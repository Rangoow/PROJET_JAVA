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
        System.out.println("You just woke up, it is 12:30, normal day. You go on your mailbox and ....");
        System.out.println("YOU ARE ADMITTED TO ISEN LILLE!");
        System.out.println();
        System.out.println("Here you are on your way to Lille, alone, without friends, with only one idea in mind, the ISEN graduate.");
    }
	
    /**
     *Display the 1st act Intro 
     */
    public static void displayFirstActIntro(){
        GameDisplay.headPrint("ACT I - INTRO ",'#');
        System.out.println();
        System.out.println("After all kinds of goodbyes, you drive towards Lille, leaving the sun behind you.");
        System.out.println("After a long journey, and the laying of rain tires, here you are, arrived at LILLE!");
        System.out.println("Despite all the rumors about the North, you decide not to take them into account and prepare you for the class");
        System.out.println();
        GameDisplay.waitCommand();
    }
	
    /**
     *Display the 1st act Outro
     */
    public static void displayFirstActOutro(){
        GameDisplay.headPrint("ACT I - OUTRO ",'#');
        System.out.println();
        System.out.println("This is the big day has arrived! You're all beautiful, your bag is ready!");
        System.out.println("You meet your friends and feel a little less alone ..");
        System.out.println("However all is not yet won, bad guys hang in the parrages ....");
        System.out.println();
        GameDisplay.waitCommand();
    }
	
    /**
     *Display the 2nd act Intro
     */
    public static void displaySecondActIntro(){
        GameDisplay.headPrint("ACT II- INTRO",'#');
        System.out.println();
        System.out.println("Monday morning, 12:30 pm: BEEP BEEP BEEP");
        System.out.println("You have forgotten that the holidays are over, it starts badly ...");
        System.out.println("Give everything to catch up ...");
        System.out.println();
        GameDisplay.waitCommand();
    }
	
    /**
     *Display the 2nd act Outro
     */
    public static void displaySecondActOutro(){
        GameDisplay.headPrint("ACT II- OUTRO",'#');
        System.out.println();
        System.out.println("The year is over! You had the average to all your modules! ");
        System.out.println("CONGRATULATIONS !!");
        System.out.println("You choose your specialization and go to Ibaza for maybe the last time");
        System.out.println();
        GameDisplay.waitCommand();
    }
	
    /**
     *Display the 3rd act Intro
     */
    public static void displayThirdActIntro(){
        GameDisplay.headPrint("ACT III-INTRO",'#');
        System.out.println();
        System.out.println("You are now in the 4th year, you quickly realize the questionable choice of your different modules.");
        System.out.println("Will you survive to the Java class ? ");
        System.out.println();
        GameDisplay.waitCommand();
    }
	
    /**
     *Display the 3rd act Outro
     */
    public static void displayThirdActOutro(){
        GameDisplay.headPrint("ACTIII- OUTRO",'#');
        System.out.println();
        System.out.println("The year is over! You had the average to all your modules! ");
        System.out.println("CONGRATULATIONS !!");
        System.out.println("You make big kisses to your friends and go on an internship for 4 months");
        System.out.println();
        GameDisplay.waitCommand();
    }
	
    /**
     *Display the 4th act Intro
     */
    public static void displayFourthActIntro(){
        GameDisplay.headPrint("ACT IV- INTRO",'#');
        System.out.println();
        System.out.println("You are there, the fifth year opens its doors!");
        System.out.println("WARNING WARNING WARNING ");
        System.out.println("Your ISEN degree is threatened by YNCREA!");
        System.out.println("Defend yourself or become a HEI");
        System.out.println();
        GameDisplay.waitCommand();
    }
	
    /**
     *Display the 4th act Outro aka the end of the game, and congratulate the player
     * @param player
     */
    public static void displayEndOfTheGame(Player player){
        System.out.println("CONGRATULATIONS, " + player.getName() + "! You defeated YNCREA CAMPUS");
        System.out.println("Long live the ISEN diploma !!!");
        System.out.println();
        System.out.println("THE END !");
    }
}
