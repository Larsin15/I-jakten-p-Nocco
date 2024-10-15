import java.util.Scanner;

public class Npc implements Interactable, Describable {
    private String name;
    private String description;
    private int health;
    private int damage = 20;
    private Scanner scan = new Scanner(System.in);


    public Npc(String name, String description) {
        this.name = name;
        this.description = description;
        this.health = 75;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void changeNpcHealth(int amount) {
        this.name += amount;
        System.out.println(name + "s hälsa är nu " + health);
    }

    public void combat(Player player) {
        while (health <= 0) {
            System.out.println("Tryck enter för att starta fighten: ");
            scan.nextLine();

            while(health > 0) {
                player.changePlayerHealth(-damage);
                changeNpcHealth(-player.getDamage());
            }
            System.out.println("Du besegrade " + name + "!");
        }
    }


    @Override
    public void interact(Player player) {
        String choice;

        if(name.equalsIgnoreCase("goblin")) {
            System.out.println("Ett " + name + " attackerar dig!" + description + "\nDu har inget annat val än att slåss för ditt liv!");
        } else if (name.equalsIgnoreCase("troll")) {
            System.out.println(name + " undrar vad du vill?");
            System.out.println("1. Be om en gåta");
            System.out.println("2. Attackera trollet");

            choice = scan.nextLine();
            if(choice.equals("1")) {
                System.out.println("GÅTA");
            } else if(choice.equals("2")) {
                combat(player);
            }
        }

    }

    @Override
    public String getDescription() {
        return "Ett " + name + " lurar här. " + description;

    }






    //Kommer lägga till: HP(hälsa), inventory(drop)
}