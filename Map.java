import java.util.Arrays;

public class Map
{
  private static int[] currentPos = new int[] {0, 0};
  public static boolean quit = false;

  public static int[] move() {
    // Variable Setup
    String request = "";

    while (true) {
      request = Input.getInput("Travel?... (n/s/e/w)").toLowerCase();

      if (request.matches("quit|q")) {
        quit = true;
        return currentPos;

      } else if (request.matches("[nsweNSWE]")) {
        if (checkNextPosition(request)) {
          currentPos = getNextPosition(request);
          return currentPos;
        } else {
          Main.print("Woops! Can't go that way...\n");
        }

      } else {
        Main.print("Not a valid direction...\n");
      }
    }
  }

  private static String key() {
    return currentPos[0]+","+currentPos[1];
  }

  public static boolean checkForBattle() {
    int likelihood;

    switch (key()) {
      default:
        likelihood = 25;
    }

    return Dice.d(100)<likelihood;

  }

  private static Creature[] getMonsters() {
    int numMonsters;

    switch (key()) {
      default:
        numMonsters = Dice.d(2);
    }

    Creature[] monsters = new Creature[numMonsters];
    for (int i=0; i<numMonsters; i++) monsters[i] = new Goblin();

    return monsters;
  }

  public static void enter(Player player) {
    if (checkForBattle()) {
      Battle battle = new Battle(player, getMonsters());
      battle.printEncounter();

      while (battle.active) {
        battle.round();
      }

      if (player.isAlive()) {
        int exp = battle.calculateExperience();
        Main.print("Victory! You gained " + exp + " experience.\n");
      } else {
        Main.print("You died! Game over...\n");
        quit = true;
      }

      Input.enterToContinue();

    }
  }

  public static boolean checkNextPosition(String dir) {
    // Returns `true` if the next position is valid -- else `false`.

    if ((currentPos[0]==0 && dir.equals("w")) ||

        (currentPos[1]==0 && dir.equals("s"))) {
      return false;

    } else {

      return true;

    }
  }

  public static int[] getNextPosition(String dir) {
    int[] newPos = new int[currentPos.length];
    System.arraycopy(currentPos, 0, newPos, 0, currentPos.length);

    switch (key()) {
      default:
        if (dir.equals("e")) newPos[0]++;
        else if (dir.equals("w")) newPos[0]--;
        else if (dir.equals("n")) newPos[1]++;
        else if (dir.equals("s")) newPos[1]--;
    }

    return newPos;
  }


}
