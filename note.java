package project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class note extends JFrame {

	private JPanel contentPane;
	private JTextField textMaterie;
	private JTextField textNume;
	static note frame = new note();
	PreparedStatement insert;
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
	public note() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NUME ELEV");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel.setBounds(72, 129, 95, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOTA");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(72, 218, 77, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MATERIE");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(72, 308, 77, 26);
		contentPane.add(lblNewLabel_2);
		
		textMaterie = new JTextField();
		textMaterie.setBounds(184, 312, 162, 20);
		contentPane.add(textMaterie);
		textMaterie.setColumns(10);
		
		Choice choice = new Choice();
		choice.add("1");  
		choice.add("2");  
		choice.add("3");  
		choice.add("4");  
		choice.add("5");  
		choice.add("6");  
		choice.add("7");  
		choice.add("8");  
		choice.add("9");  
		choice.add("10");  
		choice.setBounds(184, 218, 62, 20);
		contentPane.add(choice);
		
		textNume = new JTextField();
		textNume.setBounds(184, 133, 162, 20);
		contentPane.add(textNume);
		textNume.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("INTRODUCERE NOTA");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3.setBounds(240, 11, 373, 41);
		contentPane.add(lblNewLabel_3);
		
		Button button = new Button("ADAUGA NOTA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nume = textNume.getText();
				String materie = textMaterie.getText();
				String nota = choice.getSelectedItem();
				
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
						String rezultatNote = result.getString(1);
					
					
						rezultatNote += ";" + materie + ":" + nota;
						
						System.out.println(rezultatNote);
						
						insert = con.prepareStatement("UPDATE elevi SET note = '" + rezultatNote + "' WHERE nume = '" + nume + "'");
						insert.setString(1, rezultatNote);
						insert.setString(2, nume);
						insert.executeUpdate();
					}
					else {
						String rezultatNote = materie + ":" + nota;
						insert = con.prepareStatement("UPDATE elevi SET note = '" + rezultatNote + "' WHERE nume = '" + nume + "'");
						insert.executeUpdate();
					}
					
					
				} catch (SQLException r) {
					r.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Nota a fost introdusa cu succes!", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button.setFont(new Font("Arial", Font.BOLD, 18));
		button.setBounds(470, 166, 162, 95);
		contentPane.add(button);
		
		Button button_1 = new Button("REVENIRE MENIU PRINCIPAL");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame2.setVisible(true);
			}
		});
		button_1.setBounds(470, 395, 175, 22);
		contentPane.add(button_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\dell\\eclipse-workspace\\PI_PROJECT_FULL\\src\\project1\\background6.jpg"));
		lblNewLabel_4.setBounds(0, 0, 689, 427);
		contentPane.add(lblNewLabel_4);
	}
}
