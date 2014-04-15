import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;


public class BridgeSort {

	
	@SuppressWarnings("rawtypes")
	class Card implements Comparable
	{

		Integer  suit;
		Integer value;
		public Card(int suit,int value) 
		{
			this.suit = suit;
			this.value = value;

		}
		@Override
		public int compareTo(Object o) {
			Card card = (Card)o;
			if (this.suit!=card.suit) {
				return this.suit-card.suit;
			}
			else
				return value.compareTo(card.value); 
			
			
		}
		public String toString()
		{
			return suit + "" + value;
		}
		
		
		
	}
	public String sortedHand(String hand)
	{
		HashMap<Character, Integer> suitmap =  new HashMap<Character, Integer>();
		suitmap.put('C', 0);
		suitmap.put('D', 1);
		suitmap.put('H', 2);
		suitmap.put('S', 3);
		
		HashMap<Character, Integer> valuemap = new HashMap<Character, Integer>();
		valuemap.put('T',10);
		valuemap.put('J',11);
		valuemap.put('Q',12);
		valuemap.put('K',13);
		valuemap.put('A',14);
		
		Card card[] = new Card[hand.length()/2];
		int count=0;
		int j=1;
		for (int i = 0; i < hand.length();i+=2,j+=2) 
		{
			Character suit = hand.charAt(i);
			Character value = hand.charAt(j);
			if ((int)value >60) {
				card[count] = new Card(suitmap.get(suit), valuemap.get(value));
			}
			else
				card[count] = new Card(suitmap.get(suit),Character.getNumericValue(value));
			
			count++;
		}
		Arrays.sort(card);
		StringBuilder builder =  new StringBuilder();
		
		for (int i = 0; i < card.length; i++) 
		{
			builder.append(getsuit(suitmap, card[i].suit));
			if (card[i].value>9) {
				builder.append(getvalue(valuemap, card[i].value));
			}
			else
				builder.append(card[i].value);
			
			
		}
		return builder.toString();
		
	}
	public char getvalue(HashMap<Character, Integer > valuemap,int value)
	{
		for (Entry<Character, Integer> card:valuemap.entrySet()) 
		{
			if (card.getValue()==value) {
				return card.getKey();
			}
			
		}
		return (Character)null;
	}
	public char getsuit(HashMap<Character, Integer> suitmap,int value)
	{
		for(Entry<Character, Integer> card:suitmap.entrySet())
		{
			if (card.getValue()==value) {
				return card.getKey();
			}
		}
		return (Character) null;
	}
	public static void main(String[] args) {
		BridgeSort bridgeSort =  new BridgeSort();
		String hand = "H3SAHA";
		System.out.println(bridgeSort.sortedHand(hand));

	}

}
