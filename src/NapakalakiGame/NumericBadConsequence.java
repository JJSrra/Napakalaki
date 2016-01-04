/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Juanjo
 */
public class NumericBadConsequence extends BadConsequence{
	
	protected int nVisibleTreasures;
	protected int nHiddenTreasures;
	
	public NumericBadConsequence(String text, int levels, int nVisible, int nHidden){
		this.text = text;
		this.levels = levels;
		nVisibleTreasures = nVisible;
		nHiddenTreasures = nHidden;
	}
	
	@Override
	public boolean isEmpty(){
		return nVisibleTreasures == 0 && nHiddenTreasures == 0;
	}

	@Override
	public void substractVisibleTreasure(Treasure t){
		nVisibleTreasures--;
	}
	
	@Override
	public void substractHiddenTreasure(Treasure t){
		nHiddenTreasures--;
	}
	
	@Override
	public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
		int nVisible, nHidden;
		NumericBadConsequence bc;

		if (v.size() < nVisibleTreasures) {
			nVisible = v.size();
		} else {
			nVisible = nVisibleTreasures;
		}

		if (h.size() < nHiddenTreasures) {
			nHidden = h.size();
		} else {
			nHidden = nHiddenTreasures;
		}

		// Crear el mal rollo
		bc = new NumericBadConsequence(text, levels, nVisible, nHidden);
		
		return bc;
	}

	@Override
	public String toString() {
		return text
				+ "\n\tNiveles = " + Integer.toString(levels)
				+ "\n\tTesoros visibles = " + Integer.toString(nVisibleTreasures)
				+ "\n\tTesoros ocultos = " + Integer.toString(nHiddenTreasures);
	}
}
