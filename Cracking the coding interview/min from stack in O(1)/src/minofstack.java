//we need to design a stack which can push pop and return min of the stack in O(1)
public class minofstack 
{

	public static void main(String[] args) 
	{
		Stackwithmin stack = new Stackwithmin();
		stack.push(5);
		stack.push(3);
		stack.push(4);
		stack.pop();
		System.out.println("the min is "+ stack.getmin());

	}

}
