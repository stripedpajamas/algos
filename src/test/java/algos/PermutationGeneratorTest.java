package algos;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PermutationGeneratorTest {
  @Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
      { },
      { }
    });
	}

	private final PermutationGenerator permutationGenerator = new PermutationGenerator();
	private final String input;
	private final List<String> expected;

	public PermutationGeneratorTest(final String input, final List<String> expected) {
    this.input = input;
		this.expected = expected;
  }
  
  @Test
  public void testLetterCase() {
    Assert.assertEquals(expected, permutationGenerator.letterCase(input));
  }
}