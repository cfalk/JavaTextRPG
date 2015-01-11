import java.util.HashMap;
import java.util.Map;

public abstract class Item
{
  static boolean DEBUG = false;
  public static void main(String[] args){

  }

  protected int durability;
  protected int weight = 0;
  protected boolean equipped = false;
  protected Map<String, Integer> bonuses = new HashMap<String, Integer>();
}


class Weapon extends Item { }
class Armor extends Item { }
class Consumable extends Item { }


class Sword extends Weapon
{
  Sword() {
    weight=4;
    bonuses.put("damage", 3);
    durability = Dice.d10()*7+30;
  }
  Sword(boolean autoequipped) {
    this();
    equipped = autoequipped;
  }
}

