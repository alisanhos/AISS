package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.repository.ContactRepository;

/**
 * Servlet implementation class ContactDeleteController
 */
public class ContactDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(ContactUpdateController.class.getName());
	
    public ContactDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id= request.getParameter("id");
		if(id!=null && !"".contentEquals(id)) {

		ContactRepository cr=ContactRepository.getInstance();
		cr.deleteContact(id);
		log.info("el contacto se ha borrado");
		request.setAttribute("message", "Contact deleted successfully");
		}
		request.getRequestDispatcher("/").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
