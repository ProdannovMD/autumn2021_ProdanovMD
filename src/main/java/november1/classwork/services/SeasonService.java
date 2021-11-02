package november1.classwork.services;

import november1.classwork.enums.Month;
import november1.classwork.enums.Season;

import java.util.EnumMap;
import java.util.concurrent.Callable;

public enum SeasonService {
    INSTANCE;

    private final EnumMap<Month, Callable<Season>> monthToSeasonMap;

    SeasonService() {
        this.monthToSeasonMap = new EnumMap<>(Month.class);

        for (Month month : Month.values()) {
            Callable<Season> callable;
            switch (month) {
                case DECEMBER:
                case JANUARY:
                case FEBRUARY: callable = () -> Season.WINTER; break;

                case MARCH:
                case APRIL:
                case MAY: callable = () -> Season.SPRING; break;

                case JUNE:
                case JULY:
                case AUGUST: callable = () -> Season.SUMMER; break;

                case SEPTEMBER:
                case OCTOBER:
                case NOVEMBER: callable = () -> Season.AUTUMN; break;

                default: callable = () -> null;
            }
            this.monthToSeasonMap.put(month, callable);
        }
    }

    public Season getSeasonOfMonth(Month month) {
        try {
            return monthToSeasonMap.get(month).call();
        } catch (Exception e) {
            return null;
        }
    }
}
