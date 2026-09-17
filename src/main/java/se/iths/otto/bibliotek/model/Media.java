package se.iths.otto.bibliotek.model;

public abstract class Media {
    private String title;
    private int year;
    private boolean borrowed;


    public void borrowMedia() {
        this.borrowed = true;
    }

    public void returnMedia() {
        this.borrowed = false;
    }

    public abstract void printInfo();


    public Media(String title, int year, boolean borrowed) {
        this.title = title;
        this.year = year;
        this.borrowed = borrowed;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}
