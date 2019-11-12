/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noees
 */
public abstract class Character {
    //Attributes
    
    private int maxHP;
    private int HP;
    private int xp;
    private String name;
    
    
    //Methods
    
    public abstract int attack();
    public abstract int defend();
    
    //Constructor
    
    public Character(String name, int maxHP){
        this.name = name;
        this.maxHP = maxHP;
        this.xp = 0;
        this.HP = maxHP;   
    }

    
    //getters
    public int getMaxHP() {
        return maxHP;
    }

    public int getHP() {
        return HP;
    }

    public int getXp() {
        return xp;
    }

    public String getName() {
        return name;
    }
    
    
    
}
