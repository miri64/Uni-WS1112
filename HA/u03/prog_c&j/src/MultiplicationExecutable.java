import java.math.BigInteger;

/**
 * @author Christian Cikryt
 */
public abstract class MultiplicationExecutable implements Executable {
	protected Multiplication algorithm;

	private BigInteger a;
	private BigInteger b;

	protected MultiplicationExecutable(BigInteger a, BigInteger b) {
		this.a = a;
		this.b = b;
	}

	public void execute() {
		algorithm.multiply(a, b);
	}
}
