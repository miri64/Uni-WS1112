public class SortMain {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Usage: java -jar u01.jar length M");
			System.exit(1);
		}
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		SortTest test = new SortTest();
		test.testSortArrays(m, n);
	}
}
