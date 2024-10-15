public class Object implements Interactable, Describable, Colectable {
    private String name;
    private String description;


    public Object(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void interact(Player player) {
        System.out.println("Du plockar upp " + name + ". " + description);
        player.getCurrentRoom().removeInteractable(name);
    }

    @Override
    public String getDescription() {
        return "En " + name + " ligger här. " + description;
    }



    @Override
    public void collect(Object object) {
        System.out.println("Du har plockat en " + name + ". " + description);

    }
}
