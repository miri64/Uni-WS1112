import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * @author Christian Cikryt
 */
public abstract class MultiplicationTest {


	protected static Multiplication algorithm;

	@Test
	public void simpleMultiplication() {
		Assert.assertEquals(new BigInteger("100"), algorithm.multiply(new BigInteger("25"), new BigInteger("4")));
	}
}
