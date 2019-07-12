package algos;

public class BinaryTreeNodeFactoryImpl<T extends Comparable<T>> implements BinaryTreeNodeFactory<T, BinaryTreeNode<T>> {
  @Override
  public BinaryTreeNode<T> fromValue(T val) {
    return new BinaryTreeNode<>(val);
  }
}