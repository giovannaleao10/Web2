package br.edu.ifspcjo.ads.web2.project3.controller;

import java.io.IOException;
import java.util.List;

import br.edu.ifspcjo.ads.web2.project3.model.Person;
import br.edu.ifspcjo.ads.web2.project3.model.PersonUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public PersonServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String peopleData = req.getParameter("people");
		PersonUtil util = new PersonUtil();
		List<Person> peopleList = util.getPeopleList(peopleData);
		req.setAttribute("peoplelist", peopleList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/result.jsp");
		dispatcher.forward(req,resp);
	}
}
