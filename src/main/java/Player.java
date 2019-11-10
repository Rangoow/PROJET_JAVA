/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noees
 */

public class Player extends Character{
    
        //Integers to sroe number of upgraades/skills in each path
        public int numAtkUpgrades, numDefUpgrades;
        
        //Array to store skill names
        public String[] atkUpgrades = {"Strength","Power","Might","Godlike Strength"};
        public String[] defUpgrades = {"Heavy Bones","Stoneskin","Scale Armor","Holy Aura"};
        
        //Player specific constructor
        public Player(String name){
            //calling super class constructor
            super(name,100);
            //Setting upgrade number to 0
            this.numAtkUpgrades = 0;
            this.numDefUpgrades = 0;
            //let player choose a trait when creating
            chooseTrait();
        }
        
    	//Player specific methods (more in the next part)
	@Override
	public int attack() {
            // TODO Auto-generated method stub
            return 0;
	}

	@Override
	public int defend() {
            // TODO Auto-generated method stub
            return 0;
	}
        
        //let the player choose a trait of either skill path
        public void chooseTrait(){
            //GameLogic.consoleClear();
            GameLogic.titlePrint("Choose a trait : ",'#');
            System.out.println("(1)" + atkUpgrades[numAtkUpgrades]);
            System.out.println("(2)" + defUpgrades[numDefUpgrades]);
            //get the players choice:
            //GameLogic.consoleClear();
            //get the player choice
            int input = GameLogic.getUserInput(">> ",2);
            //GameLogic.consoleClear();
            //deal with both cases
            if (input == 1 ){
                GameLogic.headPrint("You chose " + atkUpgrades[numAtkUpgrades] +"! ",'#');
                numAtkUpgrades++;
            }
            else{
                GameLogic.headPrint("You chose " + defUpgrades[numDefUpgrades] +"! ",'#');
                numDefUpgrades++;                
            }
            GameLogic.continueCommand();
        }
        
        
        
        
        
        
}           
