public class Nodedouble 
{
	private Nodedouble left;
	private Nodedouble right;
	private int data;
	Nodedouble()
	{
		
	}
	Nodedouble(int data)
	{
		this.setData(data);
	}
	Nodedouble(int data,Nodedouble left,Nodedouble right)
	{
		this.setData(data);
		this.setLeft(left);
		this.setRight(right);
	}
	public Nodedouble getLeft() {
		return left;
	}
	public void setLeft(Nodedouble left) {
		this.left = left;
	}
	public Nodedouble getRight() {
		return right;
	}
	public void setRight(Nodedouble right) {
		this.right = right;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	
}
