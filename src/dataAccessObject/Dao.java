package dataAccessObject;

import java.util.List;

import model.Circuito;
import model.Componente;
import model.Costruttore;
import model.Equipaggio;
import model.Finanziamento;
import model.Fornitura;
import model.Gara;
import model.Iscrizione;
import model.Pilota;
import model.Scuderia;
import model.Vettura;

public interface Dao {
	
	//Connessione al database
	public final static String DBADDRESS = "jdbc:mysql://localhost:3306/campionato?useSSL=false&serverTimezone=UTC";
	public final static String USER = "root";
	public final static String PWD = "Kiwi040619!";
	
	//L'obiettivo dell'interfaccia Dao è di fornire un'astrazione sul livello di accesso ai dati, 
	//in modo che il codice che utilizza queste operazioni non debba preoccuparsi di come vengono effettivamente implementate.
	//In altre parole, l'interfaccia definisce un contratto che tutte le classi DAO devono seguire,
	//ma non specifica come tali operazioni debbano essere implementate.
	
	public List<Scuderia> getScuderia();
	public List<Vettura> getVettura();
	public List<Gara> getGara();
	public List<Circuito> getCircuito();
	public List<Costruttore> getCostruttore();
	public List<Pilota> getPilota();
	public List<Componente> getComponente();
	public List<Equipaggio> getEquipaggio();
	public List<Finanziamento> getFinanziamento();
	public List<Fornitura> getFornitura();
	public List<Iscrizione> getIscrizione();
}
