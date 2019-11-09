/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noees
 */

public class Hero extends Character{
    
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
        
        //Player specific constructor
	public Hero(String name) {
		//calling constructor of superclass
		super(name, 100);
	}
}
