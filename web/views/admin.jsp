<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<script src='https://kit.fontawesome.com/a076d05399.js'></script>--%>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="w3-center w3-light-grey">

<div class="w3-container w3-blue-grey w3-opacity w3-left-align">
    <h1>Java PP</h1>
</div>
</br>
<div class="w3-container">
    <div class="w3-responsive">
        <h3 class="w3-center">Зыс из эээ Чебурнет. Список чебурашек, способных быть удалёнными и изменёнными</h3></br>
        <table class="w3-table  w3-striped w3-centered w3-bordered w3-border w3-hoverable ">
            <tr class="w3-grey">
                <th>User</th>
                <th>ID</th>
                <th>Name</th>
                <th>Login</th>
                <th>Pass</th>
                <th>Portal</th>
                <th>Portal</th>
            </tr>
            <c:set var="User" value="user"/>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>
                        <c:out value="${user.getRole()}"/>
                    </td>
                    <td>
                        <c:out value="${user.getId()}"/>
                    </td>
                    <td>
                        <c:out value="${user.getName()}"/>
                    </td>
                    <td>
                        <c:out value="${user.getLogin()}"/>
                    </td>
                    <td>
                        <c:out value="${user.getPassword()}"/>
                    </td>

                    <td>
                        <form action="/admin/update" method="get">

                            <div>
                                <button type="submit" class="w3-btn w3-hover-amber w3-round" onclick=input name="id"
                                        value="${user.getId()}">Update <i class="fa fa-refresh"></i></button>
                            </div>

                        </form>

                    </td>
                    <td>
                        <form action="/admin/delete" method="post">
                            <div>
                                <button type="submit" class="w3-btn w3-hover-pink w3-round" onclick=input name="id"
                                        value="${user.getId()}">Delete <i class='fa fa-recycle'></i></button>
                            </div>

                        </form>
                    </td>
                </tr>
            </c:forEach>

        </table>

    </div>
</div>
<br>
<br>

<div class="w3-row">
    <div class="w3-col  w3-container" style="width:30%"></div>
    <div class="w3-col  w3-container" style="width:40%">
        <form action="/admin" method="post" class="w3-center w3-container w3-card-4 w3-light-grey w3-text-green w3-margin">
            <h2 class="w3-center">Добавить Чебурашку к Чебурнету</h2>
            <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user-o"></i></div>
            <div class="w3-rest">
                <input type="text" name="name" placeholder="Name" class="w3-input w3-border w3-round"><br/>
            </div>
            <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-envelope-o"></i></div>
            <div class="w3-rest">
                <input type="text" name="mail" placeholder="Email" class="w3-input w3-border w3-round"><br/>
            </div>
            <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-lock"></i></div>
            <div class="w3-rest">
                <input type="password" name="pass" placeholder="Password" class="w3-input w3-border w3-round"><br/>
            </div>
            <button type="submit" class="w3-btn w3-green w3-round w3-margin-bottom">Add <i
                    class='fa fa-user-plus'></i></button>
        </form>
    </div>
</div>

<div class="w3-container w3-center">
    <div class="w3-bar w3-padding-large w3-padding-24">
        <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/'">Home <i
                class='fa fa-home'></i></button>
    </div>
</div>
</body>
</html>
