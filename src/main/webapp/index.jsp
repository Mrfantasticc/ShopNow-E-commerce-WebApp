<%@page import="com.project.myshoppingwebapp.helper.Helper"%>
<%@page import="com.project.myshoppingwebapp.entities.Category"%>
<%@page import="com.project.myshoppingwebapp.dao.CategoryDao"%>
<%@page import="java.util.List"%>
<%@page import="com.project.myshoppingwebapp.entities.Product"%>
<%@page import="com.project.myshoppingwebapp.dao.ProductDao"%>
<%@page import="com.project.myshoppingwebapp.helper.FactoryProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>

        <%@include file="Component/common_css_js.jsp"%>
    </head>
    <body>
        <%@include file="Component/navbar.jsp" %>
        <div class="container design">
            <div class="row mt-3 mx-2">

                <%                    
                    String cat = request.getParameter("category");
                    // out.println(cat);

                    ProductDao dao = new ProductDao(FactoryProvider.getFactory());

                    List<Product> list = null;

                    if (cat == null || cat.trim().equals("all")) {
                        list = dao.getAllProducts();
                    } else {

                        int cid = Integer.parseInt(cat.trim());
                        list = dao.getAllProductsById(cid);
                    }

                    CategoryDao cdao = new CategoryDao(FactoryProvider.getFactory());
                    List<Category> clist = cdao.getCategory();
                %>






                <!--show category-->
                <div class="col-md-2 mt-5">
                    <div class="list-group">
                        <a href="index.jsp?category=all" class="list-group-item list-group-item-action" aria-current="true">
                            All Products
                        </a>
                        <%
                            for (Category category : clist) {
                        %>
                        <a href="index.jsp?category=<%=category.getCategoryId()%>" class="list-group-item list-group-item-action"><%=category.getCategoryTitle()%></a>
                        <%
                            }
                        %>
                    </div>


                </div>

                <!--show product-->
                <div class="col-md-10">

                    <div class="row mt-5">

                        <!--col: 12-->
                        <div class="clo-md-12">
                            <div class="row row-cols-1 row-cols-md-3 g-4 ">
                                <%
                                    for (Product product : list) {
                                %>
                                <div class="col">
                                    <div class="card product-card">
                                        <img src="img/products/<%= product.getpPhoto()%>" style="max-height: 300px;max-width: 100%;width: auto" class="card-img-top" alt="...">
                                        <div class="card-body">
                                            <h5 class="card-title"><%= product.getpName()%></h5>
                                            <p class="card-text"><%= Helper.get10Words(product.getpDesc())%></p>
                                        </div>
                                        <div class="card-footer text-center">
                                            <button class="btn btn-primary" onclick="add_to_cart(<%= product.getpId() %>,'<%= product.getpName() %>',<%=product.getPrinceAfterApplyingDiscount() %>)">Add to Card</button>
                                            <button class="btn btn-outline-primary text-white"> &#8377; <%=product.getPrinceAfterApplyingDiscount()%>/- <span class="text-secondary discount-label text-white">&#8377; <%= product.getpPrice()%>, <%=product.getdDiscount()%>% Off</span> </button>
                                        </div>
                                    </div>
                                </div>
                                <%
                                    }
                                    if (list.size() == 0) {
                                        out.println("<h3> No items in this category </h3>");

                                    }
                                %>
                            </div>
                        </div>
                    </div>



                </div>
            </div>
        </div>
                         
        <%@include file="Component\common_models.jsp" %>

    </body>
</html>
