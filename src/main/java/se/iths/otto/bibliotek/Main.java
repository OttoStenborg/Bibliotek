package se.iths.otto.bibliotek;



public class Main {
    static void main() {

        LibraryService service = new LibraryService();
        Meny run = new Meny(service);
        run.runProgram();

    }
}
