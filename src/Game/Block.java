package Game;

import java.awt.Graphics;

import Levels.LoadLevel;

public class DrawMap {
  // variables used throughout the class
  int xpos;
  int ypos;

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
  public void draw_world(Graphics g, int level) {
    String[] LEVEL = load_level(g, level);
    int x = 0;
    int y = 30;
    for (int i = 0; i < 400; i++) {
      Block b = new Block(x, y, LEVEL[i].charAt(0));
      b.draw(g);
      x += 30;
      if (LEVEL[i].charAt(0) == 'e') {
        y += 30;
        x = 0;
      }
    }
  }

  /**
   * draws the map
   * 
   * @param a graphics class, the level the user is on
   * @return N/A
   */
  public void draw_map(Graphics g, int level) {
    // draws the world
    this.draw_world(g, level);
  }
}
