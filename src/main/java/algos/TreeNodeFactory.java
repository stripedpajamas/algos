package algos;

public interface TreeNodeFactory<T extends Comparable<T>> {
  public TreeNode<T> fromValue(final T val);
}