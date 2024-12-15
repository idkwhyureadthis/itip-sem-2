public class FilterProcessor {

    @DataProcessor
     String filterData(String data) {
        if (data.contains("error")) {
            return null;
        }
        return data;
    }
}
