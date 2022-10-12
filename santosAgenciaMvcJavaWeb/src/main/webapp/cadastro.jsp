<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Santos Agencia de Viagens</title>


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
		<h3>Viagens</h3>
		<form action="Inserir" method="post" class="form-control">
			<fieldset>
				<legend>Viagens</legend>

				<p>
					<label for="nome">Origem:</label> <input type="text" id="origem_viagens"
						name="origem_viagens" size="40" class="form-control" required>
				</p>

				<p>
					<label for="date">Data do Embarque:</label> <input type="date"
						id="date" name="data_origem_viagens" size="10" class="form-control" required>
				</p>
				
				<p>
					<label for="nome">Destino:</label> <input type="text" id="destino_viagens"
						name="destino_viagens" size="40" class="form-control" required>
				</p>
				
				
				<p>
					<label for="date">Data do Destino:</label> <input type="date"
						id="date" name="data_destino_viagens" size="10" class="form-control" required>
				</p>
				
				

				<p>
					<input type="submit" value="Cadastrar Cliente"
						class="btn btn-primary">
				</p>
			</fieldset>
		</form>
		
		<br>
		<h5>Viagens</h5>
	
	<table class="table">
		<thead>
			<tr>
				<th>Origem</th>
				<th>Data do Embarque</th>
				<th>Destino</th>
				<th>Data do Destino</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach items="${listaContatos}" var="contato">
				<tr>
					<td>${viagens.origem_viagens}</td>
					<td>${viagens.data_origem_viagens}</td>
					<td>${viagens.destino_viagens}</td>
					<td>${viagens.data_destino_viagens}</td>
					<td>
						<a href="editar?id=${viagens.id}" class="btn btn-success">Editar</a>  
						<a href="excluir?id=${viagens.id}" onclick="return confirm('Deseja Excluir?')" class="btn btn-danger">Excluir</a>
					</td>
				</tr>
			</jstl:forEach>
			
		</tbody>
	</table>
	</div>
</body>
</html>