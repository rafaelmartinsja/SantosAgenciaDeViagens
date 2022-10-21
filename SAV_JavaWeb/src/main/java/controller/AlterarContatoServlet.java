package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.ContatoDAO;

@SuppressWarnings("serial")
@WebServlet("/editar")
public class AlterarContatoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
				
		int idContato = Integer.parseInt(req.getParameter("id"));
		ContatoDAO cdao = new ContatoDAO();
		Contato contatoSelecionado = cdao.getContatoById(idContato);

		req.setAttribute("contato", contatoSelecionado);
	
		RequestDispatcher rd = req.getRequestDispatcher("/alterarContato.jsp");

        rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Contato contatoAlterado = new Contato();		
		contatoAlterado.setDestino(req.getParameter("destino"));
		contatoAlterado.setData_destino(req.getParameter("data_destino"));
		contatoAlterado.setOrigem(req.getParameter("origem"));
		contatoAlterado.setData_origem(req.getParameter("data_origem"));
		contatoAlterado.setId(Integer.parseInt(req.getParameter("id")));
		
		ContatoDAO cd = new ContatoDAO();
		cd.update(contatoAlterado);	
		resp.sendRedirect("home");
	}

}
