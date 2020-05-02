import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
    JFrame f;
    JButton b;
    JTextField tf;
    
    public GUI() {
        this.f = new JFrame("Book Management System");
        this.b = new JButton("test button");
        this.tf = new JTextField();

        tf.setBounds(50, 50, 150, 20);

        b.setBounds(130, 100, 100, 40);
        b.addActionListener(this);

        f.add(b);
        f.add(tf);
        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        tf.setText("test");
    }
}
