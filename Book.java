public class Book {
    String name;
    String publisher;
    int num_pages;
    int rating;

    public Book(String name, String publisher, int num_pages, int rating) {
        this.name = name;
        this.publisher = publisher;
        this.num_pages = num_pages;
        this.rating = rating;
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