public class Node 
{
	private int data;
	private Node left;
	private Node right;
	Node()
	{
		this.setData(0);
		this.left=null;
		this.right = null;
	}
	Node(int data)
	{
		this.setData(data);
		this.left = null;
		this.right = null;
	}
	Node(int data,Node left,Node right)
	{
		this.setData(data);
		this.setLeft(left);
		this.setRight(right);
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
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
