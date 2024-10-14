import java.util.Arrays;
import java.util.HashSet;

public class TaskThree {
    public static void main(String[] args){
        System.out.println("1:");
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));
        System.out.println("2:");
        Object[][] answer = sale(new Object[][]{
            new Object[]{"Laptop", 124200},
            new Object[]{"Phone", 51450},
            new Object[]{"Headphones", 13800},
            }, 25);
        for (Object[] elem: answer){
            System.out.println(Arrays.toString(elem));
        }
        System.out.println("3:");
        System.out.println(sucsessShoot(0, 0, 5, 2, 2));
        System.out.println(sucsessShoot(-2, -3, 4, 5, -6));
        System.out.println("4:");
        System.out.println(parityAnalysis(243));
        System.out.println(parityAnalysis(12));
        System.out.println(parityAnalysis(3));
        System.out.println("5:");
        System.out.println(rps("rock", "paper"));
        System.out.println(rps("paper", "rock"));
        System.out.println(rps("paper", "scissors"));
        System.out.println(rps("scissors", "scissors"));
        System.out.println(rps("scissors", "paper"));
        System.out.println("6:");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));
        System.out.println("7:");
        System.out.println(mostExpensive(new Object[][]{
            new Object[]{"Скакалка", 550, 8},
            new Object[]{"Шлем", 3750, 4},
            new Object[]{"Мяч", 2900, 10}
        }));
        System.out.println("8:");
        System.out.println(longestUnique("abcba"));
        System.out.println(longestUnique("bbb"));
        System.out.println("9:");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));
        System.out.println("10:");
        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));
    }

    public static boolean isStrangePair(String first, String second){
        if (first == "" || second == ""){
            return true;
        }
        return (first.charAt(0) == second.charAt(second.length() - 1) && first.charAt(first.length() - 1) == second.charAt(0));
    }

    public static Object[][] sale(Object[][] initial, int discount){
        Object[][] newArray = Arrays.copyOf(initial, initial.length);
        float coefficient = (100 - discount) * .01f;
        int ind = 0;
        for (Object[] elem: initial){
            float newPrice = ((Integer) elem[1]) * coefficient;
            int priceInt = Math.round(newPrice);
            if (priceInt == 0){
                priceInt = 1;
            }
            newArray[ind][1] = priceInt;
            ind++;
        }
        return newArray;
    }

    public static boolean sucsessShoot(int x, int y, int r, int m, int n){
        int diffX = x - m;
        int diffY = y - n;
        double distance = Math.sqrt(diffX * diffX + diffY * diffY);
        return (distance < (double) r);
    }

    public static boolean parityAnalysis(int num){
        int tmp = num;
        int numsSum = 0;
        while (tmp != 0){
            numsSum += tmp % 10;
            tmp /= 10;
        }
        return (num % 2 == numsSum % 2);
    }

    public static String rps(String first, String second){
        if (first == second){
            return "Tie";
        }
        if ((first == "scissors" && second == "paper") || (first == "rock" && second == "scissors") || (first == "paper" && second == "rock")){
            return "Player 1 wins";
        }
        return "Player 2 wins";
    }

    public static int bugger(int num){
        int tmp;
        int cnt = 0;
        while (num > 10){
            tmp = 1;
            while (num != 0){
                tmp *= num % 10;
                num /= 10;
            }
            num = tmp;
            cnt++;
        }
        return cnt;
    }

    public static String mostExpensive(Object[][] items){
        String itemName = "";
        int maxTotal = 0;

        for (Object[] elem: items){
            int totalPrice = (Integer) elem[1] * (Integer) elem[2];
            if (totalPrice > maxTotal){
                itemName = (String) elem[0];
                maxTotal = totalPrice;
            }
        }
        return String.format("Наиб. общ. стоимость у предмета %s - %d", itemName, maxTotal);
    }

    public static String longestUnique(String initial){
        String longest = "";
        for (int i = 0 ; i < initial.length(); i++){
            for (int j = i + 1; j < initial.length(); j++){
                String substr = initial.substring(i, j);
                if (isUnique(substr) && substr.length() > longest.length()){
                    longest = substr;
                }
            }
        }
        return longest;
    }

    public static boolean isUnique(String toCheck){
        HashSet<Character> seen = new HashSet<>();
        for (char c: toCheck.toCharArray()){
            if (seen.contains(c)){
                return false;
            }
            seen.add(c);
        }
        return true;
    }

    public static boolean isPrefix(String word, String prefix){
        return (word.substring(0, prefix.length() - 1).equals(prefix.substring(0, prefix.length() -1)));
    }

    public static boolean isSuffix(String word, String suffix){
        return (word.substring(word.length() - suffix.length() + 1).equals(suffix.substring(1)));
    }


    public static boolean doesBrickFit(int a, int b, int c, int w, int h){
        int[] dimsArray = new int[]{a,b,c};
        int[] holeArray = new int[]{w,h};
        Arrays.sort(dimsArray);
        Arrays.sort(holeArray);
        return dimsArray[0] <= holeArray[0] && dimsArray[1] <= holeArray[1];
    }
}