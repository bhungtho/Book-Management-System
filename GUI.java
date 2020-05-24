import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class GUI extends JFrame implements ActionListener, TableModelListener {
    Library our_lib;
    JFrame f;

    JButton add_button;
    JButton delete_button;
    JButton create_table;
    JButton filler;
    
    JTextField name_tf;
    JTextField publisher_tf;
    JTextField num_pages_tf;
    JTextField rating_tf;
    JTextField start_tf;
    JTextField end_tf;

    JTextField name2_tf;
    
    JLabel add_label;
    JLabel name_label;
    JLabel publisher_label;
    JLabel num_pages_label;
    JLabel rating_label;
    JLabel start_label;
    JLabel end_label;

    JLabel delete_label;
    JLabel name2_label;

    JTable book_table;

    JScrollPane sp;

    JPanel table_pane;
    JPanel add_pane;
    JPanel main_pane;
    JPanel delete_pane;
    
    public GUI(Library new_lib) {
        our_lib = new_lib;

        // frame
        this.f = new JFrame("Book Management System");
        
        // buttons
        this.add_button = new JButton("Add");
        this.delete_button = new JButton("Delete");
        this.create_table = new JButton("Create Table");
        this.filler = new JButton("");
        
        // labels
        this.add_label = new JLabel("Add A Book");
        this.name_label = new JLabel("Book Name:");
        this.publisher_label = new JLabel("Publisher:");
        this.num_pages_label = new JLabel("# of Pages:");
        this.rating_label = new JLabel("Rating:");
        this.start_label = new JLabel("Start Date:");
        this.end_label = new JLabel("End Date:");

        this.delete_label = new JLabel("Delete A Book");
        this.name2_label = new JLabel ("Book ID:");

        // text fields
        this.name_tf = new JTextField(20);
        this.publisher_tf = new JTextField(20);
        this.num_pages_tf = new JTextField(20);
        this.rating_tf = new JTextField(20);
        this.start_tf = new JTextField(20);
        this.end_tf = new JTextField(20);

        this.name2_tf = new JTextField(20);

        table_setup();
        add_setup();
        frame_setup();
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add_button) {
            String name = name_tf.getText();
            String publisher = publisher_tf.getText();
            String num_pages = num_pages_tf.getText();
            int num_pages_int = Integer.parseInt(num_pages);
            String rating = rating_tf.getText();
            int rating_int = Integer.parseInt(rating);
            String start = start_tf.getText();
            String end = end_tf.getText();
                
            our_lib.add_book(name, publisher, num_pages_int, rating_int, start, end);
            //table_setup();
        }
        else if(e.getSource() == delete_button) {
            String entry_id = name2_tf.getText();
            int entry_id_int = Integer.parseInt(entry_id);
            our_lib.delete_book(entry_id_int);
        }
    }

    public void tableChanged(TableModelEvent e) {
        System.out.println("table changed");
    }

    public void frame_setup() {
        f.add(table_pane, BorderLayout.NORTH);
        f.add(add_pane, BorderLayout.SOUTH);
        //f.add(delete_pane, BorderLayout.EAST);

        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void table_setup() {
        Vector<Vector<String>> book_data = our_lib.print_books();
        Vector<String> heading = new Vector<>();
        
        heading.add("Entry ID");
        heading.add("Name");
        heading.add("Publisher");
        heading.add("Num. Pages");
        heading.add("Rating");
        heading.add("Start Date");
        heading.add("End Date");
        this.book_table = new JTable(book_data, heading);

        book_table.getModel().addTableModelListener(this);

        this.sp = new JScrollPane(book_table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        book_table.setPreferredScrollableViewportSize(new Dimension(420, 250));
        book_table.setFillsViewportHeight(true); 
        table_pane = new JPanel();
        table_pane.add(sp);
    }

    public void add_setup() {
        add_button.addActionListener(this);
        delete_button.addActionListener(this);
        create_table.addActionListener(this);

        this.add_pane = new JPanel();
        add_pane.setLayout(new GridLayout(9, 2));
        //add_pane.add(create_table);
        //add_pane.add(filler);
        add_pane.add(add_label);
        add_pane.add(add_button);
        add_pane.add(name_label);
        add_pane.add(name_tf);
        add_pane.add(publisher_label);
        add_pane.add(publisher_tf);
        add_pane.add(num_pages_label);
        add_pane.add(num_pages_tf);
        add_pane.add(rating_label);
        add_pane.add(rating_tf);
        add_pane.add(start_label);
        add_pane.add(start_tf);
        add_pane.add(end_label);
        add_pane.add(end_tf);
        add_pane.add(delete_label);
        add_pane.add(delete_button);
        add_pane.add(name2_label);
        add_pane.add(name2_tf);
    }
}
