<%@page import="com.ewaste.dao.EwasteCenterDaoImple"%>
<%@page import="com.ewaste.dao.EwasteCenterDao"%>
<jsp:useBean id="ewasteCenter" class="com.ewaste.dto.EwasteCenter"></jsp:useBean>
<jsp:setProperty name="ewasteCenter" property="*"></jsp:setProperty>
<%
 EwasteCenterDao edao = new EwasteCenterDaoImple();
 edao.addCenter(ewasteCenter);
 response.sendRedirect("center_add_form.jsp");
%>
