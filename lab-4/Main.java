import checker.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args){
        try{
            MailChecker.verifyMail(args[0]);
        } catch (CustomEmailFormatException e){
            System.out.println("provided string is not a mail");
            logError(e);
            return;
        } catch (IndexOutOfBoundsException i) {
            System.out.println("no data provided");
            logError(i);
            return;
        }
        System.out.printf("%s is a correct email address", args[0]);
    }

    public static void logError(Exception e){
        try  {
        File f = new File("log.txt");
        FileWriter fw = new FileWriter(f, true);
        fw.write(String.format("%s: an error occured: %s\n", ZonedDateTime.now().toString(), e.getMessage()));
        fw.close();
        } catch (IOException i){
            System.out.println("failed to log data");
        }
    }
}
