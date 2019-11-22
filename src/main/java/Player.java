/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noees
 */

public final class Player extends Character implements Action{
    
        //Integers to sroe number of upgraades/skills in each path
        public int nbrAtkAbility, nbrDefAbility;
        int gold, restsLeft, beers;
        
        //Array to store skill names
        public String[] atkAbility = {"FIRST CERTIFICATE","PR VALIDATED","ASN MASTER","3rd PURMIX"};
        public String[] defAbility = {"VOLTAIRE CERTIFICATE","INTERNATIONAL BREAK VALIDATED","CONTRAT PRO","STRONG LIVER"};
        
        //Player specific constructor
        public Player(String name){
            //calling super class constructor
            super(name,10,1);
            //Setting upgrade number to 0
            this.nbrAtkAbility = 0;
            this.nbrDefAbility = 0;
            //let player choose a trait when creating
            chooseTrait();
            
            this.gold = 5;
            this.restsLeft = 1;
            this.beers = 0;
        }
        
    	//Player specific methods (more in the next part)
	@Override
	public int attack() {
            // TODO Auto-generated method stub
            return (int) (Math.random()*(getXp()/4 + nbrAtkAbility*3 + 3) + getXp()/10 + nbrAtkAbility*2 + nbrDefAbility + 1);
	}

	@Override
	public int defend() {
            // TODO Auto-generated method stub
            return (int) (Math.random()*(getXp()/4 + nbrDefAbility*3 + 3) + getXp()/10 + nbrDefAbility*2 + nbrAtkAbility + 1);
	}
        
        //let the player choose a trait of either skill path
        public void chooseTrait(){
            GameDisplay.titlePrint("Choose a trait : ",'#');
            System.out.println("(1)" + atkAbility[nbrAtkAbility]);
            System.out.println("(2)" + defAbility[nbrDefAbility]);
            //get the players choice:
            int input = GameDisplay.getUserInput(">> ",2);
            //deal with both cases
            if (input == 1 ){
                GameDisplay.titlePrint("You chose " + atkAbility[nbrAtkAbility] +"! ",'-');
                nbrAtkAbility++;
            }
            else{
                GameDisplay.titlePrint("You chose " + defAbility[nbrDefAbility] +"! ",'-');
                nbrDefAbility++;                
            }
            GameDisplay.continueCommand();
        }
        
        
        
        
        
        
}           
