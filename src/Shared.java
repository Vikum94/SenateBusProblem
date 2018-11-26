import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Shared {
    public static final AtomicInteger ridersCount = new AtomicInteger(0);
    public static final AtomicInteger waitingRiderCount = new AtomicInteger(0);
    public static final Semaphore mutex = new Semaphore(1);
    public static final Semaphore multiplex = new Semaphore(50);
    public static final Semaphore bus = new Semaphore(0);
    public static final Semaphore allAboard = new Semaphore(0);

}
