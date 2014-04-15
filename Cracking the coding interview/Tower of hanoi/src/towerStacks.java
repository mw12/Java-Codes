
public class towerStacks 
{
	public void getsteps(int disks,Stack from,Stack auxilary,Stack to)
	{
		if (disks==1) 
		{
			to.push(from.pop().getData());
			System.out.println("move disk from "+ from +" to " + to);
		}
		else
		{
			getsteps(disks-1,from,to,auxilary);
			getsteps(1,from,auxilary,to);
			getsteps(disks-1,auxilary,from,to);
		}
	}
	public static void main(String[] args) 
	{
		int disks = 3;
		Stack from = new Stack(new int[]{3,2,1});
		Stack auxilary = new Stack();
		Stack to = new Stack();
		new towerStacks().getsteps(disks, from, auxilary, to);
		Node temp = to.getStackpointer();
		while(temp!=null)
		{
			System.out.println(temp.getData());
			to.pop();
			temp = to.getStackpointer();
		}
		
	}

}
