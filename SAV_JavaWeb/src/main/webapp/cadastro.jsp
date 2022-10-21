<%@ page language="java" contentType="text/html;"
	pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
	
	
<!DOCTYPE html>
<html LANG="PT-BR">
<head>
<title>Agenda</title>
<meta charset="utf-8">


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
		<h3>Cadastro de Viagens</h3>
		<form action="Inserir" method="post" class="form-control">
			<fieldset>
				<legend>Cadastre a sua Viagem</legend>

				<p>
					<label for="destino">Destino:</label> <input type="text" id="destino"
						name="destino" size="50" class="form-control" required>
				</p>

				<p>
					<label for="date">Data Destino:</label> <input type="date"
						id="date" name="data_destino" size="10" class="form-control" required>
				</p>
				
				<p>
					<label for="origem">Origem:</label> <input type="text" id="origem"
						name="origem" size="50" class="form-control" required>
				</p>
				
				<p>
					<label for="date">Data Origem:</label> <input type="date"
						id="date" name="data_origem" size="10" class="form-control" required>
				</p>

				<p>
					<input type="submit" value="Cadastrar Cliente"
						class="btn btn-primary">
				</p>
			</fieldset>
		</form>
		
		<br>
		<h5>Viagens cadastradas</h5>
	
	<table class="table">
		<thead>
			<tr>
				<th>Destino</th>
				<th>Data Destino</th>
				<th>Origem</th>
				<th>Data Origem</th>
				<th>Ações</th>
			</tr>
		</thead>
		
		<tbody>
			<jstl:forEach items="${listaContatos}" var="contato">
				<tr>
					<td>${contato.destino}</td>
					<td>${contato.data_destino}</td>
					<td>${contato.origem}</td>
					<td>${contato.data_origem}</td>
					
					<td>
						<a href="editar?id=${contato.id}" class="btn btn-success">Editar</a>  
						<a href="excluir?id=${contato.id}" onclick="return confirm('Deseja Excluir?')" class="btn btn-danger">Excluir</a>
					</td>
				</tr>
			</jstl:forEach>			
		</tbody>
	</table>
	
	</div>
</body>
</html>