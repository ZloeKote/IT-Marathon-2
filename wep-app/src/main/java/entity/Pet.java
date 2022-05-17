package entity;

public class Pet {
	private int id;
	private String name;
	private String form_name;
	
	public Pet(int id, String name, String form_name) {
		this.id = id;
		this.name = name;
		this.form_name = form_name;
	}
	
	public Pet(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Pet(String name, String form_name) {
		this.name = name;
		this.form_name = form_name;
	}
	
	public Pet(String name) {
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
