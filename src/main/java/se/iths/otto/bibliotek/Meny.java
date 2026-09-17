package se.iths.otto.bibliotek;

public class Meny {
    private final LibraryService service;

    public Meny(LibraryService service) {
        this.service = service;
    }


    private boolean running = true;
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
                service.showAll();
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
                running = false;
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
            service.addBook(title,year,author);
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
            service.addMovie(title, year, director);
            IO.println("Filmen är nu tillagd: " + title);
        } catch (NumberFormatException e) {
            IO.println("Ange endast siffror");
        }
    }

    private void borrow() {
        String title = IO.readln("Ange titel på median du vill låna");
        if (service.borrow(title)) {
            IO.println(title + " är nu utlånad");
        } else {
            IO.println("Boken/filmen finns inte eller är utlånad");
        }
    }

    private void returnMedia() {
        String title = IO.readln("Ange titel på median du vill låna");
        if (service.returnMedia(title)){
            IO.println(title + " är nu returnerad");
        }else {
            IO.println("Boken/filmen finns inte eller är utlånad");
        }
    }

    public void runProgram() {
        while (running) {
            valMeny();
        }
    }


}
