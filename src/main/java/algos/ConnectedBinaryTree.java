package algos;

public class ConnectedBinaryTree<T extends Comparable<T>> implements BinaryTree<T, ConnectedTreeNode<T>> {
  public ConnectedTreeNode<T> treeRoot;
  private final ConnectedTreeNodeFactory<T> nodeFactory;
  
  ConnectedBinaryTree(final ConnectedTreeNodeFactory<T> nodeFactory) {
    this.nodeFactory = nodeFactory;
	}

  /**
   * Accept an unconnected tree as input
   */
	ConnectedBinaryTree(final ConnectedTreeNodeFactory<T> nodeFactory, final BinaryTreeNode<T> root) {
		this.nodeFactory = nodeFactory;
    connect(root);
  }

  @Override
  public void setRoot(ConnectedTreeNode<T> root) {
    this.treeRoot = root;
  }

  @Override
  public ConnectedTreeNode<T> getRoot() {
    return treeRoot;
  }
  
  /**
   * Connects all the child nodes together
   * as per https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
   */
  private void connect(final BinaryTreeNode<T> root) {
    if (root == null) {
      return;
    }

  }

  private void connect(final BinaryTreeNode<T> unconnectedRoot, final ConnectedTreeNode<T> root) {
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