public class Nodemodified 
{
	private int data;
	private Nodemodified next;
	private boolean visited;
	Nodemodified() 
	{
		this.setData(0);
		this.setNext(null);
		this.setVisited(false);
	}
	Nodemodified(int data)
	{
		this.setData(data);
		this.setNext(null);
		this.setVisited(false);
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Nodemodified getNext() {
		return next;
	}
	public void setNext(Nodemodified next) {
		this.next = next;
	}
	

	
}
