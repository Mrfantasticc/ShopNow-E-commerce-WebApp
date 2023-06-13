
<%@page import="com.project.myshoppingwebapp.entities.User"%>

<%

    User user = (User) session.getAttribute("current-user");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
        <!-- Delay in milliseconds (1 seconds)before redirecting -->
               <script>
                    setTimeout(function () {
                        window.location.href = "index.jsp";
                    }, 1000); 
                </script>
        <%@include file="Component/common_css_js.jsp"%>
    </head>
    <body>
        <%@include file="Component/navbar.jsp" %>
        <div class="container my-5">
            <div class="row">
                <div class="col-md-12 ">
                    <div class="card text-dark bg-info mb-3" style="max-width: 25rem;">
                        <div class="card-header text-center"><h1>ShopNow.Com</h1></div>
                        <div class="card-body">
                            <h3 class="card-title">Welcome</h3>
                            <p class="card-text"><h2 class="text-center"><%= user.getUserName() +" "%></h2></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        

    </body>
</html>
