package algos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T, BinaryTreeNode<T>> {
	public BinaryTreeNode<T> treeRoot;
	private final BinaryTreeNodeFactory<T> nodeFactory;

	BinarySearchTree(final BinaryTreeNodeFactory<T> nodeFactory) {
		this.nodeFactory = nodeFactory;
	}

	BinarySearchTree(final BinaryTreeNodeFactory<T> nodeFactory, final BinaryTreeNode<T> root) {
		this.nodeFactory = nodeFactory;
		this.treeRoot = root;
	}

	@Override
	public void setRoot(final BinaryTreeNode<T> root) {
		this.treeRoot = root;
	}

	@Override
	public BinaryTreeNode<T> getRoot() {
		return treeRoot;
	}

	public void insert(final T val) {
		insert(treeRoot, val);
	}

	public void insert(final BinaryTreeNode<T> root, final T val) {
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
