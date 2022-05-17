import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Handler;
import dbcontrol.*;

@WebServlet("/operatormenu")
public class SelectOperator extends HttpServlet {
	private IDBControl dbc = DBFactory.getDAOInstance(TypeDB.MySQL);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		List<Handler> handlers;
		handlers = dbc.getHandlers();
        request.setAttribute("allHandlers", handlers);
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("templates/SelectOperator.jsp");
        requestDispatcher.forward(request, response);
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Handler handler = new Handler();
		if (request.getParameter("button") != null) {
			String whatDo = request.getParameter("button");
		
		if (whatDo.equals("add")) {
		handler.setName(request.getParameter("name"));
		handler.setSurname(request.getParameter("surname"));
		handler.setEmail(request.getParameter("email"));
		try {
			dbc.addHandler(handler);
			}
			catch (Exception ex) {
				System.out.println(ex);
			}
		}
		else if (whatDo.equals("delete")){
			handler.setEmail(request.getParameter("email"));
			try {
				dbc.DeleteHandler(handler);
				}
				catch (Exception ex) {
					System.out.println(ex);
				}
		}
		}
		else if (request.getParameter("button-delete") != null) {
			try {
				handler.setEmail(request.getParameter("button-delete"));
				dbc.DeleteHandler(handler);
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
			else if (request.getParameter("button-done") != null) {
				try {
					int idticket = Integer.parseInt(request.getParameter("button-done"));
					dbc.closeTicket(idticket);
				} catch (Exception ex) {
					System.out.println(ex);
				}
		}
		doGet(request, response);
	}

}
