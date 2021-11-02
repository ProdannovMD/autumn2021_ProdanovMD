package november1.classwork.enums;

public enum Season {
    WINTER("Холодно, снег падает"),
    SPRING("Прохдладно, тает снег, начинают цвести растения"),
    SUMMER("Жарко"),
    AUTUMN("Прохладно, опадают листья с деревьев");

    private String description;

    Season(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
