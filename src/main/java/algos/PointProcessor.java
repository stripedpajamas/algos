package algos;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class PointProcessor {
	public class PointDistance {
		private final int[] point;
		private final double distance;

		PointDistance(final int[] point, final double distance) {
			this.point = point;
			this.distance = distance;
		}
	}

	/**
	 * https://leetcode.com/problems/k-closest-points-to-origin/
	 */
	public int[][] kClosest(final int[][] points, final int k) {
		if (k >= points.length) {
			throw new IllegalArgumentException("k must be smaller than points length");
		}
		// return mapSortLimit(points, k);
		return selectFromHeap(points, k);
	}

	public int[][] selectFromHeap(final int[][] points, final int k) {
		final Queue<PointDistance> minHeap = new PriorityQueue<>(k, this::byDistance);
		Arrays.stream(points)
			.map(p -> new PointDistance(p, calculateEuclidianDistanceFromOrigin(p)))
			.forEach(pd -> { minHeap.add(pd); });
		
		return IntStream.range(0, k)
			.boxed()
			.map(i -> minHeap.poll().point)
			.toArray(int[][]::new);
	}

	/**
	 * Frst map the points to their distance from the origin then sort smallest to
	 * greatest then slice the first k elements
	 * 
	 * @param points an array of x, y coordinates
	 * @param k      the limit for how many points to return
	 * @return k closest points to the origin
	 */
	public int[][] mapSortLimit(final int[][] points, final int k) {
		return Arrays.stream(points)
			.map(p -> new PointDistance(p, calculateEuclidianDistanceFromOrigin(p)))
			.sorted(this::byDistance)
			.limit(k)
			.map(pd -> pd.point)
			.toArray(int[][]::new);
	}

	/**
	 * Take the square root of the sum of the squares of the differences of the
	 * coordinates. For distance from the origin, this effectively means sqrt(x^2 +
	 * y^2)
	 * 
	 * @param point [x, y]
	 * @return the euclidian distance from the origin
	 */
	private double calculateEuclidianDistanceFromOrigin(final int[] point) {
		return Math.sqrt(Arrays.stream(point).map(p -> p * p).sum());
	}

	private int byDistance(final PointDistance a, final PointDistance b) {
		if (a.distance < b.distance) {
			return -1;
		}
		if (a.distance > b.distance) {
			return 1;
		}
		return 0;
	}
}