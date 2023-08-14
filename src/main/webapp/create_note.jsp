<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@include file="all_js_css.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Note</title>
</head>
<body>




<div class="container ">
<div class="row">
<div class="col-md-10 offset-md-1">
<!-- Start of nav bar   -->
<%@include file="mynavbar.jsp" %>

<!-- End of nav bar -->
<h2  class="mt-2">Enter details to create Note</h2>
<form  action="CreateNoteServlet" method="POST">
  <div class="form-group mt-4">
    <label for="exampleInputEmail1">Title</label>
    <input name="note_title" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Title">
<!--     <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
 -->  </div>
  <div class="form-group">
    <label for="notecontent">Content</label>
    
    <textarea name="note_content" rows="5" cols="50" placeholder="Enter content" class="form-control" id="notecontent"></textarea>
    </div>
  
  <button type="submit" class="btn my-bg-theme">Submit</button>
</form>

</div>
</div>

</div>





</body>
</html>