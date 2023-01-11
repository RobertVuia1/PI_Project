package project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class operatiElev extends JFrame {

	private JPanel contentPane;
	static operatiElev frame = new operatiElev();
	static mainMenu frame2 = new mainMenu();
	static adaugare frame3 = new adaugare();
	static stergere frame4 = new stergere();
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
	public operatiElev() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 464);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button btnadaugareElev = new Button("ADAUGARE ELEV");
		btnadaugareElev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame3.setVisible(true);
			}
		});
		btnadaugareElev.setBackground(Color.LIGHT_GRAY);
		btnadaugareElev.setFont(new Font("Arial Black", Font.ITALIC, 17));
		btnadaugareElev.setBounds(246, 103, 203, 42);
		contentPane.add(btnadaugareElev);
		
		Button btnstergereElev = new Button("STERGERE ELEV");
		btnstergereElev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame4.setVisible(true);
			}
		});
		btnstergereElev.setBackground(Color.LIGHT_GRAY);
		btnstergereElev.setFont(new Font("Arial Black", Font.ITALIC, 17));
		btnstergereElev.setBounds(246, 239, 203, 42);
		contentPane.add(btnstergereElev);
		
		Label label = new Label("OPERATI ELEV");
		label.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		label.setBackground(Color.WHITE);
		label.setBounds(271, 10, 149, 22);
		contentPane.add(label);
		
		Button button = new Button("REVENIRE MENIU PRINCIPAL");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame2.setVisible(true);
			}
		});
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(10, 371, 174, 30);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\eclipse-workspace\\PI_PROJECT_FULL\\src\\project1\\background3.jpg"));
		lblNewLabel.setBounds(0, 0, 684, 423);
		contentPane.add(lblNewLabel);
	}
}
