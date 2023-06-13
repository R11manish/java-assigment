import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GuiAddSub extends JFrame {

  private JTextField firstNumberField;
  private JTextField secondNumberField;
  private JLabel resultLabel;

  public GuiAddSub() {
    setTitle("Normal Calculator");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new GridLayout(8, 8));

    JLabel firstNumberLabel = new JLabel("First Number:");
    firstNumberField = new JTextField();

    JLabel secondNumberLabel = new JLabel("Second Number:");
    secondNumberField = new JTextField();

    JLabel resultTextLabel = new JLabel("Result:");
    resultLabel = new JLabel();

    JButton addButton = new JButton("Add");
    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addition();
      }
    });
    JButton subtractButton = new JButton("Subtract");
    subtractButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        substract();
      }
    });

    add(firstNumberLabel);
    add(firstNumberField);
    add(secondNumberLabel);
    add(secondNumberField);
    add(resultTextLabel);
    add(resultLabel);
    add(addButton);
    add(subtractButton);
  }

  private void addition() {
    try {
      int num1 = Integer.parseInt(firstNumberField.getText());
      int num2 = Integer.parseInt(secondNumberField.getText());
      int result = num1 + num2;
      resultLabel.setText(String.valueOf(result));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void substract() {
    try {
      int num1 = Integer.parseInt(firstNumberField.getText());
      int num2 = Integer.parseInt(secondNumberField.getText());
      int result = num1 - num2;
      resultLabel.setText(String.valueOf(result));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    GuiAddSub app = new GuiAddSub();
    app.setVisible(true);
  }
}
