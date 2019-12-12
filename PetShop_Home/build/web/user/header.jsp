<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home | E-Shopper</title>
        <link href="/PetShop/css/bootstrap.min.css" rel="stylesheet">
        <link href="/PetShop/css/font-awesome.min.css" rel="stylesheet">
        <link href="/PetShop/css/prettyPhoto.css" rel="stylesheet">
        <link href="/PetShop/css/price-range.css" rel="stylesheet">
        <link href="/PetShop/css/animate.css" rel="stylesheet">
        <link href="/PetShop/css/main.css" rel="stylesheet">
        <link href="/PetShop/css/responsive.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="/PetShop/images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/PetShop/images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/PetShop/images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/PetShop/images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="/PetShop/images/ico/apple-touch-icon-57-precomposed.png">
    </head><!--/head-->

    <body>
        <header id="header"><!--header-->

            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 clearfix">
                            <div class="logo pull-left">
                                <a href="/PetShop/ShowProductController"><img src="/PetShop/images/home/logo.png" alt="" /></a>
                            </div>

                        </div>
                        <div class="col-md-8 clearfix">
                            <div class="shop-menu clearfix pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="/PetShop/cart.jsp"><i class="fa fa-shopping-cart"></i> Cart</a></li>

                                    <c:if test="${not empty sessionScope.ROLE}" var="isLogin">
                                        <li class="mainmenu pull-left nav navbar-nav collapse navbar-collapse dropdown">
                                            <a href="#"><i class="fa fa-user"></i>${sessionScope.USERLOGIN}</a>
                                            <ul role="menu" class="sub-menu">
                                                <c:url value="/MainController" var="EditLink">
                                                    <c:param name="action" value="Edit"/>
                                                    <c:param name="id" value="${sessionScope.USERLOGIN}"/>
                                                </c:url>
                                                <li><a href="${EditLink}">View My Profile</a></li>
                                                    <c:url value="/MainController" var="LogoutLink">
                                                        <c:param name="action" value="Logout"/>
                                                    </c:url>
                                                <li><a href="${LogoutLink}">Logout</a></li> 
                                            </ul>
                                        </li>                                                                               
                                    </c:if>

                                    <c:if test="${!isLogin}">
                                        <li><a href="/PetShop/login.jsp"><i class="fa fa-lock"></i> Login</a></li>
                                        </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->

            <div class="header-bottom"><!--header-bottom-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-9">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div class="mainmenu pull-left">
                                <ul class="nav navbar-nav collapse navbar-collapse">
                                    <li><a href="/PetShop/ShowProductController" class="active">Home</a></li>
                                    <li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                        <ul role="menu" class="sub-menu">
                                            <li><a href="/PetShop/ShowProductController">Products</a></li>
                                            <li><a href="/PetShop/cart.jsp">Cart</a></li>
                                                <c:if test="${not empty sessionScope.ROLE}" var="isLogin">
                                                </c:if>

                                            <c:if test="${!isLogin}">
                                                <li><a href="/PetShop/login.jsp">Login</a></li> 
                                                </c:if>

                                        </ul>
                                    </li> 

                                    <li>
                                        <c:url value="/ShowServiceController" var="ShowService">
                                            <c:param name="txtSearch" value=""/>
                                        </c:url>
                                        <a href="${ShowService}">Service</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-3">
                                <form action="MainController" method="POST">
                                    <div class="input-group-btn">

                                        <button type="submit" name="action" value="FindProduct"  class="btn btn-primary">
                                            <i class="fa fa-search"></i> Search
                                        </button>
                                    </div>
                                    <input type="text" name="txtSearch" id="input1-group2" name="input1-group2" placeholder="ProductName" class="form-control">
                                </form>
                        </div>
                    </div>
                </div>
            </div><!--/header-bottom-->
        </header><!--/header-->


