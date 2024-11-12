import java.util.HashMap;
import java.util.HashSet;

public class TaskFive {
    public static void main(String[] args){
        System.out.println("1:");
        System.out.println(sameLetterPattern("ABAB", "CDCD")); //  ➞ true
        System.out.println(sameLetterPattern("ABCBA", "BCDCB")); //  ➞ true
        System.out.println(sameLetterPattern("FFGG", "CDCD")); // ➞ false
        System.out.println(sameLetterPattern("FFFF", "ABCD")); // ➞ false 
        System.out.println("2:");
        System.out.println(memeSum(26, 39)); //  ➞ 515
        System.out.println(memeSum(122, 81)); // ➞ 1103
        System.out.println(memeSum(1222, 30277)); // ➞ 31499
    }

    public static boolean sameLetterPattern(String first, String second){
        if (first.length() != second.length()) {return false;}
        HashMap<Character, Character> refs = new HashMap<>();
        for (int i = 0; i < first.length(); i++){
            if (refs.containsKey(first.charAt(i)) && refs.get(first.charAt(i)) != second.charAt(i)){
                return false;
            } else {
                refs.put(first.charAt(i), second.charAt(i));
            }
        }
        HashSet<Character> seen = new HashSet<>();
        for (char c: refs.values()){
            if (seen.contains(c)){
                return false;
            }
            seen.add(c);
        }
        return true;
    }

    public static int memeSum(int first, int second){
        String answer = "";


        return Integer.parseInt(answer);
    }
}
