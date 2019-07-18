<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Checkout</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


    <script src="https://code.jquery.com/jquery-3.2.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <%--    <script src="https://kit.fontawesome.com/8fd24b2ea7.js"></script>--%>
    <%--    <script src="resource/script/script.js"></script>--%>
    <%--    ${user != null ? null : "<script src='resource/script/checkCookies.js'></script>"}--%>
    <%--    <script src="resource/script/homeScript.js"></script>--%>

    <link rel="stylesheet" href="../../resources/css/home.css"/>
    <link rel="stylesheet" href="../../resources/css/style.css"/>

</head>
<body class="bg-light">
<nav class="navbar navbar-light bg-dark justify-content-between">
    <a class="navbar-brand" href="/">CHECK OUT</a>
    <div class="" id="smallbar">
        <form class="form-inline my-2 my-lg-0 mr-auto ${username == null ? "dnone" : null}">
            <a data-toggle="modal" data-target="#cart-modal" class="btn btn-success my-2 my-sm-0 btn-sm">
                <i class="fas fa-shopping-cart"></i> Cart (${items > 0 ? items : 0})
            </a> &nbsp;
            <a href="/users/signup" class="btn btn-success my-2 my-sm-0 btn-sm">
                <i class="fas fa-sign-in-alt"></i> Signup
            </a> &nbsp;

            <!-- place holder for login data-toggle="modal" data-target="#login-modal"-->
            <a href="/users/signin" class="btn btn-outline-success my-2 my-sm-0 btn-sm">
                <i class="fas fa-user-circle"></i> Login
            </a> &nbsp;
        </form>

        <form class="form-inline my-2 my-lg-0 mr-auto ${username != null ? "dnone" : null}">

            <a class="btn btn-success my-2 my-sm-0 btn-sm" href="/logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
        </form>
    </div>
</nav>


<!--Main Contents inside container-->

<!-- Page Content -->
<div class="container">

    <%-- <div class="row">

         <div class="col">


             <div class="row my-4" id="showData">
                 <div class="display">
                     <div class="row" id="appendData">
                         <c:forEach var="product" items="${product}">

                             <div class="card custom-card">
                                 ${product.image}
 &lt;%&ndash;                                <a href="/product?id=${data[i].id}">&ndash;%&gt;
 &lt;%&ndash;                                &ndash;%&gt;
 &lt;%&ndash;                                    <img class="card-img-top" src="${data[i].picture}" alt="${data[i].name}"/>&ndash;%&gt;
 &lt;%&ndash;                                </a>&ndash;%&gt;
                                 <div class="card-body text-truncate">
                                     <h4 class="card-title">
                                         <p><h5>${product.productName}</h5></p>
                                     </h4>
                                     <p><h5>$${product.price}</h5></p>

                                 </div>
                                     <div class="section">
                                             <a href="/cart/add/${product.id}">  <button class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Add to cart</button></a>
                                     </div>
                             </div>


                         </c:forEach>


                     </div>
                     <div class="row" id="appendData2">
                         &lt;%&ndash;Display block here&ndash;%&gt;
                     </div>
                 </div>
                 <!-- /.row -->

             </div>
             <!-- /.col-lg-9 -->

         </div>
         <!-- /.row -->

     </div>
     <!-- /.container -->
 </div>--%>
    <!--End of Main container-->

    <%--
    <!--Login Modal Content-->
    <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

        <div class="modal-dialog" role="document">
            <div class="modal-content loginmodal-container">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Login</h5>

                </div>
                <div class="modal-body">
                    <form:form action="/users/login" method="post">
                        <input type="email" name="email" placeholder="Email: example@mum.com"/>
                        <input type="password" name="password" placeholder="Password">
                        <div class="dropdown-divider"></div>
                        <input type="submit" name="login" class="login btn btn-success" value="Login">

                    </form>
                    <div class="login-help">
                        <label>Please click  </label><a href="/users/signup"> Register </a><span> If you dont have an Account.</span>
                    </div>
                </div>

            </div>
        </div>
    </div>
    --%>

    <%--
    <!--Cart Modal Content-->
    <div class="modal fade" id="cart-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content card-body text-left">
              Cart (${items > 0 ? items : 0})
                <h3><i class="fas fa-shopping-cart"></i> cart here</h3>
                <div class="dropdown-divider"></div>

                <!-- repeat this for each product -->
                <c:forEach items="${cart}" var="item">
                    <div id="cartshow" class="row">

                        <div class="col-sm-5">
                            <h6 class="mt-0"><c:out value="${item.getProductName()}" /></h6>
                        </div>

                        <div class="col-sm-4 text-left">
                            <span>Quantity <strong><c:out value="${item.getQuantity()}" /></strong></span>

                        </div> <div class="col-sm-3 text-left">
                           <a href="/cart/remove/${item.getId()}">&Chi;</a>
                        </div>
                    </div>
                </c:forEach>

                <div class="my-4 text-center emptyCart ${items > 0 ? "dnone" : null}">
                    <h3><i class="far fa-frown fa-lg"></i></h3>
                    <h3>Your cart is empty!</h3>
                </div>

                <div class="dropdown-divider"></div>
                <div class="text-right">
                    <a href="/checkout" class="btn btn-danger checkoutbtn">Checkout</a>
                </div>
            </div>
        </div>
    </div>
    --%>


    <!-- Loader -->
    <div id="loader">
        <div id="central">
            <i class="fas fa-sync-alt"></i>
        </div>
    </div>


    <!-- For Reference -->
    <%-- <c:forEach items="${cart}" var="item">
     <div id="cartshow" class="row">

         <div class="col-sm-5">
             <h6 class="mt-0"><c:out value="${item.getProductName()}"/></h6>
         </div>

         <div class="col-sm-4 text-left">
             <span>Quantity <strong><c:out value="${item.getQuantity()}"/></strong></span>

         </div>
         <div class="col-sm-3 text-left">
             <a href="/cart/remove/${item.getId()}">&Chi;</a>
         </div>
     </div>
     </c:forEach>--%>
    <!--End of reference -->


    <!-- Creating checkout-->

    <div class="container">
        <table id="cart" class="table table-hover table-condensed">
            <thead>
            <tr>
                <th style="width:50%">Product</th>
                <th style="width:10%">Price</th>
                <th style="width:8%">Quantity</th>
                <th style="width:22%" class="text-center">Subtotal</th>
                <th style="width:10%"></th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${cart}" var="item">
                <tr>
                    <td data-th="Product">
                        <div class="row">

                            <div class="col-sm-2 hidden-xs"><img src="http://placehold.it/100x100" alt="..."
                                                                 class="img-responsive"/></div>
                            <div class="col-sm-10">
                                <h4 class="nomargin"><c:out value="${item.getProductName()}"/></h4>
                            </div>
                        </div>
                    </td>
                    <td data-th="Price"><c:out value="${item.getRate()}"/></td>
                    <td data-th="Quantity">
                        <c:out value="${item.getQuantity()}"/>
                    </td>
                    <td data-th="Subtotal" class="text-center"><c:out
                            value="${item.getPrice()* item.getQuantity()}"/></td>
                    <td class="actions" data-th="">
                            <%--<button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>--%>
                        <a href="/cart/remove/${item.getId()}">
                            <button type="button" class="btn btn-danger">Remove</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
            <tfoot>

            <tr>
                <c:set var="total" value="${0}"/>
                <c:forEach items="${cart}" var="item">
                    <td colspan="2" class="hidden-xs"></td>
                    <td class="hidden-xs text-center"><c:set var="total" value="${total + item.getPrice()}"/><%--${total}--%>
                    </td>
                </c:forEach>
                <td colspan="2" class="hidden-xs"></td>
              <td class="hidden-xs text-center"><strong>Total</strong> <c:out value = "${total}"></c:out></td>
                <td>
                    <a href="/checkout/pay"
                       class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a>
                </td>
            </tr>
            </tfoot>
        </table>
        <!-- End of checkout-->

        <!--Bottom Footer-->
        <footer class="bottom section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <div class="copyright">
                            <p>&copy <span>2019</span> <a href="#" class="transition">ONLINE STORE</a> All rights
                                reserved.</p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!--Bottom Footer-->

</body>

</html>