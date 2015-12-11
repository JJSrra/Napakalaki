/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
	private ArrayList<Cultist> unusedCultists;
	
	private CardDealer() {
		unusedTreasures = new ArrayList<>();
		unusedMonsters = new ArrayList<>();
		usedTreasures = new ArrayList<>();
		usedMonsters = new ArrayList<>();
		unusedCultists = new ArrayList<>();
	}

	public static CardDealer getInstance() {
		return instance;
	}
	
	private void initTreasureCardDeck(){
		// ¡Sí mi amo!
		unusedTreasures.add(new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET));
		
		// Botas de investigación
		unusedTreasures.add(new Treasure("Botas de investigación", 3, TreasureKind.SHOES));
		
		// Capucha de Cthulhu
		unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
		
		// A prueba de babas
		unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
		
		// Botas de lluvia ácida
		unusedTreasures.add(new Treasure("Botas de lluvia ácida", 1, TreasureKind.BOTHHANDS));
		
		// Casco minero
		unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
		
		// Ametralladora Thompson
		unusedTreasures.add(new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS));
		
		// Camiseta de la UGR
		unusedTreasures.add(new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR));
		
		// Clavo de raíl ferroviario
		unusedTreasures.add(new Treasure("Clavo de raíl ferroviario", 3, TreasureKind.ONEHAND));
		
		// Cuchillo de sushi arcano
		unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
		
		// Fez alópodo
		unusedTreasures.add(new Treasure("Fez alópodo", 3, TreasureKind.HELMET));
		
		// Hacha prehistórica
		unusedTreasures.add(new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND));
		
		// El aparato del Pr. Tesla
		unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
		
		// Gaita
		unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
		
		// Insecticida
		unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
		
		// Escopeta de 3 cañones
		unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
		
		// Garabato místico
		unusedTreasures.add(new Treasure("Garabato místico", 2, TreasureKind.ONEHAND));
		
		// La rebeca metálica
		unusedTreasures.add(new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR));
		
		// Lanzallamas
		unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
		
		// Necrocomicón
		unusedTreasures.add(new Treasure("Necrocomicón", 1, TreasureKind.ONEHAND));
		
		// Necronomicón
		unusedTreasures.add(new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS));
		
		// Linterna a 2 manos
		unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
		
		// Necrognomicón
		unusedTreasures.add(new Treasure("Necrognomicón", 2, TreasureKind.ONEHAND));
		
		// Necrotelecom
		unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
		
		// Mazo de los antiguos
		unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
		
		// Necroplayboycon
		unusedTreasures.add(new Treasure("Necroplayboycón", 3, TreasureKind.ONEHAND));
		
		// Porra preternatural
		unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
		
		// Shogulador
		unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
		
		// Varita de atizamiento
		unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
		
		// Tentáculo de pega
		unusedTreasures.add(new Treasure("Tentáculo de pega", 2, TreasureKind.HELMET));
		
		// Zapato deja-amigos
		unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES));
		
		shuffleTreasures();
	}
	
	private void initMonsterCardDeck(){
		// Bicéfalo
		BadReference bcBicefalo = new BadReference("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3,
				new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)),
				new ArrayList(Arrays.asList()));
		Prize pBicefalo = new Prize(1, 1);
		unusedMonsters.add(new Monster("Bicéfalo", 20, bcBicefalo, pBicefalo));

		// Los hondos
		BadReference bcHondos = new BadReference("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.", true);
		Prize pHondos = new Prize(2, 1);
		unusedMonsters.add(new Monster("Los hondos", 8, bcHondos, pHondos));

		// Semillas Cthulhu
		BadReference bcSemillas = new BadReference("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
		Prize pSemillas = new Prize(2, 1);
		unusedMonsters.add(new Monster("Semillas Cthulhu", 4, bcSemillas, pSemillas));

		// Dameargo
		BadReference bcDameargo = new BadReference("Te intentas escaquear. Pierdes una mano visible.", 0,
				new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
				new ArrayList(Arrays.asList()));
		Prize pDameargo = new Prize(2, 1);
		unusedMonsters.add(new Monster("Dameargo", 1, bcDameargo, pDameargo));

		// 3 Byakhees de Bonanza
		BadReference bcByakhees = new BadReference("Pierdes tu armadura visible y otra oculta.", 0,
				new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
				new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
		Prize pByakhees = new Prize(2, 1);
		unusedMonsters.add(new Monster("3 Byakhees de Bonanza", 8, bcByakhees, pByakhees));

		// Chibithulhu
		BadReference bcChibi = new BadReference("Embobados con el lindo primigenio te descartas de tu casco visible.", 0,
				new ArrayList(Arrays.asList(TreasureKind.HELMET)),
				new ArrayList(Arrays.asList()));
		Prize pChibi = new Prize(1, 1);
		unusedMonsters.add(new Monster("Chibithulhu", 2, bcChibi, pChibi));

		// El sopor de Dunwich
		BadReference bcDunwich = new BadReference("El primordial bostezo contagioso. Pierdes el calzado visible.", 0,
				new ArrayList(Arrays.asList(TreasureKind.SHOES)),
				new ArrayList(Arrays.asList()));
		Prize pDunwich = new Prize(1, 1);
		unusedMonsters.add(new Monster("El sopor de Dunwich", 2, bcDunwich, pDunwich));

		// Pollipólipo volante
		BadReference bcPolipo = new BadReference("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
		Prize pPolipo = new Prize(1, 1);
		unusedMonsters.add(new Monster("Pollipólipo volante", 3, bcPolipo, pPolipo));

		// Ángeles de la noche ibicenca
		BadReference bcIbicenca = new BadReference("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.", 0,
				new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
				new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
		Prize pIbicenca = new Prize(4, 1);
		unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, bcIbicenca, pIbicenca));

		// El gorrón en el umbral
		BadReference bcGorron = new BadReference("Pierdes todos tus tesoros visibles.", 0, BadReference.MAXTREASURES, 0);
		Prize pGorron = new Prize(3, 1);
		unusedMonsters.add(new Monster("El gorrón en el umbral", 10, bcGorron, pGorron));

		// H.P. Munchcraft
		BadReference bcMunchcraft = new BadReference("Pierdes la armadura visible.", 0,
				new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
				new ArrayList(Arrays.asList()));
		Prize pMunchcraft = new Prize(2, 1);
		unusedMonsters.add(new Monster("H.P. Munchcraft", 6, bcMunchcraft, pMunchcraft));

		// Bichgooth
		BadReference bcBichgooth = new BadReference("Sientes bichos bajo la ropa. Descarta la armadura visible.", 0,
				new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
				new ArrayList(Arrays.asList()));
		Prize pBichgooth = new Prize(1, 1);
		unusedMonsters.add(new Monster("Bichgooth", 2, bcBichgooth, pBichgooth));

		// El rey rosa
		NumericBadConsequence bcReyRosa = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
		Prize pReyRosa = new Prize(4, 2);
		unusedMonsters.add(new Monster("El rey de rosa", 13, bcReyRosa, pReyRosa));

		// La que redacta en las tinieblas
		NumericBadConsequence bcTinieblas = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0);
		Prize pTinieblas = new Prize(1, 1);
		unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, bcTinieblas, pTinieblas));

		// Yskhtihyssg-Goth
		DeathBadConsequence bcImpronunciable = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto.");
		Prize pImpronunciable = new Prize(3, 1);
		unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, bcImpronunciable, pImpronunciable));

		// Familia feliz
		DeathBadConsequence bcFamilia = new DeathBadConsequence("La familia te atrapa. Estás muerto.");
		Prize pFamilia = new Prize(4, 1);
		unusedMonsters.add(new Monster("Familia feliz", 1, bcFamilia, pFamilia));

		// Roboggoth
		SpecificBadConsequence bcRoboggoth = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro a 2 manos visible", 2,
				new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
				new ArrayList(Arrays.asList()));
		Prize pRoboggoth = new Prize(2, 1);
		unusedMonsters.add(new Monster("Roboggoth", 8, bcRoboggoth, pRoboggoth));

		// El espía
		SpecificBadConsequence bcEspia = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible", 0,
				new ArrayList(Arrays.asList(TreasureKind.HELMET)),
				new ArrayList(Arrays.asList()));
		Prize pEspia = new Prize(1, 1);
		unusedMonsters.add(new Monster("El espía", 5, bcEspia, pEspia));

		// El Lenguas
		NumericBadConsequence bcLenguas = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
		Prize pLenguas = new Prize(1, 1);
		unusedMonsters.add(new Monster("El Lenguas", 20, bcLenguas, pLenguas));
		
		// Indecible e impronunciable
		SpecificBadConsequence bcIndecible = new SpecificBadConsequence("Pierdes 1 mano visible.", 0,
				new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
				new ArrayList(Arrays.asList()));
		Prize pIndecible = new Prize(3, 1);
		unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, bcIndecible, pIndecible, -2));
		
		// Testigos oculares
		NumericBadConsequence bcOculares = new NumericBadConsequence("Pierdes todos tus tesoros visibles. Jajaja.", 0,
				BadReference.MAXTREASURES, 0);
		Prize pOculares = new Prize(2, 1);
		unusedMonsters.add(new Monster("Testigos Oculares", 6, bcOculares, pOculares, 2));
		
		// El gran cthulhu
		DeathBadConsequence bcGranCthulhu = new DeathBadConsequence("Hoy no es tu día de suerte. Mueres.");
		Prize pGranCthulhu = new Prize(2, 5);
		unusedMonsters.add(new Monster("El gran Cthulhu", 20, bcGranCthulhu, pGranCthulhu, 4));
		
		// Serpiente Político
		NumericBadConsequence bcPolitico = new NumericBadConsequence("Tu gobierno te recorta 2 niveles", 2, 0, 0);
		Prize pPolitico = new Prize(2, 1);
		unusedMonsters.add(new Monster("Serpiente Político", 8, bcPolitico, pPolitico, -2));
		
		// Felpuggoth
		SpecificBadConsequence bcFelpuggoth = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas", 0,
				new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)),
				new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS, TreasureKind.BOTHHANDS,
						TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.ONEHAND)));
		Prize pFelpuggoth = new Prize(1, 1);
		unusedMonsters.add(new Monster("Felpuggoth", 2, bcFelpuggoth, pFelpuggoth, 5));
		
		// Shoggoth
		NumericBadConsequence bcShoggoth = new NumericBadConsequence("Pierdes 2 niveles", 2, 0, 0);
		Prize pShoggoth = new Prize(4, 2);
		unusedMonsters.add(new Monster("Shoggoth", 16, bcShoggoth, pShoggoth, -4));
		
		// Lolitagooth
		NumericBadConsequence bcLolita = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0);
		Prize pLolita = new Prize(1, 1);
		unusedMonsters.add(new Monster("Lolitagooth", 2, bcLolita, pLolita, 3));
		
		shuffleMonsters();
	}
	
	private void initCultistCardDeck(){
		unusedCultists.add(new Cultist("Sectario", 1));
		unusedCultists.add(new Cultist("Sectario", 2));
		unusedCultists.add(new Cultist("Sectario", 1));
		unusedCultists.add(new Cultist("Sectario", 2));
		unusedCultists.add(new Cultist("Sectario", 1));
		unusedCultists.add(new Cultist("Sectario", 1));
		
		shuffleCultists();
	}
	
	private void shuffleTreasures(){
		Collections.shuffle(unusedTreasures);
	}
	
	private void shuffleMonsters(){
		Collections.shuffle(unusedMonsters);
	}
	
	private void shuffleCultists(){
		Collections.shuffle(unusedCultists);
	}
	
	public Treasure nextTreasure(){
		if (unusedTreasures.isEmpty()){
			unusedTreasures.addAll(usedTreasures);
			usedTreasures.clear();
			
			shuffleTreasures();
		}
		
		return unusedTreasures.remove(0);
	}
	
	public Monster nextMonster(){
		if (unusedMonsters.isEmpty()){
			unusedMonsters.addAll(usedMonsters);
			usedMonsters.clear();
			
			shuffleTreasures();
		}
		
		Monster siguiente = unusedMonsters.remove(0);
		usedMonsters.add(siguiente);
		
		return siguiente;
	}
	
	public Cultist nextCultist(){
		return unusedCultists.remove(0);
	}
	
	public void giveTreasureBack(Treasure t){
		usedTreasures.add(t);
	}
	
	public void giveMonsterBack(Monster m){
		usedMonsters.add(m);
	}
	
	public void initCards(){
		initTreasureCardDeck();
		initMonsterCardDeck();
		initCultistCardDeck();
	}
}