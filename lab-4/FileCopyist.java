import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileCopyist {
    public static void main(String[] args){
        String data = "";
        try{
            File f = new File("from.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()){
                data += s.nextLine() + "\n";
            }
            s.close();
            // s.nextLine();

            File t = new File("to.txt");
            if (t.createNewFile()){
                System.out.println("file successfully created");
            }
            FileWriter fw = new FileWriter(t);
            fw.write(data);
            fw.close();
             // s.nextLine();
            System.out.println("File succesfully copied");
        } catch (FileNotFoundException f){
            System.out.println("failed to find file with such name");
            f.printStackTrace();
            return;
        } catch (IllegalStateException i){
            System.out.println("file was closed, failed to get access");
            i.printStackTrace();
            return;
        } catch (IOException e) {
            System.out.println("An error ocurred.");
            e.printStackTrace();
            return;
        } 
    }
}
