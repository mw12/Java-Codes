
public class PackingBallsDiv2 
{
	
	public int minPacks(int R, int G, int B)
	{
		int packets = 0;
		packets += R / 3;
		R = R % 3;
		packets += G / 3;
		G = G % 3;
		packets += B / 3;
		B = B % 3;
		System.out.println("packets till now are " + packets);
		int array[] = new int[3];
		array[R]++;
		array[G]++;
		array[B]++;
		if(array[0]==3)
			return packets;
		else if (array[0]==2)
		{
			return packets +1;
		}
		else if (array[2]==2 || array[2]==3) 
		{
			return packets +2;
		}
		else if (array[0]==1 && array[1]== 1 && array[2]==1) 
		{
			return packets +2;
		}
		else if (array[1]==2 && array[2]==1) 
		{
			return packets +2;
		}
		else
			return packets +1;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PackingBallsDiv2 ballsDiv2 = new PackingBallsDiv2();
		System.out.println(ballsDiv2.minPacks(1,2,5));
	}

}
