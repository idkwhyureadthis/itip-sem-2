public class Palindrome{
    public static void main(String[] args){
        for (int i = 0; i < args.length; i++){
            if (IsPalindrome(args[i])){
                System.out.printf("%s is a palindrome\n", args[i]);
            } else{
                System.out.printf("%s is not a palindrome\n", args[i]);
            }
        }
    }

    public static boolean IsPalindrome(String word){
        int oppositeIndex;
        for (int i = 0; i < word.length(); i++){
            oppositeIndex = word.length() - i - 1;
            if (word.charAt(oppositeIndex) != word.charAt(i)){
                return false;
            }
        }
        return true;
    }
}