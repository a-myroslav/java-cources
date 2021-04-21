package task4;

public class Main {
    public static void main(String[] args) {

        GoldMine goldMine = new GoldMine(1000);

        Thread mainTread = new Thread(() -> {
            while (goldMine.hasGold) {

                System.out.println(goldMine.toString());

                ThreadUtils.sleep(1);
            }
            System.out.println("GoldMine is empty.");
        });

        mainTread.setPriority(Thread.MAX_PRIORITY);
        mainTread.start();

        for (int i = 1; i <= 5; i++) {
            new Miner("OLD MINER " + i, goldMine);
        }

        new Barracks(goldMine);
    }
}
