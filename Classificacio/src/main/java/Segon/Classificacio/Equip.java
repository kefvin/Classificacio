package Segon.Classificacio;

import java.util.ArrayList;
import java.util.List;

public class Equip {

	String nom = null;
	int v = 0;
	int d = 0;
	int e = 0;
	int gf = 0;
	int gc = 0;
	int p = 0;
	List<Jugador> jugadors = new ArrayList();
	
	public Equip(){
	}
	
	public Equip(String nom){
		this.nom = nom;
	}
	
	public void marca(){
		gf++;
	}
	
	public void repGol(){
		gc++;
	}
	
	public void victoria(){
		v++;
		p+=3;
	}
	
	public void derrota(){
		d++;
	}
	
	public void empat(){
		e++;
		p+=1;
	}

	public void afegirJugador(Jugador j){
		jugadors.add(j);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public int getGf() {
		return gf;
	}

	public void setGf(int gf) {
		this.gf = gf;
	}

	public int getGc() {
		return gc;
	}

	public void setGc(int gc) {
		this.gc = gc;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public List<Jugador> getJugadors() {
		return jugadors;
	}

	public void setJugadors(List<Jugador> jugadors) {
		this.jugadors = jugadors;
	}
	
	@Override
	public String toString() {
		return nom + " " + v + " " + d + " " + e + " " + gf + " " + gc + " " + p;
	}
}
