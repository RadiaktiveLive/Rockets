public class Propeller {

	private int maxPower;
	private int currentPower = 0;
	private static final int POWER_STEP = 10;

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
		currentPower += POWER_STEP;
		if (currentPower > maxPower) {
			currentPower = maxPower;
		}
	}

	public void brake() {
		currentPower -= POWER_STEP;
		if (currentPower < 0) {
			currentPower = 0;
		}
	}

	@Override
	public String toString() {
		return "" + maxPower;
	}
}
