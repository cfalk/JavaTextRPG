import java.util.Vector;

public abstract class Creature
{
  static boolean DEBUG = true;
  public static void main(String[] args) {
    if (DEBUG) {
      Goblin gob = new Goblin();
      Goblin gob2 = new Goblin();
      System.out.println(gob.getHP());
      System.out.println(gob2.getHP());
      System.out.println(gob2.getInventory());
    }
  }

  protected int hp;
  protected int getHP() {
    return hp;
  }

  protected Vector<Item> inventory = new Vector<Item>();
  protected Vector<Item> getInventory() {
    return inventory;
  }
}

class Goblin extends Creature
{

  Goblin() {
    hp = Dice.d20();
    int inventoryRoll = Dice.d100();

    if (inventoryRoll>20) inventory.add( new HealthPotion() );
    if (inventoryRoll>40) inventory.add( new HealthPotion() );
    if (inventoryRoll>60) inventory.add( new Sword() );
  }

}
