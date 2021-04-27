package task5;

import java.util.concurrent.Semaphore;

public class Cart {

    private final Semaphore lSemaphore = new Semaphore(1);
    private final Semaphore tSemaphore = new Semaphore(0);
    private final Semaphore uSemaphore = new Semaphore(0);

    private Warehouse warehouse;
    private volatile int amount;

    public Cart(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public int getAmount() {
        return amount;
    }

    public boolean canLoad() {
        return warehouse.hasGold();
    }

    public boolean canContinue() {
        return warehouse.hasGold() || amount != 0;
    }

    public void load() {
        try {
            lSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int capacity = 6;
        amount = warehouse.takeGold(capacity);
    }

    public void unload() {
        try {
            uSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        amount = 0;
    }

    public void transport() {
        try {
            tSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void passToTransporter() {
        tSemaphore.release();
    }

    public void passToOperator() {
        if (amount > 0) {
            uSemaphore.release();
        } else {
            lSemaphore.release();
        }
    }
}
