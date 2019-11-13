/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noees
 */

import java.util.Scanner;

public class GameLogic {
    
    static Scanner scanner = new Scanner(System.in);
    static Player player;
    public static boolean isRunning;
    
    //Story elements
    public static int place = 0, act;
    public static String[] places = {"Everlasting Mountains", "Haunted Landlines", "Castle of the Evil Emperor", "Throne Room"};

    //random encounters
    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};
	
    //enemy names
    public static String[] enemies = {"Ogre", "Ogre", "Goblin", "Goblin", "Stone Elemental"};
    
    //Get user input
    public static int getUserInput(String choiceString, int choicesNumber){
        int input;
        do{
            System.out.print(choiceString);
            try{
                input = Integer.parseInt(scanner.next());
            } 
            catch (NumberFormatException e){
                input = - 1;
                System.out.println("Please enter a correct value");
            }
        }
        while (input < 1 || input > choicesNumber);
        return input;
    }
    
    //Clear console log
    /*
    public static void consoleClear(){
        for(int i = 0; i <10; i++){
            System.out.println();
        }
    }
    */
    
    //Print specific separator number
    public static void separatorPrint(char separator, int n){
        for(int i=0; i<n; i++){
            System.out.print(separator);
        }
        System.out.println();
    }
    
    //Print head of the game
    public static void headPrint(String headTitle, char separator){
        separatorPrint(separator,136);
        System.out.print(separator + "------------------------------------------------------------  ");
        System.out.print(headTitle);
        System.out.println("  ------------------------------------------------------------" + separator);
        separatorPrint(separator,136);
        
    }
    
    //Print title during the game
    public static void titlePrint(String title,char separator){
        separatorPrint(separator,title.length());
        System.out.println(title);
        separatorPrint(separator,title.length());
    }
    
    
    //Wait user input
    public static void continueCommand(){
        System.out.println("\nPress a enter to continue...");
        scanner.nextLine();
    }
    
    //method to start the game
    public static void startGame(){
        boolean nameSet= false;
        String name;
        
        //Print title screen
        //consoleClear();
        headPrint("YNCREA RPG",'#');
        continueCommand();
        
        //getting the player name
        do{
            //consoleClear();
            titlePrint("What's your name?",'#');
            name = scanner.next();
            //asking the player if he wants to correct his choice
            //consoleClear();
            titlePrint("Your name is " + name + ". Is that correct?",'#');
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change my name.");
            int input = getUserInput(">> " , 2);
            if(input == 1)
                    nameSet = true;
        }while(!nameSet);
        
        //create new player object with the name
        player = new Player(name);

        //start main game loop (next part)
        // gameLoop();
    }

    //The main game loop
    public static void gameLoop(){
	while(isRunning){
            	printMenu();
		int input = getUserInput("-> ", 3);
		if(input == 1)
			continueJourney();
		else if(input == 2)
			characterInfo();
		else
			isRunning = false;
	}
        
    }
    
    //method to continue the journey (more next part)
    public static void continueJourney(){
        //check if act must be increased
	checkAct();
	//check if game isn't in last act
	if(act != 4)
            randomEncounter();
    }
    
    
    
    //printing the main menu
    public static void printMenu(){
	titlePrint(places[place],'#');
	System.out.println("Choose an action:");
	separatorPrint('#',20);
	System.out.println("(1) Continue on your journey");
	System.out.println("(2) Character Info");
	System.out.println("(3) Exit Game");
    }
    
    
    //printing out the most important information about the player character
    public static void characterInfo(){
	titlePrint("CHARACTER INFO",'#');
	System.out.println(player.getName() + "\tHP: " + player.getHP() + "/" + player.getMaxHP());
	separatorPrint('#',20);
	System.out.println("XP: " + player.getXp());
	separatorPrint('#',20);
		
	//printing the chosen traits
	if(player.numAtkUpgrades > 0){
		System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
		separatorPrint('#',20);
	}
	if(player.numDefUpgrades > 0){
		System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
	}
		
	continueCommand();
}

    //method that changes the game's values based on player xp
    public static void checkAct(){
            //change acts based on xp
		if(player.getXp() >= 10 && act == 1){
			//increment act and place
			act = 2;
			place = 1;
			//story
			Story.printFirstActOutro();
			//let the player "level up"
			player.chooseTrait();
			//story
			Story.printSecondActIntro();
			//assign new values to enemies
			enemies[0] = "Evil Mercenary";
			enemies[1] = "Goblin";
			enemies[2] = "Wolve Pack";
			enemies[3] = "Henchman of the Evil Emperor";
			enemies[4] = "Scary Stranger";
			//assign new values to encounters
			encounters[0] = "Battle";
			encounters[1] = "Battle";
			encounters[2] = "Battle";
			encounters[3] = "Rest";
			encounters[4] = "Shop";
		}else if(player.xp >= 50 && act == 2){
			//increment act and place
			act = 3;
			place = 2;
			//story
			Story.printSecondActOutro();
			//lvl up
			player.chooseTrait();
			//Story
			Story.printThirdActIntro();
			//assign new values to enemies
			enemies[0] = "Evil Mercenary";
			enemies[1] = "Evil Mercenary";
			enemies[2] = "Henchman of the Evil Emperor";
			enemies[3] = "Henchman of the Evil Emperor";
			enemies[4] = "Henchman of the Evil Emperor";
			//assign new values to encounters
			encounters[0] = "Battle";
			encounters[1] = "Battle";
			encounters[2] = "Battle";
			encounters[3] = "Battle";
			encounters[4] = "Shop";
			//fully heal the player
			player.getHP() = player.getMaxHP();
		}else if(player.getXp() >= 100 && act == 3){
			//increment act and place
			act = 4;
			place = 3;
			//story
			Story.printThirdActOutro();
			//lvl up
			player.chooseTrait();
			//story
			Story.printFourthActIntro();
			//fully heal the player
			player.hp = player.maxHp;
			//calling the final battle
			//finalBattle();
            }
    }



        
}


