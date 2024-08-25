package linkedList;

public class LinkedList {
	
	private Node ref;
	
	public LinkedList () {}
	
	public void insert(String info) {
		Node no = new Node(info);
		if(isEmpty()) {
			ref = no;
			return; 
		}
		Node aux = ref;
		ref = no;
		ref.setProx(aux);
		return;
	}

	public boolean remove(String info) {
		if(isEmpty()) {
			System.out.println("lista vazia");
			return false;
		}
		for(Node n = ref; n != null; n = n.getProx()) {
			if(n == ref) {
				if(n.getInfo() == info) {
					ref = n.getProx();
					return true;
				}
			}
			if(n.getProx() != null) {
				if(n.getProx().getInfo() == info) {
					n.setProx(n.getProx().getProx());
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isEmpty() {
		return ref == null;
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.print("lista vazia");
			return;
		}
		for(Node i = ref; i != null; i = i.getProx()) {
			System.out.print(i.getInfo() + " ");
		}
	}
	
	public boolean find(String info) {
		if(isEmpty()) return false;
		
		for(Node n = ref; n != null; n = n.getProx()) if(n.getInfo() == info) return true;
		
		return false;
	}
}	
