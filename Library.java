import java.util.Scanner;
import java.util.Vector;
//import java.util.ArrayList;
//import java.util.List;

public class Library {
    Database new_database = new Database();

    public void add_book(String name, String publisher, int num_pages, int rating, String start_date_input, String end_date_input) {
        Book new_book = new Book(name, publisher, num_pages, rating, start_date_input, end_date_input);
        new_database.insert_book(new_book);
    }

    public void delete_book(int book_id) {
        new_database.delete_book(book_id);
    }

    public void update_book() {
        String book_name = "";
        boolean valid = false;

        System.out.println("Current books in the library:");
        new_database.get_book_names();

        System.out.println();
        System.out.println("Which book would you like to update?");

        Scanner input = new Scanner(System.in);
        while(!valid) {
            if(input.hasNextLine()) {
                book_name = input.nextLine();
                valid = true;
            }
            else {
                System.out.println("Sorry, couldn't understand you!");
                input.next();
            }
        }
        System.out.println();
        new_database.update_books(book_name);
        input.close();
    }

    public Vector<Vector<String>> print_books() {
        return new_database.get_books();
    }

    private int get_num_books() {
        return new_database.get_num_books();
        //return 0;
    }

    private float get_average_rating() {
        return new_database.get_avg_rating();
    }

    public void print_stats() {
        System.out.println();
        int num_books = get_num_books();
        if(num_books < 1) {
            System.out.println("There are currently no books in the library. Statistics would be meaningless.");
            return;
        }
        System.out.println("Number of books in the library: " + num_books);

        float average_rating = get_average_rating();
        System.out.println("Average rating: " + average_rating);
        System.out.println();
    }

    public void print_to_text() {
        return;
    }
}