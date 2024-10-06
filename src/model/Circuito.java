package model;

public class Circuito {
	
	private String Nome;
	private float Lunghezza;
	private String Paese;
	private int Curve;
	
	public int getCurve() {
		return Curve;
	}
	public void setCurve(int curve) {
		Curve = curve;
	}
	public String getPaese() {
		return Paese;
	}
	public void setPaese(String paese) {
		Paese = paese;
	}
	public float getLunghezza() {
		return Lunghezza;
	}
	public void setLunghezza(float lunghezza) {
		Lunghezza = lunghezza;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Circuito() {
		super();
	}
	public Circuito(String nome, float lunghezza, String paese, int curve) {
		super();
		Nome = nome;
		Lunghezza = lunghezza;
		Paese = paese;
		Curve = curve;
	}
	@Override
	public String toString() {
		return "Circuito: " + Nome + "\tLunghezza: " + Lunghezza + "      Paese: " + Paese + "\tCurve: " + Curve;
	}
	
	

}
