
import java.io.IOException;
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


@WebServlet("/adminmenu")
public class AdminMenu extends HttpServlet {
	private IDBControl dbc = DBFactory.getDAOInstance(TypeDB.MySQL);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Game> games = new ArrayList<Game>();
			List<Pet> pets = new ArrayList<Pet>();
			games = dbc.getGames();
			pets = dbc.getPets();
	        request.setAttribute("allGames", games);
	        request.setAttribute("allPets", pets);
			}
			catch (Exception ex) {
				System.out.println(ex);
			}
	        RequestDispatcher requestDispatcher = request.getRequestDispatcher("templates/AdminMenu.jsp");
	        requestDispatcher.forward(request, response);  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String whatDo = request.getParameter("button");
		Game game = new Game(request.getParameter("value"), request.getParameter("form_name"));
		Pet pet = new Pet(request.getParameter("value"), request.getParameter("form_name"));
		try {
		switch(whatDo) {
		case "add_game": 
			dbc.AddGame(game);
			break;
		case "add_pet": 
			dbc.AddPet(pet);
			break;
		case "delete_game": 
			dbc.DeleteGame(game);
			break;
		case "delete_pet": 
			dbc.DeletePet(pet);
			break;
		}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		doGet(request, response);
	}

}
