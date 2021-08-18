<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
        xmlns:ui="http://java.sun.com/jsf/facelets"
        xmlns:h ="http://java.sun.com/jsf/html"
        xmlns:c ="http://java.sun.com/jsf/core">
<html>
  <h:head>
    
  </h:head>

  <h:body>
    <!-- taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" -->
    <jsp:useBean id ="usuarioBean" class="com.jaguaresdeveloper.UserBean"></jsp:useBean>
      <% 
      String correo = request.getParameter("correo");
      String password = request.getParameter("pass");
      %>
      <jsp:setProperty name="usuarioBean" property ="usuario"/>
      <jsp:getProperty name="usuarioBean" property ="usuario"/>
    
  	

  </h:body>
</html>