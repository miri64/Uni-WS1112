import org.junit.BeforeClass;

/**
 * @author Christian Cikryt
 */
public class SchoolMethodTest extends MultiplicationTest {
	
	@BeforeClass
	public static void initialize() {
		algorithm = new SchoolMethod();
	}
}
