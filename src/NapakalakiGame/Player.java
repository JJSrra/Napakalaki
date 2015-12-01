/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author diego
 */
public class Player {
	
	static final int MAXLEVEL = 10;
	private String name;
	private int level;
	private boolean dead;
	private boolean canISteal;
	private Player enemy;
	private ArrayList<Treasure> visibleTreasures;
	private ArrayList<Treasure> hiddenTreasures;
	private BadConsequence pendingBadConsequence;
	
	public Player(String name){
		this.name = name;
		dead = true;
		visibleTreasures = new ArrayList<>();
		hiddenTreasures = new ArrayList<>();
		pendingBadConsequence = new BadConsequence("", 0, 0, 0);
		level = 1;
	}
	
	public String getName(){
		return name;
	}
	
	private void bringToLife(){
		dead = true;
	}
	
	private int getCombatLevel(){
		int l = level;
		
		for (Treasure t : visibleTreasures){
			l += t.getBonus();
		}
		
		return l;
	}
	
	private void incrementLevels(int l){
		level += l;
		
		if (level > MAXLEVEL)
			level = MAXLEVEL;
	}
	
	private void decrementLevels(int l){
		level -= l;
		
		if (level < 1)
			level = 1;
	}
	
	private void setPendingBadConsequence(BadConsequence b){
		pendingBadConsequence = b;
	}
	
	private void applyPrize(Monster m){
		int nLevels = m.getLevelsGained();
		
		incrementLevels(nLevels);
		
		int nTreasures = m.getTreasuresGained();
		
		if (nTreasures > 0){
			CardDealer dealer = CardDealer.getInstance();
			
			for (int i = 0; i < nTreasures; ++i){
				Treasure treasure = dealer.nextTreasure();
				hiddenTreasures.add(treasure);
			}
		}
	}
	
	private void applyBadConsequence(Monster m){
		BadConsequence badConsequence = m.getBadConsequence();
		int nLevels = badConsequence.getLevels();
		
		decrementLevels(nLevels);
		
		BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
		setPendingBadConsequence(pendingBad);
	}
	
	private boolean canMakeTreasureVisible(Treasure t){
		boolean allowed = true;
		int onehands = 0;
		if (t.getType() == TreasureKind.BOTHHANDS){
			for (Treasure treasures : visibleTreasures){
				if (treasures.getType() == t.getType() || treasures.getType() == TreasureKind.ONEHAND){
					allowed = false;
				}
			}
		}else if (t.getType() == TreasureKind.ONEHAND){
			for (Treasure treasures : visibleTreasures){
				if (treasures.getType() == TreasureKind.ONEHAND){
					onehands++;
				}
				if (treasures.getType() == TreasureKind.BOTHHANDS || onehands >= 2){
					allowed = false;
				}
			}
		}else {
			for (Treasure treasures : visibleTreasures){
				if (treasures.getType() == t.getType()){
					allowed = false;
				}
			}
		}
		return allowed;
	}
	
	private int howManyVisibleTreasures(TreasureKind tKind){
		int treasureNumber = 0;
		
		for (Treasure t : visibleTreasures){
			if (t.getType() == tKind)
				treasureNumber++;
		}
		
		return treasureNumber;
	}
	
	private void dieIfNoTreasures(){
		if (visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
			dead = true;
	}
	
	public boolean isDead(){
		return dead;
	}
	
	public ArrayList<Treasure> getHiddenTreasures(){
		return hiddenTreasures;
	}
	
	public ArrayList<Treasure> getVisibleTreasures(){
		return visibleTreasures;
	}
	
	public CombatResult combat(Monster m){
		int myLevel = getCombatLevel();
		int monsterLevel = m.getCombatLevel();
		CombatResult combatResult;
		
		if (myLevel > monsterLevel){
			applyPrize(m);
			
			if (level >= MAXLEVEL)
				combatResult = CombatResult.WINGAME;
			else
				combatResult = CombatResult.WIN;
		}
		else{
			applyBadConsequence(m);
			combatResult = CombatResult.LOSE;
		}
		
		return combatResult;
	}
	
	public void makeTreasureVisible(Treasure t){
		boolean canI = canMakeTreasureVisible(t);
		
		if (canI){
			visibleTreasures.add(t);
			hiddenTreasures.remove(t);
		}
	}
	
	public void discardVisibleTreasure(Treasure t){
		visibleTreasures.remove(t);
		
		if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty()){
			pendingBadConsequence.substractVisibleTreasure(t);
		}
		
		dieIfNoTreasures();
	}
	
	public void discardHiddenTreasure(Treasure t){
		hiddenTreasures.remove(t);
		
		if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty()){
			pendingBadConsequence.substractHiddenTreasure(t);
		}
		
		dieIfNoTreasures();
	}
	
	public boolean validState(){
		return pendingBadConsequence.isEmpty() && hiddenTreasures.size() <= 4;
	}
	
	public void initTreasures(){
		CardDealer dealer = CardDealer.getInstance();
		Dice dice = Dice.getInstance();
		
		bringToLife();
		
		Treasure treasure = dealer.nextTreasure();
		hiddenTreasures.add(treasure);
		
		int number = dice.nextNumber();
		
		if (number > 1){
			treasure = dealer.nextTreasure();
			hiddenTreasures.add(treasure);
		}
		
		if (number == 6){
			treasure = dealer.nextTreasure();
			hiddenTreasures.add(treasure);
		}
	}
	
	public int getLevels(){
		return level;
	}
	
	public Treasure stealTreasure(){
		boolean canI = canISteal();
		Treasure treasure = null;
		
		if (canI){
			boolean canYou = enemy.canYouGiveMeATreasure();
			
			if (canYou){
				treasure = enemy.giveMeATreasure();
				hiddenTreasures.add(treasure);
				
				haveStolen();
			}
		}
		
		return treasure;
	}
	
	public void setEnemy(Player enemy){
		this.enemy = enemy;
	}
	
	private Treasure giveMeATreasure(){
		Random rand = new Random();
		int index = rand.nextInt(hiddenTreasures.size());
		return hiddenTreasures.get(index);
	}
	
	public boolean canISteal(){
		return canISteal;
	}
	
	private boolean canYouGiveMeATreasure(){
		return !hiddenTreasures.isEmpty();
	}
	
	private void haveStolen(){
		canISteal = false;
	}
	
	public void discardAllTreasures(){
		ArrayList<Treasure> visible = new ArrayList(visibleTreasures);
		ArrayList<Treasure> hidden = new ArrayList(hiddenTreasures);

		for (Treasure treasure : visible){
			discardVisibleTreasure(treasure);
		}
		
		for (Treasure treasure : hidden){
			discardHiddenTreasure(treasure);
		}
	}
	
	@Override
	public String toString(){
		return name + ", Nivel: " + level;
	}
}