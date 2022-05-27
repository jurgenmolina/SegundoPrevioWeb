<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Registrar Candidato</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
         <script>
	        function saludo() {
	        	 window.alert("Registrado con Exito");
	        	}
        </script>
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #01579B">
                    <div>
                        <a href="<%=request.getContextPath()%>/inicio" class="navbar-brand"> Volver al Inicio </a>
                    </div>

                    
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                        <c:if test="${user != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${user == null}">
                            <form action="insertarUser" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${user != null}">
                                    Editar candidato
                                </c:if>
                                <c:if test="${user == null}">
                                    Agregar nuevo candidato
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${user != null}">
                            <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                        </c:if>
                        
                        <fieldset class="form-group">
                            <label>Username</label> <input type="text" value="<c:out value='${user.username}' />" class="form-control" name="username" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Contrasena</label> <input type="text" value="<c:out value='${user.password}' />" class="form-control" name="password">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Email</label> <input type="text" value="<c:out value='${user.email}' />" class="form-control" name="email">
                        </fieldset>

                       
          
                        <button type="submit" class="btn btn-success" onclick="saludo()">Registrar User</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
<html>