<%-- 
    Document   : cart
    Created on : Jul 12, 2019, 8:44:47 PM
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
        <%@include file="user/header.jsp" %>
        <section id="cart_items">
            <div class="container">
                <c:if test="${sessionScope.cart != null}" var="haveCart">
                    <c:if test="${not empty sessionScope.cart.cart}" var="itemsCart">
                        <div class="table-responsive cart_info">
                            <table class="table table-condensed">
                                <c:if test="${not empty requestScope.INVALID}" var="invalid">
                                    <div class="alert alert-info alert-dismissable">
                                        <a class="panel-close close" data-dismiss="alert">×</a> 
                                        <i class="fa fa-coffee"></i>
                                        ${requestScope.INVALID}
                                    </div>
                                </c:if>
                                <c:if test="${!invalid}">
                                    
                                </c:if>
                                <thead>
                                    <tr class="cart_menu">
                                        <td>Item</td>
                                        <td>Name</td>
                                        <td>Price</td>
                                        <td>Quantity</td>
                                        <td>Total</td>
                                        <td></td>
                                    </tr>
                                </thead>
                                <tbody>
                                <form action="MainController" method="POST">
                                    <c:forEach items="${sessionScope.cart.cart.values()}" var="myCart">
                                        <tr>
                                            <td class="cart_product col-md-2">
                                                <img class="col-md-12" src="/PetShop/images/home/${myCart.productimage}" alt="">
                                            </td>
                                            <td>
                                                <h4>${myCart.productname}</h4>
                                                <input type="hidden" name="productid" value="${myCart.productid}"/>
                                            </td>
                                            <td class="cart_price">
                                                <p>${myCart.productprice} VND</p>
                                            </td>
                                            <td class="cart_quantity col-md-2">
                                                <div class="cart_quantity_button">
                                                    <input class="cart_quantity_input" type="number" name="quantity" value="${myCart.productquantity}" min="1" autocomplete="off" size="2">
                                                </div>
                                            </td>
                                            <td class="cart_total">
                                                <p class="cart_total_price">${myCart.productquantity * myCart.productprice} VND</p>
                                            </td>
                                            <td class="cart_delete col-md-1">
                                                <c:url value="MainController" var="cartDelete">
                                                    <c:param name="action" value="CartPDelete" />
                                                    <c:param name="ProductCartID" value="${myCart.productid}"/>
                                                </c:url>
                                                <a class="cart_quantity_delete" href="${cartDelete}"><i class="fa fa-times"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td>
                                            <input class="btn btn-primary" type="submit" name="action" value="UpdateQuantity"/>
                                        </td>
                                        <td class="cart_total cart_total_price">
                                            Total Cart: 
                                            </br>
                                            ${sessionScope.cart.getTotal()} VND
                                        </td>
                                        <td><input class="btn btn-primary" type="submit" name="action" value="Check Out"/></td>
                                    </tr> 
                                </form>
                                </tbody>
                            </table>

                        </div>
                    </c:if>
                    <c:if test="${!itemsCart}">
                        <div class="alert alert-info alert-dismissable">
                            <a class="panel-close close" data-dismiss="alert">×</a> 
                            <i class="fa fa-coffee"></i>
                            You Don't Have Any Items Yet
                        </div>
                    </c:if>
                </c:if>
                <c:if test="${!haveCart}">
                    <div class="alert alert-info alert-dismissable">
                        <a class="panel-close close" data-dismiss="alert">×</a> 
                        <i class="fa fa-coffee"></i>
                        You Don't Have Any Items Yet
                    </div>
                </c:if>
            </div>    
        </section> <!--/#cart_items-->

        <%@include file="user/footer.jsp" %>
    </body>
</html>
