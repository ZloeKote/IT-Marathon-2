package entity;

public class Ticket {
	
	private static int counter;
	private int id;
	private String status = "NEW";
	private Handler handler;
	private User user;
	private Game game;
	private Pet pet;
	
	public Ticket(int id, String status, Handler handler, User user, Game game, Pet pet) {
		counter++;
		this.id = id;
		this.status = status;
		this.handler = handler;
		this.user = user;
		this.game = game;
		this.pet = pet;
	}
	
	public Ticket(int id, String status, User user, Game game, Pet pet) {
		counter++;
		this.id = id;
		this.status = status;
		this.user = user;
		this.game = game;
		this.pet = pet;
	}
	
	public Ticket(String status, Handler handler, User user, Game game, Pet pet) {
		counter++;
		this.status = status;
		this.handler = handler;
		this.user = user;
		this.game = game;
		this.pet = pet;
	}
	
	public Ticket(String status, User user, Game game, Pet pet) {
		counter++;
		this.status = status;
		this.user = user;
		this.game = game;
		this.pet = pet;
	}
	
	public Ticket(int id, User user, Game game, Pet pet) {
		counter++;
		this.id = id;
		this.user = user;
		this.game = game;
		this.pet = pet;
	}
	
	public Ticket() {
		
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public static int getCounter() {
		return counter;
	}

	public int getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public User getUser() {
		return user;
	}

	public Game getGame() {
		return game;
	}

	public Pet getPet() {
		return pet;
	}

	@Override
	public String toString() {
		if (handler == null)
			return "Id: " + id + ", status: " + status + " user: " + user.getName() + " game: " + game.getName() + " pet: " + pet.getName() + "; ";
		else 
			return "Id: " + id + ", status: " + status + " handler: " + handler.getName() + " " + handler.getSurname() + " user: " + user.getName() + " game: " + game.getName() + " pet: " + pet.getName() + "; ";
	}
}
