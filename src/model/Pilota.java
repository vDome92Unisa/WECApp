package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pilota {
	
	private String Nome;
	private String Cognome;
	private String Nazionalità;
	private String ID_Equipaggio;
	private Date DataNascita;
	private String TipoPilota;
	private Date Primalicenza;
	private Integer NumeroLicenze;
	private String Scuderia;
	private List<String> circuitiVinti;
	
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
	public String getNazionalità() {
		return Nazionalità;
	}
	public void setNazionalità(String nazionalità) {
		Nazionalità = nazionalità;
	}
	public String getID_Equipaggio() {
		return ID_Equipaggio;
	}
	public void setID_Equipaggio(String iD_Equipaggio) {
		ID_Equipaggio = iD_Equipaggio;
	}
	public String getTipoPilota() {
		return TipoPilota;
	}
	public void setTipoPilota(String tipoPilota) {
		TipoPilota = tipoPilota;
	}
	public Date getPrimalicenza() {
		return Primalicenza;
	}
	public void setPrimalicenza(Date primalicenza) {
		Primalicenza = primalicenza;
	}
	public Integer getNumeroLicenze() {
		return NumeroLicenze;
	}
	public void setNumeroLicenze(Integer numeroLicenze) {
		NumeroLicenze = numeroLicenze;
	}
	public String getScuderia() {
		return Scuderia;
	}
	public void setScuderia(String scuderia) {
		Scuderia = scuderia;
	}
	public Pilota() {
		super();
	}
	public Pilota(String nome, String cognome, String nazionalità, Date data, String iD_Equipaggio, String tipoPilota,
			Date primalicenza, int numeroLicenze, String scuderia) {
		super();
		Nome = nome;
		Cognome = cognome;
		Nazionalità = nazionalità;
		DataNascita = data;
		ID_Equipaggio = iD_Equipaggio;
		TipoPilota = tipoPilota;
		Primalicenza = primalicenza;
		NumeroLicenze = numeroLicenze;
		Scuderia = scuderia;
		this.circuitiVinti = new ArrayList<>();
	}
	@Override
	public String toString() {
		return "Nome: " + Nome + "   Cognome: " + Cognome + "     Nazionalità: " + Nazionalità + "     Data di Nascita: " + DataNascita + ",\n      ID_Equipaggio: "
				+ ID_Equipaggio + "   TipoPilota: " + TipoPilota + "   Primalicenza: " + Primalicenza + "  NumeroLicenze: "
				+ NumeroLicenze + "  Scuderia: " + Scuderia + "\n";
	}
	public Date getDataNascita() {
		return DataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		DataNascita = dataNascita;
	}
	
	public void aggiungiCircuitiVinti(List<String> circuiti) {
        circuitiVinti.addAll(circuiti);
    }
	
	public List<String> getCircuitiVinti() {
        return circuitiVinti;
    }

    
	
	

}
