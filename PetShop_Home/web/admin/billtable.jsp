<%-- 
    Document   : billtable
    Created on : Jul 13, 2019, 7:10:37 PM
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
        <div class="content mt-3">
            <div class="animated fadeIn">
                <div class="row">

                    <div class="col-md-12">
                        <div class="card">

                            <div class="card-header">
                                <strong class="card-title">Bill Management</strong>
                            </div>
                            <div class="col-md-12">


                                <form>                           
                                    <div class="col-md-10 btn">
                                        <div class="input-group">
                                            <form action="MainController" method="POST">
                                                <div class="input-group-btn">

                                                    <button type="submit" name="action" value="BillSearch"  class="btn btn-primary">
                                                        <i class="fa fa-search"></i> Search
                                                    </button>
                                                </div>
                                                <input type="text" name="txtSearch" id="input1-group2" name="input1-group2" placeholder="UserName" class="form-control">
                                            </form>
                                        </div>
                                    </div>
                                </form>   
                            </div>

                            <div class="card-body">
                                <c:if test="${requestScope.ListBill != null}">
                                    <c:if test="${not empty requestScope.ListBill}" var="isList">
                                        <table  class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>BillID</th>
                                                    <th>BillDate</th>
                                                    <th>UserName</th>
                                                    <th>BillStatus</th>
                                                    <th>Manage</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${requestScope.ListBill}" var="Bill">
                                                    <tr>

                                                        <td>${Bill.billID}</td>
                                                        <td>${Bill.datetime}</td>
                                                        <td>${Bill.username}</td>
                                                        <td>
                                                            <c:if test="${Bill.status == 1}">
                                                                <font color="green">
                                                                Done
                                                                </font>
                                                            </c:if>
                                                        </td>
                                                        <td>
                                                            
                                                            <c:url value="MainController" var="View">
                                                                <c:param name="action" value="BillView"/>
                                                                <c:param name="billID" value="${Bill.billID}"/>
                                                                <c:param name="userID" value="${Bill.userID}"/>
                                                                <c:param name="txtSearch" value="${param.txtSearch}"/>
                                                            </c:url>

                                                            <a class="col-md-12 btn btn-outline-primary" href="${View}" role="button">View Detail</a>
                                                            
                                                            <form action="MainController" method="POST">
                                                                <input type="hidden" name="billID" value="${Bill.billID}"/>
                                                                <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                                                <button name="action" value="BillDelete" class="col-md-12 btn btn-danger" type="submit">Delete</button>
                                                            </form>

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
