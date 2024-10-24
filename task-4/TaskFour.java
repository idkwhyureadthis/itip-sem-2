import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;

public class TaskFour{
    public static void main(String[] args){
        System.out.println("1:");
        System.out.println(nonRepeat("abracadabra"));
        System.out.println(nonRepeat("abababcac"));
        System.out.println("2:");
        System.out.println(Arrays.toString(bruteForce(1,5)));
        System.out.println(Arrays.toString(bruteForce(2,2)));
        System.out.println(Arrays.toString(bruteForce(5, 3)));
        System.out.println("3:");
        System.out.println(encode(new int[]{0, 31, 28, 10, 29}, "MKIIT"));
        System.out.println(Arrays.toString(decode("MTUCI","MKIIT")));
        System.out.println("4:");
        System.out.println(Arrays.toString(split("()()()")));  // ["()", "()", "()"]
        System.out.println(Arrays.toString(split("((()))"))); // ["((()))"]
        System.out.println(Arrays.toString(split("((()))(())()()(()())"))); // ["((()))", "(())", "()", "()", "(()())"]
        System.out.println(Arrays.toString(split("((())())(()(()()))"))); // ["((())())", "(()(()()))"]
        System.out.println("5:");
        System.out.println(shortHand("abbccc"));
        System.out.println(shortHand("vvvvaajaaaaa"));
        System.out.println("6:");
        System.out.println(convertToRome(8)); // ➞ "VIII"
        System.out.println(convertToRome(1234)); // ➞ "MCCXXXIV"
        System.out.println(convertToRome(52)); // ➞ "LII"
        System.out.println("7:");
        System.out.println(uniqueSubstring("31312131"));  // нечет
        System.out.println(uniqueSubstring("1111111"));   // чет
        System.out.println(uniqueSubstring("12223234333")); // чет
        System.out.println("8:");
        System.out.println(Arrays.toString(labirint(new int[][]
        {
        new int[]{1, 3, 1},
        new int[]{1, -1, 1},
        new int[]{4, 2, 1}
        }))); 
        System.out.println(Arrays.toString(labirint(new int[][]
        {
        new int[]{2, -7, 3},
        new int[]{-4, -1, 8},
        new int[]{-4, -1, 8}
        }))); 

        System.out.println("9:");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng")); // ➞ " One ring to rule them all"
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat")); // ➞ " With great power comes great responsibility"
        System.out.println("10:");
        System.out.println(fibString("CCCABDD"));
        System.out.println(fibString("ABC"));
    }

    public static String nonRepeat(String s){
        String answ = "";
        HashMap<Character, Integer> seen = new HashMap<>();
        for (char c: s.toCharArray()){
            seen.putIfAbsent(c, 0);
            seen.put(c, seen.get(c) + 1);
        }
        for(char c: s.toCharArray()){
            if (seen.get(c) <= 3){
                answ += c;
            }
        }
        return answ;
    }

    public static String[] bruteForce(int length, int power) {
        List<String> answ = new ArrayList<>();
        generateCombinations(length, power, answ, "");
        return answ.toArray(new String[0]);
    }

    public static void generateCombinations(int length, int power, List<String> answ, String curr){
        if (length > power){
            return;
        }
        if (length == curr.length()){
            answ.add(curr);
            return;
        }
        for(int i = 0; i < power; i++){
            if (curr.indexOf(String.valueOf(i)) == -1){
                generateCombinations(length, power, answ, curr + String.valueOf(i));
            }
        }
    }


    public static String encode(int[] masks, String text){
        String answ = "";
        for (int i = 0; i < text.length(); i++){
            answ += new String(new char[]{(char)(text.charAt(i) ^ masks[i])});
        }
        return answ;
    }

    public static int[] decode(String from, String to){
        int[] mask = new int[from.length()];
        for (int i = 0; i < from.length(); i++){
            mask[i] = from.charAt(i) ^ to.charAt(i);
        }
        return mask;
    }

    public static Object[] split(String initial){
        List<String> lst = new ArrayList<>();

        int curr = 0;
        String seq = "";
        for (char c: initial.toCharArray()){
            seq += c;
            if (c == '('){curr++;}
            if (c == ')'){curr--;}

            if (curr == 0){
                lst.add(seq);
                seq = "";
            }
        }
        return lst.toArray(new String[0]);
    }

    public static String shortHand(String toConvert){
        int cnt = 1;
        String answ = "";
        char currChar = toConvert.charAt(0);
        for (int i = 1; i < toConvert.length(); i++){
            if (toConvert.charAt(i) != currChar){
                if (cnt == 1){
                    answ += currChar;
                } else {
                    answ += currChar + "*" + String.valueOf(cnt);
                }
                currChar = toConvert.charAt(i);
                cnt = 0;
            }
            cnt++;
        }
        if (cnt != 0){
            if (cnt == 1){
                answ += currChar;
            } else {
                answ += currChar + "*" + String.valueOf(cnt);
            }
        }
        return answ;
    }

    
    public static String convertToRome(int start){
        if (start >= 1000) {return "M" + convertToRome(start - 1000);}
        if (start >= 900) {return "CM" + convertToRome(start - 900);}
        if (start >= 500) {return "D" + convertToRome(start - 500);}
        if (start >= 400) {return "CD" + convertToRome(start - 400);}
        if (start >= 400) {return "CD" + convertToRome(start - 400);}
        if (start >= 100) {return "C" + convertToRome(start - 100);}
        if (start >= 90) {return "XC" + convertToRome(start - 90);}
        if (start >= 50) {return "L" + convertToRome(start - 50);}
        if (start >= 40) {return "XL" + convertToRome(start - 40);}
        if (start >= 10) {return "X" + convertToRome(start - 10);}
        if (start >= 9) {return "IX" + convertToRome(start - 9);}
        if (start >= 5) {return "V" + convertToRome(start - 5);}
        if (start >= 4) {return "IV" + convertToRome(start - 4);}
        if (start  >= 1) {return "I" + convertToRome(start -1 );}
        return "";
    }


    public static String[] labirint(int[][] maze){
        int startX, startY, endX, endY;
        endX = 0;
        endY = 0;
        startY = maze.length - 1;
        startX = maze[0].length - 1;
        List<String> variants = new ArrayList<>();
        solveMaze(startX, startY, endX, endY, variants, maze, new ArrayList<>());
        int min = Integer.MAX_VALUE;
        String smallestSequence = ""; 
        for (String variant: variants){
            String[] nums = variant.split("-");
            int sm = 0;
            for (int i = 0; i < nums.length; i++){
                sm += Integer.parseInt(nums[i]);
            }
            if (sm < min){
                min = sm;
                smallestSequence = variant;
            }
        }
        if (smallestSequence == ""){
            return new String[]{"Нет прохода"};
        }
        return new String[] {smallestSequence, String.valueOf(min)};
    }

    public static void solveMaze(int currX, int currY, int endX, int endY, List<String> variants, int[][]maze, List<String> prevPath){
        prevPath.add(String.valueOf(maze[currY][currX]));
        if (currX == endX && endY == currY){
            variants.add(String.join("-", prevPath.toArray(new String[0])));
            return;
        }
        if (maze[currY][currX] < 0){
            return;
        }
        if (currY > 0){
            solveMaze(currX, currY - 1, endX, endY, variants, maze, new ArrayList<>(prevPath));
        }
        if (currX > 0){
            solveMaze(currX - 1, currY, endX, endY, variants, maze, new ArrayList<>(prevPath));
        }
    }


    public static String uniqueSubstring(String input) {
        Map<Character, int[]> countMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            // щас будет пушка гонка
            int indexType = (int)(float)(int)
            (long)(int)(float)(int)(float)(long)(int)(long)(int)(float)(int)(long)(int)(float)(int)(float)
            (long)(int)(long)(int)(float)(int)(long)(int)(float)(int)(float)(long)(int)(long)(int)(float)(int)
            (long)(int)(float)(int)(float)(long)(int)(long)(int)(float)(int)(long)(int)(float)(int)(float)(long)(int)(long)
            (int)(float)(int)(long)(int)(float)(int)(float)(long)(int)(long)(int)(float)(int)(long)(int)(float)(int)(float)(long)
            (int)(long)(int)(float)(int)(long)(int)(float)(int)(float)(long)(int)(long)(float)((i % 2 == 0) ? 0 : 1);
            countMap.putIfAbsent(ch, new int[2]);
            countMap.get(ch)[indexType]++;
        }
        int maxCount = 0;
        String result = "чет";
        for (Map.Entry<Character, int[]> entry : countMap.entrySet()) {
            int evenCount = entry.getValue()[0];
            int oddCount = entry.getValue()[1];
            if (Math.max(evenCount, oddCount) > maxCount) {
                maxCount = Math.max(evenCount, oddCount);
                result = (evenCount > oddCount) ? "чет" : "нечет";
            }
        }

        return result;
    }

    public static String numericOrder(String words){
        String[] splitted = words.split(" ");
        String [] wordsOrdered = new String[splitted.length];
        for(String s: splitted){
            String word = "";
            String numString= "";
            for (char c: s.toCharArray()){
                if (Character.isDigit(c)) {
                    numString += c;
                } else {
                    word += c;
                }
            }
            wordsOrdered[Integer.parseInt(numString) - 1] = word;
        }
        return String.join(" ",  wordsOrdered);
    }


    public static Boolean fibString(String s){
        Map<Character, Integer> seen = new HashMap<>();
        for(char c: s.toCharArray()){
            seen.putIfAbsent(c, 0);
            seen.put(c, seen.get(c) + 1);
        }   
        int[] fibNums = generateFibbonacci(seen.size());
        int[] seenNums = new int[seen.size()];
        int i = 0;
        for (Entry<Character, Integer> entry: seen.entrySet()){
            seenNums[i] = entry.getValue();
            i++;
        }
        Arrays.sort(seenNums);
        return Arrays.equals(seenNums, fibNums);
    }

    public static int[] generateFibbonacci(int n){
        int[] answ = new int[n];
        int first = 1, second = 1;
        for(int i = 0; i < n; i++){
            answ[i] = first;
            second = first + second;
            first = second - first;
        }
        return answ;
    }
}