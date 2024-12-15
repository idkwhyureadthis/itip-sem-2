import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();

        // Register data processors
        dataManager.registerDataProcessor(new FilterProcessor());
        dataManager.registerDataProcessor(new TransformProcessor());
        dataManager.registerDataProcessor(new AggregationProcessor());

        // Load data
        String sourceFile = "input.txt";
        createSourceFile(sourceFile);
        dataManager.loadData(sourceFile);


        // Process data
        dataManager.processData();

        // Save data
        String destinationFile = "output.txt";
        dataManager.saveData(destinationFile);

        System.out.println("Data processing completed. Results saved to " + destinationFile);

    }

    private static void createSourceFile(String sourceFile){
        try {
            Files.write(Paths.get(sourceFile), List.of("some data", "another line", "data with error", "more data"),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
        }catch (IOException e){
            System.err.println("Error creating source file: " + e.getMessage());
        }

    }
}
