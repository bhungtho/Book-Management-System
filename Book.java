public class Book {
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