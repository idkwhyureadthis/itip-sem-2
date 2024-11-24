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
            System.out.println("error occured " + e.getMessage());
            return;
        } finally{
            try{
            scanner.close();
            } catch (IllegalStateException e){
                System.out.println("failed to close scanner" + e.getMessage());
            }
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
        for (String word: seen.keySet()){
            list.add(word);
        }
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                  return -seen.get(s1).compareTo(seen.get(s2));
            }
        });
        for(int i = 0; i < Math.min(10, list.size()); i++){
            System.out.print(list.get(i) + " : "  + seen.get(list.get(i)) + "\n");
        }

    }
}