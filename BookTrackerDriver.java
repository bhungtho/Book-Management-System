import java.util.Scanner;

public class BookTrackerDriver {
    public static void main(String[] args) {
        Library new_lib = new Library();
        boolean is_done = false;

        while(is_done == false) {
            System.out.println("What would you like to do?\n");
            System.out.println("(A) Add a new book (B) Library Stats (E) Exit");
            
            Scanner input = new Scanner(System.in);
            String option = input.nextLine();

            switch(option) {
                case "A":
                    new_lib.add_book();
                    break;
                case "B":
                    new_lib.print_stats();
                    break;
                case "E":
                    is_done = true;
                    break;
                default:
                    System.out.println("Sorry, the option you chose is not valid. Please try again.");
            }
            //input.close();
        }
    }
}