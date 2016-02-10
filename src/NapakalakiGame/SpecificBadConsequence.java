/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class SpecificBadConsequence extends BadConsequence{
	
	private ArrayList<TreasureKind> specificVisibleTreasures;
	private ArrayList<TreasureKind> specificHiddenTreasures;
	
	public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
		this.text = text;
		this.levels = levels;
		specificVisibleTreasures = tVisible;
		specificHiddenTreasures = tHidden;
	}
	
	@Override
	public boolean isEmpty(){
		return specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty();
	}
	
	public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
		return specificVisibleTreasures;
	}
	
	public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
		return specificHiddenTreasures;
	}
	
	@Override
	public void substractVisibleTreasure(Treasure t){
		specificVisibleTreasures.remove(t.getType());
	}
	
	@Override
	public void substractHiddenTreasure(Treasure t){
		specificHiddenTreasures.remove(t.getType());
	}
	
	@Override
	public SpecificBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
		SpecificBadConsequence bc;
		
		ArrayList<TreasureKind> auxVisible = new ArrayList();
		ArrayList<TreasureKind> auxHidden = new ArrayList();
		ArrayList<TreasureKind> specificV = new ArrayList(specificVisibleTreasures);
		ArrayList<TreasureKind> specificH = new ArrayList(specificHiddenTreasures);

		int index;
		for (Treasure treasure : v) {
			index = specificV.indexOf(treasure.getType());

			if (index != -1) {
				auxVisible.add(treasure.getType());
				specificV.remove(index);
			}
		}

		for (Treasure treasure : h) {
			index = specificH.indexOf(treasure.getType());

			if (index != -1) {
				auxHidden.add(treasure.getType());
				specificH.remove(index);
			}
		}

		bc = new SpecificBadConsequence(text, levels, auxVisible, auxHidden);
		return bc;
	}
	
	@Override
	public String toString(){
		String bc = "<html>";
		
		if (specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty())
			bc += "No queda mal rollo por cumplir.";
		else{
			if (!specificVisibleTreasures.isEmpty()){
				bc += "Tesoros visibles: ";
				
				bc += specificVisibleTreasures.get(0);
				for (int i = 1; i < specificVisibleTreasures.size(); ++i){
					bc += ", ";
					bc += specificVisibleTreasures.get(i);
				}
				
				bc += "<br>";
			}
			
			if (!specificHiddenTreasures.isEmpty()){
				bc += "Tesoros ocultos: ";
				
				bc += specificHiddenTreasures.get(0);
				for (int i = 1; i < specificHiddenTreasures.size(); ++i){
					bc += ", ";
					bc += specificHiddenTreasures.get(i);
				}
			}
		}
			
		bc += "</html>";
		return bc;
	}
}
