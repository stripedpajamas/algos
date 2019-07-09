package algos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ConnectedBinaryTreeTest {
  @Test
  public void testInsert() {
    final ConnectedBinaryTree<Integer> tree = new ConnectedBinaryTree<>();
    final List<Integer> vals = Arrays.asList(1, 2, 3, 4, 5);
    tree.insert(vals);

    assertEquals(vals.get(0), tree.getRoot().getVal());
    assertEquals(vals.get(1), tree.getRoot().getLeft().getVal());
    assertEquals(vals.get(2), tree.getRoot().getRight().getVal());
    assertEquals(vals.get(3), tree.getRoot().getLeft().getLeft().getVal());
    assertEquals(vals.get(4), tree.getRoot().getLeft().getRight().getVal());

    assertNull(tree.getRoot().getNext());
    assertEquals(tree.getRoot().getRight(), tree.getRoot().getLeft().getNext());
    assertNull(tree.getRoot().getRight().getNext());
  }

  @Test
  public void testConnect_small() {
    final BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    bst.insert(Arrays.asList(2, 1, 3));

    final ConnectedBinaryTree<Integer> actualTree = new ConnectedBinaryTree<>(bst.getRoot());

    final ConnectedTreeNode<Integer> root = actualTree.getRoot();
    assertNull(root.getNext());
    assertEquals(root.getRight(), root.getLeft().getNext());
    assertNull(root.getRight().getNext());
  }
}