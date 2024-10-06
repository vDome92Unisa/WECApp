package model;

import dataAccessObject.DaoFinanziamento;

public class Finanziamento {
	
	private int generateNumeroFinanziamento(String nomeScuderia) {
        // Ottieni il contatore corrente per la scuderia specifica
        int numeroFinanziamentoCounter = DaoFinanziamento.numeroFinanziamentoCounters.getOrDefault(nomeScuderia, 1);

        // Incrementa il contatore per questa scuderia
        DaoFinanziamento.numeroFinanziamentoCounters.put(nomeScuderia, numeroFinanziamentoCounter + 1);

        // Restituisci il numero del finanziamento
        return numeroFinanziamentoCounter;
    }
	
	private String NomeScuderia;
	private String NomePilota;
	private String CognomePilota;
	private float Quota;
	private int NumeroFinanziamento;
	private java.sql.Date DataFinanziamento;
	
	public String getNomeScuderia() {
		return NomeScuderia;
	}
	public void setNomeScuderia(String nomeScuderia) {
		NomeScuderia = nomeScuderia;
	}
	public String getNomePilota() {
		return NomePilota;
	}
	public void setNomePilota(String nomePilota) {
		NomePilota = nomePilota;
	}
	public String getCognomePilota() {
		return CognomePilota;
	}
	public void setCognomePilota(String cognomePilota) {
		CognomePilota = cognomePilota;
	}
	public float getQuota() {
		return Quota;
	}
	public void setQuota(float quota) {
		Quota = quota;
	}
	public int getNumeroFinanziamento() {
		return NumeroFinanziamento;
	}
	public void setNumeroFinanziamento(int numeroFinanziamento) {
		NumeroFinanziamento = numeroFinanziamento;
	}
	public Finanziamento() {
		super();
	}
	public Finanziamento(String nomeScuderia, String nomePilota, String cognomePilota, float quota, java.sql.Date dataFinanziamento) {
		super();
		NomeScuderia = nomeScuderia;
		NomePilota = nomePilota;
		CognomePilota = cognomePilota;
		Quota = quota;
		DataFinanziamento = dataFinanziamento;
		NumeroFinanziamento = generateNumeroFinanziamento(nomeScuderia);
	}
	@Override
	public String toString() {
		return "Finanziamento: " + NomeScuderia + ", Nome Pilota: " + NomePilota + ", CognomePilota: "
				+ CognomePilota + ", Quota: " + Quota + ", Data Finanziamento" + DataFinanziamento;
	}
	public java.sql.Date getDataFinanziamento() {
		return DataFinanziamento;
	}
	public void setDataFinanziamento(java.sql.Date dataFinanziamento) {
		DataFinanziamento = dataFinanziamento;
	}

}
