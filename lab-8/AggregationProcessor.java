public class AggregationProcessor{
    @DataProcessor
    public String addPrefix(String data) {
        return "Processed: " + data;
}
}