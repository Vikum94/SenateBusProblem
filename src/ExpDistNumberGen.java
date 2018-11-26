import java.util.Random;

public class ExpDistNumberGen {
    private Random random;
    private double mean;

    public ExpDistNumberGen(double mean) {
        random = new Random();
        this.mean = mean;
    }

    public double getNext() {
        double lambda = 1.0/mean;
        return Math.log(1-random.nextDouble())/(-lambda);
    }
}
