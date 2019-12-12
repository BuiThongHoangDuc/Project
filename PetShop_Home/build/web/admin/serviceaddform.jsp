<%-- 
    Document   : serviceaddform
    Created on : Jul 12, 2019, 2:40:07 PM
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
                    <strong>Service Add Form</strong>
                </div>
                <form action="/PetShop/MainController" method="POST" enctype="multipart/form-data" class="form-horizontal">
                    <div class="card-body card-block">

                        <c:if test="${requestScope.INVALID == null}" var="isERROR">

                        </c:if>
                        <c:if test="${!isERROR}">
                            <div class="alert alert-info alert-dismissable">
                                <a class="panel-close close" data-dismiss="alert">×</a> 
                                <i class="fa fa-coffee"></i>
                                ${requestScope.INVALID}
                            </div>
                        </c:if>
                        
                        <div class="row form-group">
                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">Name</label></div>
                            <div class="col-12 col-md-9"><input type="text" id="text-input" name="name"  class="form-control" required></div>
                        </div>

                        <div class="row form-group">
                            <div class="col col-md-3"><label for="select" class=" form-control-label">Type</label></div>
                            <div class="col-12 col-md-9">
                                <select name="type" class="form-control">
                                    <option value="1">Dog</option>
                                    <option value="2">Cat</option>
                                    </select>
                                </div>
                            </div>

                            <div class="row form-group">
                                <div class="col col-md-3"><label for="text-input" class=" form-control-label">Price</label></div>
                                <div class="col-12 col-md-9"><input type="number" id="text-input" name="price"  class="form-control" min="1" required></div>
                            </div>

                            <div class="row form-group">
                                <div class="col col-md-3"><label for="file-input" class=" form-control-label">Image</label></div>
                                <div class="col-12 col-md-9"><input type="file" id="file-input" name="image" class="form-control-file" accept="image/*" onchange="loadFile(event)"></div>
                            </div>


                        </div>
                        <div class="card-footer">
                            <input type="hidden" name="txtSearch" value="${requestScope.txtSearch}"/>
                            <button type="submit" name="action" value="ServiceAdd" class="btn btn-primary btn-sm">
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
