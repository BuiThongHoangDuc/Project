<%-- 
    Document   : usertable
    Created on : Jul 3, 2019, 6:28:08 PM
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
                                <strong class="card-title">User Management</strong>
                            </div>
                            <div class="col-md-12">

                                
                                <form>                           
                                    <div class="col-md-10 btn">
                                        <div class="input-group">
                                            <form action="MainController" method="POST">
                                                <div class="input-group-btn">

                                                    <button type="submit" name="action" value="Search"  class="btn btn-primary">
                                                        <i class="fa fa-search"></i> Search
                                                    </button>
                                                </div>
                                                <input type="text" name="txtSearch" id="input1-group2" name="input1-group2" placeholder="FullName" class="form-control">
                                            </form>
                                        </div>
                                    </div>
                                </form>   
                            </div>

                            <div class="card-body">
                                <c:if test="${requestScope.LISTUSER != null}">
                                    <c:if test="${not empty requestScope.LISTUSER}" var="isList">
                                        <table  class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>UserName</th>
                                                    <th>FullName</th>
                                                    <th>Email</th>
                                                    <th>Adress</th>
                                                    <th>PhoneNumber</th>
                                                    <th>Role</th>
                                                    <th>Manage</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${requestScope.LISTUSER}" var="User">
                                                    <c:if test="${sessionScope.USERLOGIN == User.username}" var="Me">

                                                    </c:if>
                                                    <c:if test="${!Me}">
                                                        <tr>

                                                            <td>${User.username}</td>
                                                            <td>${User.fullname}</td>
                                                            <td>${User.useremail}</td>
                                                            <td>${User.useradress}</td>
                                                            <td>${User.userphonenum}</td>
                                                            <td>${User.userrole}</td>
                                                            <td>
                                                                <c:url value="MainController" var="EditLink">
                                                                    <c:param name="action" value="Edit"/>
                                                                    <c:param name="id" value="${User.username}"/>
                                                                    <c:param name="txtSearch" value="${param.txtSearch}"/>
                                                                </c:url>
                                                                <a class="col-md-12 btn btn-outline-primary" href="${EditLink}" role="button">Edit</a>
                                                                <c:if test="${User.userrole == 'Admin'}" var="btnDelete">

                                                                </c:if>
                                                                <c:if test="${!btnDelete}"> 
                                                                    <form action="MainController" method="POST">
                                                                        <input type="hidden" name="id" value="${User.username}"/>
                                                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                                                                        <button name="action" value="Delete" class="col-md-12 btn btn-danger" type="submit">Delete</button>
                                                                    </form>
                                                                </c:if>
                                                            </td>

                                                        </tr>
                                                    </c:if>
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
