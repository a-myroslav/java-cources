package task5;

import java.util.concurrent.TimeUnit;

public class Loader implements Runnable{

    private Cart cart;

    public Loader(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void run() {
        while (cart.canLoad()) {

            cart.load();
            System.out.println("--Loader: started loading.");

            try {
                int productivity = 2;
                TimeUnit.SECONDS.sleep(cart.getAmount() / productivity);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("--Loader: finished loading.");
            cart.passToTransporter();
        }

        System.out.println("Loader is done.");

    }
}
