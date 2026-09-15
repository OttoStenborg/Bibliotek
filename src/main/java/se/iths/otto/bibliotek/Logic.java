package se.iths.otto.bibliotek;

public class Logic {
    public void valMeny(){
        IO.println("1. Visa alla medier");
        IO.println("2. Lägg till bok");
        IO.println("3. lägg till film");
        IO.println("4. låna media");
        IO.println("5. Lämna tillbaka media");
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
            case "6":
                System.exit(0);
                break;
            default:
                IO.println("Ogiltigt input");
        }

        }

    public void addBook(){
        String title = IO.readln("Ange titel: ");
        String yearString = IO.readln("Ange år: ");
        try {
            int year = Integer.parseInt(yearString);
            String author = IO.readln("Ange författare: ");
            Main.library.add(new Book(title,year,false, author));
            IO.println("Boken är nu tillagd: "+title);
        } catch (NumberFormatException e) {
            IO.println("Ange endast siffror");
        }
    }


    public void addMovie(){
        String title = IO.readln("Ange titel: ");
        String yearString = IO.readln("Ange år: ");
        try{
            int year = Integer.parseInt(yearString);
            String director = IO.readln("Ange skapare: ");
            Main.library.add(new Movie(title,year,false,director));
            IO.println("Filmen är nu tillagd: "+title);
        } catch (RuntimeException e) {
            IO.println("Ange endast siffror");
        }

    }

    public void borrow(){
        String titel = IO.readln("Ange titel på median du vill låna");
        for (Media media : Main.library){
            if (media.getTitle().equals(titel)){
                if (!media.isBorrowed()){
                    media.borrowMedia();
                    IO.println(media.getTitle()+" är nu lånad");
                }else {
                    IO.println(media.getTitle()+" är redan utlånad");
                }
            }
            else {
                IO.println("Bokem/filmen finns inte");
            }
        }
    }

    public void returnMedia(){
        String titel = IO.readln("Ange titel på median du vill låna");
        for (Media media : Main.library){
            if (media.getTitle().equals(titel)){
                if (media.isBorrowed()){
                    media.returnM();
                    IO.println(media.getTitle()+" är nu återlämnad");
                }else {
                    IO.println(media.getTitle()+" är redan återlämnad");
                }
            }
            else {
                IO.println("Bokem/filmen finns inte");
            }
        }
    }


    public static void visaAllaMedier() {
        for (Media media : Main.library){
            media.printInfo();
            IO.println("____________________");
            //IO.println(media.getTitle());
        }

    }
    public void runProgram(){
        while(true){
            valMeny();
        }
    }

}
