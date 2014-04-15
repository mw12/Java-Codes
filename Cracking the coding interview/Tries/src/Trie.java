import java.util.ArrayList;
import java.util.Iterator;

public class Trie 
{
	private Node root;
	Trie()
	{
		this.setRoot(new Node());
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public void insert(char word[])
	{
		Node parent = this.getRoot();
		for (int i = 0; i < word.length; i++) 
		{
			if(parent.getchild(word[i])==null)
			{
				parent.setchild(new Node(word[i]),word[i]);
				parent = parent.getchild(word[i]);
			}
			else
			{
				parent = parent.getchild(word[i]);
			}
			if(i==word.length-1)
			{
				if(!parent.isWordend())
					parent.setWordend(true);
			}	
		}
	}
	public void display(Node root,ArrayList<Character> word)
	{
		if(root!=null)
		{
			if(root.getCharacter()!=null)
				word.add(root.getCharacter());
			if(root.isWordend())
			{
				Iterator<Character> iter = word.iterator();
				while(iter.hasNext())
					System.out.print(iter.next());
				System.out.println();
				
			}
			for(int i=0;i<root.getChild().length;i++)
				{
				display(root.getchild((char)(i+97)),(ArrayList<Character>) word.clone());
				}
		}
	}
	public ArrayList<ArrayList<String>> sorttrie()
	{
		ArrayList<ArrayList<String>> sorted  = new ArrayList<ArrayList<String>>();
		Node temp = null;
		for(int i=0;i<this.getRoot().getChild().length;i++)
		{
			temp = this.getRoot().getchild((char)(i+97)); 
			if(temp!=null)
			{
				sorted.add(sortchar(temp, new ArrayList<Character>(),new ArrayList<String>()));
			}
		}
		return sorted;
	}
	public ArrayList<String> sortchar(Node root,ArrayList<Character> word,ArrayList<String> words) 
	{
		if(root==null)
			return words;
		else
		{
			word.add(root.getCharacter());
			if(root.isWordend())
			{
				StringBuilder temp = new StringBuilder();
				Iterator<Character> iter = word.iterator();
				while(iter.hasNext())
				{
					temp.append(iter.next());
				}
				words.add(temp.toString());
			}
			for(int i=0;i<root.getChild().length;i++)
			{
				sortchar(root.getchild((char)(i+97)), (ArrayList<Character>) word.clone(), words);
				
			}
			return words;
		}
	}
}
