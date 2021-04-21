package task4;

public class Miner implements Runnable {
    private final int capacity = 3;

    private final int timeout = 1;

    private final String name;

    private final GoldMine goldMine;

    private int totalGold;

    public Miner(String name, GoldMine goldMine) {
        this.name = name;
        this.goldMine = goldMine;
        new Thread(this).start();
    }

    @Override
    public void run() {
        ThreadUtils.sleep(timeout);

        while (goldMine.hasGold) {

            totalGold += goldMine.mineGold(capacity);

            ThreadUtils.sleep(timeout);
        }
        System.out.println(toString());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Miner{")
                .append("name='")
                .append(name).append('\'')
                .append(", totalGold=")
                .append(totalGold)
                .append('}');

        return sb.toString();
    }

}
