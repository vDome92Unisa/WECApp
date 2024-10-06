package model;

public class Fornitura {
	
	private String Codice;
	private String RagioneSociale;
	private String Costruttore;
	private int NumeroComponente;
	
	
	public String getCodice() {
		return Codice;
	}
	public void setCodice(String codice) {
		Codice = codice;
	}
	public String getRagioneSociale() {
		return RagioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		RagioneSociale = ragioneSociale;
	}
	public int getNumeroComponente() {
		return NumeroComponente;
	}
	public void setNumeroComponente(int numeroComponente) {
		NumeroComponente = numeroComponente;
	}
	public Fornitura() {
		super();
	}
	public Fornitura(String codice, String ragioneSociale, String costruttore, int numeroComponente) {
		super();
		Codice = codice;
		RagioneSociale = ragioneSociale;
		Costruttore = costruttore;
		NumeroComponente = numeroComponente;
	}
	@Override
	public String toString() {
		return "Fornitura: " + Codice + ", RagioneSociale: " + RagioneSociale + ",Costruttore: " + Costruttore + " NumeroComponente: "
				+ NumeroComponente + "";
	}
	public String getCostruttore() {
		return Costruttore;
	}
	public void setCostruttore(String costruttore) {
		Costruttore = costruttore;
	}
	

}
