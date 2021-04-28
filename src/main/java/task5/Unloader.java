package task5;

import java.util.concurrent.TimeUnit;

public class Unloader implements Runnable{

    private Cart cart;

    public Unloader(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void run() {
        while (cart.canContinue()) {

            cart.unload();
            System.out.println("--Unloader: started unloading.");

            try {
                int productivity = 3;
                TimeUnit.SECONDS.sleep(cart.getAmount() / productivity);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("--Unloader: finished unloading.");
            cart.passToTransporter();
        }

        System.out.println("Unloader is done.");
    }
}
