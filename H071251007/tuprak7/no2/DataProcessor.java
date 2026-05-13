package tuprak7.no2;

import java.util.Random;

public class DataProcessor {
    private final Random random = new Random();

    public int process(String fileName) throws InterruptedException {
        int sleepTime = 500 + random.nextInt(1501);
        Thread.sleep(sleepTime);

        return 100 + random.nextInt(901);
    }
}