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
                        <li><a href="<%=request.getContextPath()%>/crear" class="nav-link">Crear Usuario</a></li>
                         <li><a href="<%=request.getContextPath()%>/verUsers" class="nav-link">Ver Lista de Usuarios Disponibles(Solo para usos de previo)</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                         <c:if test="${user !=null }">
				           <form action="update" method="post">
				           </c:if>
				          <c:if test="${user == null }">
				           <form action="logearse" method="post">
				           </c:if>
				           
				           <caption>
				           <h2>
				           <c:if test="${user != null} }">
				           Editar Usuario
				           </c:if>
				           <c:if test="${user == null}">
				           ingresar Usuario
				           </c:if>
				           </h2>
				           </caption>
				           
				           <c:if test="${user != null }">
				              <input type="hidden" name="id" value="<c:out value="${user.id}" />"/>
				           </c:if>

                        <fieldset class="form-group">
                            <label>Nombre de Usuario</label> <input type="text" value="<c:out value='${user.username}' />" class="form-control" name="user" required="required">
                        </fieldset>                       

                        <fieldset class="form-group">
                            <label>Contraseña</label> <input type="password" value="<c:out value='${user.password}' />" class="form-control" name="password">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
