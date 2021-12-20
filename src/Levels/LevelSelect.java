package Levels;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Game.*;

public class LevelSelect {
  public void paint(Graphics g, JFrame f, Game game) {

    final JButton level1_button = new JButton("Level 1");
    final JButton level2_button = new JButton("Level 2");
    final JButton level3_button = new JButton("Level 3");
    final JButton level4_button = new JButton("Level 4");
    final JButton level5_button = new JButton("Level 5");
    final JButton level6_button = new JButton("Level 6");
    final JButton level7_button = new JButton("Level 7");
    final JButton level8_button = new JButton("Level 8");
    final JButton level9_button = new JButton("Level 9");
    final JButton level10_button = new JButton("Level 10");

    level1_button.setBounds(100, 100, 95, 30);
    level2_button.setBounds(200, 100, 95, 30);
    level3_button.setBounds(300, 100, 95, 30);
    level4_button.setBounds(400, 100, 95, 30);
    level5_button.setBounds(500, 100, 95, 30);
    level6_button.setBounds(100, 200, 95, 30);
    level7_button.setBounds(200, 200, 95, 30);
    level8_button.setBounds(300, 200, 95, 30);
    level9_button.setBounds(400, 200, 95, 30);
    level10_button.setBounds(500, 200, 95, 30);

    JButton[] buttons = { level1_button, level2_button, level3_button, level4_button, level5_button, level6_button,
        level7_button, level8_button, level9_button, level10_button, };
        
    addButtons(f, buttons);

    level1_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        game.paint();
      }
    });

    level2_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        game.paint();
      }
    });

    level3_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        game.paint();
      }
    });

    level4_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        game.paint();
      }
    });

    level5_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        game.paint();
      }
    });

    level6_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        game.paint();
      }
    });

    level7_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        game.paint();
      }
    });

    level8_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        game.paint();
      }
    });

    level9_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        game.paint();
      }
    });

    level10_button.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        game.paint();
      }
    });
  }

  public void removeButtons(Frame f, JButton[] buttons) {
    for (JButton b : buttons) {
      f.remove(b);
    }
  }

  public void addButtons(Frame f, JButton[] buttons) {
    for (JButton b : buttons) {
      f.add(b);
    }
  }

}
