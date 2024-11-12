import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpChecker{
    public static final String regex = "((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])";

    public static void main(String[] args){
        for (String s: args){
            if (ipMatches(s)){
                System.out.printf("ip %s is valid\n", s);
            } else {
                System.out.printf("ip %s is invalid\n", s);
            }
        }
    }

    public static boolean ipMatches(String s){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}