package project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class afisare extends JFrame {

	private JPanel contentPane;
	static afisare frame = new afisare();
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
	public afisare() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Choice choice = new Choice();  
		choice.add("5");  
		choice.add("6");  
		choice.add("7");  
		choice.add("8");  
		choice.add("9");  
		choice.add("10");
		choice.add("11");  
		choice.add("12");
		choice.setBounds(118, 378, 90, 26);
		contentPane.add(choice);
		
		JLabel lblNewLabel = new JLabel("CLASA");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblNewLabel.setBounds(58, 378, 70, 20);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(35, 99, 611, 241);
		contentPane.add(textArea);
		
		Button button = new Button("AFISARE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String clasa = choice.getSelectedItem();
				
				String uname = "root";
				String password = "";
				String query = "select * from elevi where clasa = " + clasa;
			
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
					String rezultat = "";
					
					rezultat = "Nume   |   CNP   |   DataNasterii   |   Clasa   |   Note   |   Absente	|   Numar Matricol" + "\n";
					
					while (result.next()) {
						String UniversityData = "";
						for (int i = 1; i <= 7; i++) {
							UniversityData += result.getString(i) + "    |    ";
						}
						rezultat += "\n" + UniversityData;
					}
					textArea.setText(rezultat);
					
				} catch (SQLException r) {
					r.printStackTrace();
				}
				
			}
		});
		button.setFont(new Font("Arial", Font.BOLD, 15));
		button.setBounds(257, 365, 158, 52);
		contentPane.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("AFISARE ELEVI");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(246, 11, 354, 52);
		contentPane.add(lblNewLabel_1);
		
		Button button_1 = new Button("REVENIRE MENIU PRINCIPAL");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame2.setVisible(true);
			}
		});
		button_1.setBounds(471, 376, 175, 22);
		contentPane.add(button_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\dell\\eclipse-workspace\\PI_PROJECT_FULL\\src\\project1\\background3.jpg"));
		lblNewLabel_2.setBounds(0, 0, 689, 427);
		contentPane.add(lblNewLabel_2);
	}
}
