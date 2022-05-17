

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

import dbcontrol.DBFactory;
import dbcontrol.IDBControl;
import dbcontrol.TypeDB;
import entity.*;

@WebServlet("")
public class Main extends HttpServlet {
	private IDBControl dbc = DBFactory.getDAOInstance(TypeDB.MySQL);
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("email") != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/templates/indexComplete.html");
	        requestDispatcher.forward(request, response);
		}
		else {
			List<Game> games; List<Pet> pets;
			try {
			games = dbc.getGames();
			pets = dbc.getPets();
			request.setAttribute("allGames", games);
			request.setAttribute("allPets", pets);
			}
			catch (Exception ex) {
				System.out.println(ex);
			}
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
	        requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User(request.getParameter("name"), request.getParameter("email"));
		Game game = new Game(request.getParameter("game"));
		Pet pet = new Pet(request.getParameter("pet"));
		Ticket ticket = new Ticket("NEW", user, game, pet);
		try {
		dbc.addTicket(ticket);
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		doGet(request, response);
	}

}
