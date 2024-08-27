package linkedList;

public class LinkedList {
	
	private Node ref;
	private int tam = 0;
	
	public LinkedList () {}
	
	public void insert(String info) {
		Node no = new Node(info);
		if(isEmpty()) {
			ref = no;
			tam++;
			return; 
		}
		Node aux = ref;
		ref = no;
		ref.setProx(aux);
		tam++;
		return;
	}

	public boolean remove(String info) {
		if(isEmpty()) {
			System.out.println("lista vazia");
			return false;
		}
		for(Node n = ref; n != null; n = n.getProx()) {
			if(n == ref) {
				if(n.getInfo().contentEquals(info)) {
					ref = n.getProx();
					tam--;
					return true;
				}
			}
			if(n.getProx() != null) {
				if(n.getProx().getInfo().contentEquals(info)) {
					n.setProx(n.getProx().getProx());
					tam--;
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
		
		for(Node n = ref; n != null; n = n.getProx()) if(n.getInfo().contentEquals(info)) return true;
		
		return false;
	}
	
	public String[] getValues(){
		if(isEmpty()) {
			return null;
		}
		String[] values = new String[tam];
		int i = 0;
		for(Node n = ref; n != null; n = n.getProx()) {
			values[i] = n.getInfo();
			i++;
		}
		return values;
	}
	
	public int length() {
		return tam;
	}
}	