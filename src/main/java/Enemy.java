/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noees
 */
public class Enemy extends Character {
    
    //variable to store the players current xp
	int playerXp;
	
	//enemy specific constructor
	public Enemy(String name, int maxHp, int xp) {
		super(name, 100, xp);
                //assigning variable
		this.playerXp = playerXp;
	}

	//Enemy specific attack and defence calculations
	@Override
	public int attack() {
		return (int) (Math.random()*(playerXp/4 + 1) + getXp()/4 + 3);
	}

	@Override
	public int defend() {
            return (int) (Math.random()*(playerXp/4 + 1) + getXp()/4 + 3);	}

    
}
