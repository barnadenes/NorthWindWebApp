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
    <h3>Task 4</h3>
    <form action="task4" method="POST">
        <p>Enter a company name: </p>
        <input type="text" name="company">
        <br>
        <input type="submit" value="Search">
    </form>
     <table>
         <tr>
             <th>Company</th>
             <th>Orders</th>
         </tr>
         <c:forEach var="task4" items="${output}">
         <tr>
             <td>${task4.company}</td>
             <td>${task4.order}</td>
         </tr>
         </c:forEach>
     </table>
</body>
</html>
