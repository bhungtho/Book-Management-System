public class Book {
    String name;
    String publisher;
    int num_pages;
    int rating;
    int[3] start_date;
    int[3] end_date;

    public Book(String name, String publisher, int num_pages, int rating, int[] start_date, int[] end_date) {
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
}