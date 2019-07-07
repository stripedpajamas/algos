package algos;

public interface BinaryTree<T extends Comparable<T>, Node extends BinaryTreeNode<T>> {
  public Node getRoot();
  public void setRoot(final Node root);
}