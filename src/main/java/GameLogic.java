
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noees
 */


public class GameLogic {
    
    static Scanner scanner = new Scanner(System.in);

    static Player player;
    public static boolean isRunning = true;
    public static boolean completed = false;
    
    //Story elements
    public static int place = 0, act=1;
    public static String[] places = {"ATRYIUM", "AMPHI JND", "B805", "A918"};

    //random encounters
    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};
    
    //enemy names
    public static String[] enemies = {"HEI STUDENT", "ICAM STUDENT", "HEI STUDENT", "ICAM STUDENT", "HEI STUDENT"};
    

    
    
    //method to start the game
    public static void startGame(){
        boolean nameSet= false;
        String name;
        
        //Print title screen
        GameDisplay.headPrint("YNCREA RPG",'#');
        GameDisplay.continueCommand();
        
        //getting the player name
        do{
            GameDisplay.titlePrint("What's your name?",'#');
            name = scanner.next();
            //asking the player if he wants to correct his choice
            GameDisplay.titlePrint("Your name is " + name + ". Is that correct?",'#');
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change my name ! ");
            int input = GameDisplay.getUserInput(">> " , 2);
            if(input == 1)
                    nameSet = true;
        }while(!nameSet);
        
        //create new player object with the name
        player = new Player(name);

        //start main game loop (next part)
        gameLoop();
    }

    //The main game loop
    public static void gameLoop(){
	while(isRunning){
            printMenu();
            int input = GameDisplay.getUserInput(">> ", 3);
            switch (input) {
                case 1:
                    continueJourney();
                    break;
                case 2:
                    characterInfo();
                    break;
                default:
                    isRunning = false;
                    break;
            }
	}
    }
    
    //method to continue the journey 
    public static void continueJourney(){
        //check if act must be increased
	checkAct();
	//check if game isn't in last act
	if(act != 4)
            randomEncounter();
    }
    
    //printing the main menu
    public static void printMenu(){
	GameDisplay.titlePrint(places[place],'#');
        System.out.println();
	System.out.println("Choose an action:");
	GameDisplay.separatorPrint('#',20);
	System.out.println("(1) Continue");
	System.out.println("(2) Character Info");
	System.out.println("(3) Exit Game");
        GameDisplay.separatorPrint('#',20);
    }
    
    //printing out the most important information about the player character
    public static void characterInfo(){
	GameDisplay.titlePrint("CHARACTER INFO",'#');
        System.out.println();
        GameDisplay.separatorPrint('.',20);
	System.out.println(player.getName() + "\tHP: " + player.getHP() + "/" + player.getMaxHP());
	GameDisplay.separatorPrint('.',20);
	//player xp and gold
	System.out.println("XP: " + player.getXp() + "\tGold: " + player.gold);
	GameDisplay.separatorPrint('.',20);
	//# of pots
	System.out.println("number of Potions: " + player.pots);
	GameDisplay.separatorPrint('.',20);
	
	//printing the chosen traits
	if(player.numAtkUpgrades > 0){
		System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
		GameDisplay.separatorPrint('.',20);
	}
	if(player.numDefUpgrades > 0){
		System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
                GameDisplay.separatorPrint('.',20);
	}
	
	GameDisplay.continueCommand();

    }

    //method that changes the game's values based on player xp
    public static void checkAct(){
            //change acts based on xp
                if (player.getXp() == 1){
                    Story.printIntro();
                    Story.printFirstActIntro();
                }
                else if(player.getXp() >= 10 && act == 1){
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
		}else if(player.getXp() >= 50 && act == 2){
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
			player.setHP(player.getMaxHP());
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
			player.setHP(player.getMaxHP());
			//calling the final battle
			finalBattle();
            }
    }

    //method to calculate a random encounter
    public static void randomEncounter(){
            //random number between 0 and the length of the encounters array
            int encounter = (int) (Math.random()* encounters.length);
            //calling the respective methods
            if(encounters[encounter].equals("Battle")){
                    randomBattle();
            }else if(encounters[encounter].equals("Rest")){
                    takeRest();
            }else{
                    shop();
            }
    }
        
    //creating a random battle
    public static void randomBattle(){
	GameDisplay.headPrint("You encountered an evil minded creature. You'll have to fight it!",'#');
	GameDisplay.continueCommand();
	//creating new enemy with random name
	battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], (int) (Math.random()*player.getMaxHP() + player.getMaxHP()/3 + 5),(int) (Math.random()*(player.getXp()/4 + 2) + 1)));
    }
    
    //the main BATTLE method    
    public static void battle(Enemy enemy){
            //main battle loop
            while(true){
                    GameDisplay.titlePrint(enemy.getName() + "\nHP: " + enemy.getHP() + "/" + enemy.getMaxHP(),'#');
                    GameDisplay.titlePrint(player.getName() + "\nHP: " + player.getHP() + "/" + player.getMaxHP(),'#');
                    System.out.println("Choose an action:");
                    GameDisplay.separatorPrint('#',20);
                    System.out.println("(1) Fight\n(2) Use Potion\n(3) Run Away");
                    int input = GameDisplay.getUserInput(">> ", 3);
                    //react accordingly to player input
                    if(input == 1){
                            //FIGHT
                            //calculate dmg and dmgTook (dmg enemy deals to player)
                            int dmg = player.attack() - enemy.defend();
                            int dmgTook = enemy.attack() - player.defend();
                            //check that dmg and dmgTook isn't negative
                            if(dmgTook < 0){
                                    //add some dmg if player defends very well
                                    dmg -= dmgTook/2;
                                    dmgTook = 0;
                            }
                            if(dmg < 0)
                                    dmg = 0;
                            //deal damge to both parties
                            player.setHP(player.getHP()-dmgTook);
                            enemy.setHP(enemy.getHP()-dmg);
                            //print the info of this battle round
                            GameDisplay.headPrint("BATTLE",'#');
                            System.out.println("You dealt " + dmg + " damage to the " + enemy.getName() + ".");
                            GameDisplay.separatorPrint('#',15);
                            System.out.println("The " + enemy.getName() + " dealt " + dmgTook + " damage to you.");
                            GameDisplay.continueCommand();
                            //check if player is still alive or dead
                            if(player.getHP() <= 0){
                                    playerDied(); //method to end the game
                                    break;
                            }else if(enemy.getHP() <= 0){
                                    //tell the player he won
                                    GameDisplay.headPrint("You defeated the " + enemy.getName() + "!",'#');
                                    //increase player xp
                                    player.setXp(player.getXp()+enemy.getXp());
                                    System.out.println("You earned "+ enemy.getXp() + " XP!");
                                    //random drops
                                    boolean addRest = (Math.random()*5 + 1 <= 2.25);
                                    int goldEarned = (int) (Math.random()*enemy.getXp());
                                    if(addRest){
                                        player.restsLeft++;
                                        System.out.println("You earned the chance to get an additional rest!");
                                    }
                                    if(goldEarned > 0){
                                        player.gold += goldEarned;
                                        System.out.println("You collect " + goldEarned + " gold from the " + enemy.getName() + "'s corpse!");
                                    }
                                    GameDisplay.continueCommand();
                                    break;
                            }
                    }else if(input == 2){
                        //USE POTION
                        if(player.pots > 0 && player.getHP() < player.getMaxHP()){
                                //player CAN take a potion
                                //make sure player wants to drink the potion
                                GameDisplay.headPrint("Do you want to drink a potion? (" + player.pots + " left).",'#');
                                System.out.println("(1) Yes\n(2) No, maybe later");
                                input = GameDisplay.getUserInput(">> ", 2);
                                if(input == 1){
                                        //player actually took it
                                        player.setHP(player.getMaxHP());
                                        GameDisplay.headPrint("You drank a magic potion. It restored your health back to " + player.getMaxHP(),'#');
                                        GameDisplay.continueCommand();
                                }
                        }
                        else{
                                //player CANNOT take a potion
                                GameDisplay.headPrint("You don't have any potions or you're at full health.",'#');
                                GameDisplay.continueCommand();
                        }

                    }else{
                            //RUN AWAY
                            //check that player isn't in last act (final boss battle)
                            if(act != 4){
                                    //chance of 35% to escape
                                    if(Math.random()*10 + 1 <= 3.5){
                                            GameDisplay.headPrint("You ran away from the " + enemy.getName() + "!",'#');
                                            GameDisplay.continueCommand();
                                            break;
                                    }else{
                                            GameDisplay.headPrint("You didn't manage to escape.",'#');
                                            //calculate dmage the player takes
                                            int dmgTook = enemy.attack();
                                            System.out.println("In your hurry you took " + dmgTook + " damage!");
                                            GameDisplay.continueCommand();
                                            //check if player's still alive
                                            if(player.getHP() <= 0)
                                                    playerDied();
                                    }
                            }else{
                                    GameDisplay.headPrint("YOU CANNOT ESCAPE THE EVIL EMPEROR!!!",'#');
                                    GameDisplay.continueCommand();
                            }

                    }
            }
    }
        
    //method that gets called when the player is dead
    public static void playerDied(){
        GameDisplay.headPrint("You died...",'#');
        GameDisplay.headPrint("You earned " + player.getXp() + " XP on your journey. Try to earn more next time!",'#');
        System.out.println("Thank you for playing my game. I hope you enjoyed it :)");
        try {
            Data.saveData(player.getName(), player.getXp(), completed);
        } catch (IOException ex) {
            Logger.getLogger(GameLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        isRunning = false;
    }
    
    //shopping / encountering a travelling trader
    public static void shop(){
	GameDisplay.headPrint("You meet a mysterious stranger.\nHe offers you something:",'#');
	int price = (int) (Math.random()* (10 + player.pots*3) + 10 + player.pots);
	System.out.println("- Magic Potion: " + price + " gold.");
	GameDisplay.separatorPrint('#',20);
	//ask the player to buy one
	System.out.println("Do you want to buy one?\n(1) Yes!\n(2) No thanks.");
	int input = GameDisplay.getUserInput(">> ", 2);
	//check if player wants to buy
	if(input == 1){
		//check if player has enough gold
		if(player.gold >= price){
			GameDisplay.headPrint("You bought a magical potion for " + price + "gold.",'#');
			player.pots++;
			player.gold -= price;
		}else
			GameDisplay.headPrint("You don't have enough gold to buy this...",'#');
		GameDisplay.continueCommand();
	}
}
    
    //taking a rest
    public static void takeRest(){
        if(player.restsLeft >= 1){
		GameDisplay.headPrint("Do you want to take a rest? (" + player.restsLeft + " rest(s) left).",'#');
		System.out.println("(1) Yes\n(2) No, not now.");
		int input = GameDisplay.getUserInput(">> ", 2);
		if(input == 1){
			//player actually takes rest
			if(player.getHP() < player.getMaxHP()){
				int hpRestored = (int) (Math.random() * (player.getXp()/4 + 1) + 10);
				player.setHP(player.getHP()+ hpRestored);
				if(player.getHP() > player.getMaxHP())
					player.setHP(player.getMaxHP());
				System.out.println("You took a rest and restored up to " + hpRestored + " health.");
				System.out.println("You're now at " + player.getHP() + "/" + player.getMaxHP() + " health.");
				player.restsLeft--;
			}else
				System.out.println("You're at full health. You don't need to rest now!");
		}
		GameDisplay.continueCommand();
	}
    }
    
    //the final (last) battle of the entire game
    public static void finalBattle(){
	//creating the evil emperor and letting the player fight against him
	battle(new Enemy("THE EVIL EMPEROR", 300,player.getXp()));
	//printing the proper ending
	Story.printEnd(player);
        completed = true;
        try {
            Data.saveData(player.getName(), player.getXp(), completed);
        } catch (IOException ex) {
            Logger.getLogger(GameLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
	isRunning = false;
        
}
    
    
    
    
}


