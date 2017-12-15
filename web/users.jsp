<%@ page import="uz.java.web.app.dto.UserData" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.java.web.app.dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: dilsh0d
  Date: 06.10.2017
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Mening profilim</title>

    <!-- Bootstrap core CSS -->
    <link href="/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/css/bootstrap-theme.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/assets/css/dashboard.css" rel="stylesheet">
</head>

<body>


<%
    uz.java.web.app.dto.UserData userData = (uz.java.web.app.dto.UserData) session.getAttribute("userData");
%>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <%=userData.getFirstname()%> <%=userData.getLastname()%>
            </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout">Systemadan chiqish</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">Foydalanuvchilar <span class="sr-only">(current)</span></a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header" style="color:red">Dashboard</h1>

            <h2 class="sub-header">Ruyhat</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>E-mail</th>
                        <th>Ismi</th>
                        <th>Familiyasi</th>
                        <th>Admin</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        UserDao userDao = new UserDao();
                        List<UserData> userDataList = userDao.getUserList();

                        for(UserData data:userDataList){
                            out.print("<tr>");
                            out.print("<td>"+data.getId()+"</td>");
                            out.print("<td>"+data.getUsername()+"</td>");
                            out.print("<td>"+data.getFirstname()+"</td>");
                            out.print("<td>"+data.getLastname()+"</td>");
                            out.print("<td>"+data.isAdmin()+"</td>");
                            out.print("</tr>");
                        }
                    %>


                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/assets/js/jquery-3.2.1.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
</body>
</html>
