package com.todo.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.Session;


import com.notes.entities.Note;
import com.notes.helper.FactoryProvider;

/**
 * Servlet implementation class CreateNoteServlet
 */
public class CreateNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("note_title");
		String content = request.getParameter("note_content");
		
		SessionFactory  sf = FactoryProvider.getSessionFactory();
		Session s = (Session) sf.openSession();
		
		Note note = new Note(title,content, new Date());
		
		
		Transaction tx = s.beginTransaction();
		s.save(note);
	 
	
		tx.commit();
		s.close();
		System.out.println("Note saved successfully");
		
		
		response.sendRedirect("show_notes.jsp");
		
		//doGet(request, response);
//		response.sendRedirect("show_notes.jsp");
	}

}
