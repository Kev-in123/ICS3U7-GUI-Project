package Game;

import java.awt.*;

public class World {
  // variables used throughout the class
  protected int worldHeight = 800;
  protected int worldWidth = 1535;

  public void paint(final Graphics g) {
    // breates instances of the ground, player, and platform
    Ground ground = new Ground();
    Player player = new Player();
    Platform platform = new Platform(100, 100, 200, 10);
    ground.paint(g);
    platform.paint(g);
    player.paint(g);
  }

  /**
   * returns the height of the world
   * 
   * @param N/A
   * @return worldHeight
   */
  public int getHeight() {
    return worldHeight;
  }

  /**
   * returns the width of the world
   * 
   * @param N/A
   * @return worldWidth
   */
  public int getWidth() {
    return worldWidth;
  }

}
