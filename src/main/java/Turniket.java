import java.util.Arrays;

public class Turniket extends RegisterSystem{

    public boolean dayAllowedCheck(SkiPass card, DayType today){
        if (Arrays.stream(card.getType().daysAllowed).toList().contains(today)){
            return true;
        }
        return false;
    }

    public boolean leftCheck(SkiPass card){
        if (card.getLeft() > 0){
            return true;
        }
        return false;
    }

    public boolean blockedCheck(SkiPass card){
        if (card.blocked){
            return false;
        }
        return true;
    }

    public String entryTurniket(SkiPass card, DayType today){
        if (dayAllowedCheck(card, today) && leftCheck(card) && blockedCheck(card)){
            card.decreseLeft();
            addRunCard(card);
            return "You have successfully entered the turniket!";
        } else if (card.getType() == CardType.SEASON && isInDB(card)){
            addRunCard(card);
            return "You have successfully entered the turniket!";
        }
        else if (!blockedCheck(card)){
            addFailedCard(card);
            return "ERROR: Your card is blocked.";
        } else if (!leftCheck(card)){
            addFailedCard(card);
            return "ERROR: You cannot ride entry anymore, buy a new SkiPass.";
        } else if (!dayAllowedCheck(card, today)){
            addFailedCard(card);
            return "ERROR: You cannot ride today.";
        } else if(!isInDB(card)){
            addFailedCard(card);
            return "Your card does not exist.";
        }
        return "skipped all";
    }
}
