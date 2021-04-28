package task5;

public class Warehouse {

    private volatile int gold = 100;

    public synchronized int takeGold(int desiredAmount) {
        int amount = Math.min(gold, desiredAmount);
        gold -= amount;

        return amount;
    }

    public boolean hasGold() {
        return gold != 0;
    }
}
