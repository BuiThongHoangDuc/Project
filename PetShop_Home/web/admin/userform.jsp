<%-- 
    Document   : userform
    Created on : Jul 4, 2019, 1:47:09 PM
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
        <div class="col-lg-12">
            <div class="card">
                <div class="card-header">
                    <strong>Form</strong>
                </div>
                <form action="MainController" method="POST" class="form-horizontal">
                    <div class="card-body card-block">


                        <div class="row form-group">
                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">UserName:</label></div>
                            <div class="col-12 col-md-9"><input type="text" id="text-input" value="${requestScope.DTO.username}" name="username" class="form-control" readonly></div>
                        </div>

                        <div class="row form-group">
                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">UserFullName:</label></div>
                            <div class="col-12 col-md-9"><input type="text" id="text-input" value="${requestScope.DTO.fullname}" name="fullname" class="form-control" required></div>
                        </div>

                        <div class="row form-group">
                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">UserEmail:</label></div>
                            <div class="col-12 col-md-9"><input type="text" id="text-input" value="${requestScope.DTO.useremail}" name="email" class="form-control" pattern="[A-Za-z0-9._%+-]{3,}@[a-zA-Z]{3,}([.]{1}[a-zA-Z]{2,}|[.]{1}[a-zA-Z]{2,}[.]{1}[a-zA-Z]{2,})"  title="ex@abc.xyz" required></div>
                        </div>

                        <div class="row form-group">
                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">UserAdress:</label></div>
                            <div class="col-12 col-md-9"><input type="text" id="text-input" value="${requestScope.DTO.useradress}" name="adress" class="form-control" required></div>
                        </div>

                        <div class="row form-group">
                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">UserPhoneNum:</label></div>
                            <div class="col-12 col-md-9"><input type="text" id="text-input" value="${requestScope.DTO.userphonenum}" name="phonenumber" class="form-control" required></div>
                        </div>
                        <c:if test="${sessionScope.USERLOGIN != requestScope.DTO.username}" var="notMe">
                            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
                            <input type="hidden" name="person" value="notMe"/>
                            <div class="row form-group">
                                <div class="col col-md-3"><label for="select" class=" form-control-label">Select</label></div>
                                <div class="col-12 col-md-9">
                                    <select name="role" class="form-control">
                                        <option value="1"<c:if test="${requestScope.DTO.userrole eq '1'}"> selected </c:if>>Admin</option>
                                        <option value="2"<c:if test="${requestScope.DTO.userrole eq '2'}"> selected </c:if>>User</option>
                                        </select>
                                    </div>
                                </div>
                        </c:if>

                    </div>
                    <div class="card-footer">
                        <c:if test="${!notMe}">
                            <input type="hidden" name="person" value="Me"/>
                            <input type="hidden" name="role" value="${requestScope.DTO.userrole}"/>
                            <input type="hidden" name="id" value="${requestScope.DTO.username}"/>
                        </c:if>

                        <button type="submit" name="action" value="Update" class="btn btn-primary btn-sm">
                            <i class="fa fa-dot-circle-o"></i> Submit
                        </button>
                        <button type="reset" class="btn btn-danger btn-sm">
                            <i class="fa fa-ban"></i> Reset
                        </button>
                    </div>
                </form>
            </div>

        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
