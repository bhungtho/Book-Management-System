import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    // connects to database "library" MUST ALREADY BE CREATED
    public void connect() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "unlock");
         } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
         }
         System.out.println("Opened database successfully");
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
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
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
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table deleted successfully");
    }

    public void insert_book() {
        return;
    }
}