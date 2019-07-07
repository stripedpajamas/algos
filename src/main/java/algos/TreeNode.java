package algos;

public interface TreeNode<T extends Comparable<T>> {
  public T getVal();
  public void setVal(final T val);
  public TreeNode<T> getLeft();
  public TreeNode<T> getRight();
  public void setLeft(final TreeNode<T> left);
  public void setRight(final TreeNode<T> right);
}