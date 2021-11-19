public class Modeling {
    public static void main(String[] args) {
        // Create sregister system and turniket
        RegisterSystem system = new RegisterSystem();
        Turniket turniket = new Turniket();

        // Create some SkiPasses
        SkiPass weekend2 = system.createDaySkiPass(CardType.WEEKEND, 2);
        SkiPass weekday5 = system.createDaySkiPass(CardType.WEEKDAY, 5);
        SkiPass weekday10 = system.createRidesSkiPass(CardType.WEEKDAY, 10);
        SkiPass season = system.createDaySkiPass(CardType.SEASON, 0);

        System.out.println(system.getCards() + "\n");

        // Try to use different SkiPasses
        System.out.println("WEEKEND_2:");
        System.out.println(turniket.entryTurniket(weekend2, DayType.MONDAY) + "\n");

        System.out.println("WEEKDAYS_5:");
        System.out.println(turniket.entryTurniket(weekday5, DayType.MONDAY) + "\n");

        // Block SkiPass and try to use it
        System.out.println("SEASON:");
        system.blockSkipass(season);
        System.out.println(turniket.entryTurniket(season, DayType.MONDAY) + "\n");

        // Try to use SkiPass until it reaches above max of lifts
        System.out.println("WEEKDAYS_10:");
        for (int i = 0; i < 9; i++) {
            turniket.entryTurniket(weekday10, DayType.TUESDAY);
        }
        System.out.println(turniket.entryTurniket(weekday10, DayType.TUESDAY) + "\n");

        System.out.println("___TEST IS OVER___");
    }
}
