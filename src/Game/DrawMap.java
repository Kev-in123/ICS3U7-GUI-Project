package Game;

import java.io.*;
import java.awt.Graphics;

import Levels.*;

public class DrawMap {
  // variables used throughout the class
  int xpos;
  int ypos;
  Block[] blocks;
  int level;

  DrawMap(Graphics g) {
    try {
      FileReader file = new FileReader("data.txt");
      BufferedReader in = new BufferedReader(file);
      String line = in.readLine();
      level = Integer.parseInt(line);
      in.close();
    } catch (IOException e) {
      System.out.println("Couldn't read the file");
    }

    String[] LEVEL = load_level(g, level);
    int x = 0;
    int y = 30;
    int length = LEVEL.length;
    blocks = new Block[length];
    for (int i = 0; i < length; i++) {
      Block b = new Block(x, y, LEVEL[i].charAt(0));
      blocks[i] = b;
      x += 30;
      if (LEVEL[i].charAt(0) == 'e') {
        y += 30;
        x = 0;
      }
    }
  }

  /**
   * loads the world
   * 
   * @param a graphics class, the level the user is on
   * @return N/A
   */
  public String[] load_level(Graphics g, int level) {
    LoadLevel l = new LoadLevel();
    String[][] levels = l.getLevels();
    return levels[level - 1];
  }

  /**
   * draws the world
   * 
   * @param a graphics class, the level the user is on
   * @return N/A
   */
  public void draw_world(Graphics g) {
    for (Block b: blocks) {
      b.draw(g);
    }
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
