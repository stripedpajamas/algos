package algos;

public interface BinaryTreeNodeFactory<T extends Comparable<T>, Node extends AbstractBinaryTreeNode<T, Node>> {
  public Node fromValue(final T val);
}