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
    System.out.println( name + " the " + race );
    System.out.println( "HP: " + status() );
    System.out.println( "Strength: " + getModifier("strength") );
    System.out.println( "Constitution: " + getModifier("constitution") );
    System.out.println( "Dexterity: " + getModifier("dexterity") );
    System.out.println( "Wisdom: " + getModifier("wisdom") );
    System.out.println( "Intelligence: " + getModifier("intelligence") );
    System.out.println( "Charisma: " + getModifier("charisma") );
    System.out.println();
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
