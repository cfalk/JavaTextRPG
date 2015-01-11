import java.util.Scanner;
import java.util.Arrays;

public class Main
{
  public static void main(String[] args){
    System.out.println("Welcome, adventurer!");

    Player player = buildCharacter();
    int[] pos = new int[] {0,0};

    while(true){
      pos = mapMovement(pos);
      // Let {-1, -1} be the signal to end the game.
      if (pos[0]==-1 && pos[1]==-1) {
        break;
      } else {
        System.out.println("Now at: "+pos[0]+", "+pos[1]);
      }
    }

    System.out.println("Quitting!");
  }


  public static int[] mapMovement(int[] pos) {
    // Variable Setup
    String request = "";

    while (true) {
      request = getInput("Travel?... (n/s/e/w)").toLowerCase();

      if (request.matches("quit|q")) {
        return new int[]{-1,-1};

      } else if (request.matches("[nsweNSWE]")) {
        if (checkNextPosition(pos, request)) {
          return getNextPosition(pos, request);
        } else {
          System.out.println("Woops! Can't go that way...");
        }

      } else {
        System.out.println("Not a valid direction...");
      }
    }
  }

  public static boolean checkNextPosition(int[] pos, String dir) {
    int[] newPos = getNextPosition(pos, dir);
    int[] quitPos = new int[] {-1, -1};
    return (! Arrays.equals(newPos, quitPos) );
  }

  public static int[] getNextPosition(int[] pos, String dir){
    int[] newPos = new int[pos.length];
    System.arraycopy(pos, 0, newPos, 0, pos.length);
    String key = pos[0]+","+pos[1];

    switch (key) {
      default:
        if ((pos[0]==0 && dir.equals("w")) || (pos[1]==0 && dir.equals("s"))) {
          return new int[] {-1, -1};
        }

        if (dir.equals("e")) newPos[0]++;
        else if (dir.equals("w")) newPos[0]--;
        else if (dir.equals("n")) newPos[1]++;
        else if (dir.equals("s")) newPos[1]--;
    }

    return newPos;
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

  public static Player buildCharacter(){
    Player player = new Player();
    player.name = getInput("What's your name?");
    String race = getInput("What race are you? (human)");
    // TODO: Expand to include more races/etc.
    player.setRace(race);
    return player;
  }
}
