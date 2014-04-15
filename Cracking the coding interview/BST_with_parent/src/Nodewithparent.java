public class Nodewithparent 
{
	private int data;
	private Nodewithparent left;
	private Nodewithparent right;
	private Nodewithparent parent;
	
	Nodewithparent() 
	{
		this.data = 0;
		this.left = null;
		this.right = null;
		this.parent = null;
				
	}
	Nodewithparent(int data) 
	{
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
				
	}
	Nodewithparent(int data,Nodewithparent left,Nodewithparent right,Nodewithparent parent) 
	{
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
				
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Nodewithparent getLeft() {
		return left;
	}
	public void setLeft(Nodewithparent left) {
		this.left = left;
	}
	public Nodewithparent getRight() {
		return right;
	}
	public void setRight(Nodewithparent right) {
		this.right = right;
	}
	public Nodewithparent getParent() {
		return parent;
	}
	public void setParent(Nodewithparent parent) {
		this.parent = parent;
	}
	

}
