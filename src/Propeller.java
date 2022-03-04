public class Propeller {

    private int maxPower;
    private int currentPower = 0;

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
        if ((currentPower + 10) <= maxPower) {
            currentPower += 10;
        }
    }

    public void brake() {
        if ((currentPower - 10) >= 0) {
            currentPower -= 10;
        }
    }

    @Override
    public String toString() {
        return "" + maxPower;
    }
}
