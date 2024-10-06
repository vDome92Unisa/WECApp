package model;
import java.util.Date;

public class Componente {
	
	private String Codice;
	private int NumeroVettura;
	private String TipoComponente;
	private float Costo;
	private java.sql.Date DataInstallazione;
	private String Materiale;
	private Float Peso;
	private String Marce;
	private Integer Cilindrata;
	private String TipoMotore;
	private Integer Cilindri;
	
	public String getCodice() {
		return Codice;
	}
	public void setCodice(String codice) {
		Codice = codice;
	}
	public int getNumeroVettura() {
		return NumeroVettura;
	}
	public void setNumeroVettura(int numeroVettura) {
		NumeroVettura = numeroVettura;
	}
	public String getTipoComponente() {
		return TipoComponente;
	}
	public void setTipoComponente(String tipoComponente) {
		TipoComponente = tipoComponente;
	}
	public float getCosto() {
		return Costo;
	}
	public void setCosto(float costo) {
		Costo = costo;
	}
	public Date getDataInstallazione() {
		return DataInstallazione;
	}
	public void setDataInstallazione(java.sql.Date dataInstallazione) {
		DataInstallazione = dataInstallazione;
	}
	public String getMateriale() {
		return Materiale;
	}
	public void setMateriale(String materiale) {
		Materiale = materiale;
	}
	public float getPeso() {
	    return Peso != null ? Peso.floatValue() : 0.0f;
	}
	public void setPeso(float peso) {
		Peso = peso;
	}
	public String getMarce() {
	    return Marce;
	}
	public void setMarce(String marce) {
		Marce = marce;
	}
	public int getCilindrata() {
		return Cilindrata != null ? Cilindrata.intValue() : 0;
	}
	public void setCilindrata(int cilindrata) {
		Cilindrata = cilindrata;
	}
	public String getTipoMotore() {
		return TipoMotore;
	}
	public void setTipoMotore(String tipoMotore) {
		TipoMotore = tipoMotore;
	}
	public int getCilindri() {
		return Cilindri != null ? Cilindri.intValue() : 0;
	}
	public void setCilindri(int cilindri) {
		Cilindri = cilindri;
	}
	public Componente() {
		super();
	}
	public Componente(String codice, int numeroVettura, String tipoComponente, float costo, java.sql.Date dataInstallazione,
			String materiale, Float peso, String marce, Integer cilindrata, String tipoMotore, Integer cilindri) {
		super();
		this.Codice = codice;
		this.NumeroVettura = numeroVettura;
		this.TipoComponente = tipoComponente;
		this.Costo = costo;
		this.DataInstallazione = dataInstallazione;
		this.Materiale = materiale;
		this.Peso = peso;
		this.Marce = marce;
		this.Cilindrata = cilindrata;
		this.TipoMotore = tipoMotore;
		this.Cilindri = cilindri;
	}
	@Override
	public String toString() {
		return "Componente: " + Codice + ", NumeroVettura: " + NumeroVettura + ", TipoComponente: "
				+ TipoComponente + ",\nCosto: " + Costo + ", DataInstallazione: " + DataInstallazione + ", Materiale: "
				+ Materiale + ", Peso=" + Peso + ", Marce=" + Marce + ", Cilindrata=" + Cilindrata + ", TipoMotore="
				+ TipoMotore + ", Cilindri: " + Cilindri;
	}

}
