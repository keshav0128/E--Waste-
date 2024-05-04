<%@page import="com.ewaste.dto.User"%>
<%@page import="com.ewaste.dto.EwasteCenter"%>
<%@page import="java.util.List"%>
<%@page import="com.ewaste.dao.EwasteCenterDaoImple"%>
<%@page import="com.ewaste.dao.EwasteCenterDao"%>





<%
 User user = (User)session.getAttribute("user");
 if(user==null || user.getEmailId()==null){
  response.sendRedirect("logout.jsp"); 
 }else{
  
 
 EwasteCenterDao edao = new EwasteCenterDaoImple();
 List<EwasteCenter> elist = edao.selectAll();
 %>


<html>
 <head>
  <title>Center List Page</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
   .even{
    background-color: background;
    text-align: center;
   }
   .odd{
    background-color: blueviolet;
    text-align: center;
   }
  </style>
 </head>
 <body>
  <div>
   <jsp:include page="cache_control_page.jsp"></jsp:include>
   <form action="center_add.jsp" method="post">
    <table border="1" align="center">
     <thead>
      <tr>
       <th colspan="6">Center List</th>
      </tr>
      <tr>
       <th>Center Name</th>
       <th>Center Address</th>
       <th>Contact Number</th>
       <th>Delete</th>
       <th>Update</th>
       <th>Image</th>
      </tr>
     </thead>
     <tbody>
      
      <%
        int i=0; 
        for(EwasteCenter ec : elist){
         i++;
       %>
       <tr class='<%=(i%2==0)?"even":"odd"%>' >
       
       <td><%=ec.getCenterName()%></td>
       <td><%=ec.getAddress()%></td>
       <td><%=ec.getContactNo()%></td>
       <td><a href="center_delete.jsp?centerId=<%=ec.getCenterId()%>" >delete</a></td>
       <td><a href="center_update_form.jsp?centerId=<%=ec.getCenterId()%>" >update</a></td>
       <td><a href="center_upload_form.jsp?centerId=<%=ec.getCenterId()%>" ><img src="<%=ec.getImageUrl()%>" width="100" height="100" alt="No Image" /></a></td>
       </tr>
       
       <% } %>
       <tr>
        <td style="text-align: right" colspan="6"><a href="admin_home.jsp" >Back</a></td>
      </tr>
      </tbody>
    </table>    
   </form>
  </div>
 </body>
</html>
<%
 }
%>