package Game;

import java.awt.*;
import javax.swing.JFrame;

public class Game {
  // creates a new world
  World world = new World();

  // Constructor
  public Game(JFrame frame) {
    // sets the size of the world
    frame.setSize(world.getWidth(), world.getHeight());
    // sets an empty layout
    frame.setLayout(null);
    // makes the window visible
    frame.setVisible(true);
  }

  /**
   * Used to draw the world
   * 
   * @param a graphics class
   * @return N/A
   */
  public void paint(Graphics g) {
    world.paint(g);
  }
}
