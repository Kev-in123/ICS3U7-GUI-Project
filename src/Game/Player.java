package Game;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Player implements KeyListener {
  // variables used throughout the class
  private int height = 30;
  private int width = 30;
  private int startx = 150;
  private int starty = 150;
  private int xpos = startx;
  private int ypos = starty;
  private int velocity = 3;
  private int direction = 1;
  private int level;
  Graphics g;

  public Player(Graphics gr) {
    try {
      FileReader file = new FileReader("data.txt");
      BufferedReader in = new BufferedReader(file);
      String line = in.readLine();
      level = Integer.parseInt(line);
      in.close();
    } catch (IOException e) {
      System.out.println("Couldn't read the file");
    }
    g = gr;
  }

  /**
   * draws the player
   * 
   * @param a graphics class
   * @return N/A
   */
  public void paint() {
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
   * checks if the player is on a block, used to check if the player can jump
   * 
   * @param Player p
   * @return boolean
   */
  public boolean on_block(Block b) {
    if (b.type != 'b') {
      if (b.type == 's' || b.type == 'l') {
        respwan();
      } else if (b.type == '0') {
        return false;
      } else if (b.type == 'p') {
        nextLevel();
      }
    }
    // gets the players position
    int playerBottom = getYPos() + getPlayerHeight();
    int playerLeft = getXPos();
    int playerRight = getXPos() + getPlayerWidth();

    // checks if the player is on/over the block
    boolean inBoundary = playerLeft > b.getXPos() && playerRight < b.getXPos() + b.getXPos();
    // checks if the player is on the block
    boolean touching = playerBottom == b.getYPos();

    return inBoundary && touching;
  }

  /**
   * checks if the player is right under a block, used for collision detection
   * 
   * @param Player p
   * @return boolean
   */
  public boolean under_block(Block b) {
    if (b.type != 'b') {
      if (b.type == 's' || b.type == 'l') {
        respwan();
      } else if (b.type == '0') {
        return false;
      } else if (b.type == 'p') {
        nextLevel();
      }
    }
    // gets the players position
    int playerTop = getYPos();
    int playerLeft = getXPos();
    int playerRight = getXPos() + getPlayerWidth();

    // checks if the player is on/over the block
    boolean inBoundary = playerLeft > b.getXPos() && playerRight < b.getXPos() + b.getXPos();
    // checks if the player is on the block
    boolean touching = playerTop == b.getYPos();

    return inBoundary && touching;
  }

  /**
   * checks if the player is directly to the left of a block, used for collision
   * detection
   * 
   * @param Player p
   * @return if the player is touching a block
   */
  public boolean left_block(Block b) {
    if (b.type != 'b') {
      if (b.type == 's' || b.type == 'l') {
        respwan();
      } else if (b.type == '0') {
        return false;
      } else if (b.type == 'p') {
        nextLevel();
      }
    }

    // gets the players position
    int playerLeft = getXPos();

    // checks if the player is within the boundaries of the block
    boolean left = playerLeft == b.getXPos() && (under_block(b) || on_block(b));

    return left && (under_block(b) || on_block(b));
  }

  /**
   * checks if the player is directly to the right of a block, used for collision
   * detection
   * 
   * @param Player p
   * @return if the player is touching a block
   */
  public boolean right_block(Block b) {
    if (b.type != 'b') {
      if (b.type == 's' || b.type == 'l') {
        respwan();
      } else if (b.type == '0') {
        return false;
      } else if (b.type == 'p') {
        nextLevel();
      }
    }

    // gets the players position
    int playerRight = getXPos() + getPlayerWidth();

    // checks if the player is within the boundaries of the block
    boolean right = playerRight == b.getXPos() && (under_block(b) || on_block(b));

    return right && (under_block(b) || on_block(b));
  }

  /**
   * returns the player's height
   * 
   * @param N/A
   * @return the players height
   */
  public int getPlayerHeight() {
    return height;
  }

  /**
   * returns the player's width
   * 
   * @param N/A
   * @return the players width
   */
  public int getPlayerWidth() {
    return width;
  }

  /**
   * returns the player's x position
   * 
   * @param N/A
   * @return the players x position
   */
  public int getXPos() {
    return xpos;
  }

  /**
   * returns the player's y position
   * 
   * @param N/A
   * @return the players x position
   */
  public int getYPos() {
    return ypos;
  }

  /**
   * respwans the player
   * 
   * @param a graphics class
   * @return N/A
   */
  public void respwan() {
    // reset the location of the player
    xpos = startx;
    ypos = starty;
  }

  /**
   * returns the current level the player is on
   * 
   * @param N/A
   * @return the current level
   */
  public int getLevel() {
    return level;
  }

  /**
   * updates the level
   * 
   * @param N/A
   * @return N/A
   */
  public void nextLevel() {
    level++;
  }

  /**
   * called when a key is pressed
   * 
   * @param a key event listener
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
    paint();
  }

  // not used
  // only here so the compiler doesn't complain

  /**
   * called when a key is released
   * 
   * @param a key event listener
   * @return N/A
   */

  public void keyReleased(KeyEvent key) {
  }

  /**
   * called when a key is typed
   * 
   * @param a key event listener
   * @return N/A
   */

  public void keyTyped(KeyEvent key) {
  }

}