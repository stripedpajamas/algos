package algos;

public class ConnectedTreeNode<V extends Comparable<V>> extends TreeNode<V> {
  private TreeNode<V> next;

  ConnectedTreeNode(V x) {
    super(x);
  }

  /**
   * @param next the next to set
   */
  public void setNext(TreeNode<V> next) {
    this.next = next;
  }

  /**
   * @return the next
   */
  public TreeNode<V> getNext() {
    return next;
  }
}