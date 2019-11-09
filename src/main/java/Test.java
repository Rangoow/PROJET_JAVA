/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noees
 */

public class Test {
    public static void main(String[] args){
        GameLogic.headPrint("YNCREA RPG");
        GameLogic.continueCommand();
        //GameLogic.consoleClear();
        int input = GameLogic.getUserInput("Please select 1, 2 or 3", 3);
        System.out.println("You chose number " + input);
        GameLogic.continueCommand();
    }
}
