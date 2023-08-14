<%@page import="com.notes.helper.FactoryProvider"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="all_js_css.jsp" %>
<%@page import="com.notes.entities.Note" %>
<%@page import="com.notes.helper.FactoryProvider" %>
<%@page import="org.hibernate.*" %>
<%@page import="jakarta.persistence.Query" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Notes</title>
</head>
<body>

<div class="container ">
<div class="row">
<div class="col-md-10 offset-md-1">

<%@include file="mynavbar.jsp" %>


<h2  class="mt-2">All Notes: </h2>
<div class="row">

<div class="col-12">
<% SessionFactory sf =  FactoryProvider.getSessionFactory(); 
     Session s = sf.openSession();
     String query = "From Note";
     Query q = s.createQuery(query);
     List<Note> allNotes = q.getResultList();  

      for(Note eachnote: allNotes)
      {
%>
<div class="card mt-3" >
  <img class="card-img-top mt-2 ml-2" style="max-width: 60px; " src="img/notesicon.png" />
  <div class="card-body">
    <h5 class="card-title"><%=eachnote.getTitle() %> </h5>

   <p class="card-text"> <%=eachnote.getContent() %>  </p>
    
   <p style="text-align: right; color: blue;"><b> Date Created: <%=eachnote.getCreateDate().toLocaleString() %></b></p>
    <a href="update_note.jsp?note_id=<%=eachnote.getId() %>" class="btn btn-primary">Update</a>
    <a href="DeleteServlet?note_id=<%=eachnote.getId() %>" class="btn btn-danger" >Delete</a>
      
  </div>

   
</div>
<% 
       }
 %>
</div>



   
   
</div>
</div>
</div>
</div>

</body>
</html>