package algos;

public class ConnectedTreeNode<T extends Comparable<T>> extends AbstractBinaryTreeNode<T, ConnectedTreeNode<T>> {
  private ConnectedTreeNode<T> next;

  ConnectedTreeNode(T val) {
    setVal(val);
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