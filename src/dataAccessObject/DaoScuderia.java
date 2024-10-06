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

public class DaoScuderia implements Dao{

	@Override
	public List<Scuderia> getScuderia() {
		
		List<Scuderia> Scuderie = new ArrayList<Scuderia>();
		
		String sql = "select * from scuderia";
		
		try(Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
				PreparedStatement pr = conn.prepareStatement(sql);
				){
			
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
				
				Scuderie.add(new Scuderia(rs.getString("nome"), rs.getString("sedeprincipale")));
			}
			
			rs.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return Scuderie;
		}
	
	public boolean checkScuderia(String scuderia) {
	    String sql = "SELECT * FROM scuderia WHERE nome = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, scuderia);
	       
	        ResultSet rs = pr.executeQuery();

	        return rs.next(); // Restituisce true se esiste già un finanziamento con la stessa chiavi primarie

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false; 
	    }
	}
	
	
	public void insertScuderia(Scuderia nuovaScuderia) {
	    String sql = "INSERT INTO scuderia (nome, sedeprincipale) VALUES (?, ?)";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, nuovaScuderia.getNome());
	        pr.setString(2, nuovaScuderia.getSede());

	        pr.executeUpdate();
	        
	    	} catch (Exception e) {
	        e.printStackTrace();
	     }
	}
	
	public double percentualeGentlemanDriver(String nomeScuderia) {
        String sql = "SELECT COUNT(p.id_equipaggio_p) AS totali, " +
                     "       SUM(CASE WHEN p.tipo = 'Gentleman Driver' THEN 1 ELSE 0 END) AS gentlemanDriver " +
                     "FROM equipaggio e " +
                     "JOIN pilota p ON e.id_equipaggio = p.id_equipaggio_p " +
                     "JOIN vettura v ON e.numerovettura_e = v.numero " +
                     "JOIN scuderia s ON v.scuderia_v = s.nome " +
                     "WHERE s.nome = ?";

        try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
             PreparedStatement pr = conn.prepareStatement(sql)) {

            pr.setString(1, nomeScuderia);
            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                int totali = rs.getInt("totali");
                int gentlemanDriver = rs.getInt("gentlemanDriver");

                if (totali > 0) {
                    return (double) gentlemanDriver / totali * 100.0;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0.0;
    }
	
	public List<Object[]> reportScuderie() {
	    List<Object[]> report = new ArrayList<>();

	    String sql = "SELECT s.nome AS nomeScuderia, " +
	                 "SUM(i.punti) AS totalPunti, " +
	                 "SUM(TIME_TO_SEC(g.durata)) / 60 AS totalMinutiGara " +
	                 "FROM scuderia s " +
	                 "LEFT JOIN vettura v ON s.nome = v.scuderia_v " +
	                 "LEFT JOIN iscrizione i ON v.numero = i.numerovettura_i " +
	                 "LEFT JOIN gara g ON i.nomegara_i = g.nome " +
	                 "GROUP BY s.nome " +
	                 "ORDER BY totalPunti / totalMinutiGara DESC";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        ResultSet rs = pr.executeQuery();

	         while (rs.next()) {
	            String nomeScuderia = rs.getString("nomeScuderia");
	            int totalPunti = rs.getInt("totalPunti");
	            int totalMinutiGara = rs.getInt("totalMinutiGara");

	            double rapportoPuntiMinuti = (totalMinutiGara != 0) ? (double) totalPunti / totalMinutiGara : 0;

	            report.add(new Object[]{nomeScuderia, totalPunti, totalMinutiGara, rapportoPuntiMinuti});
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return report;
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


	@Override
	public List<Iscrizione> getIscrizione() {
		// TODO Auto-generated method stub
		return null;
	}


}