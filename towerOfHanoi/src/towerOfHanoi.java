public class towerOfHanoi 
{
	public void solvetower(int noOfDisks,String current,String auxilary,String resultant)
	{
		if(noOfDisks == 1)
			System.out.println("Move from stack " + current + " to stack " + resultant);
		else
		{
			solvetower(noOfDisks-1, current, resultant, auxilary);
			solvetower(1, current, auxilary, resultant);
			solvetower(noOfDisks-1, auxilary, current, resultant);
		}
	}
	public static void main(String[] args) 
	{
		towerOfHanoi tower = new towerOfHanoi();
		tower.solvetower(3, "current", "auxilary", "resultant");

	}

}
