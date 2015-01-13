class Player extends Creature
{
  private String name;
  private String race;

  private int hitDie = 8;

  public Player() {
    name = Input.getInput("What's your name?");
    String race = Input.getInput("What race are you? (human)");

    setRace(race); // TODO: Expand to include more races/etc.
    randomizeStats();
    refresh();

    printStats();

  }

  private void refresh() {
    hp = maxHp;
  }


  public void printStats() {
    Main.print( name + " the " + race +"\n");
    Main.print( "HP: " + status() +"\n");
    Main.print( "Strength: " + getModifier("strength") +"\n");
    Main.print( "Constitution: " + getModifier("constitution") +"\n");
    Main.print( "Dexterity: " + getModifier("dexterity") +"\n");
    Main.print( "Wisdom: " + getModifier("wisdom") +"\n");
    Main.print( "Intelligence: " + getModifier("intelligence") +"\n");
    Main.print( "Charisma: " + getModifier("charisma") +"\n");

    Input.enterToContinue();
  }


  private void randomizeStats() {

    strength=Dice.charStatRoll();
    constitution=Dice.charStatRoll();
    dexterity=Dice.charStatRoll();
    wisdom=Dice.charStatRoll();
    intelligence=Dice.charStatRoll();
    charisma=Dice.charStatRoll();

    maxHp = hitDie + getModifier("constitution");

  }

  private void setRace(String r){
    //TODO: Add stat-modifications for different races.
    race = r;
  }

}
