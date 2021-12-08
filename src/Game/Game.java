package Game;

import java.awt.*;
import javax.swing.JFrame;

public class Game extends JFrame {
  // Constructor
  public Game() {
    // creates a new world
    World w = new World();
    // sets the size of the world
    setSize(w.worldWidth, w.worldHeight);
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
    // calls the paint method in the JFrame class
    super.paint(g);
    // breates instances of the ground, player, and platform
    Ground ground = new Ground();
    Player player = new Player();
    Platform platform = new Platform(100, 100, 200, 10);
    ground.paint(g);
    platform.paint(g);
    player.paint(g);
  }
}
