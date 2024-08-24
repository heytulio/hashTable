package linkedList;

public class Node {

	private int info;
	private Node prox;

	public Node(int info) {
		this.info = info;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public Node getProx() {
		return prox;
	}

	public void setProx(Node prox) {
		this.prox = prox;
	}
}
