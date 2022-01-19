package Main;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import javax.sound.sampled.*;

import Game.*;

public class Main extends JFrame {
  // declare the game page and the how to play page
  Game game;
  How how;
  // declare the frame width and height
  public static int WIDTH = 720;
  public static int HEIGHT = 720;

  // constructor
  public Main(boolean is_user) throws IOException {
    // set the window size
    setSize(WIDTH, HEIGHT);
    // set the layout
    setLayout(null);
    // set the close operation
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // set the colour
    getContentPane().setBackground(new Color(0, 0, 128));
    // makes the window visible
    setVisible(true);
    // make the window un-resizable
    setResizable(false);

    // initialize the graphics
    Graphics g = getGraphics();

    // add a start button
    JButton startButton = new JButton("Start");
    // add the game button
    JButton gameButton = new JButton("Game");
    // add a how to play button
    JButton howButton = new JButton("How to Play");
    // add an exit button
    JButton exitButton = new JButton("Exit");
    // add a back button
    JButton backButton = new JButton("Back");
    // add a title
    JLabel title = new JLabel("Lost");
    // add the authors
    JLabel authors = new JLabel("By: Kevin Cai and Ayman Farhad");

    // add image
    BufferedImage wPic = ImageIO.read(new File("Assets/portal-image.png"));
    JLabel wIcon = new JLabel(new ImageIcon(wPic));

    // set the size and location of the game button
    gameButton.setBounds(100, 300, 105, 30);
    // set the size and location of the how to play button
    howButton.setBounds(100, 335, 105, 30);
    // set the size and location of the exit button
    exitButton.setBounds(100, 370, 105, 30);
    // set the size and location of the back button
    backButton.setBounds(100, 335, 105, 30);
    // set the size, location, font, and colour of the title
    title.setBounds(345, 200, 500, 300);
    title.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 50));
    title.setForeground(Color.WHITE);
    // set the size and location of image
    wIcon.setBounds(200, 100, 400, 500);
    // set the size and location of the start button
    startButton.setBounds(100, 335, 105, 30);
    // set the size and location of the authors
    authors.setBounds(240, 460, 500, 300);
    authors.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
    authors.setForeground(Color.WHITE);

    // set the action for the game button
    gameButton.addActionListener(e -> {
      // play sound
      playSoundEffect();
      // remove the buttons, the title and paint the game
      remove(gameButton);
      remove(howButton);
      remove(exitButton);
      remove(title);
      remove(wIcon);
      remove(authors);
      // focus the window
      requestFocusInWindow();
      // initialize the game, paint it, and add the listeners
      game = new Game(Main.this, g);
      game.paint();
      game.addListeners();
    });

    // set the action for the how to play button
    howButton.addActionListener(e -> {
      // play sound
      playSoundEffect();
      // remove the buttons and the title
      remove(gameButton);
      remove(howButton);
      remove(exitButton);
      remove(title);
      remove(wIcon);
      remove(authors);
      // dirty method to get frame to update
      // pack(); can be used, however that makes the transition very obvious
      setSize(WIDTH, HEIGHT - 1);
      setSize(WIDTH, HEIGHT);
      // add the back button
      add(backButton);
      // display the how to play page
      how = new How();
      add(how);
    });

    // set the action for the back button
    backButton.addActionListener(e -> {
      // play sound
      playSoundEffect();
      // remove the back button and the how to play page
      remove(backButton);
      remove(how);
      // repaint the frame back to the main menu
      repaint();
      // add the buttons back
      add(gameButton);
      add(howButton);
      add(exitButton);
      add(title);
      add(wIcon);
      add(authors);
    });

    // set the action for the exit button
    exitButton.addActionListener(e -> {
      // play sound
      playSoundEffect();
      System.exit(0);
    });

    // add the buttons to the window
    startButton.addActionListener(e -> {
      // play sound
      playSoundEffect();
      add(gameButton);
      add(howButton);
      add(exitButton);
      remove(startButton);
      // dirty method to get frame to update
      // pack(); can be used, however that makes the transition very obvious
      setSize(WIDTH, HEIGHT - 1);
      setSize(WIDTH, HEIGHT);
    });

    if (is_user) {
      add(startButton);
    } else {
      add(gameButton);
      add(howButton);
      add(exitButton);
    }

    add(authors);
    add(title);
    add(wIcon);

    pack();
    setSize(WIDTH, HEIGHT - 1);
  }

  /**
   * Plays a sound when a button is clicked
   *
   * @param N/A
   * @return N/A
   */
  static void playSoundEffect() {
    File file = new File("Assets/mixkit-video-game-retro-click-237.wav");
    try {
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
      Clip clip = AudioSystem.getClip();
      clip.open(audioStream);
      clip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {

    try {
      File file = new File("Assets/The-Creeping-Blob_Looping.wav");
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
      Clip clip = AudioSystem.getClip();
      clip.open(audioStream);
      clip.loop(Clip.LOOP_CONTINUOUSLY);
    } catch (Exception e) {
      e.printStackTrace();
    }

    EventQueue.invokeLater(() -> {
      try {
        new Main(true);
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }
}
