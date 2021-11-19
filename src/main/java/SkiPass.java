public class SkiPass {
    private String id;
    private CardType type;
    public boolean blocked = false;
    private int capacity;
    private int left;

    public SkiPass(String id, CardType type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.left = capacity;
    }

    public String getId(){
        return this.id;
    }
    public CardType getType(){
        return this.type;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public int getLeft(){
        return this.left;
    }
    public void decreseLeft(){
        this.left -= 1;
    }
}
