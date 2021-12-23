package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Main.*;

public class Game implements KeyListener {
  Player player;
  DrawMap draw;
  Graphics graphics;
  JFrame frame;

  // Constructor
  public Game(JFrame f, Graphics g) {
    frame = f;
    graphics = g;
    // sets the size of the world
    frame.setSize(Main.WIDTH, Main.HEIGHT);
    // sets an empty layout
    frame.setLayout(null);
    // makes the window visible
    frame.setVisible(true);
    // create an instance of the player and the map
    draw = new DrawMap(g);
    player = new Player(g, draw.getBlocks());
  }

  /**
   * Used to draw the world
   * 
   * @param a graphics class
   * @return N/A
   */
  public void paint() {
    frame.addKeyListener(player);
    frame.addKeyListener(this);
    draw.draw_world(graphics);
    player.paint();
  }


    /**
   * called when a key is pressed
   * 
   * @param a key event listener
   * @return N/A
   */
  public void keyPressed(KeyEvent key) {
    draw.draw_world(graphics);
    player.paint();
  }


  /**
   * called when a key is released
   * 
   * @param a key event listener
   * @return N/A
   */
  public void keyReleased(KeyEvent key) {
    draw.draw_world(graphics);
    player.paint();
  }

  // not used
  // only here so the compiler doesn't complain

  /**
   * called when a key is typed
   * 
   * @param a key event listener
   * @return N/A
   */

  public void keyTyped(KeyEvent key) {
  }
}
