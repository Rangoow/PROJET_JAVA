/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.FileWriter;
/**
 *Class that only permit to save data into text file
 * @author ESPARSA NOE
 */
public class Data {
     
    /**
     *Permit to save most important information of a game into a text file as we can see a kind of history
     * @param name
     * @param XP
     * @param completed
     * @throws IOException
     */
    public static void saveData(String name, int XP,boolean completed) throws IOException{
        String content = "Name : " + name + "       " + "XP : " + XP + "       " + "Game completed : " + completed + '\n';
        try(FileWriter writer = new FileWriter("data.txt",true)) {
            try{
                writer.write(content);
                writer.close();
            }
            catch (IOException e){
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
    
    
    
}
