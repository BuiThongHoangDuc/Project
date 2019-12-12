<%-- 
    Document   : EditProfile
    Created on : Jun 30, 2019, 1:33:41 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Login | E-Shopper</title>

    </head><!--/head-->

    <body>
        <%@include file="header.jsp" %>
        <!--	EditProfile-->


        <div class="container">
            <h1>Edit Profile</h1>
            <hr>
            <div class="row">
                <!-- left column Menu -->
                <div class="col-md-3">
                    <div class="left-sidebar">
                        <h2>User Management</h2>
                        <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <c:url value="/MainController" var="EditLink">
                                            <c:param name="action" value="Edit"/>
                                            <c:param name="id" value="${sessionScope.USERLOGIN}"/>
                                        </c:url>
                                        <a href="${EditLink}">Your Profile</a>
                                    </h4>
                                </div>
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <c:url value="/MainController" var="PSLink">
                                            <c:param name="action" value="SearchPet"/>
                                            <c:param name="id" value="${requestScope.DTO.userid}"/>
                                        </c:url>
                                        <a href="${PSLink}">PetManagement</a>
                                    </h4>
                                </div>
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <c:url value="/MainController" var="BillLink">
                                            <c:param name="action" value="BillOnlyUser"/>
                                            <c:param name="id" value="${requestScope.DTO.userid}"/>
                                        </c:url>
                                        <a href="${BillLink}">List Bill</a>
                                    </h4>
                                </div>
                            </div>
                        </div><!--/category-products-->
                    </div>
                </div>

                <!-- edit form column -->
                <div class="col-md-9 personal-info">
                    <h3>Personal info</h3>

                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-lg-3 control-label">UserName:</label>
                            <div class="col-lg-8">
                                <input class="form-control" type="text" name="username" value="${requestScope.DTO.username}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">UserFullName:</label>
                            <div class="col-lg-8">
                                <input class="form-control" type="text" name="fullname" value="${requestScope.DTO.fullname}" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">UserEmail:</label>
                            <div class="col-lg-8">
                                <input class="form-control" type="email" name="email" value="${requestScope.DTO.useremail}" pattern="[A-Za-z0-9._%+-]{3,}@[a-zA-Z]{3,}([.]{1}[a-zA-Z]{2,}|[.]{1}[a-zA-Z]{2,}[.]{1}[a-zA-Z]{2,})"  title="ex@abc.xyz" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">UserAdress:</label>
                            <div class="col-lg-8">
                                <input class="form-control" type="text" name="adress" value="${requestScope.DTO.useradress}" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">UserPhoneNum:</label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" name="phonenumber" value="${requestScope.DTO.userphonenum}" pattern="^\d{10}$" required> 
                            </div>
                        </div>

                        <div class="form-group save">
                            <label class="col-md-3 control-label"></label>
                            <div class="col-md-8">
                                <input type="submit" name="action" class="btn btn-primary" value="Update">
                                <input type="hidden" name="id" value="${requestScope.DTO.username}"/>
                                <input type="hidden" name="role" value="${requestScope.DTO.userrole}"/>
                                <input type="reset" class="btn btn-default" value="Cancel">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>




        <!--===============================================================================================-->
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/daterangepicker/moment.min.js"></script>
        <script src="vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>

        <!--	EditProfile-->

        <%@include file="footer.jsp" %>
    </body>
</html>
