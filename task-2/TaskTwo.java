import java.util.Arrays;
public class TaskTwo{
    
    public static void main(String[] args){
        System.out.println("1:");
        System.out.println(duplicateChars("Barack", "Obama"));
        System.out.println("2:");
        System.out.println(dividedByThree(new int[]{3, 12, 7, 81, 52}));
        System.out.println("3:");
        System.out.println(getInitials("simonov sergei evgenievich"));
        System.out.println(getInitials("kozhevnikova tatiana vitalevna"));
        System.out.println("4:");
        System.out.println(Arrays.toString(normalizator(new float[]{3.5f, 7.0f, 1.5f, 9.0f, 5.5f})));
        System.out.println(Arrays.toString(normalizator(new float[]{10.0f, 10.0f, 10.0f, 10.0f})));
        System.out.println("5:");
        System.out.println(Arrays.toString(compressedNums(new float[] {1.6f, 0, 212.3f, 34.8f, 0, 27.5f})));
        System.out.println("6:");
        System.out.println(camelToSnake("helloWorld"));
        System.out.println("7:");
        System.out.println(secondBiggest(new int[]{3, 5, 8, 1, 2, 4}));
        System.out.println("8:");
        System.out.println(localReverse("baobab", 'b'));
        System.out.println(localReverse("Hello, I'm under the water, please help me", 'e'));
        System.out.println("9:");
        System.out.println(equal(8, 1, 8));
        System.out.println(equal(5, 5, 5));
        System.out.println(equal(4, 9, 6));
        System.out.println("10:");
        System.out.println(isAnagram("LISTEN", "silent"));
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
        System.out.println(isAnagram("hello", "world"));
    }

    public static String duplicateChars(String first, String second){
        first = first.toLowerCase();
        second = second.toLowerCase();
        String ans = "";
        for (int i = 0; i < first.length(); i++){
            String letterToCheck = String.valueOf(first.charAt(i));
            if (!second.contains(letterToCheck)){
                ans += first.charAt(i);
            }
        }
        return ans;
    }

    public static int dividedByThree(int[] nums){
        int n = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] % 2 != 0 && nums[i] % 3 == 0){
                n++;
        }
    }
        return n;
    }

    public static String getInitials(String fullName){
        String ans = "";
        String[] separated = fullName.split(" ");
        ans += separated[1].toUpperCase().charAt(0) + ".";
        ans += separated[2].toUpperCase().charAt(0) + ". ";
        ans += separated[0].toUpperCase().charAt(0) + separated[0].substring(1);
        return ans;
    }

    public static float[] normalizator(float[] nums){
        float[] ans = new float[nums.length];
        float max = Float.NEGATIVE_INFINITY, min = Float.POSITIVE_INFINITY;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < min){
                min = nums[i];
            }
            if (nums[i] > max){
                max = nums[i];
            }
        }
        for(int i = 0; i < nums.length; i++){
            if (nums[i] == min){
                ans[i] = 0;
            } else if (nums[i] == max){
                ans[i] = 1;
            } else {
                ans[i] = (nums[i] - min) / (max - min);
            }
        }
        return ans;
    }
    
    public static float[] compressedNums(float[] nums){
        float[] answ;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0) zeroCount++;
        }
        answ = new float[nums.length - zeroCount];
        int currInd = 0; 
        for(int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                answ[currInd] = nums[i];
                currInd++;
            }
        }
        Arrays.sort(answ);
        return answ;
    }

    public static String camelToSnake(String str){
        return str.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
    }

    public static int secondBiggest(int[] nums){
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        return tmp[tmp.length - 2];
    }


    public static String localReverse(String initialText, char delimiter){
        String ans;
        String[] middleStrings = initialText.split(new String(new char[]{delimiter}));
        for (int i = 0; i < middleStrings.length; i++){
            middleStrings[i] = reverse(middleStrings[i]);
        }
        ans = String.join(new String(new char[]{delimiter}), middleStrings);
        if (initialText.charAt(initialText.length() - 1) == delimiter){
            ans += delimiter;
        }
        return ans;
    }

    public static String reverse(String toReverse){
        String reversed = "";
        for(int i = toReverse.length() - 1; i >= 0; i--){
            reversed += toReverse.charAt(i);
        }
        return reversed;
    }


    public static int equal(int first, int second, int third){
        if (first == second && second == third){
            return 3;
        } else if (first == second || second == third || first == third){
            return 2;
        }
        return 0;
    }


    public static boolean isAnagram(String first, String second){
        first = first.replaceAll("[^a-zA-Z]", "").toLowerCase();
        second = second.replaceAll("[^a-zA-Z]", "").toLowerCase();
        char[] firstCa = first.toCharArray();
        char[] secondCa = second.toCharArray();
        Arrays.sort(firstCa);
        Arrays.sort(secondCa);
        return Arrays.equals(firstCa, secondCa);
    }
}