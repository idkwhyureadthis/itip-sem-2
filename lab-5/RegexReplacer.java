import java.util.regex.PatternSyntaxException;

public class RegexReplacer{
    public static final String regex = "([a-z])([A-Z])";
    public static void main(String[] args){
        for (String s: args){
            try{
            System.out.println(s.replaceAll(regex, "!$1$2!"));
            } catch(PatternSyntaxException e){
                System.out.println("error parsing regex occured" + e.getMessage());
            }
        }
    }
}