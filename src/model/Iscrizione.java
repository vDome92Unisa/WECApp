package model;

public class Iscrizione {
	
	private String NomeGara;
	private int NumeroVettura;
	private int Punti;
	private String MotivoRitiro;
	
	public String getNomeGara() {
		return NomeGara;
	}
	public void setNomeGara(String nomeGara) {
		NomeGara = nomeGara;
	}
	public int getNumeroVettura() {
		return NumeroVettura;
	}
	public void setNumeroVettura(int numeroVettura) {
		NumeroVettura = numeroVettura;
	}
	public int getPunti() {
		return Punti;
	}
	public void setPunti(int punti) {
		Punti = punti;
	}
	public String getMotivoRitiro() {
		return MotivoRitiro;
	}
	public void setMotivoRitiro(String motivoRitiro) {
		MotivoRitiro = motivoRitiro;
	}
	public Iscrizione() {
		super();
	}
	public Iscrizione(String nomeGara, int numeroVettura, int punti, String motivoRitiro) {
		super();
		NomeGara = nomeGara;
		NumeroVettura = numeroVettura;
		Punti = punti;
		MotivoRitiro = motivoRitiro;
	}
	@Override
	public String toString() {
		return "Gara: " + NomeGara + ", NumeroVettura: " + NumeroVettura + ", Punti: " + Punti
				+ ", MotivoRitiro: " + MotivoRitiro + "";
	}
}
