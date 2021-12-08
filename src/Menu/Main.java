package Menu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import Game.Game;

public class Main {
  JFrame frame;

  // constructer
  Main(JFrame frame) {
    this.frame = frame;
    // set the window size
    frame.setSize(1535, 800);
    // set the window layout
    frame.setLayout(null);
    // makes the window visible
    frame.setVisible(true);
    // add a button
    JButton b = new JButton("Start");
    // set the size and location of the button
    b.setBounds(50, 100, 95, 30);
    // set the action
    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Game game = new Game(frame);
        Graphics g = frame.getGraphics();
        game.paint(g);
        b.setVisible(false);
      }
    });
    // add the button to the window
    frame.add(b);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Game");
    new Main(frame);
  }
}