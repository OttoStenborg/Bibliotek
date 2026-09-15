package se.iths.otto.bibliotek;


public class Movie extends Media{
    private String director;


    public Movie(String title, int year, boolean borrowed, String director) {
        super(title, year, borrowed);
        this.director = director;
    }


    @Override
    public void printInfo(){
        IO.println(getTitle()+"\n"+
        getYear()+"\n"+
        getDirector());
        IO.println(getClass());
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
