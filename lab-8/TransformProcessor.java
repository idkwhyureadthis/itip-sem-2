public class TransformProcessor {
    @DataProcessor
    public String transformData(String data) {
         return data.toUpperCase();
    }
}