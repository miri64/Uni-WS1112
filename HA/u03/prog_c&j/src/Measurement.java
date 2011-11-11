public class Measurement {
	private int numberOfRuns;

	public Measurement(int numberOfRuns) {
		this.numberOfRuns = numberOfRuns;
	}

	public long[] measureTimeForDifferentExecutables(Executable... executables) {
		long[] res = new long[executables.length];
		for (int i = 0; i < executables.length; i++) {
			res[i] = measureTime(executables[i]);
		}
		return res;
	}

	public long measureTime(Executable e) {
		long res = 0;
		for (int i = 1; i <= numberOfRuns; i++) {
			System.gc();
			long start = System.currentTimeMillis();
			e.execute();
			long end = System.currentTimeMillis();
			res += end - start;
		}
		return res / numberOfRuns;
	}
}
