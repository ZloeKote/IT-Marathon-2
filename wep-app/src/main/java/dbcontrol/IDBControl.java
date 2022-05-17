package dbcontrol;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import entity.*;

public interface IDBControl {
	public List<Handler> getHandlers() 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;
	
	public List<Ticket> getTickets() 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;
	
	public List<Game> getGames() 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;
	
	public List<Pet> getPets() 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;
	
	public List<Ticket> getTicketsByUserEmail(String email) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;
	
	public List<Ticket> getTicketsByHandlerEmail(String email) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;
	
	public List<Ticket> getTicketsByStatus(String status) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;
	
	public void addHandler(Handler handler) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;
	
	public void addTicket(Ticket ticket) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;
	
	public void AddUser(User user) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;
	
	public void AddGame(Game game) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;
	
	public void AddPet(Pet pet) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;
	
	public void DeleteHandler(Handler handler) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;
	
	public void DeleteGame(Game game) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;

	public void DeletePet(Pet pet) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;
	
	public void closeTicket(int idticket) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
			NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;
}
