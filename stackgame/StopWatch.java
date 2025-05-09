public class StopWatch {

	private long watchStart = 0;
	private long watchStop = 0;
	
	public void start() {
		watchStart = System.nanoTime();
	}
	
	public void stop() {
		watchStop = System.nanoTime();
	}
	
	// convert nano to micro
	public long getTimeMicroSec() {
		return (watchStop - watchStart) / 1000;
	}
	
   // convert nano to seconds
	public double getTimeSeconds() {
		return (watchStop - watchStart) / 1000000000.0;
	}

	public String toString() {
		return String.format("Time: %.1f Seconds", getTimeSeconds());
	}
}
