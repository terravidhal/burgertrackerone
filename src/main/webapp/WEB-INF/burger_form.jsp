<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- New line below to use the JSP Standard Tag Library -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- New line below to use the JSP Standard Tag Library : Form -->
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <!-- gestion ds erreurs -->
    <%@ page isErrorPage="true" %> 
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Create Burgers :</title>
            <!-- for Bootstrap CSS -->
            <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
            <!-- YOUR own local CSS -->
            <link rel="stylesheet" href="/css/style.css" />
        </head>

        <body>
            <div class="container-fluid text-center p-5" style="justify-content: center;width: 50%;">
                <h1 class="text-center text-primary" style="padding-top: 100px;">
                    Create new burger!</h1>
               <div class="omikuji border-1">
                        <form:form action="/process_burger" method="POST" modelAttribute="burgerAttr" class="form_burger">
                            <div class="form-group">
                                <form:label path="burger">Burger Name  : </form:label>
                                <form:errors path="burger"/>
                                <form:input class="form-control" path="burger"/>
                            </div>
                            <div class="form-group">
                                <form:label path="restaurant">Restaurant Name :</form:label>
                                <form:errors path="restaurant"/>
                                <form:input class="form-control"  path="restaurant"/> 
                            </div>
                            <div class="form-group">
                                <form:label path="rating">Rating(out of 5) :</form:label>
                                <form:errors path="rating"/>
                                <form:input class="form-control"  type="number" path="rating"/>
                            </div>
                            <div class="form-group">
                                <form:label path="notes">Notes :</form:label>
                                <form:errors path="notes"/>
                                <form:textarea class="form-control" rows="3" path="notes"/> 
                            </div>
                            <button type="submit" class="btn btn-primary my-2">Submit</button>
                        </form:form>
                </div> 
                
            </div>
            <div class="back st">
                <a href="/burgers">Back to All burgers</a>
            </div>

            <!-- link Js -->
            <script type="text/javascript" src="/js/main.js"></script>
            <!-- For any Bootstrap that uses jquery -->
            <script src="/webjars/jquery/jquery.min.js"></script>
            <!--For any Bootstrap that uses JS -->
            <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        </body>

        </html>