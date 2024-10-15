import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Room forest = new Room("Skogen", "Du står i en mörk skog med höga träd.");
        Room cave = new Room("Grottan", "Inne i skogen ser du en klippväg med nåt glimmande i en skåra");
        Room glade = new Room("Gläntan", "Du står i en glänta. Framför dig ser du en igenväxt stig åt ett håll, åt andra är en bäck");
        Room redwood = new Room("Trädet", "Framför dig ser du ett massivt redwood träd som sträcker sig långt över molnen");
        Room thorn = new Room("Igenväxta stigen", "Rosenbuskar river upp din kropp");
        Room camp = new Room("Eldstaden", "Du värmer upp dig");
        Room cottage = new Room("Stugan", "På en stubbe stugan sitter ett litet troll som ger dig en varm blick");
        Room river = new Room("Bäcken", "Vid bäcken ser du en blodig väska och längre bort hör du en sprakande brasa.");
        Room doorEnding = new Room("Dörren", "Rötter täcker en gammal dörr i den finaste mahogny du nånsin skådat");


        Treasure gold = new Treasure("guldmynt", "Det glimmar vackert i ljuset.");

        Object bloodyPouch = new Object("blodiga väskan", "I väskan hittar du en NOCCO Limón del sol");
        Object knife = new Object("kniv", " en slank obsidiankniv som glimmar i mörkret. \n Den är snabb och tyst, because you are worth it - Maybeline. \n Egenskaper:" + " Skada + 15");
        Object nocco = new Object("nocco", "Den indragande loggan med sockerfritt 180mg koffein får dig att tänka på hälsa i dess renaste form. \n Med en doft av tonårsångest ger den förnyelse till dem som har lidit i skolbänken eller strid. \n Egenskaper:\n Effekt: Återställer 30 hälsa.");
        Object key = new Object("nyckel", "En enkel nyckel i mässing");
        //Object trollQuiz = new Object("")


        Npc goblin = new Npc("goblin", "Den har mord i blicken.");
        Npc troll = new Npc("troll", "Trollet är en stor och stark varelse med gröna, skrovliga hud och långa klor. Det är både kraftfullt och klokt. \n Djupt inne i skogen förvarar det en magisk nyckel, skapad av stjärnljus. För att få nyckeln måste du besvara dess gåtor, som viskar genom natten.");


        forest.addInteractable("guldmynt", gold);
        camp.addInteractable("goblin", goblin);
        cave.addInteractable("skåra", knife);
        river.addInteractable("blodigpåse", bloodyPouch);

        Player player = new Player("Äventyrare");

        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        System.out.println("Välkommen till Äventyrsspelet!");

        player.moveTo(glade);

        while (playing) {
            System.out.println("\nVad vill du göra?");
            if (player.getCurrentRoom() == doorEnding) {
                System.out.println("1. Gå mot " + thorn.getName() + " men vägen ser snårig ut");
                System.out.println("2. Knacka på dörren");// vägvalet

                System.out.println("\nVad vill du göra?");
            } else if (player.getCurrentRoom() == river) {
                System.out.println(river.getDescription());
                System.out.println("1. Gå mot " + glade.getName()); // vägvalet
                System.out.println("2. Gå mot " + camp.getName());

                System.out.println("\nVad vill du göra?");
            } else if (player.getCurrentRoom() == cottage) {
                System.out.println(cottage.getDescription());
                System.out.println("1. Tala med " + troll.getName()); // vägvalet
                System.out.println("2. Gå mot " + camp.getName());
            }// vägvalet
            else if (player.getCurrentRoom() == camp) {
                System.out.println(camp.getDescription());
                System.out.println("1. Gå mot " + cottage.getName()); // vägvalet
                System.out.println("2. Gå mot " + river.getName()); // vägvalet
                System.out.println("3. Gå mot " + redwood.getName()); // vägvalet
            } else if (player.getCurrentRoom() == redwood) {
                System.out.println(redwood.getDescription());
                System.out.println("1. Gå mot" + thorn.getName() + " men vägen ser snårig ut"); // vägvalet
                System.out.println("2. Gå mot" + camp.getName()); // vägvalet
                System.out.println("3. Gå mot" + cave.getName());
            }// vägvalet
            else if (player.getCurrentRoom() == cave) {
                System.out.println(cave.getDescription());
                System.out.println("1. Gå till skåran");
                System.out.println("2. Gå mot" + glade.getName() + " men vägen ser snårig ut"); // vägvalet
                System.out.println("3. Gå mot" + redwood.getName()); // vägvalet
            } else if (player.getCurrentRoom() == glade) {
                System.out.println(glade.getDescription());
                System.out.println("1. Gå mot en av vägen "); // vägvalet
                //System.out.println("2. Gå mot" + river.getName());
            }
            System.out.println("2. Interagera med något");
            System.out.println("3. Avsluta spelet");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (player.getCurrentRoom() == glade) {
                        System.out.println("1 eller 2");
                        choice = scanner.nextLine();
                        if (choice.equalsIgnoreCase("1")) {
                            player.moveTo(cave);
                            player.changePlayerHealth(-10);
                        } else if (choice.equalsIgnoreCase("2")) {
                            player.moveTo(river);
                        }
                    } else if (player.getCurrentRoom() == cave) {
                        choice = scanner.nextLine();
                        if (choice.equalsIgnoreCase("1")) {
                            player.moveTo(redwood);
                        } else if (choice.equalsIgnoreCase("2")) {
                            player.moveTo(glade);
                        }
                    } else if (player.getCurrentRoom() == redwood) {
                        choice = scanner.nextLine();
                        if (choice.equalsIgnoreCase("1")) {
                            player.moveTo(thorn);
                            player.changePlayerHealth(-10);
                        } else if (choice.equalsIgnoreCase("2")) {
                            player.moveTo(camp);
                        } else if (choice.equalsIgnoreCase("3")) {
                            player.moveTo(cave);
                        }
                    } else if (player.getCurrentRoom() == camp) {
                        choice = scanner.nextLine();
                        if (choice.equalsIgnoreCase("1")) {
                            player.moveTo(cottage);
                        } else if (choice.equalsIgnoreCase("2")) {
                            player.moveTo(river);
                        } else if (choice.equalsIgnoreCase("3")) {
                            player.moveTo(redwood);
                        }
                    } else if (player.getCurrentRoom() == cottage) {
                        player.moveTo(camp);

                    } else if (player.getCurrentRoom() == river) {
                        choice = scanner.nextLine();
                        if (choice.equalsIgnoreCase("1")) {
                            player.moveTo(glade);
                        } else if (choice.equalsIgnoreCase("2")) {
                            player.moveTo(camp);
                        }
                    } else if (player.getCurrentRoom() == thorn) {
                        choice = scanner.nextLine();
                        if (choice.equalsIgnoreCase("1")) {
                            player.moveTo(doorEnding);
                        } else if (choice.equalsIgnoreCase("2")) {
                            player.moveTo(redwood);
                            player.changePlayerHealth(-10);
                        }
                    } else if (player.getCurrentRoom() == doorEnding) {
                        choice = scanner.nextLine();
                        if (choice.equalsIgnoreCase("1")) {
                            player.moveTo(redwood);
                        } else if (choice.equalsIgnoreCase("2")) {

                            System.out.println("Inget svar");
                        }
                    } else {
                        System.out.println("Ogiltigt val.");
                    }
                    break;
                case "2":
                    Room currentRoom = player.getCurrentRoom();
                    if (currentRoom.hasInteractables()) {
                        System.out.println("Du kan interagera med följande:");
                        currentRoom.showInteractablesWithNumbers();
                        System.out.print("Ange numret på det du vill interagera med: ");
                        String itemChoice = scanner.nextLine();
                        Interactable item = currentRoom.getInteractableByNumber(itemChoice);
                        if (item != null) {
                            item.interact(player);
                        } else {
                            System.out.println("Ogiltigt val.");
                        }
                    } else {
                        System.out.println("Det finns inget att interagera med här.");
                    }
                    break;
                case "3":
                    playing = false;
                    System.out.println("Tack för att du spelade!");
                    break;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
                    break;

            }

            if (player.getHealth() <= 0) {
                System.out.println("Du har förlorat all din hälsa. Spelet är slut.");
                playing = false;
            }


            scanner.close();

            // x - Starta med att karta ut världen
            // x - Skapa flera interactable objekt, npc, item,
            // x - items: livlina, nyckel, vapen
            // x -  Skapa flera rum, navigation, skada från omgivningen, skillcheck,
            // En Collectible interface för att plocka på sig items
            // Stridsmekanik
            // Formulera om treasure klassen

            //Room:
            //Gläntan(Start)
            //Grottan, objekt: Kniv(+dmg) !!
            //Redwood, objekt: Träd
            //Bäcken, objekt: Nocco(+hälsa)
            //Stugan, objekt: NPC(nyckel för slut)
            //Campfire, objekt: Goblin(fiende)
            //Dörren(slut)
            // Pathway(?), väg mellan rum

        }
    }
}