import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;

public class Anagrams {
 public static void main(String[] args) {
  Console myConsole = System.console();
  System.out.println("Enter a word:");
  String[] stringUserWord = myConsole.readLine().split(" ");

  String[] charData;

  ArrayList al = new ArrayList();
  bubbleSort(stringUserWord);

  charData = new String[stringUserWord[0].length()];

  for (int i = 0; i < stringUserWord[0].length(); i++) {
   charData[i] = Character.toString(stringUserWord[0].charAt(i));
  }

  int counter = 0;

  for (int i = 0; i < stringUserWord.length; i++) {
   if (stringUserWord[i].length() == charData.length) {
    // if same length go through the loop to find letter
    for (int j = 0; j < charData.length; j++) {
     if (stringUserWord[i].indexOf(charData[j]) != -1) {
      if (charData.length - 1 == j && j == stringUserWord[i].length() - 1) {
       al.add(stringUserWord[i]);
      }
     }
    }
   } else {
    System.out.println("Contents for Anagrams: " + al);
    charData = new String[stringUserWord[i].length()];
    // not same letter reset the charData using loop
    for (int k = 0; k < stringUserWord[i].length(); k++) {
     charData[k] = Character.toString(stringUserWord[i].charAt(k));
    }
    for (int k = al.size() - 1; k > -1; k--) {
     al.remove(k);
    }
    al.add(stringUserWord[i]);
   }
  }

  System.out.println("Contents for Anagrams: " + al);
 }

 // Mutates the original array
 public static void bubbleSort(String[] arr) {
  boolean swapped = false;
  do {
   swapped = false;
   for (int i = 0; i < arr.length - 1; i += 1) {
    if (arr[i].length() > arr[i + 1].length()) {
     swap(arr, i, i + 1);
     swapped = true;
    }
   }
  } while (swapped);
 }

 // Mutates the original array
 public static void swap(String[] arr, int index0, int index1) {
  String temp = arr[index0];
  arr[index0] = arr[index1];
  arr[index1] = temp;
 }
}
