import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {
    // connects to database "library" MUST ALREADY BE CREATED
    public void connect() {
        //Connection c = null;
        //try {
        //    Class.forName("org.postgresql.Driver");
        //    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "unlock");
        // } catch (Exception e) {
        //    e.printStackTrace();
        //    System.err.println(e.getClass().getName() + ": " + e.getMessage());
        //    System.exit(0);
        // }
        // System.out.println("Opened database successfully");
    }

    public void create_table() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "unlock");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE BOOKS " +
                "(NAME           TEXT, " +
                " PUBLISHER      TEXT, " +
                " NUM_PAGES      INT, " +
                " RATING         INT, " +
                " START_DATE     TEXT, " +
                " END_DATE       TEXT)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public void delete_table() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "unlock");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "DROP TABLE COMPANY";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table deleted successfully");
    }

    public void insert_book(Book to_add) {
        Connection c = null;
        Statement stmt = null;
        try {
            // connect to database
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "unlock");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            // get values for insertion
            String name = to_add.get_name();
            String publisher = to_add.get_publisher();
            int num_pages = to_add.get_num_pages();
            int rating = to_add.get_rating();
            String start_date = to_add.get_start_date();
            String end_date = to_add.get_end_date();

            // SQL formation and execution
            stmt = c.createStatement();
            String sql = "INSERT INTO BOOKS (NAME, PUBLISHER, NUM_PAGES, RATING, START_DATE, END_DATE) "
                + "VALUES ('" + name + "', '"
                + publisher + "', '"
                + Integer.toString(num_pages) + "', '"
                + Integer.toString(rating) + "', '"
                + start_date + "', '"
                + end_date + "');";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Book added successfully");
            return;
    }

    public void delete_book(String to_delete) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "unlock");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            //String to_delete_name = to_delete.get_name();

            stmt = c.createStatement();
            String sql = "DELETE from BOOKS where NAME = " + "'" + to_delete + "';";
            stmt.executeUpdate(sql);
            c.commit();

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Book deleted successfully");
    }

    public void get_books() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "unlock");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BOOKS;");
            while (rs.next()) {
                String name = rs.getString("name");
                String publisher = rs.getString("publisher");
                int num_pages = rs.getInt("num_pages");
                int rating = rs.getInt("rating");
                String start_date = rs.getString("start_date");
                String end_date = rs.getString("end_date");

                System.out.println("NAME = " + name);
                System.out.println("PUBLISHER = " + publisher);
                System.out.println("NUM_PAGES = " + num_pages);
                System.out.println("RATING = " + rating);
                System.out.println("START_DATE = " + start_date);
                System.out.println("END_DATE = " + end_date);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public void get_book_names() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "unlock");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BOOKS;");
            while (rs.next()) {
                String name = rs.getString("name");

                System.out.println("NAME = " + name);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        //System.out.println("Operation done successfully");
    }
}