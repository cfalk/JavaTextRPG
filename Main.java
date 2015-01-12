import java.util.Scanner;
import java.util.Arrays;

public class Main
{

  public static void main(String[] args)
  {

    System.out.println("Welcome, adventurer!");

    Player player = new Player();
    Map map = new Map();

    int[] pos = new int[] {0,0};

    while(true){
      pos = map.move();

      if (map.quit) {
        System.out.println("Quitting!");
        break;

      } else {

        System.out.println("Now at: "+pos[0]+", "+pos[1]);
        Map.enter(player);

      }
    }
  }


}
