package Menu;

import java.awt.event.*;
import javax.swing.*;
import Game.Game;

public class Main extends JFrame {
  // constructer
  Main() {
    // set the window size
    setSize(1535, 800);
    // set the window layout
    setLayout(null);
    // makes the window visible
    setVisible(true);
    // add a button
    JButton b = new JButton("Start");
    // set the size
    b.setBounds(50, 100, 95, 30);
    // set the action
    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    // add the button to the window
    add(b);

  }

  public static void main(String[] args) {
    new Main();
  }
}