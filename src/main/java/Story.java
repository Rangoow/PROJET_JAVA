/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Class that store all the different story part
 * @author ESPARSA NOE
 */

public class Story {
	
    /**
     *Display the Intro of the Story
     */
    public static void displayStoryIntro(){
        GameDisplay.headPrint("    STORY     ",'#');	
        System.out.println();
        System.out.println("Tu viens de te reveiller, il est 12h30, journée normale. Tu fonces sur ta boite mail et ....");
        System.out.println("TU ES ADMIS A ISEN LILLE !");
        System.out.println();
        System.out.println("Te voila en route direction Lille, seul, sans amis, avec une seule idée en tête, le diplome ISEN.");
    }
	
    /**
     *Display the 1st act Intro 
     */
    public static void displayFirstActIntro(){
        GameDisplay.headPrint("ACT I - INTRO ",'#');
        System.out.println();
        System.out.println("Après des au-revoirs en tout genre, tu roules direction Lille, laissant le  soleil derrière toi.");
        System.out.println("Après un long trajet, et la pose de pneus pluie, te voila arrivé à LILLE !");
        System.out.println("Malgrès toutes les rumeurs sur le Nord, tu décides de ne pas les prendre en compte et te prépare pour la rentrée");
        System.out.println();
        GameDisplay.waitCommand();
    }
	
    /**
     *Display the 1st act Outro
     */
    public static void displayFirstActOutro(){
        GameDisplay.headPrint("ACT I - OUTRO ",'#');
        System.out.println();
        System.out.println("Ca y est le grand jour est arrivé !  Tu t'es fait tout beau, ton sac est prêt !");
        System.out.println("Tu rencontres tes ami(e)s et te sent un peu moins seul..");
        System.out.println("Cependant tout n'est pas encore gagné, des méchants trainnent dans les parrages....");
        System.out.println();
        GameDisplay.waitCommand();
    }
	
    /**
     *Display the 2nd act Intro
     */
    public static void displaySecondActIntro(){
        GameDisplay.headPrint("ACT II- INTRO",'#');
        System.out.println();
        System.out.println("Lundi matin, 12h30 : BIP BIP BIP ");
        System.out.println("Tu as oublier que les vacances sont finis, ça commence mal...");
        System.out.println("Donne tout pour rattraper ce retard ...");
        System.out.println();
        GameDisplay.waitCommand();
    }
	
    /**
     *Display the 2nd act Outro
     */
    public static void displaySecondActOutro(){
        GameDisplay.headPrint("ACT II- OUTRO",'#');
        System.out.println();
        System.out.println("L'année est finis ! Tu as eu la moyenne à tout tes modules ! ");
        System.out.println("FELICITATION !!");
        System.out.println("Tu choisis tes spé et blablabla");
        System.out.println();
        GameDisplay.waitCommand();
    }
	
    /**
     *Display the 3rd act Intro
     */
    public static void displayThirdActIntro(){
        GameDisplay.headPrint("ACT III-INTRO",'#');
        System.out.println();
        System.out.println("Te voilà maintenant en 4eme année, tu te rends rapidement compte du choix douteux de tes différents modules..");
        System.out.println("BLABLABLA");
        System.out.println();
        GameDisplay.waitCommand();
    }
	
    /**
     *Display the 3rd act Outro
     */
    public static void displayThirdActOutro(){
        GameDisplay.headPrint("ACTIII- OUTRO",'#');
        System.out.println();
        System.out.println("L'année est finis ! Tu as eu la moyenne à tout tes modules ! ");
        System.out.println("FELICITATION !!");
        System.out.println("Tu choisis tes spé et blablabla");
        System.out.println();
        GameDisplay.waitCommand();
    }
	
    /**
     *Display the 4th act Intro
     */
    public static void displayFourthActIntro(){
        GameDisplay.headPrint("ACT IV- INTRO",'#');
        System.out.println();
        System.out.println("Tu y es, la cinquième année ouvre ses portes !");
        System.out.println("WARNING WARNING WARNING ");
        System.out.println("Ton diplome ISEN est menacé par YNCREA !");
        System.out.println("Défend toi ou devient un HEI");
        System.out.println();
        GameDisplay.waitCommand();
    }
	
    /**
     *Display the 4th act Outro aka the end of the game, and congratulate the player
     * @param player
     */
    public static void displayEndOfTheGame(Player player){
        System.out.println("Felicitation, " + player.getName() + "! Tu as vaincu YNCREA CAMPUS");
        System.out.println("Longue vie au diplôme ISEN !!!");
        System.out.println();
        System.out.println("THE END !");
    }
}
