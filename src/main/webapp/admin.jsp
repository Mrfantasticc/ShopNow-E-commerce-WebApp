<%@page import="java.util.Map"%>
<%@page import="com.project.myshoppingwebapp.helper.Helper"%>
<%@page import="java.util.List"%>
<%@page import="com.project.myshoppingwebapp.helper.FactoryProvider"%>
<%@page import="com.project.myshoppingwebapp.dao.CategoryDao"%>
<%@page import="com.project.myshoppingwebapp.entities.User" %>
<%@page import="com.project.myshoppingwebapp.entities.Category" %>

<!--logic to check user is logged in or not-->
<%
    User user = (User) session.getAttribute("current-user");
//    if user is null then user is not loged in ,return him on login page
    if (user == null) {
        session.setAttribute("message", "you are not logged in !! login first");
        response.sendRedirect("login.jsp");
        return;
    } else {
//        if user is not a admin ,send him to the login page and display message that you are not admin
        if (user.getUserType().equals("normal")) {
            session.setAttribute("message", "You are not a admin !!");
            response.sendRedirect("login.jsp");
            return;
        }

    }


%>

                  <!--accessing category Dao class-->
<%
    CategoryDao cdao= new CategoryDao(FactoryProvider.getFactory());
    List<Category> list= cdao.getCategory();
    

//getting count of product and user
Map<String,Long> m=Helper.getCounts(FactoryProvider.getFactory());

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <%@include file="Component/common_css_js.jsp"%>
    </head>
    <body>
        <!--navbar-->
        <%@include file="Component/navbar.jsp" %>
        <div class="container admin">
            
            <!--display message-->
            <div class="container-fluid mt-2">
                <%@include file="Component/message.jsp" %>
            </div>
            
            <!--first row--> 
            <div class="row mt-3">
                <!--first column-->

                <div class="col-md-4">

                    <!--users-->
                    <div class="card">
                        <div class="card-body text-center">

                            <div class="container">
                                <img style="max-width: 125px" class="img-fluid" src="img/user.png" alt="User_icon"/>
                            </div>

                            <h1><%= m.get("userCount") %></h1>
                            <h1 class="text-uppercase text-muted">Users</h1>

                        </div>
                    </div>

                </div>

                <!--second column-->

                <div class="col-md-4">

                    <!--categories-->
                    <div class="card">
                        <div class="card-body text-center">

                            <div class="container">
                                <img style="max-width: 125px" class="img-fluid" src="img/categories.png" alt="category_icon"/>
                            </div>

                            <h1><%= list.size() %></h1>
                            <h1 class="text-uppercase text-muted">Categories</h1>

                        </div>
                    </div>


                </div>


                <!--third column-->

                <div class="col-md-4">

                    <!--products-->
                    <div class="card">
                        <div class="card-body text-center">

                            <div class="container">
                                <img style="max-width: 125px" class="img-fluid" src="img/products.png" alt="product_icon"/>
                            </div>

                            <h1><%= m.get("productCount") %></h1>
                            <h1 class="text-uppercase text-muted">Products</h1>

                        </div>
                    </div>


                </div>
            </div>


            <!--second row-->
            <div class="row mt-3">
                <!--first column-->
                <div class="col-md-6">

                    <div class="card" data-bs-toggle="modal" data-bs-target="#add-category-model">
                        <div class="card-body text-center">

                            <div class="container">
                                <img style="max-width: 125px" class="img-fluid" src="img/add-catogries.png" alt="add_category_icon"/>
                            </div>

                            <p class="mt-2">Click here to add category</p>
                            <h1 class="text-uppercase text-muted">Add Category</h1>

                        </div>
                    </div>

                </div>


                <!--second column-->
                <div class="col-md-6">

                    <div class="card" data-bs-toggle="modal" data-bs-target="#add-product-model">
                        <div class="card-body text-center">

                            <div class="container">
                                <img style="max-width: 125px" class="img-fluid" src="img/add-product.png" alt="add_product_icon"/>
                            </div>

                            <p class="mt-2">Click here to add product</p>
                            <h1 class="text-uppercase text-muted">Add Products</h1>

                        </div>
                    </div>

                </div>
            </div>

        </div>

        <!--start of category model-->


        <!-- Modal -->
        <div class="modal fade" id="add-category-model" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header custom-bg text-white">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Fill Category Details</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <!--start category form-->
                        <form action="ProductOperationServlet" method="post">
                            <input type="hidden" name="operation" value="addcategory">
                            <div class="form-group">
                                <input type="text" class="form-control" name="catTitle" placeholder="Enter category title" required/>
                            </div>

                            <div class="form-group mt-3">
                                <textarea style="height: 150px" class="form-control" name="catDescription" placeholder="Enter category description" required>
                      
                                </textarea>
                            </div>
                            <div class="container text-center mt-3">

                                <button class="btn btn-primary">Add Category</button>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>

                            </div>
                        </form>
                        <!--end of category form-->

                    </div>  
                </div>
            </div>
        </div>
        <!--end of category model-->



        <!--start of product model-->


        <!-- Modal -->
        <div class="modal fade" id="add-product-model" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header custom-bg text-white">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Fill Product Details</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <!--start product form-->
                        <form action="ProductOperationServlet" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="operation" value="addproduct">
                            <div class="form-group">
                                <input type="text" class="form-control" name="pTitle" placeholder="Enter product name " required/>
                            </div>

                            <div class="form-group mt-3">
                                <textarea style="height: 100px" class="form-control" name="pDescription" placeholder="Enter product description" required>    
                                </textarea>
                            </div>
                            
                            <div class="form-group mt-3">
                                <input type="number" class="form-control" name="pPrice" placeholder="Enter product price" required/>
                            </div>
                            <div class="form-group mt-3">
                                <input type="number" class="form-control" name="pDiscount" placeholder="Enter product discount" required/>
                            </div>
                            
                            <div class="form-group mt-3">
                                <input type="number" class="form-control" name="pQuantity" placeholder="Enter product quantity" required/>
                            </div>
                              
                            
                            <!--product category-->
                            
                            
                            
                            <div class="form-group mt-3">
                                <label>Select Product Category</label><br>
                                <select name="catId" class="form-control mt-2">
                                    
                                    <!--getting product category dynamically-->
                                    <% 
                                    for(Category c: list){
                                    
                                    %>
                                    
                                    <option value="<%= c.getCategoryId() %>"><%= c.getCategoryTitle() %></option>
                                    <%
                                        }
                                    %>
                                    
                                </select>
                            </div>
                            <!--product category-->
                            
                            <!--product file/pic-->
                        
                            <div class="form-group mt-3">
                                <label class="form-group mb-2" for="pPic">Select Product Photo</label><br>
                                <input type="file" id="pPic" name="pPic" required />
                          
                            </div>
                        
                        <!--product file/pic-->
                            
                            
                            <div class="container text-center mt-3">

                                <button class="btn btn-primary">Add Product</button>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>

                            </div>
                        </form>
                        <!--end of product form-->
                                                
                    </div>  
                </div>
            </div>
        </div>
        <!--end of product model-->
        <%@include file="Component\common_models.jsp" %>
    </body>
</html>
