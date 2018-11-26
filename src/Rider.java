public class Rider extends Thread {
    @Override
    public void run() {
        try {
            Shared.multiplex.acquire();

            Shared.mutex.acquire();
            Shared.ridersCount.incrementAndGet();
            System.out.println("Rider " + Shared.ridersCount + " came to bus stop");
            Shared.mutex.release();

            Shared.bus.acquire(); //stop the bus
            Shared.multiplex.release(); // getting into bus, therefore decrementing count

//            Shared.mutex.acquire();
            System.out.println("Rider: " + (Shared.ridersCount.decrementAndGet()+1)+ " getting into bus");
//            Shared.mutex.release();

            if (Shared.ridersCount.get() == 0) {
                Shared.allAboard.release(); //last rider signals the bus
                //the bus calls the bus.release for this one
            } else {
                Shared.bus.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
