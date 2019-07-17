<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NorthwindWebApp</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <jsp:include page="index.html"/>
    <h3>Task 5</h3>
    <form action="task5" method="POST">
        <p>Enter a company name: </p>
        <input type="text" name="company">
        <br>
        <input type="submit" value="Search">
    </form>
     <table>
         <tr>
             <th>Company</th>
             <th>Product</th>
             <th>Price</th>
         </tr>
         <c:forEach var="task5" items="${output}">
         <tr>
             <td>${task5.company}</td>
             <td>${task5.product}</td>
             <td>${task5.price}</td>
         </tr>
         </c:forEach>
     </table>
</body>
</html>
