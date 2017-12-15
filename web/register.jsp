<%--
  Created by IntelliJ IDEA.
  User: dilsh0d
  Date: 10/21/17
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
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
    <link href="/assets/css/singup.css" rel="stylesheet">

</head>

<body>

<div class="container">
    <h1 class="well">Register form</h1>
    <div class="col-lg-12 well">
        <div class="row">
            <form action="/register" method="post">
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <label>Ismi</label>
                            <input type="text" name="firstName" placeholder="Ismini kiriting" class="form-control">
                        </div>
                        <div class="col-sm-6 form-group">
                            <label>Familiyangiz</label>
                            <input type="text" name="lastName" placeholder="Familiyangizni kiriting" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="text" name="username" placeholder="Emailni kiriting" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Parol</label>
                        <input type="password" name="password1" placeholder="Parolni kiriting" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Takroriy parol</label>
                        <input type="password" name="password2" placeholder="Takroriy parolni kiriting" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>Mantiqiy amal javobini kiriting <%=request.getAttribute("question")%></label>
                        <input type="text" name="answer" placeholder="Javobni kiriting" class="form-control">
                    </div>

                    <button type="submit" class="btn btn-lg btn-info">Ok</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/assets/js/jquery-3.2.1.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
</body>
</html>