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
public class Dice {
	private static final Dice dice = new Dice();
	
	private Dice(){	}
	
	public static Dice getInstance(){
		return dice;
	}
	
	public int nextNumber(){
		Random rand = new Random();
		return rand.nextInt(6) + 1;
	}	
}

