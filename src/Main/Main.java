package Main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Game.*;

public class Main extends JFrame {
  Game game;
  Player player;
  public static final int WIDTH = 600;
  public static final int HEIGHT = 600;

  // constructer
  Main() {
    // initialize the game, the player, and the graphics
    game = new Game(Main.this);
    player = new Player();
    final Graphics g = getGraphics();
    // set the window size
    setSize(WIDTH, HEIGHT);
    // set the close operation
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // set the layout
    setLayout(null);
    // makes the window visible
    setVisible(true);
    // add the game button
    final JButton gameButton = new JButton("Game");
    // add a button
    final JButton levelSelectButton = new JButton("LevelSelect");
    // set the size and location of the game button
    gameButton.setBounds(300, 300, 95, 30);
    // set the size and location of the level select button
    levelSelectButton.setBounds(300, 300, 95, 30);
    // set the action
    gameButton.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        gameButton.setVisible(false);
        game.paint(g);
        addKeyListener(player);
      }
    });
    //add a window listener to check when the screen is maximized
    addWindowStateListener(new WindowStateListener() {
      public void windowStateChanged(WindowEvent event) {
        boolean isMaximized = isMaximized(event.getNewState());
        boolean wasMaximized = isMaximized(event.getOldState());
        if (isMaximized && !wasMaximized) {
          game.paint(g);
        } else if (wasMaximized && !isMaximized) {
          game.paint(g);
        }
      }
    });
    // add the button to the window
    add(gameButton);
  }

  /**
   * used to check if the window is full-screened
   * 
   * @param the state of the screen
   * @return if the screen is maximized
   */
  private static boolean isMaximized(int state) {
    return (state & MAXIMIZED_BOTH) == MAXIMIZED_BOTH;
  }

  public static void main(final String[] args) {
    new Main();
  }
}
