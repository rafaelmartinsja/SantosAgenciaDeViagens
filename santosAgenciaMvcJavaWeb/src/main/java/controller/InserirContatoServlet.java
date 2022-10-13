package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Viagens;
import model.ViagensDAO;

@SuppressWarnings("serial")
@WebServlet("/Inserir")
public class InserirContatoServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recebendo os dados do formulario via parametro
		String origem_viagens = request.getParameter("origem_viagens");
		String data_origem_viagens = request.getParameter(request.getParameter("data_origem_viagens"));
		String destino_viagens = request.getParameter("destino_viagens");
		String data_destino_viagens = request.getParameter("data_destino_viagens"); 
		
		// criando o objeto contato
		Viagens objContato = new Viagens();

		// guardando os dados do formulario do objeto
		objContato.setOrigem_viagens(origem_viagens);
		objContato.setData_origem_viagens(data_origem_viagens);
		objContato.setDestino_viagens(destino_viagens);
		objContato.setData_destino_viagens(data_destino_viagens);
		// objContato.setDataCadastro(new Date());
		
		// criando um objeto DAO para enviar o objeto Contato para o banco de dados
		// usando o método save da classe ContatoDAO
		ViagensDAO cdao = new ViagensDAO();
		cdao.save(objContato);

		// Redirecionando o usuario para a pagina inicial da aplicação.
		response.sendRedirect("home");

	}

}
