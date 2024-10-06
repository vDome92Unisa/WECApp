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


public class DaoFinanziamento implements Dao{
	
	public static Map<String, Integer> numeroFinanziamentoCounters = new HashMap<>();
	
	@Override
	public List<Finanziamento> getFinanziamento() {
		
		List<Finanziamento> Finanziamenti = new ArrayList<Finanziamento>();
		
		String sql = "select * from finanziamento";
		
		try(Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
				PreparedStatement pr = conn.prepareStatement(sql);
				){
			
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
				
				Finanziamenti.add(new Finanziamento(rs.getString("nomescuderia_f"), rs.getString("nome_f"), rs.getString("cognome_f"), rs.getFloat("quota"), rs.getDate("datafinanziamento")));
			}
			
			rs.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return Finanziamenti;
	}
	
	public List<Finanziamento> listaFinanziamenti(String nomePilota, String cognomePilota, String nomeScuderia) {
	    List<Finanziamento> finanziamenti = new ArrayList<>();

	    String sql = "SELECT * FROM finanziamento WHERE nome_f = ? AND cognome_f = ? AND nomescuderia_f = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, nomePilota);
	        pr.setString(2, cognomePilota);
	        pr.setString(3, nomeScuderia);

	        ResultSet rs = pr.executeQuery();

	        while (rs.next()) {
	            finanziamenti.add(new Finanziamento(
	                    rs.getString("nomescuderia_f"),
	                    rs.getString("nome_f"),
	                    rs.getString("cognome_f"),
	                    rs.getFloat("quota"),
	                    rs.getDate("datafinanziamento")));
	        }

	        rs.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return finanziamenti;
	}
	
	public float sommaQuoteFinanziamenti(String nomeScuderia) {
	    float sommaQuote = 0.0f;

	    String sql = "SELECT SUM(quota) AS sommaQuote FROM finanziamento WHERE nomescuderia_f = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, nomeScuderia);

	        ResultSet rs = pr.executeQuery();

	        if (rs.next()) {
	            sommaQuote = rs.getFloat("sommaQuote");
	        }

	        rs.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return sommaQuote;
	}
	
	public boolean insertFinanziamento(Finanziamento nuovoFinanziamento) {
	    // Rimuovi il contatore di finanziamento dal map e calcolalo direttamente dal database
	    int numeroFinanziamentoCounter = getNumeroFinanziamento(nuovoFinanziamento.getNomeScuderia()) + 1;

	    String sql = "INSERT INTO finanziamento (nomescuderia_f, nome_f, cognome_f, quota, finanziamentonumero, datafinanziamento) VALUES (?, ?, ?, ?, ?, ?)";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, nuovoFinanziamento.getNomeScuderia());
	        pr.setString(2, nuovoFinanziamento.getNomePilota());
	        pr.setString(3, nuovoFinanziamento.getCognomePilota());
	        pr.setFloat(4, nuovoFinanziamento.getQuota());
	        pr.setInt(5, numeroFinanziamentoCounter); // Utilizza il contatore aggiornato
	        pr.setDate(6, nuovoFinanziamento.getDataFinanziamento());

	        int result = pr.executeUpdate();

	        return result > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	private int getNumeroFinanziamento(String nomeScuderia) {
	    String sql = "SELECT MAX(finanziamentonumero) FROM finanziamento WHERE nomescuderia_f = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, nomeScuderia);

	        ResultSet rs = pr.executeQuery();
	        if (rs.next()) {
	            // Ottieni il valore massimo di finanziamentonumero per la scuderia specificata
	            return rs.getInt(1);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Restituisci 0 se non ci sono dati nel database o se si verificano eccezioni
	    return 0;
	}

	
	public int countFinanziamenti(String nomeScuderia) {
	    int numeroFinanziamenti = 0;

	    String sql = "SELECT COUNT(*) FROM finanziamento WHERE nomescuderia_f = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, nomeScuderia);

	        ResultSet rs = pr.executeQuery();

	        if (rs.next()) {
	            numeroFinanziamenti = rs.getInt(1);
	        }

	        rs.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return numeroFinanziamenti;
	}
	
	public boolean checkPilotaScuderiaFinanziamento(String nomePilota, String cognomePilota, String nomeScuderia) {
	    String sql = "SELECT COUNT(*) FROM pilota WHERE nome = ? AND cognome = ? AND nomescuderia_p = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, nomePilota);
	        pr.setString(2, cognomePilota);
	        pr.setString(3, nomeScuderia);

	        ResultSet rs = pr.executeQuery();
	        rs.next();

	        int count = rs.getInt(1);

	        return count > 0;

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
