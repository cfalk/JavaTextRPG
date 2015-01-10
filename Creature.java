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

  protected int strength=10;
  protected int constitution=10;
  protected int dexterity=10;
  protected int wisdom=10;
  protected int intelligence=10;
  protected int charisma=10;

  protected int maxHp;
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
    maxHp = Dice.d20();
    hp = maxHp;
    int inventoryRoll = Dice.d100();

    //if (inventoryRoll>20) inventory.add( new HealthPotion() );
    //if (inventoryRoll>40) inventory.add( new HealthPotion() );
    if (inventoryRoll>60) inventory.add( new Sword() );
  }

}
