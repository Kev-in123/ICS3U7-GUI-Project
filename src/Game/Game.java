package Game;

import java.awt.*;
import javax.swing.*;

/**
 * @author Kevin Cai
 * 
 * last updated: 2022-01-23
 *
 * Game class: includes the game loop
 */
public class Game implements Runnable {
  Player player;
  DrawMap draw;
  Graphics graphics;
  static JFrame frame;
  Thread gameloop;

  /**
   * The Game constructor
   *
   * @param f - the main frame
   * @param g - the instance of the graphics class
   */
  public Game(JFrame f, Graphics g) {
    frame = f;
    graphics = g;
    // create an instance of the player and the map
    draw = new DrawMap(g);
    player = new Player(g, draw);
    gameloop = new Thread(this);
    gameloop.start();
  }

  /**
   * game loop
   * 
   */
  public void run() {
    Thread t = Thread.currentThread();
    while (t == gameloop) {
      try {
        Thread.sleep(1000 / 25);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      player.tick();
      draw();
    }
  }

  /**
   * Used to draw the world
   * 
   */
  public void draw() {
    draw.redraw(graphics);
    player.draw();
  }

  /**
   * Used to add the listeners
   * 
   */
  public void addListeners() {
    frame.addKeyListener(player);
  }
}
