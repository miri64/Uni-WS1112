import java.math.BigInteger;

/**
 * @author Christian Cikryt
 */
public class MKaratsuba extends Karatsuba {

	public MKaratsuba(int m) {
		this.m = m;
	}

	private Multiplication helper = new SchoolMethod();

	@Override
	public BigInteger multiply(BigInteger a, BigInteger b) {
		return helper.multiply(a, b);
	}
}
