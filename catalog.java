package project1;

import java.awt.EventQueue;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Choice;

public class catalog extends JFrame{

	private JPanel contentPane;
	private JTextField textContent;
	PreparedStatement insert;
	int contor = 0;
	static catalog frame = new catalog();
	static mainMenu frame2 = new mainMenu();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public catalog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CATALOG PREZENTE");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblNewLabel_1.setBounds(245, 24, 247, 30);
		contentPane.add(lblNewLabel_1);
		
		textContent = new JTextField();
		textContent.setText("Apasati pe butonul URMATORUL pentru a incepe");
		textContent.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textContent.setBounds(245, 164, 289, 98);
		contentPane.add(textContent);
		textContent.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ELEV:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(196, 196, 55, 30);
		contentPane.add(lblNewLabel_2);
		
		Button button = new Button("PREZENT");
		button.setFont(new Font("Arial", Font.BOLD, 13));
		button.setBounds(181, 310, 90, 39);
		contentPane.add(button);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(514, 104, 100, 20);
		choice_1.add("Romana");    
        choice_1.add("Matematica");    
        choice_1.add("Informatica");    
        choice_1.add("Biologie");    
        choice_1.add("Istorie");
        choice_1.add("Chimie");
		contentPane.add(choice_1);
		
		Button button_1 = new Button("ABSENT");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
				   LocalDateTime now = LocalDateTime.now();  
				   //System.out.println(dtf.format(now)); 
				   
				    
				   	String nume = textContent.getText();
				   	
				   	String materie = choice_1.getSelectedItem();
				    String uname = "root";
					String password = "";
					String query = "select absente from elevi where nume = '" + nume + "'";
					
				
					String url = "jdbc:mysql://localhost/schoolproject";
					
					try {
						
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
						} catch (ClassNotFoundException r) {
							r.printStackTrace();
						}
						Connection con = DriverManager.getConnection(url, uname, password);
						Statement statement = con.createStatement();
						ResultSet result = statement.executeQuery(query);
						
						
						if (!result.isBeforeFirst()) {
							String rezultatAbsente = result.getString(1);
							
							System.out.println(rezultatAbsente);
						
						
							rezultatAbsente += ";" + materie + ":" + dtf.format(now);
							
							System.out.println(rezultatAbsente);
							System.out.println("Am ajuns 2");
							
							insert = con.prepareStatement("UPDATE elevi SET absente = '" + rezultatAbsente + "' WHERE nume = '" + nume + "'");
							insert.setString(1, rezultatAbsente);
							insert.setString(2, nume);
							insert.executeUpdate();
						}
						else {
							String rezultatAbsente = materie + ":" + dtf.format(now);
							insert = con.prepareStatement("UPDATE elevi SET absente = '" + rezultatAbsente + "' WHERE nume = '" + nume + "'");
							insert.executeUpdate();
						}
						
						
					} catch (SQLException r) {
						r.printStackTrace();
					}
				
			}
		});
		button_1.setFont(new Font("Arial", Font.BOLD, 13));
		button_1.setBounds(453, 310, 90, 39);
		contentPane.add(button_1);
		
		Choice choice = new Choice();
		choice.setBounds(196, 104, 91, 20);
		choice.add("5");    
        choice.add("6");    
        choice.add("7");    
        choice.add("8");    
        choice.add("9");
        choice.add("10");
        choice.add("11");
        choice.add("12");
		contentPane.add(choice);
		
		Button button_2 = new Button("URMATORUL");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				
				String clasa = choice.getSelectedItem();
		
				String uname = "root";
				String password = "";
				String query = "select nume from elevi where clasa = " + clasa;
			
				String url = "jdbc:mysql://localhost/schoolproject";
				
				try {
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException r) {
						r.printStackTrace();
					}
					Connection con = DriverManager.getConnection(url, uname, password);
					Statement statement = con.createStatement();
					ResultSet result = statement.executeQuery(query);
					
					contor++;
					for (int i = 1; i <= contor; i++) {
						result.next();
					}
					String nume = result.getString(1);
					textContent.setText(nume);
					
				} catch (SQLException r) {
					r.printStackTrace();
				}
				
			}
		});
		button_2.setFont(new Font("Arial", Font.BOLD, 13));
		button_2.setBackground(SystemColor.menu);
		button_2.setBounds(299, 292, 131, 76);
		contentPane.add(button_2);
		
		
		JLabel lblNewLabel_3 = new JLabel("Clasa");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(154, 104, 62, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Materia");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(453, 104, 55, 14);
		contentPane.add(lblNewLabel_4);
		
		Button button_3 = new Button("REVENIRE MENIU PRINCIPAL");
		button_3.setBackground(Color.LIGHT_GRAY);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame2.setVisible(true);
			}
		});
		button_3.setBounds(483, 395, 178, 22);
		contentPane.add(button_3);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(41, 11, 620, 427);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\eclipse-workspace\\PI_PROJECT_FULL\\src\\project1\\background4.jpg"));
		contentPane.add(lblNewLabel);
	}
}
