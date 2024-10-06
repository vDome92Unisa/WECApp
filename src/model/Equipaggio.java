package model;

public class Equipaggio {
	
	private String ID_equipaggio;
	private int NumeroVettura;
	private int NumeroComponenti;
	
	public String getID_equipaggio() {
		return ID_equipaggio;
	}
	public void setID_equipaggio(String id_equipaggio) {
		ID_equipaggio = id_equipaggio;
	}
	public int getNumeroVettura() {
		return NumeroVettura;
	}
	public void setNumeroVettura(int numeroVettura) {
		NumeroVettura = numeroVettura;
	}
	public int getNumeroComponenti() {
		return NumeroComponenti;
	}
	public void setNumeroComponenti(int numeroComponenti) {
		NumeroComponenti = numeroComponenti;
	}
	public Equipaggio() {
		super();
	}
	public Equipaggio(String iD_equipaggio, int numeroVettura, int numeroComponenti) {
		super();
		ID_equipaggio = iD_equipaggio;
		NumeroVettura = numeroVettura;
		NumeroComponenti = numeroComponenti;
	}
	@Override
	public String toString() {
		return "Equipaggio: " + ID_equipaggio + ", NumeroVettura: " + NumeroVettura + ", NumeroComponenti: "
				+ NumeroComponenti;
	}

}
