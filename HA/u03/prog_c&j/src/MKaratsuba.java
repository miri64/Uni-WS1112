import java.math.BigInteger;

public class MKaratsuba extends Karatsuba {

	public MKaratsuba(int m) {
		this.m = m;
	}

	private Multiplication helper = new SchoolMethod();

	@Override
	public BigInteger trivialMultiply(BigInteger a, BigInteger b) {
		return helper.multiply(a, b);
	}
}
