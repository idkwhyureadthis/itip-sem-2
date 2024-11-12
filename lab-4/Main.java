import java.io.IOException;
public class Main {
   public static void main (String[] args) {
    try {            
        try {                
            throw new Exception("a");
            } 
        finally {                
            throw new IOException("b");
        }        
    } 
    catch (IOException ex) {
        System.out.println(ex.getMessage());
    } 
    catch (Exception ex) {
        System.out.println(ex.getMessage());
    }    
    }
}