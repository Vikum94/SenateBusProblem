import java.util.Random;

public class ExpDistNumberGen {
    private Random random;
    private int mean;

    public ExpDistNumberGen(int mean) {
        random = new Random();
        this.mean = mean;
    }

    public long getNext() {
        float lambda = 1/mean;
        return  (long) (Math.log(1-random.nextLong())/(lambda));
    }
}
