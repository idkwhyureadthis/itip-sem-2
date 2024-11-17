import java.util.regex.*;


public class NumberFinder {
 public static void main(String[] args) {
    String text = "The price of the product is $19.99, you gave me 20 dollars";
    try{
        Pattern pattern = Pattern.compile("(\\d+)(\\.\\d+)?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    } catch (PatternSyntaxException e){
        System.out.println("regex error occured" + e.getDescription());
    } catch (IllegalStateException e){
        System.out.println("state error occured" + e.getMessage());
    }
 }
}