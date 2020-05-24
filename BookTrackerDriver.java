//import java.util.Scanner;

public class BookTrackerDriver {
    public static void main(String[] args) {
        // initialize the library
        Library new_lib = new Library();

        // initialize and start the GUI
        GUI the_gui = new GUI(new_lib);
    }
}