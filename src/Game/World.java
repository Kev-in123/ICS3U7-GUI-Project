package Game;

import java.awt.*;
import Main.*;

public class World {
  // variables used throughout the class
  private int worldHeight = Main.HEIGHT;
  private int worldWidth = Main.WIDTH;

  public void paint(Graphics g) {
    // creates instances of the ground, player, and platform
    Player player = new Player();
    DrawMap draw = new DrawMap();
    int level = player.getLevel();
    draw.draw_world(g, level);
    player.paint(g);
  }

  /**
   * returns the height of the world
   * 
   * @param N/A
   * @return the height of the world
   */
  public int getHeight() {
    return worldHeight;
  }

  /**
   * returns the width of the world
   * 
   * @param N/A
   * @return the width of the world
   */
  public int getWidth() {
    return worldWidth;
  }

}
