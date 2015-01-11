import java.util.Scanner;

public class Main
{
  public static void main(String[] args){
    System.out.println("Welcome, adventurer!");

    Player player = buildCharacter();

    /*TODO: Implement the rest of the game mechanics.
    while(true){
      String raw = getInput();
      if (raw.equals("quit")) break;
    }
    */

    System.out.println("Quitting!");
  }

  public static String getInput(String question){
    System.out.println(question);
    return getInput();
  }

  public static String getInput(){
    Scanner keyboard = new Scanner(System.in);
    String raw;
    while (true) {
      System.out.print(">>> ");
      raw = keyboard.nextLine();
      if (raw.length()>1) break;
    }
    return raw;
  }

  public static Player buildCharacter(){
    Player player = new Player();
    player.name = getInput("What's your name?");
    String race = getInput("What race are you? (human)");
    player.setRace(race);
    return player;
  }
}
