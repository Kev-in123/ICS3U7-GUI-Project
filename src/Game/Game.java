package Game;

import java.awt.*;
import javax.swing.JFrame;

public class Game {
  // creates a new world
  World world = new World();

  // Constructor
  public Game(JFrame frame) {
    // sets the size of the world
    frame.setSize(world.worldWidth, world.worldHeight);
    // sets an empty layout
    frame.setLayout(null);
    // makes the window visible
    frame.setVisible(true);
  }

  // Overrides the paint method
  /**
   * Used to draw the world
   * 
   * @param Graphics g
   * @return N/A
   */
  //@Override
  public void paint(Graphics g) {
    world.paint(g);
  }
}
