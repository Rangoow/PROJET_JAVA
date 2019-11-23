
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
    public static String[] placeAction = {"Battle", "Battle", "Battle", "Battle" ,"Battle","Battle"}; 
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
     *This method create a battle between the player and an enemy,
     *there are 3 possibilitu for the player :
     *      Fight :
     *          each one (player and ennemy while attack and defend at the same time,
     *          then we calculate the damage took by each other
     *          the battle end when one die, if the player win he earns XP of the ennemies.
     *          You also have a chance to gain a rest at the end of a battle if you win.
     *          
     *      use a beer :
     *          Permit to restore some HP.
     * 
     *      run away :
     *          Permit tro try to escape from the battle, the player have 35% chance to succeed
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
            System.out.println("(2) Drink beer (to restore HP)");
            System.out.println("(3) Run Away");
            int input = GameDisplay.getUserInput(">> ", 3);
            //react accordingly to player inpu
            int dmgTook;
            switch (input) {
                case 1:
                    //FIGHT OPTION
                    //calculate dmg (dmg deals to enemy) and dmgTook (dmg enemy deals to player)
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
                    //deal damage to both entity
                    player.setHP(player.getHP()-dmgTook);
                    enemy.setHP(enemy.getHP()-dmg);
                    //display the result of this battle round (new HP of each part)
                    GameDisplay.headPrint("    BATTLE    ",'#');
                    System.out.println("You dealt " + dmg + " damage to the " + enemy.getName() + ".");
                    GameDisplay.separatorPrint('#',15);
                    System.out.println("The " + enemy.getName() + " dealt " + dmgTook + " damage to you.");
                    GameDisplay.waitCommand();
                    //check if player is still alive or dead
                    if (player.getHP() <= 0) {
                        playerDied(); //method to end the game
                        break OUTER; 
                    }
                    //check if enemy is dead,
                    else if (enemy.getHP() <= 0) {
                        //tell the player he won
                        GameDisplay.titlePrint("You defeated the " + enemy.getName() + "!",'#');
                        //increase player xp by collecting ennemy's XP and increase by 2 the player's HP
                        player.setXp(player.getXp()+enemy.getXp());
                        player.setMaxHP(player.getMaxHP()+2);
                        System.out.println("You earned "+ enemy.getXp() + " XP!");
                        //permit the player to randomly earned rest and Gold
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
                    //USE BEER OPTION
                    //Check if player have beers and he's not full health
                    if(player.beers > 0 && player.getHP() < player.getMaxHP()){
                        //make sure player wants to drink the potion
                        GameDisplay.headPrint("Do you want to drink a beer ? (" + player.beers + " left).",'#');
                        System.out.println("(1) Yes");
                        System.out.println("(2) No, maybe later");
                        input = GameDisplay.getUserInput(">> ", 2);
                        if(input == 1){
                            //player drink beer so his health is fully restored
                            player.setHP(player.getMaxHP());
                            GameDisplay.headPrint("You drank a magical beer. It restored your health back to " + player.getMaxHP(),'#');
                            GameDisplay.waitCommand();
                        }
                    }
                    else{
                        //player is not able to drink a beer
                        GameDisplay.headPrint("You don't have any potions or you're at full health.",'#');
                        GameDisplay.waitCommand();
                    }
                    break;
                default:
                    //RUN AWAY OPTION
                    //check that player isn't in last act because he can't escape the final boss
                    if (act != 4) {
                        //35% chance to escape the fight
                        if (Math.random()*10 + 1 <= 3.5) {
                            GameDisplay.headPrint("You ran away from the " + enemy.getName() + "!",'#');
                            GameDisplay.waitCommand();
                            break OUTER;
                        }
                        //if the player didn't succed in escaping, he took damage without defend and attacking back
                        else {
                            GameDisplay.headPrint("You didn't manage to escape.",'#');
                            //calculate dmage the player takes
                            dmgTook = enemy.attack();
                            System.out.println("In your hurry you took " + dmgTook + " damage!");
                            GameDisplay.waitCommand();
                            //check if player's still alive
                            if(player.getHP() <= 0)
                                playerDied();
                        }
                    }
                    //player can't escape final boss
                    else {
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
    
    /**
     *Pemrit the player to  buy stuff like beers to restore health or redbulls to earn xp
     */
    public static void shop(){
	GameDisplay.titlePrint("It's wednesday, you are at the ZYTHO.\nSomeone offers you something:",'#');
	int beerPrice = (int) (Math.random()* (10 + player.beers*3) + 10 + player.beers);
        int xpPrice = beerPrice/2;
        int xpBonus = 10;
	System.out.println("(1) Magic beer : " + beerPrice + " gold.");
        System.out.println("(2) Powerfull RedBull :" + xpPrice + " gold.");
        System.out.println("(3) No thanks !");
	GameDisplay.separatorPrint('#',20);
	//ask the player to buy one
        System.out.println("Do you want to buy something ?");
	int input = GameDisplay.getUserInput(">> ", 2);
        switch (input){
            case 1:
                //check if player has enough gold
		if(player.gold >= beerPrice){
                    GameDisplay.headPrint("You bought a magical beer " + beerPrice + "gold.",'#');
                    player.beers++;
                    player.gold -= beerPrice;
		}
                //if not tell him               
                else{
                    GameDisplay.headPrint("You don't have enough gold to buy this...",'#');
                    GameDisplay.waitCommand();
                }
                break;
            case 2:
                //check if player has enough gold
		if(player.gold >= xpPrice){
                    GameDisplay.headPrint("You bought a powerfull Redbull " + xpPrice + "gold.",'#');
                    player.gold -= xpPrice;
                    player.setXp(player.getXp()+xpBonus);
		}
                //if not tell him
                else{
                    GameDisplay.headPrint("You don't have enough gold to buy this...",'#');
                    GameDisplay.waitCommand();
                }
                break;
            default:
                GameDisplay.waitCommand();
                break;          
        }
    }
    
    /**
     *Pemrit the player to take a at the MI and restore HP
     */
    public static void takeRest(){
        if(player.restsLeft >= 1){
		GameDisplay.headPrint("Do you want to take a rest at the MI? (" + player.restsLeft + " rest(s) left).",'#');
		System.out.println("(1) Yes, I'm tired !");
                System.out.println("(2) No, not now I'm still ready to figth.");
		int input = GameDisplay.getUserInput(">> ", 2);
		if(input == 1){
			//If player take a rest, restore randomly HP based on the player's xp
			if(player.getHP() < player.getMaxHP()){
                            int hpRestored = (int) (Math.random() * (player.getXp()/4 + 1) + 10);
                            player.setHP(player.getHP()+ hpRestored);
                            //case the Hp restored are superior to max HP, we just reset HP to full healt
                            if(player.getHP() > player.getMaxHP())
                                    player.setHP(player.getMaxHP());
                            System.out.println("You took a long afternoon rest at the MI and restored up to " + hpRestored + " health.");
                            System.out.println("You're now at " + player.getHP() + "/" + player.getMaxHP() + " health.");
                            player.restsLeft--;
			}
                        else{
                            System.out.println("You're at full health you should go fight. You don't need to rest now!");
                        }
		}
		GameDisplay.waitCommand();
	}
    }
    
    /**
     *This method permit the player to fight against a special enemy who is the final boss of the game
     * this one is not in the enemy array
     * The player can finish the game here.
     */
    public static void finalBattle(){
	//create the final boss entity and then start the battle against him, his stats are based on player's one
        Enemy finalBoss = new Enemy("CAMPUS YNCREA", player.getMaxHP()*3,player.getXp());
	battle(finalBoss);
        //display the end and certified the player finsih the game
        Story.displayEndOfTheGame(player);
        completed = true;
        //save data in txt file
        try {
            Data.saveData(player.getName(), player.getXp(), completed);
        }
        catch (IOException ex){
            Logger.getLogger(gameArchitecture.class.getName()).log(Level.SEVERE, null, ex);
        }
        //stop the main game loop
	isRunning = false;       
    }
 
    
    
}


