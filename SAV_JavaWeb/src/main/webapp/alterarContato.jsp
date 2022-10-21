<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Alteração de Viagem ${contato.destino}</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>

</head>
<body>

	<div class="container">
		<h5>Alteração de Viagem ${contato.destino}</h5>
		<form action="editar" method="post" class="form-control">

			<input type="hidden" name="id" value="${contato.id}">
			<p>Destino:</p>
			<p>
				<input type="text" name="destino" value="${contato.destino}">
			</p>
			<p>Data Destino:</p>
			<p>
				<input type="date" name="data_destino" value="${contato.data_destino}">
			</p>
			
			<p>Origem:</p>
			<p>
				<input type="text" name="origem" value="${contato.origem}">
			</p>
			<p>Data Origem:</p>
			<p>
				<input type="date" name="data_origem" value="${contato.data_origem}">
			</p>
			<button type="submit" class="btn btn-success">Atualizar</button>
		</form>
	</div>
	
</body>
</html>