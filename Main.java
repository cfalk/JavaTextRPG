import java.util.Scanner;
import java.util.Arrays;

public class Main
{

  public static void print(String message) {
    System.out.print(message);
  }

  public static void main(String[] args)
  {

    Main.print("Welcome, adventurer!\n");

    Player player = new Player();
    Map map = new Map();

    int[] pos = new int[] {0,0};

    while(!map.quit){

      pos = map.move();
      Main.print("Now at: "+pos[0]+", "+pos[1]+"\n");
      Map.enter(player);

    }

  }


}
