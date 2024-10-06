package model;

public class Costruttore {
	
	private String RagioneSociale;
	private String Sede;
	private String Nome;
	
	public String getRagioneSociale() {
		return RagioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		RagioneSociale = ragioneSociale;
	}
	public String getSede() {
		return Sede;
	}
	public void setSede(String sede) {
		Sede = sede;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Costruttore() {
		super();
	}
	public Costruttore(String ragioneSociale, String sede, String nome) {
		super();
		RagioneSociale = ragioneSociale;
		Sede = sede;
		Nome = nome;
	}
	@Override
	public String toString() {
		return "Costruttore: " + RagioneSociale + "\tSede: " + Sede + "        Nome: " + Nome;
	}
	

}
