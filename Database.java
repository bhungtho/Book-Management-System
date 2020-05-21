import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Vector;

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
            //System.out.println("Opened database successfully");

            // get values for insertion
            int book_id = to_add.get_id();
            String name = to_add.get_name();
            String publisher = to_add.get_publisher();
            int num_pages = to_add.get_num_pages();
            int rating = to_add.get_rating();
            String start_date = to_add.get_start_date();
            String end_date = to_add.get_end_date();

            // SQL formation and execution
            stmt = c.createStatement();
            String sql = "INSERT INTO BOOKS (EntryID, Name, Publisher, NumPages, Rating, StartDate, EndDate) "
                + "VALUES ('" + book_id + "', '" 
                + name + "', '"
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

    public void delete_book(int to_delete) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "unlock");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully");

            //String to_delete_name = to_delete.get_name();

            stmt = c.createStatement();
            String sql = "DELETE from BOOKS where EntryID = " + "'" + to_delete + "';";
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

    public void update_books(String update_name) {
        // boolean valid = false;
        Connection c = null;
        Statement stmt = null;
        //Statement query = null;
        try {
            // connect to database library
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "unlock");
            c.setAutoCommit(false);
            // System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BOOKS WHERE NAME = '" + update_name + "'");
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
            System.out.println("Which field would you like to update?");

            String sql = null;
            String update_field = null;
            int update_field_int = 0;

            Scanner input = new Scanner(System.in);
            String field = input.nextLine();
            System.out.println("What would you like to update " + field + " to?");

            switch(field) {
                case "NAME":
                    update_field = input.nextLine();
                    sql = "UPDATE BOOKS set " + field + " = '" + update_field + "' where NAME = '" + update_name + "';";
                    break;
                case "PUBLISHER":
                    update_field = input.nextLine();
                    sql = "UPDATE BOOKS set " + field + " = '" + update_field + "' where NAME = '" + update_name + "';";
                    break;
                case "NUM_PAGES":
                    update_field_int = input.nextInt();
                    sql = "UPDATE BOOKS set " + field + " = '" + Integer.toString(update_field_int) + "' where NAME = '" + update_name + "';";
                    break;
                case "RATING":
                    update_field_int = input.nextInt();
                    sql = "UPDATE BOOKS set " + field + " = '" + Integer.toString(update_field_int) + "' where NAME = '" + update_name + "';";
                    break;
                case "START_DATE":
                    update_field = input.nextLine();
                    sql = "UPDATE BOOKS set " + field + " = '" + update_field + "' where NAME = '" + update_name + "';";
                    break;
                case "END_DATE":
                    update_field = input.nextLine();
                    sql = "UPDATE BOOKS set " + field + " = '" + update_field + "' where NAME = '" + update_name + "';";
                    break;
                default:
                    System.out.println("The field you entered is not valid. The program will now exit.");
                    rs.close();
                    stmt.close();
                    c.close();
                    input.close();
                    return;
            }
            input.close();

            stmt = c.createStatement();
            // String sql = "UPDATE BOOKS set " + field + " = '" + update_field + "' where NAME = '" + update_name + "';";
            stmt.executeUpdate(sql);
            c.commit();
            
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public Vector<Vector<String>> get_books() {
        Vector<Vector<String>> book_data = new Vector<>();
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
                int book_id = rs.getInt("EntryID");
                String book_id_string = Integer.toString(book_id);
                String name = rs.getString("Name");
                String publisher = rs.getString("Publisher");
                int num_pages = rs.getInt("NumPages");
                String num_pages_string = Integer.toString(num_pages);
                int rating = rs.getInt("Rating");
                String rating_string = Integer.toString(rating);
                String start_date = rs.getString("StartDate");
                String end_date = rs.getString("EndDate");

                Vector<String> book_data_temp = new Vector<>();
                book_data_temp.add(book_id_string);
                book_data_temp.add(name);
                book_data_temp.add(publisher);
                book_data_temp.add(num_pages_string);
                book_data_temp.add(rating_string);
                book_data_temp.add(start_date);
                book_data_temp.add(end_date);

                book_data.add(book_data_temp);

                /*
                System.out.println("NAME = " + name);
                System.out.println("PUBLISHER = " + publisher);
                System.out.println("NUM_PAGES = " + num_pages);
                System.out.println("RATING = " + rating);
                System.out.println("START_DATE = " + start_date);
                System.out.println("END_DATE = " + end_date);
                System.out.println();
                */
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        //System.out.println("Operation done successfully");
        return book_data;
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

    public int get_num_books() {
        int count = 0;
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "unlock");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as num_books FROM BOOKS;");
            while (rs.next()) {
                count = rs.getInt("num_books");

                //System.out.println("num_books = " + count);
                //System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return count;
        //System.out.println("Operation done successfully");
    }

    public float get_avg_rating() {
        float average = 0;
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "unlock");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT AVG(RATING) as avg FROM BOOKS;");
            while (rs.next()) {
                average = rs.getInt("avg");

                //System.out.println("num_books = " + count);
                //System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return average;
    }
}