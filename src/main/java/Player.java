/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Class that permit to create a Player
 * @author ESPARSA NOE
 */

public final class Player extends Character implements Action{
    
    //Integers to sroe number of upgraades/skills in each path
    public int nbrAtkAbility, nbrDefAbility;
    int gold, restsLeft, beers;

    //Array to store skill names
    public String[] atkAbility = {"FIRST CERTIFICATE","PR VALIDATED","ASN MASTER","3rd PURMIX"};
    public String[] defAbility = {"VOLTAIRE CERTIFICATE","INTERNATIONAL BREAK VALIDATED","CONTRAT PRO","STRONG LIVER"};

    /**
     * Player specific constructor
     * @param name
     */
    public Player(String name){
        //calling super class constructor
        super(name,10,0);
        //Setting upgrade number to 0
        this.nbrAtkAbility = 0;
        this.nbrDefAbility = 0;
        //let player choose a trait when creating
        skillUpgrade();  
        this.gold = 5;
        this.restsLeft = 1;
        this.beers = 0;
    }

    /**
     *method defining randomly the value of the attack
     * @return int
     */
    @Override
    public int attack() {
        // TODO Auto-generated method stub
        return (int) (Math.random()*(this.getXp()/4 + this.nbrAtkAbility*3 + 3) + this.getXp()/10 + this.nbrAtkAbility*2 + this.nbrDefAbility + 1);
    }


    /**
     *method defining randomly the value of the defense
     * @return int
     */        
    @Override
    public int defend() {
        // TODO Auto-generated method stub
        return (int) (Math.random()*(this.getXp()/4 + this.nbrDefAbility*3 + 3) + this.getXp()/10 + this.nbrDefAbility*2 + this.nbrAtkAbility + 1);
    }

    /**
     *Method that permit the player to choose a new skill defensive or offensive
     */
    public void skillUpgrade(){
        GameDisplay.titlePrint("Choose a skill : ",'#');
        System.out.println("(1)" + atkAbility[nbrAtkAbility]);
        System.out.println("(2)" + defAbility[nbrDefAbility]);
        //get the players choice:
        int input = GameDisplay.getUserInput(">> ",2);
        //deal with both cases
        if (input == 1 ){
            GameDisplay.titlePrint("You chose offensive skill :",'.');
            GameDisplay.titlePrint( atkAbility[nbrAtkAbility],'-');
            nbrAtkAbility++;
        }
        else{
            GameDisplay.titlePrint("You chose defensive skill :",'.');
            GameDisplay.titlePrint(defAbility[nbrDefAbility],'-');
            nbrDefAbility++;                
        }
        GameDisplay.waitCommand();
    }    
}           
