package checker;

public class MailChecker{
    private static final String regex = "[A-Za-z0-9._]+@[a-z]+.[a-z]{2,3}";

    public static void verifyMail(String mail) throws CustomEmailFormatException{
        mail = mail.replaceAll(regex, "");
        if (mail.length() != 0){
            throw new CustomEmailFormatException("string is not a mail");
        }
    }
}