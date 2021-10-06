package DAL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AddingIconToJLabel {

  public static void main(String[] a) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Icon icon = new ImageIcon("yourFile.gif");
    JLabel label3 = new JLabel("Warning", icon, JLabel.CENTER);

    frame.add(label3);

    frame.setSize(300, 200);
    frame.setVisible(true);
  }

}