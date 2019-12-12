<%-- 
    Document   : servicetable
    Created on : Jul 12, 2019, 2:16:06 PM
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
                                <strong class="card-title">Service Table</strong>
                            </div>

                            <div class="col-md-12">

                                <form>
                                    <c:url value="/admin/serviceaddform.jsp" var="AddLink">
                                        <c:param name="txtSearch" value="${requestScope.txtSearch}"/>
                                    </c:url>
                                    <a class="col-md-2 btn" href="${AddLink}"><button type="button" class="btn btn-primary">Add New Service</button></a>
                                    <div class="col-md-10 btn">
                                        <div class="input-group">
                                            <form action="MainController" method="POST">
                                                <div class="input-group-btn">

                                                    <button type="submit" name="action" value="ServiceSearch"  class="btn btn-primary">
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
                                <c:if test="${requestScope.LISTSERVICE != null}">
                                    <c:if test="${not empty requestScope.LISTSERVICE}" var="isList">
                                        <table  class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Image</th>
                                                    <th>Name</th>
                                                    <th>Type</th>
                                                    <th>Price</th>
                                                    <th>Manage</th>
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
                                                        <td>
                                                            <c:url value="MainController" var="EditLink">
                                                                <c:param name="action" value="ServiceEdit"/>
                                                                <c:param name="id" value="${Service.serviceid}"/>
                                                                <c:param name="txtSearch" value="${requestScope.txtSearch}"/>
                                                            </c:url>
                                                            <a class="col-md-12 btn btn-outline-primary" href="${EditLink}" role="button">Edit</a>

                                                            <c:if test="${!btnDelete}"> 
                                                                <form action="MainController" method="POST">
                                                                    <input type="hidden" name="id" value="${Service.serviceid}"/>
                                                                    <input type="hidden" name="txtSearch" value="${requestScope.txtSearch}"/>
                                                                    <button name="action" value="ServiceDelete" class="col-md-12 btn btn-danger" type="submit">Delete</button>
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
