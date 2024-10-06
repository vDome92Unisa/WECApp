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

public class DaoComponente implements Dao {
	
	@Override
	public List<Componente> getComponente() {
		
		List<Componente> Componenti = new ArrayList<Componente>();
		
		String sql = "select * from componente";
		
		try(Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
				PreparedStatement pr = conn.prepareStatement(sql);
				){
			
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
				
				Componenti.add(new Componente(rs.getString("codice"), rs.getInt("numerovettura_c"), rs.getString("tipo"), rs.getFloat("costo"), rs.getDate("datainstallazione"),
						rs.getString("tipomateriale"), rs.getFloat("peso"), rs.getString("numeromarce"), rs.getInt("cilindrata"), rs.getString("tipomotore"), rs.getInt("numerocilindri")));
			}
			
			rs.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return Componenti;
	}
	
	public void insertComponente(Componente nuovaComponente, String costruttore) {
		
		DaoFornitura daoF = new DaoFornitura();
		
	    String sql = "INSERT INTO componente (codice, numerovettura_c, tipo, costo, datainstallazione, tipomateriale, peso, numeromarce, cilindrata, tipomotore, numerocilindri)"
	            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, nuovaComponente.getCodice());
	        pr.setInt(2, nuovaComponente.getNumeroVettura());
	        pr.setString(3, nuovaComponente.getTipoComponente());
	        pr.setFloat(4, nuovaComponente.getCosto());
	        pr.setDate(5, (Date) nuovaComponente.getDataInstallazione());
	        pr.setString(6, nuovaComponente.getMateriale());
	        pr.setFloat(7, nuovaComponente.getPeso());
	        pr.setString(8, nuovaComponente.getMarce());
	        pr.setInt(9, nuovaComponente.getCilindrata());
	        pr.setString(10, nuovaComponente.getTipoMotore());
	        pr.setInt(11, nuovaComponente.getCilindri());

	        pr.executeUpdate();
	        
	        daoF.insertFornitura(nuovaComponente.getCodice(), costruttore);

	        } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void deleteComponente(String codice) {
	    String sql = "DELETE FROM componente WHERE codice = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, codice);

	        pr.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	
	public boolean checkComponente(String codiceComponente) {
	    String sql = "SELECT COUNT(*) FROM componente WHERE codice = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, codiceComponente);

	        ResultSet rs = pr.executeQuery();

	        if (rs.next()) {
	            return rs.getInt(1) > 0; // Restituisce true se il componente esiste, altrimenti false
	        }

	        rs.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return false; // In caso di errore, restituisci false
	}
	
	public List<Componente> listaComponenteV(int numeroVettura) {
		
		List<Componente> tipoComponente = new ArrayList<Componente>();
	    String sql = "SELECT * FROM componente WHERE numerovettura_c = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setInt(1, numeroVettura);
	        
	        ResultSet rs = pr.executeQuery();
	        
	        while(rs.next()) {
				
				tipoComponente.add(new Componente(rs.getString("codice"), rs.getInt("numerovettura_c"), rs.getString("tipo"), rs.getFloat("costo"), rs.getDate("datainstallazione"),
						rs.getString("tipomateriale"), rs.getFloat("peso"), rs.getString("numeromarce"), rs.getInt("cilindrata"), rs.getString("tipomotore"), rs.getInt("numerocilindri")));
			}
	        rs.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	     }
	    
	    return tipoComponente;
	}
	
	public List<String> componentiMancanti(int numeroVettura) {
	    
		List<String> tipiComponentiMancanti = new ArrayList<>();
	    List<String> tipiComponentiPresenti = new ArrayList<>();

	    // Ottiene tutti i tipi di componente associati alla vettura
	    List<Componente> componentiVettura = listaComponenteV(numeroVettura);

	    for (Componente componente : componentiVettura) {
	        tipiComponentiPresenti.add(componente.getTipoComponente());
	    }

	    // Verifica quali tipi di componente mancano tra Motore, Telaio e Cambio
	    if (!tipiComponentiPresenti.contains("Motore")) {
	        tipiComponentiMancanti.add("Motore");
	    }
	    if (!tipiComponentiPresenti.contains("Telaio")) {
	        tipiComponentiMancanti.add("Telaio");
	    }
	    if (!tipiComponentiPresenti.contains("Cambio")) {
	        tipiComponentiMancanti.add("Cambio");
	    }

	    return tipiComponentiMancanti;
	}
	
	public List<Object[]> classificaPuntiPerTipoMotore(String tipoMotore) {
        
		List<Object[]> classifica = new ArrayList<>();

        String sql = "SELECT c.numerovettura_c AS numeroVettura, SUM(i.punti) AS totalPunti, c.tipomotore " +
                     "FROM componente c " +
                     "LEFT JOIN iscrizione i ON c.numerovettura_c = i.numerovettura_i " +
                     "WHERE c.tipomotore = ? " +
                     "GROUP BY c.numerovettura_c, c.tipomotore " +
                     "ORDER BY totalPunti DESC";

        try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
             PreparedStatement pr = conn.prepareStatement(sql)) {

            pr.setString(1, tipoMotore);

            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                int numeroVettura = rs.getInt("numeroVettura");
                int totalPunti = rs.getInt("totalPunti");
                String tipoMotoreVettura = rs.getString("tipomotore");

                classifica.add(new Object[]{numeroVettura, totalPunti, tipoMotoreVettura});
                classifica.sort((o1, o2) -> Integer.compare((int) o2[1], (int) o1[1]));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return classifica;
    }
	
	public void updateComponente(int numeroVettura, String codiceComponenteEsistente, Componente nuovaComponente, String costruttore) {
		
		DaoFornitura daoF = new DaoFornitura();
	    String sql = "UPDATE componente SET codice = ?, numerovettura_c = ?, tipo = ?, costo = ?, datainstallazione = ?, " +
	                 "tipomateriale = ?, peso = ?, numeromarce = ?, cilindrata = ?, tipomotore = ?, numerocilindri = ? " +
	                 "WHERE numerovettura_c = ? AND codice = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setString(1, nuovaComponente.getCodice());
	        pr.setInt(2, nuovaComponente.getNumeroVettura());
	        pr.setString(3, nuovaComponente.getTipoComponente());
	        pr.setFloat(4, nuovaComponente.getCosto());
	        pr.setDate(5, (Date) nuovaComponente.getDataInstallazione());
	        pr.setString(6, nuovaComponente.getMateriale());
	        pr.setFloat(7, nuovaComponente.getPeso());
	        pr.setString(8, nuovaComponente.getMarce());
	        pr.setInt(9, nuovaComponente.getCilindrata());
	        pr.setString(10, nuovaComponente.getTipoMotore());
	        pr.setInt(11, nuovaComponente.getCilindri());
	        pr.setInt(12, numeroVettura);
	        pr.setString(13, codiceComponenteEsistente);

	        pr.executeUpdate();
	        daoF.insertFornitura(nuovaComponente.getCodice(), costruttore);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	
	public List<Object[]> listaComponentePerVettura(int numeroVettura) {
	    List<Object[]> componentiVettura = new ArrayList<>();
	    String sql = "SELECT codice, tipo FROM componente WHERE numerovettura_c = ?";

	    try (Connection conn = DriverManager.getConnection(DBADDRESS, USER, PWD);
	         PreparedStatement pr = conn.prepareStatement(sql)) {

	        pr.setInt(1, numeroVettura);

	        ResultSet rs = pr.executeQuery();

	        while (rs.next()) {
	        	String tipoComponente = rs.getString("tipo");
	        	String codiceComponente = rs.getString("codice");
	            
	        	componentiVettura.add(new Object[]{codiceComponente, tipoComponente});
	        }

	        rs.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return componentiVettura;
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
