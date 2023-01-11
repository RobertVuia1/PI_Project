package project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import java.util.*;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField numeUtilizator;
	private JPasswordField parola;
	static login frame = new login();
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
	public login(){
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 489);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBounds(0, 0, 356, 450);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\dell\\eclipse-workspace\\PI_PROJECT_FULL\\src\\project1\\school3.jpg"));
		lblNewLabel_2.setBounds(-77, 0, 496, 439);
		panel.add(lblNewLabel_2);
		
		Button button = new Button("Logare");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = "root";
				String password = "";
				String query = "select * from admini";
				String url = "jdbc:mysql://localhost/schoolproject";
				String nume = numeUtilizator.getText().toString();
				String password2 = parola.getText().toString();
				
				try {
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException r) {
						r.printStackTrace();
					}
					Connection con = DriverManager.getConnection(url, uname, password);
					Statement statement = con.createStatement();
					ResultSet result = statement.executeQuery(query);
					String n = "";
					String p = "";
					boolean exista = false;
					
					while (result.next()) {
						for (int i = 1; i <= 2; i++) {
							if (i == 1) {
								n = result.getString(i);
							}
							else {
								p = result.getString(i);
							}
						}
						if (nume.equals(n) && password2.equals(p)) {
							exista = true;
						}
					}
					
					if (exista) {
						frame.setVisible(false);
						frame2.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Datele introduse sunt incorecte!", "Eroare logare", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException r) {
					r.printStackTrace();
				}
				
			
			}
		});
		
		button.setFont(new Font("Symbol", Font.PLAIN, 17));
		button.setForeground(SystemColor.controlHighlight);
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(449, 332, 177, 48);
		contentPane.add(button);
		
		numeUtilizator = new JTextField();
		numeUtilizator.setBounds(415, 84, 239, 31);
		contentPane.add(numeUtilizator);
		numeUtilizator.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nume utilizator");
		lblNewLabel.setFont(new Font("Arial", Font.ITALIC, 13));
		lblNewLabel.setBounds(415, 49, 108, 24);
		contentPane.add(lblNewLabel);
		
		parola = new JPasswordField();
		parola.setBounds(415, 213, 239, 31);
		contentPane.add(parola);
		
		JLabel lblNewLabel_1 = new JLabel("Parola");
		lblNewLabel_1.setFont(new Font("Arial", Font.ITALIC, 13));
		lblNewLabel_1.setBounds(415, 181, 81, 25);
		contentPane.add(lblNewLabel_1);
	}
	
	
}
