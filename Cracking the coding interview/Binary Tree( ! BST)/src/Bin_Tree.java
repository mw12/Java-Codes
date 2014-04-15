
public class Bin_Tree 
{
	public static void main(String[] args) 
	{
		int values[] = {1,2,3,4,5,6,7};
		Binary_Tree tree = new Binary_Tree();
		tree.setRoot(tree.insertminheight(values, 0, values.length-1));
		tree.inorder(tree.getRoot());
		Nodebinary temp = new Nodebinary();
		Integer highestlevel = tree.deepestleftleaf(tree.getRoot(),false, 0, 0,temp);
		System.out.println(temp.getData());
		System.out.println("the deepest left node leaf's level is " + highestlevel);
	}

}
