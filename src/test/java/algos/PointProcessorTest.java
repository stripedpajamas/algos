package algos;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PointProcessorTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { createPointsFrom(1, 3, -2, 2), 1, createPointsFrom(-2, 2) },
				{ createPointsFrom(3, 3, 5, -1, -2, 4), 2, createPointsFrom(3, 3, -2, 4) } });
	}

	private final PointProcessor PointProcessor = new PointProcessor();
	private final int[][] points;
	private final int k;
	private final int[][] expected;

	public PointProcessorTest(final int[][] points, final int k, final int[][] expected) {
		this.points = points;
		this.k = k;
		this.expected = expected;
	}

	@Test
	public void testKClosest_mapSortLimit() {
		assertArrayEquals(expected, PointProcessor.kClosest(points, k));
	}

	private static int[][] createPointsFrom(int... nums) {
		if (nums.length % 2 != 0) {
			throw new IllegalArgumentException("must provide even list of nums");
		}
		final List<int[]> output = new ArrayList<>();
		for (int i = 0; i < nums.length; i += 2) {
			final int x = nums[i];
			final int y = nums[i + 1];
			output.add(new int[] { x, y });
		}

		return output.toArray(new int[0][0]);
	}
}