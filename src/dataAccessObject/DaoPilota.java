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

public class DaoPilota implements Dao {
	
	@Override
	public List<Pilota> getPilota() {
		
		List<Pilota> Piloti = new ArrayList<Pilota>();
		
		String sql = "select * from pilota";
		
		try(Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
				PreparedStatement pr = conn.prepareStatement(sql);
				){
			
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
				
				Piloti.add(new Pilota(rs.getString("nome"), rs.getString("cognome"), rs.getString("nazionalità"), rs.getDate("datanascita"), rs.getString("id_equipaggio_p"),
						rs.getString("tipo"), rs.getDate("dataprimalicenza"), rs.getInt("numerolicenzepossedute"), rs.getString("nomescuderia_p")));
			}
			
			rs.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return Piloti;
		}
	
	public boolean checkPilotaEsistente(Pilota pilota) {
	    
		String sql = "SELECT COUNT(*) FROM pilota WHERE nome = ? AND cognome = ? AND nazionalità = ? AND datanascita = ?";
	    
	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, pilota.getNome());
	        pr.setString(2, pilota.getCognome());
	        pr.setString(3, pilota.getNazionalità());
	        pr.setDate(4, new java.sql.Date(pilota.getDataNascita().getTime()));

	        ResultSet rs = pr.executeQuery();
	        rs.next();

	        // Se il conteggio è maggiore di 0, il pilota esiste già
	        return rs.getInt(1) > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	
	public boolean insertPilota(Pilota nuovoPilota) {
	    
		if (checkPilotaEsistente(nuovoPilota)) {
	        System.out.println("Il pilota è già presente nel database.");
	        return false;
	    }

	    String sql = "INSERT INTO pilota (nome, cognome, nazionalità, datanascita, id_equipaggio_p, tipo, dataprimalicenza, numerolicenzepossedute, nomescuderia_p )"
	            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, nuovoPilota.getNome());
	        pr.setString(2, nuovoPilota.getCognome());
	        pr.setString(3, nuovoPilota.getNazionalità());
	        pr.setDate(4, new java.sql.Date(nuovoPilota.getDataNascita().getTime()));
	        pr.setString(5, nuovoPilota.getID_Equipaggio());
	        pr.setString(6, nuovoPilota.getTipoPilota());
	        if (nuovoPilota.getPrimalicenza() != null) {
	            pr.setDate(7, new java.sql.Date(nuovoPilota.getPrimalicenza().getTime()));
	        } else {
	            pr.setNull(7, java.sql.Types.DATE);
	        }
	        if (nuovoPilota.getNumeroLicenze() != null) {
	            pr.setInt(8, nuovoPilota.getNumeroLicenze());
	        } else {
	            pr.setNull(8, java.sql.Types.INTEGER);
	        }
	        pr.setString(9, nuovoPilota.getScuderia());

	        pr.executeUpdate();
	        return true;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public boolean isGentlemanDriver(String nome, String cognome) {
	    String sql = "SELECT COUNT(*) FROM pilota WHERE nome = ? AND cognome = ? AND tipo = 'Gentleman Driver'";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, nome);
	        pr.setString(2, cognome);

	        ResultSet rs = pr.executeQuery();

	        if (rs.next()) {
	            int count = rs.getInt(1);
	            return count > 0;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	}

	public List<Pilota> pilotiVincitoriCasa() {
	    List<Pilota> pilotiVincitori = new ArrayList<>();

	    String sql = "SELECT p.nome, p.cognome, p.nazionalità, GROUP_CONCAT(c.nome) AS circuiti_vinti " +
	                 "FROM pilota p " +
	                 "JOIN equipaggio e ON p.id_equipaggio_p = e.id_equipaggio " +
	                 "JOIN vettura v ON e.numerovettura_e = v.numero " +
	                 "JOIN iscrizione i ON v.numero = i.numerovettura_i " +
	                 "JOIN gara g ON i.nomegara_i = g.nome " +
	                 "JOIN circuito c ON g.nomecircuito = c.nome " +
	                 "WHERE i.punti = 25 AND p.nazionalità = c.paese " +
	                 "GROUP BY p.nome, p.cognome, p.nazionalità";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        ResultSet rs = pr.executeQuery();

	        while (rs.next()) {
	            Pilota pilota = new Pilota(
	                    rs.getString("nome"),
	                    rs.getString("cognome"),
	                    rs.getString("nazionalità"),
	                    null,
	                    null,
	                    null,
	                    null,
	                    0,
	                    null
	            );
	            String circuitiVinti = rs.getString("circuiti_vinti");
	            if (circuitiVinti != null) {
	                String[] circuiti = circuitiVinti.split(",");
	                List<String> circuitiList = new ArrayList<>();
	                for (String circuito : circuiti) {
	                    circuitiList.add(circuito.trim());
	                }
	                pilota.aggiungiCircuitiVinti(circuitiList);
	            }
	            pilotiVincitori.add(pilota);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return pilotiVincitori;
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
