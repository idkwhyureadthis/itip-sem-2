import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.nio.file.*;


public class DataManager {

    private final List<Object> processors = new ArrayList<>();
    private List<String> data = new ArrayList<>();
    private List<String> processedData = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        try {
            data = java.nio.file.Files.readAllLines(java.nio.file.Paths.get(source));
        } catch (IOException e) {
            System.err.println("Error loading data from source: " + source + " " + e.getMessage());
        }
    }

    public void processData() {
        if (data.isEmpty()) {
            System.err.println("Data is empty. Unable to process.");
            return;
        }

            processedData = data.parallelStream()
                .map(line -> {
                  String processedLine = line;
                  for (Object processor : processors) {
                      processedLine = applyProcessor(processor, processedLine);
                      if (processedLine == null) break;
                    }
                    return processedLine;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private String applyProcessor(Object processor, String line) {
        String result = line;
          for (Method method : processor.getClass().getDeclaredMethods()) {
              if (method.isAnnotationPresent(DataProcessor.class)) {
                try {
                    result = (String) method.invoke(processor, result);
                } catch (IllegalAccessException|InvocationTargetException e) {
                   System.err.println("Error applying processor: " + method.getName() + " " + e.getMessage());
                 }
               }
           }
          return result;
     }

    public void saveData(String destination) {
        if(processedData.isEmpty()){
            System.err.println("Processed data is empty. Unable to save.");
            return;
        }
        try {
            Files.write(java.nio.file.Paths.get(destination), processedData, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.err.println("Error saving data to destination: " + destination + " " + e.getMessage());
        }
    }
}