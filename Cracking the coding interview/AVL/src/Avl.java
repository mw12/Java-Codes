import java.util.ArrayList;
import java.util.List;

public class Avl 
{
	private Node root;
	Avl()
	{
		this.setRoot(null);
	}
	Avl(int data)
	{
		this.setRoot(new Node(data));
	}
	Avl(int data,Node left,Node right,Node parent)
	{
		this.setRoot(new Node(data, left, right, parent));
	}
	Avl(int values[])
	{
		for (int i = 0; i < values.length; i++) 
		{
			
			insert(this.getRoot(),values[i]);
		}
	}
	public Node search(Node root,int key)
	{
		if(root==null)
			return null;
		if(root.getData()==key)
			return root;
		else
		{
			if(key<root.getData())
				return search(root.getLeft(),key);
			else
				return search(root.getRight(),key);
		}
	}
	public Node insert(Node root,int data)
	{
		if(root==null)
		{
		//	System.out.println("tree empty");
			this.setRoot(new Node(data));
			return this.getRoot();
		}
		else
		{
			//System.out.println("called with data as "+ data + " and root as " + root.getData());
			
			if(data<root.getData())
			{
				Node temp = new Node();
				if(root.getLeft()==null)
					{
					root.setLeft(new Node(data,null,null,root));
					temp = root.getLeft();
					}
				else
					temp =  insert(root.getLeft(),data);
				
				List<Node> parents = this.rotationrequired(temp);
				if(parents==null)
					return temp;
				else
				{
					this.performrotation(parents);
					return temp;
				}
			}
			else if(data>root.getData())
			{
				Node temp = new Node();
				if(root.getRight()==null)
					{
					root.setRight(new Node(data,null,null,root));
					temp =  root.getRight();
					}
				else
					temp =  insert(root.getRight(),data);
				//System.out.println("here");
				List<Node> parents = this.rotationrequired(temp);
				if(parents==null)
					return temp;
				else
				{
					this.performrotation(parents);
					return temp;
				}
			}
			else
			{
				System.out.println(root.getData());
				return null;
			}
		}
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public void inorder(Node root)
	{
		if(root!=null)
		{
			inorder(root.getLeft());
			System.out.println(root.getData());
			inorder(root.getRight());
		}
	}
	public void preorder(Node root)
	{
		if(root!=null)
		{
			System.out.println(root.getData());
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}
	public void postorder(Node root)
	{
		if(root!=null)
		{
			postorder(root.getLeft());
			postorder(root.getRight());
			System.out.println(root.getData());
		}
	}
	public int getheight(Node node)
	{
		if(node==null)
			return 0;
		else
			return 1+ (Math.max(getheight(node.getLeft()), getheight(node.getRight())));
	}
	public boolean isbalanced(Node node)
	{
		if(node ==null)
			return true;
		if(Math.abs(getheight(node.getLeft())-getheight(node.getRight()))>1)
			return false;
		else
			return true;
			
	}
	public List<Node> rotationrequired(Node node)
	{
		List<Node> parents = new ArrayList<Node>();
		while(node!=this.getRoot())
		{
			parents.add(node);
			if(!this.isbalanced(node))
				break; 
			node = node.getParent();
		}
		if(node==this.getRoot())
		{
			if(this.isbalanced(node))
				return null;
			else
			{
				parents.add(node);
				return parents;
				
			}
			
		}
		else
			return parents;
			
		
	}
	public void rotateleft(Node x,Node y)
	{
		System.out.println("rotating left " + x.getData() + " "+ y.getData());
		if(y.getParent().getLeft()==y)
			y.getParent().setLeft(x);
		else
			y.getParent().setRight(x);
		x.setParent(y.getParent());
		y.setParent(x);
		y.setRight(x.getLeft());
		if(x.getLeft()!=null)
			x.getLeft().setParent(y);
		x.setLeft(y);
		if(y==this.getRoot())
			this.setRoot(x);
					
	}
	public void rotateright(Node x,Node y)
	{
		System.out.println("rotating right " + x.getData() + " "+ y.getData());
		if(y.getParent().getLeft()==y)
			y.getParent().setLeft(x);
		else
			y.getParent().setRight(x);
		x.setParent(y.getParent());
		y.setParent(x);
		y.setLeft(x.getRight());
		if(x.getRight()!=null)
			x.getRight().setParent(y);
		x.setRight(y);
		if(y==this.getRoot())
			this.setRoot(x);
			
	}
	public void performrotation(List<Node> parents) 
	{
		int size = parents.size();
		Node z = parents.get(size-1);
		Node y = parents.get(size-2);
		Node x = parents.get(size-3);
		
		switch(whichcaseofrotation(x,y,z))
		{
			case 1://left left
					rotateright(y, z);
					break;
			
			case 2://left right
				rotateleft(x, y);
				rotateright(x,z);
				break;
			case 3://right right
				rotateleft(y,z);
				break;
			case 4://right left
				rotateright(x,y);
				this.inorder(this.getRoot());
				rotateleft(x,z);
				break;
				
		}
	}
	public int whichcaseofrotation(Node x,Node y,Node z)
	{
		if(z.getLeft()==y)//left
		{
			if(y.getLeft()==x)//left
			{
				return 1;
			}
			else//right
			{
				return 2;
			}
		}
		else//right
		{
			if(y.getRight()==x)//right
			{
				return 3;
			}
			else//left
			{
				return 4;
			}
		}
	}
}
