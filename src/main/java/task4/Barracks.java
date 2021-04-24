package task4;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Barracks implements Runnable {
    private final GoldMine goldMine;

    private ArrayList<Miner> miners = new ArrayList<>();

    public Barracks(GoldMine goldMine) {
        this.goldMine = goldMine;
        new Thread(this).start();
    }

    public void addMiner(Miner miner) {
        miners.add(miner);
    }

    public ArrayList<Miner> getMiners() {
        return miners;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            addMiner(new Miner("MINER " + i, goldMine));
        }

        while (goldMine.hasGold) {

            addMiner(new Miner("MINER " + (miners.size() + 1), goldMine));

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Barracks are closed");
    }

}
