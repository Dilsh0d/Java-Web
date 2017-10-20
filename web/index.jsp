<%--
  Created by IntelliJ IDEA.
  User: dilsh0d
  Date: 06.10.2017
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login form</title>

    <!-- Bootstrap core CSS -->
    <link href="/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/css/singin.css" rel="stylesheet">

</head>

<body>

<div class="container">

    <form class="form-signin" action="/login" method="post">
        <h2 class="form-signin-heading">Systemaga kiring</h2>
        <label for="inputEmail" class="sr-only">Login</label>
        <input type="email" id="inputEmail" name="login" class="form-control" placeholder="Loginingizni kiriting" required autofocus>
        <label for="inputPassword" class="sr-only">Parol</label>
        <input type="password" id="inputPassword" name="password2" class="form-control" placeholder="Parolni kiriting" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Eslab qolish
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Kirish</button>
    </form>

</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/assets/js/jquery-3.2.1.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
</body>
</html>