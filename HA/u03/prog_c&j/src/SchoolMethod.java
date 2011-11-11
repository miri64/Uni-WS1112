import java.math.BigInteger;

public class SchoolMethod implements Multiplication{

	public BigInteger multiply(BigInteger a, BigInteger b) {
		BigInteger res = new BigInteger("0");
		int pos = 0;
		BigInteger exp = BigInteger.ONE;
		BigInteger factor2 = b;
		while (factor2.compareTo(BigInteger.ZERO) > 0) {
			BigInteger[] result = factor2.divideAndRemainder(BigInteger.TEN);
			BigInteger digit = result[1];
			factor2 = result[0];
			res = res.add(a.multiply(digit)).multiply(exp);
			pos++;
			exp = exp.multiply(BigInteger.TEN);
		}
		return res;
	}
}
