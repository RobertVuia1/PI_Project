package try1;

import java.sql.*;
import java.util.*;


public class Main {
	
	public static void inserare() throws SQLException{
		
		String uname = "root";
		String password = "";
		String url = "jdbc:mysql://localhost/schoolproject";
		String nume = "";
		String cnp = "";
		String dataNastere = "";
		String clasa = "";
		String note = "";
		String materii = "";
		PreparedStatement insert;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Scanner scan= new Scanner(System.in);
			Connection con = DriverManager.getConnection(url, uname, password);
			insert = con.prepareStatement("insert into elevi(nume, CNP, dataNastere, clasa, note, materii) values(?,?,?,?,?,?)");
			
			System.out.print("Introduceti numele: ");
		    nume = scan.nextLine();
		    System.out.print("Introduceti CNP-ul: ");
		    cnp = scan.nextLine();
		    System.out.print("Introduceti data nasterii: ");
		    dataNastere = scan.nextLine();
		    System.out.print("Introduceti clasa: ");
		    clasa = scan.nextLine();
		    int nrMaterii = 0;
		    System.out.print("Introduceti numarul de materii: ");
		    nrMaterii = scan.nextInt();
		    scan.nextLine();
		    
		    for(int i = 0; i < nrMaterii; i++) {
		    	
		    	System.out.print("Introduceti materia " + i + ": ");
		    	String materie = scan.nextLine();
		    	if (materii == "") {
		    		materii = materie;
		    	}else {
		    		materii += " " + materie;
		    	}
		    	System.out.print("Introduceti notele pentru materia " + i + ": ");
			    note += " " + scan.nextLine();
			    note += materie.charAt(0);
		    }
		    
			insert.setString(1, nume);
			insert.setString(2, cnp);
			insert.setString(3, dataNastere);
			insert.setString(4, clasa);
			insert.setString(5, note);
			insert.setString(6, materii);
			insert.executeUpdate();
			System.out.println("Elev adaugat");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		meniu();
	}
	
	public static void stergere() throws SQLException{
		
		PreparedStatement insert;
		String uname = "root";
		String password = "";
		String url = "jdbc:mysql://localhost/schoolproject";
		Scanner scan= new Scanner(System.in);
		
		System.out.print("Introduceti numele elevului care doriti sa fie sters: ");
		String nume = "";
		nume = scan.nextLine();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(url, uname, password);
			insert = con.prepareStatement("delete from elevi where nume = ?");
			insert.setString(1, nume);
			insert.executeUpdate();
			System.out.println("Elevul a fost sters cu succes");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		meniu();
		
	}
	
	public static void afisare() throws SQLException{
		String uname = "root";
		String password = "";
		String query = "select * from elevi";
		String url = "jdbc:mysql://localhost/schoolproject";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(url, uname, password);
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while (result.next()) {
				String UniversityData = "";
				for (int i = 1; i <= 6; i++) {
					UniversityData += result.getString(i) + "   |   ";
				}
				System.out.println(UniversityData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		meniu();
	}
	
	public static void cautare() throws SQLException{
		String uname = "root";
		String password = "";
		String url = "jdbc:mysql://localhost/schoolproject";
		PreparedStatement insert;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(url, uname, password);
			System.out.print("Introduceti numele elevului pe care doriti sa il cautati: ");
			Scanner scan= new Scanner(System.in);
			String nume = scan.nextLine();
			
			insert = con.prepareStatement("select * from elevi where nume = ?");
			insert.setString(1, nume);
			
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(insert.toString().substring(43));
			
			while (result.next()) {
				String UniversityData = "";
				for (int i = 1; i <= 6; i++) {
					UniversityData += result.getString(i) + "   |   ";
				}
				System.out.println(UniversityData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		meniu();
	}
	
	public static String note() throws SQLException{
		String uname = "root";
		String password = "";
		String url = "jdbc:mysql://localhost/schoolproject";
		PreparedStatement insert;
		String sirNote = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(url, uname, password);
			System.out.print("Introduceti numele elevului pe care doriti sa il cautati: ");
			Scanner scan= new Scanner(System.in);
			String nume = scan.nextLine();
			System.out.print("Introduceti numele materiei pentru care doriti sa vedeti notele: ");
			String materie = scan.nextLine();
			String notes = "";
			
			insert = con.prepareStatement("select note from elevi where nume = ?");
			insert.setString(1, nume);
			
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(insert.toString().substring(43));
			
			while (result.next()) {
				notes += result.getString(1);
			}
			String[] note = notes.split(" ");
			char initiala = materie.charAt(0);
			sirNote = "";

			for (String s: note) {
				if (s != "" && s.charAt(s.length() - 1) == initiala) {
					sirNote = sirNote + " " + s.substring(0, s.length() - 1);
					break;
				}
				else if(s != "" && s.charAt(s.length() - 1) >= '0' && s.charAt(s.length() - 1) <= '9') {
					sirNote = sirNote + " " + s;
				}
				else {
					sirNote = "";
				}
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sirNote;
	}
	
	
	
	public static void meniu() throws SQLException{
		System.out.println("Optiuni:");
		System.out.println("1.Adaugare elev");
		System.out.println("2.Stergere elev");
		System.out.println("3.Afisare elevi");
		System.out.println("4.Cautare elev");
		System.out.println("5.Afisarea notelor la o materie data pentru un elev");
		System.out.println("0.Inchidere aplicatie");
		
		Scanner scan= new Scanner(System.in);
		
		System.out.print("Optiune: ");

	    String alegere= scan.nextLine();
	    
	    switch(alegere){
		    case "1":
		    	inserare();
		    	break;
		    
			case "2":
		    	stergere();
		    	break;
		    
			case "3":
				afisare();
				break;
			
			case "4":
				cautare();
				break;
				
			case "5":
				System.out.println(note());
				break;
				
			case "0":
				break;
			
				default:
					System.out.println("Optiune gresita! Reincercati");
					meniu();}
				

		
	}

	public static void main (String args[]) throws SQLException{
			meniu();
		}
	

}
