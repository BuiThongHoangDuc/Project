<%-- 
    Document   : pettable
    Created on : Jul 11, 2019, 3:29:32 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <!--	EditProfile-->

        <div class="container">
            <h1>Pet Management</h1>
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
                                            <c:param name="id" value="${param.id}"/>
                                        </c:url>
                                        <a href="${PSLink}">PetManagement</a>
                                    </h4>
                                </div>
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <c:url value="/MainController" var="BillLink">
                                            <c:param name="action" value="BillOnlyUser"/>
                                            <c:param name="id" value="${param.id}"/>
                                        </c:url>
                                        <a href="${BillLink}">List Bill</a>
                                    </h4>
                                </div>
                            </div>
                        </div><!--/category-products-->
                    </div>
                </div>

                <div class="col-md-9 personal-info">

                    <div class="card">
                        <form>
                            <c:url value="/user/petaddform.jsp" var="AddLink">
                                <c:param name="id" value="${param.id}"/>
                            </c:url>
                            <a class="col-md-2 btn" href="${AddLink}"><button type="button" class="btn btn-primary">Add New Pet</button></a>
                            <div class="col-md-10 btn">
                                <div class="input-group">
                                    <form action="/MainController" method="POST">
                                        <div class="input-group-btn">
                                            <input type="hidden" name="id" value="${param.id}"/>
                                            <button type="submit" name="action" value="PPersonSearch"  class="btn btn-primary">
                                                <i class="fa fa-search"></i> Search
                                            </button>
                                        </div>
                                        <input type="text" name="txtSearch" id="input1-group2" name="input1-group2" placeholder="Name" class="form-control">
                                    </form>
                                </div>
                            </div>
                        </form>  

                        <div class="card-body">
                            <c:if test="${requestScope.listPet!=null}">
                                <c:if test="${not empty requestScope.listPet}" var="isList">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>No</th>
                                                <th>Name</th>
                                                <th>Type</th>
                                                <th>Management</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${requestScope.listPet}" var="ListPet" varStatus="counter">
                                                <tr>
                                                    <td>${counter.count}</td>
                                                    <td>${ListPet.petname}</td>
                                                    <c:if test="${ListPet.type == 1}" var="type">
                                                        <td>Dog</td>
                                                    </c:if>
                                                    <c:if test="${!type}">
                                                        <td>Cat</td>
                                                    </c:if>
                                                    <td>
                                                        <c:url value="/MainController" var="PEdit">
                                                            <c:param name="action" value="PetEdit"/>
                                                            <c:param name="id" value="${param.id}"/>
                                                            <c:param name="idPet" value="${ListPet.petid}"/>
                                                        </c:url>
                                                        <a class="col-md-3 btn btn-outline-primary" href="${PEdit}">View</a>

                                                        <form action="/PetShop/MainController" method="POST">
                                                            <input type="hidden" name="id" value="${param.id}"/>
                                                            <input type="hidden" name="idPet" value="${ListPet.petid}"/>
                                                            <input type="submit" class="col-md-3 btn btn-danger" name="action" value="DeletePet"/>
                                                        </form>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>                                                             
                                </c:if>
                                <c:if test="${!isList}">
                                    You Don't Have A Pet
                                </c:if>
                            </c:if>
                        </div>

                    </div>
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
