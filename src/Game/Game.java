package Game;

import java.awt.*;
import javax.swing.JFrame;

import Main.*;

public class Game {
  public Player player;
  DrawMap draw;
  Graphics g;
   // Constructor
  public Game(JFrame frame, Graphics gr) {
    // sets the size of the world
    frame.setSize(Main.WIDTH, Main.HEIGHT);
    // sets an empty layout
    frame.setLayout(null);
    // makes the window visible
    frame.setVisible(true);
    // create an instance of the player and the map
    draw = new DrawMap();
    g = gr;
    player = new Player(gr);
  }

  /**
   * Used to draw the world
   * 
   * @param a graphics class
   * @return N/A
   */
  public void paint() {
    int level = player.getLevel();
    draw.draw_world(g, level);
    player.paint();
  }
}
