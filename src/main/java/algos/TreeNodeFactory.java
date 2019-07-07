package algos;

public interface TreeNodeFactory<T extends Comparable<T>, Self> {
  public TreeNode<T, Self> fromValue(final T val);
}