import java.util.Scanner;

public class BookTrackerDriver {
    public static void main(String[] args) {
        Library new_lib = new Library();
        Scanner input = new Scanner(System.in);
        boolean is_done = false;

        while(is_done == false) {
            System.out.println("What would you like to do?\n");
            System.out.println("(A) Add a new book (E) Exit");
            String option = input.nextLine();

            switch(option) {
                case "A":
                    new_lib.add_book();
                    break;
                case "E":
                    is_done = true;
                    break;
                default:
                    System.out.println("Sorry, the option you chose is not valid. Please try again.");
            }
        }
    }
}