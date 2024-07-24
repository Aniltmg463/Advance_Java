
import java.awt.BorderLayout;
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
public class BorderLayoutDemo {
    public static void main(String[] args) {
JFrame frame = new JFrame ();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setBounds (100,100,500,500);
frame.setTitle("This is a Border Layout");
JButton btn1=new JButton("NORTH");
JButton btn2=new JButton("SOUTH");
JButton btn3=new JButton("EAST");
JButton btn4=new JButton("WEST");
JButton btn5=new JButton("CENTER");
frame.add(btn1,BorderLayout.NORTH);
frame.add(btn2,BorderLayout.SOUTH);
frame.add(btn3,BorderLayout.EAST);
frame.add(btn4,BorderLayout.WEST);
frame.add(btn5,BorderLayout.CENTER);
frame.setVisible(true);
}
    
}
