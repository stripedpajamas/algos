package algos;

public class TreeNode<V extends Comparable<V>> {
	private final V val;
	private TreeNode<V> left;
	private TreeNode<V> right;

	TreeNode(V x) {
		val = x;
	}

	/**
	 * @return the val
	 */
	public V getVal() {
		return val;
	}

	/**
	 * @return the left
	 */
	public TreeNode<V> getLeft() {
		return left;
	}

	/**
	 * @return the right
	 */
	public TreeNode<V> getRight() {
		return right;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(TreeNode<V> left) {
		this.left = left;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(TreeNode<V> right) {
		this.right = right;
	}
}
