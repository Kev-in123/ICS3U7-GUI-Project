package Game;

import java.awt.*;
import java.awt.event.*;

public class Player extends World implements KeyListener {
  // variables used throughout the class
  private int height = 120;
  private int width = 60;
  private int xpos = 150;
  private int ypos = 650;
  private int velocity = 3;
  private int direction = 1;

  /**
   * draws the player
   * 
   * @param Graphics g
   * @return N/A
   */
  public void paint(final Graphics g) {
    // sets the color of the player
    g.setColor(Color.BLUE);
    // draws the player
    g.fillRect(xpos, ypos, width, height);
    // sets the color of the player's eye
    g.setColor(Color.BLACK);
    // determine the player's eye size based on the width
    int eye_size = width / 5;
    // determine the eye's location based on the width and direction
    int eye_x;
    if (direction == 1) {
      eye_x = xpos + width - 15;
    } else {
      eye_x = xpos + 5;
    }
    g.fillOval(eye_x, ypos + 10, eye_size, eye_size);
  }

  /**
   * updates the player's x position
   * 
   * @param int amt
   * @return N/A
   */
  public void updateXPos(int amt) {
    xpos += amt;
  }

  /**
   * updates the player's y position
   * 
   * @param int amt
   * @return N/A
   */
  public void updateYPos(int amt) {
    ypos += amt;
  }

  /**
   * returns the player's height
   * 
   * @param N/A
   * @return height
   */
  public int getPlayerHeight() {
    return height;
  }

  /**
   * returns the player's width
   * 
   * @param N/A
   * @return width
   */
  public int getPlayerWidth() {
    return width;
  }

  /**
   * returns the player's x position
   * 
   * @param N/A
   * @return xpos
   */
  public int getXPos() {
    return xpos;
  }

  /**
   * returns the player's y position
   * 
   * @param N/A
   * @return ypos
   */
  public int getYPos() {
    return ypos;
  }

  /**
   * called when a key is pressed
   * 
   * @param KeyEvent key
   * @return N/A
   */
  public void keyPressed(KeyEvent key) {
    if (key.getKeyCode() == KeyEvent.VK_UP) {
      ypos -= velocity;
    }
    if (key.getKeyCode() == KeyEvent.VK_DOWN) {
      ypos += velocity;
    }
    if (key.getKeyCode() == KeyEvent.VK_LEFT) {
      xpos -= velocity;
      direction = 1;
    }
    if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
      xpos += velocity;
      direction = -1;
    }
  }

  // not used
  // only here so the compiler doesn't complain

  /**
   * called when a key is released
   * 
   * @param KeyEvent key
   * @return N/A
   */
  public void keyReleased(KeyEvent key) {
  }

  /**
   * called when a key is typed
   * 
   * @param KeyEvent key
   * @return N/A
   */
  public void keyTyped(KeyEvent key) {
  }
}