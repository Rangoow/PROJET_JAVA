
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noees
 */
public class GameDisplay {
    
    static Scanner scanner = new Scanner(System.in);
    
    //Print specific separator number
    public static void separatorPrint(char separator, int n){
        for(int i=0; i<n; i++){
            System.out.print(separator);
        }
        System.out.println();
    }
    

    //Print head of the game
    public static void headPrint(String headTitle, char separator){
        separatorPrint(separator,136);
        System.out.print(separator + "----------------------------------------------------------  ");
        System.out.print(headTitle);
        System.out.println("  ----------------------------------------------------------" + separator);
        separatorPrint(separator,136);    
    }    


    //Print title during the game
    public static void titlePrint(String title,char separator){
        separatorPrint(separator,title.length());
        System.out.println(title);
        separatorPrint(separator,title.length());
    }

    
    //Get user input
    public static int getUserInput(String choiceString, int choicesNumber){
        int input;
        do{
            System.out.print(choiceString);
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
    
    //Wait user input
    public static void waitCommand(){
        System.out.println("\nPress a enter to continue...");
        scanner.nextLine();
    } 
    
}
