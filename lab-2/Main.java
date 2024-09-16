

public class Main {
    public static void main(String[] args) {
    }
}


abstract class Book{
    protected String author;    
    protected String name;
    protected boolean isRunning;
    public abstract String start();
    public abstract String stop();
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String newAuthor){
        author = newAuthor;
    }
    public String getName(){
        return name;
    }
    public void setName(String newName){
        name = newName;
    }
}


class AudioBook extends Book{
    private String voiceActor;
    AudioBook(String name, String author, String voiceActor){
        this.author = author;
        this.name = name;
        this.voiceActor = voiceActor;
    }

    AudioBook(Book book, String voiceActor){
        this(book.name, book.author, voiceActor);
    }

    public String getVoiceActor(){
        return voiceActor;
    }

    public void setVoiceActor(String newVoiceActor){
        voiceActor = newVoiceActor;
    }

    public String start(){
        if (isRunning){
            return "Audiobook already playing";
        }
        isRunning = true;
        return String.format("Audiobook '%s' playing", name);
    }


    public String stop(){
        if (!isRunning){
            return "Audiobook already stopped";
        }
        isRunning = false;
        return String.format("Audiobook '%s' stopped", name);
    }
}

class Musical extends Book{
    protected String producer;

    Musical(String name, String author, String producer){
        this.author = author;
        this.name = name;
        this.producer = producer;
    }

    Musical(Book book, String producer){
        this(book.name, book.author, producer);
    }

    public String start(){
        if (isRunning){
            return "Musical already started";
        }
        isRunning = true;
        return String.format("Musical '%s' started", name);
    }


    public String stop(){
        if (!isRunning){
            return "Musical already stopped";
        }
        isRunning = false;
        return String.format("Musical '%s' stopped", name);
    }

    public void setProducer(String newProducer){
        producer = newProducer;
    }

    public String getProducer(){
        return producer;
    }
}


class Movie extends Musical{
    public String start(){
        if (isRunning){
            return "Movie already started";
        }
        isRunning = true;
        return String.format("Movie '%s' started", name);
    }


    public String stop(){
        if (!isRunning){
            return "Movie already stopped";
        }
        isRunning = false;
        return String.format("Movie '%s' stopped", name);
    }


    Movie(String name, String author, String producer){
        super(name, author, producer);
    }

    Movie(Book book, String producer){
        this(book.name, book.author, producer);
    }
}
