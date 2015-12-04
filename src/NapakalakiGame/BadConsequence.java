/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author dianavi
 */
public class BadConsequence {

	static final int MAXTREASURES = 10;
	private String text;
	private int levels;
	private int nVisibleTreasures;
	private int nHiddenTreasures;
	private boolean death = false;
	private ArrayList<TreasureKind> specificHiddenTreasures;
	private ArrayList<TreasureKind> specificVisibleTreasures;

	public BadConsequence(String text, int levels, int nVisible, int nHidden) {
		this.specificVisibleTreasures = new ArrayList();
		this.specificHiddenTreasures = new ArrayList();
		this.text = text;
		this.levels = levels;
		nVisibleTreasures = nVisible;
		nHiddenTreasures = nHidden;
	}

	public BadConsequence(String text, boolean death) {
		this.specificVisibleTreasures = new ArrayList();
		this.specificHiddenTreasures = new ArrayList();
		this.text = text;
		this.death = death;
		
		if (death){
			levels = Player.MAXLEVEL;
			nVisibleTreasures = MAXTREASURES;
			nHiddenTreasures = MAXTREASURES;
		}
	}

	public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden) {
		this.text = text;
		this.levels = levels;
		this.specificVisibleTreasures = tVisible;
		this.specificHiddenTreasures = tHidden;
	}
	
	public boolean isEmpty(){
		return nVisibleTreasures == 0 && nHiddenTreasures == 0 && 
				specificVisibleTreasures.isEmpty() && 
				specificHiddenTreasures.isEmpty();
	}

	public String getText() {
		return text;
	}

	public int getLevels() {
		return levels;
	}

	public int getNVisibleTreasures() {
		return nVisibleTreasures;
	}

	public int getNHiddenTreasures() {
		return nHiddenTreasures;
	}

	public boolean getDeath() {
		return death;
	}
	
	public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
		return specificVisibleTreasures;
	}
	
	public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
		return specificHiddenTreasures;
	}
	
	public void substractVisibleTreasure(Treasure t){		
		if (specificVisibleTreasures.isEmpty() && nVisibleTreasures > 0)
			nVisibleTreasures--;
		else
			specificVisibleTreasures.remove(t.getType());
	}
	
	public void substractHiddenTreasure(Treasure t){
		if (specificHiddenTreasures.isEmpty() && nHiddenTreasures > 0)
			nHiddenTreasures--;
		else
			specificHiddenTreasures.remove(t.getType());
	}

	public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
		int nVisible, nHidden;
		BadConsequence bc;
		
		// Si no hay tesoros específicos
		if (specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty()){
			if (v.size() < nVisibleTreasures)
				nVisible = v.size();
			else
				nVisible = nVisibleTreasures;
			
			if (h.size() < nHiddenTreasures)
				nHidden = h.size();
			else
				nHidden = nHiddenTreasures;
			
			// Crear el mal rollo
			bc = new BadConsequence(text, levels, nVisible, nHidden);
		}
		else{
			// Si hay tesoros específicos, bc debe llevar la intersección
			ArrayList<TreasureKind> auxVisible = new ArrayList();
			ArrayList<TreasureKind> auxHidden = new ArrayList();
			ArrayList<TreasureKind> specificV = new ArrayList(specificVisibleTreasures);
			ArrayList<TreasureKind> specificH = new ArrayList(specificHiddenTreasures);
			
			int index;
			for (Treasure treasure : v){
				index = specificV.indexOf(treasure.getType());
				
				if (index != -1){
					auxVisible.add(treasure.getType());
					specificV.remove(index);
				}
			}
			
			for (Treasure treasure : h){
				index = specificH.indexOf(treasure.getType());
				
				if (index != -1){
					auxHidden.add(treasure.getType());
					specificH.remove(index);
				}
			}
			
			bc = new BadConsequence(text, levels, auxVisible, auxHidden);
		}
		
		return bc;
	}
	
	@Override
	public String toString() {
		return text
				+ "\n\tNiveles = " + Integer.toString(levels)
				+ "\n\tTesoros visibles = " + Integer.toString(nVisibleTreasures)
				+ "\n\tTesoros ocultos = " + Integer.toString(nHiddenTreasures)
				+ "\n\tMuerte = " + Boolean.toString(death)
				+ "\n\tTesoros visibles específicos = " + specificVisibleTreasures.toString()
				+ "\n\tTesoros ocultos específicos = " + specificHiddenTreasures.toString();
	}
}
