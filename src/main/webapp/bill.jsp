<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Aplicacion Gestion Usuario</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #01579B">
                    <div>
                        <a href="#" class="navbar-brand"> Nuevo Movimiento </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="listBill?user_id=<c:out value='${user_id}' />" class="nav-link">Cancelar</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                       
                         <form action="insertBill" method="post">


                        

                        <fieldset class="form-group">
                            <label>Fecha Movimiento</label> <input type="text"  class="form-control" name="date_bill" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Usuario </label> <input type="text" value="<c:out value='${user_id}' />" class="form-control" name="user_id" readonly>
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Valor </label> <input type="text"  class="form-control" name="value">
                        </fieldset>
                        
                        <fieldset class="form-group">
						<label>Tipo de Movimiento </label> 
                        <div class="form-check">
						  <input class="form-check-input" type="radio" name="type" id="flexRadioDefault1">
						  <label class="form-check-label" for="flexRadioDefault1">
						    Ingreso
						  </label>
						</div>
						<div class="form-check">
						  <input class="form-check-input" type="radio" name="type" id="flexRadioDefault2" checked>
						  <label class="form-check-label" for="flexRadioDefault2">
						    Gasto
						  </label>
						</div>
						
						</fieldset>
						
						<fieldset class="form-group">
                            <label>Observación </label> <input type="text"  class="form-control" name="observation">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
