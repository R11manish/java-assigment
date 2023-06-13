import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButton extends JFrame {
  private JRadioButton radioButton1;
  private JRadioButton radioButton2;
  private JRadioButton radioButton3;
  private JLabel titleLabel;

  public RadioButton() {
    setTitle("Radio Button Demo");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(4, 1));
    titleLabel = new JLabel("Select Your Favourite Programming Language");
    radioButton1 = new JRadioButton("C/C++");
    radioButton2 = new JRadioButton("JAVA");
    radioButton3 = new JRadioButton("RUST");

    ButtonGroup buttonGroup = new ButtonGroup();

    buttonGroup.add(radioButton1);
    buttonGroup.add(radioButton2);
    buttonGroup.add(radioButton3);

    ActionListener radioButtonListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JRadioButton selectedRadioButton = (JRadioButton) e.getSource();
        String selectedOption = selectedRadioButton.getText();
        System.out.println("Selected option: " + selectedOption);
      }
    };

    radioButton1.addActionListener(radioButtonListener);
    radioButton2.addActionListener(radioButtonListener);
    radioButton3.addActionListener(radioButtonListener);

    add(titleLabel);
    add(radioButton1);
    add(radioButton2);
    add(radioButton3);
    pack();
    setVisible(true);
  }

  public static void main(String[] args) {
    RadioButton app = new RadioButton();
    app.setVisible(true);
  }
}
