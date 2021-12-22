package Main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Game.*;

public class Main extends JFrame {
  Game game;
  How how;
  public static final int WIDTH = 720;
  public static final int HEIGHT = 720;

  // constructor
  Main() {
    // set the window size
    setSize(WIDTH, HEIGHT);
    // set the layout
    setLayout(null);
    // set the close operation
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // set the colour
    getContentPane().setBackground(Color.CYAN);
    // makes the window visible
    setVisible(true);

    // initialize the game, the player, and the graphics
    Graphics g = getGraphics();
    game = new Game(Main.this, g);

    // add the game button
    final JButton gameButton = new JButton("Game");
    // add a how to play button
    final JButton howButton = new JButton("How to Play");
    // add an exit button
    final JButton exitButton = new JButton("Exit");
    // add a back button
    final JButton backButton = new JButton("Back");

    // set the size and location of the game button
    gameButton.setBounds(100, 300, 105, 30);
    // set the size and location of the how to play button
    howButton.setBounds(100, 335, 105, 30);
    // set the size and location of the exit button
    exitButton.setBounds(100, 370, 105, 30);
    // set the size and location of the back button
    backButton.setBounds(100, 370, 105, 30);

    // set the action for the game button
    gameButton.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        remove(gameButton);
        remove(howButton);
        remove(exitButton);
        game.paint();
        setFocusable(false);
        // add the keylistener from the player class
        Main.this.addKeyListener(game.player);
      }
    });

    // set the action for the how to play button
    howButton.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        remove(gameButton);
        remove(howButton);
        remove(exitButton);
        how = new How();
        add(how);
        add(backButton);
      }
    });

    // set the action for the back button
    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        remove(backButton);
        remove(how);
        repaint();
        add(gameButton);
        add(howButton);
        add(exitButton);
      }
    });

    // set the action for the exit button
    exitButton.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        System.exit(0);
      }
    });

    // add the buttons to the window
    add(gameButton);
    add(howButton);
    add(exitButton);
  }

  public JFrame getFrame() {
    return this;
  }

  public static void main(final String[] args) {
    new Main();
  }
}
