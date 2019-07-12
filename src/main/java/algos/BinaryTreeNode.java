package algos;

public class BinaryTreeNode<T extends Comparable<T>> extends AbstractBinaryTreeNode<T, BinaryTreeNode<T>> {
  BinaryTreeNode(final T val) {
    setVal(val);
  }
}
