package se.iths.otto.bibliotek;

import java.util.ArrayList;
import java.util.List;

public class Logic {
    public void valMeny() {
        IO.println("1. Visa alla medier");
        IO.println("2. Lägg till bok");
        IO.println("3. lägg till film");
        IO.println("4. låna media");
        IO.println("5. Lämna tillbaka media");
        IO.println("0. Stänga av");
        String val = IO.readln("Ange ett val:  ");
        switch (val) {
            case "1":
                visaAllaMedier();
                break;
            case "2":
                addBook();
                break;

            case "3":
                addMovie();
                break;
            case "4":
                borrow();
                break;
            case "5":
                returnMedia();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                IO.println("Ogiltigt input");
        }

    }

    private void addBook() {
        String title = IO.readln("Ange titel: ");
        String yearString = IO.readln("Ange år: ");
        try {
            int year = Integer.parseInt(yearString);
            String author = IO.readln("Ange författare: ");
            library.add(new Book(title, year, false, author));
            IO.println("Boken är nu tillagd: " + title);
        } catch (NumberFormatException e) {
            IO.println("Ange endast siffror");
        }
    }


    private void addMovie() {
        String title = IO.readln("Ange titel: ");
        String yearString = IO.readln("Ange år: ");
        try {
            int year = Integer.parseInt(yearString);
            String director = IO.readln("Ange skapare: ");
            library.add(new Movie(title, year, false, director));
            IO.println("Filmen är nu tillagd: " + title);
        } catch (NumberFormatException e) {
            IO.println("Ange endast siffror");
        }
    }

    private void borrow() {
        String titel = IO.readln("Ange titel på median du vill låna");
        for (Media media : library) {
            if (media.getTitle().equals(titel)) {
                if (!media.isBorrowed()) {
                    media.borrowMedia();
                    IO.println(media.getTitle() + " är nu lånad");
                    return;
                } else {
                    IO.println(media.getTitle() + " är redan utlånad");
                    return;
                }
            }
        }
        IO.println("Boken/filmen finns inte");
    }

    private void returnMedia() {
        boolean found = false;
        String titel = IO.readln("Ange titel på median du vill låna");
        for (Media media : library) {
            if (media.getTitle().equals(titel)) {
                if (media.isBorrowed()) {
                    media.returnMedia();
                    IO.println(media.getTitle() + " är nu återlämnad");
                    return;
                } else {
                    IO.println(media.getTitle() + " är redan återlämnad");
                    return;
                }
            }
        }
        IO.println("Boken/filmen finns inte");
    }


    private static void visaAllaMedier() {
        for (Media media : library) {
            media.printInfo();
            IO.println("____________________");
        }

    }

    public void runProgram() {
        while (true) {
            valMeny();
        }
    }
    static List<Media> library = new ArrayList<>();

}
