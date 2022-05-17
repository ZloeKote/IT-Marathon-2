package entity;

public class Handler {
	private int id;
	private String name;
	private String surname;
	private String email;
	private int idticket;
	private String userEmail;
	
	public Handler(int id, String name, String surname, String email, int idticket, String userEmail) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.idticket = idticket;
		this.userEmail = userEmail;
	}
	
	public Handler(int id, String name, String surname, String email, int idticket) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.idticket = idticket;
	}
	
	public Handler(String name, String surname, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
	}
	
	public Handler(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public Handler() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdticket() {
		return idticket;
	}

	public void setIdticket(int idticket) {
		this.idticket = idticket;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
