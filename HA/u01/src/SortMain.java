/**
 * @author Christian Cikryt
 */
public class SortMain {
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		SortTest test = new SortTest();
		test.testSortArrays(m, n);
	}
}
