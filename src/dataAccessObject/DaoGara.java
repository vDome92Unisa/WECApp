package dataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

public class DaoGara implements Dao {
	
	@Override
	public List<Gara> getGara() {
		
		List<Gara> Gare = new ArrayList<Gara>();
		
		String sql = "select * from gara";
		
		try(Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
				PreparedStatement pr = conn.prepareStatement(sql);
				){
			
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
				
				Gare.add(new Gara(rs.getString("nome"), rs.getString("nomecircuito"), rs.getDate("data"), rs.getString("durata"), rs.getString("tipo")));
			}
			
			rs.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return Gare;
		}
	
	public boolean checkGara(String gara) {
	    
		String sql = "SELECT * FROM gara WHERE nome = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, gara);
	        ResultSet rs = pr.executeQuery();

	        return rs.next(); 

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false; 
	    }
	}
	
	public boolean checkDate(Date dataGara) {
        String sql = "SELECT * FROM gara WHERE data = ?";

        try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
             PreparedStatement pr = conn.prepareStatement(sql)) {

            pr.setDate(1, new java.sql.Date(dataGara.getTime()));
            ResultSet rs = pr.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public void insertGara(Gara nuovaGara) {
		
		String sql = "INSERT INTO gara (nome, nomecircuito, data, durata, tipo) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
             PreparedStatement pr = conn.prepareStatement(sql)) {

            pr.setString(1, nuovaGara.getNome());
            pr.setString(2, nuovaGara.getNomeCircuito());
            pr.setDate(3, nuovaGara.getData());
            pr.setString(4, nuovaGara.getDurata());
            pr.setString(5, nuovaGara.getTipoGara());
            
            pr.executeUpdate();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void deleteGara(String nomeGara) {
	    String sql = "DELETE FROM gara WHERE nome = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, nomeGara);
	        pr.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	        System.err.println("Errore durante l'eliminazione della gara.");
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
