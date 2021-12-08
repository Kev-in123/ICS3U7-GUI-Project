package Game;

import java.awt.*;

public class Ground extends World {
  // variables used throughout the class
  private int groundX = 0;
  private int groundY = 770;
  private int groundHeight = worldHeight;
  private int groundWidth = worldWidth;

  /**
   * draws the ground
   * 
   * @param Graphics g
   * @return N/A
   */
  public void paint(final Graphics g) {
    // set the grass colour
    g.setColor(Color.GREEN);
    // draw a rectangle to represent the grass
    g.fillRect(groundX, groundY, groundWidth + 10, groundHeight);
    // set the dirt colour
    Color brown = new Color(230, 195, 105);
    g.setColor(brown);
    // draw a rectangle to represent the dirt
    g.fillRect(groundX, groundY + groundY/50, groundWidth + 10, groundHeight);
  }

  /**
   * checks if the player is on the ground, used to check if the player can jump
   * 
   * @param Player p
   * @return boolean
   */
  public boolean on_ground(Player p) {
    // gets the players position
    int playerBottom = p.getYPos() + p.getPlayerHeight();
    // checks if the player is on the ground
    boolean touching = playerBottom == groundY;

    // returns the boolean
    return touching;
  }
}
