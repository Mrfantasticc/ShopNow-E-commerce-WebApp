
<!--if user is null ,then user shoud not chekout-->
<%
//    chek that user is null or not,if null then send it to the login page and display message
    User user = (User) session.getAttribute("current-user");
    if (user == null) {
        session.setAttribute("message", "you are not logged in !! login first to access chekout page");
        response.sendRedirect("login.jsp");
        return;
    }


%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="Component/common_css_js.jsp"%>
    </head>
    <body>
        <!--display navbar-->
        <%@include file="Component/navbar.jsp" %>
        <div class="container design">
            <div class="row mt-5">
                <div class="col-md-6">
                    <!--cart details-->
                    <div class="card text-white bg-secondary my-3" style="max-width: 100rem;">
                        <div class="card-header text-center"><h3>Your Items</h3></div>
                        <div class="card-body">
                            <div class="cart-body text-white">

                            </div>
                        </div>
                    </div>

                </div>
                <div class="col-md-6">
                    
                    
                    <!--form details-->
                    <div class="card text-dark bg-light my-3" style="max-width: 100rem;">
                        <div class="card-header">Your Details For Order</div>
                        <div class="card-body">
                            <form class="row g-3">
                                <div class="col-md-6">
                                    <label for="inputEmail4" class="form-label">Email</label>
                                    <input value="<%= user.getUserEmail() %>" type="email" class="form-control" id="inputEmail4">
                                </div>
                                <div class="col-md-6">
                                    <label for="inputName" class="form-label">Name</label>
                                    <input value="<%= user.getUserName() %>" type="text" class="form-control" id="inputName">
                                </div>
                                <div class="col-12">
                                    <label for="inputAddress" class="form-label">Address</label>
                                    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
                                </div>
                                
                                <div class="col-md-6">
                                    <label for="inputCity" class="form-label">City</label>
                                    <input type="text" class="form-control" id="inputCity">
                                </div>
                                <div class="col-md-4">
                                    <label for="inputState" class="form-label">State</label>
                                    <input type="text" class="form-control" id="inputState">
                                </div>
                                <div class="col-md-2">
                                    <label for="inputZip" class="form-label">Zip</label>
                                    <input type="text" class="form-control" id="inputZip">
                                </div>
                                <div class="col-12">
                                    <button type="submit" class="btn btn-primary">Checkout</button>
                                    <button type="button" class="btn btn-secondary" onclick="goToIndexPage()">Continue Shopping</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>




        <%@include file="Component\common_models.jsp" %>
    </body>
</html>
