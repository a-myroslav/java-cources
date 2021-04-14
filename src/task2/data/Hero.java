package task2.data;

import java.io.Serializable;

public class Hero implements Serializable {

    protected int intelligence, agility, strength;

    public Hero(int intelligence, int agility, int strength) {
        this.intelligence = intelligence;
        this.agility = agility;
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Hero{")
                .append("intelligence=")
                .append(intelligence)
                .append(", agility=")
                .append(agility)
                .append(", strength=")
                .append(strength)
                .append('}')
                .toString();
    }
}
