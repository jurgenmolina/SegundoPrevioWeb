<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
 <html>

        <head>
            <title>Aplicacion BBVA</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="#" class="navbar-brand">
     					Gestion de Usuarios BBVA</a>
                    </div>
                </nav>
            </header>
            
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Lista de usuarios BBVA</h3>
                    <h3 class="text-center">${list.get(0).username}</h3>
                    
                    <hr>
                    <div class="container text-left">

                        <a href="newBill?id=<c:out value='${list.get(0).id}' />">Agregar nuevo movimiento</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Fecha del movimiento</th>
                                <th>Usuario ID</th>
                                <th>Valor</th>
                                <th>Tipo</th>
                                <th>Observación</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="bill" items="${list.get(1)}">

                                <tr>
                                    <td>
                                        <c:out value="${bill.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${bill.date_bill}" />
                                    </td>
                                    <td>
                                        <c:out value="${bill.user_id.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${bill.value}" />
                                    </td>
                                    <td>
                                        <c:out value="${bill.type}" />
                                    </td>
                                    <td>
                                        <c:out value="${bill.observation}" />
                                    </td>
                                    <td><a href="delete?id=<c:out value='${bill.id}' />">Eliminar Movimiento</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>