package task5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();
        Cart cart = new Cart(warehouse);

        ExecutorService es = Executors.newFixedThreadPool(3);
        es.execute(new Loader(cart));
        es.execute(new Transporter(cart));
        es.execute(new Unloader(cart));

        es.shutdown();
    }
}
