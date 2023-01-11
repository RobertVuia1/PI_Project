package project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class adaugare extends JFrame {

	private JPanel contentPane;
	private JTextField textNume;
	private JTextField textCnp;
	private JTextField textMatricol;
	private JTextField textClasa;
	private JTextField textData;
	static adaugare frame = new adaugare();
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
	public adaugare() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNume = new JTextField();
		textNume.setBounds(211, 98, 168, 26);
		contentPane.add(textNume);
		textNume.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NUME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(64, 103, 46, 14);
		contentPane.add(lblNewLabel);
		
		textCnp = new JTextField();
		textCnp.setBounds(211, 157, 168, 26);
		contentPane.add(textCnp);
		textCnp.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CNP");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(64, 162, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textMatricol = new JTextField();
		textMatricol.setBounds(211, 327, 168, 26);
		contentPane.add(textMatricol);
		textMatricol.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DATA NASTERII");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(64, 222, 104, 14);
		contentPane.add(lblNewLabel_2);
		
		textClasa = new JTextField();
		textClasa.setBounds(211, 272, 168, 26);
		contentPane.add(textClasa);
		textClasa.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CLASA");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(64, 277, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textData = new JTextField();
		textData.setBounds(211, 216, 168, 26);
		contentPane.add(textData);
		textData.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("NUMAR MATRICOL");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(64, 332, 116, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("INTRODUCERE ELEV");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblNewLabel_5.setBounds(211, 11, 267, 26);
		contentPane.add(lblNewLabel_5);
		
		Button button = new Button("ADAUGARE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = "root";
				String password = "";
				String url = "jdbc:mysql://localhost/schoolproject";
				PreparedStatement insert;
				
				try {
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException r) {
						r.printStackTrace();
					}
					Connection con = DriverManager.getConnection(url, uname, password);
					insert = con.prepareStatement("insert into elevi(nume, CNP, dataNasterii, clasa, note, absente, nrMatricol) values(?,?,?,?,?,?,?)");
					
					String nume = textNume.getText();
					String cnp = textCnp.getText();
					String dataNasterii = textData.getText();
					String clasa = textClasa.getText();
					String note = "";
					String absente = "";
					String nrMatricol = textMatricol.getText();
					
					insert.setString(1, nume);
					insert.setString(2, cnp);
					insert.setString(3, dataNasterii);
					insert.setString(4, clasa);
					insert.setString(5, note);
					insert.setString(6, absente);
					insert.setString(7, nrMatricol);
					insert.executeUpdate();
					
				} catch (SQLException r) {
					r.printStackTrace();
				}
				
				
				JOptionPane.showMessageDialog(null, "Elevul a fost introdus cu succes!", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				frame2.setVisible(true);
			}
		});
		button.setFont(new Font("Arial", Font.ITALIC, 18));
		button.setBounds(494, 185, 143, 57);
		contentPane.add(button);
		
		Button button_1 = new Button("REVENIRE MENIU PRINCIPAL");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame2.setVisible(true);
			}
		});
		button_1.setBounds(476, 367, 174, 22);
		contentPane.add(button_1);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\dell\\eclipse-workspace\\PI_PROJECT_FULL\\src\\project1\\background5.jpg"));
		lblNewLabel_6.setBounds(0, 0, 689, 427);
		contentPane.add(lblNewLabel_6);
	}
}
