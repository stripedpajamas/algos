package algos;

public class BinaryTreeNode<T extends Comparable<T>> {
  public BinaryTreeNode<T> left;
  public BinaryTreeNode<T> right;
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
  public BinaryTreeNode<T> getLeft() {
    return left;
  }

  /**
   * @return the right
   */
  public BinaryTreeNode<T> getRight() {
    return right;
  }

  /**
   * @param left the left to set
   */
  public void setLeft(final BinaryTreeNode<T> left) {
    this.left = left;
  }

  /**
   * @param right the right to set
   */
  public void setRight(final BinaryTreeNode<T> right) {
    this.right = right;
  }
}
