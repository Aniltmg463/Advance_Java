import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
public class GridBagLayoutDemo1 extends JFrame {
JButton btn1 = new JButton("Button 1");
JButton btn2 = new JButton("Button 2");
JButton btn3 = new JButton("Button 3");
JButton btn4 = new JButton("Button 4");
JButton btn5 = new JButton("Button 5");
public GridBagLayoutDemo1() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 500, 500);
setTitle("This is a Border Layout");
setVisible(true);
Container container = getContentPane();
GridBagLayout gridBagLayout=new GridBagLayout();
container.setLayout(gridBagLayout);
GridBagConstraints gridBagConstraints=new GridBagConstraints();
gridBagConstraints.fill=GridBagConstraints.HORIZONTAL;
gridBagConstraints.weightx=0.5;
gridBagConstraints.gridx=0;
gridBagConstraints.gridy=0;
container.add(btn1,gridBagConstraints);
//gridBagConstraints.weightx=0;
gridBagConstraints.gridx=1;
gridBagConstraints.gridy=0;
container.add(btn2,gridBagConstraints);
gridBagConstraints.gridx=2;
gridBagConstraints.gridy=0;

container.add(btn3,gridBagConstraints);
gridBagConstraints.gridwidth=3;
gridBagConstraints.gridx=0;
gridBagConstraints.gridy=1;
gridBagConstraints.ipadx=40;
container.add(btn4,gridBagConstraints);
gridBagConstraints.gridwidth=2;
gridBagConstraints.ipady=0;
gridBagConstraints.gridx=1;
gridBagConstraints.gridy=2;
gridBagConstraints.anchor=GridBagConstraints.PAGE_END;
gridBagConstraints.weighty=1;
container.add(btn5,gridBagConstraints);
pack();
}
public static void main(String[] args) {
new GridBagLayoutDemo1();
}
}