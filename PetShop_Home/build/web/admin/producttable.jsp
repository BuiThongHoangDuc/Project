<%-- 
    Document   : producttable
    Created on : Jul 3, 2019, 4:51:14 PM
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
                                <strong class="card-title">Product Table</strong>
                            </div>

                            <div class="col-md-12">

                                <form>
                                    <c:url value="/admin/productform.jsp" var="AddLink">
                                        <c:param name="txtSearch" value="${requestScope.txtSearch}"/>
                                    </c:url>
                                    <a class="col-md-2 btn" href="${AddLink}"><button type="button" class="btn btn-primary">Add New Product</button></a>
                                    <div class="col-md-10 btn">
                                        <div class="input-group">
                                            <form action="MainController" method="POST">
                                                <div class="input-group-btn">

                                                    <button type="submit" name="action" value="ProductSearch"  class="btn btn-primary">
                                                        <i class="fa fa-search"></i> Search
                                                    </button>
                                                </div>
                                                <input type="text" name="txtSearch" id="input1-group2" name="input1-group2" placeholder="Name" class="form-control">
                                            </form>
                                        </div>
                                    </div>
                                </form>  
                            </div>

                            <div class="card-body">
                                <c:if test="${requestScope.LISTPRODUCT != null}">
                                    <c:if test="${not empty requestScope.LISTPRODUCT}" var="isList">
                                        <table  class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Image</th>
                                                    <th>Name</th>
                                                    <th>Type</th>
                                                    <th>Detail</th>
                                                    <th>Quantity</th>
                                                    <th>Price</th>
                                                    <th>Status</th>
                                                    <th>Manage</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${requestScope.LISTPRODUCT}" var="Product">
                                                    <tr>

                                                        <td><img src="/PetShop/images/home/${Product.productimage}"/></td>
                                                        <td>${Product.productname}</td>
                                                        <td>${Product.typename}</td>
                                                        <td>${Product.productdetail}</td>
                                                        <td>${Product.productquantity}</td>
                                                        <td>${Product.productprice} VND</td>
                                                        <td>
                                                            <c:if test="${Product.productstatus == true}" var="isHave">
                                                                <font color="green">
                                                                IsAvailable
                                                                </font>
                                                            </c:if>
                                                            <c:if test="${!isHave}">
                                                                <font color="red">
                                                                Not Available
                                                                </font>
                                                            </c:if>
                                                        </td>
                                                        <td>
                                                            <c:url value="MainController" var="EditLink">
                                                                <c:param name="action" value="ProductEdit"/>
                                                                <c:param name="id" value="${Product.productid}"/>
                                                                <c:param name="txtSearch" value="${requestScope.txtSearch}"/>
                                                            </c:url>
                                                            <a class="col-md-12 btn btn-outline-primary" href="${EditLink}" role="button">Edit</a>

                                                            <c:if test="${!btnDelete}"> 
                                                                <form action="MainController" method="POST">
                                                                    <input type="hidden" name="id" value="${Product.productid}"/>
                                                                    <input type="hidden" name="txtSearch" value="${requestScope.txtSearch}"/>
                                                                    <button name="action" value="ProductDelete" class="col-md-12 btn btn-danger" type="submit">Delete</button>
                                                                </form>
                                                            </c:if>
                                                        </td>

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
