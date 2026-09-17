package se.iths.otto.bibliotek;

import se.iths.otto.bibliotek.model.Media;
import se.iths.otto.bibliotek.model.Book;
import se.iths.otto.bibliotek.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Media> library = new ArrayList<>();
    public void addBook(String title, int year, String author){
        library.add(new Book(title,year,false,author));
    }


    public void addMovie(String title, int year, String director){
        library.add(new Movie(title, year, false, director));
    }

    public boolean borrow(String title){
        for (Media media : library){
            if (media.getTitle().equals(title) && !media.isBorrowed()){
                media.borrowMedia();
                return true;
            }
        }
        return false;
    }
    public boolean returnMedia(String title){
        for (Media media : library) {
            if (media.getTitle().equals(title) && media.isBorrowed()) {
                media.returnMedia();
                return true;
                }
            }
        return false;
    }
    public void showAll(){
        for (Media media : library) {
            media.printInfo();
            IO.println("____________________");
        }
    }
    }

