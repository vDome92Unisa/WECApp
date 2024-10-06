package dataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

public class DaoCostruttore implements Dao {
	
	@Override
	public List<Costruttore> getCostruttore() {
		
		List<Costruttore> Costruttori = new ArrayList<Costruttore>();
		
		String sql = "select * from costruttore";
		
		try(Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
				PreparedStatement pr = conn.prepareStatement(sql);
				){
			
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
				
				Costruttori.add(new Costruttore(rs.getString("ragionesociale"), rs.getString("sede"), rs.getString("nome")));
			}
			
			rs.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return Costruttori;
	}
	
	public void insertCostruttore(Costruttore nuovoCostruttore) {
	    
		String sql = "INSERT INTO costruttore (ragionesociale, sede, nome) VALUES (?, ?, ?)";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, nuovoCostruttore.getRagioneSociale());
	        pr.setString(2, nuovoCostruttore.getSede());
	        pr.setString(3, nuovoCostruttore.getNome());

	        pr.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
public boolean checkCostruttore(String costruttore) {
		
		String sql = "SELECT * FROM costruttore WHERE nome = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, costruttore);
	        
	        ResultSet rs = pr.executeQuery();

	        return rs.next();

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public List<Scuderia> getScuderia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vettura> getVettura() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gara> getGara() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Circuito> getCircuito() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pilota> getPilota() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Componente> getComponente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipaggio> getEquipaggio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Finanziamento> getFinanziamento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornitura> getFornitura() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Iscrizione> getIscrizione() {
		// TODO Auto-generated method stub
		return null;
	}
}