package undirected;
public class vertices 
{
	private int data;
	private Edge head;
	private vertices linkdown;
	private String color = "white";
	private vertices parent;
	vertices()
	{
		this.data = 0;

	}
	vertices(int data)
	{
		this.data = data;
	}
	vertices(int data,Edge head)
	{
		this.data = data;
		this.head = head;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Edge gethead() {
		return head;
	}
	public void sethead(Edge head) {
		this.head = head;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public vertices getParent() {
		return parent;
	}
	public void setParent(vertices parent) 
	{
		this.parent = parent;
	}
	public vertices getLinkdown() {
		return linkdown;
	}
	public void setLinkdown(vertices linkdown) {
		this.linkdown = linkdown;
	}
	public Edge append(int data)
	{
		Edge temp = this.gethead();
		if(temp==null)
		{
			this.sethead(new Edge(data));
			return this.gethead();
		}
		while(temp.getNext()!=null)
		{
			temp = temp.getNext();
		}
		temp.setNext(new Edge(data));
		return temp.getNext();
	}
}
