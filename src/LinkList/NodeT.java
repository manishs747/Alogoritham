package linklist;

public class NodeT<T> {
	public T data;
	public NodeT<T> next;
    public NodeT() {
    	this.data = null;
    	this.next = null;
			}
    
    public NodeT(T data,NodeT<T> node) {
    	this.data = data;
    	this.next = node;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public NodeT<T> getNode() {
		return next;
	}

	public void setNode(NodeT<T> node) {
		this.next = node;
	}
  
}

