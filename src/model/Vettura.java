package model;

import java.util.Date;

public class Vettura {
	
	private int NumeroVettura;
	private String Modello;
	private String Scuderia;
	private Date DataAcquisto;
	
	public int getNumeroVettura() {
		return NumeroVettura;
	}
	public void setNumeroVettura(int numeroVettura) {
		NumeroVettura = numeroVettura;
	}
	public String getModello() {
		return Modello;
	}
	public void setModello(String modello) {
		Modello = modello;
	}
	public String getScuderia() {
		return Scuderia;
	}
	public void setScuderia(String scuderia) {
		Scuderia = scuderia;
	}
	public Date getDataAcquisto() {
		return DataAcquisto;
	}
	public void setDataAcquisto(Date dataAcquisto) {
		DataAcquisto = dataAcquisto;
	}
	public Vettura() {
		super();
	}
	public Vettura(int numeroVettura, String modello, String scuderia, Date dataAcquisto) {
		super();
		NumeroVettura = numeroVettura;
		Modello = modello;
		Scuderia = scuderia;
		DataAcquisto = dataAcquisto;
	}
	@Override
	public String toString() {
		return "Numero: " + NumeroVettura + "\t  Modello:" + Modello + "\tScuderia:" + Scuderia
				+ "   DataAcquisto: " + DataAcquisto;
	}
	
	

}
