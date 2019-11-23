
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Class that is used to implement all the methods needed for the game display
 * @author ESPARSA NOE
 */
public class GameDisplay {
    
    static Scanner scanner = new Scanner(System.in);
    
    /**
     * Print a certain value of a specific character
     * @param separator
     * @param n
     */
    public static void separatorPrint(char separator, int n){
        for(int i=0; i<n; i++){
            System.out.print(separator);
        }
        System.out.println();
    }
    
    /**
     *Print an head title with a special character as decoration
     * @param headTitle
     * @param separator
     */
    public static void headPrint(String headTitle, char separator){
        separatorPrint(separator,136);
        System.out.print(separator + "----------------------------------------------------------  ");
        System.out.print(headTitle);
        System.out.println("  ----------------------------------------------------------" + separator);
        separatorPrint(separator,136);    
    }    

    /**
     *Print a title with a special character as decoration
     * @param title
     * @param separator
     */
    public static void titlePrint(String title,char separator){
        separatorPrint(separator,title.length());
        System.out.println(title);
        separatorPrint(separator,title.length());
    }

    /**
     *Permit to get the user input between a specific number of choice
     * @param inputLine
     * @param choicesNumber
     * @return
     */
    public static int getUserInput(String inputLine, int choicesNumber){
        int input;
        do{
            System.out.print(inputLine);
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
    
    /**
     *Permit to make a pause during the game waiting the user tap on enter to proceed
     */
    public static void waitCommand(){
        System.out.println("\nPress a enter to continue...");
        scanner.nextLine();
    } 
    
}
