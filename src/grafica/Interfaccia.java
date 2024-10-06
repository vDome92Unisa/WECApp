package grafica;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import dataAccessObject.DaoCircuito;
import dataAccessObject.DaoComponente;
import dataAccessObject.DaoCostruttore;
import dataAccessObject.DaoEquipaggio;
import dataAccessObject.DaoFinanziamento;
import dataAccessObject.DaoFornitura;
import dataAccessObject.DaoGara;
import dataAccessObject.DaoIscrizione;
import dataAccessObject.DaoPilota;
import dataAccessObject.DaoScuderia;
import dataAccessObject.DaoVettura;
import model.Circuito;
import model.Componente;
import model.Costruttore;
import model.Equipaggio;
import model.Finanziamento;
import model.Gara;
import model.Iscrizione;
import model.Pilota;
import model.Scuderia;
import model.Vettura;
import javax.swing.UIManager;
import java.awt.Font;

public class Interfaccia extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea Lavagna;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaccia frame = new Interfaccia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Interfaccia() {
		
		setTitle("Campionato Mondiale Automobili");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		JButton btnNewButton = new JButton("9: Lista Scuderie + N°Finanziamenti");
		btnNewButton.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton.setFocusTraversalPolicyProvider(true);
		btnNewButton.setSize(new Dimension(90, 20));
		btnNewButton.setPreferredSize(new Dimension(90, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoScuderia daoScuderia = new DaoScuderia();
		        DaoFinanziamento daoFinanziamento = new DaoFinanziamento();
		        List<Scuderia> scuderie = daoScuderia.getScuderia();
		        
		        int i = 1;
		        for (Scuderia scuderia : scuderie) {
		            int numeroFinanziamenti = daoFinanziamento.countFinanziamenti(scuderia.getNome());
		            Lavagna.append("\n" + i + ":  " + scuderia.toString() + "       Numero Finanziamenti: " + numeroFinanziamenti);
		            i++;
		        }
		        Lavagna.append("\n");
		     }
		});
		
		JButton btnNewButton_1 = new JButton("Lista Vetture");
		btnNewButton_1.setAutoscrolls(true);
		btnNewButton_1.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_1.setFocusTraversalPolicyProvider(true);
		btnNewButton_1.setSize(new Dimension(90, 20));
		btnNewButton_1.setPreferredSize(new Dimension(90, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoVettura daoV = new DaoVettura();
				List<Vettura> Vetture = daoV.getVettura();
				int i = 1;
				for(Vettura v: Vetture) {
					Lavagna.append("\n" + i + ":  " + v.toString());
					i++;
				}
				Lavagna.append("\n");
			}
			});
		
		JButton btnNewButton_2 = new JButton("Lista Gare");
		btnNewButton_2.setAutoscrolls(true);
		btnNewButton_2.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_2.setFocusTraversalPolicyProvider(true);
		btnNewButton_2.setSize(new Dimension(90, 20));
		btnNewButton_2.setPreferredSize(new Dimension(90, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoGara daoG = new DaoGara();
				List<Gara> Gare = daoG.getGara();
				int i = 1;
				
				for(Gara g: Gare) {
					Lavagna.append("\n" + i + ":  " + g.toString());
					i++;
				}
				Lavagna.append("\n");
			}
		});
		
		JButton btnNewButton_3 = new JButton("Lista Circuiti");
		btnNewButton_3.setAutoscrolls(true);
		btnNewButton_3.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_3.setFocusTraversalPolicyProvider(true);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoCircuito daoC = new DaoCircuito();
				List<Circuito> Circuiti = daoC.getCircuito();
				int i = 1;
				
				for(Circuito c: Circuiti) {
					Lavagna.append("\n" + i + ":  " + c.toString());
					i++;
				}
				Lavagna.append("\n");
			}
		});
		btnNewButton_3.setPreferredSize(new Dimension(90, 20));
		btnNewButton_3.setSize(new Dimension(90, 20));
		
		JButton btnNewButton_3_1 = new JButton("Lista Costruttori");
		btnNewButton_3_1.setAutoscrolls(true);
		btnNewButton_3_1.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_3_1.setFocusTraversalPolicyProvider(true);
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoCostruttore daoCo = new DaoCostruttore();
				List<Costruttore> Costruttori = daoCo.getCostruttore();
				int i = 1;
				
				for(Costruttore co: Costruttori) {
					Lavagna.append("\n" + i + ":  " + co.toString());
					i++;
				}
				Lavagna.append("\n");
			}
		});
		btnNewButton_3_1.setSize(new Dimension(90, 20));
		btnNewButton_3_1.setPreferredSize(new Dimension(90, 20));
		
		JButton btnNewButton_4 = new JButton("Lista Piloti");
		btnNewButton_4.setAutoscrolls(true);
		btnNewButton_4.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_4.setFocusTraversalPolicyProvider(true);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoPilota daoP = new DaoPilota();
				int i = 1;
				
				List<Pilota> Piloti = daoP.getPilota();
				for(Pilota p: Piloti) {
					Lavagna.append("\n" + i + ":  " + p.toString());
					i++;
				}
				Lavagna.append("\n");
			}
		});
		
		JButton btnNewButton_5 = new JButton("1: Nuova Scuderia");
		btnNewButton_5.setAutoscrolls(true);
		btnNewButton_5.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_5.setFocusTraversalPolicyProvider(true);
		btnNewButton_5.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		        DaoScuderia daoS = new DaoScuderia();
		        JTextField nomeField = new JTextField();
		        JTextField sedeField = new JTextField();

		        Object[] message = {
		            "Nome:", nomeField,
		            "Sede:", sedeField
		        };

		        int option = JOptionPane.showConfirmDialog(null, message, "Inserisci Scuderia", JOptionPane.OK_CANCEL_OPTION);
		        if (option == JOptionPane.OK_OPTION) {
		            
		            String nome = nomeField.getText();
		            String sede = sedeField.getText();

		            if (!nome.isEmpty() && !sede.isEmpty()) {
		            	Scuderia nuovaScuderia = new Scuderia(nome, sede);
		            	if(!daoS.checkScuderia(nome)){;
		                daoS.insertScuderia(nuovaScuderia);
		                Lavagna.append("\nInserimento Scuderia Riuscito.\n");
		            	}else {
		            		Lavagna.append("\nScuderia già registrata.\n");
		            	}
		            }else {
		            	Lavagna.append("\nCampi non compilati.\n");
		            	return;
		            }
		        }
		    }
		});

		Lavagna = new JTextArea();
		Lavagna.setFocusTraversalPolicyProvider(true);
		Lavagna.setAlignmentY(Component.TOP_ALIGNMENT);
		Lavagna.setAlignmentX(Component.LEFT_ALIGNMENT);
		Lavagna.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		Lavagna.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		
		JButton btnNewButton_6 = new JButton("2: Nuova Vettura");
		btnNewButton_6.setAutoscrolls(true);
		btnNewButton_6.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_6.setFocusTraversalPolicyProvider(true);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoVettura daoV = new DaoVettura();
				DaoComponente daoC = new DaoComponente();
				DaoCostruttore daoCos = new DaoCostruttore();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				
				//vettura
				JTextField numeroVetturaField = new JTextField();
                JTextField modelloField = new JTextField();
                JTextField scuderiaField = new JTextField();
                JTextField dataAcquistoField = new JTextField();
                
                //motore
                JTextField codiceMotoreField = new JTextField();
                JTextField costoMotoreField = new JTextField();
                JTextField tipoMotoreField = new JTextField();
                JTextField cilindrataField = new JTextField();
                JTextField cilindriField = new JTextField();
                JTextField dataInstallazioneMField = new JTextField();
                JTextField costruttoreMField = new JTextField();
                String costruttoreM = costruttoreMField.getText();
                
                //telaio
                JTextField codiceTelaioField = new JTextField();
                JTextField costoTelaioField = new JTextField();
                JTextField materialeField = new JTextField();
                JTextField pesoField = new JTextField();
                JTextField dataInstallazioneTField = new JTextField();
                JTextField costruttoreTField = new JTextField();
                String costruttoreT = costruttoreTField.getText();
                 
                //cambio
                JTextField codiceCambioField = new JTextField();
                JTextField costoCambioField = new JTextField();
                JTextField marceField = new JTextField();
                JTextField dataInstallazioneCField = new JTextField();
                JTextField costruttoreCField = new JTextField();
                String costruttoreC = costruttoreCField.getText();
                
                
                Object[] messageVettEquip = {
                        "Numero Vettura:", numeroVetturaField,
                        "Modello Vettura:", modelloField,
                        "Scuderia:", scuderiaField,
                        "Data Acquisto:\ndd-mm-yyyy", dataAcquistoField,
                       };
                
                Object[] messageMot = {
                		"Codice Motore:", codiceMotoreField,
                		"Costruttore:", costruttoreMField,
                        "Costo Motore:", costoMotoreField,
                        "Cilindrata:", cilindrataField,
                        "Numero Cilindri:", cilindriField,
                        "Tipo Motore\nTurbo o Aspirato:", tipoMotoreField,
                        "Data Instal. Motore:", dataInstallazioneMField,
                };
                
                Object[] messageTel = {
                		"Codice Telaio:", codiceTelaioField,
                		"Costruttore:", costruttoreTField,
                        "Materiale Telaio", materialeField,
                        "Costo Telaio:", costoTelaioField,
                        "Peso Telaio:", pesoField,
                        "Data Instal. Telaio:", dataInstallazioneTField,
                };
                
                Object[] messageCamb = {
                		"Codice Cambio:", codiceCambioField,
                		"Costruttore:", costruttoreCField,
                		"Costo Cambio:", costoCambioField,
                        "Numero marce\n7 o 8:", marceField,
                        "Data Instal. Cambio:", dataInstallazioneCField,
                };
                
                
                int vetturaEquip = JOptionPane.showConfirmDialog(null, messageVettEquip, "Inserisci Vettura", JOptionPane.OK_CANCEL_OPTION);
                if (vetturaEquip == JOptionPane.OK_OPTION) {
                	
                	String numeroVettura = numeroVetturaField.getText();
                    String modello = modelloField.getText();
                    String scuderia = scuderiaField.getText();
                    String dataAcquisto = dataAcquistoField.getText();
                    
                    int numeroVetturaInt;
                    try {
                        numeroVetturaInt = Integer.parseInt(numeroVettura);
                    } catch (NumberFormatException e3) {
                        System.err.println("\nErrore durante il parsing del numero vettura: " + e3.getMessage());
                        e3.printStackTrace();
                        return;
                    }
                    
                    java.sql.Date dataAcquistoDate = null;
                    try {
                    	java.util.Date dataAcquistoUtil = dateFormat.parse(dataAcquisto);
                        dataAcquistoDate = new java.sql.Date(dataAcquistoUtil.getTime());
                    } catch (ParseException e1) {
                    	System.err.println("\nErrore durante il parsing della data acquisto: " + e1.getMessage());
                        e1.printStackTrace();
                    }
                    
                    if(!numeroVettura.isEmpty() && !modello.isEmpty() && !scuderia.isEmpty() && !dataAcquisto.isEmpty()) {
                    	if(daoV.checkVettura(numeroVetturaInt)) {
                            Lavagna.append("\nLa vettura è già registrata.\n");
                            	return;
                     }else {
                    	Vettura nuovaVettura = new Vettura(numeroVetturaInt, modello, scuderia, dataAcquistoDate);
                    	daoV.insertVettura(nuovaVettura);
                     	Lavagna.append("\nVettura registrata.\n");
                    	}
                    }else {
		            	Lavagna.append("\nCampi non compilati.\n");
		            	return;
		            }
                }
                
                int motore = JOptionPane.showConfirmDialog(null, messageMot, "Inserisci Motore", JOptionPane.OK_CANCEL_OPTION);
                if (motore == JOptionPane.OK_OPTION) {
                	
                	String numeroVettura = numeroVetturaField.getText();
                	String codiceMotore = codiceMotoreField.getText(); 
                    String costoMotore = costoMotoreField.getText();
                    String tipoMotore = tipoMotoreField.getText();
                    String cilindrata = cilindrataField.getText();
                    String cilindri = cilindriField.getText();
                    String dataInstallazioneM = dataInstallazioneMField.getText();
                    costruttoreM = costruttoreMField.getText();
                    
                    int numeroVetturaInt;
                    try {
                        numeroVetturaInt = Integer.parseInt(numeroVettura);
                    } catch (NumberFormatException e3) {
                        System.err.println("\nErrore durante il parsing del numero vettura: " + e3.getMessage());
                        e3.printStackTrace();
                        return;
                    }
                    
                    if (!daoCos.checkCostruttore(costruttoreM)) {
                        Lavagna.append("\nCostruttore Motore non esistente. Inserisci prima un costruttore.");
                        daoV.deleteVettura(numeroVetturaInt);
                        return;
                    }
                    
                    int cilindrataInt = 0;
                    try {
                        cilindrataInt = Integer.parseInt(cilindrata);
                    } catch (NumberFormatException e3) {
                    	System.err.println("\nErrore durante il parsing della cilindrata: " + e3.getMessage());
                        e3.printStackTrace();
                    }
                	
                    int cilindriInt = 0;
                    try {
                        cilindriInt = Integer.parseInt(cilindri);
                    } catch (NumberFormatException e3) {
                    	System.err.println("\nErrore durante il parsing del numero cilindri: " + e3.getMessage());
                        e3.printStackTrace();
                    }
                    
                    java.sql.Date dataInstallazioneMDate = null;
                    try {
                    	java.util.Date dataInstallazioneMUtil = dateFormat.parse(dataInstallazioneM);
                        dataInstallazioneMDate = new java.sql.Date(dataInstallazioneMUtil.getTime());
                    } catch (ParseException e1) {
                    	System.err.println("\nErrore durante il parsing della data installazione motore: " + e1.getMessage());
                        e1.printStackTrace();
                    }
                    
                    float costoMotoreFloat = 0.0f;
                    try {
                        costoMotoreFloat = Float.parseFloat(costoMotore);
                    } catch (NumberFormatException e4) {
                        System.err.println("\nErrore durante il parsing del costo del motore: " + e4.getMessage());
                        e4.printStackTrace();
                    }
                    
                    if (!tipoMotore.equals("Turbo") && !tipoMotore.equals("Aspirato") && !tipoMotore.equals("turbo") && !tipoMotore.equals("aspirato")) {
                        Lavagna.append("\nTipo di Motore non valido.\n");
                        daoV.deleteVettura(numeroVetturaInt);
                        return;
                    }
                    if(!codiceMotore.isEmpty() && !costoMotore.isEmpty() && !tipoMotore.isEmpty() && !cilindrata.isEmpty() && !cilindri.isEmpty() &&
                    	!dataInstallazioneM.isEmpty() && !costruttoreM.isEmpty()) {
                    	
                    	Componente nuovaComponente = new Componente(codiceMotore, numeroVetturaInt, "Motore", costoMotoreFloat, dataInstallazioneMDate, null, null, null, cilindrataInt, tipoMotore, cilindriInt);
                    	if(daoC.checkComponente(codiceMotore)) {
                    		Lavagna.append("\nComponente già inserita nel DataBase.\n");
                    		daoV.deleteVettura(numeroVetturaInt);
                    		return;
                    	}else {
                    		daoC.insertComponente(nuovaComponente, costruttoreM);
                    		Lavagna.append("\nMotore inserito.\n");
                    	}
                    }else {
		            	Lavagna.append("\nCampi non compilati.\n");
		            	return;
		            }
                }
                
                int telaio = JOptionPane.showConfirmDialog(null, messageTel, "Inserisci Telaio", JOptionPane.OK_CANCEL_OPTION);
                if (telaio == JOptionPane.OK_OPTION) {
                	
                	String numeroVettura = numeroVetturaField.getText();
                	String codiceTelaio = codiceTelaioField.getText();
                    String costoTelaio = costoTelaioField.getText();
                    String materiale = materialeField.getText();
                    String pesoTelaio = pesoField.getText();
                    String dataInstallazioneT = dataInstallazioneTField.getText();
                    costruttoreT = costruttoreTField.getText();
                    
                    
                     int numeroVetturaInt;
                    try {
                        numeroVetturaInt = Integer.parseInt(numeroVettura);
                    } catch (NumberFormatException e3) {
                        System.err.println("\nErrore durante il parsing del numero vettura: " + e3.getMessage());
                        e3.printStackTrace();
                        return;
                    }
                    
                    if (!daoCos.checkCostruttore(costruttoreT)) {
                        Lavagna.append("\nCostruttore Telaio non esistente. Inserisci prima un costruttore.\n");
                        daoV.deleteVettura(numeroVetturaInt);
                        return;
                    }
                    
                    java.sql.Date dataInstallazioneTDate = null;
                    try {
                    	java.util.Date dataInstallazioneTUtil = dateFormat.parse(dataInstallazioneT);
                        dataInstallazioneTDate = new java.sql.Date(dataInstallazioneTUtil.getTime());
                    } catch (ParseException e1) {
                    	System.err.println("\nErrore durante il parsing della data installazione telaio: " + e1.getMessage());
                        e1.printStackTrace();
                    }
                    
                    float costoTelaioFloat = 0.0f;
                    try {
                        costoTelaioFloat = Float.parseFloat(costoTelaio);
                    } catch (NumberFormatException e4) {
                        System.err.println("\nErrore durante il parsing del costo Telaio: " + e4.getMessage());
                        e4.printStackTrace();
                    }
                    
                    float pesoTelaioFloat = 0.0f;
                    try {
                        pesoTelaioFloat = Float.parseFloat(pesoTelaio);
                    } catch (NumberFormatException e4) {
                        System.err.println("\nErrore durante il parsing del costo del peso telaio: " + e4.getMessage());
                        e4.printStackTrace();
                    }
                    
                    if(!codiceTelaio.isEmpty() && !costoTelaio.isEmpty() && !dataInstallazioneT.isEmpty() && !materiale.isEmpty() && !pesoTelaio.isEmpty() && !costruttoreT.isEmpty()) {
                        	
                        	Componente nuovaComponente = new Componente(codiceTelaio, numeroVetturaInt, "Telaio", costoTelaioFloat, dataInstallazioneTDate, materiale, pesoTelaioFloat, null, null, null, null);
                        	if(daoC.checkComponente(codiceTelaio)) {
                        		Lavagna.append("\nComponente già inserita nel DataBase.\n");
                        		daoV.deleteVettura(numeroVetturaInt);
                        		return;
                        	}else {
                        		daoC.insertComponente(nuovaComponente, costruttoreT);
                        		Lavagna.append("\nTelaio inserito.\n");
                        	}
                        }else {
    		            	Lavagna.append("\nCampi non compilati.\n");
    		            	return;
    		            }
                	}
                
                int cambio = JOptionPane.showConfirmDialog(null, messageCamb, "Inserisci Cambio", JOptionPane.OK_CANCEL_OPTION);
                if (cambio == JOptionPane.OK_OPTION) {
                	
                	String numeroVettura = numeroVetturaField.getText();
                	String codiceCambio = codiceCambioField.getText();
                    String costoCambio = costoCambioField.getText();
                    String marce = marceField.getText();
                    String dataInstallazioneC = dataInstallazioneCField.getText();
                    costruttoreC = costruttoreCField.getText();
                    
                    int numeroVetturaInt;
                    try {
                        numeroVetturaInt = Integer.parseInt(numeroVettura);
                    } catch (NumberFormatException e3) {
                        System.err.println("\nErrore durante il parsing del numero vettura: " + e3.getMessage());
                        e3.printStackTrace();
                        return;
                    }
                    
                    if (!daoCos.checkCostruttore(costruttoreC)) {
                        Lavagna.append("\nCostruttore Cambio non esistente. Inserisci prima un costruttore.");
                        daoV.deleteVettura(numeroVetturaInt);
                        return;
                    }
                    
                    java.sql.Date dataInstallazioneCDate = null;
                    try {
                    	java.util.Date dataInstallazioneCUtil = dateFormat.parse(dataInstallazioneC);
                        dataInstallazioneCDate = new java.sql.Date(dataInstallazioneCUtil.getTime());
                    } catch (ParseException e1) {
                    	 System.err.println("\nErrore durante il parsing della data installazione cambio: " + e1.getMessage());
                        e1.printStackTrace();
                    }
                    
                    float costoCambioFloat = 0.0f; 
                    try {
                        costoCambioFloat = Float.parseFloat(costoCambio);
                    } catch (NumberFormatException e4) {
                        System.err.println("\nErrore durante il parsing del costo del cambio: " + e4.getMessage());
                        e4.printStackTrace();
                    }
                    
                    if (!marce.equals("7") && !marce.equals("8")) {
                        Lavagna.append("\nNumero marce non valido.\n");
                        daoV.deleteVettura(numeroVetturaInt);
                        return;
                    }
                    if(!codiceCambio.isEmpty() && !costoCambio.isEmpty() && !marce.isEmpty() && !dataInstallazioneC.isEmpty() && !costruttoreC.isEmpty()) {
                        	
                        	Componente nuovaComponente = new Componente(codiceCambio, numeroVetturaInt, "Cambio", costoCambioFloat, dataInstallazioneCDate, null, null, marce, null, null, null);
                        	if(daoC.checkComponente(codiceCambio)) {
                        		Lavagna.append("\nComponente già inserita nel DataBase.\n");
                        		daoV.deleteVettura(numeroVetturaInt);
                        		return;
                        	}else {
                        		daoC.insertComponente(nuovaComponente, costruttoreC);
                        		Lavagna.append("\nCambio inserito.\n");
                        	}
                    	}else {
    		            	Lavagna.append("\nCampi non compilati.\n");
    		            	return;
    		            }
                	}
				}
			});
		
		JButton btnNewButton_7 = new JButton("3: Inserisci Pilota");
		btnNewButton_7.setAutoscrolls(true);
		btnNewButton_7.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_7.setFocusTraversalPolicyProvider(true);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoPilota daoP = new DaoPilota();
				DaoEquipaggio daoE = new DaoEquipaggio();
				DaoVettura daoV = new DaoVettura();
				DaoScuderia daoS = new DaoScuderia();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				
				JTextField nomeField = new JTextField();
                JTextField cognomeField = new JTextField();
                JTextField nazionalitàField = new JTextField();
                JTextField dataNascitaField = new JTextField();
                JTextField idEquipaggioField = new JTextField();
                JTextField tipoField = new JTextField();
                JTextField primaLicenzaField = new JTextField();
                JTextField numeroLicenzeField = new JTextField();
                JTextField scuderiaField = new JTextField();

                Object[] message = {
                        "Nome:", nomeField,
                        "Cognome:", cognomeField,
                        "Nazionalità:", nazionalitàField,
                        "Data di Nascita:", dataNascitaField,
                        "ID Equipaggio:", idEquipaggioField,
                        "Tipo Pilota:\n(Pilota Pro-Pilota Am-Gentleman Driver)", tipoField,
                        "*Data 1^Licenza:", primaLicenzaField,
                        "*Numero Licenze:", numeroLicenzeField,
                        "Scuderia:", scuderiaField
                };
                
                Object[] options = {"Inserisci", "Crea Equipaggio", "Annulla"};

                int option = JOptionPane.showOptionDialog(null, message, "Inserisci Pilota", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (option == JOptionPane.YES_OPTION) {
                    
                    String nome = nomeField.getText();
                    String cognome = cognomeField.getText();
                    String nazionalità = nazionalitàField.getText();
                    String dataNascita = dataNascitaField.getText();
                    String idEquipaggio = idEquipaggioField.getText();
                    String tipo = tipoField.getText();
                    String primaLicenza = primaLicenzaField.getText();
                    String numeroLicenze = numeroLicenzeField.getText();
                    String scuderia = scuderiaField.getText();
                    
                    java.sql.Date dataNascitaDate = null;
                    try {
                    	java.util.Date dataNascitaUtil = dateFormat.parse(dataNascita);
                        dataNascitaDate = new java.sql.Date(dataNascitaUtil.getTime());
                    } catch (ParseException e1) {
                    	System.err.println("\nErrore durante il parsing della data di nascita: " + e1.getMessage());
                        e1.printStackTrace();
                    }
                    
                    java.util.Date primaLicenzaDate = null;
                    try {
                    	if (!primaLicenza.isEmpty()) {
                            java.util.Date dataPrimaLicenzaUtil = dateFormat.parse(primaLicenza);
                            primaLicenzaDate = new java.sql.Date(dataPrimaLicenzaUtil.getTime());
                        }
                    } catch (ParseException e1) {
                    	System.err.println("\nErrore durante il parsing della data prima licenza: " + e1.getMessage());
                        e1.printStackTrace();
                    }
                    
                    int numeroLicenzeInt = 0;
                    try {
                    	if (!numeroLicenze.isEmpty()) {
                            numeroLicenzeInt = Integer.parseInt(numeroLicenze);
                    	}
                    } catch (NumberFormatException e3) {
                    	System.err.println("\nErrore durante il parsing del numero licenze: " + e3.getMessage());
                        e3.printStackTrace();
                    }

                    
                    if (!nome.isEmpty() && !cognome.isEmpty() && !nazionalità.isEmpty() && !dataNascita.isEmpty() && !idEquipaggio.isEmpty() && !tipo.isEmpty() && !scuderia.isEmpty()) {
                    	if (!tipo.equals("Pilota Pro") && !tipo.equals("Pilota Am") && !tipo.equals("Gentleman Driver")
                    	        && !tipo.equals("Pilota PRO") && !tipo.equals("Pilota pro") && !tipo.equals("Pilota AM")
                    	        && !tipo.equals("Pilota am") && !tipo.equals("Gentleman driver") && !tipo.equals("gentleman driver")) {
                    	    Lavagna.append("\nTipo pilota non valido.\n");
                    	    return;
                    	}
                    	if(daoS.checkScuderia(scuderia)) {
                    	if (!daoE.checkEquipaggio(idEquipaggio)){
                    	   Lavagna.append("\nEquipaggio non esistente, Creane prima uno.\n");
                    	   return;
                    	}else if(!daoE.checkNumeroComponenti(idEquipaggio)){
                    			Lavagna.append("\nL'equipaggio: " + idEquipaggio + " ha già 3 piloti.");
                    			return;
                    		}else {
                    			if(daoE.checkEquipaggioScuderia(idEquipaggio, scuderia)) {
                    			
                    		Pilota nuovoPilota = new Pilota(nome, cognome, nazionalità, dataNascitaDate, idEquipaggio, tipo, primaLicenzaDate, numeroLicenzeInt, scuderia );
                    																
                    																//controlla quanti Gentleman Driver ci sono già nell'equipaggio
                    	if (tipo.equalsIgnoreCase("Gentleman Driver")) {			//solo se viene inserito un pilota di tipo Gentleman Driver,
                            if (!daoE.checkGentlemanDriverLimit(idEquipaggio)) {	//ignorando la differenza tra Maiuscole e minuscole
                                Lavagna.append("\nL'equipaggio ha già 2 Gentleman Driver, impossibile aggiungerne altri.\n");
                                return;
                            }
                        }
                    	
                        boolean inserimentoPilotaRiuscito = daoP.insertPilota(nuovoPilota);

                        if (inserimentoPilotaRiuscito) {
                            Lavagna.append("\nInserimento Pilota riuscito.\n");
                        } else {
                            Lavagna.append("\nInserimento Pilota non riuscito.\n");
                            return;
                        	}
                    		}else {
                    			Lavagna.append("\nEquipaggio " + idEquipaggio + " non abbinato alla scuderia " + scuderia + ".\n");
                    			return;
                    		}
                    	}
                    	}else {
                    		Lavagna.append("\nScuderia non registrata.\n");
                    		return;
                    	}
                    }else {
		            	Lavagna.append("\nCampi non compilati.\n");
		            	return;
		            }
                }else if(option == JOptionPane.NO_OPTION) {
                	
                	JTextField idEquipaggioEqField = new JTextField();
                    JTextField numeroVetturaField = new JTextField();
                    JTextField numeroComponentiField = new JTextField();
                	
                	Object[] messageEq = {
                            "ID Equipaggio:", idEquipaggioEqField,
                            "Numero Vettura:", numeroVetturaField,
                            "Numero Componenti:\nMax 3", numeroComponentiField
                    };

                    int optionEq = JOptionPane.showConfirmDialog(null, messageEq, "Inserisci Equipaggio", JOptionPane.OK_CANCEL_OPTION);
                    if (optionEq == JOptionPane.OK_OPTION){
                    	
                    	String idEquipaggio = idEquipaggioEqField.getText();
                        String numeroVettura = numeroVetturaField.getText();
                        String numeroComponenti = numeroComponentiField.getText();
                        
                        int numeroVetturaInt = 0;
                        try {
                            numeroVetturaInt = Integer.parseInt(numeroVettura);
                        } catch (NumberFormatException e3) {
                            System.err.println("\nErrore durante il parsing del numero di vettura: " + e3.getMessage());
                            e3.printStackTrace();
                        }
                        
                        int numeroComponentiInt = 0;
                        try {
                        	numeroComponentiInt = Integer.parseInt(numeroComponenti);
                        } catch (NumberFormatException e3) {
                        	System.err.println("\nErrore durante il parsing del numero componenti: " + e3.getMessage());
                            e3.printStackTrace();
                        }
                        
                        if(!idEquipaggio.isEmpty() && !numeroVettura.isEmpty() && !numeroComponenti.isEmpty()) {
                        	if(numeroComponentiInt > 3 || numeroComponentiInt <= 0) {
                        		Lavagna.append("\nNumero componenti non valido.\n");
                        		return;
                        	}
                        	if(daoV.checkVettura(numeroVetturaInt)) {
                        	if(daoE.checkEquipaggioVettura(numeroVetturaInt)) {
                        		Lavagna.append("\nQuesta vettura ha già un equipaggio registrato.\n");
                        		return;
                        	}else {
                        	Equipaggio nuovoEquipaggio = new Equipaggio(idEquipaggio, numeroVetturaInt, numeroComponentiInt);
                        	daoE.insertEquipaggio(nuovoEquipaggio);
                        	Lavagna.append("\nEquipaggio inserito.\n");
                        	}
                        }else {
                        	Lavagna.append("\nVettura non registrata.\n");
                        	return;
                        }
                      }else {
    		            Lavagna.append("\nCampi non compilati.\n");
    		            return;
    		            }
                   }
             }
		}
	});
		
		JButton btnNewButton_8 = new JButton("4: Finanziamento");
		btnNewButton_8.setAutoscrolls(true);
		btnNewButton_8.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_8.setFocusTraversalPolicyProvider(true);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoFinanziamento daoF = new DaoFinanziamento();
				DaoPilota daoP = new DaoPilota();
				DaoScuderia daoS = new DaoScuderia();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				
				JTextField scuderiaField = new JTextField();
                JTextField nomeField = new JTextField();
                JTextField cognomeField = new JTextField();
                JTextField quotaField = new JTextField();
                JTextField dataFinanziamentoField = new JTextField();
                
                Object[] message = {
                        "Scuderia:", scuderiaField,
                        "Nome Pilota:", nomeField,
                        "Cognome Pilota:", cognomeField,
                        "Quota Finanziamento:", quotaField,
                        "Data Finanziamento:", dataFinanziamentoField,
                 };

                int option = JOptionPane.showConfirmDialog(null, message, "Registra Finanziamento", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    
                    String scuderia = scuderiaField.getText();
                    String nome = nomeField.getText();
                    String cognome = cognomeField.getText();
                    String quota = quotaField.getText();
                    String dataFinanziamento = dataFinanziamentoField.getText();
                    
                    java.sql.Date dataFinanziamentoDate = null;
                    try {
                    	java.util.Date dataFinanziamentoUtil = dateFormat.parse(dataFinanziamento);
                        dataFinanziamentoDate = new java.sql.Date(dataFinanziamentoUtil.getTime());
                    } catch (ParseException e1) {
                    	System.err.println("\nErrore durante il parsing della data di nascita: " + e1.getMessage());
                        e1.printStackTrace();;
                    }
                    
                    float quotaFloat = 0.0f;
                    try {
                        quotaFloat = Float.parseFloat(quota);
                    } catch (NumberFormatException e4) {
                        System.err.println("Errore durante il parsing della quota: " + e4.getMessage());
                        e4.printStackTrace();
                    }
                    
                   if(!scuderia.isEmpty() && !nome.isEmpty() && !cognome.isEmpty() && !quota.isEmpty()) {
                	   if(daoF.checkPilotaScuderiaFinanziamento(nome, cognome, scuderia)) {
                    	if(daoS.checkScuderia(scuderia)) {
                    		if(daoP.isGentlemanDriver(nome, cognome)) {
                    			Finanziamento nuovoFinanziamento = new Finanziamento(scuderia, nome, cognome, quotaFloat, dataFinanziamentoDate);
                    		    daoF.insertFinanziamento(nuovoFinanziamento);
                    		    Lavagna.append("\nInserimento Finanziamento riuscito.\n");
                    	}else {
                    		Lavagna.append("\n" + nome + " " + cognome + " non è un Gentleman Driver.\n");
                    		return;
                    			}
                    		}else {
                    			Lavagna.append("\nScuderia non ancora registrata.\n");
                    			return;
                    		}
                    	}else {
                   			Lavagna.append("\n" + nome + " " + cognome + " non è un pilota per " + scuderia + ".\n");
                   		}
                   		}else {
    		            	Lavagna.append("\nCampi non compilati.\n");
    		            	return;
    		            }
                 	}
				}
			});
		btnNewButton_8.setMinimumSize(new Dimension(115, 23));
		
		JButton btnNewButton_9 = new JButton("5/6: Iscrizione Gara");
		btnNewButton_9.setAutoscrolls(true);
		btnNewButton_9.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_9.setFocusTraversalPolicyProvider(true);
		btnNewButton_9.setPreferredSize(new Dimension(145, 23));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoIscrizione daoI = new DaoIscrizione();
				DaoGara daoG = new DaoGara();
				DaoVettura daoV = new DaoVettura();
				int vettureInt = 0;
				String gara = null;
				
				JTextField vettureField = new JTextField();
				JTextField garaField = new JTextField();
				
				Object[] message = {
						"Nome gara:", garaField,
						"Quante vetture vuoi inserire?", vettureField
				};
				
				int option = JOptionPane.showConfirmDialog(null, message, "Numero vetture totali", JOptionPane.OK_CANCEL_OPTION);
				if(option == JOptionPane.OK_OPTION) {
					
					String vettureTxt = vettureField.getText();
								gara = garaField.getText();
					
                    try {
                    	vettureInt = Integer.parseInt(vettureTxt);
                    } catch (NumberFormatException e3) {
                    	System.err.println("\nErrore durante il parsing del numero vettura: " + e3.getMessage());
                        e3.printStackTrace();
                    	}
                 	}
				if(daoG.checkGara(gara)) {
					if(vettureInt > 0) {
						JTextField numeroVetturaField = new JTextField();
						JTextField puntiField = new JTextField();
						JTextField motivoRitiroField = new JTextField();
					
               for(int i = 1; i <= vettureInt; i++){
            	   numeroVetturaField.setText("");
                   puntiField.setText("");
                   motivoRitiroField.setText("");
                   
            	   Object[] message1 = {
            			   
							"Numero Vettura:", numeroVetturaField,
							"Punti:", puntiField,
							"*Motivo del Ritiro:\nIncidente-Guasto Meccanico-Squalifica", motivoRitiroField,
					};

					int option1 = JOptionPane.showConfirmDialog(null, message1, "Partecipazione gara", JOptionPane.OK_CANCEL_OPTION);
					if (option1 == JOptionPane.OK_OPTION) {
						
		                String numeroVettura = numeroVetturaField.getText();
						String punti = puntiField.getText();
						String motivoRitiro = motivoRitiroField.getText();
						
						int numeroVetturaInt = 0;
	                    try {
	                    	numeroVetturaInt = Integer.parseInt(numeroVettura);
	                    } catch (NumberFormatException e3) {
	                    	System.err.println("\nErrore durante il parsing del numero vettura: " + e3.getMessage());
	                        e3.printStackTrace();
	                    }
						
						int puntiInt = 0;
	                    try {
	                    	puntiInt = Integer.parseInt(punti);
	                    } catch (NumberFormatException e3) {
	                    	System.err.println("\nErrore durante il parsing dei punti: " + e3.getMessage());
	                        e3.printStackTrace();
	                    }
	                    
	                    if (!motivoRitiro.trim().isEmpty()) {
	                        if ("Incidente".equals(motivoRitiro) || "Guasto Meccanico".equals(motivoRitiro) || "Squalifica".equals(motivoRitiro)) {
	                            					// La stringa è valida (è uguale a una delle opzioni desiderate)
	                     } else {
	                    	Lavagna.append("\nMotivo del ritiro non valido.\n");
                            return;				//La stringa non corrisponde alle opzioni desiderate, interrompi.
	                     	}
	                    } else {
                             motivoRitiro = null;  // Impostare a null se è vuoto o contiene solo spazi bianchi
                        }
	                    
	                    if(!numeroVettura.isEmpty() && !punti.isEmpty()) {
	                    	if(daoV.checkVettura(numeroVetturaInt)) {
	                    	Iscrizione nuovaIscrizione = new Iscrizione(gara, numeroVetturaInt, puntiInt, motivoRitiro);
	                    	if(!daoI.checkIscrizione(nuovaIscrizione)){
	                    		daoI.insertIscrizione(nuovaIscrizione);
	                    		Lavagna.append("\nIscrizione avvenuta con Successo.\n");
	                    	}else {
	                    		Lavagna.append("\nVettura "+ numeroVetturaInt + "già iscritta alla Gara: " + gara + ".\n");
	                    		daoG.deleteGara(gara);
	                    		Lavagna.append("\nPer evitare errori, Gara eliminata. Ripeti le operazioni.\n");
	                    		return;
	                    	}
	                    }else {
	                    	Lavagna.append("\nVettura "+ numeroVetturaInt + " non registrata.\n");
	                    	return;
	                    }
	                    }else {
	                    	Lavagna.append("\nCampi non compilati.\n");
	                    	return;
	                    }
					}
               	}
            }else {
            	Lavagna.append("\nNumero vetture non valido.\n");
            	return;
            }
		}else {
			Lavagna.append("\nGara inesistente.\n");
			return;
		}
	}
});
		btnNewButton_9.setMinimumSize(new Dimension(120, 23));
		
		JButton btnNewButton_10 = new JButton("7: Verifica Componente");
		btnNewButton_10.setAutoscrolls(true);
		btnNewButton_10.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_10.setFocusTraversalPolicyProvider(true);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoComponente daoC = new DaoComponente();
				DaoVettura daoV = new DaoVettura();
				List<String> componentiMancanti = new ArrayList<>();
				
				JTextField vetturaField = new JTextField();
				
				Object[] message = {
						"Numero vettura:", vetturaField,
					};
				
				int option1 = JOptionPane.showConfirmDialog(null, message, "Verifica Componente", JOptionPane.OK_CANCEL_OPTION);
				if (option1 == JOptionPane.OK_OPTION) {
					
					String numeroVettura = vetturaField.getText();
					
					int numeroVetturaInt = 0;
					try {
                    	numeroVetturaInt = Integer.parseInt(numeroVettura);
                    } catch (NumberFormatException e3) {
                    	System.err.println("\nErrore durante il parsing del numero vettura: " + e3.getMessage());
                        e3.printStackTrace();
                    }
					
				if(!numeroVettura.isEmpty()) {
					if(daoV.checkVettura(numeroVetturaInt)){
						componentiMancanti = daoC.componentiMancanti(numeroVetturaInt);
						if (!componentiMancanti.isEmpty()) {
				            Lavagna.append("\nComponenti mancanti per la vettura:  " + numeroVetturaInt + ":");
				            for (String componente : componentiMancanti) {
				                Lavagna.append("\n" + componente);
				            }
				            Lavagna.append("\n");
				        } else {
				            Lavagna.append("\nLa vettura:  " + numeroVetturaInt + "  ha tutte le componenti.\n");
				        }
				    }else {
				    	Lavagna.append("\nVettura non ancora registrata.\n");
				    }
				}else {
					Lavagna.append("\nCampi non compilati.\n");
					return;
				}
			}
		}
	});
		
		JButton btnNewButton_11 = new JButton("8: Lista Quota Totale");
		btnNewButton_11.setAutoscrolls(true);
		btnNewButton_11.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_11.setFocusTraversalPolicyProvider(true);
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoFinanziamento daoF = new DaoFinanziamento();
		        DaoScuderia daoS = new DaoScuderia();
		        List<Scuderia> scuderie = daoS.getScuderia();
		        int i = 1;

		        for (Scuderia scuderia : scuderie) {
		            float sommaQuote = daoF.sommaQuoteFinanziamenti(scuderia.getNome());
		            Lavagna.append("\n"+ i +":  Scuderia: " + scuderia.getNome() + "\tSomma delle quote:  " + sommaQuote);
		            i++;
		        }
		        Lavagna.append("\n");
			}
		});
		
		JButton btnNewButton_12 = new JButton("10: Piloti Vincenti Casa");
		btnNewButton_12.setAutoscrolls(true);
		btnNewButton_12.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_12.setFocusTraversalPolicyProvider(true);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoPilota daoPilota = new DaoPilota();
		        List<Pilota> pilotiVincitori = daoPilota.pilotiVincitoriCasa();
		        int i = 1;

		        if (!pilotiVincitori.isEmpty()) {
		            for (Pilota pilota : pilotiVincitori) {
		                Lavagna.append("\n" + i + ":  " + pilota.getNome() + " " + pilota.getCognome() +
		                        "\tNazionalità: " + pilota.getNazionalità() + "\tCircuiti Vinti:  " + pilota.getCircuitiVinti());
		                i++;
		            }
		            Lavagna.append("\n");
		        } else {
		            Lavagna.append("\nNessun pilota ha vinto in un circuito di casa.\n");
		        }
			}
		});
		
		JButton btnNewButton_13 = new JButton("11: % Gentleman Driver");
		btnNewButton_13.setAutoscrolls(true);
		btnNewButton_13.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_13.setFocusTraversalPolicyProvider(true);
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					DaoScuderia daoScuderia = new DaoScuderia();
					List<Scuderia> scuderie = daoScuderia.getScuderia();
					int i = 1;

			        for (Scuderia scuderia : scuderie) {
			            double percentualeGentlemanDriver = daoScuderia.percentualeGentlemanDriver(scuderia.getNome());
			            DecimalFormat df = new DecimalFormat("#.##");
			            String percentualeGD = df.format(percentualeGentlemanDriver);
			            
			            Lavagna.append("\n" + i + ":  Scuderia: " + scuderia.getNome() + "\tGentleman Driver: " + percentualeGD + "%");
			            i++;
			        }
			        Lavagna.append("\n");
			    }
			});
		
		JButton btnNewButton_14 = new JButton("12: Stampa Costruttori");
		btnNewButton_14.setAutoscrolls(true);
		btnNewButton_14.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_14.setFocusTraversalPolicyProvider(true);
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoCostruttore daoC = new DaoCostruttore();
				DaoFornitura daoF = new DaoFornitura();
		        List<Costruttore> costruttori = daoC.getCostruttore();
		        
		        int i = 1;
		        for (Costruttore costruttore : costruttori) {
		            int numeroComponenti = daoF.countComponenti(costruttore.getNome());
		            Lavagna.append("\n" + i + ":  " + costruttore.toString() + "\tNumero componenti fornite:  " + numeroComponenti);
		            i++;
		        }
		        Lavagna.append("\n");
			}
		});
		
		JButton btnNewButton_15 = new JButton("13: Classifica Finale");
		btnNewButton_15.setAutoscrolls(true);
		btnNewButton_15.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_15.setFocusTraversalPolicyProvider(true);
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoIscrizione daoI = new DaoIscrizione();
				List<Object[]> totalePuntiVetture = new ArrayList<>();
				int i = 1;
				
				totalePuntiVetture = daoI.totalePunti();
				
				for (Object[] result : totalePuntiVetture) {
				    int numerovettura = (int) result[0];
				    int totalePunti = (int) result[1];
				    
				    Lavagna.append("\n" + i + "°:  Numero Vettura: " + numerovettura + "\tPunteggio Totale: " + totalePunti);
				    i++;
				}
				Lavagna.append("\n");
			}
		});
		
		JButton btnNewButton_16 = new JButton("Nuovo Costruttore");
		btnNewButton_16.setAutoscrolls(true);
		btnNewButton_16.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_16.setFocusTraversalPolicyProvider(true);
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoCostruttore daoCos = new DaoCostruttore();

			    JTextField nomeField = new JTextField();
			    JTextField sedeField = new JTextField();
			    
			    Object[] message = {
			            "Nome Costruttore:", nomeField,
			            "Sede:", sedeField,
			    };

			    int option = JOptionPane.showConfirmDialog(null, message, "Nuovo Costruttore", JOptionPane.OK_CANCEL_OPTION);
			    if (option == JOptionPane.OK_OPTION) {
			        
			        String nome = nomeField.getText();
			        String sede = sedeField.getText();

			       if(!nome.isEmpty() && !sede.isEmpty()) {
			    	   if(!daoCos.checkCostruttore(nome)) {
			    	   Costruttore nuovoCostruttore = new Costruttore(nome, sede, nome);
			    	   daoCos.insertCostruttore(nuovoCostruttore);
			    	   Lavagna.append("\nCostruttore inserito.\n");
			    	   }else {
			    		   Lavagna.append("\nCostruttore già registrato.\n");
			    		   return;
			    	   }
			       	}else {
						Lavagna.append("\nCampi non compilati.\n");
						return;
					}
			    }
			}
		});
		
		JButton btnNewButton_17 = new JButton("14: Classifica per motore");
		btnNewButton_17.setAutoscrolls(true);
		btnNewButton_17.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_17.setFocusTraversalPolicyProvider(true);
        btnNewButton_17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	DaoComponente daoC = new DaoComponente();
                List<Object[]> classificaMotore = new ArrayList<>();

                JTextArea tipoMotoreField = new JTextArea();

                Object[] message = {
                        "Tipo Motore,\nTurbo-Aspirato:", tipoMotoreField
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Tipo Motore", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String tipoMotore = tipoMotoreField.getText();

                    if (!tipoMotore.isEmpty()) {
                    	if (!tipoMotore.equals("Turbo") && !tipoMotore.equals("Aspirato") && !tipoMotore.equals("turbo") && !tipoMotore.equals("aspirato")) {
                    	    Lavagna.append("\nTipo motore non valido.\n");
                    	    return;
                    	}else {
                    		classificaMotore = daoC.classificaPuntiPerTipoMotore(tipoMotore);
                    		int i = 1;
                    		for (Object[] result : classificaMotore) {
                    			int numerovettura = (int) result[0];
                    			int totalePunti = (int) result[1];

                            Lavagna.append("\n" + i + "°:  Numero Vettura: " + numerovettura + "\tPunteggio Totale: " + totalePunti);
                            i++;
                        }
                        Lavagna.append("\n");
                    	}
                    }else {
    					Lavagna.append("\nCampi non compilati.\n");
    					return;
    				}
                }
            }
        });
		
		JButton btnNewButton_18 = new JButton("Nuovo Circuito");
		btnNewButton_18.setAutoscrolls(true);
		btnNewButton_18.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_18.setFocusTraversalPolicyProvider(true);
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoCircuito daoC = new DaoCircuito();
				
				JTextArea nomeField = new JTextArea();
				JTextArea paeseField = new JTextArea();
				JTextArea lunghezzaField = new JTextArea();
				JTextArea curveField = new JTextArea();
				
				Object[] circuitoMsg = {
						"Nome Circuito:", nomeField,
						"Paese:", paeseField,
						"Lunghezza in Km:", lunghezzaField,
						"Numero Curve:", curveField
				};
				
				int option = JOptionPane.showConfirmDialog(null, circuitoMsg, "Nuovo Circuito", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                	
                	String circuito = nomeField.getText();
                	String paese = paeseField.getText();
                	String lunghezza = lunghezzaField.getText();
                	String curve = curveField.getText();
                	
                	 float lunghezzaFloat = 0.0f;
                     try {
                         lunghezzaFloat = Float.parseFloat(lunghezza);
                     } catch (NumberFormatException e4) {
                         System.err.println("\nErrore durante il parsing della lunghezza Circuito: " + e4.getMessage());
                         e4.printStackTrace();
                     }
                     
                    int curveInt = 0;
 					try {
                     	curveInt = Integer.parseInt(curve);
                     } catch (NumberFormatException e3) {
                    	 System.err.println("\nErrore durante il parsing del numero curve: " + e3.getMessage());
                         e3.printStackTrace();
                     }
                	
                	if(!circuito.isEmpty() && !paese.isEmpty() && !lunghezza.isEmpty() && !curve.isEmpty()) {
                		if(daoC.checkCircuito(circuito)) {
                			Lavagna.append("\nCircuito già registrato.\n");
                			return;
                		}else {
                			Circuito nuovoCircuito = new Circuito(circuito, lunghezzaFloat, paese, curveInt);
                			daoC.insertCircuito(nuovoCircuito);
                			Lavagna.append("\nCircuito inserito.\n");
                		}
                	}else {
                		Lavagna.append("\nCampi non compilati.\n");
                		return;
                	}
                }
			}
		});
		
		JButton btnNewButton_20 = new JButton("15: % Punti/Minuti");
		btnNewButton_20.setAutoscrolls(true);
		btnNewButton_20.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_20.setFocusTraversalPolicyProvider(true);
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoScuderia daoScuderia = new DaoScuderia();
				List<Object[]> report = daoScuderia.reportScuderie();
				int i = 1;
				
				for (Object[] result : report) {
		            String nomeScuderia = (String) result[0];
		            int totalPunti = (int) result[1];
		            int totalMinutiGara = (int) result[2];
		            double rapportoPuntiMinuti = (double) result[3];
		            
		            DecimalFormat df = new DecimalFormat("#.##");
		            String rapportoPuntiMinutiFormatted = df.format(rapportoPuntiMinuti);

		            Lavagna.append("\n" + i + "° :  " + nomeScuderia + "\t   Punti totali: " + totalPunti + "      Minuti totali: " + totalMinutiGara + "      Rapporto Punti/Minuti: " + rapportoPuntiMinutiFormatted);
		            i++;
		        }
				Lavagna.append("\n");
			}
		});
		
		JButton btnNewButton_19 = new JButton("Nuova Gara");
		btnNewButton_19.setAutoscrolls(true);
		btnNewButton_19.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_19.setFocusTraversalPolicyProvider(true);
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoGara daoG = new DaoGara();
				DaoCircuito daoC = new DaoCircuito();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				
				JTextArea garaField = new JTextArea();
				JTextArea circuitoField = new JTextArea();
				JTextArea dataField = new JTextArea();
				JTextArea durataField = new JTextArea();
				JTextArea tipoField = new JTextArea();
				
				Object[] garaMsg = {
						"Nome Gara", garaField,
						"Nome Circuito:", circuitoField,
						"Data Evento:", dataField,
						"Durata:\nore:minuti:secondi", durataField,
						"Tipo Gara:\nAsciutta o Bagnata", tipoField
				};
				
				int option = JOptionPane.showConfirmDialog(null, garaMsg, "Nuova Gara", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                	
                	String gara = garaField.getText();
                	String circuito = circuitoField.getText();
                	String data = dataField.getText();
                	String durata = durataField.getText();
                	String tipo = tipoField.getText();
                	
                	java.sql.Date dataDate = null;
                    try {
                    	java.util.Date dataGaraUtil = dateFormat.parse(data);
                        dataDate = new java.sql.Date(dataGaraUtil.getTime());
                    } catch (ParseException e1) {
                    	System.err.println("\nErrore durante il parsing della data Gara: " + e1.getMessage());
                        e1.printStackTrace();
                    }
                    
                    
                	if(!circuito.isEmpty() && !gara.isEmpty() && !durata.isEmpty() && !tipo.isEmpty()) {
                		if(!daoG.checkGara(gara)){
                			if(!daoG.checkDate(dataDate)) {
                				if(daoC.checkCircuito(circuito)) {
                					if(tipo.equals("Asciutta") || tipo.equals("Bagnata") || tipo.equals("asciutta") || tipo.equals("bagnata")) {
                					Gara nuovaGara = new Gara(gara, circuito, dataDate, durata, tipo);
                					daoG.insertGara(nuovaGara);
                					Lavagna.append("\nGara inserita.\n");
                				}else {
                					Lavagna.append("\nTipo gara non valido.\n");
                					return;
                				}
                				}else {
                					Lavagna.append("\nCircuito non registrato.\n");
                					return;
                				}
                				
                			}else {
                				Lavagna.append("\nIn questa data è già registrata una Gara.\n");
                				return;
                			}
                		}else {
                			Lavagna.append("\nGara già registrata.\n");
                			return;
                		}
                	}else {
    					Lavagna.append("\nCampi non compilati.\n");
    					return;
    				}
                }
			}
		});
		
		JButton btnNewButton_21 = new JButton("Cancella Vettura");
		btnNewButton_21.setFocusTraversalPolicyProvider(true);
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoVettura daoV = new DaoVettura();
				JTextArea numeroField = new JTextArea();
				
				Object[] garaMsg = {
						"Numero Vettura", numeroField,
				};
				
				int option = JOptionPane.showConfirmDialog(null, garaMsg, "Nuova Gara", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                	
                	String numeroV = numeroField.getText();
                	
                	int numeroInt = 0;
 					try {
                     	numeroInt = Integer.parseInt(numeroV);
                     } catch (NumberFormatException e3) {
                    	 System.err.println("\nErrore durante il parsing del numero vettura: " + e3.getMessage());
                         e3.printStackTrace();
                     }
 					
 					if(!numeroV.isEmpty()) {
 						if(daoV.checkVettura(numeroInt)) {
 							daoV.deleteVettura(numeroInt);
 							Lavagna.append("\nVettura eliminata.\n");
 					}else {
 						Lavagna.append("\nVettura non trovata.\n");
 						return;
 					}
                }else {
                	Lavagna.append("\nCampi non compilati.\n");
                	return;
                }
            }
		}
	});
		
		JButton btnNewButton_22 = new JButton("Comp/ Vettura");
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoComponente daoC = new DaoComponente();
				DaoVettura daoV = new DaoVettura();
				List<Object[]> componentiVettura = new ArrayList<>();
				
				JTextArea numeroField = new JTextArea();
				
				Object[] garaMsg = {
						"Numero Vettura", numeroField,
				};
				
				int option = JOptionPane.showConfirmDialog(null, garaMsg, "Nuova Gara", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                	
                	String numero = numeroField.getText();
                	
                	int numeroInt = 0;
 					try {
                     	numeroInt = Integer.parseInt(numero);
                     } catch (NumberFormatException e3) {
                    	 System.err.println("\nErrore durante il parsing del numero vettura: " + e3.getMessage());
                         e3.printStackTrace();
                     }
 					
 					if(!numero.isEmpty()) {
 						if(daoV.checkVettura(numeroInt)) {
 							componentiVettura = daoC.listaComponentePerVettura(numeroInt);
 							for (Object[] result : componentiVettura) {
 								String tipo = (String) result[1];
 								String codice = (String) result[0];
 								Lavagna.append("\n" + tipo + "  Codice: " + codice);
 							}
 							Lavagna.append("\n");
 						}else {
 							Lavagna.append("\nVettura non trovata.\n");
 							return;
 					}
                }else {
                	Lavagna.append("\nCampi non compilati.\n");
                	return;
                }
			}	
		}
	});
		
		JButton btnNewButton_24 = new JButton("Modifica Compon.");
		btnNewButton_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoVettura daoV = new DaoVettura();
				DaoComponente daoC = new DaoComponente();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				
				JTextArea numeroField = new JTextArea();
				JTextArea codiceField = new JTextArea();
				JTextArea nuovoCodiceField = new JTextArea();
				JTextArea tipoField = new JTextArea();
				
				Object[] nuovaCompMsg = {
						"Numero Vettura", numeroField,
						"Codice Componente\nda eliminare:", codiceField,
						"Nuovo Codice:", nuovoCodiceField,
						"Tipo Componente:\nMotore-Telaio-Cambio:", tipoField
				};
				
				int option = JOptionPane.showConfirmDialog(null, nuovaCompMsg, "Nuova Componente", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                	
                	String numero = numeroField.getText();
                	String codice = codiceField.getText();
                	String nuovoCodice = nuovoCodiceField.getText();
                	String tipo = tipoField.getText();
                	
                	int numeroInt = 0;
 					try {
                     	numeroInt = Integer.parseInt(numero);
                     } catch (NumberFormatException e3) {
                    	 System.err.println("\nErrore durante il parsing del numero vettura: " + e3.getMessage());
                         e3.printStackTrace();
                     }
 					
 					if(!numero.isEmpty() && !codice.isEmpty() && !nuovoCodice.isEmpty() && !tipo.isEmpty()) {
 						if("Motore".equals(tipo) || "Telaio".equals(tipo) || "Cambio".equals(tipo) || "motore".equals(tipo) || "telaio".equals(tipo) || "cambio".equals(tipo)) {
 							if(daoV.checkVettura(numeroInt)) {
 								if(daoC.checkComponente(codice)) {
 									if("Motore".equals(tipo)) {
 										
 									JTextArea costruttoreField = new JTextArea();
 									JTextArea costoField = new JTextArea();
 									JTextArea dataField = new JTextArea();
 									JTextArea cilindrataField = new JTextArea();
 									JTextArea tipoMField = new JTextArea();
 									JTextArea cilindriField = new JTextArea();
 									
 									Object[] motoreMsg = {
 											"Costruttore", costruttoreField,
 											"Costo:", costoField,
 											"Data Installazione:\ndd-mm-yyyy", dataField,
 											"Cilindrata", cilindrataField,
 											"Numero Cilindri", cilindriField,
 											"Tipo Motore:\nTurbo-Aspirato:", tipoMField
 									};
 									
 									int option1 = JOptionPane.showConfirmDialog(null, motoreMsg, "Nuovo Motore", JOptionPane.OK_CANCEL_OPTION);
 					                if (option1 == JOptionPane.OK_OPTION) {
 					                	
 					                	String costruttore = costruttoreField.getText();
 					                	String costo = costoField.getText();
 					                	String data = dataField.getText();
 					                	String cilindrata = cilindrataField.getText();
 					                	String tipoM = tipoMField.getText();
 					                	String cilindri = cilindriField.getText();
 					                	
 					                	int cilindriInt = 0;
 					 					try {
 					                     	cilindriInt = Integer.parseInt(cilindri);
 					                     } catch (NumberFormatException e3) {
 					                    	 System.err.println("\nErrore durante il parsing del numero cilindri: " + e3.getMessage());
 					                         e3.printStackTrace();
 					                     }
 					 					
 					 					int cilindrataInt = 0;
 					 					try {
 					                     	cilindrataInt = Integer.parseInt(cilindrata);
 					                     } catch (NumberFormatException e3) {
 					                    	 System.err.println("\nErrore durante il parsing della cilindrata: " + e3.getMessage());
 					                         e3.printStackTrace();
 					                     }
 					 					
 					 					float costoFloat = 0.0f;
 	 				 					try {
 	 				                     	costoFloat = Float.parseFloat(costo);
 	 				                     } catch (NumberFormatException e4) {
 	 				                    	 System.err.println("\nErrore durante il parsing del costo: " + e4.getMessage());
 	 				                         e4.printStackTrace();
 	 				                     }
 					 					
 					 					java.sql.Date dataDate = null;
 					                    try {
 					                    	java.util.Date dataCostoUtil = dateFormat.parse(data);
 					                        dataDate = new java.sql.Date(dataCostoUtil.getTime());
 					                    } catch (ParseException e1) {
 					                    	System.err.println("\nErrore durante il parsing della data Installazione: " + e1.getMessage());
 					                        e1.printStackTrace();
 					                    }
 					                    
 					                   if(!costo.isEmpty() && !data.isEmpty() && !cilindrata.isEmpty() && !tipoM.isEmpty() && !cilindri.isEmpty() && !costruttore.isEmpty()) {
 					                	   if("Turbo".equals(tipoM) || "Aspirato".equals(tipoM) || "turbo".equals(tipoM) || "aspirato".equals(tipoM)) {
 					                		   if(!daoC.checkComponente(nuovoCodice)) {
 					                			   Componente nuovaComponente = new Componente(nuovoCodice, numeroInt, tipo, costoFloat, dataDate, null, null, null, cilindrataInt, tipoM, cilindriInt);
 					                			   daoC.updateComponente(numeroInt, codice, nuovaComponente, costruttore);
 					                		   }else {
 					                			   Lavagna.append("\nComponente già registrata.\n");
 					                			   return;
 					                		   }
 					                	   }else {
 					                		   Lavagna.append("\nTipo motore non valido.\n");
 					                		   return;
 					                	   }
 					                	   
 					                   }else {
 					                	   Lavagna.append("\nCampi non compilati correttamente.\n");
 					                	   return;
 					                   }
 					                }
 					             }else if("Telaio".equals(tipo)) {
 					            	 
 					            	JTextArea costruttoreField = new JTextArea();
 									JTextArea costoField = new JTextArea();
 									JTextArea dataField = new JTextArea();
 									JTextArea materialeField = new JTextArea();
 									JTextArea pesoField = new JTextArea();
 									
 									
 									Object[] telaioMsg = {
 											"Costruttore", costruttoreField,
 											"Costo:", costoField,
 											"Data Installazione:\ndd-mm-yyyy", dataField,
 											"Materiale", materialeField,
 											"Peso in Kg:", pesoField
 									};
 									
 									int option2 = JOptionPane.showConfirmDialog(null, telaioMsg, "Nuovo Telaio", JOptionPane.OK_CANCEL_OPTION);
 					                if (option2 == JOptionPane.OK_OPTION) {
 					                	
 					                	String costruttore = costruttoreField.getText();
 					                	String costo = costoField.getText();
 					                	String data = dataField.getText();
 					                	String materiale = materialeField.getText();
 					                	String peso = pesoField.getText();
 					                	
 					                	float pesoFloat = 0.0f;
 					 					try {
 					                     	pesoFloat = Float.parseFloat(peso);
 					                     } catch (NumberFormatException e4) {
 					                    	 System.err.println("\nErrore durante il parsing del peso: " + e4.getMessage());
 					                         e4.printStackTrace();
 					                     }
 					 					
 					 					float costoFloat = 0.0f;
 	 				 					try {
 	 				                     	costoFloat = Float.parseFloat(costo);
 	 				                     } catch (NumberFormatException e4) {
 	 				                    	 System.err.println("\nErrore durante il parsing del costo: " + e4.getMessage());
 	 				                         e4.printStackTrace();
 	 				                     }
 					 					
 					 					java.sql.Date dataDate = null;
 					                    try {
 					                    	java.util.Date dataCostoUtil = dateFormat.parse(data);
 					                        dataDate = new java.sql.Date(dataCostoUtil.getTime());
 					                    } catch (ParseException e1) {
 					                    	System.err.println("\nErrore durante il parsing della data Installazione: " + e1.getMessage());
 					                        e1.printStackTrace();
 					                    }
 					                    
 					                   if(!costo.isEmpty() && !data.isEmpty() && !materiale.isEmpty() && !peso.isEmpty() && !costruttore.isEmpty()) {
 					                	   if(!daoC.checkComponente(nuovoCodice)) {
 					                			   Componente nuovaComponente = new Componente(nuovoCodice, numeroInt, tipo, costoFloat, dataDate, materiale, pesoFloat, null, null, null, null);
 					                			   daoC.updateComponente(numeroInt, codice, nuovaComponente, costruttore);
 					                		   }else {
 					                			   Lavagna.append("\nComponente già registrata.\n");
 					                			   return;
 					                		   }
 					                	   }else {
 					                		   Lavagna.append("\nCampi non compilati correttamente.\n");
 					                		   return;
 					                	   	}
 					                	}
 					             	}else if("Cambio".equals(tipo)) {
 					             		
 					             		JTextArea costruttoreField = new JTextArea();
 	 									JTextArea costoField = new JTextArea();
 	 									JTextArea dataField = new JTextArea();
 	 									JTextArea marceField = new JTextArea();
 	 									
 	 									Object[] cambioMsg = {
 	 											"Costruttore", costruttoreField,
 	 											"Costo:", costoField,
 	 											"Data Installazione:\ndd-mm-yyyy", dataField,
 	 											"Marce: 7-8", marceField
 	 									};
 	 									
 	 									int option3 = JOptionPane.showConfirmDialog(null, cambioMsg, "Nuovo Cambio", JOptionPane.OK_CANCEL_OPTION);
 	 					                if (option3 == JOptionPane.OK_OPTION) {
 	 					                	
 	 					                	String costruttore = costruttoreField.getText();
 	 					                	String costo = costoField.getText();
 	 					                	String data = dataField.getText();
 	 					                	String marce = marceField.getText();
 	 					                	
 	 					                	float costoFloat = 0.0f;
 	 	 				 					try {
 	 	 				                     	costoFloat = Float.parseFloat(costo);
 	 	 				                     } catch (NumberFormatException e4) {
 	 	 				                    	 System.err.println("\nErrore durante il parsing del costo: " + e4.getMessage());
 	 	 				                         e4.printStackTrace();
 	 	 				                     }
 	 					 					
 	 					 					java.sql.Date dataDate = null;
 	 					                    try {
 	 					                    	java.util.Date dataCostoUtil = dateFormat.parse(data);
 	 					                        dataDate = new java.sql.Date(dataCostoUtil.getTime());
 	 					                    } catch (ParseException e1) {
 	 					                    	System.err.println("\nErrore durante il parsing della data Installazione: " + e1.getMessage());
 	 					                        e1.printStackTrace();
 	 					                    }
 	 					                    
 	 					                   if(!costo.isEmpty() && !data.isEmpty() && !marce.isEmpty() && !costruttore.isEmpty()) {
 	 					                	   if(!daoC.checkComponente(nuovoCodice)) {
 	 					                			   Componente nuovaComponente = new Componente(nuovoCodice, numeroInt, tipo, costoFloat, dataDate, null, null, marce, null, null, null);
 	 					                			   daoC.updateComponente(numeroInt, codice, nuovaComponente, costruttore);
 	 					                		   }else {
 	 					                			   Lavagna.append("\nComponente già registrata.\n");
 	 					                			   return;
 	 					                		   }
 	 					                	  }else {
 	 					                		 Lavagna.append("\nCampi non compilati correttamente.\n");
 	 					                		 return;
 	 					                	 }
 	 					                }
 					             	}
 								}else {
 									Lavagna.append("\nComponente da sostituire non trovata.\n");
 									return;
 								}
 						}else {
 							Lavagna.append("\nVettura non trovata.\n");
 							return;
 						}
 					}else {
 						Lavagna.append("\nTipo componente non valido.\n");
 						return;
 						}
 				}else {
						Lavagna.append("\nCampi non compilati correttamente.\n");
 						return;
 				}
            }
		}
	});
		
		JButton btnNewButton_23 = new JButton("Elimina/Inserisci Componente");
		btnNewButton_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DaoCostruttore daoCo = new DaoCostruttore();
				DaoComponente daoC = new DaoComponente();
				DaoVettura daoV = new DaoVettura();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				
				JTextArea rispField = new JTextArea();
				
				Object[] rispMsg = {
							"Inserisci o Elimina?:", rispField,
					};
					
					int option = JOptionPane.showConfirmDialog(null, rispMsg, "Inserimento o Cancellazione", JOptionPane.OK_CANCEL_OPTION);
	                if (option == JOptionPane.OK_OPTION) {
	                	
	                	String risp = rispField.getText();
	                	
	                	if(!risp.isEmpty()) {
	                		if("Inserisci".equals(risp)) {
	                			JTextArea numeroField = new JTextArea();
	            				JTextArea codiceField = new JTextArea();
	            				JTextArea tipoField = new JTextArea();
	            				
	            				Object[] compMsg = {
	            						"Numero Vettura", numeroField,
	            						"Codice:", codiceField,
	            						"Tipo Componente:\nMotore-Telaio-Cambio:", tipoField
	            				};
	            				
	            				int option1 = JOptionPane.showConfirmDialog(null, compMsg, "Nuova Componente", JOptionPane.OK_CANCEL_OPTION);
	                            if (option1 == JOptionPane.OK_OPTION) {
	                            	
	                            	String numero = numeroField.getText();
	                            	String codice = codiceField.getText();
	                            	String tipo = tipoField.getText();
	                            	
	                            	int numeroInt = 0;
	             					try {
	                                 	numeroInt = Integer.parseInt(numero);
	                                 } catch (NumberFormatException e3) {
	                                	 System.err.println("\nErrore durante il parsing del numero vettura: " + e3.getMessage());
	                                     e3.printStackTrace();
	                                 }
	             					
	             					List<String> tipiComponentiMancanti = daoC.componentiMancanti(numeroInt); 
	             				if(!tipiComponentiMancanti.isEmpty()) {
	             				if(tipiComponentiMancanti.contains(tipo)){
	             					if(numero.isEmpty() || !codice.isEmpty() || !tipo.isEmpty()) {
	             						if("Motore".equals(tipo) || "Telaio".equals(tipo) || "Cambio".equals(tipo)) {
	             							if(daoV.checkVettura(numeroInt)) {
	             								if(!daoC.checkComponente(codice)) {
	             									if("Motore".equals(tipo)) {
	             										
	             									JTextArea costruttoreField = new JTextArea();
	             									JTextArea costoField = new JTextArea();
	             									JTextArea dataField = new JTextArea();
	             									JTextArea cilindrataField = new JTextArea();
	             									JTextArea tipoMField = new JTextArea();
	             									JTextArea cilindriField = new JTextArea();
	             									
	             									Object[] motoreMsg = {
	             											"Costruttore", costruttoreField,
	             											"Costo:", costoField,
	             											"Data Installazione:\ndd-mm-yyyy", dataField,
	             											"Cilindrata", cilindrataField,
	             											"Numero Cilindri", cilindriField,
	             											"Tipo Motore:\nTurbo-Aspirato:", tipoMField
	             									};
	             									
	             									int option2 = JOptionPane.showConfirmDialog(null, motoreMsg, "Nuovo Motore", JOptionPane.OK_CANCEL_OPTION);
	             					                if (option2 == JOptionPane.OK_OPTION) {
	             					                	
	             					                	String costruttore = costruttoreField.getText();
	             					                	String costo = costoField.getText();
	             					                	String data = dataField.getText();
	             					                	String cilindrata = cilindrataField.getText();
	             					                	String tipoM = tipoMField.getText();
	             					                	String cilindri = cilindriField.getText();
	             					                	
	             					                	int cilindriInt = 0;
	             					 					try {
	             					                     	cilindriInt = Integer.parseInt(cilindri);
	             					                     } catch (NumberFormatException e3) {
	             					                    	 System.err.println("\nErrore durante il parsing del numero cilindri: " + e3.getMessage());
	             					                         e3.printStackTrace();
	             					                     }
	             					 					
	             					 					int cilindrataInt = 0;
	             					 					try {
	             					                     	cilindrataInt = Integer.parseInt(cilindrata);
	             					                     } catch (NumberFormatException e3) {
	             					                    	 System.err.println("\nErrore durante il parsing della cilindrata: " + e3.getMessage());
	             					                         e3.printStackTrace();
	             					                     }
	             					 					
	             					 					float costoFloat = 0.0f;
	             	 				 					try {
	             	 				                     	costoFloat = Float.parseFloat(costo);
	             	 				                     } catch (NumberFormatException e4) {
	             	 				                    	 System.err.println("\nErrore durante il parsing del costo: " + e4.getMessage());
	             	 				                         e4.printStackTrace();
	             	 				                     }
	             					 					
	             					 					java.sql.Date dataDate = null;
	             					                    try {
	             					                    	java.util.Date dataCostoUtil = dateFormat.parse(data);
	             					                        dataDate = new java.sql.Date(dataCostoUtil.getTime());
	             					                    } catch (ParseException e1) {
	             					                    	System.err.println("\nErrore durante il parsing della data Installazione: " + e1.getMessage());
	             					                        e1.printStackTrace();
	             					                    }
	             					                    
	             					                   if(!costo.isEmpty() && !data.isEmpty() && !cilindrata.isEmpty() && !tipoM.isEmpty() && !cilindri.isEmpty() && !costruttore.isEmpty()) {
	             					                	   if("Turbo".equals(tipoM) || "Aspirato".equals(tipoM) || "turbo".equals(tipoM) || "aspirato".equals(tipoM)) {
	             					                		   if(daoCo.checkCostruttore(costruttore)) {
	             					                		   	Componente nuovaComponente = new Componente(codice, numeroInt, tipo, costoFloat, dataDate, null, null, null, cilindrataInt, tipoM, cilindriInt);
	             					                			daoC.insertComponente(nuovaComponente, costruttore);
	             					                			Lavagna.append("\nComponente: " + codice + " inserita sulla vettura: " + numero + ".\n");
	             					                			return;
	             					                	   }else {
	             					                		   Lavagna.append("\nCostruttore non registrato.\n");
	             					                		   return;
	             					                	   }
	             					                		}else {
	             					                		   Lavagna.append("\nTipo motore non valido.\n");
	             					                		   return;
	             					                	   }
	             					                	   
	             					                	   
	             					                   }else {
	             					                	   Lavagna.append("\nCampi non compilati correttamente.\n");
	             					                	   return;
	             					                   }
	             					                }
	             					             }else if("Telaio".equals(tipo)) {
	             					            	 
	             					            	JTextArea costruttoreField = new JTextArea();
	             									JTextArea costoField = new JTextArea();
	             									JTextArea dataField = new JTextArea();
	             									JTextArea materialeField = new JTextArea();
	             									JTextArea pesoField = new JTextArea();
	             									
	             									
	             									Object[] telaioMsg = {
	             											"Costruttore", costruttoreField,
	             											"Costo:", costoField,
	             											"Data Installazione:\ndd-mm-yyyy", dataField,
	             											"Materiale", materialeField,
	             											"Peso in Kg:", pesoField
	             									};
	             									
	             									int option2 = JOptionPane.showConfirmDialog(null, telaioMsg, "Nuovo Telaio", JOptionPane.OK_CANCEL_OPTION);
	             					                if (option2 == JOptionPane.OK_OPTION) {
	             					                	
	             					                	String costruttore = costruttoreField.getText();
	             					                	String costo = costoField.getText();
	             					                	String data = dataField.getText();
	             					                	String materiale = materialeField.getText();
	             					                	String peso = pesoField.getText();
	             					                	
	             					                	float pesoFloat = 0.0f;
	             					 					try {
	             					                     	pesoFloat = Float.parseFloat(peso);
	             					                     } catch (NumberFormatException e4) {
	             					                    	 System.err.println("\nErrore durante il parsing del peso: " + e4.getMessage());
	             					                         e4.printStackTrace();
	             					                     }
	             					 					
	             					 					float costoFloat = 0.0f;
	             	 				 					try {
	             	 				                     	costoFloat = Float.parseFloat(costo);
	             	 				                     } catch (NumberFormatException e4) {
	             	 				                    	 System.err.println("\nErrore durante il parsing del costo: " + e4.getMessage());
	             	 				                         e4.printStackTrace();
	             	 				                     }
	             					 					
	             					 					java.sql.Date dataDate = null;
	             					                    try {
	             					                    	java.util.Date dataCostoUtil = dateFormat.parse(data);
	             					                        dataDate = new java.sql.Date(dataCostoUtil.getTime());
	             					                    } catch (ParseException e1) {
	             					                    	System.err.println("\nErrore durante il parsing della data Installazione: " + e1.getMessage());
	             					                        e1.printStackTrace();
	             					                    }
	             					                    
	             					                   if(!costo.isEmpty() && !data.isEmpty() && !materiale.isEmpty() && !peso.isEmpty() && !costruttore.isEmpty()) {
	             					                	   if(!daoC.checkComponente(codice)) {
	             					                		   if(daoCo.checkCostruttore(costruttore)) {
	             					                			   Componente nuovaComponente = new Componente(codice, numeroInt, tipo, costoFloat, dataDate, materiale, pesoFloat, null, null, null, null);
	             					                			   daoC.insertComponente(nuovaComponente, costruttore);
	             					                			  Lavagna.append("\nComponente: " + codice + " inserita sulla vettura: " + numero + ".\n");
		             					                			return;
	             					                		  }else {
		             					                		   Lavagna.append("\nCostruttore non registrato.\n");
		             					                		   return;
		             					                	   }
	             					                		   }else {
	             					                			   Lavagna.append("\nComponente già registrata.\n");
	             					                			   return;
	             					                		   }
	             					                	   }else {
	             					                		   Lavagna.append("\nCampi non compilati correttamente.\n");
	             					                		   return;
	             					                	   	}
	             					                	}
	             					             	}else if("Cambio".equals(tipo)) {
	             					             		
	             					             		JTextArea costruttoreField = new JTextArea();
	             	 									JTextArea costoField = new JTextArea();
	             	 									JTextArea dataField = new JTextArea();
	             	 									JTextArea marceField = new JTextArea();
	             	 									
	             	 									Object[] cambioMsg = {
	             	 											"Costruttore", costruttoreField,
	             	 											"Costo:", costoField,
	             	 											"Data Installazione:\ndd-mm-yyyy", dataField,
	             	 											"Marce: 7-8", marceField
	             	 									};
	             	 									
	             	 									int option3 = JOptionPane.showConfirmDialog(null, cambioMsg, "Nuovo Cambio", JOptionPane.OK_CANCEL_OPTION);
	             	 					                if (option3 == JOptionPane.OK_OPTION) {
	             	 					                	
	             	 					                	String costruttore = costruttoreField.getText();
	             	 					                	String costo = costoField.getText();
	             	 					                	String data = dataField.getText();
	             	 					                	String marce = marceField.getText();
	             	 					                	
	             	 					                	float costoFloat = 0.0f;
	             	 	 				 					try {
	             	 	 				                     	costoFloat = Float.parseFloat(costo);
	             	 	 				                     } catch (NumberFormatException e4) {
	             	 	 				                    	 System.err.println("\nErrore durante il parsing del costo: " + e4.getMessage());
	             	 	 				                         e4.printStackTrace();
	             	 	 				                     }
	             	 					 					
	             	 					 					java.sql.Date dataDate = null;
	             	 					                    try {
	             	 					                    	java.util.Date dataCostoUtil = dateFormat.parse(data);
	             	 					                        dataDate = new java.sql.Date(dataCostoUtil.getTime());
	             	 					                    } catch (ParseException e1) {
	             	 					                    	System.err.println("\nErrore durante il parsing della data Installazione: " + e1.getMessage());
	             	 					                        e1.printStackTrace();
	             	 					                    }
	             	 					                    
	             	 					                   if(!costo.isEmpty() && !data.isEmpty() && !marce.isEmpty() && !costruttore.isEmpty()) {
	             	 					                	   if(!daoC.checkComponente(codice)) {
	             	 					                		   if(daoCo.checkCostruttore(costruttore)) {
	             	 					                			   Componente nuovaComponente = new Componente(codice, numeroInt, tipo, costoFloat, dataDate, null, null, marce, null, null, null);
	             	 					                			   daoC.insertComponente(nuovaComponente, costruttore);
	             	 					                			 Lavagna.append("\nComponente: " + codice + " inserita sulla vettura: " + numero + ".\n");
	 	             					                			return;
	             	 					                		 }else {
	  	             					                		   Lavagna.append("\nCostruttore non registrato.\n");
	  	             					                		   return;
	  	             					                	   }
	             	 					                		   }else {
	             	 					                			   Lavagna.append("\nComponente già registrata.\n");
	             	 					                			   return;
	             	 					                		   }
	             	 					                	  }else {
	             	 					                		 Lavagna.append("\nCampi non compilati correttamente.\n");
	             	 					                		 return;
	             	 					                	 }
	             	 					                }
	             					             	}
	             								}else {
	             									Lavagna.append("\nComponente " + codice + " già registrata su un'altra vettura .\n");
	             									return;
	             								}
	             						}else {
	             							Lavagna.append("\nVettura non trovata.\n");
	             							return;
	             						}
	             					}else {
	             						Lavagna.append("\nTipo componente non valido.\n");
	             						return;
	             						}
	             				}else {
	            						Lavagna.append("\nCampi non compilati correttamente.\n");
	             						return;
	             					}
	             				}else {
	             					Lavagna.append("\nQuesta vettura ha già un "+ tipo + ".\n");
	             					return;
	             				}
	             				}else {
	             					Lavagna.append("\nLa vettura " + numero + " ha già tutte le componenti.\n");
	             					return;
	             				}
	                      }
	                }else if("Elimina".equals(risp)) {
	                	
	                	JTextArea numeroField = new JTextArea();
        				JTextArea codiceField = new JTextArea();
        				
        				Object[] deleteMsg = {
        						"Numero Vettura", numeroField,
        						"Codice:", codiceField
        				};
        				
        				int option4 = JOptionPane.showConfirmDialog(null, deleteMsg, "Elimina Componente", JOptionPane.OK_CANCEL_OPTION);
                        if (option4 == JOptionPane.OK_OPTION) {
                        	
                        	String numero = numeroField.getText();
			                String codice = codiceField.getText();
			                
			                int numeroInt = 0;
			 					try {
			                     	numeroInt = Integer.parseInt(numero);
			                     } catch (NumberFormatException e3) {
			                    	 System.err.println("\nErrore durante il parsing del numero vettura: " + e3.getMessage());
			                         e3.printStackTrace();
			                     }
			 					
			 					if(!numero.isEmpty() && !codice.isEmpty()) {
			 						List<Componente> componentiVettura = daoC.listaComponenteV(numeroInt);
			 						boolean componentePresente = false;
			 						for (Componente componente : componentiVettura) {
			 						    if (componente.getCodice().equals(codice)) {
			 						        componentePresente = true;
			 						        break;
			 						    }
			 						}
			 					if(componentePresente) {
			 						daoC.deleteComponente(codice);
			 						Lavagna.append("\nComponente " + codice + " eliminata dalla vettura " + numero + ".\n");
			 						return;
			 					}else {
			 						Lavagna.append("\nLa componente: " + codice + " non è presente sulla vettura " + numero + ".\n");
			 						return;
			 					}
			 						
			 					}else {
			 						Lavagna.append("\nCampi non compilati.\n");
			 						return;
			 					}
                        }
	                }
	                	}else {
	                		Lavagna.append("\nCampo non compilato.\n");
	                		return;
	                	}
	               
	                }
				}
			});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(Lavagna, GroupLayout.DEFAULT_SIZE, 1318, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton_18, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_19, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_3_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_16, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(243)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnNewButton_7)
											.addGap(18)
											.addComponent(btnNewButton_12))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnNewButton_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(btnNewButton_13))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnNewButton_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnNewButton_14)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton_15)
										.addComponent(btnNewButton_17)
										.addComponent(btnNewButton_20)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(6)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnNewButton_21)
											.addGap(144)
											.addComponent(btnNewButton_5)
											.addGap(10)
											.addComponent(btnNewButton_10))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(10)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(btnNewButton_22)
													.addGap(137)
													.addComponent(btnNewButton_6)
													.addGap(18)
													.addComponent(btnNewButton_11))
												.addComponent(btnNewButton_24)
												.addComponent(btnNewButton_23))))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)))
							.addGap(318))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_3_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_16, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_18, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_19, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_5)
								.addComponent(btnNewButton_10))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_6)
								.addComponent(btnNewButton_11))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_7)
								.addComponent(btnNewButton_12))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_13))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_14)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_15)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_17)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_20))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_21)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_22)
							.addGap(45)
							.addComponent(btnNewButton_24)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_23)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Lavagna, GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
					.addContainerGap())
		);
		Lavagna.append("Gerarchia Inserimento:\nIndipendenti: Circuito, Scuderia, Costruttore.\n1.Vettura 2.Equipaggio 3.Pilota 4.Finanziamento 5.Iscrizione"
				+ "\nI campi con l'asterisco sono opzionali e possono essere non compilati.\n");
		contentPane.setLayout(gl_contentPane);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewButton_3, btnNewButton, btnNewButton_2, btnNewButton_1, btnNewButton_3_1, btnNewButton_4, Lavagna, btnNewButton_5, btnNewButton_6, btnNewButton_7, btnNewButton_8, btnNewButton_9, btnNewButton_10, btnNewButton_11, btnNewButton_12, btnNewButton_13, btnNewButton_14, btnNewButton_15, btnNewButton_16, btnNewButton_17, btnNewButton_18, btnNewButton_20, btnNewButton_19, btnNewButton_21, btnNewButton_22, btnNewButton_24, btnNewButton_23}));
	}
}
