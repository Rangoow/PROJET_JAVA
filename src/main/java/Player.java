/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noees
 */

public final class Player extends Character{
    
        //Integers to sroe number of upgraades/skills in each path
        public int numAtkUpgrades, numDefUpgrades;
        int gold, restsLeft, pots;
        
        //Array to store skill names
        public String[] atkUpgrades = {"Strength","Power","Might","Godlike Strength"};
        public String[] defUpgrades = {"Heavy Bones","Stoneskin","Scale Armor","Holy Aura"};
        
        //Player specific constructor
        public Player(String name){
            //calling super class constructor
            super(name,10,1);
            //Setting upgrade number to 0
            this.numAtkUpgrades = 0;
            this.numDefUpgrades = 0;
            //let player choose a trait when creating
            chooseTrait();
            
            this.gold = 5;
            this.restsLeft = 1;
            this.pots = 0;
        }
        
    	//Player specific methods (more in the next part)
	@Override
	public int attack() {
            // TODO Auto-generated method stub
            return (int) (Math.random()*(getXp()/4 + numAtkUpgrades*3 + 3) + getXp()/10 + numAtkUpgrades*2 + numDefUpgrades + 1);
	}

	@Override
	public int defend() {
            // TODO Auto-generated method stub
            return (int) (Math.random()*(getXp()/4 + numDefUpgrades*3 + 3) + getXp()/10 + numDefUpgrades*2 + numAtkUpgrades + 1);
	}
        
        //let the player choose a trait of either skill path
        public void chooseTrait(){
            GameDisplay.titlePrint("Choose a trait : ",'#');
            System.out.println("(1)" + atkUpgrades[numAtkUpgrades]);
            System.out.println("(2)" + defUpgrades[numDefUpgrades]);
            //get the players choice:
            //get the player choice
            int input = GameDisplay.getUserInput(">> ",2);
            //deal with both cases
            if (input == 1 ){
                GameDisplay.headPrint("You chose " + atkUpgrades[numAtkUpgrades] +"! ",'#');
                numAtkUpgrades++;
            }
            else{
                GameDisplay.headPrint("You chose " + defUpgrades[numDefUpgrades] +"! ",'#');
                numDefUpgrades++;                
            }
            GameDisplay.continueCommand();
        }
        
        
        
        
        
        
}           
