package model;

import java.util.Date;

public class GentlemanDriver {
	
	private String Nome;
	private String Cognome;
	private Date DataNascita;
	private String ID_Equipaggio;
	private String Scuderia;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public Date getDataNascita() {
		return DataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		DataNascita = dataNascita;
	}
	public String getID_Equipaggio() {
		return ID_Equipaggio;
	}
	public void setID_Equipaggio(String iD_Equipaggio) {
		ID_Equipaggio = iD_Equipaggio;
	}
	public String getScuderia() {
		return Scuderia;
	}
	public void setScuderia(String scuderia) {
		Scuderia = scuderia;
	}
	public GentlemanDriver() {
		super();
	}
	public GentlemanDriver(String nome, String cognome, Date dataNascita, String iD_Equipaggio, String scuderia) {
		super();
		Nome = nome;
		Cognome = cognome;
		DataNascita = dataNascita;
		ID_Equipaggio = iD_Equipaggio;
		Scuderia = scuderia;
	}
	@Override
	public String toString() {
		return "Nome: " + Nome + ", Cognome: " + Cognome + ", DataNascita: " + DataNascita
				+ ", ID_Equipaggio: " + ID_Equipaggio + ", Scuderia: " + Scuderia + "";
	}
	
	

}
