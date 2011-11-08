import java.math.BigInteger;

/**
 * @author Christian Cikryt
 */
public class KaratsubaExecutable extends MultiplicationExecutable {

	protected KaratsubaExecutable(BigInteger a, BigInteger b) {
		super(a, b);
		algorithm = new Karatsuba();
	}
}
