import java.util.Arrays;

public enum CardType {

    WEEKDAY(new DayType[] {DayType.MONDAY, DayType.TUESDAY, DayType.WEDNESDAY, DayType.THURSDAY, DayType.FRIDAY}),
    WEEKEND(new DayType[] {DayType.SATURDAY, DayType.SUNDAY}),
    SEASON(new DayType[] {DayType.SATURDAY, DayType.SUNDAY});

    public DayType[] daysAllowed;

    CardType(DayType[] daysAllowed){
        this.daysAllowed = daysAllowed;
    }


}
