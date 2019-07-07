package algos;

public class BinaryTreeNodeFactory<T extends Comparable<T>> {
  public BinaryTreeNode<T> fromValue(final T val) {
    return new BinaryTreeNode<>(val);
  }
}