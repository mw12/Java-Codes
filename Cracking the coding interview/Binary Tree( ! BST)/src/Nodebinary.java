public class Nodebinary 
{
	private int data;
	private Nodebinary left;
	private Nodebinary right;
	Nodebinary() 
	{
		this.data = 0;
		this.left = null;
		this.right = null;
	}
	Nodebinary(int data) 
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
	Nodebinary(int data,Nodebinary left,Nodebinary right) 
	{
		this.data = data;
		this.left = left;
		this.right =right;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Nodebinary getLeft() {
		return left;
	}
	public void setLeft(Nodebinary left) {
		this.left = left;
	}
	public Nodebinary getRight() {
		return right;
	}
	public void setRight(Nodebinary right) {
		this.right = right;
	}
}
