package task5;

import java.util.concurrent.TimeUnit;

public class Transporter implements Runnable {

    private Cart cart;

    public Transporter(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void run() {
        while (cart.canContinue()) {

            cart.transport();
            System.out.println("--Transporter: started moving.");

            try {
                int travelTime = 5;
                TimeUnit.SECONDS.sleep(travelTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("--Transporter: finished moving.");
            cart.passToOperator();

            if (!cart.canLoad()) {
                break;
            }
        }

        System.out.println("Transporter is done.");
    }
}
