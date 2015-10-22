/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author dianavi
 */
public class PruebaNapakalaki {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		ArrayList<Monster> monsters = new ArrayList();
		
		// Bicéfalo
		BadConsequence bcBicefalo = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3,
				new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS, TreasureKind.ONEHAND, TreasureKind.ONEHAND)),
				new ArrayList(Arrays.asList()));
		Prize pBicefalo = new Prize(1, 1);
		monsters.add(new Monster("Bicéfalo", 20, bcBicefalo, pBicefalo));
		
		// Los hondos
		BadConsequence bcHondos = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.", true);
		Prize pHondos = new Prize(2,1);
		monsters.add(new Monster("Los hondos", 8, bcHondos, pHondos));
		
		// Semillas Cthulhu
		BadConsequence bcSemillas = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
		Prize pSemillas = new Prize(2,1);
		monsters.add(new Monster("Semillas Cthulhu", 4, bcSemillas, pSemillas));
		
		// Dameargo
		BadConsequence bcDameargo = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0,
				new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
				new ArrayList(Arrays.asList()));
		Prize pDameargo = new Prize(2,1);
		monsters.add(new Monster("Dameargo", 1, bcDameargo, pDameargo));
		
		// 3 Byakhees de Bonanza
		BadConsequence bcByakhees = new BadConsequence("Pierdes tu armadura visible y otra oculta.", 0,
				new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
				new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
		Prize pByakhees = new Prize(2, 1);
		monsters.add(new Monster("3 Byakhees de Bonanza", 8, bcByakhees, pByakhees));
		
		// Chibithulhu
		BadConsequence bcChibi = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible.", 0,
				new ArrayList(Arrays.asList(TreasureKind.HELMET)),
				new ArrayList(Arrays.asList()));
		Prize pChibi = new Prize(1, 1);
		monsters.add(new Monster("Chibithulhu", 2, bcChibi, pChibi));
		
		// El sopor de Dunwich
		BadConsequence bcDunwich = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.", 0,
				new ArrayList(Arrays.asList(TreasureKind.SHOES)),
				new ArrayList(Arrays.asList()));
		Prize pDunwich = new Prize(1, 1);
		monsters.add(new Monster("El sopor de Dunwich", 2, bcDunwich, pDunwich));
		
		// Pollipólipo volante
		BadConsequence bcPolipo = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
		Prize pPolipo = new Prize(1,1);
		monsters.add(new Monster("Pollipólipo volante", 3, bcPolipo, pPolipo));
		
		// Ángeles de la noche ibicenca
		BadConsequence bcIbicenca = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.", 0,
				new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
				new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
		Prize pIbicenca = new Prize(4, 1);
		monsters.add(new Monster("Ángeles de la noche ibicenca", 14, bcIbicenca, pIbicenca));
		
		// El gorrón en el umbral
		BadConsequence bcGorron = new BadConsequence("Pierdes todos tus tesoros visibles.", 0, 6, 0);
		Prize pGorron = new Prize(3, 1);
		monsters.add(new Monster("El gorrón en el umbral", 10, bcGorron, pGorron));
		
		// H.P. Munchcraft
		BadConsequence bcMunchcraft = new BadConsequence("Pierdes la armadura visible.", 0,
				new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
				new ArrayList(Arrays.asList()));
		Prize pMunchcraft = new Prize(2, 1);
		monsters.add(new Monster("H.P. Munchcraft", 6, bcMunchcraft, pMunchcraft));
		
		// Bichgooth
		BadConsequence bcBichgooth = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.", 0,
				new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
				new ArrayList(Arrays.asList()));
		Prize pBichgooth = new Prize(1, 1);
		monsters.add(new Monster("Bichgooth", 2, bcBichgooth, pBichgooth));
		
		// El rey rosa
		BadConsequence bcReyRosa = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
		Prize pReyRosa = new Prize(4, 2);
		monsters.add(new Monster("El rey de rosa", 13, bcReyRosa, pReyRosa));
		
		// La que redacta en las tinieblas
		BadConsequence bcTinieblas = new BadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0);
		Prize pTinieblas = new Prize(1, 1);
		monsters.add(new Monster("La que redacta en las tinieblas", 2, bcTinieblas, pTinieblas));
	}

}
