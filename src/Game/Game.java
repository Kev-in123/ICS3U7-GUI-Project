package Game;

import java.awt.*;
import javax.swing.JFrame;

public class Game {
  JFrame frame;
  // Constructor
  public Game(JFrame frame) {
    this.frame = frame;
    // creates a new world
    World w = new World();
    // sets the size of the world
    this.frame.setSize(w.worldWidth, w.worldHeight);
    // sets an empty layout
    this.frame.setLayout(null);
    // makes the window visible
    this.frame.setVisible(true);
  }

  // Overrides the paint method
  /**
   * Used to draw the world
   * 
   * @param Graphics g
   * @return N/A
   */
  public void paint(Graphics g) {
    // calls the paint method in the JFrame class
    this.frame.paint(g);
    // breates instances of the ground, player, and platform
    Ground ground = new Ground();
    Player player = new Player();
    Platform platform = new Platform(100, 100, 200, 10);
    ground.paint(g);
    platform.paint(g);
    player.paint(g);
  }
}
