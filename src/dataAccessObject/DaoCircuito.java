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

public class DaoCircuito implements Dao{
	
	@Override
	public List<Circuito> getCircuito() {
		
		List<Circuito> Circuiti = new ArrayList<Circuito>();
		
		String sql = "select * from circuito";
		
		try(Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
				PreparedStatement pr = conn.prepareStatement(sql);
				){
			
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
				
				Circuiti.add(new Circuito(rs.getString("nome"), rs.getFloat("lunghezza"), rs.getString("paese"), rs.getInt("numerocurve")));
			}
			
			rs.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return Circuiti;
	}
	
	public void insertCircuito(Circuito nuovoCircuito) {
		
			String sql = "INSERT INTO circuito (nome, lunghezza, paese, numerocurve) VALUES (?, ?, ?, ?)";

	        try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	             PreparedStatement pr = conn.prepareStatement(sql)) {

	            pr.setString(1, nuovoCircuito.getNome());
	            pr.setFloat(2, nuovoCircuito.getLunghezza());
	            pr.setString(3, nuovoCircuito.getPaese());
	            pr.setInt(4, nuovoCircuito.getCurve());

	            pr.executeUpdate();
	        
	       } catch (Exception e) {
	            e.printStackTrace();
	       }
	}
	
	public boolean checkCircuito(String circuito) {
	    String sql = "SELECT COUNT(*) FROM circuito WHERE nome = ?";
	    
	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, circuito);
	        
	        ResultSet rs = pr.executeQuery();
	        rs.next();
	        // Se il conteggio è maggiore di 0, il circuito esiste già
	        return rs.getInt(1) > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;  //false in caso di errore/eccezione
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
	public List<Costruttore> getCostruttore() {
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
