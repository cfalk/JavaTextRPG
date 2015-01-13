import java.util.Arrays;

public class Battle
{
  private Player player;
  private Creature[] monsters;
  public boolean active = true;

  public Battle(Player player, Creature[] monsters)
  {

    this.player = player;
    this.monsters = monsters;

  }

  public Creature[] allInvolved() {

    Creature[] living = getLivingMonsters();
    Creature[] involved = new Creature[living.length+1];
    involved[0] = player;

    for (int i=0; i<living.length; i++)
      involved[i+1] = living[i];

    Arrays.sort(involved, new InitiativeComparator());

    return involved;
  }

  private void delay(int ms) {
    // Delay execution for a second for effect...
    try {
      Thread.sleep(ms);
    } catch(InterruptedException e) { }
  }


  public int calculateExperience() {
    return monsters.length;
  }


  public void round() {
    printHUD();
    Creature[] participants = allInvolved();

    for (Creature participant : participants) {
      if (!player.isAlive()) break;

      if (participant instanceof Player) {


        Creature[] monsters = getLivingMonsters();
        String question = "Which would you like to attack?";
        int choice = Input.getIntInRange(1, monsters.length+1, question);

        Creature selected = monsters[choice-1];
        String outcome = player.attack(selected);

        Main.print("Attacking... ");
        delay(500);

        Main.print(outcome + "!\n");
        delay(750);

      } else {

        String outcome = participant.attack(player);

        Main.print(participant.name +" attacks you... ");
        delay(500);

        Main.print(outcome + "!\n");
        delay(750);

      }

    }

    if (getLivingMonsters().length==0 || !player.isAlive()) {

      active = false;

    } else {

      Input.enterToContinue();
    }

  }


  public void printHUD() {

    // Print your health.
    Main.print("You: " +  player.status()+"\n");

    // Print the health of the monsters.
    Creature[] monsters = getLivingMonsters();
    for (int i=0; i < monsters.length; i++) {
      Creature monster = monsters[i];
      String label = "" + (i+1) + ".) ";
      Main.print(label + monster.name + " " +  monster.status()+"\n");
    }

  }


  public void printEncounter() {
    Main.print("Oh no, some goblins appeared!\n");
  }


  private Creature[] getLivingMonsters() {

    int living = 0;
    for (Creature monster: monsters) {
      if (monster.isAlive())
         living++;
    }

    Creature[] livingMonsters = new Creature[living];
    for (Creature monster: monsters) {
      if (monster.isAlive()) {
        living -= 1;
        livingMonsters[living] = monster;
      }
    }

    return livingMonsters;

  }

}
