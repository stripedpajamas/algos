package algos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T, BinaryTreeNode<T>> {
	BinarySearchTree() {}

	BinarySearchTree(final BinaryTreeNode<T> root) {
		setRoot(root);
	}

	@Override
	public void insert(final T val) {
		insert(getRoot(), val);
	}

	public void insert(final BinaryTreeNode<T> root, final T val) {
		if (getRoot() == null) {
			setRoot(new BinaryTreeNode<>(val));
			return;
		}

		if (val.compareTo(root.getVal()) < 0) {
			// val belongs to the left of root
			if (root.getLeft() == null) {
				root.setLeft(new BinaryTreeNode<>(val));
			} else {
				insert(root.getLeft(), val);
			}
		} else if (val.compareTo(root.getVal()) > 0) {
			// val belongs to the right of root
			if (root.getRight() == null) {
				root.setRight(new BinaryTreeNode<>(val));
			} else {
				insert(root.getRight(), val);
			}
		}
	}

	public void traverseInOrder(final Consumer<T> visit) {
		traverseInOrder(getRoot(), visit);
	}

	public void traverseInOrder(final BinaryTreeNode<T> root, final Consumer<T> visit) {
		if (root == null) {
			return;
		}
		traverseInOrder(root.getLeft(), visit);
		visit.accept(root.getVal());
		traverseInOrder(root.getRight(), visit);
	}

	public List<T> toInorderList() {
		final List<T> output = new ArrayList<>();
		this.traverseInOrder(val -> {
			output.add(val);
		});
		return output;
	}
}
