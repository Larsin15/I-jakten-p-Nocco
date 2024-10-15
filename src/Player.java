public class Player {
        private String name;
        private int health;
        private Room currentRoom;
        private int damage;

        public Player(String name) {
            this.name = name;
            this.health = 100;
        }

        public void moveTo(Room room) {
            this.currentRoom = room;
            System.out.println("Du går in i " + room.getName() + ".");
            System.out.println(room.getDescription());
            room.showInteractables();
        }

        public int getHealth() {
            return health;
        }

        public int getDamage() {
            return damage;
        }

        public void changePlayerHealth(int amount) {
            this.health += amount;
            System.out.println("Din hälsa är nu " + health + ".");
        }

        public String getName() {
            return name;
        }

        public Room getCurrentRoom() {
            return currentRoom;
        }

        // inventory, damage,
    }

