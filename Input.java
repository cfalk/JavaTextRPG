import java.util.Scanner;

public class Input
{

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
