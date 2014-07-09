public class decToBin 
{


	public static void main(String[] args) 
	{
		int decimal = 1000;
		String binary = "0";
		int multiplier =1;
		while(decimal>0)
		{
			binary = String.valueOf((decimal%2)*multiplier + Integer.parseInt(binary));
			//System.out.println("binary is "+ binary);
			multiplier *= 10;
			decimal /=2;
		}
		System.out.println(binary);
	}

}
