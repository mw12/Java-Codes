
public class targetsum 
{


	public boolean getcombination(int array[],int index,int sumtillnow,int currentnumber,int targetsum,String combination)
	{
		//System.out.println("combination is " + combination);
//		if(currentnumber==67)
//			System.out.println("here");
		if(sumtillnow==targetsum)
		{
			System.out.println("True: \n"+ combination );
			return true;
		}
		else if(sumtillnow > targetsum)
		{
			return false;
		}
		else
		{
			if(index>=array.length)
				return false;
			else
			{
				String buffer =  new String(combination);
				int indexofplus = buffer.lastIndexOf("+");
				int	 increasedsum  = 0;
				if(indexofplus == -1)
				{
					buffer = new String(String.valueOf(currentnumber*10 + array[index]));
					
				}
				else
				{
					buffer = buffer.substring(0, indexofplus);
					buffer = new String(new StringBuffer(buffer).append("+" + (currentnumber*10 + array[index])));
					increasedsum = Integer.parseInt(new StringBuffer(String.valueOf(currentnumber)).append(array[index]).toString());
				}
				
				return 
				getcombination(array, index+1, sumtillnow+array[index], array[index], targetsum,new StringBuffer(combination).append("+"+ array[index]).toString())
				||
				getcombination(array, index+1,sumtillnow-currentnumber+increasedsum,increasedsum, targetsum,buffer);
			}
			
		}
	}
	public static void main(String[] args) 
	{
		int array[] = {5,5};
		targetsum target = new targetsum();
		if(!target.getcombination(array, 0, 0, 0, 5,new String("")))
			System.out.println("False");
		//System.out.println(new String("sahila").substring(1,4));

	}

}
