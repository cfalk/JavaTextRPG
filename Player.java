class Player extends Creature
{
  protected String name;
  protected String race;

  public Player() {
    randomizeStats();
  }

  public void randomizeStats() {
    strength=Dice.charStatRoll();
    constitution=Dice.charStatRoll();
    dexterity=Dice.charStatRoll();
    wisdom=Dice.charStatRoll();
    intelligence=Dice.charStatRoll();
    charisma=Dice.charStatRoll();
  }

  public void setRace(String r){
    //TODO: Add stat-modifications for different races.
    race = r;
  }

}
