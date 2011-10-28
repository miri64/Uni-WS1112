import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SortMain {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.err
					.println("Usage: java -jar u01.jar [M1,M2,M3,M4] [n1,n2,n3,n4]");
			System.err.println("IMPORTANT: No spaces between the commas");
			System.exit(1);
		}
		int[] ms = parseArrayString(args[0]);
		int[] lengths = parseArrayString(args[1]);
		SortTest test = new SortTest();
		test.testSortWithDifferentLengths(lengths, ms);
	}
	
	public static int[] parseArrayString(String input) {
		input = input.substring(1, input.length() - 1);
		input = input.replace(',', ' ');
		List<Integer> temp = new LinkedList<Integer>();
		Scanner scanner = new Scanner(input);
		while (scanner.hasNextInt()) {
			temp.add(scanner.nextInt());
	    }
		int[] res = new int[temp.size()];
	    int t = 0;
	    for (int e : temp) {
	    	res[t] = e;
	    	t++;
	    }
	    return res;
	}
}
