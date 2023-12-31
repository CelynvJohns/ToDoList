package controllerToDoList;

/**
 * @author valei - vlunderwood CIS175 - Fall 2023 Oct 06, 2023
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.ToDoListHelper;
import model.ToDoList;

/**
 * Servlet implementation class DeleteToDoList
 */
@WebServlet("/deleteToDoList")
public class DeleteToDoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteToDoList() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ToDoListHelper helper = new ToDoListHelper();
		String title = request.getParameter("title");
		ToDoList deleteThis = helper.searchToDoListByTitle(title);
		helper.delete(deleteThis);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	
	}

}
