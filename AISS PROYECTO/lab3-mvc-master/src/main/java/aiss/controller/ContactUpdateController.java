package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Contact;
import aiss.model.repository.ContactRepository;

/**
 * Servlet implementation class DeleteContactController
 */
public class ContactUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(ContactUpdateController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactUpdateController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO
		String id=request.getParameter("id");
		ContactRepository cr= ContactRepository.getInstance();
		Contact contact=cr.getContact(id);
		
		request.setAttribute("contact", contact);
		request.getRequestDispatcher("/ContactEditView.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String id=request.getParameter("id");
		ContactRepository cr= ContactRepository.getInstance();
		Contact contact= cr.getContact(id);
		
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		contact.setName(name);
		contact.setTelephone(phone);
		
		request.setAttribute("message", "contact updated succesfully");
		request.getRequestDispatcher("/").forward(request, response);
		
	}

}
