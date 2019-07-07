package algos;

public class BinaryTreeNode<T extends Comparable<T>> implements TreeNode<T> {
  public TreeNode<T> left;
  public TreeNode<T> right;
  private T val;

  public BinaryTreeNode(final T val) {
    this.val = val;
  }

	public T getVal() {
		return this.val;
	}

	public void setVal(final T val) {
		this.val = val;
	}

  /**
   * @return the left
   */
  public TreeNode<T> getLeft() {
    return left;
  }

  /**
   * @return the right
   */
  public TreeNode<T> getRight() {
    return right;
  }

  /**
   * @param left the left to set
   */
  public void setLeft(final TreeNode<T> left) {
    this.left = left;
  }

  /**
   * @param right the right to set
   */
  public void setRight(final TreeNode<T> right) {
    this.right = right;
  }
}
