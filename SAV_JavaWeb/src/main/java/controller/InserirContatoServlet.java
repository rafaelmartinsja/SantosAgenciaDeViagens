package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.ContatoDAO;

@SuppressWarnings("serial")
@WebServlet("/Inserir")
public class InserirContatoServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		// recebendo os dados do formulario via parametro
		String destino = request.getParameter("destino");
		String data_destino = request.getParameter("data_destino");
		String origem = request.getParameter("origem");
		String data_origem = request.getParameter("data_origem");

		// criando o objeto contato
		Contato objContato = new Contato();

		// guardando os dados do formulario do objeto
		objContato.setDestino(destino);		
		objContato.setData_destino(data_destino);
		objContato.setOrigem(origem);		
		objContato.setData_origem(data_origem);
		
		// criando um objeto DAO para enviar o objeto Contato para o banco de dados
		// usando o método save da classe ContatoDAO
		ContatoDAO cdao = new ContatoDAO();
		cdao.save(objContato);

		// Redirecionando o usuario para a pagina inicial da aplicação.
		response.sendRedirect("home");

	}

}
