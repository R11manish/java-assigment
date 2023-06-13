import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class WordCalculator extends JFrame {

  public WordCalculator() {
    setTitle("Character and word calculator");
    setSize(600, 650);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(null);
    JLabel Heading = new JLabel("start writing the text inside the textbox");
    JLabel display = new JLabel();
    JTextArea textArea = new JTextArea();
    Heading.setBounds(200, 25, 300, 50);
    textArea.setBounds(10, 90, 550, 400);
    display.setBounds(100, 500, 400, 50);
    textArea.addKeyListener(new KeyListener() {
      public void keyTyped(KeyEvent e) {
        String character = textArea.getText();
        String words[] = character.split("\\s");
        display.setText("total character counts :" + character.length() + " , words : " + words.length);
      }

      public void keyPressed(KeyEvent e) {
      }

      public void keyReleased(KeyEvent e) {
      }
    });
    add(Heading);
    add(textArea);
    add(display);
  }

  public static void main(String[] args) {
    WordCalculator app = new WordCalculator();
    app.setVisible(true);
  }
}
