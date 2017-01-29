package Segon.Classificacio;

public class Jugador {
	
	String nom = null;
	int gols = 1;
	String equip = null;
	
	public Jugador(){
		
	}
	
	public Jugador(String nom, String equip){
		this.nom=nom;
		this.equip=equip;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getGols() {
		return gols;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}
	
	public void marca(){
		gols++;
	}
	
	@Override
	public String toString() {
		return nom + "	" + gols + "	" + equip;
	}

}
