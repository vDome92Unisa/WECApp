package dataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class DaoFornitura implements Dao {
	
	private static Map<String, Integer> numeroComponenteCounters = new HashMap<>();

	@Override
	 public List<Fornitura> getFornitura() {
        
		List<Fornitura> forniture = new ArrayList<>();

        String sql = "SELECT * FROM fornitura";

        try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
             PreparedStatement pr = conn.prepareStatement(sql)) {

            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                forniture.add(new Fornitura(rs.getString("codice_f"), rs.getString("ragionesociale_f"),
                        rs.getString("costruttore_f"), rs.getInt("numerocomponentefornita")));
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return forniture;
    }
	
	public int countComponenti(String nomeCostruttore) {
        
		int numeroComponenti = 0;

        String sql = "SELECT COUNT(*) " +
                     "FROM fornitura f " +
                     "JOIN componente c ON f.codice_f = c.codice " +
                     "JOIN costruttore co ON f.costruttore_f = co.nome " +
                     "WHERE co.nome = ?";

        try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
             PreparedStatement pr = conn.prepareStatement(sql)) {

            pr.setString(1, nomeCostruttore);

            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                numeroComponenti = rs.getInt(1);
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return numeroComponenti;
    }

	public void insertFornitura(String codiceComponente, String ragioneSocialeCostruttore) {
	    try {
	        // Controlla il numero componente fornita per questo costruttore nel database
	        int numeroComponenteFornitaFromDB = getNumeroComponenteFornita(ragioneSocialeCostruttore);

	        // Se il numero componente fornita dal database è maggiore, aggiorna il contatore
	        int numeroComponenteCounter = Math.max(numeroComponenteCounters.getOrDefault(ragioneSocialeCostruttore, 0),
	                numeroComponenteFornitaFromDB);

	        // Incrementa il contatore per questo costruttore
	        numeroComponenteCounter++;

	        String sql = "INSERT INTO fornitura (codice_f, ragionesociale_f, costruttore_f, numerocomponentefornita) VALUES (?, ?, ?, ?)";

	        try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	             PreparedStatement pr = conn.prepareStatement(sql)) {

	            pr.setString(1, codiceComponente);
	            pr.setString(2, ragioneSocialeCostruttore);
	            pr.setString(3, ragioneSocialeCostruttore);
	            pr.setInt(4, numeroComponenteCounter);

	            // Esegui l'inserimento
	            int rowsAffected = pr.executeUpdate();

	            if (rowsAffected > 0) {
	                // Aggiorna il contatore nel map solo se l'inserimento è avvenuto con successo
	                numeroComponenteCounters.put(ragioneSocialeCostruttore, numeroComponenteCounter);
	            } 

	        } catch (Exception e) {
	            e.printStackTrace();
	            }
	    } catch (Exception e) {
	        e.printStackTrace();
	      }
	}



	
	private int getNumeroComponenteFornita(String ragioneSocialeCostruttore) {
	    String sql = "SELECT MAX(numerocomponentefornita) FROM fornitura WHERE ragionesociale_f = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, ragioneSocialeCostruttore);
	        ResultSet rs = pr.executeQuery();

	        if (rs.next()) {
	            // Ottieni il valore massimo di numerocomponentefornita per il costruttore specificato
	            return rs.getInt(1);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Restituisci 0 se non ci sono dati nel database o se si verificano eccezioni
	    return 0;
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
	public List<Iscrizione> getIscrizione() {
		// TODO Auto-generated method stub
		return null;
	}

}
