/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Class that permit to create an Enemy
 * @author ESPARSA NOE
 */
public class Enemy extends Character implements Action {
    
    //variable to store the players current xp
    int playerXp;
	
    /**
     *Enemy constructor
     * @param name
     * @param playerXp
     */
    public Enemy(String name, int playerXp) {
        super(name, (int) (Math.random()*playerXp + playerXp/3 + 5), (int) (Math.random()*(playerXp/4 + 2) + 1));
        //assigning variable
        this.playerXp = playerXp;

    }        

    /**
     *method defining randomly the value of the attack
     * @return int
     */
    @Override
    public int attack() {
        return (int) (Math.random()*(playerXp/4 + 1) + getXp()/4 + 3);
    }

    /**
     *method defining randomly the value of the defense
     * @return int
     */
    @Override
    public int defend() {
        return (int) (Math.random()*(playerXp/4 + 1) + getXp()/4 + 3)+1;	
    } 
}
