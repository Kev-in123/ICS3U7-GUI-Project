package Menu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import Game.*;

public class Main extends JFrame {
  Game game;
  Player player;

  // constructer
  Main() {
    // set the window size
    setSize(1535, 800);
    // set the window layout
    setLayout(null);
    // makes the window visible
    setVisible(true);
    // add a button
    JButton b = new JButton("Game");
    // set the size and location of the button
    b.setBounds(400, 600, 95, 30);
    // set the action
    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        game = new Game(Main.this);
        player = new Player();
        Graphics g = getGraphics();
        game.paint(g);
        addKeyListener(player);
        b.setVisible(false);
      }
    });
    // add the button to the window
    add(b);
  }

  public static void main(String[] args) {
    new Main();
  }
}
