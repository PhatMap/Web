<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <div class="container-fluid bg-dark mb-30">
        <div class="row px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn d-flex align-items-center justify-content-between bg-primary w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; padding: 0 30px;">
                    <h6 class="text-dark m-0"><i class="fa fa-bars mr-2"></i>Categories</h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 999;">
                    <div class="navbar-nav w-100">
                        <c:forEach items="${Clist}" var="cat">
                            <a href="controlCategory?cid=${cat.catid}" class="nav-item nav-link">${cat.catname}</a>
                        </c:forEach>
                    </div>
                </nav>
            </div>
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0">
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="home.jsp" class="nav-item nav-link">Home</a>
                            <a href="controlShop" class="nav-item nav-link">Shop</a>
                            <c:if test="${sessionScope.acc==null}"><a href="cart.jsp" class="nav-item nav-link">Shopping Cart</a></c:if>
                            <c:if test="${sessionScope.acc!=null}"><a href="controlCart" class="nav-item nav-link">Shopping Cart</a></c:if>
                            <a href="checkout.jsp" class="nav-item nav-link">Checkout</a>
                        </div>
                        <div class="navbar-nav ml-auto py-0 d-none d-lg-block">
                            <c:if test="${sessionScope.acc.issell==true}">
                                <a href="controlPManage" ><button style="background-color:yellow;">Manage product</button></a>
                            </c:if>
                            <c:if test="${sessionScope.acc.isadmin==true}">
                                <a href="" ><button style="background-color:yellow;">Manage account</button></a>
                            </c:if>
                            <c:if test="${sessionScope.acc==null}">
                            <a href="cart.jsp" class="btn px-0 ml-3">
                                <i class="fas fa-shopping-cart text-primary"></i>
                                <span class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;">0</span>
                            </a>
                            </c:if>
                            <c:if test="${sessionScope.acc!=null}">
                            <a href="controlCart?cartID=${sessionScope.acc.acid}" class="btn px-0 ml-3">
                                <i class="fas fa-shopping-cart text-primary"></i>
                                <span class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;">0</span>
                            </a>
                            </c:if>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
