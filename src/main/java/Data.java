/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.FileWriter;
/**
 *
 * @author noees
 */
public class Data {
     
    public static void saveData(String name, int XP,boolean completed) throws IOException{
        String content = "Name : " + name + "       " + "XP : " + XP + "       " + "Game completed : " + completed + '\n';
        FileWriter writer = new FileWriter("data.txt",true);
        try{
            writer.write(content);
            writer.close();
        }
        catch (IOException e){
            System.err.println("Error: " + e.getMessage());
        }
        writer.close();
    }
    
    
    
}
