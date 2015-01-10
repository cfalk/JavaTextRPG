public abstract class Item
{
  protected int durability;
  protected int weight = 0;
  protected boolean equippable = false;
}


class Weapon extends Item
{
  protected int damageBonus;
  protected int attackSpeedBonus;

  Weapon() {
    equippable = true;
  }
}


class Sword extends Weapon
{
  Sword() {
    weight=4;
    damageBonus = 3;
    attackSpeedBonus = 2;
    durability = Dice.d10()*7+30;
  }
}

