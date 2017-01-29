package Segon.Classificacio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class Gestor extends DefaultHandler {
	
	boolean llista = false;
	boolean nomClub = false;
	boolean local = false;
	boolean visitant = false;
	boolean gol = false;
	boolean partit = false;
	int golEquipL = 0;
	int golEquipV = 0;
	List<Equip> equips = new ArrayList();
	Equip equipL = null;
	Equip equipV = null;
	
	public void startDocument(){
		
	}
	
	public void endDocument(){
		List<Jugador> jugadorsEquips = new ArrayList();
		System.out.println("Ranking classificacions");
		System.out.println();
		for(Equip equip:equips){
			System.out.println(equip.toString());
			jugadorsEquips.addAll(equip.getJugadors());
		}
		// Sort jugadors
		Collections.sort(jugadorsEquips, new Comparator<Jugador>(){
			@Override
			public int compare(Jugador jugador1, Jugador jugador2){
				return jugador1.gols - jugador2.gols;
			}
		});
		System.out.println();
		System.out.println("Top 3 MVP");
		System.out.println();
		for(int i=jugadorsEquips.size()-1;i>jugadorsEquips.size()-4;i--){
			System.out.println(jugadorsEquips.get(i));
		}
		
	}
	
	public void startElement(String uri, String localName, String qName, Attributes atts){
		
		switch(qName){
		case "llista-equips":
			llista = true;
			break;
		case "partit":
			if(golEquipL!=0){
				Equip equip = buscaEquip(equipV);
				equip.repGol();
			}
			if(golEquipV!=0){
				Equip equip = buscaEquip(equipL);
				equip.repGol();
			}
			if(golEquipL>golEquipV){
				Equip equip = buscaEquip(equipL);
				equip.victoria();
				equip = buscaEquip(equipV);
				equip.derrota();
			}else if(golEquipL<golEquipV){
				Equip equip = buscaEquip(equipV);
				equip.victoria();
				equip = buscaEquip(equipL);
				equip.derrota();
			}else if(golEquipL==golEquipV && golEquipL!=0){
				Equip equip = buscaEquip(equipV);
				equip.empat();
				equip = buscaEquip(equipL);
				equip.empat();
			}
			partit = true;
			llista = false;
			nomClub = false;
			local = false;
			visitant = false;
			equipL = null;
			equipV = null;
			break;
		case "nom":
			if(llista==true || partit==true){
				nomClub = true;
			}
			break;
		case "equip":
			if(!local){
				local = true;
				visitant=false;
			}else{
				visitant = true;
				local=false;
			}
			break;
		case "jugador":
			gol = true;
			break;
		}
	}
	

	public void endElement(String namespaceURI, String localname, String qName){
		
	}
	
	public void characters(char[] ch, int start, int length){
		String text = new String(ch, start, length);
		
		if(nomClub == true && llista == true){
			equips.add(new Equip(text));
			nomClub = false;
		}
		
		if(local==true && nomClub==true){
			equipL = new Equip(text);
			nomClub = false;
		}else if(visitant==true && nomClub==true){
			equipV = new Equip(text);
			nomClub = false;
		}
		
		if(gol==true&&local==true){
			Equip equip = buscaEquip(equipL);
			equip.marca();
			buscaJugadorMarca(equip, text);
			equipL.marca();
			gol = false;
			golEquipL++;
		}else if(gol==true&&visitant==true){
			Equip equip = buscaEquip(equipV);
			equip.marca();
			buscaJugadorMarca(equip, text);
			equipV.marca();
			gol = false;
			golEquipV++;
		}
	}

	private Equip buscaEquip(Equip equipGol) {
		String nom = equipGol.getNom();
		for(Equip equip : equips){
			if(nom.equals(equip.getNom())){
				return equip;
			}
		}
		return new Equip("noTrobat");
	}
	
	private int buscaJugadorMarca(Equip equip, String text) {
		List<Jugador> jugadors = equip.getJugadors();
		for(Jugador jugador: jugadors){
			if(text.equals(jugador.getNom())){
				jugador.marca();
				return 0;
			}
		}
		equip.afegirJugador(new Jugador(text, equip.getNom()));
		return 0;
	}
	
}
