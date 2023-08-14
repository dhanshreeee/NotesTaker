package com.todo.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.notes.entities.Note;
import com.notes.helper.FactoryProvider;

/**
 * Servlet implementation class UpdateNoteServlet
 */
public class UpdateNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newtitle = request.getParameter("note_title");
		String newcontent = request.getParameter("note_content");
		int note_id = Integer.parseInt(request.getParameter("note_id_hidden").trim());
//		Note Id field was kept as hidden on update_note.jsp page 
		//only with the sole purpose of sending 
		// its value to this servlet which is UpdateNoteServlet

		
		Session s = FactoryProvider.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		Note note= s.get(Note.class, note_id);
	
		note.setTitle(newtitle);
		note.setContent(newcontent);
		note.setCreateDate(new Date());
		
		tx.commit();
		
		s.close();
		response.sendRedirect("show_notes.jsp");
	}

}
