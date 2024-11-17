import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class TopWords {
    public static void main(String[] args) {
        String filePath = "text.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, Integer> seen = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            String[] words = s.split(" ");
            for (String word : words){
                seen.put(word, seen.getOrDefault(word, 0) + 1);
            }
        }
        System.out.println(seen.toString());
        for (String word: seen.keySet()){
            System.out.println(word);
            list.add(word);
        }
        System.out.println(list.toString());
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                  return -seen.get(s1).compareTo(seen.get(s2));
            }
        });
        System.out.println(list.toString());
        for(int i = 0; i < Math.min(10, list.size()); i++){
            System.out.print(list.get(i) + " ");
        }

    }
}