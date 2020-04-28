import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> book_collection = new ArrayList<Book>();

    public void add_book() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the book's name: ");
        String name = input.nextLine();

        System.out.println("Enter the book's publisher: ");
        String publisher = input.nextLine();

        System.out.println("Enter the number of pages in the book: ");
        int num_pages = input.nextInt();

        System.out.println("Enter your rating for the book: ");
        int rating = input.nextInt();

        Book new_book = new Book(name, publisher, num_pages, rating);
        book_collection.add(new_book);
    }
}