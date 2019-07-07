package algos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<T extends Comparable<T>> {
	public TreeNode<T> treeRoot;
	private final TreeNodeFactory<T> nodeFactory;

	BinaryTree(final TreeNodeFactory<T> nodeFactory) {
		this.nodeFactory = nodeFactory;
	}

	BinaryTree(final TreeNodeFactory<T> nodeFactory, final TreeNode<T> root) {
		this.nodeFactory = nodeFactory;
		this.treeRoot = root;
	}

	public void insert(final T val) {
		insert(treeRoot, val);
	}

	public void insert(final TreeNode<T> root, final T val) {
		if (this.treeRoot == null) {
			this.treeRoot = nodeFactory.fromValue(val);
			return;
		}

		if (val.compareTo(root.getVal()) < 0) {
			// val belongs to the left of root
			if (root.getLeft() == null) {
				root.setLeft(nodeFactory.fromValue(val));
			} else {
				insert(root.getLeft(), val);
			}
		} else if (val.compareTo(root.getVal()) > 0) {
			// val belongs to the right of root
			if (root.getRight() == null) {
				root.setRight(nodeFactory.fromValue(val));
			} else {
				insert(root.getRight(), val);
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
