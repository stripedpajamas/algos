package algos;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BinarySearchTreeTest {
	@Test
	public void testInorderTraversal() {
		final BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(Arrays.asList(7, 2, 5, 4, 3, 6, 8, 1));

		final List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		final List<Integer> actual = new ArrayList<>();
		tree.traverseInOrder(val -> {
			actual.add(val);
		});
		assertEquals(actual, expected);
	}
}