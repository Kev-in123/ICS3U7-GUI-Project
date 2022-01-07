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
  DrawMap draw;

  public Player(Graphics gr, DrawMap d) {
    blocks = d.getBlocks();
    draw = d;
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
   * @param Block b
   * @return boolean
   */
  public boolean on_block(Block b) {
    if (b.type == '0') {
      return false;
    }
    int playerBottom = ypos + height;
    int playerRight = xpos + width;
    boolean inBoundary = xpos < b.getXPos() + 30 && playerRight > b.getXPos();
    boolean touching = playerBottom == b.getYPos();
    if (inBoundary && touching) {
      if (b.type == 'p') {
        nextLevel();
        return false;
      } else if (b.type == 'l') {
        respwan();
        return false;
      } else if (b.type == 's') {
        respwan();
        return false;
      }
    }
    return inBoundary && touching;
  }

  /**
   * checks if the player is right under a block, used for collision detection
   * 
   * @param Block b
   * @return boolean
   */
  public boolean under_block(Block b) {
    if (b.type == '0') {
      return false;
    }
    int playerRight = xpos + width;
    boolean inBoundary = xpos < b.getXPos() + 30 && playerRight > b.getXPos();
    boolean touching = ypos == b.getYPos() + 30;
    if (inBoundary && touching) {
      if (b.type == 'p') {
        nextLevel();
        return false;
      } else if (b.type == 'l') {
        respwan();
        return false;
      } else if (b.type == 's') {
        respwan();
        return false;
      }
    }
    return inBoundary && touching;
  }

  /**
   * checks if the player is directly to the left of a block, used for collision
   * detection
   * 
   * 
   * @param Block b
   * @return if the player is touching a block
   */
  public boolean right_block(Block b) {
    if (b.type == '0') {
      return false;
    }
    int playerBottom = ypos + height;
    boolean inBoundary = ypos < b.getYPos() + 30 && playerBottom > b.getYPos();
    boolean touching = xpos == b.getXPos() - 30;
    if (inBoundary && touching) {
      if (b.type == 'p') {
        nextLevel();
        return false;
      } else if (b.type == 'l') {
        respwan();
        return false;
      } else if (b.type == 's') {
        respwan();
        return false;
      }
    }
    return inBoundary && touching;
  }

  /**
   * checks if the player is directly to the left of a block, used for collision
   * detection
   * 
   * 
   * @param Block b
   * @return boolean
   */
  public boolean left_block(Block b) {
    if (b.type == '0') {
      return false;
    }
    int playerBottom = ypos + height;
    boolean inBoundary = ypos < b.getYPos() + 30 && playerBottom > b.getYPos();
    boolean touching = xpos == b.getXPos() + 30;
    if (inBoundary && touching) {
      if (b.type == 'p') {
        nextLevel();
        return false;
      } else if (b.type == 'l') {
        respwan();
        return false;
      } else if (b.type == 's') {
        respwan();
        return false;
      }
    }
    return inBoundary && touching;
  }

  /**
   * checks if the player is on any block, used for collision detection
   * 
   * @param Block b
   * @return boolean
   */
  public boolean on_any_block() {
    for (Block b : blocks) {
      if (on_block(b)) {
        return true;
      }
    }
    return false;
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
   * updates the level in the text file
   * 
   * @param N/A
   * @return N/A
   */
  public void setLevel(String level) {
    try {
      FileWriter file = new FileWriter("data.txt");
      BufferedWriter out = new BufferedWriter(file);
      out.write(level);
      out.close();
    } catch (IOException e) {
      System.out.println("Couldn't read the file");
    }
  }

  /**
   * updates the level
   * 
   * @param N/A
   * @return N/A
   */
  public void nextLevel() {
    setLevel(Integer.toString(++level));
    if (level == 11) {
      // go back to the main menu
      Game.frame.dispose();
      try {
        new Main.Main(false);
        setLevel("1");
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
    draw.draw_world(g);
    blocks = draw.getBlocks();
    respwan();
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
    gravity();
    paint();
  }

  public void gravity() {
    jumping = !on_any_block();
    if (!jumping) {
      set_yvel(0);
    } else if (jumping) {
      set_yvel(5);
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
    jumping = !on_any_block();
    if (key.getKeyCode() == KeyEvent.VK_UP && !jumping) {
      set_yvel(-65);
      for (Block b : blocks) {
        if (under_block(b)) {
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
  }

  /**
   * called when a key is released
   * 
   * @param a key event listener
   * @return N/A
   */
  @Override
  public void keyReleased(KeyEvent key) {
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
