package november8.classwork.task;

import java.util.Objects;

public class Verb {
    private String infinitive;
    private String pastSimple;
    private String pastParticiple;
    private String rusName;

    public Verb(String infinitive, String pastSimple, String pastParticiple, String rusName) {
        this.infinitive = infinitive;
        this.pastSimple = pastSimple;
        this.pastParticiple = pastParticiple;
        this.rusName = rusName;
    }

    public String getInfinitive() {
        return infinitive;
    }

    public void setInfinitive(String infinitive) {
        this.infinitive = infinitive;
    }

    public String getPastSimple() {
        return pastSimple;
    }

    public void setPastSimple(String pastSimple) {
        this.pastSimple = pastSimple;
    }

    public String getPastParticiple() {
        return pastParticiple;
    }

    public void setPastParticiple(String pastParticiple) {
        this.pastParticiple = pastParticiple;
    }

    public String getRusName() {
        return rusName;
    }

    public void setRusName(String rusName) {
        this.rusName = rusName;
    }

    @Override
    public String toString() {
        return "Verb{" +
                "infinitive='" + infinitive + '\'' +
                ", pastSimple='" + pastSimple + '\'' +
                ", pastParticiple='" + pastParticiple + '\'' +
                ", rusName='" + rusName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Verb verb = (Verb) o;
        return Objects.equals(infinitive, verb.infinitive) && Objects.equals(pastSimple, verb.pastSimple) && Objects.equals(pastParticiple, verb.pastParticiple) && Objects.equals(rusName, verb.rusName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(infinitive, pastSimple, pastParticiple, rusName);
    }
}
