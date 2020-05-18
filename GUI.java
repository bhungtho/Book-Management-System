import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;

public class GUI extends JFrame implements ActionListener {
    Library our_lib;
    JFrame f;
    JButton add_button;
    
    JTextField name_tf;
    JTextField publisher_tf;
    JTextField num_pages_tf;
    JTextField rating_tf;
    JTextField start_tf;
    JTextField end_tf;
    
    JLabel add_label;
    JLabel name_label;
    JLabel publisher_label;
    JLabel num_pages_label;
    JLabel rating_label;
    JLabel start_label;
    JLabel end_label;

    JTable book_table;

    JScrollPane sp;
    
    public GUI(Library new_lib) {
        our_lib = new_lib;

        // frame
        this.f = new JFrame("Book Management System");
        
        // buttons
        this.add_button = new JButton("Add");
        
        // labels
        this.add_label = new JLabel("Add A Book");
        this.name_label = new JLabel("Book Name:");
        this.publisher_label = new JLabel("Publisher:");
        this.num_pages_label = new JLabel("# of Pages:");
        this.rating_label = new JLabel("Rating:");
        this.start_label = new JLabel("Start Date:");
        this.end_label = new JLabel("End Date:");

        // text fields
        this.name_tf = new JTextField();
        this.publisher_tf = new JTextField();
        this.num_pages_tf = new JTextField();
        this.rating_tf = new JTextField();
        this.start_tf = new JTextField();
        this.end_tf = new JTextField();
        
        label_setup();
        tf_setup();
        button_setup();
        frame_setup();
        table_setup();
    }


    public void actionPerformed(ActionEvent e) {
        String name = name_tf.getText();
        String publisher = publisher_tf.getText();
        String num_pages = num_pages_tf.getText();
        int num_pages_int = Integer.parseInt(num_pages);
        String rating = rating_tf.getText();
        int rating_int = Integer.parseInt(rating);
        String start = start_tf.getText();
        String end = end_tf.getText();
        
        our_lib.add_book(name, publisher, num_pages_int, rating_int, start, end);
        
        //name_tf.setText("test");
    }

    public void label_setup() {
        // bounds
        add_label.setBounds(5, 5, 70, 20);
        name_label.setBounds(5, 30, 70, 20);
        publisher_label.setBounds(5, 55, 66, 20);
        num_pages_label.setBounds(5, 80, 66, 20);
        rating_label.setBounds(5, 105, 100, 20);
        start_label.setBounds(5, 130, 66, 20);
        end_label.setBounds(5, 155, 66, 20);

        // add to frame
        f.add(add_label);
        f.add(name_label);
        f.add(publisher_label);
        f.add(num_pages_label);
        f.add(rating_label);
        f.add(start_label);
        f.add(end_label);
    }

    public void tf_setup() {
        // bounds
        name_tf.setBounds(85, 30, 150, 20);
        publisher_tf.setBounds(85, 55, 150, 20);
        num_pages_tf.setBounds(85, 80, 150, 20);
        rating_tf.setBounds(85, 105, 150, 20);
        start_tf.setBounds(85, 130, 150, 20);
        end_tf.setBounds(85, 155, 150, 20);

        // add to frame
        f.add(name_tf);
        f.add(publisher_tf);
        f.add(num_pages_tf);
        f.add(rating_tf);
        f.add(start_tf);
        f.add(end_tf);
    }

    public void button_setup() {
        // bounds
        add_button.setBounds(5, 180, 60, 20);

        // set up interactions
        add_button.addActionListener(this);

        // add to frame
        f.add(add_button);
    }

    public void frame_setup() {
        // set up the size
        f.setSize(1000, 1000);

        // layout
        f.setLayout(null);

        // visible or not
        f.setVisible(true);
    }

    public void table_setup() {
        Vector<Vector<String>> book_data = our_lib.print_books();
        Vector<String> heading = new Vector<>();
        heading.add("Name");
        heading.add("Publisher");
        heading.add("Num. Pages");
        heading.add("Rating");
        heading.add("Start Date");
        heading.add("End Date");
        this.book_table = new JTable(book_data, heading);

        book_table.setBounds(240, 5, 600, 500);

        this.sp = new JScrollPane(book_table);
        f.add(sp);
    }
}
