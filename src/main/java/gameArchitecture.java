
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ISEN-LILLE M1 JAVA PROJECT 2019
 * @author NOE_ESPARSA 
 */


public class gameArchitecture {
    
    static Scanner scanner = new Scanner(System.in);
    
    //Each game have a player
    static Player player;
    
    //Boolean that control and define the state of the game
    public static boolean isRunning = true;
    public static boolean completed = false;
    
    //Int that control the place and the act of the game
    public static int place = 0, act=1;
    
    //String arrays that contain possible places, places action (Battle,rest,shop) and ennemies 
    public static String[] places = {"ATRYIUM", "AMPHI JND", "B805", "A918"};
    public static String[] placeAction = {"Battle", "Battle", "Battle", "Battle" ,"Battle"}; 
    public static String[] enemies = {"HEI STUDENT", "ICAM STUDENT", "HEI STUDENT", "ICAM STUDENT", "HEI STUDENT", "ISA STUDENT", "LA CATHO STUDENT" };


    /**
     * Start the game, ask for a player name and launch gameloop()
     */
    public static void startGame(){
        boolean nameSet= false;
        String name;
        
        //Print title screen
        GameDisplay.headPrint("  YNCREA RPG  ",'#');
        GameDisplay.waitCommand();
        
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
        }while(nameSet == false);
        
        //create new player object with the name
        player = new Player(name);

        //start main game loop (next part)
        gameLoop();
    }

        /**
     *Display the main menu link to the game loop to choose between : 
     *      continue the adventure
     *      get inforamtions about your character
     *      exit the game
     */
    public static void displayMenu(){
	GameDisplay.titlePrint(places[place],'#');
        System.out.println();
	System.out.println("Choose an action:");
	GameDisplay.separatorPrint('#',20);
	System.out.println("(1) Continue");
	System.out.println("(2) Character Info");
	System.out.println("(3) Exit Game");
        GameDisplay.separatorPrint('#',20);
    }
    
    /**
     *Main game loop that let player chose between :
     *      continuing adventure
     *      get info about your character 
     *      exit the game
     */
    public static void gameLoop(){
	while(isRunning){
            displayMenu();
            int input = GameDisplay.getUserInput(">> ", 3);
            switch (input) {
                case 1:
                    carryOn();
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
    

    /**
     *while act is different of 4 we make random room action such as
     *battle/rest/shop depending of the act that's is checked before
     */
    public static void carryOn(){
        //check if act must be increased
	checkAct();
	//check if game isn't in last act
	if(act != 4)
            randomRoomAction();
    }
   
    /**
     *Get all the character informations :
     * Name / HP / MaxHP
     * XP / Gold
     * number of beers
     */
    public static void characterInfo(){
	GameDisplay.titlePrint("CHARACTER INFO",'#');
        System.out.println();
        GameDisplay.separatorPrint('.',20);
        //player name, HP and max HP
	System.out.println(player.getName() + "\tHP: " + player.getHP() + "/" + player.getMaxHP());
	GameDisplay.separatorPrint('.',20);
	//player xp and gold
	System.out.println("XP: " + player.getXp() + "\tGold: " + player.gold);
	GameDisplay.separatorPrint('.',20);
	//number of beers
	System.out.println("number of beers: " + player.beers);
	GameDisplay.separatorPrint('.',20);
	
	//printing the chosen ability which can be offensive or defensive
	if(player.nbrAtkAbility > 0){
		System.out.println("Offensive ability: " + player.atkAbility[player.nbrAtkAbility - 1]);
		GameDisplay.separatorPrint('.',20);
	}
	if(player.nbrDefAbility > 0){
		System.out.println("Defensive ability: " + player.defAbility[player.nbrDefAbility - 1]);
                GameDisplay.separatorPrint('.',20);
	}
	GameDisplay.waitCommand();
    }

    
    /**
     *This method adapt the xp win by the player, 
     *change and display the story for the different acts depending on the player XP
     * it also adabt the roomAction List adding rest possibility from the act 2
     * and shop possibility from the act 3
     */
    public static void checkAct(){
            //change acts based on xp
                if (player.getXp() == 1){
                    Story.displayStoryIntro();
                    Story.displayFirstActIntro();
                }
                else if(player.getXp() >= 10 && act == 1){
			//increment act and place
			act = 2;
			place = 1;
                        placeAction[3]="Rest";
			//story
			Story.displayFirstActOutro();
			//let the player "level up"
			player.skillUpgrade();
			//story
			Story.displaySecondActIntro();
		}
                else if(player.getXp() >= 20 && act == 2){
			//increment act and place
			act = 3;
			place = 2;
                        placeAction[4]="Shop";
			//story
			Story.displaySecondActOutro();
			//lvl up
			player.skillUpgrade();
			//Story
			Story.displayThirdActIntro();
			//fully heal the player
			player.setHP(player.getMaxHP());
		}
                else if(player.getXp() >= 30 && act == 3){
			//increment act and place
			act = 4;
			place = 3;
			//story
			Story.displayThirdActOutro();
			//lvl up
			player.skillUpgrade();
			//story
			Story.displayFourthActIntro();
			//fully heal the player
			player.setHP(player.getMaxHP());
			//calling the final battle
			finalBattle();
            }
    }

    /**
     *This method pick randomly one item in the roomAction array, depending on
     * the result the appropriate metho is call
     * Battle : randomBattle()
     * Shop : Shop()
     * default : takeRest()
     */
    public static void randomRoomAction(){
        //calling the respective methods
        switch (placeAction[(int) (Math.random()* placeAction.length)]) {
            case "Battle":
                randomBattle();
                break;
            case "Shop":
                shop();
                break;
            default:
                takeRest();
                break;
        }
    }
        
    /**
     *This method permit the player to fight against a random ennemie whose
     * stats are generated based on the player stats with a bit of random
     * then we call the battle method in which the battle is start betwen player and enemy
     */
    public static void randomBattle(){
	GameDisplay.titlePrint("| You encountered an evil minded creature. You'll have to fight it! |",'=');
	GameDisplay.waitCommand();
	//creating new enemy with random name
        String enemy_name=enemies[(int)(Math.random()*enemies.length)];
        int enemy_maxHP = (int) (Math.random()*player.getMaxHP() + player.getMaxHP()/3 + 5);
        int enemy_XP = (int) (Math.random()*(player.getXp()/4 + 4) + 1);
        Enemy enemy = new Enemy(enemy_name, enemy_maxHP ,enemy_maxHP);
	battle(enemy);
    }
    
    /**
     *
     * @param enemy
     */
    public static void battle(Enemy enemy){
        OUTER:
        while (true) {
            GameDisplay.titlePrint(enemy.getName() + "\nHP: " + enemy.getHP() + "/" + enemy.getMaxHP(),'#');
            GameDisplay.titlePrint(player.getName() + "\nHP: " + player.getHP() + "/" + player.getMaxHP(),'#');
            System.out.println("Choose an action:");
            GameDisplay.separatorPrint('.',20);
            System.out.println("(1) Fight ");
            System.out.println("(2) Use Potion");
            System.out.println("(3) Run Away");
            int input = GameDisplay.getUserInput(">> ", 3);
            //react accordingly to player inpu
            int dmgTook;
            switch (input) {
                case 1:
                    //FIGHT
                    //calculate dmg and dmgTook (dmg enemy deals to player)
                    int dmg = player.attack() - enemy.defend();
                    dmgTook = enemy.attack() - player.defend();
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
                    GameDisplay.headPrint("    BATTLE    ",'#');
                    System.out.println("You dealt " + dmg + " damage to the " + enemy.getName() + ".");
                    GameDisplay.separatorPrint('#',15);
                    System.out.println("The " + enemy.getName() + " dealt " + dmgTook + " damage to you.");
                    GameDisplay.waitCommand();
                    //check if player is still alive or dead
                    if (player.getHP() <= 0) {
                        playerDied(); //method to end the game
                        break OUTER;
                    } else if (enemy.getHP() <= 0) {
                        //tell the player he won
                        GameDisplay.titlePrint("You defeated the " + enemy.getName() + "!",'#');
                        //increase player xp
                        player.setXp(player.getXp()+enemy.getXp());
                        player.setMaxHP(player.getMaxHP()+2);
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
                        GameDisplay.waitCommand();
                        break OUTER;
                    }
                    break;
                case 2:
                    //USE POTION (BEER)
                    if(player.beers > 0 && player.getHP() < player.getMaxHP()){
                        //player CAN take a potion
                        //make sure player wants to drink the potion
                        GameDisplay.headPrint("Do you want to drink a potion? (" + player.beers + " left).",'#');
                        System.out.println("(1) Yes");
                        System.out.println("(2) No, maybe later");
                        input = GameDisplay.getUserInput(">> ", 2);
                        if(input == 1){
                            //player actually took it
                            player.setHP(player.getMaxHP());
                            GameDisplay.headPrint("You drank a magic beer. It restored your health back to " + player.getMaxHP(),'#');
                            GameDisplay.waitCommand();
                        }
                    }
                    else{
                        //player CANNOT take a potion
                        GameDisplay.headPrint("You don't have any potions or you're at full health.",'#');
                        GameDisplay.waitCommand();
                    }
                    break;
                default:
                    //RUN AWAY
                    //check that player isn't in last act (final boss battle)
                    if (act != 4) {
                        //chance of 35% to escape
                        if (Math.random()*10 + 1 <= 3.5) {
                            GameDisplay.headPrint("You ran away from the " + enemy.getName() + "!",'#');
                            GameDisplay.waitCommand();
                            break OUTER;
                        } else {
                            GameDisplay.headPrint("You didn't manage to escape.",'#');
                            //calculate dmage the player takes
                            dmgTook = enemy.attack();
                            System.out.println("In your hurry you took " + dmgTook + " damage!");
                            GameDisplay.waitCommand();
                            //check if player's still alive
                            if(player.getHP() <= 0)
                                playerDied();
                        }
                    } else {
                        GameDisplay.headPrint("YOU CANNOT ESCAPE YNCREA CAMPUS !!!",'#');
                        GameDisplay.waitCommand();
                    }
                    break;
            }
        }
    }
        
    //method that gets called when the player is dead
    public static void playerDied(){
        GameDisplay.headPrint("You died...",'#');
        GameDisplay.headPrint("You earned " + player.getXp() + " XP on your journey. Try to earn more next time!",'#');
        try {
            Data.saveData(player.getName(), player.getXp(), completed);
        }
        catch (IOException ex){
            Logger.getLogger(gameArchitecture.class.getName()).log(Level.SEVERE, null, ex);
        }
        isRunning = false;
    }
    
    //shopping / encountering a travelling trader
    public static void shop(){
	GameDisplay.titlePrint("You meet a mysterious stranger at the ZYTHO.\nHe offers you something:",'#');
	int price = (int) (Math.random()* (10 + player.beers*3) + 10 + player.beers);
	System.out.println("- Magic beer: " + price + " gold.");
	GameDisplay.separatorPrint('#',20);
	//ask the player to buy one
	System.out.println("Do you want to buy one ?");
        System.out.println("(1) Yes!");
        System.out.println("(2) No thanks.");
	int input = GameDisplay.getUserInput(">> ", 2);
	//check if player wants to buy
	if(input == 1){
		//check if player has enough gold
		if(player.gold >= price){
			GameDisplay.headPrint("You bought a magical beer " + price + "gold.",'#');
			player.beers++;
			player.gold -= price;
		}
                else{
			GameDisplay.headPrint("You don't have enough gold to buy this...",'#');
		GameDisplay.waitCommand();
                }
	}
}
    
    //taking a rest
    public static void takeRest(){
        if(player.restsLeft >= 1){
		GameDisplay.headPrint("Do you want to take a rest? (" + player.restsLeft + " rest(s) left).",'#');
		System.out.println("(1) Yes !");
                System.out.println("(2) No, not now.");
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
			}
                        else{
                            System.out.println("You're at full health. You don't need to rest now!");
                        }
		}
		GameDisplay.waitCommand();
	}
    }
    
    //the final (last) battle of the entire game
    public static void finalBattle(){
	//creating the evil emperor and letting the player fight against him
	battle(new Enemy("CAMPUS YNCREA", 150,player.getXp()));
	//printing the proper ending
	Story.displayEndOfTheGame(player);
        completed = true;
        try {
            Data.saveData(player.getName(), player.getXp(), completed);
        }
        catch (IOException ex){
            Logger.getLogger(gameArchitecture.class.getName()).log(Level.SEVERE, null, ex);
        }
	isRunning = false;       
    }
 
    
    
}


