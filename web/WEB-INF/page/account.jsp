
<%--
  Created by IntelliJ IDEA.
  User: jimmyli
  Date: 5/8/22
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ryan Bank account page</title>
    <base href="<%=basePath%>>">

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="resources/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/assets/css/form-elements.css">
    <link rel="stylesheet" href="resources/assets/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="resources/assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="resources/assets/ico/apple-touch-icon-57-precomposed.png">
</head>

<body>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>Ryan Bank</strong></h1>
                    <div class="description">
                        <p>
                            Welcome to Ryan Bank
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h2>Hello ${user}</h2>
                            <h4>${user}'s balance: <fmt:formatNumber type="number" value="${balance}" maxFractionDigits="2"/></h4>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <h3>Withdraw</h3>
                        <form role="form" action="withdraw" method="post" class="login-form">
                            <p class="alert-danger d-block">
                                ${withdrawError}
                            </p>
                            <div class="form-group">
                                <label class="sr-only" for="form-withdraw">withdraw</label>
                                <input type="text" name="withdraw" placeholder="Please enter amounts you want to withdraw" class="form-username form-control" id="form-withdraw">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn">Withdraw</button>
                            </div>
                        </form>
                        <h3>Send</h3>
                        <form role="form" action="send" method="post" class="login-form">
                            <p class="alert-danger d-block">
                                ${depositError}
                            </p>
                            <div class="form-group">
                                <label class="sr-only" for="form-send">send</label>
                                <input type="text" name="send" placeholder="Please enter amounts you want to send" class="form-username form-control" id="form-send">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn">Send</button>
                            </div>
                        </form>
                        <hr/>

                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 social-login">
                    <h3>...or logout:</h3>
                    <div class="social-login-buttons">
                        <form role="form" action="logout" method="post" class="login-form">
                            <div class="form-group">
                                <button type="submit" class="btn btn-danger">Logout</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<!-- Javascript -->
<script src="resources/assets/js/jquery-1.11.1.min.js"></script>
<script src="resources/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/assets/js/jquery.backstretch.min.js"></script>
<script src="resources/assets/js/scripts.js"></script>

<!--[if lt IE 10]>
<script src="resources/assets/js/placeholder.js"></script>
<![endif]-->

</body>

</html>

