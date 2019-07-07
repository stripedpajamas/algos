package algos;

public class ConnectedBinaryTree<T extends Comparable<T>> {
  public ConnectedTreeNode<T> treeRoot;
  private final ConnectedTreeNodeFactory<T> nodeFactory;
  
  ConnectedBinaryTree(final ConnectedTreeNodeFactory<T> nodeFactory) {
    this.nodeFactory = nodeFactory;
	}

	ConnectedBinaryTree(final ConnectedTreeNodeFactory<T> nodeFactory, final ConnectedTreeNode<T> root) {
		this.nodeFactory = nodeFactory;
    this.treeRoot = root;
    connect(root);
  }
  
  /**
   * Connects all the child nodes together
   * as per https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
   */
  private void connect(final ConnectedTreeNode<T> root) {
    if (root == null) {
      return;
    }
    if (root.getLeft() != null) {
      root.getLeft().setNext(root.getRight());
    }
    if (root.getNext() != null && root.getRight() != null) {
        root.getRight().setNext(root.getNext().getLeft());
    }
    
    connect(root.getRight());
    connect(root.getLeft());
  }
}