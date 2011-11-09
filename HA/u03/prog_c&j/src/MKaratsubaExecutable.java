import java.math.BigInteger;

public class MKaratsubaExecutable extends KaratsubaExecutable {

	protected MKaratsubaExecutable(BigInteger a, BigInteger b, int m) {
		super(a, b);
		algorithm = new MKaratsuba(m);
	}

}
