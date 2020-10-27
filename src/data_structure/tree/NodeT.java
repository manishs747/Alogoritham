package data_structure.tree;

public class NodeT<T extends Comparable<T>> {

	public T data;
	public NodeT<T> left, right;

	public NodeT(T data) {
		this.left = this.right = null;
		this.data = data;

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public NodeT<T> getLeft() {
		return left;
	}

	public void setLeft(NodeT<T> left) {
		this.left = left;
	}

	public NodeT<T> getRight() {
		return right;
	}

	public void setRight(NodeT<T> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Data " + data;
	}

}
