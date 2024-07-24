import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
public class CardLayoutDemo extends JFrame implements ActionListener{
JButton btn1,btn2,btn3,btn4,btn5;
CardLayout cardLayout;
Container container;
CardLayoutDemo(){
btn1 = new JButton ("Button1");
btn2 = new JButton ("Button2");
btn3 = new JButton ("Button3");
btn4 = new JButton ("Button4");
btn5 = new JButton ("Button5");
container = this.getContentPane();
cardLayout = new CardLayout (10, 20);
container.setLayout(cardLayout);
container.add ("Card1", btn1);
container.add ("Card2", btn2);
container.add ("Card3", btn3);
container.add ("Card4", btn4);
container.add ("Card5", btn5);
btn1.addActionListener (this);
btn2.addActionListener (this);
btn3.addActionListener (this);
btn4.addActionListener (this);
btn5.addActionListener (this);
setVisible(true);
setSize(600, 600);
setTitle("This is a Card Layout");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String[] args) {
CardLayoutDemo cardLayoutDemo=new CardLayoutDemo();
}
@Override
public void actionPerformed(ActionEvent arg0) {
cardLayout.next(container);
}
}
