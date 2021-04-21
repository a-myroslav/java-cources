package task4;

public class Barracks implements Runnable {
    private final int timeout = 10;

    private int minersAmount;

    private final GoldMine goldMine;

    public Barracks(GoldMine goldMine) {
        this.goldMine = goldMine;
        new Thread(this).start();
    }

    @Override
    public void run() {
        ThreadUtils.sleep(timeout);

        while (goldMine.hasGold) {

            new Miner("YOUNG MINER " + ++minersAmount, goldMine);

            ThreadUtils.sleep(timeout);
        }

        System.out.println("Barracks are closed");
    }

}
