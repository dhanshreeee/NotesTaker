package com.todo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.notes.entities.Note;
import com.notes.helper.FactoryProvider;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	try {
	   int note_id = Integer.parseInt(request.getParameter("note_id").trim());
	   System.out.println(note_id);
	   SessionFactory sf = FactoryProvider.getSessionFactory();
	   Session s = sf.openSession();
	   Transaction tx = s.beginTransaction();
	   Note note = s.get(Note.class, note_id);
	   
	   s.delete(note);
	   tx.commit();
	   s.close();
	   response.sendRedirect("show_notes.jsp");
	}
	catch (Exception e) {

		e.printStackTrace();
	}	
	}


}
