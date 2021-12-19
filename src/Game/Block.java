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
   * draws the platform
   * 
   * @param Graphics g
   * @return N/A
   */
  public void draw(Graphics g) {
    Color color = Color.BLACK;
    if (this.type != 'b' || this.type != 'e') {
      if (this.type == 'p') {
        color = Color.PINK;
      } else if (this.type == 'l') {
        color = Color.ORANGE;
      } else if (this.type == 's') {
        color = Color.DARK_GRAY;
      } else if (this.type == '0') {
        color = Color.WHITE;
      }
    }
    // set the block colour
    g.setColor(color);
    // make sure the type isn't a spike
    if (this.type != 's') {
      // draw a rectangle to represent the block
      g.fillRect(this.xpos, this.ypos, width, height);
      return;
    }
    // draws a triangle
    int[] xpoints = { this.xpos, this.xpos + 15, this.xpos + 30 };
    int[] ypoints = { this.ypos, this.ypos + 30, this.ypos + 30 };
    g.fillPolygon(xpoints, ypoints, 3);

  }
}
