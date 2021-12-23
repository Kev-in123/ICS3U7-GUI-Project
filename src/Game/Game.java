package Game;

import java.awt.*;
import javax.swing.*;

import Main.*;

public class Game {
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
    draw.draw_world(graphics);
    player.paint();
  }

}
