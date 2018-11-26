import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program starting... ");
        Thread busThreadCreator = new Thread(() -> {
            ExpDistNumberGen gen = new ExpDistNumberGen(Properties.BUS_INTERVAL_MEAN);
            while (true) {
                new Bus().start();
                try {
                    Thread.sleep((long) gen.getNext());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread riderThreadCreator = new Thread(() -> {
            ExpDistNumberGen gen = new ExpDistNumberGen(Properties.RIDER_INTERVAL_MEAN);
            while (true) {
                new Rider().start();
                try {
                    Thread.sleep((long) gen.getNext());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        riderThreadCreator.start();
        busThreadCreator.start();
    }
}
