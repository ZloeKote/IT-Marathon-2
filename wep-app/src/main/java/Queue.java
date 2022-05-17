import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcontrol.DBFactory;
import dbcontrol.IDBControl;
import dbcontrol.TypeDB;
import entity.*;

@WebServlet("/queue")
public class Queue extends HttpServlet {
	private IDBControl dbc = DBFactory.getDAOInstance(TypeDB.MySQL);
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Ticket> tickets;
			String whatSearch = request.getParameter("button-sort");
			
			
			if (request.getParameter("search-user-email") != null) {
				tickets = dbc.getTicketsByUserEmail(request.getParameter("search-user-email"));
			}
			else if (request.getParameter("search-handler-email") != null) {
				tickets = dbc.getTicketsByHandlerEmail(request.getParameter("search-handler-email"));
			}
			else if (whatSearch != null) {
				tickets = dbc.getTicketsByStatus(whatSearch);
			}
			else {
				tickets = dbc.getTickets();
			}
			request.setAttribute("allTickets", tickets);
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("templates/Queue.jsp");
        requestDispatcher.forward(request, response);          
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
