package model;

public class Gara {
	
	private String Nome;
	private String NomeCircuito;
	private java.sql.Date Data;
	private String Durata;			//ore:minuti:secondi
	private String TipoGara;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getNomeCircuito() {
		return NomeCircuito;
	}
	public void setNomeCircuito(String nomeCircuito) {
		NomeCircuito = nomeCircuito;
	}
	public java.sql.Date getData() {
		return Data;
	}
	public void setData(java.sql.Date data) {
		Data = data;
	}
	public String getDurata() {
		return Durata;
	}
	public void setDurata(String durata) {
		Durata = durata;
	}
	public String getTipoGara() {
		return TipoGara;
	}
	public void setTipoGara(String tipoGara) {
		TipoGara = tipoGara;
	}
	public Gara() {
		super();
	}
	public Gara(String nome, String nomeCircuito, java.sql.Date data, String durata, String tipoGara) {
		super();
		Nome = nome;
		NomeCircuito = nomeCircuito;
		Data = data;
		Durata = durata;
		TipoGara = tipoGara;
	}
	@Override
	public String toString() {
		return "Gara: " + Nome + " - Nome Circuito: " + NomeCircuito + "\n      Data: " + Data + "    Durata: " + Durata
				+ "    TipoGara: " + TipoGara + "\n";
	}
	

}
