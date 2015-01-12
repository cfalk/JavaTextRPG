class Player extends Creature
{
  private String name;
  private String race;

  public Player() {
    randomizeStats();
    name = Input.getInput("What's your name?");
    String race = Input.getInput("What race are you? (human)");

    // TODO: Expand to include more races/etc.
    setRace(race);
  }

  private void randomizeStats() {
    strength=Dice.charStatRoll();
    constitution=Dice.charStatRoll();
    dexterity=Dice.charStatRoll();
    wisdom=Dice.charStatRoll();
    intelligence=Dice.charStatRoll();
    charisma=Dice.charStatRoll();
  }

  private void setRace(String r){
    //TODO: Add stat-modifications for different races.
    race = r;
  }

}
