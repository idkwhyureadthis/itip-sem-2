import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class TaskFive {
    private static final Map<Integer, Integer>scores = new HashMap<>(){{
        put(3, 1);
        put(4,2);
        put(5,3);
        put(6,54);
    }};
    private static final Map<String, Integer> timeOffsets = new HashMap<>() {
        {
            put("Los Angeles", -8 * 60);
            put("New York", -5 * 60);
            put("Caracas", -4 * 60 - 30);
            put("Buenos Aires", -3 * 60);
            put("London", 0);
            put("Rome", 1 * 60);
            put("Moscow", 3 * 60);
            put("Tehran", 3 * 60 + 30);
            put("New Delhi", 5 * 60 + 30);
            put("Beijing", 8 * 60);
            put("Canberra", 10 * 60);
        }
    };
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
        System.out.println("3:");
        System.out.println(digitsCount(4666)); // ➞ 4
        System.out.println(digitsCount(544)); // ➞ 3
        System.out.println(digitsCount(121317)); // ➞ 6
        System.out.println(digitsCount(0)); // ➞ 1
        System.out.println(digitsCount(12345)); // ➞ 5
        System.out.println(digitsCount(1289396387328L)); // ➞ 13;
        System.out.println("4:");
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster")); // ➞ 2
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant")); // ➞ 108
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed")); // ➞ 13
        System.out.println("5:");
        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9})); // ➞ 5
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15})); // ➞ 3
        System.out.println(longestRun(new int[]{5, 4, 2, 1})); // ➞ 2
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15})); // ➞ 1
        System.out.println("6:");
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"})); // ➞ "54%"
        System.out.println(takeDownAverage(new String[]{"10%"})); // ➞ "0%"
        System.out.println(takeDownAverage(new String[]{"53%", "79%"})); // ➞ "51%"
        System.out.println("7:");
        System.out.println(canMove("Rook", "A8", "H8")); // ➞ true
        System.out.println(canMove("Bishop", "A7", "G1")); // ➞ true 
        System.out.println(canMove("Queen", "C4", "D6")); // ➞ false
        System.out.println("8:");
        System.out.println(maxPossible(9328, 456)); // ➞ 9658
        System.out.println(maxPossible(523, 76)); // ➞ 763
        System.out.println(maxPossible(9132, 5564)); // ➞ 9655
        System.out.println(maxPossible(8732, 91255)); // ➞ 9755
        System.out.println("9:");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println("10:");
        System.out.println(isNew(3));     // ➞ true
        System.out.println(isNew(30));    // ➞ true
        System.out.println(isNew(321));   // ➞ false
        System.out.println(isNew(123));   // ➞ true
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
        while (first != 0 && second != 0){
            int firstNum = first % 10;
            int secondNum = second % 10;
            int toAdd = firstNum + secondNum;
            answer = String.valueOf(toAdd) + answer;
            first /= 10;
            second /= 10;
        }
        if (first !=0 ){
            answer = String.valueOf(first) + answer;
        } else if (second != 0){
            answer = String.valueOf(second) + answer;
        }
        return Integer.parseInt(answer);
    }

    public static int digitsCount(long number){
        if (number < 10){
            return 1;
        }
        return 1 + digitsCount(number / 10);
    }


    public static int totalPoints(String[] words, String initial){
        int result = 0;
        for(String word: words){
            if (isSubword(word, initial)){
                result += scores.getOrDefault(word.length(), 0);
            }
        }
        return result;
    }
    

    public static boolean isSubword(String word, String initial){
        Map<Character, Integer> seen = new HashMap<>();
        for (char c: initial.toCharArray()){
            seen.put(c, seen.getOrDefault(c,0) + 1);
        }
        for (char c: word.toCharArray()){
            seen.put(c, seen.getOrDefault(c, 0) - 1);
        }
        return Collections.min(seen.values()) >= 0;
    }

    public static int longestRun(int[] nums){
        int mx = 0;
        int curr = 1;
        int diff = 0;
        for (int i = 1; i < nums.length; i++){
            mx = Math.max(curr, mx);
            if (Math.abs(nums[i] - nums[i-1]) != 1){
                curr = 1;
                diff = 0;
            } else if (curr == 1){
                curr++;
                diff = nums[i]-nums[i-1];
            } else if (diff != nums[i] - nums[i-1]){
                curr = 1;
                diff = 0;
            } else {
                curr++;
            }
        }
        mx = Math.max(curr, mx);
        return mx;
    }

    public static String takeDownAverage(String[] percentages){
        int sm = 0;
        for (String s: percentages){
            sm += Integer.parseInt(s.substring(0, s.length() - 1));
        }
        sm /= percentages.length;
        return String.valueOf(sm - 5 * (percentages.length + 1)) + "%";
    }

    public static boolean canMove(String type, String from, String to){
        int xdiff = Math.abs(from.charAt(0) - to.charAt(0));
        int ydiff = Math.abs(from.charAt(1) - to.charAt(1));
        switch (type){
            case "Bishop":
                return (xdiff == ydiff);
            case "Knight":
                return (xdiff == 2 && ydiff == 1) || (xdiff == 1 && ydiff == 2);
            case "Rook":
                return (xdiff == 0 || ydiff == 0);
            case "Queen":
                return (xdiff == ydiff) || (xdiff == 0 || ydiff == 0);
        
        }
        return false;
    }

    public static int maxPossible(int initial, int additional){
        String answer = "";
        char[] additionalArr = String.valueOf(additional).toCharArray();
        Arrays.sort(additionalArr);
        int currInd = additionalArr.length - 1;
        for (char c: String.valueOf(initial).toCharArray()){
            if (currInd >= 0 && c < additionalArr[currInd]){
                answer += additionalArr[currInd];
                currInd--;
            } else {
                answer += c;
            }
        }
        return Integer.parseInt(answer);
    }

    public static String timeDifference(String cityA, String timestamp, String cityB) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy HH:mm", Locale.US);
        try {
            Date date = sdf.parse(timestamp);
            int offsetA = timeOffsets.get(cityA);
            int offsetB = timeOffsets.get(cityB);
            int timeDifference = offsetB - offsetA;
            long newTimeInMillis = date.getTime() + timeDifference * 60 * 1000;
            Date newDate = new Date(newTimeInMillis);
            SimpleDateFormat resultFormat = new SimpleDateFormat("yyyy-M-d HH:mm");
            return resultFormat.format(newDate);
        } catch (ParseException e) {
            return null;
        }
    }


    public static boolean isNew(int num) {
        String strNum = Integer.toString(num);
        char[] digitsNum = strNum.toCharArray();
        for (int i = 1; i < num; i++) {
            String strI = Integer.toString(i);
            char[] digitsI = strI.toCharArray();
            Arrays.sort(digitsNum);
            Arrays.sort(digitsI);
            if (Arrays.equals(digitsNum, digitsI)) {
                return false;
            }
        }
        return true;
    }
}
