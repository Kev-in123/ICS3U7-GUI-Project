package Main;

import javax.swing.*;
import java.awt.event.*;

public class How extends JPanel {

  How() {
    // set the window size
    setSize(WIDTH, HEIGHT);
    // set the layout
    setLayout(null);
    final JLabel label = new JLabel(
        "How to Play\n"
            + "Arrow keys to move\n"
            + "'p' to pause\n"
            + "Avoid all spikes and lava"
            + "Get to the portal");
    add(label);
    // add a back button to go back to the main menu
    final JButton backButton = new JButton("Back");
    backButton.setBounds(100, 300, 105, 30);
    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        remove(label);
        remove(backButton);
        
        new Main();
      }
    });
    add(backButton);

  }
}
