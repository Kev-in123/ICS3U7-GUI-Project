package Game;

import java.awt.*;
import javax.swing.JFrame;

public class Game extends JFrame {
  // creates a new world
  World world = new World();
  public static void main(String[] args) {
    new Game();
  }

  // Constructor
  public Game() {
    // sets the size of the world
    setSize(world.worldWidth, world.worldHeight);
    // sets an empty layout
    setLayout(null);
    // makes the window visible
    setVisible(true);
  }

  // Overrides the paint method
  /**
   * Used to draw the world
   * 
   * @param Graphics g
   * @return N/A
   */
  @Override
  public void paint(Graphics g) {
    world.paint(g);
  }
}
