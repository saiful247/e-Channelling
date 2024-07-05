package net.labtest.usermanagement.web;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import net.javaguides.usermanagement.model.User;
//import net.javaguides.usermanagement.model.User;
import net.labtest.usermanagement.dao.LabTestDAO;
import net.labtest.usermanagement.model.LabTest;

/**
 * Servlet implementation class LabTestServlet
 */
@WebServlet("/")
//inheritance
public class LabTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LabTestDAO labtestDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LabTestServlet() {
       this.labtestDAO = new LabTestDAO();
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			try {
				insertLabTest(request, response);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteLabTest(request, response);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/edit":
			try {
				showEditForm(request, response);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/update":
			try {
				updateLabTest(request, response);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			try {
				listLabTest(request, response);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("labtest-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertLabTest(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String area = request.getParameter("area");
		String lab = request.getParameter("lab");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		LabTest newLabTest = new LabTest(name, area, lab, email, phone);
		labtestDAO.insertLabTest(newLabTest);
		response.sendRedirect("list");
	}
	
	private void deleteLabTest(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		labtestDAO.deleteLabTest(id);
		response.sendRedirect("list");

	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		LabTest existingUser = labtestDAO.selectLabTest(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("labtest-form.jsp");
		request.setAttribute("labtest", existingUser);
		dispatcher.forward(request, response);

	}
	
	private void updateLabTest(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String area = request.getParameter("area");
		String lab = request.getParameter("lab");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		LabTest labtest = new LabTest(id, name, area, lab, email, phone);
		labtestDAO.updateLabTest(labtest);
		response.sendRedirect("list");
	}
	
	private void listLabTest(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<LabTest> listLabTest = labtestDAO.selectAllLabTests();
		request.setAttribute("listLabTest", listLabTest);
		RequestDispatcher dispatcher = request.getRequestDispatcher("labtest-list.jsp");
		dispatcher.forward(request, response);
	}
	

}
