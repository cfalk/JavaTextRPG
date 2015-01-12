import java.util.Arrays;

public class Dice
{
  static boolean DEBUG = false;

  public static void main(String[] args)
  {
    if (DEBUG)
    {
      System.out.println("D20 rolled... "+d(20));
    }
  }

  public static int d(int num)
  {
     double temp = Math.random()*num;
     return (int) temp+1;
  }

  public static int largestXofY(int die, int x, int y) {
    // Roll a D(die) Y times and select the largest X of those rolls.
    int numRolls = y;

    int[] rolls = new int[numRolls];
    for (int i=0; i<numRolls; i++)
        rolls[i] = Dice.d(die);

    // Sum the 4 largest.
    int sum = 0;
    Arrays.sort(rolls);
    for (int i=y-x; i<rolls.length; i++)
        sum += rolls[i];

    return sum;
  }

  public static int charStatRoll(){
    return largestXofY(6, 4, 5);
  }
}
