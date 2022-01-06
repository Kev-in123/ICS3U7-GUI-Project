package Game;

import java.awt.*;

public class Block {
  // variables used throughout the class
  int xpos;
  int ypos;
  char type;
  int width = 30;
  int height = 30;

  // constructor, used to determine the position, size, and type of the platform
  Block(int x, int y, char type) {
    this.xpos = x;
    this.ypos = y;
    this.type = type;
  }

  /**
   * returns the block's x position
   * 
   * @param N/A
   * @return the x position of the block
   */
  public int getXPos() {
    return this.xpos;
  }

  /**
   * returns the block's y position
   * 
   * @param N/A
   * @return the y position of the block
   */
  public int getYPos() {
    return this.ypos;
  }

  /**
   * draws the block
   * 
   * @param Graphics g
   * @return N/A
   */
  public void draw(Graphics g) {
    Color color = Color.BLACK;
    if (this.type != 'b') {
      if (this.type == 'p') {
        color = Color.PINK;
      } else if (this.type == 'l') {
        color = Color.RED;
      } else if (this.type == 's') {
        color = Color.DARK_GRAY;
      } else if (this.type == '0') {
        color = Color.WHITE;
      }
    }
    // if the type is a spike
    if (this.type == 's') {
      // draw a rectangle for the background
      g.setColor(Color.WHITE);
      g.fillRect(this.xpos, this.ypos, width, height);
      g.setColor(color);
      // draws a triangle
      int[] xpoints = { this.xpos + 15, this.xpos + 30, this.xpos };
      int[] ypoints = { this.ypos, this.ypos + 30, this.ypos + 30 };
      g.fillPolygon(xpoints, ypoints, 3);
      return;
    }
    // set the block colour
    g.setColor(color);
    // draw the block
    g.fillRect(this.xpos, this.ypos, width, height);
  }
}
