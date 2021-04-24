package task4;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        GoldMine goldMine = new GoldMine(100);
        Barracks barracks = new Barracks(goldMine);

        while (goldMine.hasGold) {
            System.out.println(goldMine.toString());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        barracks.getMiners().forEach(miner -> System.out.println(miner.toString()));

    }
}
