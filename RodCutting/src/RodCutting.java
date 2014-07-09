import java.util.ArrayList;

public class RodCutting 
{
	int maxvalue = Integer.MIN_VALUE;
	ArrayList<Integer> rodcuts = null;
	public void maxvalue(int lengthleft,int prices[],int value,ArrayList<Integer> cuts)
	{
		if(lengthleft == 0)
			{
				if(value > maxvalue)
				{
					rodcuts = cuts;
					maxvalue = value;
				}
			}
		else
		{
			for (int i = 0; i < lengthleft; i++) 
			{
				ArrayList<Integer> temp = new ArrayList<Integer>(cuts);
				temp.add(i+1);
				maxvalue(lengthleft- (i+1), prices,value + prices[i],temp);
				
			}
		}
	}
	public static void main(String[] args) 
	{
		
		RodCutting cutting =  new RodCutting();
		int prices[] = {1,5,8,9,10,17,17,20};
		cutting.maxvalue(8	, prices,0,new ArrayList<Integer>());
		System.out.println("the max value is " + cutting.maxvalue + " and list is " + cutting.rodcuts);
		

	}

}
