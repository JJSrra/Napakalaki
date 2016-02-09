/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Juanjo
 */
public class Napakalaki {
	
	private static final Napakalaki instance = new Napakalaki();
	private Monster currentMonster;
	private CardDealer dealer;
	private Player currentPlayer;
	private ArrayList<Player> players;
	
	private Napakalaki() {
		dealer = CardDealer.getInstance();
		players = new ArrayList<>();
	}
	
	public static Napakalaki getInstance(){
		return instance;
	}
	
	private void initPlayers(ArrayList<String> names){
		for (String name : names)
			players.add(new Player(name));
	}
	
	private Player nextPlayer(){
		int indice;
		
		if (currentPlayer == null){
			Random rand = new Random();
			
			indice = rand.nextInt(players.size());
		}
		else{
			indice = players.indexOf(currentPlayer);
			indice = (indice + 1) % players.size();
		}
		
		currentPlayer = players.get(indice);
		return currentPlayer;
	}
	
	private boolean nextTurnAllowed(){
		return currentPlayer == null || currentPlayer.validState();
	}
	
	private void setEnemies(){
		if (players.size() == 2){
			players.get(0).setEnemy(players.get(1));
			players.get(1).setEnemy(players.get(0));
		}
		else if (players.size() == 3){
			Random rand = new Random();
			int number = rand.nextInt(2);
			
			players.get(2).setEnemy(players.get(number));
			
			if (number == 0)
				players.get(number).setEnemy(players.get(++number));
			else
				players.get(number).setEnemy(players.get(--number));

			players.get(number).setEnemy(players.get(2));
		}
	}
	
	public CombatResult developCombat(){
		CombatResult result = currentPlayer.combat(currentMonster);
		
		if (result == CombatResult.LOSEANDCONVERT){
			Cultist cultist = dealer.nextCultist();
			CultistPlayer convertedPlayer = new CultistPlayer(currentPlayer, cultist);
			
			// Actualizar los jugadores
			players.set(players.indexOf(currentPlayer), convertedPlayer);
			currentPlayer = convertedPlayer;
		}
		
		return result;
	}
	
	public void discardVisibleTreasures(ArrayList<Treasure> treasures){
		for (Treasure treasure : treasures){
			currentPlayer.discardVisibleTreasure(treasure);
			dealer.giveTreasureBack(treasure);
		}
	}
	
	public void discardHiddenTreasures(ArrayList<Treasure> treasures){
		for (Treasure treasure : treasures){
			currentPlayer.discardHiddenTreasure(treasure);
			dealer.giveTreasureBack(treasure);
		}
	}
	
	public void makeTrasuresVisible(ArrayList<Treasure> treasures){
		for (Treasure t : treasures){
			currentPlayer.makeTreasureVisible(t);
		}
	}
	
	public void initGame(ArrayList<String> players){
		initPlayers(players);
		setEnemies();
		dealer.initCards();
		nextTurn();
	}
	
	public Player getCurrentPlayer(){
		return currentPlayer;
	}
	
	public Monster getCurrentMonster(){
		return currentMonster;
	}
	
	public boolean nextTurn(){
		boolean stateOK = nextTurnAllowed();
		
		if (stateOK){
			currentMonster = dealer.nextMonster();
			currentPlayer = nextPlayer();
			
			boolean dead = currentPlayer.isDead();
			if (dead){
				currentPlayer.initTreasures();
			}
		}
		
		return stateOK;
	}
	
	public boolean endOfGame(CombatResult result){
		return result == CombatResult.WINGAME;
	}
}
