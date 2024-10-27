import checker.*;

public class Main {
    public static void main(String[] args){
        try{
            MailChecker.verifyMail(args[0]);
        } catch (CustomEmailFormatException e){
            System.out.println("provided string is not a mail");
            return;
        } catch (IndexOutOfBoundsException i) {
            System.out.println("no data provided");
            return;
        }
        System.out.printf("%s is a correct email address", args[0]);
    }
}
