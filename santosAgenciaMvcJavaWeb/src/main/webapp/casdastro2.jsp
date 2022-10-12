<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>