package task2.data;

import java.io.Serializable;

public class Pudge extends Hero implements Serializable {

    private String ultimate;

    public Pudge(int intelligence, int agility, int strength, String ultimate) {
        super(intelligence, agility, strength);
        this.ultimate = ultimate;
    }

    public String getUltimate() {
        return ultimate;
    }

    public void setUltimate(String ultimate) {
        this.ultimate = ultimate;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Pudge{")
                .append("intelligence=")
                .append(intelligence)
                .append(", agility=")
                .append(agility)
                .append(", strength=")
                .append(strength)
                .append(", ultimate='")
                .append(ultimate)
                .append('\'')
                .append('}')
                .toString();
    }
}
