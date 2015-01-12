import java.util.Arrays;

public class Map
{
  private static int[] currentPos = new int[] {0, 0};

  public static int[] move() {
    // Variable Setup
    String request = "";

    while (true) {
      request = Input.getInput("Travel?... (n/s/e/w)").toLowerCase();

      if (request.matches("quit|q")) {
        return new int[]{-1,-1};

      } else if (request.matches("[nsweNSWE]")) {
        if (checkNextPosition(request)) {
          currentPos = getNextPosition(request);
          return currentPos;
        } else {
          System.out.println("Woops! Can't go that way...");
        }

      } else {
        System.out.println("Not a valid direction...");
      }
    }
  }

  public static boolean checkNextPosition(String dir) {
    int[] newPos = getNextPosition(dir);
    return (! Arrays.equals(newPos, quitPos()) );
  }

  public static int[] quitPos() {
    return new int[] {-1, -1};
  }

  public static int[] getNextPosition(String dir){
    int[] newPos = new int[currentPos.length];
    System.arraycopy(currentPos, 0, newPos, 0, currentPos.length);
    String key = currentPos[0]+","+currentPos[1];

    switch (key) {
      default:
        if ((currentPos[0]==0 && dir.equals("w")) ||
            (currentPos[1]==0 && dir.equals("s"))) {
          return quitPos();
        }

        if (dir.equals("e")) newPos[0]++;
        else if (dir.equals("w")) newPos[0]--;
        else if (dir.equals("n")) newPos[1]++;
        else if (dir.equals("s")) newPos[1]--;
    }

    return newPos;
  }


}
