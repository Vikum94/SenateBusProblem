import java.util.Random;

public class ExpDistNumberGen {
    private Random random;
    private int mean;

    public ExpDistNumberGen(int mean) {
        random = new Random();
        this.mean = mean;
    }

    public double getNext() {
        double lambda = 1.0/mean;
        return Math.log(1-random.nextDouble())/(-lambda);
    }
}
