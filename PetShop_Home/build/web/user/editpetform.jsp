<%-- 
    Document   : editpetform
    Created on : Jul 11, 2019, 9:35:14 PM
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
        <div class="container">
            <h1>Add Pet</h1>
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
                                        <c:url value="/PetShop/MainController" var="EditLink">
                                            <c:param name="action" value="Edit"/>
                                            <c:param name="id" value="${sessionScope.USERLOGIN}"/>
                                        </c:url>
                                        <a href="${EditLink}">Your Profile</a>
                                    </h4>
                                </div>
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <c:url value="/PetShop/MainController" var="PSLink">
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
                                            <c:param name="id" value="${requestScope.DTO.userid}"/>
                                        </c:url>
                                        <a href="${BillLink}">List Bill</a>
                                    </h4>
                                </div>
                            </div>
                        </div><!--/category-products-->
                    </div>
                </div>

                <div class="col-md-9 personal-info">
                    <h3>Pet Form</h3>

                    <form action="/PetShop/MainController" method="POST" class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-lg-3 control-label">PetName:</label>
                            <div class="col-lg-8">
                                <input class="form-control" type="text" value="${requestScope.DTO.petname}" name="txtPetName">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-3 control-label">PetType:</label>
                            <div class="col-lg-8">
                                <select name="type" class="form-control">
                                    <option value="1" <c:if test="${requestScope.DTO.type == 1}">selected</c:if>>Dog</option>
                                    <option value="2" <c:if test="${requestScope.DTO.type == 2}">selected</c:if>>Cat</option>
                                    </select>
                                </div>
                            </div>


                            <div class="form-group save">
                                <label class="col-md-3 control-label"></label>
                                <div class="col-md-8">
                                    <input type="submit" name="action" class="btn btn-primary" value="UpdatePet">
                                    <input type="hidden" name="id" value="${param.id}"/>
                                <input type="hidden" name="idPet" value="${requestScope.DTO.petid}"/>
                                <input type="reset" class="btn btn-default" value="Cancel">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <%@include file="footer.jsp" %>
    </body>
</html>
