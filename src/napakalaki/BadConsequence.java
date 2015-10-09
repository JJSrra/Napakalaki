/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author dianavi
 */
public class BadConsequence {

	private String text;
	private int levels;
	private int nVisibleTreasures;
	private int nHiddenTreasures;
	private boolean death;
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
	}

	public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden) {
		this.text = text;
		this.levels = levels;
		this.specificVisibleTreasures = tVisible;
		this.specificHiddenTreasures = tHidden;
	}

	public String getText() {
		return text;
	}

	public int getLevels() {
		return levels;
	}

	public int getVisible() {
		return nVisibleTreasures;
	}

	public int getHidden() {
		return nHiddenTreasures;
	}

	public boolean getDeath() {
		return death;
	}

	@Override
	public String toString() {
		return "Text = " + text
				+ ", Levels = " + Integer.toString(levels)
				+ ", Visible Treasures = " + Integer.toString(nVisibleTreasures)
				+ ", Hidden Tresaures = " + Integer.toString(nHiddenTreasures)
				+ ", Death = " + Boolean.toString(death)
				+ ", Specific Visible Treasures = " + specificVisibleTreasures.toString()
				+ ", Specific Hidden Treasures = " + specificHiddenTreasures.toString();
	}
}
