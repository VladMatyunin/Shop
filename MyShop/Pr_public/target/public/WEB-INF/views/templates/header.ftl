<head>
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
    <meta charset="utf-8">
    <title>Jumbotron Template for Bootstrap</title>
    <link rel="stylesheet" href="/resources/styles/style.css" content="html/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<div class="container">
    <div class="row">

        <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
            <div class ="col-lg-10">
                <ul class="nav navbar-nav">
                    <li class="nav-item">
                        <a href="#" class="logo" > <span class="glyphicon glyphicon-certificate" aria-hidden="true"></span> Share! </a>
                    </li>

                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contact</a>
                    </li>
                </ul>
            </div>
            <div class = "col-lg-2"> <@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
                <a  href="/auth" style="color: #E3E3E3">Login</a> |
                <a  href="/reg" style="color: #E3E3E3">Registration</a>
            </@sec.authorize>
            <#-- Если уже авторизован, то ссылки в личный кабинет и на выход -->
            <@sec.authorize access="isAuthenticated()">
                <a class="login" href="/cabinet">
                    <i class="user"> </i>
                    <li class="user_desc">
                    <#-- principal - это фактически экземпляр объекта MyUserDetail -->
                        <@sec.authentication property="principal.username"/>
                    </li>
                </a>
                <a class="login" href="/logout">
                    <li class="user_desc" style="padding-left: 10px; color: #E3E3E3"">Logout</li>
                </a>
            </@sec.authorize>
            </div>
        </nav>
    </div>
</div>
<script src="/resources/js/jquery-1.11.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
        integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
