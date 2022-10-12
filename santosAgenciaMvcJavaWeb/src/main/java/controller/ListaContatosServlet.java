package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Viagens;
import model.ViagensDAO;

@SuppressWarnings("serial")
@WebServlet("/home")
public class ListaContatosServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Viagens> agenda = new ArrayList<Viagens>();
		ViagensDAO cdao = new ViagensDAO();		
		agenda = cdao.getviagenss();		
		req.setAttribute("listaContatos", agenda);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cadastro.jsp");
		dispatcher.forward(req, resp);
	}

}
