public class Node {
	private int data;
	private Node parent;
	private Node left;
	private Node right;

	Node() {
		this.setData(0);
		this.setLeft(null);
		this.setRight(null);
		this.setParent(null);

	}

	Node(int data) {
		this.setData(data);
		this.setLeft(null);
		this.setRight(null);
		this.setParent(null);
	}

	Node(int data, Node left, Node right, Node parent) {
		this.setData(data);
		this.setLeft(left);
		this.setRight(right);
		this.setParent(parent);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
