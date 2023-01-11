package project1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class mainMenu extends JFrame {

	private JPanel contentPane;
	static mainMenu frame = new mainMenu();
	static operatiElev frame2 = new operatiElev();
	static catalog frame3 = new catalog();
	static note frame4 = new note();
	static afisare frame5 = new afisare();

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
	public mainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 466);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button operatiElev = new Button("OPERATI ELEVI");
		operatiElev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame2.setVisible(true);
			}
		});
		operatiElev.setFont(new Font("Magneto", Font.BOLD | Font.ITALIC, 13));
		operatiElev.setBackground(Color.GRAY);
		operatiElev.setBounds(72, 90, 211, 37);
		contentPane.add(operatiElev);
		
		Button button_1 = new Button("CATALOG PREZENTA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame3.setVisible(true);
			}
		});
		button_1.setFont(new Font("Magneto", Font.BOLD | Font.ITALIC, 13));
		button_1.setBackground(Color.GRAY);
		button_1.setBounds(72, 261, 211, 37);
		contentPane.add(button_1);
		
		Button button_1_1 = new Button("ADAUGARE NOTE");
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame4.setVisible(true);
			}
		});
		button_1_1.setFont(new Font("Magneto", Font.BOLD | Font.ITALIC, 13));
		button_1_1.setBackground(Color.GRAY);
		button_1_1.setBounds(444, 90, 211, 37);
		contentPane.add(button_1_1);
		
		Button button_1_2 = new Button("AFISARE ELEVI");
		button_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame5.setVisible(true);
			}
		});
		button_1_2.setFont(new Font("Magneto", Font.BOLD | Font.ITALIC, 13));
		button_1_2.setBackground(Color.GRAY);
		button_1_2.setBounds(444, 261, 211, 37);
		contentPane.add(button_1_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\eclipse-workspace\\PI_PROJECT_FULL\\src\\project1\\background2.jpg"));
		lblNewLabel.setBounds(0, 50, 689, 373);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Meniu principal");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(276, 0, 255, 39);
		contentPane.add(lblNewLabel_1);
	}
}
