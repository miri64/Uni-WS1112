import java.math.BigInteger;

public class KaratsubaExecutable extends MultiplicationExecutable {

	protected KaratsubaExecutable(BigInteger a, BigInteger b) {
		super(a, b);
		algorithm = new Karatsuba();
	}
}
