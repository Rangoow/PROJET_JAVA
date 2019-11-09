/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noees
 */

import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    
    //Get user input
    public static int getUserInput(String choiceString, int choicesNumber){
        int input;
        do{
            System.out.println(choiceString);
            try{
                input = Integer.parseInt(scanner.next());
            } 
            catch (NumberFormatException e){
                input = - 1;
                System.out.println("Please enter a correct value");
            }
        }
        while (input < 1 || input > choicesNumber);
        return input;
    }
    
    /*Clear console log
    public static void consoleClear(){
        for(int i = 0; i <10; i++){
            System.out.println();
        }
    }*/
    
    //Print specific separator number
    public static void separatorPrint(char separator, int n){
        for(int i=0; i<n; i++){
            System.out.print(separator);
        }
        System.out.println();
    }
    
    //Print head of the game
    public static void headPrint(String Title){
        separatorPrint('#',136);
        System.out.print("#------------------------------------------------------------  ");
        System.out.print(Title);
        System.out.println("  ------------------------------------------------------------#");
        separatorPrint('#',136);
        
    }
    
    //Wait user input
    public static void continueCommand(){
        System.out.println("\nPress a enter to continue...");
        scanner.nextLine();
    }
}


