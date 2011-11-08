import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author Christian Cikryt
 */
public class KaratsubaTest extends MultiplicationTest{

	@BeforeClass
	public static void initialize() {
		algorithm = new Karatsuba();
	}
}
