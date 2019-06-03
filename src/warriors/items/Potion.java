package warriors.items;

public class Potion extends Resource {
    private int healPts;

    public Potion(String name, int healPts){
        super(name);
        this.healPts = healPts;
    }
}
