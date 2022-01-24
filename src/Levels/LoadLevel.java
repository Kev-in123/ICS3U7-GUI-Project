package Levels;

import java.io.*;

/**
 * @author Kevin Cai
 * 
 * last updated: 2022-01-23
 * 
 * LoadLevel class: loads the levels into cache
 */
public class LoadLevel {

  /**
   * reads a text file to make the code cleaner
   * 
   * @param file_name - the file name
   * @return the file as a string
   */
  private static String readFile(String file_name) {
    String level = "";
    String line;
    try {
      FileReader file = new FileReader(file_name);
      BufferedReader in = new BufferedReader(file);
      line = in.readLine();
      while (line != null) {
        level += line;
        line = in.readLine();
      }
      in.close();
    } catch (IOException e) {
      System.out.println("Couldn't read the file");
    }
    return level;
  }

  /**
   * returns the layout of all the levels in an array
   * 
   * @return the files as an array of strings
   */
  public String[][] getLevels() {
    String[] files;
    File f = new File("Levels/");
    files = f.list();
    String[][] levels = new String[10][400];
    for (int i = 0; i < 10; i++) {
      levels[i] = readFile("Levels/" + files[i]).split(" ");
    }
    return levels;
  }

}
