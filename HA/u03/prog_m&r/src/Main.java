import java.math.BigInteger;
import java.util.Random;


public class Main {
	public static long messe_zeit(Multiplikation m, int n) {
		long start, ende;
		BigInteger a = new BigInteger(n, new Random());		
		BigInteger b = new BigInteger(n, new Random());
		
		start = System.currentTimeMillis();
		
		m.multipliziere(a, b);
		
		ende = System.currentTimeMillis();
		
		return ende-start;
	}
	
	public static Integer run_tests(int testruns, int max_num_length) {
		Stichprobe results_schulmethode = null;
		Stichprobe results_karatsuba    = null;
		
		Multiplikation schulmethode = new Schulmethode();
		Multiplikation karatsuba = new Karatsuba();
		
		for (int n = 1; n <= max_num_length; n++) {
			results_schulmethode = new Stichprobe();
			results_karatsuba = new Stichprobe();
			
			for (int _ = 0; _ < testruns; _++) {
				results_schulmethode.add(messe_zeit(schulmethode, n));
				results_karatsuba.add(messe_zeit(karatsuba, n));
			}
			System.out.printf("n = %5d; Schulmethode (µ = %2d, σ = %2d); " +
					"Karatsuba (µ = %2d, σ =  %2d);\n", n,
					results_schulmethode.mittelwert(), results_schulmethode.maa(),
					results_karatsuba.mittelwert(), results_karatsuba.maa());
			if (results_schulmethode.compareTo(results_karatsuba) > 0) {
				return n;
			}
		}
		
		return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length < 2) {
			System.err.println("Usage: java -jar u03.jar <testruns> <max_num_length>");
			System.exit(1);
		}
		
		int testruns = Integer.parseInt(args[0]);
		int max_num_length = Integer.parseInt(args[1]);
		
		Integer opt_karatsuba = run_tests(testruns, max_num_length);
		
		if (opt_karatsuba == null) {
			System.out.println("Für n < "+max_num_length+" konnte kein n gefunden werden, für das Karatsuba besser ist.");
		} else {
			System.out.println("Karatsuba ist ab n = "+opt_karatsuba+" besser.");
		}
	}

}
