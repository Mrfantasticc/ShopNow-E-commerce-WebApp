
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New User</title>
        <%@include file="Component/common_css_js.jsp"%>
    </head>
    <body>
        <%@include file="Component/navbar.jsp" %>
        <div class="container design my-2">
            <div class="row mt-3">
                <div class="col-md-4 offset-md-7">
                    <form action="RegisterServlet" method="post">

                        <div class="card w-60">
                            <%@include file="Component/message.jsp" %>
                            <div class="card-body">
                                <div class="text-center" style="border: 0">
                                    <img style="max-width: 50px" class="" src="img/register.png" alt="login_icon">
                                </div>
                                <h4 class="card-title text-center">Sign Up Here !!</h4>
                                <fieldset >
                                    <!--<legend>Register</legend>-->
                                    <br>
                                    <div class="mb-3">
                                        <label for="name" class="form-label">Name</label>
                                        <input name="user_name" type="text" id="name" class="form-control" placeholder="Full Name">
                                        
                                    </div>
                                    <div class="mb-3">
                                        <label for="email" class="form-label">Email</label>
                                        <input name="user_email" type="email" id="email" class="form-control" placeholder="abc@mail.com">
                                    </div>
                                    <div class="mb-3">
                                        <label for="password" class="form-label">Password</label>
                                        <input name="user_password" type="password" id="password" class="form-control" placeholder="Abc@1">
                                    </div>
                                    <div class="mb-3">
                                        <label for="phone" class="form-label">Phone</label>
                                        <input name="user_phone" type="number" id="phone" class="form-control" placeholder="0123456789">
                                    </div>
                                    <div class="mb-3">
                                        <label for="address" class="form-label">Address</label>
                                        <textarea name="user_address" class="form-control" placeholder="Enter your address"></textarea>
                                    </div>

                                    <div class="container text-center">
                                        <button type="submit" class="btn btn-primary ">Submit</button>
                                    </div>
                                </fieldset>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </body>
</html>
