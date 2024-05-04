<%
session.setAttribute("centerId", request.getParameter("centerId")); 
%>
<html>
 <head>
  <title>Center Upload Page</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
 </head>
 <body>
  <div>
   <form action="UploadServlet" method="post" enctype="multipart/form-data" >
    <table border="0" align="center">
     <thead>
      <tr>
       <th colspan="2">Center Upload Image Form</th>

      </tr>
     </thead>
     <tbody>
      <tr>
       <td>Select Image: </td>
       
       <td><input type="file" name="centerImage" /></td>
      </tr>
      <tr>
       <td><a href="center_list.jsp" >Back</a></td>
       <td><input type="submit" value="Upload" /></td>
      </tr>
     </tbody>
    </table>    
   </form>
  </div>
 </body>
</html>
