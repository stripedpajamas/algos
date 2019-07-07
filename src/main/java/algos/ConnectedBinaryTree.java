package algos;

public class ConnectedBinaryTree<T extends Comparable<T>> implements BinaryTree<T, ConnectedTreeNode<T>> {
  public ConnectedTreeNode<T> treeRoot;

  /**
   * Accept an unconnected tree as input
   */
	ConnectedBinaryTree(final BinaryTreeNode<T> root) {
    this.treeRoot = connect(root);
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
  private ConnectedTreeNode<T> connect(final BinaryTreeNode<T> root) {
    if (root == null) {
      return null;
    }
    final ConnectedTreeNode<T> newRoot = new ConnectedTreeNode<T>(root.getVal());
    connect(root, newRoot);

    return newRoot;
  }

  private void connect(final BinaryTreeNode<T> unconnectedRoot, final ConnectedTreeNode<T> root) {
    if (unconnectedRoot == null) {
      return;
    }
    final ConnectedTreeNode<T> newLeft = unconnectedRoot.getLeft() != null ? new ConnectedTreeNode<T>(unconnectedRoot.getLeft().getVal()) : null;
    final ConnectedTreeNode<T> newRight = unconnectedRoot.getRight() != null ? new ConnectedTreeNode<T>(unconnectedRoot.getRight().getVal()) : null;

    root.setLeft(newLeft);
    root.setRight(newRight);

    if (newLeft != null) {
      newLeft.setNext(newRight);
    }

    if (root.getNext() != null) {
      ConnectedTreeNode<T> sibling = root.getNext();
      while (sibling != null && sibling.getLeft() == null && sibling.getRight() == null) {
          sibling = sibling.getNext();
      }
      if (sibling != null) {
          final ConnectedTreeNode<T> next;
          if (sibling.getLeft() == null) {
            if (sibling.getRight() == null) {
              next = null;
            } else {
              next = sibling.getRight();
            }
          } else {
            next = sibling.getLeft();
          }
          if (root.getRight() != null) {
              root.getRight().setNext(next);
          } else if (root.getLeft() != null) {
              root.getLeft().setNext(next);
          }
      }
    }
    
    connect(root.getRight());
    connect(root.getLeft());
  }
}