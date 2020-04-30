import java.util.Scanner;

public class BookTrackerDriver {
    public static void main(String[] args) {
        Database new_database = new Database();
        Library new_lib = new Library();
        boolean is_done = false;

        //new_database.connect();

        while(is_done == false) {
            System.out.println("What would you like to do?\n");
            System.out.println("(A) Add a new book (B) Library Stats (C) Print Books (D) Delete a book (X) Database Operations (Z) Exit");
            
            Scanner input = new Scanner(System.in);
            String option = input.nextLine();

            switch(option) {
                case "A":
                    new_lib.add_book();
                    break;
                case "B":
                    new_lib.print_stats();
                    break;
                case "C":
                    new_lib.print_books();
                    break;
                case "D":
                    new_lib.delete_book();
                    break;
                case "E":
                    new_lib.update_book();
                    break;
                case "X":
                    database_operations(new_database);
                    break;
                case "Z":
                    is_done = true;
                    break;
                default:
                    System.out.println("Sorry, the option you chose is not valid. Please try again.");
            }
            //input.close();
        }
    }

    public static void database_operations(Database new_database) {
        System.out.println("Let's modify the database (for testing purposes mostly)!");
        System.out.println("(A) Create the table (ONLY DO THIS IF A TABLE IS NOT ALREADY THERE) (B) Delete the table");

        Scanner input = new Scanner(System.in);
        String option = input.nextLine();

        switch(option) {
            case "A":
                new_database.create_table();
                break;
            case "B":
                new_database.delete_table();
                break;
            default:
        }
    }
}