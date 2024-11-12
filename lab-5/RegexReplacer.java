public class RegexReplacer{
    public static final String regex = "([a-z])([A-Z])";
    public static void main(String[] args){
        for (String s: args){
            System.out.println(s.replaceAll(regex, "!$1$2!"));
        }
    }
}