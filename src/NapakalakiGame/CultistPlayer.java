/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.Random;

/**
 *
 * @author diego
 */
public class CultistPlayer extends Player{
	private static int totalCultistPlayers = 0;
	
	private Cultist myCultistCard;
	
	public CultistPlayer(Player p, Cultist c){
		super(p);
		
		myCultistCard = c;
		totalCultistPlayers++;
	}
	
	@Override
	protected int getCombatLevel(){
		return ((int)(super.getCombatLevel() * 1.20)) + myCultistCard.getGainedLevels() * totalCultistPlayers;
	}
	
	@Override
	protected int getOponentLevel(Monster m){
		return m.getCombatLevelAgainstCultistPlayer();
	}
	
	@Override
	protected boolean shouldConvert(){
		return false;
	}
	
	@Override
	protected Treasure giveMeATreasure(){
		Random rand = new Random();
		int index = rand.nextInt(getVisibleTreasures().size());
		return getVisibleTreasures().get(index);
	}
	
	@Override
	protected boolean canYouGiveMeATreasure(){
		return !getVisibleTreasures().isEmpty();
	}
	
	public static int getTotalCultistPlayers(){
		return totalCultistPlayers;
	}
}
