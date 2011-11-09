import java.math.BigInteger;

/**
 * @author Christian Cikryt
 */
public class MKaratsubaExecutable extends KaratsubaExecutable {

	protected MKaratsubaExecutable(BigInteger a, BigInteger b, int m) {
		super(a, b);
		algorithm = new MKaratsuba(m);
	}

}
