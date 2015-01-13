import java.util.Vector;
import java.util.Comparator;

public abstract class Creature
{

  public String name;
  protected int maxHp;
  protected int hp;
  protected int level = 1;

  protected int strength=10;
  protected int constitution=10;
  protected int dexterity=10;
  protected int wisdom=10;
  protected int intelligence=10;
  protected int charisma=10;

  protected int baseInitiative = 0;
  protected int baseAttack = 0;
  protected int baseAc = 10;

  protected Vector<Item> inventory = new Vector<Item>();


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
      case "constitution":
        raw = constitution;
        break;
      case "intelligence":
        raw = intelligence;
        break;
      case "dexterity":
        raw = dexterity;
        break;
      case "wisdom":
        raw = wisdom;
        break;
      case "charisma":
        raw = charisma;
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


  public int getHp() {
    return hp;
  }

  public int getAc() {
    return baseAc + getEquipmentBonus("ac") + getModifier("dexterity");
  }


  public String status() {
    int percent = (int) ((double)hp / maxHp * 100);
    return "" + hp + "/" + maxHp + " ("+percent+"%)";
  }


  public boolean isAlive() {
    return hp>0;
  }


  protected Vector<Item> getInventory() {
    return inventory;
  }


  protected int attackBonus() {
    return baseAttack + getEquipmentBonus("base attack") + getModifier("strength");
  }


  public int maxDamage() {
    int damage = getEquipmentBonus("damage");
    if (damage == 0) damage = 3; // Unarmed damage should be 2.

    return damage;
  }


  public String attack(Creature other) {

    int attackRoll = Dice.d(20)+ attackBonus();

    if (attackRoll >= other.getAc()){

      // Get the amount of damage to yield (must be at least 1).
      int damage = Dice.d(maxDamage()) + getModifier("strength");
      if (damage<=0) damage = 1;

      other.hp -= damage;

      return "" + damage + " damage";
    } else {
      return "miss";
    }

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
    name = "Goblin";

    int inventoryRoll = Dice.d(100);
    if (inventoryRoll>60) inventory.add( new Sword(true) );
  }

}


