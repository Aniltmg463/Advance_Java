
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Spriment Uchiha
 */
public class FlowLayoutDemo {
    public static void main(String[] args) {
JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setBounds(100, 100, 500, 500);
frame.setTitle("This is a Flow Layout");
JButton btn1 = new JButton("Open");
JButton btn2 = new JButton("New");
JButton btn3 = new JButton("Sava");
JButton btn4 = new JButton("Delete");
JButton btn5 = new JButton("Exit");
frame.add(btn1);
frame.add(btn2);
frame.add(btn3);
frame.add(btn4);
frame.add(btn5);
frame.setLayout(new FlowLayout(FlowLayout.CENTER));
frame.setVisible(true);
}
    
}
