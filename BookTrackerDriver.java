//import java.util.Scanner;

public class BookTrackerDriver {
    public static void main(String[] args) {
        Library new_lib = new Library();
        GUI the_gui = new GUI(new_lib);
        
        // Database new_database = new Database();
        //boolean is_done = false;

        //new_database.connect();

        /*
        while(is_done == false) {
            System.out.println("What would you like to do?\n");
            System.out.println("(A) Add a new book (B) Delete a book (C) Update a book (D) Print Books (E) Library Stats");
            System.out.println("(F) Get books in text file (X) Database Operations (Z) Exit");
            
            Scanner input = new Scanner(System.in);
            String option = input.nextLine();

            switch(option) {
                case "A":
                    new_lib.add_book();
                    break;
                case "E":
                    new_lib.print_stats();
                    break;
                case "D":
                    new_lib.print_books();
                    break;
                case "B":
                    new_lib.delete_book();
                    break;
                case "C":
                    new_lib.update_book();
                    break;
                case "F":
                    new_lib.print_to_text();
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
        */
    }
    /*    public static void database_operations(Database new_database) {
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
    */
}