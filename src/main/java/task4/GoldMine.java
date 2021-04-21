package task4;

public class GoldMine {
    public volatile int gold;

    public volatile boolean hasGold;

    public GoldMine(int gold) {
        this.gold = gold;
        hasGold = gold > 0;
    }

    public synchronized int mineGold(int goldAmount) {
        int minedGold = Math.min(goldAmount, gold);
        gold -= minedGold;
        hasGold = gold > 0;
        return minedGold;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GoldMine{")
                .append("gold=")
                .append(gold)
                .append('}');

        return sb.toString();
    }
}
