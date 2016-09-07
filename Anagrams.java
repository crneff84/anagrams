import java.io.Console;
import java.util.ArrayList;

public class Anagrams {
  public static void main(String[] args) {
    Console myConsole = System.console();
    System.out.println("Enter a words:");
    String[] stringUserWord = myConsole.readLine().split(" ");

    String[] charData;

    ArrayList al = new ArrayList();

    charData = new String[stringUserWord[0].length()];

    for (int i = 0; i < stringUserWord[0].length(); i++) {
      charData[i] = Character.toString(stringUserWord[0].charAt(i));
    }

    al.add(stringUserWord[0]);
    int counter = 0;

    for (int i = 1; i < stringUserWord.length; i++) {
      if (stringUserWord[i].length() == charData.length) {
        // if same length go though the loop to find lettle
        for (int j = 0; j < charData.length; j++) {
          if (stringUserWord[i].indexOf(charData[j]) != -1) {
            if (charData.length - 1 == j) {
              al.add(stringUserWord[i]);
            }
          } else {
            System.out.println("Contents for Anagrams: " + al);
            // not same letter reset the chaData using loop.
            for (int k = 0; k < stringUserWord[i].length(); k++) {
              charData[k] = Character.toString(stringUserWord[i].charAt(k));
            }
            for (int k = al.size() - 1; k > -1; k--) {
              al.remove(k);
            }
            al.add(stringUserWord[i]);
            break;
          }
        }
      } else {
        charData = new String[stringUserWord[i].length()];
        for (int k = 0; k < stringUserWord[i].length(); k++) {
          charData[k] = Character.toString(stringUserWord[i].charAt(k));
        }
        System.out.println("Contents for Anagrams: " + al);
        for (int k = al.size() - 1; k > -1; k--) {
          al.remove(k);
        }
        al.add(stringUserWord[i]);
      }
    }

    System.out.println("Contents for Anagrams: " + al);

  }
}
