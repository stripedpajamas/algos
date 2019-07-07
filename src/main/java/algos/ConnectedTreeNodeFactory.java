package algos;

public class ConnectedTreeNodeFactory<T extends Comparable<T>> {
  public ConnectedTreeNode<T> fromValue(final T val) {
    return new ConnectedTreeNode<>(val);
  }
}