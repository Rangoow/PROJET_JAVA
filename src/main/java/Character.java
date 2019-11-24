/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Mother Class that permit to create a Character which after can be Player or an enemy
 * @author ESPARSA NOE & DUBOIS THOMAS
 */
public abstract class Character {
    //Attributes
    private int maxHP;
    private int HP;
    private int xp;
    private String name;
    
    /**
     * Character specific constructor
     * @param name
     * @param maxHP
     * @param xp
     */
    public Character(String name, int maxHP, int xp){
        this.name = name;
        this.maxHP = maxHP;
        this.xp = xp;
        this.HP = maxHP;   
    }

    /**
     *Return character's maximum health
     * @return
     */
    public int getMaxHP() {
        return maxHP;
    }

    /**
     *Return character's health
     * @return
     */
    public int getHP() {
        return HP;
    }

    /**
     *Return character's experience
     * @return
     */
    public int getXp() {
        return xp;
    }

    /**
     *Return character's name
     * @return
     */
    public String getName() {
        return name;
    }
    
    
    /**
     *Permit to set the maximum health of the character
     * @param maxHP
     */
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    /**
     *Permit to set the health of the character
     * @param HP
     */
    public void setHP(int HP) {
        this.HP = HP;
    }

    /**
     *Permit to set the experience of the character
     * @param xp
     */
    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     *Permit to set the name of the character
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }  
}
