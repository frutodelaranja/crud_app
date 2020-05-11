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


    <div style="background-color:MediumSlateBlue" class="w3-panel  w3-display-container w3-card-4 w3-round">
        <h2 style="color:white">Добро пожаловать в Чебурнет!</h2>
    </div>

    <div class="w3-row">
        <div class="w3-col  w3-container" style="width:25%"></div>
        <div class="w3-col  w3-container" style="width:50%">
            <form action="/admin" class="w3-center w3-container w3-card-4 w3-light-grey w3-margin" method="post">
                <h2 style="color:MediumSlateBlue" class="w3-center">Захади!</h2>
                <div class="w3-row w3-section">
                    <div class="w3-col" style="width:50px"><i style="color:MediumSlateBlue" class="w3-xxlarge fa fa-user-o"></i></div>
                    <div class="w3-rest">
                        <input style="color:SaddleBrown" type="text" name="login" placeholder="Email" class="w3-input w3-border w3-round">
                    </div>
                </div>
                <div class="w3-row w3-section">
                    <div class="w3-col" style="width:50px"><i style="color:MediumSlateBlue" class="w3-xxlarge fa fa-lock"></i></div>
                    <div class="w3-rest">
                        <input style="color:SaddleBrown" type="password" name="pass" placeholder="Password" class="w3-input w3-border w3-round" >
                    </div>
                </div>

                <button style="background-color:Peru; color: white" type="submit" class="w3-btn w3-round w3-margin-bottom">Sign in</button>
            </form>
        </div>
        <div class="w3-col  w3-container" style="width:25%"></div>
    </div>

</div>

</body>
</html>
