package se.iths.otto.bibliotek;

public class Book extends Media {
    private String author;

    public Book(String title, int year, boolean borrowed, String author) {
        super(title, year, borrowed);
        this.author = author;
    }

    @Override
    public void printInfo() {
        IO.println(getTitle() + "\n" +
                getYear() + "\n" +
                getAuthor());
        IO.println(getClass());
    }


    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }




}
