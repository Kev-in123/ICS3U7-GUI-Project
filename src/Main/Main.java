package Main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Game.*;
import Levels.*;

public class Main extends JFrame {
  Game game;
  LevelSelect levelSelect;
  public static final int WIDTH = 600;
  public static final int HEIGHT = 700;

  // constructer
  Main() {
    // set the window size
    setSize(WIDTH, HEIGHT);
    // set the layout
    setLayout(null);
    // set the close operation
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the window visible
    setVisible(true);

    // initialize the game, the player, and the graphics
    Graphics g = getGraphics();
    game = new Game(Main.this, g);
    levelSelect = new LevelSelect();

    // add the game button
    final JButton gameButton = new JButton("Game");
    // add a level select button
    final JButton levelSelectButton = new JButton("Level select");
    // add an exit button
    final JButton exitButton = new JButton("Exit");
    // add a back button
    final JButton backButton = new JButton("Back");

    // set the size and location of the game button
    gameButton.setBounds(100, 300, 105, 30);
    // set the size and location of the level select button
    levelSelectButton.setBounds(210, 300, 105, 30);
    // set the size and location of the exit button
    exitButton.setBounds(320, 300, 105, 30);
    // set the size and location of the back button
    backButton.setBounds(320, 600, 105, 30);

    // set the action for the game button
    gameButton.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        remove(gameButton);
        remove(levelSelectButton);
        remove(exitButton);
        game.paint();
        setFocusable(false);
        // add the keylistener from the player class
        add_listener();
      }
    });

    // set the action for the level select button
    levelSelectButton.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        remove(gameButton);
        remove(levelSelectButton);
        remove(exitButton);
        add(backButton);
        levelSelect.paint(g, Main.this, game);
      }
    });

    // set the action for the back button
    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        dispose();
        setVisible(true);
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
    add(levelSelectButton);
    add(exitButton);
  }

  public void add_listener() {
    // add the keylistener from the player class
    this.addKeyListener(game.player);
  }

  public static void main(final String[] args) {
    new Main();
  }
}
