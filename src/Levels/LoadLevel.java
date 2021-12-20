package Levels;

import java.io.*;

public class LoadLevel {

  /**
   * reads a text file to make the code cleaner
   * 
   * @param N/A
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
   * @param N/A
   * @return the files as an array of strings
   */
  public String[][] getLevels() {
    String[] files;
    File f = new File("Levels/");
    files = f.list();
    String[][] levels = new String[10][800];
    for (int i = 0; i < 10; i++) {
      if (files[i].equals("Levels/10.txt")) {
        levels[9] = readFile("Levels/10.txt").split(" ");
        continue;
      }
      levels[i] = readFile("Levels/" + files[i]).split(" ");
    }
    return levels;
  }
}