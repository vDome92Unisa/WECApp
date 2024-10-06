package model;

public class Scuderia {
	
	private String nome;
	private String sede;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public Scuderia() {
		super();
	}
	public Scuderia(String nome, String sede) {
		super();
		this.nome = nome;
		this.sede = sede;
	}
	public Scuderia(String sede) {
		super();
		this.sede = sede;
	}
	@Override
	public String toString() {
		return "Scuderia: " + nome + "\tSede: " + sede;
	}
	
}