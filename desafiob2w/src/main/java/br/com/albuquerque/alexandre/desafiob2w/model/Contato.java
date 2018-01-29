package br.com.albuquerque.alexandre.desafiob2w.model;

public class Contato {
	
	private String tel;
	private String cel;
	private String address;
	private String website;
	private String mail;
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		this.cel = cel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "Contato [tel=" + tel + ", cel=" + cel + ", address=" + address
				+ ", website=" + website + ", mail=" + mail + "]";
	}
}
