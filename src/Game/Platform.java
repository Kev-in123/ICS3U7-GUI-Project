package Game;

import java.awt.*;

public class Platform extends World {
  // variables used throughout the class
  int xpos;
  int ypos;
  int width;
  int height;

  // constructor, used to determine the position and size of the platform
  Platform(int x, int y, int w, int h) {
    this.xpos = x;
    this.ypos = y;
    this.width = w;
    this.height = h;
  }

  /**
   * draws the platform
   * 
   * @param Graphics g
   * @return N/A
   */
  public void paint(final Graphics g) {
    // set the grass colour
    g.setColor(Color.GREEN);
    // draw a rectangle to represent the grass
    g.fillRect(this.xpos, this.ypos, this.width, this.height);
    // set the dirt colour
    Color brown = new Color(230, 195, 105);
    g.setColor(brown);
    // draw a rectangle to represent the dirt
    g.fillRect(this.xpos, this.ypos + this.ypos / 25, this.width, this.height);
  }

  /**
   * checks if the player is on a platform, used to check if the player can jump
   * 
   * @param Player p
   * @return boolean
   */
  public boolean on_platform(Player p) {
    // gets the players position
    int playerBottom = p.getYPos() + p.getPlayerHeight();
    int playerLeft = p.getXPos();
    int playerRight = p.getXPos() + p.getPlayerWidth();

    // checks if the player is on/over the platform
    boolean inBoundary = playerLeft > this.xpos && playerRight < this.xpos + this.width;
    // checks if the player is on the platform
    boolean touching = playerBottom == this.ypos;

    return inBoundary && touching;
  }

}
