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

public class DaoEquipaggio implements Dao {
	
	@Override
	public List<Equipaggio> getEquipaggio() {
		
		List<Equipaggio> Equipaggi = new ArrayList<Equipaggio>();
		
		String sql = "select * from equipaggio";
		
		try(Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
				PreparedStatement pr = conn.prepareStatement(sql);
				){
			
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
				
				Equipaggi.add(new Equipaggio(rs.getString("id_equipaggio"), rs.getInt("numerovettura_e"), rs.getInt("numerocomponenti")));
			}
			
			rs.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return Equipaggi;
	}
	
	public void insertEquipaggio(Equipaggio nuovoEquipaggio) {
	    
		String sql = "INSERT INTO equipaggio (id_equipaggio, numerovettura_e, numerocomponenti) VALUES (?, ?, ?)";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, nuovoEquipaggio.getID_equipaggio());
	        pr.setInt(2, nuovoEquipaggio.getNumeroVettura());
	        pr.setInt(3, nuovoEquipaggio.getNumeroComponenti());

	        pr.executeUpdate();

	      } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public boolean checkEquipaggio(String idEquipaggio) {
	    
		String sql = "SELECT COUNT(*) FROM equipaggio WHERE id_equipaggio = ? ";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, idEquipaggio);

	        ResultSet rs = pr.executeQuery();
	        rs.next();

	        int count = rs.getInt(1);

	        return count > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
public boolean checkEquipaggioVettura(int numeroVettura) {
	    
		String sql = "SELECT COUNT(*) FROM equipaggio WHERE numerovettura_e = ? ";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setInt(1, numeroVettura);

	        ResultSet rs = pr.executeQuery();
	        rs.next();

	        int count = rs.getInt(1);

	        return count > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

public boolean checkEquipaggioScuderia(String codiceEquipaggio, String codiceScuderia) {
	
	String sql = "SELECT COUNT(*) AS count " +
            "FROM equipaggio e " +
            "JOIN vettura v ON e.numerovettura_e = v.numero " +
            "JOIN scuderia s ON v.scuderia_v = s.nome " +
            "WHERE e.id_equipaggio = ? AND s.nome = ?";

    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
         PreparedStatement pr = conn.prepareStatement(sql)) {

        pr.setString(1, codiceEquipaggio);
        pr.setString(2, codiceScuderia);

        ResultSet rs = pr.executeQuery();
        if (rs.next()) {
            int count = rs.getInt("count");
            return count > 0; // True se l'equipaggio è associato alla scuderia, altrimenti false
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}

	
	public boolean checkGentlemanDriverLimit(String idEquipaggio) {
        
		String sql = "SELECT COUNT(*) AS count FROM pilota WHERE id_equipaggio_p = ? AND tipo = 'Gentleman Driver'";

        try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
             PreparedStatement pr = conn.prepareStatement(sql)) {

            pr.setString(1, idEquipaggio);

            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count < 2; // True se ci sono meno di 2 Gentleman Driver, altrimenti false
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;		// In caso di errore, ritorna false per evitare di inserire un pilota erroneamente
        }

        return false;
    }
	
	public boolean checkNumeroComponenti(String idEquipaggio) {
	    String sql = "SELECT COUNT(*) AS numPiloti FROM pilota WHERE id_equipaggio_p = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, idEquipaggio);

	        ResultSet rs = pr.executeQuery();
	        if (rs.next()) {
	            int numPiloti = rs.getInt("numPiloti");
	            return numPiloti < 3; 
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return false;
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
