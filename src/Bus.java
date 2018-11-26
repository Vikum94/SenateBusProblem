public class Bus extends Thread {
    @Override
    public void run() {
        try {
            Shared.mutex.acquire(); //in case another bus was there
            System.out.println("Bus: " + this.getId() + " arrived." );
            if (Shared.ridersCount.get() > 0) {
                Shared.bus.release(); //riders stop waiting for bus
                Shared.allAboard.acquire(); //last rider will release this
            }
            Shared.mutex.release();
            System.out.println("Bus: " + this.getId() + " departed." );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
