/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noees
 */

//class that does nothing but storing methods to print out every part of the story
public interface Story {
	
	public static void printIntro(){
		GameDisplay.headPrint("    STORY     ",'#');	
                System.out.println();
                System.out.println("Tu viens de te reveiller, il est 12h30, journée normale. Tu fonces sur ta boite mail et ....");
		System.out.println("TU ES ADMIS A ISEN LILLE !");
		System.out.println("Te voila en route direction Lille, seul, sans amis, avec une seule idée en tête, le diplome ISEN.");
	}
	
	public static void printFirstActIntro(){
		GameDisplay.headPrint("ACT I - INTRO ",'#');
                System.out.println();
		System.out.println("Après des au-revoirs en tout genre, tu roules direction Lille, laissant le  soleil derrière toi.");
		System.out.println("Après un long trajet, et la pose de pneus pluie, te voila arrivé à LILLE !");
		System.out.println("Malgrès toutes les rumeurs sur le Nord, tu décides de ne pas les prendre en compte et te prépare pour la rentrée");
		GameDisplay.continueCommand();
	}
	
	public static void printFirstActOutro(){
		GameDisplay.separatorPrint('#',30);
		System.out.println("ACT I - OUTRO");
		GameDisplay.separatorPrint('#',30);
		System.out.println("Ca y est le grand jour est arrivé !  Tu t'es fait tout beau, ton sac est prêt !");
		System.out.println("Tu rencontres tes ami(e)s et te sent un peu moins seul..");
		System.out.println("\nCependant tout n'est pas encore gagné, des méchants trainnent dans les parrages....");
		GameDisplay.continueCommand();
	}
	
	public static void printSecondActIntro(){
		GameDisplay.separatorPrint('#',30);
		System.out.println("ACT II - INTRO");
		GameDisplay.separatorPrint('#',30);
		System.out.println("Lundi matin, 12h30 : BIP BIP BIP ");
		System.out.println("Tu as oublier que les vacances sont finis, ça commence mal...");
		System.out.println("Donne tout pour rattraper ce retard ...");
		GameDisplay.continueCommand();
	}
	
	public static void printSecondActOutro(){
		GameDisplay.separatorPrint('#',30);
		System.out.println("ACT II - OUTRO");
		GameDisplay.separatorPrint('#',30);
		System.out.println("L'année est finis ! Tu as eu la moyenne à tout tes modules ! ");
		System.out.println("FELICITATION !!");
		System.out.println("Tu choisis tes spé et blablabla");
		GameDisplay.continueCommand();
	}
	
	public static void printThirdActIntro(){
		GameDisplay.separatorPrint('#',30);
		System.out.println("ACT III - INTRO");
		GameDisplay.separatorPrint('#',30);
		System.out.println("Te voilà maintenant en 4eme année, tu te rends rapidement compte du choix douteux de tes différents modules..");
		System.out.println("BLABLABLA");
		GameDisplay.continueCommand();
	}
	
	
	public static void printThirdActOutro(){
		GameDisplay.separatorPrint('#',30);
		System.out.println("ACT III - OUTRO");
		GameDisplay.separatorPrint('#',30);
		System.out.println("L'année est finis ! Tu as eu la moyenne à tout tes modules ! ");
		System.out.println("FELICITATION !!");
		System.out.println("Tu choisis tes spé et blablabla");
		GameDisplay.continueCommand();
	}
	
	public static void printFourthActIntro(){
		GameDisplay.separatorPrint('#',30);
		System.out.println("ACT IV - INTRO");
		GameDisplay.separatorPrint('#',30);
		System.out.println("Tu y es, la cinquième année ouvre ses portes !");
		System.out.println("WARNING WARNING WARNING ");
		System.out.println("Ton diplome ISEN est menacé par YNCREA !");
		System.out.println("Défend toi ou devient un HEI");
		GameDisplay.continueCommand();
	}
	
	public static void printEnd(Player player){
		GameDisplay.separatorPrint('#',30);
		System.out.println("Felicitation, " + player.getName() + "! Tu as vaincu YNCREA");
		GameDisplay.separatorPrint('#',30);
		System.out.println("THE END !");
	}
}
