<%-- 
    Document   : index
    Created on : Jun 21, 2019, 7:05:25 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home | E-Shopper</title>
    </head><!--/head-->

    <body>
        <%@include file="user/header.jsp" %>

        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="left-sidebar">
                            <h2>Category</h2>
                            <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a href="/PetShop/ShowDogProductController">Products For Dog</a>
                                        </h4>
                                    </div>
                                    <div class="panel-heading">
                                        <h4 class="panel-title"><a href="/PetShop/ShowCatProductController">Products For Cat</a></h4>
                                    </div>
                                </div>
                            </div><!--/category-products-->
                        </div>
                    </div>

                    <div class="col-sm-9 padding-right">
                        <div class="features_items"><!--features_items-->
                            <h2 class="title text-center">Features Items</h2>
                            <c:if test="${requestScope.ListProduct != null}">
                                <c:if test="${not empty requestScope.ListProduct}" var="isList">
                                    <c:forEach items="${requestScope.ListProduct}" var="listProduct" >
                                        <div class="col-sm-4">
                                            <div class="product-image-wrapper">
                                                <div class="single-products">
                                                    <div class="productinfo text-center">
                                                        <img src="/PetShop/images/home/${listProduct.productimage}" alt="" />
                                                        <h2>${listProduct.productprice}VND</h2>
                                                        <p>${listProduct.productname}</p>
                                                        <c:url value="/MainController" var="AddToCart">
                                                            <c:param name="productID" value="${listProduct.productid}"/>
                                                            <c:param name="productPrice" value="${listProduct.productprice}"/>
                                                            <c:param name="productName" value="${listProduct.productname}"/>
                                                            <c:param name="productQuantity" value="${listProduct.productquantity}"/>
                                                            <c:param name="productImage" value="${listProduct.productimage}"/>
                                                            <c:param name="action" value="AddCart"/>
                                                        </c:url>
                                                        <a href="${AddToCart}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                                    </div>
                                                    <div class="product-overlay">
                                                        <div class="overlay-content">
                                                            <p>${listProduct.productdetail}</p>
                                                            <h2>${listProduct.productprice}VND</h2>
                                                            <p>${listProduct.productname}</p>
                                                            <c:url value="/MainController" var="AddToCart">
                                                                <c:param name="productID" value="${listProduct.productid}"/>
                                                                <c:param name="productPrice" value="${listProduct.productprice}"/>
                                                                <c:param name="productName" value="${listProduct.productname}"/>
                                                                <c:param name="productQuantity" value="${listProduct.productquantity}"/>
                                                                <c:param name="productImage" value="${listProduct.productimage}"/>
                                                                <c:param name="action" value="AddCart"/>
                                                            </c:url>
                                                            <a href="${AddToCart}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${!isList}">
                                    <font color="red">
                                    NO RECORD FOUND
                                    </font>
                                </c:if>
                            </c:if>

                        </div><!--features_items-->
                    </div>

                </div>
            </div>
        </section>

        <%@include file="user/footer.jsp" %>
    </body>
</html>
