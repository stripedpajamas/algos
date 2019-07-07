package algos;

public class ConnectedTreeNode<T extends Comparable<T>> implements TreeNode<T, ConnectedTreeNode<T>> {
  private T val;
  private ConnectedTreeNode<T> next;
  private ConnectedTreeNode<T> left;
  private ConnectedTreeNode<T> right;

  ConnectedTreeNode(T val) {
    this.val = val;
  }

  @Override
  public ConnectedTreeNode<T> getLeft() {
    return left;
  }

  @Override
  public ConnectedTreeNode<T> getRight() {
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
  public void setRight(ConnectedTreeNode<T> right) {
    this.right = right;
  }

  @Override
  public void setLeft(ConnectedTreeNode<T> left) {
    this.left = left;
  }

  /**
   * @param next the next to set
   */
  public void setNext(ConnectedTreeNode<T> next) {
    this.next = next;
  }

  /**
   * @return the next
   */
  public ConnectedTreeNode<T> getNext() {
    return next;
  }
}