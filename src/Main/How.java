package Main;

import java.awt.*;
import javax.swing.*;

public class How extends JPanel {

  How() {
    // set the bounds and how to play
    setBounds(100, 0, 500, 500);
    setBackground(Color.CYAN);
    // title text
    JLabel title = new JLabel("How To Play");
    title.setForeground(Color.BLACK);
    // set the font and the size
    title.setFont(new Font("Times New Roman", Font.PLAIN, 50));
    // add the text
    add(title);
    // Instructions
    JLabel text = new JLabel(
        "<html>- Arrow keys to move<br>- Avoid spikes and lava<br>- Get to the portal to reach the next level");
    // set the text colour
    text.setForeground(Color.BLACK);
    // set the font and the size
    text.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    // add the text
    add(text);
  }
}
