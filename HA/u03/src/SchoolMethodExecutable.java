import java.math.BigInteger;

/**
 * @author Christian Cikryt
 */
public class SchoolMethodExecutable extends MultiplicationExecutable{
	protected SchoolMethodExecutable(BigInteger a, BigInteger b) {
		super(a, b);
		algorithm = new SchoolMethod();
	}
}
