<%-- 
    Document   : billdetail
    Created on : Jul 13, 2019, 9:20:09 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="content mt-3">
            <div class="animated fadeIn">
                <div class="row">

                    <div class="col-md-12">
                        <div class="card">

                            <div class="card-header">
                                <strong class="card-title">Bill Detail</strong>
                            </div>

                            <div class="card-body">
                                <c:if test="${requestScope.ListDetail != null}">
                                    <c:if test="${not empty requestScope.ListDetail}" var="isList">
                                        <table  class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>ProductImage</th>
                                                    <th>Name</th>
                                                    <th>Quantity</th>
                                                    <th>Date</th>
                                                    <th>Price</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${requestScope.ListDetail}" var="Bill">
                                                    <tr>

                                                        <td><img src="/PetShop/images/home/${Bill.productimage}"/></td>
                                                        <td>${Bill.productname}</td>
                                                        <td>${Bill.quantity}</td>
                                                        <td>${Bill.datetime}</td>
                                                        <td>${Bill.priceproduct}</td>
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
        <%@include file="footer.jsp" %>
    </body>
</html>
