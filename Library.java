import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> book_collection = new ArrayList<Book>();

    public void add_book() {
        Scanner input = new Scanner(System.in);
        String name = "";
        String publisher = "";
        int num_pages = 0;
        int rating = 0;
        boolean valid = false;
        
        while(!valid) {
            System.out.println("Enter the book's name: ");
            if(input.hasNextLine()) {
                name = input.nextLine();
                valid = true;
            }
            else {
                System.out.println("Sorry, couldn't understand you!");
                input.next();
            }
        }

        valid = false;
        while(!valid) {
            System.out.println("Enter the book's publisher: ");
            if(input.hasNextLine()) {
                publisher = input.nextLine();
                valid = true;
            }
            else {
                System.out.println("Sorry, couldn't understand you!");
                input.next();
            }
        }

        valid = false;
        while(!valid) {
            System.out.println("Enter the number of pages in the book: ");
            if(input.hasNextInt()) {
                num_pages = input.nextInt();
                valid = true;
            }
            else {
                System.out.println("Sorry, couldn't understand you!");
                input.next();
            }
        }

        valid = false;
        while(!valid) {
            System.out.println("Enter your rating for the book on a scale from 1-10: ");
            if(input.hasNextInt()) {
                rating = input.nextInt();
                if((rating < 1) || (rating > 10)) {
                    System.out.println("Please input a number between 1 and 10, inclusive.");
                }
                else {
                    valid = true;
                }
            }
            else {
                System.out.println("Sorry, couldn't understand you!");
                input.next();
            }
        }

        Book new_book = new Book(name, publisher, num_pages, rating);
        book_collection.add(new_book);
    }

    private int get_num_books() {
        return book_collection.size();
    }

    private int get_average_rating() {
        int sum = 0;
        for(int i = 0; i < book_collection.size(); i++) {
            sum += book_collection.get(i).get_rating();
        }
        return sum / book_collection.size();
    }

    public void print_stats() {
        int num_books = get_num_books();
        if(num_books < 1) {
            System.out.println("There are currently no books in the library. Statistics would be meaningless.");
            return;
        }
        System.out.println("Number of books in the library: " + num_books);

        int average_rating = get_average_rating();
        System.out.println("Average rating: " + average_rating);

        System.out.println("Press enter to continue ...");
        try {
            System.in.read();
        }
        catch(Exception e) {
        }
    }
}