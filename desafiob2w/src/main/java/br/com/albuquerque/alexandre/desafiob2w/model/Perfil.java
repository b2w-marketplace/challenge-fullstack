package br.com.albuquerque.alexandre.desafiob2w.model;

import java.util.List;

public class Perfil {
	
	private String image;
	private String name;
	private String profession;
	private String description;
	private Contato contact;
	private List<Habilidades> skills;
	private List<Experiencia> experience;
	private List<Educacao> education;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Contato getContact() {
		return contact;
	}
	public void setContact(Contato contact) {
		this.contact = contact;
	}
	public List<Habilidades> getSkills() {
		return skills;
	}
	public void setSkills(List<Habilidades> skills) {
		this.skills = skills;
	}
	public List<Experiencia> getExperience() {
		return experience;
	}
	public void setExperience(List<Experiencia> experience) {
		this.experience = experience;
	}
	public List<Educacao> getEducation() {
		return education;
	}
	public void setEducation(List<Educacao> education) {
		this.education = education;
	}
	
	@Override
	public String toString() {
		return "Perfil [image=" + image + ", name=" + name + ", profession="
				+ profession + ", description=" + description + ", contact="
				+ contact + ", skills=" + skills + ", experience=" + experience
				+ ", education=" + education + "]";
	}
	
}
