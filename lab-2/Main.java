public class Main {
    public static void main(String[] args) {
        
    }
}


abstract class Book{
    protected String author;    
    protected String name;    
    protected int totalPages;
    protected int currentPage;
    protected boolean isRead;
    public abstract String nextPage();
    public abstract String startReading();
    public abstract String endReading();
    public abstract int getPage();
    public abstract void setPage(int page);
    public abstract String getName();
}


class AudioBook extends Book{
    private String voiceActor;
    AudioBook(int totalPages, String name, String author, String voiceActor){
        this.totalPages = totalPages;
        this.voiceActor = voiceActor;
        this.author = author;
        this.name = name;
    }
    public String nextPage(){
        if (currentPage >= totalPages){
            return "book ended";
        }
        currentPage++;
        return String.format("reading page %d out of ", currentPage, totalPages);
    }

    public int getPage(){
        return currentPage;
    }

    public void setPage(int page){
        currentPage = page;
    }
}

