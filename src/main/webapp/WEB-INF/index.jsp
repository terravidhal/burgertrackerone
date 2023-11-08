<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- New line below to use the JSP Standard Tag Library -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Show Burgers :</title>
            <!-- for Bootstrap CSS -->
            <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
            <!-- YOUR own local CSS -->
            <link rel="stylesheet" href="/css/style.css" />
        </head>

        <body>

            <div class="container-fluid">
                <h1 class="text-center text-primary" style="padding-top: 100px;">
                    All Burgers</h1>
                <table class="table table-striped border border-5 w-m">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Burger Name</th>
                            <th scope="col">Restaurant Name</th>
                            <th scope="col">Rating(out of 5)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="elt" items="${burgers}">
                            <tr>
                                <td>
                                    <c:out value="${elt.id}" />
                                </td>
                                <td>
                                    <a href="/burger/${elt.id}">
                                        <c:out value="${elt.burger}" />
                                    </a>
                                </td>
                                <td>
                                    <c:out value="${elt.restaurant}" />
                                </td>
                                <td>
                                    <c:out value="${elt.rating}" />
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table> 
                <div class="create ml-30">
                    <a href="/burger/new">Create New burger</a>
                </div>
            </div>


            <!-- link Js -->
            <script type="text/javascript" src="/js/main.js"></script>
            <!-- For any Bootstrap that uses jquery -->
            <script src="/webjars/jquery/jquery.min.js"></script>
            <!--For any Bootstrap that uses JS -->
            <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        </body>

        </html>