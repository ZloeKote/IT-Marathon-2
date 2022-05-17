package entity;

public class Game {
	private int id;
	private String name;
	private String form_name;
	
	public Game(int id, String name, String form_name) {
		this.id = id;
		this.name = name;
		this.form_name = form_name;
	}
	
	public Game(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Game(String name, String form_name) {
		this.name = name;
		this.form_name = form_name;
	}
	
	public Game(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getForm_name() {
		return form_name;
	}
	
}
