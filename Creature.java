import java.util.Vector;
import java.util.Comparator;

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

  protected int level=1;
  protected int strength=10;
  protected int constitution=10;
  protected int dexterity=10;
  protected int wisdom=10;
  protected int intelligence=10;
  protected int charisma=10;

  protected int baseInitiative = 0;

  protected int getEquipmentBonus(String mod){
    int bonus = 0;
    for (Item item : inventory) {
      if (item.equipped && item.bonuses.containsKey(mod)){
        bonus += item.bonuses.get(mod);
      }
    }
    return bonus;
  }

  protected int getModifier(String mod){
    int raw;
    switch (mod) {
      case "strength":
        raw = strength;
        break;
      default:
        raw = 0;
        break;
    }

    // Calculate the modifier from the overall score.
    raw += getEquipmentBonus(mod)-10;
    double rounded = Math.floor( (double)raw /2);
    return (int) rounded;
  }

  public int getInitiative() {
    return baseInitiative + getModifier("dexterity");
  }

  protected int maxHp;
  protected int hp;
  public int getHP() {
    return hp;
  }

  public boolean isAlive() {
    return hp>0;
  }

  protected Vector<Item> inventory = new Vector<Item>();
  protected Vector<Item> getInventory() {
    return inventory;
  }
}

class InitiativeComparator implements Comparator<Creature>
{

  @Override
  public int compare(Creature a, Creature b) {
    return a.getInitiative() - b.getInitiative();
  }

}

class Goblin extends Creature
{

  Goblin() {
    maxHp = Dice.d(20);
    hp = maxHp;

    int inventoryRoll = Dice.d(100);
    if (inventoryRoll>60) inventory.add( new Sword(true) );
  }

}
