package november1.classwork;

import november1.classwork.enums.Month;
import november1.classwork.enums.Season;
import november1.classwork.services.SeasonService;


public class Main {
    public static void main(String[] args) {
        Season season = SeasonService.INSTANCE.getSeasonOfMonth(Month.APRIL);
        System.out.printf("%s - %s", season, season.getDescription());
    }
}
