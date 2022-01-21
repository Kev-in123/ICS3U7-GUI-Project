package Game;

import java.awt.*;

/**
 * @author Kevin Cai, Ayman Farhad
 * 
 * last updated: 2022-01-21  
 */
public class Block {
  // variables used throughout the class
  private int xpos;
  private int ypos;
  private char type;
  private int width = 30;
  private int height = 30;

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
   * @return the block's xpos
   */
  public int getXPos() {
    return this.xpos;
  }

  /**
   * returns the block's y position
   * 
   * @param N/A
   * @return the block's ypos
   */
  public int getYPos() {
    return this.ypos;
  }

  /**
   * returns the block's width
   * 
   * @param N/A
   * @return the block's width
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * returns the block's height
   * 
   * @param N/A
   * @return the block's height
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * returns the block's ytpye
   * 
   * @param N/A
   * @return the block's type
   */
  public char getType() {
    return this.type;
  }

  /**
   * get the blocks bounds
   * 
   * @param N/A
   * @return a rectanble representing the boundaries of the block
   */
  public Rectangle getBounds() {
    return new Rectangle(xpos, ypos, width, height);
  }

  /**
   * draws the block
   * 
   * @param g
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
    // if the type is a portal
    if (this.type == 'p') {
      // draw a rectangle for the background
      g.setColor(Color.WHITE);
      g.fillRect(this.xpos, this.ypos, width, height);
      g.setColor(color);
      // draws a circle
      g.fillOval(this.xpos + 5, this.ypos, 20, 30);
      g.setColor(Color.DARK_GRAY);
      g.fillOval(this.xpos+7, this.ypos+2, 16, 26);
      return;
    }
    // set the block colour
    g.setColor(color);
    // draw the block
    g.fillRect(this.xpos, this.ypos, width, height);
  }
}
