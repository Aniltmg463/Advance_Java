
import java.awt.GridLayout;
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
public class GridLayoutDemo {
    public static void main(String[] args) {
JFrame frame = new JFrame ();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setBounds (100,100,500,500);
frame.setTitle("This is a Border Layout");
JButton btn1 = new JButton("Open");
JButton btn2 = new JButton("New");
JButton btn3 = new JButton("Sava");
JButton btn4 = new JButton("Delete");
JButton btn5 = new JButton("Exit");
JButton btn6 = new JButton("Open");
JButton btn7 = new JButton("New");
JButton btn8 = new JButton("Sava");
JButton btn9 = new JButton("Delete");
JButton btn10 = new JButton("Exit");
frame.add(btn1);
frame.add(btn2);
frame.add(btn3);
frame.add(btn4);
frame.add(btn5);
frame.add(btn6);
frame.add(btn7);
frame.add(btn8);
frame.add(btn9);
frame.add(btn10);
frame.setLayout(new GridLayout(2,2));
frame.setVisible(true);
}
    
}
