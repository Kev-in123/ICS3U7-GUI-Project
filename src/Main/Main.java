package Main;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;

import Game.*;

public class Main extends JFrame {
	// declare the game page and the how to play page
	  Game game;
	  How how;
	  // declare the frame width and height
	  public static final int WIDTH = 720;
	  public static final int HEIGHT = 720;

	  // constructor
	public Main() throws IOException {
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

	    // initialize the graphics
	    Graphics g = getGraphics();

	    // add the game button
	    final JButton gameButton = new JButton("Game");
	    // add a how to play button
	    final JButton howButton = new JButton("How to Play");
	    // add an exit button
	    final JButton exitButton = new JButton("Exit");
	    // add a back button
	    final JButton backButton = new JButton("Back");
	    // add a title
	    final JLabel title = new JLabel("Lost");
	    
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
	    
    	    // set the action for the game button
    	    gameButton.addActionListener(e -> {
                // remove the buttons, the title and paint the game
                remove(gameButton);
                remove(howButton);
                remove(exitButton);
                remove(title);
                remove(wIcon);
                // focus the window
                requestFocusInWindow();
                // initialize the game, paint it, and add the listeners
                game = new Game(Main.this, g);
                game.paint();
                game.addListeners();
            });

            // set the action for the how to play button
            howButton.addActionListener(e -> {
                // remove the buttons and the title
                remove(gameButton);
                remove(howButton);
                remove(exitButton);
                remove(title);
                remove(wIcon);
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
            backButton.addActionListener(e-> {
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
            });

            // set the action for the exit button
            exitButton.addActionListener(e -> System.exit(0));
        
		  
	    // add the buttons to the window
	    add(gameButton);
	    add(howButton);
	    add(exitButton);
	    add(title);
	    add(wIcon);

	}

	public static void main(final String[] args) {
	    // event queue to handle the window
	    EventQueue.invokeLater(() -> {
            try {
                new Main();
            } catch (IOException e) {
                e.printStackTrace();
            }
      	});
	}
}
