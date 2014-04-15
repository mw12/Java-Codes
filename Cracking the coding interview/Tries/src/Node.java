public class Node 
{
	private Character character;
	private Node child[];
	private boolean wordend = false;
	
	public boolean isWordend() {
		return wordend;
	}
	public void setWordend(boolean wordend) {
		this.wordend = wordend;
	}
	Node()
	{
		this.character = null;
		this.child = new Node[26];
	}
	Node(char character)
	{
		this.character = character;
		this.child = new Node[26];
	}
	Node(char character,Node values[])
	{
		this.character = character;
		for(int i=0;i<values.length;i++)
			this.child[i] = values[i];
	}
	public Character getCharacter() {
		return character;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}
	public Node[] getChild() {
		return child;
	}
	public void setChild(Node[] child) {
		this.child = child;
	}
	public void setchild(Node temp, char c) 
	{
		int index = (int)c  - 97;
		this.child[index] = temp;
		
	}
	public Node getchild(char c) 
	{
		int index = (int)c  - 97;
		return this.child[index];
		
	}
}
