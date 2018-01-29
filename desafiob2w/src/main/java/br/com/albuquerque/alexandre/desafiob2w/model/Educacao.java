package br.com.albuquerque.alexandre.desafiob2w.model;

public class Educacao {
	
	private String name;
	private String date;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Educacao [name=" + name + ", date=" + date + ", description="
				+ description + "]";
	}
	
	

}
