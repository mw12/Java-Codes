import java.util.ArrayList;

public class Mailbox {
	public int impossible(String collection, String[] address)
	{
		ArrayList<Character> arrayList = new ArrayList<Character>();
		for (int i = 0; i < collection.length(); i++) 
			arrayList.add(i,collection.charAt(i));
		ArrayList<Character> arrayList2 = new ArrayList<Character>();
			int count=0;
		for (int i = 0; i < address.length; i++) 
		{
			for (int j = 0; j < arrayList.size(); j++) 
				arrayList2.add(j, arrayList.get(j));
			
			for (int j = 0; j < address[i].length(); j++) 
			{
				if (address[i].charAt(j)==' ')
					continue;
				else
				{
					if (arrayList2.contains(address[i].charAt(j))) 
						arrayList2.remove(Character.valueOf(address[i].charAt(j)));
			
					else
						{
						count++;
						break;
						}
				}
			}
			arrayList2.clear();
		}
		return count;
	}
	
	public static void main(String[] args) {
		Mailbox mailbox =  new Mailbox();
		String collection = "AAAAAAABBCCCCCDDDEEE123456789";
		String  address[] = {"123C","123A","123 ADA"};
		System.out.println(mailbox.impossible(collection, address));

	}

}
