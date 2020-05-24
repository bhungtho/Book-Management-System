import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Book {
    int book_id;        // id of the book
    String name;        // name of the book
    String publisher;   // publisher of the book
    int num_pages;      // number of pages in the book
    int rating;         // rating the user gave to the book
    String start_date;  // when user started reading the book
    String end_date;    // when user finished reading the book

    // constructor
    public Book(String name, String publisher, int num_pages, int rating, String start_date, String end_date) {
        this.name = name;
        this.publisher = publisher;
        this.num_pages = num_pages;
        this.rating = rating;
        this.start_date = start_date;
        this.end_date = end_date;

        // reads the latest id
        int latest_id = -1;
        try {
            File file = new File("latest_id.txt");
            Scanner file_scanner = new Scanner(file);
            while (file_scanner.hasNextLine()) {
                latest_id = Integer.parseInt(file_scanner.nextLine());
            }
            file_scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        // updates the latest id
        try {
            PrintWriter prw= new PrintWriter ("latest_id.txt");
            prw.println(latest_id + 1);          
            prw.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        this.book_id = latest_id + 1;
    }

    // gets the id of the book
    public int get_id() {
        return book_id;
    }

    // gets the name of the book
    public String get_name() {
        return name;
    }

    // gets the publisher of the book
    public String get_publisher() {
        return publisher;
    }

    // gets the number of pages in the book
    public int get_num_pages() {
        return num_pages;
    }

    // gets the rating the user gave to the book
    public int get_rating() {
        return rating;
    }

    // gets the date user started reading the book
    public String get_start_date() {
        return start_date;
    }

    // gets the date user finished reading the book
    public String get_end_date() {
        return end_date;
    }
}