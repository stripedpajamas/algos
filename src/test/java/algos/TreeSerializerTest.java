package algos;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TreeSerializerTest {
	private static final BinaryTreeNodeFactory<Integer> NODE_FACTORY = new BinaryTreeNodeFactory<>();
	
	private BinaryTree<Integer> tree;
	private TreeSerializer<Integer> serializer;

	private final List<Integer> valuesList = Arrays.asList(7, 2, 8, 1, 5, null, null, null, null, 4, 6, 3, null, null,
			null, null, null);

	@Before
	public void setup() {
		tree = new BinaryTree<>(NODE_FACTORY);
		tree.insert(Arrays.asList(7, 2, 5, 4, 3, 6, 8, 1));

		serializer = new TreeSerializer<>(NODE_FACTORY);
	}

	@Test
	public void testCreateValuesList() {
		final List<Integer> actualValues = serializer.createValuesList(tree);

		assertEquals(valuesList, actualValues);
	}

	@Test
	public void testFromValuesList() {
		final BinaryTree<Integer> actualTree = serializer.fromValuesList(valuesList);

		// TODO implement an equality test on the tree
		// because the below equality does not necessitate equal structure
		assertEquals(tree.toInorderList(), actualTree.toInorderList());
	}

	@Test
	public void testSerialization() throws IOException {
		final BinaryTree<Integer> actualTree = serializer.deserialize(serializer.serialize(tree));

		// TODO implement an equality test on the tree
		// because the below equality does not necessitate equal structure
		assertEquals(tree.toInorderList(), actualTree.toInorderList());
	}
}