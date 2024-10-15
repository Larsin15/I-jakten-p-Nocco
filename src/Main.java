import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Room forest = new Room("Skogen", "Du står i en mörk skog med höga träd.");
        Room doorEnding = new Room("Dörren", "Rötter täcker en gammal dörr i den finaste mahogny du nånsin skådat");
        Room redwood = new Room("Trädet", "Framför dig ser du ett massivt redwood träd som sträcker sig långt över molnen");
        Room cave = new Room("Grottan", "Inne i skogen ser du en klippväg med nåt glimmande i en skåra");
        Room glade = new Room("Gläntan", "Du står i en glänta. Framför dig ser du en igenväxt stig åt ett håll, åt andra är en bäck");
        Room river = new Room("Bäcken", "Vid bäcken ser du en blodig väska och längre bort hör du en sprakande brasa.");
        Room camp = new Room("Eldstaden", "Du värmer upp dig");
        Room cottage = new Room("Stugan", "På en stubbe stugan sitter ett litet troll som ger dig en varm blick");

        glade.connectRoom("Åt ena hållet ser du en snårig stig", cave);
        glade.connectRoom("den andra stigen leder dig till en pålande bäck\"", river);

        cave.connectRoom("Åt ena hållet ser du en snårig stig", glade);
        cave.connectRoom("Du ser ett massivt träd långt bort", redwood);

        redwood.connectRoom("En stig med klippor runt om", cave);
        redwood.connectRoom("Du ser inte mycket mer än en övervuxen stig fylld av rosenbuskar", doorEnding);
        redwood.connectRoom("En brinnande eldstad", camp);

        camp.connectRoom("Massivt träd", redwood);
        camp.connectRoom("En röd stuga uppe på en kulle", cottage);
        camp.connectRoom("Du hör en pålande bäck", river);

        river.connectRoom("En sprakande eldstad", camp);
        river.connectRoom("Solen lyser upp mot en familjär plats", glade);

        doorEnding.connectRoom("Gå tillbaka genom rosenbuskarna", redwood);



        Treasure gold = new Treasure("guldmynt", "Det glimmar vackert i ljuset.");

        Object bloodyPouch = new Object("blodiga väskan", "I väskan hittar du en NOCCO Limón del sol");
        Object knife = new Object("kniv", " en slank obsidiankniv som glimmar i mörkret. \n Den är snabb och tyst, because you are worth it - Maybeline. \n Egenskaper:" + " Skada + 15");
        Object nocco = new Object("nocco", "Den indragande loggan med sockerfritt 180mg koffein får dig att tänka på hälsa i dess renaste form. \n Med en doft av tonårsångest ger den förnyelse till dem som har lidit i skolbänken eller strid. \n Egenskaper:\n Effekt: Återställer 30 hälsa.");
        Object key = new Object("nyckel", "En enkel nyckel i mässing");
        //Object trollQuiz = new Object("")


        Npc goblin = new Npc("goblin", "Den har mord i blicken.");
        Npc troll = new Npc("troll", "Trollet är en stor och stark varelse med gröna, skrovliga hud och långa klor. Det är både kraftfullt och klokt. \n Djupt inne i skogen förvarar det en magisk nyckel, skapad av stjärnljus. För att få nyckeln måste du besvara dess gåtor, som viskar genom natten.");


        //forest.addInteractable("guldmynt", gold);
        camp.addInteractable("goblin", goblin);
        cave.addInteractable("skåra", knife);
        river.addInteractable("blodigpåse", bloodyPouch);

        Player player = new Player("Äventyrare");
        player.moveTo(glade);

        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        System.out.println("Välkommen till Äventyrsspelet!");


        while (playing) {

            System.out.println(player.getCurrentRoom().getDescription());
            System.out.println("1. Gå vidare");
            System.out.println("2. Gå till");
            System.out.println("3. Avsluta spel");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Room currentRoom = player.getCurrentRoom();
                    currentRoom.showConnectedRoomsWithNumbers();

                    String roomChoice = scanner.nextLine();
                    Room nextRoom = currentRoom.getConnectRoomByNumber(roomChoice);

                    if (nextRoom != null) {
                        player.moveTo(nextRoom);
                    } else {
                        System.out.println("Ogiltigt val.");
                    }
                case "2":
                    currentRoom = player.getCurrentRoom();
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