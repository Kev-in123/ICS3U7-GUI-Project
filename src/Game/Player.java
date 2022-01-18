package Game;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;

public class Player implements KeyListener {
  // variables used throughout the class
  private int height = 30;
  private int width = 30;
  private int startx = 30;
  private int starty = 660;
  private int xpos = startx;
  private int ypos = starty;
  private int xvel = 0;
  private int yvel = 0;
  private int direction = 1;
  private boolean jumping = false;
  private int level;
  Block[] blocks;
  Graphics g;
  DrawMap draw;
  
  // added a sound effect for entering a portal
  static void playSoundEffect() {
	    File file = new File("Assets/Video-Game-Power-Level-Up-A2-Fast.wav");
	    try {
	      AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
	      Clip clip = AudioSystem.getClip();
	      clip.open(audioStream);
	      clip.start();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
  
  // added a sound effect for hitting a spike of lava
  static void playSoundEffect2() {
	    File file = new File("Assets/mixkit-electronic-retro-block-hit-2185.wav");
	    try {
	      AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
	      Clip clip = AudioSystem.getClip();
	      clip.open(audioStream);
	      clip.start();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
  
  // added a sound effect for jumping
  static void playSoundEffect3() {
	    File file = new File("Assets/Video game jump Sound Effect.wav");
	    try {
	      AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
	      Clip clip = AudioSystem.getClip();
	      clip.open(audioStream);
	      clip.start();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

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
    Graphics2D g2 = (Graphics2D) g;
    // sets the color of the player
    g2.setColor(Color.BLUE);
    // draws the player
    g2.fillRect(xpos, ypos, width, height);
    // sets the color of the player's eye
    g2.setColor(Color.BLACK);
    // determine the player's eye size based on the width
    int eye_size = width / 5;
    // determine the eye's location based on the width and direction
    int eye_x;
    if (direction == 1) {
      eye_x = xpos + width - 15;
    } else {
      eye_x = xpos + 5;
    }
    g2.fillOval(eye_x, ypos + 10, eye_size, eye_size);
  }

  /**
   * collision detection to the x boundaries of the palyer
   *
   * @param N/A
   * @return Rectangle
   */
  public Rectangle getBounds1() {
    int bx = xpos + xvel;
    int by = ypos + 2;
    int bw = 30 + xvel / 2;
    int bh = 30 - 4;
    return new Rectangle(bx, by, bw, bh);
  }

  /**
   * collision detection to the y boundaries of the palyer
   *
   * @param N/A
   * @return Rectangle
   */
  public Rectangle getBounds2() {
    int bx = xpos + 2;
    int by = ypos + yvel;
    int bw = 30 - 4;
    int bh = 30 + yvel / 2;
    return new Rectangle(bx, by, bw, bh);
  }

  /**
   * collision detection to the x & y boundaries of the player
   *
   * @param N/A
   * @return Rectangle
   */
  void collision() {
    for (Block b : blocks) {
      if (b.getType() == '0') {
        continue;
      }
      if (getBounds1().intersects(b.getBounds())) {
        if (b.getType() == 's' || b.getType() == 'l') {
	  playSoundEffect2(); 
          respwan();
        } else if (b.getType() == 'p') {
          playSoundEffect();
          nextLevel();
        }

        if (xvel > 0) {
          xvel = 0;
          xpos = b.getXPos() - width;
        } else if (xvel < 0) {
          xvel = 0;
          xpos = b.getXPos() + b.getWidth();
        }
      }
      if (getBounds2().intersects(b.getBounds())) {
        if (b.getType() == 's' || b.getType() == 'l') {
          playSoundEffect2();
          respwan();
        } else if (b.getType() == 'p') {
          playSoundEffect();
          nextLevel();
        }
        if (yvel > 0) {
          yvel = 0;
          ypos = b.getYPos() - height;
          jumping = false;
        } else if (yvel < 0) {
          yvel = 0;
          ypos = b.getYPos() + b.getHeight();
          jumping = false;
        }
      }
    }
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
    yvel = 0;
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
    collision();
    if (ypos >= 690)
      return;
    ++yvel;
  }

  /**
   * called when a key is pressed
   * 
   * @param a key event listener
   * @return N/A
   */
  @Override
  public void keyPressed(KeyEvent key) {
    int keyCode = key.getKeyCode();
    if (keyCode == KeyEvent.VK_UP && !jumping) {
      playSoundEffect3();
      yvel = -15;
      jumping = true;
    } else if (keyCode == KeyEvent.VK_DOWN) {
      yvel = 10;
    } else if (keyCode == KeyEvent.VK_LEFT) {
      xvel = -10;
      direction = -1;
    } else if (keyCode == KeyEvent.VK_RIGHT) {
      xvel = 10;
      direction = 1;
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
    int keyCode = key.getKeyCode();
    if (keyCode == KeyEvent.VK_UP && !jumping) {
      yvel = 0;
    } else if (keyCode == KeyEvent.VK_DOWN) {
      yvel = 0;
    }
    if (keyCode == KeyEvent.VK_LEFT) {
      xvel = 0;
    }
    if (keyCode == KeyEvent.VK_RIGHT) {
      xvel = 0;
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
