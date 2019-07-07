package algos;

public class ConnectedTreeNodeFactory<T extends Comparable<T>> implements TreeNodeFactory<T, ConnectedTreeNode<T>> {
  public ConnectedTreeNode<T> fromValue(final T val) {
    return new ConnectedTreeNode<>(val);
  }
}