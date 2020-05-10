<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User</title>
    <style>
        table {
            width:50%;
        }
        table, th, td {
            border: 2px solid MediumSlateBlue;
            border-collapse: collapse;
        }
        th, td {
            padding: 15px;
            text-align: left;
        }
        table#t01 tr:nth-child(even) {
            background-color: #eee;
            color: SaddleBrown;
        }
        table#t01 tr:nth-child(odd) {
            background-color: #fff;
            color: SaddleBrown;
        }
        table#t01 th {
            background-color: MediumSlateBlue;
            color: white;
        }
    </style>
</head>
<body>
<h2>Здравствуй дорогой друг!</h2>
<table id="t01">
    <tr>
        <th>User</th>
        <th>ID</th>
        <th>Name</th>
        <th>Login</th>
        <th>Password</th>
    </tr>
    <tr>
        <td>
            <c:out value="${role}"/>
        </td>
        <td>
            <c:out value="${id}"/>
        </td>
        <td>
            <c:out value="${name}"/>
        </td>
        <td>
            <c:out value="${login}"/>
        </td>
        <td>
            <c:out value="${pass}"/>
        </td>
    </tr>
</table>
<c:out value="${roleUser}"></c:out>
</body>
</html>
