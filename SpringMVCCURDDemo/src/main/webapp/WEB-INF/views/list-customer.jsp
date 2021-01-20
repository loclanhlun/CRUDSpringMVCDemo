
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 1/20/2021
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <%@ page isELIgnored="false"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Hover Rows</h2>
    <p>The .table-hover class enables a hover state on table rows:</p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var ="item" items = "${listCustomer}" >
            <!-- construct an "update" link with customer id -->
            <c:url var="updateLink" value="/customer/updateForm">
            <c:param name="customerId" value="${tempCustomer.id}" />
            </c:url>

            <!-- construct an "delete" link with customer id -->
            <c:url var="deleteLink" value="/customer/delete">
                <c:param name="customerId" value="${item.id}" />
            </c:url>



        <tr>
            <td>${item.firstName}</td>
            <td>${item.LastName}</td>
            <td>${item.email}</td>
            <td>
                <!-- display the update link --> <a href="${updateLink}">Update</a>
                | <a href="${deleteLink}"
                     onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
            </td>
        </tr>

        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

