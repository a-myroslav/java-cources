package task4;

import java.util.concurrent.TimeUnit;

public class Miner implements Runnable {

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
        while (goldMine.hasGold) {
            totalGold += goldMine.mineGold(3);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
