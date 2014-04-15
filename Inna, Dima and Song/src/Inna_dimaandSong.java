import java.util.ArrayList;
import java.util.Scanner;

public class Inna_dimaandSong {
	private int joy =0;
	
	public int getJoy() {
		return joy;
	}
	public void setJoy(int joy) {
		this.joy = joy;
	}
	public int amountofJoy(int volumes[],int total[])
	{
		for (int i = 0; i < total.length; i++) 
		{
			
				ArrayList<Integer> result = getbestcombo(volumes[i], total[i]);
				joy += result.get(0) * result.get(1);
			
		}
		return getJoy();
	}
	public ArrayList<Integer> getbestcombo(int volume,int total)
	{
		int maxproduct = Integer.MIN_VALUE;
		int combomember = 0;
		for (int i = 1; i <= volume; i++) 
		{
			for (int j = 1; j <= volume ; j++) 
			{
				if(j*i > maxproduct && i+j==total)
				{
					combomember = i;
				}
			}
			
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		if(combomember==0)
		{
			temp.add(1);
			temp.add(-1);
		}
		
		temp.add(combomember);
		temp.add(total-combomember);
		//System.out.println("returning "+ temp.get(0) + " and " + temp.get(1));
		return temp;
	}
	public static void main(String[] args) 
	{
		Inna_dimaandSong dimaandSong = new Inna_dimaandSong();
		Scanner scan =  new Scanner(System.in);
		int noofnotes = scan.nextInt();
		int volumes[] = new int[noofnotes];
		int total[] =  new int[noofnotes];
		for (int i = 0; i < noofnotes; i++) 
		{
			volumes[i] = scan.nextInt();
		}
		for (int i = 0; i < noofnotes; i++) 
		{
			total[i] = scan.nextInt();
		}
		System.out.println(dimaandSong.amountofJoy(volumes, total));
		scan.close();
	}

}
