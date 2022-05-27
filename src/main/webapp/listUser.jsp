<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>BBVA</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
               <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #01579B">
                    <div>
                        <a href="#" class="navbar-brand"> BBVA</a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/login" class="nav-link">Volver</a></li>
                    </ul>
                </nav>
            </header>
            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Lista de USUARIOS BBVA</h3>
                   
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Username</th>
                                <th>Pasword</th>
                                <th>email</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="user" items="${listUsers}">

                                <tr>
                                    <td>
                                        <c:out value="${user.id}" />
                                    </td>
                                    
                                    <td>
                                        <c:out value="${user.username}" />
                                    </td>
                                    
                                    <td>
                                        <c:out value="${user.pass}" />
                                    </td>
                                    
                                    <td>
                                        <c:out value="${user.email}" />
                                    </td>
                                    
                                    <td>
                                    	<a href="editUser?id=<c:out value='${user.id}' />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="deleteCandidato?id=<c:out value='${user.id}' />">Eliminar</a>
                                    </td>
                               
                                  </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                    
                    
                    
                </div>
            </div>
        </body>
