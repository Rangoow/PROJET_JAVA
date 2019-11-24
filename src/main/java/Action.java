/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Define the 2 main action use by both characters
 * @author ESPARSA NOE & DUBOIS THOMAS
 */
public interface Action {
    
    /**
     *declare the attack fonction which is common to Player and Enemy class
     * @return
     */
    public int attack();

    /**
     *declare the defend fonction which is common to Player and Enemy class
     * @return
     */
    public int defend();
    
}
