public class BST_link_list 
{
	private Nodedouble root;
	public BST_link_list() 
	{
		
	}
	BST_link_list(int data) 
	{
		this.setRoot(new Nodedouble(data));
	}
	BST_link_list(int data,int left,int right) 
	{
		this.setRoot(new Nodedouble(data,new Nodedouble(left),new Nodedouble(right)));
	}
	public Nodedouble getRoot() 
	{
		return root;
	}
	public void setRoot(Nodedouble root) 
	{
		this.root = root;
	}
	public Nodedouble bsttolist(Node tree)
	{
		if(tree==null)
			return null;
		else
		{
			return new Nodedouble(tree.getData(),bsttolist(tree.getLeft()),bsttolist(tree.getRight()));
		}
	}
	public void displaylist(Nodedouble node)
	{
		if(node!=null)
		{
			displaylist(node.getLeft());
			System.out.print(node.getData() + " ");
			displaylist(node.getRight());
			
		}
		
	}
	public static void main(String[] args)
	{
		int values[] = {20,8,22,4,12,10,14};
		BST bst = new BST(values);
		bst.inorder(bst.getRoot());
		BST_link_list list = new BST_link_list();
		list.setRoot(list.bsttolist(bst.getRoot()));
		System.out.println(list.getRoot().getData());
		list.displaylist(list.getRoot());
		System.out.println("working");
	}

}
