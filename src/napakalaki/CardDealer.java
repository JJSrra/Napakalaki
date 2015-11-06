/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Juanjo
 */
public class CardDealer {
	
	private static final CardDealer instance = new CardDealer();
	private ArrayList<Treasure> unusedTreasures;
	private ArrayList<Treasure> usedTreasures;
	private ArrayList<Monster> unusedMonsters;
	private ArrayList<Monster> usedMonsters;
	
	private CardDealer() { }

	public static CardDealer getInstance() {
		return instance;
	}
	
	private void initTreasureCardDeck(){
		
	}
	
	private void initMonsterCardDeck(){
		
	}
	
	private void shuffleTreasures(){
		
	}
	
	private void shuffleMonsters(){
		
	}
	
	public Treasure nextTreasure(){
		return 0;
	}
	
	public Monster nextMonster(){
		return 0;
	}
	
	public void giveTreasureBack(Treasure t){
		
	}
	
	public void giveMonsterBack(Monster m){
		
	}
	
	public void initCards(){
		
	}
}