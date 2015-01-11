import java.util.Arrays;

public class Dice
{
  static boolean DEBUG = false;

  public static void main(String[] args)
  {
    if (DEBUG)
    {
      System.out.println(d20());
    }
  }

  private static int d(int num)
  {
     double temp = Math.random()*num;
     return (int) temp+1;
  }

  public static int d100() { return d(100); }
  public static int d20() { return d(20); }
  public static int d12() { return d(12); }
  public static int d10() { return d(10); }
  public static int d8() { return d(8); }
  public static int d6() { return d(6); }
  public static int d4() { return d(4); }

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
