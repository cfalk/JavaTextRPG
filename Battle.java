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

  public void round() {

    Creature[] participants = allInvolved();

    //TODO: Actually do battle.

    if (getLivingMonsters().length==0)
       active = false;

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
