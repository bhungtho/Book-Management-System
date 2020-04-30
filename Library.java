import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;

public class Library {
    //List<Book> book_collection = new ArrayList<Book>();
    Database new_database = new Database();

    public void add_book() {
        Scanner input = new Scanner(System.in);
        String name = "";
        String publisher = "";
        int num_pages = 0;
        int rating = 0;
        String start_date_input = "";
        String end_date_input = "";
        // int[] start_date = new int[3];
        // int[] end_date = new int[3];
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

        input.nextLine();

        valid = false;
        while(!valid) {
            System.out.println("Enter the date when you started the book in the format mm/dd/yyyy: ");
            if(input.hasNextLine()) {
                start_date_input = input.nextLine();
                valid = true;
            }
            else {
                System.out.println("Sorry, couldn't understand you!");
                input.next();
            }
        }

        valid = false;
        while(!valid) {
            System.out.println("Enter the date when you finished the book in the format mm/dd/yyyy: ");
            if(input.hasNextLine()) {
                end_date_input = input.nextLine();
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
                    input.next();
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

        System.out.println(start_date_input + " " + end_date_input);

        //String[] start_date_string = start_date_input.split("/", 3);
        //String[] end_date_string = end_date_input.split("/", 3);

        //for(int i = 0; i < 3; i++) {
            //start_date[i] = Integer.parseInt(start_date_string[i]);
            //end_date[i] = Integer.parseInt(end_date_string[i]);
        //}

        // System.out.println(start_date[0] + " " + start_date[1] + " " + start_date[2]);

        Book new_book = new Book(name, publisher, num_pages, rating, start_date_input, end_date_input);
        //book_collection.add(new_book);
        //input.close();

        new_database.insert_book(new_book);
    }

    public void delete_book() {
        String book_name = "";
        boolean valid = false;

        System.out.println("Current books in the library:");
        new_database.get_book_names();

        System.out.println("");
        System.out.println("Which book would you like to delete?");

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

        new_database.delete_book(book_name);
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
    }

    public void print_books() {
        new_database.get_books();
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
}