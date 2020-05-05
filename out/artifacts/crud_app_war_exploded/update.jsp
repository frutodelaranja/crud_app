<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>update jsp</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="w3-center w3-light-grey">

<div class="w3-container w3-blue-grey w3-opacity w3-left-align">
    <h1>Java PP</h1>
</div>

<div class="w3-center w3-container w3-padding">

    <c:set  var="user" value="${userName}"/>
    <c:set  var="idOld" value="${id}"/>
    <c:set  var="nameOld" value="${name}"/>
    <c:set  var="mailOld" value="${mail}"/>
    <c:set  var="passOld" value="${pass}"/>
    <c:if test="${ user != null}">
        <div class="w3-panel w3-green w3-display-container w3-card-4 w3-round">
            <span onclick="this.parentElement.style.display='none'" class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey">×</span>
            <h5>User ${user} updated!</h5>
        </div>
    </c:if>
    <c:if test="${userName == null}">
        <div class="w3-panel w3-red w3-display-container w3-card-4 w3-round">
            <span onclick="this.parentElement.style.display='none'" class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey">×</span>
            <h5>"User not updated!"</h5>
        </div>
    </c:if>
    <div class="w3-row">
        <div class="w3-col  w3-container" style="width:25%"></div>
        <div class="w3-col  w3-container" style="width:50%">
            <form class="w3-center w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin" method="post">
                <h2 class="w3-center">Изменить Чебурашку</h2>
                <div class="w3-row w3-section">
                    <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-key"></i></div>
                    <div class="w3-rest">
                        <input type="number" name="id" value="${idOld}" placeholder="ID" class="w3-input w3-animate-input w3-border w3-round"><br />
                    </div>
                </div>
                <div class="w3-row w3-section">
                    <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user-o"></i></div>
                    <div class="w3-rest">
                        <input  type="text" name="name" value="${nameOld}" placeholder="Name" class="w3-input w3-border w3-round">
                    </div>
                </div>
                <div class="w3-row w3-section">
                    <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-envelope-o"></i></div>
                    <div class="w3-rest">
                        <input type="text" name="mail" value="${mailOld}" placeholder="Email" class="w3-input w3-border w3-round">
                    </div>
                </div>
                <div class="w3-row w3-section">
                    <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-lock"></i></div>
                    <div class="w3-rest">
                        <input type="password" name="pass" value="${passOld}" placeholder="Password" class="w3-input w3-border w3-round" >
                    </div>
                </div>

                <button type="submit" class="w3-btn w3-blue w3-round w3-margin-bottom">Submit</button>
            </form>
        </div>
        <div class="w3-col  w3-container" style="width:25%"></div>
    </div>
    <div class="w3-container w3-center">

    </div>
</div>
<div class="w3-container w3-center">
    <div class="w3-bar w3-padding-large w3-padding-24">
        <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/'">Home <i class='fa fa-home'></i></button>
    </div>
</div>
</body>
</html>