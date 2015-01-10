public abstract class Item
{
  static boolean DEBUG = false;
  public static void main(String[] args){

  }

  protected int durability;
  protected int weight = 0;
  protected boolean equipped = false;
}


class Weapon extends Item
{
  protected int damageBonus;
}


class Sword extends Weapon
{
  Sword() {
    weight=4;
    damageBonus = 3;
    durability = Dice.d10()*7+30;
  }
}

