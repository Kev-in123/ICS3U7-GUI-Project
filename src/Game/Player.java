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
  private int xvel = 0;
  private int yvel = 0;
  private int direction = 1;
  private int level;
  private boolean jumping = false;
  Block[] blocks;
  Graphics g;

  public Player(Graphics gr, Block[] b) {
    blocks = b;
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
    if (b.type == '0') {
      return false;
    }
    if (b.type != 'b') {
      if (b.type == 's' || b.type == 'l') {
        respwan();
      } else if (b.type == 'p') {
        nextLevel();
      }
    }
    // gets the players position
    int playerBottom = ypos + height;
    int playerRight = xpos + width;

    // checks if the player is on/over the block
    boolean inBoundary = xpos > b.getXPos() && playerRight < b.getXPos() + b.getXPos();
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
    if (b.type == '0') {
      return false;
    }
    if (b.type != 'b') {
      if (b.type == 's' || b.type == 'l') {
        respwan();
      } else if (b.type == 'p') {
        nextLevel();
      }
    }

    // gets the players position
    int playerRight = xpos + width;

    // checks if the player is on/over the block
    boolean inBoundary = xpos > b.getXPos() && playerRight < b.getXPos() + b.getXPos();
    // checks if the player is on the block
    boolean touching = ypos == b.getYPos() + 30;

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
    if (b.type == '0') {
      return false;
    }
    if (b.type != 'b') {
      if (b.type == 's' || b.type == 'l') {
        respwan();
      } else if (b.type == 'p') {
        nextLevel();
      }
    }

    // checks if the player is within the boundaries of the block
    boolean left = xpos == b.getXPos() && (!under_block(b) || !on_block(b));

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
    if (b.type == '0') {
      return false;
    }
    if (b.type != 'b') {
      if (b.type == 's' || b.type == 'l') {
        respwan();
      } else if (b.type == 'p') {
        nextLevel();
      }
    }

    // gets the players position
    int playerRight = xpos + width;

    // checks if the player is within the boundaries of the block
    boolean right = playerRight == b.getXPos() && (!under_block(b) || !on_block(b));

    return right && (under_block(b) || on_block(b));
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
    paint();
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
   * sets the current level the player is on
   * 
   * @param N/A
   * @return the current level
   */
  public void setLevel(int l) {
    level = l;
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
   * used for smoother animations
   * 
   * @param N/A
   * @return N/A
   */
  public void tick() {
    xpos += xvel;
    ypos += yvel;
    while (!jumping) {

    }
  }

  /**
   * used to set the x velocity
   * 
   * @param N/A
   * @return N/A
   */
  public void set_xvel(int vel) {
    xvel = vel;
  }

  /**
   * used to set the y velocity
   * 
   * @param N/A
   * @return N/A
   */
  public void set_yvel(int vel) {
    yvel = vel;
  }

  /**
   * called when a key is pressed
   * 
   * @param a key event listener
   * @return N/A
   */
  @Override
  public void keyPressed(KeyEvent key) {
    if (key.getKeyCode() == KeyEvent.VK_UP) {
      set_yvel(-5);
      for (Block b : blocks) {
        if (under_block(b)) {
          set_yvel(0);
          break;
        }
      }
    }

    if (key.getKeyCode() == KeyEvent.VK_DOWN) {
      set_yvel(5);
      for (Block b : blocks) {
        if (on_block(b)) {
          set_yvel(0);
          break;
        }
      }
    }

    if (key.getKeyCode() == KeyEvent.VK_LEFT) {
      set_xvel(-5);
      direction = -1;
      for (Block b : blocks) {
        if (left_block(b)) {
          set_xvel(0);
          break;
        }
      }
    }

    if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
      set_xvel(5);
      direction = 1;
      for (Block b : blocks) {
        if (right_block(b)) {
          set_xvel(0);
          break;
        }
      }
    }
    tick();
  }

  /**
   * called when a key is released
   * 
   * @param a key event listener
   * @return N/A
   */
  @Override
  public void keyReleased(KeyEvent key) {
    if (key.getKeyCode() == KeyEvent.VK_UP) {
      set_yvel(0);
    }
    if (key.getKeyCode() == KeyEvent.VK_DOWN) {
      set_yvel(0);
    }
    if (key.getKeyCode() == KeyEvent.VK_LEFT) {
      set_xvel(0);
    }
    if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
      set_xvel(0);
    }
  }

  // not used
  // only here so the compiler doesn't complain

  /**
   * called when a key is typed
   * 
   * @param a key event listener
   * @return N/A
   */
  @Override
  public void keyTyped(KeyEvent key) {
  }

}