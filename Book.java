import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Book {
    int book_id;
    String name;
    String publisher;
    int num_pages;
    int rating;
    String start_date;
    String end_date;
    //int[] start_date = new int[3];
    //int[] end_date = new int[3];

    public Book(String name, String publisher, int num_pages, int rating, String start_date, String end_date) {
        this.name = name;
        this.publisher = publisher;
        this.num_pages = num_pages;
        this.rating = rating;
        this.start_date = start_date;
        this.end_date = end_date;

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
        
        try {
            PrintWriter prw= new PrintWriter ("latest_id.txt");
            prw.println(latest_id + 1);          
            prw.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        this.book_id = latest_id + 1;
        //return latest_id + 1;
    }

    public int get_id() {
        return book_id;
    }

    public String get_name() {
        return name;
    }

    public String get_publisher() {
        return publisher;
    }

    public int get_num_pages() {
        return num_pages;
    }

    public int get_rating() {
        return rating;
    }

    public String get_start_date() {
        return start_date;
    }

    public String get_end_date() {
        return end_date;
    }
}