package dbcontrol;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.*;

public class MySqlControl implements IDBControl {
	
	private static String GET_TICKETS = "SELECT t.idticket, t.status, u.name, u.email, h.name, h.surname, h.email, g.form_name, p.name FROM ticket t "
			+ "JOIN user u ON iduser = user_iduser "
			+ "LEFT OUTER JOIN handler h ON handler_id = h.id "
			+ "JOIN game g ON g.id = t.game_id "
			+ "JOIN pet p ON p.id = t.pet_id ORDER BY t.status desc, t.idticket";
	
	private static String GET_TICKETS_BY_HANDLER = "SELECT * FROM ticket WHERE handler_id = ?";
	
	private static String GET_NEW_TICKETS_NO_HANDLER = "SELECT * FROM ticket WHERE status = 'NEW' AND handler_id IS null;";
	private static String GET_FREE_HANDLERS = "SELECT * FROM handler WHERE id NOT IN (SELECT handler_id FROM ticket WHERE status = 'INPROGRESS');";
	
	private static String GET_HANDLERS = "SELECT h.id, h.name, h.surname, h.email, t.idticket FROM handler h LEFT OUTER JOIN ticket t ON h.id = t.handler_id AND t.status = 'INPROGRESS'";
	private static String GET_USER_EMAIL_BY_STATUS_IDTICKET = "SELECT u.email FROM user u JOIN ticket t ON u.iduser = t.user_iduser WHERE t.status = 'INPROGRESS' AND t.idticket = ?;";
	
	private static String GET_GAMES = "SELECT * FROM game WHERE form_name != '';";
	
	private static String GET_PETS = "SELECT * FROM pet WHERE form_name != '';";
	
	private static String GET_TICKETS_BY_USER_EMAIL = "SELECT t.idticket, t.status, u.name, u.email, h.name, h.surname, h.email, g.form_name, p.name FROM ticket t "
			+ "JOIN user u ON iduser = user_iduser "
			+ "LEFT OUTER JOIN handler h ON handler_id = h.id "
			+ "JOIN game g ON g.id = t.game_id "
			+ "JOIN pet p ON p.id = t.pet_id WHERE u.email = ? ORDER BY t.status desc, t.idticket";
	
	private static String GET_TICKETS_BY_HANDLER_EMAIL = "SELECT t.idticket, t.status, u.name, u.email, h.name, h.surname, h.email, g.form_name, p.name FROM ticket t "
			+ "JOIN user u ON iduser = user_iduser "
			+ "LEFT OUTER JOIN handler h ON handler_id = h.id "
			+ "JOIN game g ON g.id = t.game_id "
			+ "JOIN pet p ON p.id = t.pet_id WHERE h.email = ? ORDER BY t.status desc, t.idticket";
	
	private static String GET_TICKETS_BY_STATUS = "SELECT t.idticket, t.status, u.name, u.email, h.name, h.surname, h.email, g.form_name, p.name FROM ticket t "
			+ "JOIN user u ON iduser = user_iduser "
			+ "LEFT OUTER JOIN handler h ON handler_id = h.id "
			+ "JOIN game g ON g.id = t.game_id "
			+ "JOIN pet p ON p.id = t.pet_id WHERE t.status = ? ORDER BY t.idticket";
	
	private static String ADD_HANDLER = "INSERT handler(name, surname, email) VALUES (?, ?, ?);";
	
	private static String ADD_TICKET = "INSERT ticket(status, user_iduser, game_id, pet_id) "
			+ "VALUES (\"NEW\", (SELECT iduser FROM user u WHERE u.name = ?), "
			+ "(SELECT g.id FROM game g WHERE g.name = ?), (SELECT p.id FROM pet p WHERE p.name = ?));";
	
	private static String ADD_USER = "INSERT user(name, email) VALUES (?, ?);";
	
	private static String ADD_GAME = "INSERT game(name, form_name) VALUES (?, ?);";
	
	private static String ADD_PET = "INSERT pet(name, form_name) VALUES (?, ?)";
	
	private static String SET_HANDLER_TO_TICKET = "UPDATE ticket SET handler_id = (SELECT MIN(h.id) FROM handler h "
			+ "WHERE h.id NOT IN (SELECT * FROM (SELECT t.handler_id FROM ticket t WHERE status = 'INPROGRESS') t1)), "
			+ "status = 'INPROGRESS' "
			+ "WHERE idticket = (SELECT * FROM(SELECT MIN(t.idticket) FROM ticket t WHERE t.status = 'NEW') t2);";
	
	private static String SET_TICKET_TO_DONE = "UPDATE ticket SET status = 'CLOSED' WHERE idticket = ?;";
	
	private static String DELETE_HANDLER = "DELETE FROM handler WHERE email = ?;";
	
	private static String DELETE_GAME = "UPDATE game SET form_name = '' WHERE name = ?;";
	
	private static String DELETE_PET = "UPDATE pet SET form_name = '' WHERE name = ?;";
	
	private static String DELETE_HANDLER_ID_FROM_CLOSED_TICKETS = "UPDATE ticket SET handler_id = null WHERE handler_id = (SELECT id FROM handler WHERE email = ?) AND status = 'CLOSED'";
	private static String DELETE_HANDLER_ID_FROM_INPROGRESS_TICKET = "UPDATE ticket SET handler_id = null, status = 'NEW' WHERE handler_id = (SELECT id FROM handler WHERE email = ?) AND status = 'INPROGRESS'";
	
	private static Connection con = null;
    public MySqlControl() throws SQLException {
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        	con = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException ex) {
        	System.out.println(ex);
        }
        catch (Exception ex ) {
        	System.out.println(ex);
        }
    }
    
    public List<Handler> getHandlers() throws InstantiationException, IllegalAccessException, IllegalArgumentException, 
    InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
    	con = null;
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, username, password);
        
        List<Handler> handlers = new ArrayList<Handler>();
        Statement statement = con.createStatement();
        PreparedStatement ps;
    	ResultSet resultSet = statement.executeQuery(GET_HANDLERS);
    	while(resultSet.next()){
    		Handler handler = new Handler(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5));
    		ps = con.prepareStatement(GET_USER_EMAIL_BY_STATUS_IDTICKET);
    		ps.setInt(1, handler.getIdticket());
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()) {
    			handler.setUserEmail(rs.getString(1));
    		}
    		handlers.add(handler);
    	}
    	con.close();
        return handlers;
    }
    public List<Ticket> getTickets() throws InstantiationException, IllegalAccessException, IllegalArgumentException, 
    InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
    	con = null;
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, username, password);
        
        List<Ticket> tickets = new ArrayList<Ticket>();
        Statement statement = con.createStatement();
    	ResultSet resultSet = statement.executeQuery(GET_TICKETS);
    	while(resultSet.next()){
    		User user = new User(resultSet.getString(3), resultSet.getString(4));
    		Handler handler = new Handler(resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
    		Game game = new Game(resultSet.getString(8));
        	Pet pet = new Pet(resultSet.getString(9));
    		Ticket ticket = new Ticket(resultSet.getInt(1), resultSet.getString(2), handler, user, game, pet);
    		tickets.add(ticket);
    	}
    	con.close();
        return tickets;
    }
    public List<Game> getGames() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
    	con = null;
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, username, password);
        
        List<Game> games = new ArrayList<Game>();
        Statement statement = con.createStatement();
    	ResultSet resultSet = statement.executeQuery(GET_GAMES);
        while(resultSet.next()){
    		Game game = new Game(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
    		games.add(game);
    	}
        con.close();
        return games;
    }
    
    public List<Pet> getPets() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
    	con = null;
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, username, password);
        
        List<Pet> pets = new ArrayList<Pet>();
        Statement statement = con.createStatement();
    	ResultSet resultSet = statement.executeQuery(GET_PETS);
        while(resultSet.next()){
    		Pet pet = new Pet(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
    		pets.add(pet);
    	}
        con.close();
        return pets;
    }
    
    public List<Ticket> getTicketsByUserEmail(String email) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
    	con = null;
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, username, password);
        
        List<Ticket> tickets = new ArrayList<Ticket>();
        PreparedStatement ps;
    	ps = con.prepareStatement(GET_TICKETS_BY_USER_EMAIL);
    	ps.setString(1, email);
    	ResultSet resultSet = ps.executeQuery();
    	while(resultSet.next()){
    		User user = new User(resultSet.getString(3), resultSet.getString(4));
    		Handler handler = new Handler(resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
    		Game game = new Game(resultSet.getString(8));
        	Pet pet = new Pet(resultSet.getString(9));
    		Ticket ticket = new Ticket(resultSet.getInt(1), resultSet.getString(2), handler, user, game, pet);
    		tickets.add(ticket);
    	}
    	con.close();
    	return tickets;
    }
    
    public List<Ticket> getTicketsByHandlerEmail(String email) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
    	con = null;
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, username, password);
        
        List<Ticket> tickets = new ArrayList<Ticket>();
        PreparedStatement ps;
    	ps = con.prepareStatement(GET_TICKETS_BY_HANDLER_EMAIL);
    	ps.setString(1, email);
    	ResultSet resultSet = ps.executeQuery();
    	while(resultSet.next()){
    		User user = new User(resultSet.getString(3), resultSet.getString(4));
    		Handler handler = new Handler(resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
    		Game game = new Game(resultSet.getString(8));
        	Pet pet = new Pet(resultSet.getString(9));
    		Ticket ticket = new Ticket(resultSet.getInt(1), resultSet.getString(2), handler, user, game, pet);
    		tickets.add(ticket);
    	}
    	con.close();
    	return tickets;
    }
    
    public List<Ticket> getTicketsByStatus(String status) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
    	con = null;
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, username, password);
        
        List<Ticket> tickets = new ArrayList<Ticket>();
        PreparedStatement ps;
    	ps = con.prepareStatement(GET_TICKETS_BY_STATUS);
    	ps.setString(1, status);
    	ResultSet resultSet = ps.executeQuery();
    	while(resultSet.next()){
    		User user = new User(resultSet.getString(3), resultSet.getString(4));
    		Handler handler = new Handler(resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
    		Game game = new Game(resultSet.getString(8));
        	Pet pet = new Pet(resultSet.getString(9));
    		Ticket ticket = new Ticket(resultSet.getInt(1), resultSet.getString(2), handler, user, game, pet);
    		tickets.add(ticket);
    	}
    	con.close();
    	return tickets;
    }
    
    public void addHandler(Handler handler) throws InstantiationException, IllegalAccessException, IllegalArgumentException, 
    InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
    	con = null;
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, username, password);
        
        PreparedStatement ps;
    	ps = con.prepareStatement(ADD_HANDLER);
    	ps.setString(1, handler.getName());
    	ps.setString(2, handler.getSurname());
    	ps.setString(3, handler.getEmail());
    	ps.executeUpdate();
    	
    	Statement st = con.createStatement();
    	if(st.execute(GET_NEW_TICKETS_NO_HANDLER))
    		st.executeUpdate(SET_HANDLER_TO_TICKET);
    
    	con.close();
    }

    
    public void addTicket(Ticket ticket) throws InstantiationException, IllegalAccessException, IllegalArgumentException, 
    InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
    	AddUser(ticket.getUser());

    	con = null;
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, username, password);

        PreparedStatement ps;
    	ps = con.prepareStatement(ADD_TICKET);
    	ps.setString(1, ticket.getUser().getName());
    	ps.setString(2, ticket.getGame().getName());
    	ps.setString(3, ticket.getPet().getName());
    	
    	ps.executeUpdate();
    	Statement st = con.createStatement();
    	ResultSet rs = st.executeQuery(GET_FREE_HANDLERS);
    	if(rs.next()) {
    		st.executeUpdate(SET_HANDLER_TO_TICKET);
    	}

        con.close();
    }
    
    public void AddUser(User user) throws InstantiationException, IllegalAccessException, IllegalArgumentException, 
    InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
    	con = null;
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, username, password);
        
        PreparedStatement ps;
    	ps = con.prepareStatement(ADD_USER);
    	ps.setString(1, user.getName());
    	ps.setString(2, user.getEmail());
    	
    	ps.executeUpdate();
    	
    	con.close();
    }
    
    public void AddGame(Game game) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
    	con = null;
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, username, password);
        
        PreparedStatement ps;
    	ps = con.prepareStatement(ADD_GAME);
    	ps.setString(1, game.getName());
    	ps.setString(2, game.getForm_name());
    	
    	ps.executeUpdate();
    	
    	con.close();
    }
    
    public void AddPet(Pet pet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
    	con = null;
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, username, password);
        
        PreparedStatement ps;
    	ps = con.prepareStatement(ADD_PET);
    	ps.setString(1, pet.getName());
    	ps.setString(2, pet.getForm_name());
    	
    	ps.executeUpdate();
    	
    	con.close();
    }
    
    public void DeleteHandler(Handler handler) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
    	con = null;
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, username, password);
        
        PreparedStatement ps;
        con.setAutoCommit(false);
        ps = con.prepareStatement(DELETE_HANDLER_ID_FROM_CLOSED_TICKETS);
        ps.setString(1, handler.getEmail());
        ps.executeUpdate();
        ps = con.prepareStatement(DELETE_HANDLER_ID_FROM_INPROGRESS_TICKET);
        ps.setString(1, handler.getEmail());
        ps.executeUpdate();
        ps = con.prepareStatement(DELETE_HANDLER);
        ps.setString(1, handler.getEmail());
        ps.executeUpdate();
        Statement st = con.createStatement();
    	ResultSet rs = st.executeQuery(GET_FREE_HANDLERS);
    	if(rs.next()) {
    		st.executeUpdate(SET_HANDLER_TO_TICKET);
    	}
        con.setAutoCommit(true);
        con.close();
    }
    
    public void DeleteGame(Game game) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
    	con = null;
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, username, password);
        
        PreparedStatement ps;
        ps = con.prepareStatement(DELETE_GAME);
        ps.setString(1, game.getName());
        ps.executeUpdate();
        
        con.close();
    }
    
    public void DeletePet(Pet pet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
    	con = null;
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, username, password);
        
        PreparedStatement ps;
        ps = con.prepareStatement(DELETE_PET);
        ps.setString(1, pet.getName());
        ps.executeUpdate();
        
        con.close();
    }
    
    public void closeTicket(int idticket) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
    	con = null;
    	String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "FB)tNdh%,?h5";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection(url, username, password);
        
        PreparedStatement ps;
        ps = con.prepareStatement(SET_TICKET_TO_DONE);
        ps.setInt(1, idticket);
        ps.executeUpdate();
        
        Statement st = con.createStatement();
    	if(st.execute(GET_NEW_TICKETS_NO_HANDLER))
    		st.executeUpdate(SET_HANDLER_TO_TICKET);
    	
        con.close();
    }
}
