package Game;

import java.io.*;
import java.awt.*;

import Levels.*;

/**
 * @author Kevin Cai
 * 
 * last updated: 2022-01-21
 */
public class DrawMap {
  // variables used throughout the class
  Block[] blocks;
  int level;

  DrawMap(Graphics g) {
    draw_world(g);
  }


  /**
   * gets the level
   * 
   * @param N/A
   * @return int
   */
  public static int getLevel() {
    // initialize the level to 0
    int l = 0;
    try {
      // create a file reader
      FileReader file = new FileReader("data.txt");
      // create a buffered reader
      BufferedReader in = new BufferedReader(file);
      // read the line
      String line = in.readLine();
      // parse the string to an integer
      l = Integer.parseInt(line);
      // close the reader
      in.close();
    } catch (IOException e) {
      System.out.println("Couldn't read the file");
    }
    // return the level
    return l;
  }

  /**
   * loads the world
   * 
   * @param level
   * @return N/A
   */
  public String[] load_level(int level) {
    // create a LoadLevel instance
    LoadLevel l = new LoadLevel();
    // load the levels into a 2D array
    String[][] levels = l.getLevels();
    // return the levels
    return levels[level - 1];
  }

  /**
   * draws the world
   * 
   * @param g
   * @return N/A
   */
  public void draw_world(Graphics g) {
    // get the level
    level =  getLevel();
    // load the level
    String[] LEVEL = load_level(level);
    // initialize the starting point
    int x = 0;
    int y = 30;
    // find the length of the level
    int length = LEVEL.length;
    // create an array of blocks
    blocks = new Block[length];
    // fill the array with block instances
    for (int i = 0; i < length; i++) {
      if (i % 24 == 0 && i != 0) {
        y += 30;
        x = 0;
      }
      Block b = new Block(x, y, LEVEL[i].charAt(0));
      blocks[i] = b;
      x += 30;
    }
    // draw the blocks
    for (Block b : blocks) {
      b.draw(g);
    }
    // display the level in the corner
    g.setColor(Color.GREEN);
    g.drawString("Level: " + level, 90, 50);
  }
   
  /**
   * returns an array of the blocks
   * 
   * @param N/A
   * @return N/A
   */
  public Block[] getBlocks() {
    return blocks;
  }
}
