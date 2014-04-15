import java.util.ArrayList;
import java.util.Iterator;
public abstract class chartree 
{

	public static void main(String[] args) 
	{
		Trie trie = new Trie();
		trie.insert("sahil".toCharArray());
		trie.insert("ashu".toCharArray());
		trie.insert("pandu".toCharArray());
		trie.insert("vishal".toCharArray());
		trie.insert("vivek".toCharArray());
		//trie.display(trie.getRoot(),new ArrayList<Character>());
		ArrayList<ArrayList<String>> sorted = trie.sorttrie();
		Iterator<ArrayList<String>> iter = sorted.iterator();
		while(iter.hasNext())
		{
			Iterator<String> iternew = iter.next().iterator();
			//System.out.println(iter.next().toString());
			while(iternew.hasNext())
			{
				System.out.println(iternew.next());
			}
		}
	}

}
