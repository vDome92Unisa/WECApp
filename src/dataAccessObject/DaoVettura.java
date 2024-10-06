package dataAccessObject;

import java.sql.Connection;
import java.sql.Date;
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

public class DaoVettura implements Dao {

	@Override
	public List<Vettura> getVettura() {
		
		List<Vettura> Vetture = new ArrayList<Vettura>();
		
		String sql = "select * from vettura";
		
		try(Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
				PreparedStatement pr = conn.prepareStatement(sql);
				){
			
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
				
				Vetture.add(new Vettura(rs.getInt("numero"), rs.getString("modelloveicolo"), rs.getString("scuderia_v"), rs.getDate("dataacquisto")));
			}
			
			rs.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return Vetture;
	}
	
	public void insertVettura(Vettura nuovaVettura) {
        String sql = "INSERT INTO vettura (numero, modelloveicolo, scuderia_v, dataacquisto) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
             PreparedStatement pr = conn.prepareStatement(sql)) {

            pr.setInt(1, nuovaVettura.getNumeroVettura());
            pr.setString(2, nuovaVettura.getModello());
            pr.setString(3, nuovaVettura.getScuderia());
            pr.setDate(4, (Date) nuovaVettura.getDataAcquisto());
            
            pr.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public boolean checkVettura(int numeroVettura) {
	    String sql = "SELECT COUNT(*) AS vetturaCount " +
	                 "FROM vettura " +
	                 "WHERE numero = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setInt(1, numeroVettura);

	        ResultSet rs = pr.executeQuery();

	        if (rs.next()) {
	            int vetturaCount = rs.getInt("vetturaCount");
	            return vetturaCount > 0;  // Restituisci true solo se esiste una vettura con lo stesso numero
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	}
	
	public void deleteVettura(int numeroVettura) {
	    String sql = "DELETE FROM vettura WHERE numero = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setInt(1, numeroVettura);
	        pr.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	        System.err.println("Errore durante l'eliminazione della vettura.");
	    }
	}



	@Override
	public List<Scuderia> getScuderia() {
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

	@Override
	public List<Iscrizione> getIscrizione() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}


