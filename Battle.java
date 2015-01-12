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

  public void round() {
    while (true) {
      Creature[] participants = allInvolved();

      for (Creature participant : participants) {

        if (participant instanceof Player) {

          printHUD();

          Creature[] monsters = getLivingMonsters();
          String question = "Which would you like to attack?";
          int choice = Input.getIntInRange(1, monsters.length+1, question);

          Creature selected = monsters[choice-1];
          String outcome = player.attack(selected);

          System.out.print("Attacking... ");
          delay(500);

          System.out.println(outcome + "!\n");
          delay(750);

        } else {

          // TODO: If monster attacks...

        }

      }

      if (getLivingMonsters().length==0 || !player.isAlive()) {
        active = false;
        break;
      }
    }
  }


  public void printHUD() {

    // Print your health.
    System.out.println("You: " +  player.status());

    // Print the health of the monsters.
    Creature[] monsters = getLivingMonsters();
    for (int i=0; i < monsters.length; i++) {
      Creature monster = monsters[i];
      String label = "" + (i+1) + ".) ";
      System.out.println(label + monster.name + " " +  monster.status());
    }

  }


  public void printEncounter() {
    System.out.println("Oh no, some goblins appeared!");
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
