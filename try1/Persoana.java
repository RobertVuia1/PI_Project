package try1;

public abstract class Persoana {
	String nume;
	String CNP;
	String dataNastere;
	
	Persoana(String nume, String cNP, String dataNastere) {
		super();
		this.nume = nume;
		CNP = cNP;
		this.dataNastere = dataNastere;
	}
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getCNP() {
		return CNP;
	}
	public void setCNP(String cNP) {
		CNP = cNP;
	}
	public String getDataNastere() {
		return dataNastere;
	}
	public void setDataNastere(String dataNastere) {
		this.dataNastere = dataNastere;
	}

	@Override
	public String toString() {
		return "Persoana [nume=" + nume + ", CNP=" + CNP + ", dataNastere=" + dataNastere + "]";
	}
	
	
	
}
