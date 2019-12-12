<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en">
    <!--<![endif]-->

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Sufee Admin - HTML5 Admin Template</title>
        <meta name="description" content="Sufee Admin - HTML5 Admin Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="apple-icon.png">
        <link rel="shortcut icon" href="favicon.ico">


        <link rel="stylesheet" href="/PetShop/vendors/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="/PetShop/vendors/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="/PetShop/vendors/themify-icons/css/themify-icons.css">
        <link rel="stylesheet" href="/PetShop/vendors/flag-icon-css/css/flag-icon.min.css">
        <link rel="stylesheet" href="/PetShop/vendors/selectFX/css/cs-skin-elastic.css">
        <link rel="stylesheet" href="/PetShop/vendors/datatables.net-bs4/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="/PetShop/vendors/datatables.net-buttons-bs4/css/buttons.bootstrap4.min.css">

        <link rel="stylesheet" href="/PetShop/assets/css/style.css">

        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
    </head>

    <body>
        <!-- Left Panel -->

        <aside id="left-panel" class="left-panel">
            <nav class="navbar navbar-expand-sm navbar-default">

                <div class="navbar-header">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand" href="/PetShop/admin/admin.jsp"><img src="/PetShop/images/admin/logo3.png" alt="Logo"></a>
                    <a class="navbar-brand hidden" href="/PetShop/admin/admin.jsp"><img src="/PetShop/images/admin/logo.png" alt="Logo"></a>
                </div>

                <div id="main-menu" class="main-menu collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <h3 class="menu-title">Management</h3><!-- /.menu-title -->
                        <li class="menu-item-has-children active dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Tables</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="fa fa-table"></i>
                                    <c:url value="MainController" var="userLink">
                                        <c:param name="action" value="Search"/>
                                        <c:param name="txtSearch" value=""/>
                                    </c:url>
                                    <a href="${userLink}">User Management</a>
                                </li>
                                <li><i class="fa fa-table"></i>
                                    <c:url value="MainController" var="productLink">
                                        <c:param name="action" value="ProductSearch"/>
                                        <c:param name="txtSearch" value=""/>
                                    </c:url>
                                    <a href="${productLink}">Table Product</a>
                                </li>
                                <li><i class="fa fa-table"></i>
                                    <c:url value="MainController" var="serviceLink">
                                        <c:param name="action" value="ServiceSearch"/>
                                        <c:param name="txtSearch" value=""/>
                                    </c:url>
                                    <a href="${serviceLink}">Service Management</a>
                                </li>
                                <li><i class="fa fa-table"></i>
                                    <c:url value="MainController" var="billLink">
                                        <c:param name="action" value="BillSearch"/>
                                        <c:param name="txtSearch" value=""/>
                                    </c:url>
                                    <a href="${billLink}">Bill Management</a>
                                </li>
                            </ul>
                        </li>   
                    </ul>
                </div><!-- /.navbar-collapse -->
            </nav>
        </aside><!-- /#left-panel -->

        <!-- Left Panel -->

        <!-- Right Panel -->

        <div id="right-panel" class="right-panel">

            <!-- Header-->
            <header id="header" class="header">

                <div class="header-menu">

                    <div class="col-sm-7">
                        <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks"></i></a>
                    </div>

                    <div class="col-sm-5">
                        <div class="user-area dropdown float-right">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">	
                                ${sessionScope.USERLOGIN}
                            </a>

                            <div class="user-menu dropdown-menu">
                                <c:url value="MainController" var="EditLink">
                                    <c:param name="action" value="Edit"/>
                                    <c:param name="id" value="${sessionScope.USERLOGIN}"/>
                                </c:url>
                                <a class="nav-link" href="${EditLink}"><i class="fa fa-user"></i> My Profile</a>
                                <c:url value="MainController" var="LogoutLink">
                                    <c:param name="action" value="Logout"/>
                                </c:url>
                                <a class="nav-link" href="${LogoutLink}"><i class="fa fa-power-off"></i> Logout</a>
                            </div>
                        </div>


                    </div>
                </div>

            </header><!-- /header -->
            <!-- Header-->