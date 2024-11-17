import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PasswordChecker {
    public static final String regex = "(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9]{8,16}";
    public static void main(String[] args){
        for (String s : args){
            if (validPass(s)){
                System.out.printf("password %s is valid\n", s);
            } else {
                System.out.printf("password %s is invalid\n", s);
            }
        }
    }

    public static boolean validPass(String s){
        try{
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        } catch(PatternSyntaxException e){
            System.out.println("error occured" + e.getDescription());
        }
        return false;
    }
}
