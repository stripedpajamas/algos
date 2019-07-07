package algos;

public interface TreeNode<T extends Comparable<T>, Self> {
  public T getVal();
  public void setVal(final T val);
  public Self getLeft();
  public Self getRight();
  public void setLeft(final Self left);
  public void setRight(final Self right);
}