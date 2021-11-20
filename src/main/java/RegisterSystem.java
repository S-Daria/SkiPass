import java.util.Arrays;
import java.util.LinkedList;

public class RegisterSystem {
    private LinkedList<SkiPass> cards = new LinkedList<>();
    private int nextId = -1;
    protected LinkedList<SkiPass> runcards = new LinkedList<>();
    protected LinkedList<SkiPass> failedcards = new LinkedList<>();

    public void addRunCard(SkiPass card){
        runcards.add(card);
    }

    public void addFailedCard(SkiPass card){
        failedcards.add(card);
    }

    public String getCards(){
        return this.cards.toString();
    }

    public String getRunCards(){
        return this.runcards.toString();
    }

    public String getFailedCards(){
        return this.failedcards.toString();
    }

    public DayCard createDaySkiPass(CardType type, int capacity) {
        if ((capacity == 1 || capacity == 2) || (type == CardType.WEEKDAY && capacity == 5) || (type == CardType.SEASON)) {
            nextId++;
            DayCard card = new DayCard(String.format("%010d", this.nextId), type, capacity);
            cards.add(card);
            System.out.println("SUCCESS: card has been added.");
            return card;
        } else {
            throw new java.lang.Error("ERROR: capacity is incorrect.");
        }
    }

    public RidesCard createRidesSkiPass(CardType type, int capacity){
        if (Arrays.asList(10, 20, 50, 100).contains(capacity)) {
            nextId++;
            RidesCard card = new RidesCard(String.format("%010d", this.nextId), type, capacity);
            cards.add(card);
            System.out.println("SUCCESS: card has been added.");
            return card;
        } else {
            throw new java.lang.Error("ERROR: capacity is incorrect.");
        }
    }

    protected boolean isInDB(SkiPass card){
        for (int i = 0; i < cards.size(); i++){
            if (cards.get(i).getId().equals(card.getId())){
                return true;
            }
        }
        return false;
    }

    public String blockSkipass(SkiPass card){
        if (isInDB(card)){
            card.blocked = true;
            return "SUCCESS: card has been blocked.";
        } else {
            return "ERROR: card does not exist.";
        }
    }
}
