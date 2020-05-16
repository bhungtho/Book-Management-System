import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
    JFrame f;
    JButton b;
    
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
    
    public GUI() {
        this.f = new JFrame("Book Management System");
        
        this.b = new JButton("Add");
        
        this.add_label = new JLabel("Add A Book");
        this.name_label = new JLabel("Book Name:");
        this.publisher_label = new JLabel("Publisher:");
        this.num_pages_label = new JLabel("# of Pages:");
        this.rating_label = new JLabel("Rating:");
        this.start_label = new JLabel("Start Date:");
        this.end_label = new JLabel("End Date:");

        this.name_tf = new JTextField();
        this.publisher_tf = new JTextField();
        this.num_pages_tf = new JTextField();
        this.rating_tf = new JTextField();
        this.start_tf = new JTextField();
        this.end_tf = new JTextField();

        add_label.setBounds(5, 5, 70, 20);
        name_label.setBounds(5, 30, 70, 20);
        publisher_label.setBounds(5, 55, 66, 20);
        num_pages_label.setBounds(5, 80, 66, 20);
        rating_label.setBounds(5, 105, 100, 20);
        start_label.setBounds(5, 130, 66, 20);
        end_label.setBounds(5, 155, 66, 20);
        
        name_tf.setBounds(85, 30, 150, 20);
        publisher_tf.setBounds(85, 55, 150, 20);
        num_pages_tf.setBounds(85, 80, 150, 20);
        rating_tf.setBounds(85, 105, 150, 20);
        start_tf.setBounds(85, 130, 150, 20);
        end_tf.setBounds(85, 155, 150, 20);

        b.setBounds(5, 180, 60, 20);
        //b.addActionListener(this);

        f.add(b);
        f.add(add_label);
        f.add(name_label);
        f.add(publisher_label);
        f.add(num_pages_label);
        f.add(rating_label);
        f.add(start_label);
        f.add(end_label);

        f.add(name_tf);
        f.add(publisher_tf);
        f.add(num_pages_tf);
        f.add(rating_tf);
        f.add(start_tf);
        f.add(end_tf);
        
        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        name_tf.setText("test");
    }
}
