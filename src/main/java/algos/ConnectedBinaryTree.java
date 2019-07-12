package algos;

public class ConnectedBinaryTree<T extends Comparable<T>> extends BinaryTree<T, ConnectedTreeNode<T>> {
  ConnectedBinaryTree() {}

  /**
   * Accept an unconnected tree as input
   */
	ConnectedBinaryTree(final BinaryTreeNode<T> root) {
    setRoot(connect(root));
  }

  @Override
  public void insert(final T val) {
    if (getRoot() == null) {
      setRoot(new ConnectedTreeNode<>(val));
      return;
    }
    insert(getRoot(), val);
  }

  private void insert(final ConnectedTreeNode<T> root, final T val) {
    // find the first node that doesn't have two children and stick it there
    if (root == null) {
      return;
    }
    if (root.getLeft() == null || root.getRight() == null) {
      final ConnectedTreeNode<T> newNode = new ConnectedTreeNode<T>(val);
      if (root.getLeft() == null) {
        root.setLeft(newNode);
      } else {
        root.setRight(newNode);
      }
      connectNewNode(root);
      return;
    }
    insert(root.getLeft(), val);
    insert(root.getRight(), val);
  }

  private void connectNewNode(final ConnectedTreeNode<T> root) {
    if (root.getLeft() != null) {
      root.getLeft().setNext(root.getRight());
    }
    connectToSiblingChild(root, findNearestSiblingWithChild(root));
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

    connectToSiblingChild(root, findNearestSiblingWithChild(root));
    
    connect(unconnectedRoot.getRight(), root.getRight());
    connect(unconnectedRoot.getLeft(), root.getLeft());
  }

  private ConnectedTreeNode<T> findNearestSiblingWithChild(final ConnectedTreeNode<T> root) {
    ConnectedTreeNode<T> sibling = root.getNext();
    while (sibling != null && sibling.getLeft() == null && sibling.getRight() == null) {
        sibling = sibling.getNext();
    }
    return sibling;
  }

  private void connectToSiblingChild(final ConnectedTreeNode<T> root, final ConnectedTreeNode<T> sibling) {
    if (sibling == null || root == null) {
      return;
    }
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