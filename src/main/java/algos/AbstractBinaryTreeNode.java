package algos;

public abstract class AbstractBinaryTreeNode<T extends Comparable<T>, Node extends AbstractBinaryTreeNode<T, Node>> {
  private Node left;
  private Node right;
  private T val;

	public T getVal() {
		return this.val;
	}

	public void setVal(final T val) {
		this.val = val;
	}

  /**
   * @return the left
   */
  public Node getLeft() {
    return left;
  }

  /**
   * @return the right
   */
  public Node getRight() {
    return right;
  }

  /**
   * @param left the left to set
   */
  public void setLeft(final Node left) {
    this.left = left;
  }

  /**
   * @param right the right to set
   */
  public void setRight(final Node right) {
    this.right = right;
  }
}
