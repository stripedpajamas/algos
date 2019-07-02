package algos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<T extends Comparable<T>> {
	TreeNode<T> treeRoot;

	BinaryTree() {
	}

	BinaryTree(final TreeNode<T> root) {
		this.treeRoot = root;
	}

	public void insert(final T val) {
		insert(treeRoot, val);
	}

	public void insert(final TreeNode<T> root, final T val) {
		if (this.treeRoot == null) {
			this.treeRoot = new TreeNode<>(val);
			return;
		}

		if (val.compareTo(root.val) < 0) {
			// val belongs to the left of root
			if (root.left == null) {
				root.left = new TreeNode<>(val);
			} else {
				insert(root.left, val);
			}
		} else if (val.compareTo(root.val) > 0) {
			// val belongs to the right of root
			if (root.right == null) {
				root.right = new TreeNode<>(val);
			} else {
				insert(root.right, val);
			}
		}
	}

	public void insert(final List<T> vals) {
		for (final T val : vals) {
			insert(val);
		}
	}

	public void traverseInOrder(final Consumer<T> visit) {
		traverseInOrder(treeRoot, visit);
	}

	public void traverseInOrder(final TreeNode<T> root, final Consumer<T> visit) {
		if (root == null) {
			return;
		}
		traverseInOrder(root.left, visit);
		visit.accept(root.val);
		traverseInOrder(root.right, visit);
	}

	public List<T> toInorderList() {
		final List<T> output = new ArrayList<>();
		this.traverseInOrder(val -> {
			output.add(val);
		});
		return output;
	}
}
