package br.com.albuquerque.alexandre.desafiob2w.model;

public class Habilidades {
	
	private String name;
	private float value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getValue() {
		return value * 100;
	}
	public void setValue(float value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Habilidades [name=" + name + ", value=" + value + "]";
	}
	
}
