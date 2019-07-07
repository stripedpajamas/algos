package algos;

public class ConnectedTreeNode<T extends Comparable<T>> implements TreeNode<T> {
  private T val;
  private TreeNode<T> next;
  private TreeNode<T> left;
  private TreeNode<T> right;

  ConnectedTreeNode(T val) {
    this.val = val;
  }

  @Override
  public TreeNode<T> getLeft() {
    return left;
  }

  @Override
  public TreeNode<T> getRight() {
    return right;
  }

  @Override
  public T getVal() {
    return val;
  }

  @Override
  public void setVal(T val) {
    this.val = val;
  }

  @Override
  public void setRight(TreeNode<T> right) {
    this.right = right;
  }

  @Override
  public void setLeft(TreeNode<T> left) {
    this.left = left;
  }

  /**
   * @param next the next to set
   */
  public void setNext(TreeNode<T> next) {
    this.next = next;
  }

  /**
   * @return the next
   */
  public TreeNode<T> getNext() {
    return next;
  }
}