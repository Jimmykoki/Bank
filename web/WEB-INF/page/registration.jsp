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
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ryan Bank signup page</title>
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
                            <h2>Register</h2>
                            <p>Enter your username and password to register</p>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="register" method="post" class="login-form">
                            <p class="alert-danger d-block">
                                ${error}
                            </p>
                            <p class="alert-danger d-block">
                                ${directError}
                            </p>
                            <div class="form-group">
                                <p class="alert-danger d-block">
                                    ${uerror}
                                </p>
                                <label class="sr-only" for="form-username">Username</label>
                                <input type="text" name="username" placeholder="Username" class="form-username form-control" id="form-username" required="required">
                            </div>
                            <div class="form-group">
                                <p class="alert-danger d-block">
                                    ${perror}
                                </p>
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="password" name="password" placeholder="Password" class="form-password form-control" id="form-password" required="required">
                            </div>
                            <div class="form-group">
                                <p class="alert-danger d-block">
                                    ${derror}
                                </p>
                                <label class="sr-only" for="form-deposit">Initial Deposit</label>
                                <input type="text" name="deposit" placeholder="Deposit" class="form-password form-control" id="form-deposit" required="required">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn">Register!</button>
                            </div>
                            <div class="mt-5 text-center">
                                By clicking Register you agree to our <a href="link?term=https://github.com/Jimmykoki/Bank"> Terms of Use</a>.
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
