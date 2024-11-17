import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class WordPrinter {
    public static void main(String[] args) {
        for (int i = 1; i < args.length; i++){
            if (startsWith(args[i], args[0])){
                System.out.println(args[i]);
            }
        }
    }
    public static boolean startsWith(String s, String firstLetter){
        try{
            String regex = "(?i)" + firstLetter + "[a-zA-Z]*";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        } catch(PatternSyntaxException e){
            System.out.println("error occured" + e.getDescription());
        }
        return false;
    }
}
