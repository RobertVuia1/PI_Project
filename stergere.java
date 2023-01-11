package project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class stergere extends JFrame {

	private JPanel contentPane;
	private JTextField textMatricol;
	static stergere frame = new stergere();
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
	public stergere() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textMatricol = new JTextField();
		textMatricol.setBounds(345, 153, 228, 20);
		contentPane.add(textMatricol);
		textMatricol.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NUMAR MATRICOL");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(158, 155, 151, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("STERGERE ELEV");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(223, 24, 249, 24);
		contentPane.add(lblNewLabel_1);
		
		Button button = new Button("STERGERE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement insert;
				String uname = "root";
				String password = "";
				String url = "jdbc:mysql://localhost/schoolproject";
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException r) {
					r.printStackTrace();
				}
				
				try {
					String nrMatricol = textMatricol.getText();
					Connection con = DriverManager.getConnection(url, uname, password);
					insert = con.prepareStatement("delete from elevi where nrMatricol = ?");
					insert.setString(1, nrMatricol);
					insert.executeUpdate();
				} catch (SQLException r) {
					r.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Elevul a fost sters cu succes!", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				frame2.setVisible(true);
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 15));
		button.setBounds(264, 246, 151, 68);
		contentPane.add(button);
		
		Button button_1 = new Button("REVENIRE MENIU PRINCIPAL");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame2.setVisible(true);
			}
		});
		button_1.setBounds(487, 374, 174, 22);
		contentPane.add(button_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\dell\\eclipse-workspace\\PI_PROJECT_FULL\\src\\project1\\background5.jpg"));
		lblNewLabel_2.setBounds(0, 0, 689, 427);
		contentPane.add(lblNewLabel_2);
	}

}
