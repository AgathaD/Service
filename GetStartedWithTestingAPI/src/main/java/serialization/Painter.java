package serialization;


public class Painter{
    private String name;
    private String genre;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getGenre(){
        return genre;
    }

    @Override
    public String toString(){
        return "Painter { name :" + name + ", genre: " + genre + " }";
    }
}