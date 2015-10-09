/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author dianavi
 */
public class PruebaNapakalaki {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// Crear monstruo de prueba
		BadConsequence plugs = new BadConsequence("It plugs. You're dead", true);
		Prize hodgsonPrize = new Prize(1031, 10);
		Monster hodgson = new Monster("Mr. Hodgson's Hawk-Cuckoo", 18, plugs, hodgsonPrize);

		// Imprimir monstruo por pantalla
		System.out.println(hodgson);
	}

}
