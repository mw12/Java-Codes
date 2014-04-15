public class AvlTree 
{
	public static void main(String[] args) 
	{
		int values[] = new int[]{3,2,8,1,5,4,9,7};
		Avl avl = new Avl(values);
		avl.insert(avl.getRoot(), 6);
		avl.inorder(avl.getRoot());
		System.out.println(avl.isbalanced(avl.getRoot()));
		
	}

}
