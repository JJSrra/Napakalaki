/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author dianavi
 */
public enum TreasureKind {

	ARMOR,
	ONEHAND,
	BOTHHANDS,
	HELMET,
	SHOES;
	
	@Override
	public String toString(){
		switch (this){
			case ARMOR: return "Armadura";
			case ONEHAND: return "Una mano";
			case BOTHHANDS: return "Dos manos";
			case HELMET: return "Casco";
			case SHOES: return "Calzado";
		}
		// Easter egg (esto nunca se va a devolver)
		return "El veloz murciélago hindú comía feliz cardillo y kiwi. La cigüeña tocaba el saxofón detrás del palenque de paja. 1234567890";
	}
}
