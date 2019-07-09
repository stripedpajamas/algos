package algos;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class ConnectedBinaryTreeTest {
  @Test
  public void testConnect_small() {
    final BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    bst.insert(Arrays.asList(2, 1, 3));

    final ConnectedBinaryTree<Integer> actualTree = new ConnectedBinaryTree<>(bst.getRoot());

    final ConnectedTreeNode<Integer> root = actualTree.getRoot();
    assertEquals(null, root.getNext());
    assertEquals(root.getRight(), root.getLeft().getNext());
    assertEquals(null, root.getRight().getNext());
  }
}