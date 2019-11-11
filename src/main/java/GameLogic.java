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

    }
    
    
    
    //printing the main menu
    public static void printMenu(){
	printHeading(places[place]);
	System.out.println("Choose an action:");
	separatorPrint('#',20);
	System.out.println("(1) Continue on your journey");
	System.out.println("(2) Character Info");
	System.out.println("(3) Exit Game");
    }
    
    
    //printing out the most important information about the player character
public static void characterInfo(){
	titlePrint("CHARACTER INFO",'#');
	System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
	separatorPrint('#',20);
	System.out.println("XP: " + player.xp);
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

        
}


