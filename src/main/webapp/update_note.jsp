<%@page import="com.notes.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.notes.entities.Note" %>
<%@page import="com.notes.helper.FactoryProvider" %>
<%@page import="org.hibernate.*" %>
<%@page import="jakarta.persistence.Query" %>
<%@page import="java.util.*" %>
<%@include file="all_js_css.jsp" %>
<% int note_id = Integer.parseInt(request.getParameter("note_id").trim());

Session s = FactoryProvider.getSessionFactory().openSession();
Note note = s.get(Note.class, note_id);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update note: <%=note.getId() %></title>
</head>
<body>
<!-- Start of nav bar   -->

<div class="container ">
<div class="row">
<div class="col-md-10 offset-md-1">
<%@include file="mynavbar.jsp" %>


<h2  class="mt-2"> Update your  Note</h2>
<form  action="UpdateNoteServlet" method="POST">

<input name="note_id_hidden" value="<%=note.getId()%>" type="hidden" />

  <div class="form-group mt-4">
    <label for="exampleInputEmail1">Title</label>
    <input name="note_title" type="text" class="form-control" id="exampleInputEmail1" 
            aria-describedby="emailHelp" 
             placeholder="Enter Title" 
              value="<%=note.getTitle() %>"
              >

 </div>
  <div class="form-group">
    <label for="notecontent">Content</label>
    
    <textarea name="note_content" rows="5" cols="50" placeholder="Enter content" class="form-control" id="notecontent"><%=note.getContent() %></textarea>
    </div>
  
  <button type="submit" class="btn btn-success">Save</button>
</form>

</div>
</div>
</div>

</body>
</html>