package Game;

import java.awt.*;

/**
 * @author Kevin Cai, Ayman Farhad
 * 
 * last updated: 2022-01-23
 *
 * Block class: contains all the blocks and elements in the game
 */
public class Block {
  // variables used throughout the class
  private int xpos;
  private int ypos;
  private char type;
  private int width = 30;
  private int height = 30;

 /**
   * The Block constructor - Creates a new block
   *
   * @param x - the x position of the block
   * @param y - the y position of the block
   * @param type - the type of the block
   */
  Block(int x, int y, char type) {
    this.xpos = x;
    this.ypos = y;
    this.type = type;
  }

  /**
   * gets the block's x position
   * 
   * @return the block's xpos
   */
  public int getXPos() {
    return this.xpos;
  }

  /**
   * gets the block's y position
   * 
   * @return the block's ypos
   */
  public int getYPos() {
    return this.ypos;
  }

  /**
   * gets the block's width
   * 
   * @return the block's width
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * gets the block's height
   * 
   * @return the block's height
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * gets the block's ytpye
   * 
   * @return the block's type
   */
  public char getType() {
    return this.type;
  }

  /**
   * get the blocks bounds
   * 
   * @return a rectanble representing the boundaries of the block
   */
  public Rectangle getBounds() {
    return new Rectangle(xpos, ypos, width, height);
  }

  /**
   * draws the block
   * 
   * @param g - the instance of the graphics class
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
      // draws the portal
      g.setColor(color);
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
