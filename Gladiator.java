package gladiator_tanzo;


public class Gladiator {

    //instanant variable - declared outside
    //                     any method or contructor
    private String name;
    private double health;
    private int damage;
    private int defense;
    private int initiative;

    //constructor - used to create objects
    public Gladiator(String name, double health, int damage,
            int defense, int initiative) {

        setName(name);

        setHealth(health);

        setDamage(damage);
        setDefense(defense);
        setInitiative(initiative);
    }

    public String getName() {
        return this.name;
    }

    public double getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getInitiative() {
        return this.initiative;
    }

    public void setName(String newName) {
        if (newName.isEmpty()) {
            System.out.print("Name cannot be empty");
        } else {
            this.name = newName;
        }
    }

    public void setHealth(double newHealth) {
        if (newHealth <= 0) {
            System.out.println("Health cannot be less than"
                    + "or equal to 0");
        } else {
            this.health = newHealth;
        }
    }

    public void setDamage(int newDamage) {
        if (newDamage <= 0) {
            System.out.println("Damage cannot be less"
                    + "than or equal to 0");
        } else {
            this.damage = newDamage;
        }
    }

    public void setDefense(int newDefense) {
        if (newDefense >= 0) {
            this.defense = newDefense;
        } else {
            System.out.println("Defense cannot be"
                    + "less than 0");
        }

    }

    public void setInitiative(int newInitiative) {
        if (newInitiative >= 0) {
            this.initiative = newInitiative;
        } else {
            System.out.println("Initiative cannot be"
                    + "less than 0");
        }
    }

    public static void displayGladiatorStats(Gladiator glad) {
        System.out.println(",initiative:"
                + glad.getName()
                + ",health:" + glad.getHealth()
                + ",damage:" + glad.getDamage()
                + ",defense:" + glad.getDefense()
                + ",initiative" + glad.getInitiative());
    }

    public static Gladiator fight(Gladiator glad1,
            Gladiator glad2) {
        displayGladiatorStats(glad1);
        displayGladiatorStats(glad2);

        int round = 1;
        int turn
                = glad1.getInitiative() > glad2.getInitiative()
                ? 1 : 2;

        while (true) {
            if (turn == 1) {
                //glad 1 attactks
                glad2.health
                        -= glad1.damage
                        - (glad1.damage * (glad2.defense / 100.0));

                System.out.println("Round " + round + ": "
                        + glad1.getName() + " does "
                        + glad1.getDamage() + " damage,"
                        + glad2.getDefense() + " % of which "
                        + glad2.getName() + " ignores. "
                        + glad2.getName() + " has "
                        + glad2.getHealth() + " health left. ");
                turn = 2;
            } else {
                //glad 2 attactks
                glad1.health
                        -= glad2.damage
                        - (glad2.damage * (glad1.defense / 100.0));

                System.out.println("Round " + round + ": "
                        + glad2.getName() + " does "
                        + glad2.getDamage() + " damage,"
                        + glad1.getDefense() + " % of which "
                        + glad1.getName() + " ignores. "
                        + glad1.getName() + " has "
                        + glad1.getHealth() + " health left. ");
                turn = 1;
            }
            if (glad1.getHealth() <= 0) {
                return glad2;
            } else if (glad2.getHealth() <= 0) {
                return glad1;
            }
            round++;
        }
    }
}
