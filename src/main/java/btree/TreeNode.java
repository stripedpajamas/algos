package btree;

public class TreeNode<V extends Comparable<V>> {
	final V val;
	TreeNode<V> left;
	TreeNode<V> right;

	TreeNode(V x) {
		val = x;
	}
}
