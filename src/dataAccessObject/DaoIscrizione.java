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

public class DaoIscrizione implements Dao {
	
	@Override
	public List<Iscrizione> getIscrizione() {
		
		List<Iscrizione> Iscrizioni = new ArrayList<Iscrizione>();
		
		String sql = "select * from iscrizione";
		
		try(Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
				PreparedStatement pr = conn.prepareStatement(sql);
				){
			
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
				
				Iscrizioni.add(new Iscrizione(rs.getString("nomegara_i"), rs.getInt("numerovettura_i"), rs.getInt("punti"), rs.getString("motivoritiro")));
			}
			
			rs.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return Iscrizioni;
	}
	
	public boolean checkIscrizione(Iscrizione iscrizione) {
	    
		String sql = "SELECT * FROM iscrizione WHERE numerovettura_i = ? AND nomegara_i = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setInt(1, iscrizione.getNumeroVettura());
	        pr.setString(2, iscrizione.getNomeGara());
	        

	        ResultSet rs = pr.executeQuery();

	        return rs.next(); 

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false; 
	    }
	}
	
	public boolean insertIscrizione(Iscrizione nuovaIscrizione) {
	    
		String sql = "INSERT INTO iscrizione (nomegara_i, numerovettura_i, punti, motivoritiro) VALUES (?, ?, ?, ?)";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, nuovaIscrizione.getNomeGara());
	        pr.setInt(2, nuovaIscrizione.getNumeroVettura());
	        pr.setInt(3, nuovaIscrizione.getPunti());
	        pr.setString(4, nuovaIscrizione.getMotivoRitiro());
	        
	        int result = pr.executeUpdate();

	        return result > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public List<Object[]> totalePunti() {
	    
		List<Object[]> totalePuntiVettura = new ArrayList<>();

	    String sql = "SELECT numerovettura_i, SUM(punti) AS totalPunti FROM iscrizione GROUP BY numerovettura_i";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        ResultSet rs = pr.executeQuery();

	        while (rs.next()) {
	            int numerovettura = rs.getInt("numerovettura_i");
	            int totalPunti = rs.getInt("totalPunti");
	            
	            totalePuntiVettura.add(new Object[]{numerovettura, totalPunti});
	            totalePuntiVettura.sort((o1, o2) -> Integer.compare((int) o2[1], (int) o1[1]));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return totalePuntiVettura;
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

}
