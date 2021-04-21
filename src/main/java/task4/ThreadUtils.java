package task4;

import java.util.concurrent.TimeUnit;

public class ThreadUtils {

    static public void sleep(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
