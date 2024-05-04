
<%@page import="com.ewaste.dao.UserDaoImple"%>
<%@page import="com.ewaste.dao.UserDao"%>
<jsp:useBean id="user" class="com.ewaste.dto.User" scope="session"></jsp:useBean>
<jsp:setProperty name="user" property="*"></jsp:setProperty>
<%
 UserDao dao = new UserDaoImple();
 String userRole = dao.login(user);
 if(userRole==null){
  response.sendRedirect("login_form.jsp");
 }else{
  if(userRole.equals("admin")){
   response.sendRedirect("admin_home.jsp");
  }else{
   response.sendRedirect("user_home.jsp");
  }
 }
%>