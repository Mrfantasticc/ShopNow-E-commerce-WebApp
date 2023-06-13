<%-- 
    Document   : login
    Created on : 07-May-2023, 9:50:42 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login</title>
        <%@include file="Component/common_css_js.jsp"%>
    </head>
    <body>
        <%@include file="Component/navbar.jsp" %>

        <div class="container design">
            <div class="row mt-5">
                <div class="col-md-8">
                    <div class="page-hero d-flex align-items-center justify-content-center">
                        <h1 class="display-3 text-secondary"><b>Welcome To ShopNow</b></h1><br>

                    </div>



                </div>
                <div class="col-md-4 ">
                    <div class="text-center mt-5" style="border: 0">
                        <img style="max-width: 120px" class="" src="img/login.png" alt="login_icon">
                    </div>
                    <div class="card my-5">
                        <%@include file="Component/message.jsp" %>

                        <h5 class="card-header text-center text-white" style="background-color: #e0850d">Login</h5>
                        <div class="card-body">
                            <form action="LoginServlet" method="post">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input name="email" type="email" class="form-control mt-2" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">

                                </div>
                                <div class="form-group mt-4">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input name="password" type="password" class="form-control mt-2" id="exampleInputPassword1" placeholder="Password">
                                </div>
                                <a href="register.jsp" class="text-center d-block mt-2">
                                    <h6>Click Here To Register</h6>
                                </a>
                                <div class="container-fluid text-center mt-3">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>


            </div>
        </div>


    </body>
</html>
