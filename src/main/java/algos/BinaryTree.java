package algos;

import java.util.List;

public abstract class BinaryTree<T extends Comparable<T>, Node extends AbstractBinaryTreeNode<T, Node>> {
  private Node treeRoot;

  public Node getRoot() {
    return this.treeRoot;
  }

  public void setRoot(final Node root) {
    this.treeRoot = root;
  }

  abstract public void insert(final T val);

  public void insert(final List<T> vals) {
    vals.stream().forEach(this::insert);
  }
}