package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ViagensDAO;

@SuppressWarnings("serial")
@WebServlet("/excluir")
public class ExcluirContatoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_viagens = Integer.parseInt(req.getParameter("id_viagens"));
//		Contato contatoExcluido = new Contato();
//		contatoExcluido.setId(idContato);

		ViagensDAO cdao = new ViagensDAO();

		cdao.removeById(id_viagens);

		resp.sendRedirect("home");
	}

}
