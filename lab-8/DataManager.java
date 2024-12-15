import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import java.nio.file.*;


public class DataManager {

    private final List<Object> processors = new ArrayList<>();
    private List<String> data = new ArrayList<>();
    private List<String> processedData = new ArrayList<>();

    class ProcessorRunnable implements Runnable{
        private List<String> processed;
        private List<Object> processors;
        private List<String> toProcess;
        public void run(){
            List<String> processedData = toProcess.parallelStream()
            .map(line -> {
              String processedLine = line;
              for (Object processor : processors) {
                  processedLine = applyProcessor(processor, processedLine);
                  if (processedLine == null) break;
                }
                return processedLine;
            }).filter(Objects::nonNull).collect(Collectors.toList());
            for (Object s: processedData){
                processed.add((String)s);
                }
            }
    
        public ProcessorRunnable(List<String> processed, List<Object> processors, List<String> toProcess){
            this.processed = processed;
            this.processors = processors;
            this.toProcess = toProcess;
        }
    }

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
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<String> firstPart = data.subList(0, data.size() / 2);
        List<String> secondPart = data.subList(data.size() / 2, data.size());
        Runnable task1 = new ProcessorRunnable(processedData, processors, firstPart);
        Runnable task2 = new ProcessorRunnable(processedData, processors, secondPart);
        executorService.execute(task1);
        executorService.execute(task2);
        try{
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e){
            System.out.println("failed to terminate executorService: " + e.getMessage());
        }
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


