package Game;

import java.awt.*;
import javax.swing.*;

public class Game implements Runnable {
  Player player;
  DrawMap draw;
  Graphics graphics;
  static JFrame frame;
  Thread gameloop;

  // Constructor
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
   * @param N/A
   * @return N/A
   */
  public void run() {
    Thread t = Thread.currentThread();
    while (t == gameloop) {
      try {
        Thread.sleep(1000 / 60);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      player.tick();
      paint();
    }
  }

  /**
   * Used to draw the world
   * 
   * @param a graphics class
   * @return N/A
   */
  public void paint() {
    draw.draw_world(graphics);
    player.paint();
  }

  /**
   * Used to add the listeners
   * 
   * @param N/A
   * @return N/A
   */
  public void addListeners() {
    frame.addKeyListener(player);
  }

}
