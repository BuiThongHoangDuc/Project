<%-- 
    Document   : viewservice
    Created on : Jul 14, 2019, 11:40:19 AM
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
        <%@include file="/user/header.jsp" %>
        <div class="container">
            <div class="animated fadeIn">
                <div class="row">

                    <div class="col-md-12">
                        <div class="card">
                            
                            <div class="card-header">
                                <h1><strong class="card-title">Please Contact Us By 090-xxxxxxx For Book Service</strong></h1>
                            </div>

                            <div class="card-body">
                                <c:if test="${requestScope.LISTSERVICE != null}">
                                    <c:if test="${not empty requestScope.LISTSERVICE}" var="isList">
                                        <table  class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Image</th>
                                                    <th>Name</th>
                                                    <th>Type</th>
                                                    <th>Price</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${requestScope.LISTSERVICE}" var="Service">
                                                    <tr>

                                                        <td><img src="/PetShop/images/home/${Service.serviceimage}"/></td>
                                                        <td>${Service.servicename}</td>
                                                        <td>
                                                            <c:if test="${Service.typeofpet == 1}">Dog</c:if>
                                                            <c:if test="${Service.typeofpet == 2}">Cat</c:if>
                                                            </td>
                                                            <td>${Service.price} VND</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </c:if>

                                    <c:if test="${!isList}">
                                        <div class="alert alert-info alert-dismissable">
                                            <a class="panel-close close" data-dismiss="alert">×</a> 
                                            <i class="fa fa-coffee"></i>
                                            NO RECORD FOUND
                                        </div>
                                    </c:if>
                                </c:if>
                            </div>
                        </div>
                    </div>


                </div>
            </div><!-- .animated -->
        </div><!-- .content -->
        <%@include file="/user/footer.jsp" %>
    </body>
</html>
