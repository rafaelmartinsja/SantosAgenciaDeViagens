package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Viagens;
import model.ViagensDAO;

@SuppressWarnings("serial")
@WebServlet("/editar")
public class AlterarContatoServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_viagens = Integer.parseInt(req.getParameter("id"));
		ViagensDAO cdao = new ViagensDAO();
		Viagens contatoSelecionado = cdao.getviagensById(id_viagens);

		req.setAttribute("contato", contatoSelecionado);
	
		RequestDispatcher rd = req.getRequestDispatcher("/alterarContato.jsp");

        rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Viagens contatoAlterado = new Viagens();		
		contatoAlterado.setOrigem_viagens(req.getParameter("origem_viagens"));
		contatoAlterado.setOrigem_viagens(req.getParameter("data_origem_viagens"));
		contatoAlterado.setDestino_viagens(req.getParameter("destino_viagens"));
		contatoAlterado.setOrigem_viagens(req.getParameter("data_origem_viagens"));
		contatoAlterado.setId_viagens(Integer.parseInt(req.getParameter("id_viagens")));
				
		ViagensDAO cd = new ViagensDAO();
		cd.update(contatoAlterado);	
		resp.sendRedirect("home");
	}

}
