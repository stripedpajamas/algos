package algos;

public class BinaryTreeNodeFactory<T extends Comparable<T>> implements TreeNodeFactory<T, BinaryTreeNode<T>> {
  public BinaryTreeNode<T> fromValue(final T val) {
    return new BinaryTreeNode<>(val);
  }
}