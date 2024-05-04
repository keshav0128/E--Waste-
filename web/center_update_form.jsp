<%@page import="com.ewaste.dto.EwasteCenter"%>
<%@page import="com.ewaste.dao.EwasteCenterDaoImple"%>
<%@page import="com.ewaste.dao.EwasteCenterDao"%>
<%
String p1 = request.getParameter("centerId");
int centerId = Integer.parseInt(p1);
EwasteCenterDao edao = new EwasteCenterDaoImple();
EwasteCenter ec = edao.selectById(centerId);
%>

<html>
 <head>
  <title>Center Update Page</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
 </head>
 <body>
  <div>
   <form action="center_update.jsp" method="post">
    <table border="0" align="center">
     <thead>
      <tr>
       <th colspan="2">Center Update Form</th>

      </tr>
     </thead>
     <tbody>
      <tr>
       <td>e-Waste Center Name: </td>
       <td>
        <input type="hidden" name="centerId" value="<%=ec.getCenterId()%>" />
        <input type="text" name="centerName" value="<%=ec.getCenterName()%>" />
       </td>
      </tr>
      <tr>
       <td>Address: </td>
       <td>
        <textarea name="address" ><%=ec.getAddress()%></textarea>
       </td>
      </tr>
      <tr>
       <td>Contact No.: </td>
       <td><input type="text" name="contactNo" value="<%=ec.getContactNo()%>" /></td>
      </tr>
      <tr>
       <td><a href="center_list.jsp" >Back</a></td>
       <td><input type="submit" value="Update" /></td>
      </tr>
     </tbody>
    </table>    
   </form>
  </div>
 </body>
</html>
