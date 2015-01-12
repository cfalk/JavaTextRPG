import java.util.Scanner;
import java.util.InputMismatchException;

public class Input
{
  public static void main(String[] args) {
    getInput("Enter anything!");
    getInt("Enter an integer!");
    getIntInRange(5,7,"Enter an integer in [5,7).");
  }

  public static int getInt(String question) {
    System.out.println(question);
    return getInt();
  }

  public static int getInt() {
    Scanner keyboard = new Scanner(System.in);
    while (true) {

      try {
        System.out.print(">>> ");
        return keyboard.nextInt();
      }

      catch (InputMismatchException e) {
        keyboard.next(); // Clear the invalid answer.
      }

    }
  }


  public static int getIntInRange(int min, int max, String question) {
    System.out.println(question);
    return getIntInRange(min, max);
  }


  public static int getIntInRange(int min, int max) {
    int result;
    do {
      result = getInt();
    } while (!(min <= result && result < max));
    return result;
  }


  public static String getInput(String question){
    System.out.println(question);
    return getInput();
  }


  public static String getInput() {
    Scanner keyboard = new Scanner(System.in);
    String raw;
    while (true) {
      System.out.print(">>> ");
      raw = keyboard.nextLine();
      if (raw.length()>0) break;
    }
    System.out.println();
    return raw;
  }

}
