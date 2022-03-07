public class Propeller {

    private int maxPower;
    private int currentPower = 0;
    private static final int POWER = 10;

    public Propeller(int maxPower) throws Exception {
        checkMaxPower(maxPower);
        this.maxPower = maxPower;
    }

    private void checkMaxPower(int maxPower) throws Exception {
        if (maxPower <= 0) throw new Exception("La potència ha de ser superior a 0");
    }

    public int getCurrentPower() {
        return currentPower;
    }

    public void throttle() {
        if ((currentPower + POWER) <= maxPower) {
            currentPower += POWER;
        }
    }

    public void brake() {
        if ((currentPower - POWER) >= 0) {
            currentPower -= POWER;
        }
    }

    @Override
    public String toString() {
        return "" + maxPower;
    }
}
