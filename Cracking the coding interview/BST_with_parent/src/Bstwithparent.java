import java.util.ArrayList;
import java.util.List;

public class Bstwithparent 
{
	private Nodewithparent root;	
	public Nodewithparent getRoot() {
		return root;
	}
	public void setRoot(Nodewithparent root) {
		this.root = root;
	}
	Bstwithparent() 
	{
		this.root = null;
	}
	Bstwithparent(int data)
	{
		this.setRoot(new Nodewithparent(data));
	}
	Bstwithparent(int values[])
	{
		for (int i = 0; i < values.length; i++)
		{
			insert(this.getRoot(), values[i]);
		}
	}
	public void insert(Nodewithparent root,int data)
	{
		if(root==null)
		{
			this.setRoot(new Nodewithparent(data));
		}
		else
		{
			if(root.getData()>=data)
			{
				if(root.getLeft()==null)
				{
					root.setLeft(new Nodewithparent(data, null, null, root));
				}
				else
					insert(root.getLeft(), data);
			}
			else
			{
				if(root.getRight()==null)
				{
					root.setRight(new Nodewithparent(data, null, null, root));
					
				}
				else
					insert(root.getRight(), data);
			}
		}
	}
	public void preorder(Nodewithparent root)
	{
		if(root!=null)
		{
			System.out.print(root.getData() + " ");
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}
	public void inorder(Nodewithparent root)
	{
		if(root!=null)
		{
			inorder(root.getLeft());
			System.out.print(root.getData() + " ");
			inorder(root.getRight());
		}
	}
	public void postorder(Nodewithparent root)
	{
		if(root!=null)
		{
			postorder(root.getLeft());
			postorder(root.getRight());
			System.out.print(root.getData() + " ");
		}
	}
	public Nodewithparent search(Nodewithparent root,int key)
	{
		if(root!=null)
		{
			if(root.getData()==key)
			{
				return root;
			}
			else
			{
				if(root.getData()>=key)
					return search(root.getLeft(),key);
				else
					return search(root.getRight(),key);
			}
			
		}
		return null;
	}
	public ArrayList<Nodewithparent> levelordertraversal(Nodewithparent root)
	{
		ArrayList<Nodewithparent> queue = new ArrayList<Nodewithparent>();
		if(root!=null)
			queue.add(root);
		int index = 0;
		while((index+1)<=queue.size())
		{
			Nodewithparent temp = queue.get(index);
			if(temp.getLeft()!=null)
				queue.add(temp.getLeft());
			if(temp.getRight()!=null)
				queue.add(temp.getRight());
			index++;
		}
		return queue;
		
	}
	public Nodewithparent inordersuccesor(int key)
	{
		Nodewithparent temp = search(this.getRoot(), key);
		if(temp.getRight()!=null)
		{
			System.out.println("here");
			temp = temp.getRight();
			while(temp.getLeft()!=null)
			{
				temp= temp.getLeft();
			}
			return temp;
		}
		else
		{
			//System.out.println(temp!=this.getRoot());
			while(temp.getParent().getLeft()!=temp && temp!=this.getRoot())
			{
				temp = temp.getParent();
			}
			if(temp.getParent().getData()>key)
				return temp.getParent();
			else
				return null;
		}
	}
	public Nodewithparent inorderpredecessor(int key)
	{
		Nodewithparent found = this.search(this.getRoot(), key);
		if(found.getLeft()!=null)//return rightmost of the left subtree
		{
			Nodewithparent temp = found.getLeft();
			while(temp.getRight()!=null)
			{
				temp = temp.getRight();
			}
			return temp;
		}
		else
		{
			while(found.getParent().getRight()!=found && found!=this.getRoot())
			{
				found = found.getParent();
			}
			if(found.getParent().getData()<key)
				return found.getParent();
			else
				return null;//left most node as key
		}
	}
	public boolean delete(int key)
	{
		Nodewithparent found = search(this.getRoot(), key);
		if(found==null)
			return false;
		else
		{
			if(found.getRight()==null)
			{
				if(found.getLeft()==null)//leaf node
				{
					if(found.getParent().getLeft()==found)//left child of parent
					{
						found.getParent().setLeft(null);
					}
					else
					{
						found.getParent().setRight(null);
					}
				}
				else//left is not null and right is null
				{
					if(found.getParent().getLeft()==found)//left child of parent
					{
						found.getParent().setLeft(found.getLeft());
					}
					else
						found.getParent().setRight(found.getLeft());
				}
					
			}
			else//right not null
			{
				if(found.getLeft()==null)//leaf node
				{
					if(found.getParent().getLeft()==found)//left child of parent
					{
						found.getParent().setLeft(found.getRight());
					}
					else
						found.getParent().setRight(found.getRight());
				}
				else//both not null
				{
					Nodewithparent successor = found.getRight();
					while(successor.getLeft()!=null)
					{
						successor = successor.getLeft();
					}
					if(successor.getParent().getLeft()==successor)
						successor.getParent().setLeft(successor.getRight());
					else
						successor.getParent().setRight(successor.getRight());
					
					found.setData(successor.getData());
				}
			}
			return true;
		}
	}
	public Nodewithparent maketreeprein(List<Integer> prevalues,List<Integer> invalues)
	{
		if(prevalues==null)
		{
			return null;
		}
		if(prevalues.size() != invalues.size())
		{
			System.out.println("arrays passed are not of same size");
			return null;
		}
	
		List<Integer> leftpre  = null;
		List<Integer> rightpre = null;
		List<Integer> leftin   = null;
		List<Integer> rightin  = null;
		int root = prevalues.get(0);//root
		int position = invalues.indexOf(root);
		int leftelements = invalues.subList(0, position).size();
		if(leftelements!=0)
		 {
			leftpre = prevalues.subList(1, leftelements+1);
			leftin = invalues.subList(0, position);
		 }
		
			 
		int rightelements;
		if(position+1>=invalues.size())
			rightelements = 0;
		else
			rightelements = invalues.subList(position+1, invalues.size()).size();
		
		if(rightelements!=0)
			{
			rightpre = prevalues.subList(leftelements+1,prevalues.size());
			rightin = invalues.subList(leftelements+1,invalues.size() );
			}
			
		
		return new Nodewithparent(root, 
				maketreeprein(leftpre,leftin),
				maketreeprein(rightpre,rightin),
				null);
		
	}
	public Nodewithparent maketreeprepost(List<Integer> prevalues,List<Integer> postvalues)
	{
		if(prevalues.size()!=postvalues.size())
		{
			System.out.println("Ambigous inputs");
			return null;
		}
		if(prevalues.size()==1)
		{
			return new Nodewithparent(prevalues.get(0));
		}
		else if(prevalues.size()==3)
		{
			return new Nodewithparent(postvalues.get(2), new Nodewithparent(postvalues.get(0)),
					new Nodewithparent(postvalues.get(1)), null);
		}
		else
		{
			int key = prevalues.get(1);
			int position = postvalues.indexOf(key);
			List<Integer> leftpre = prevalues.subList(1, position+2);
			List<Integer> leftpost = postvalues.subList(0, position+1);
			List<Integer> rightpre = prevalues.subList(position+2, prevalues.size());
			List<Integer> rightpost = postvalues.subList(position+1, postvalues.size()-1);
						
			return new Nodewithparent(prevalues.get(0), maketreeprepost(leftpre, leftpost), maketreeprepost(rightpre, rightpost), null);
		}
		
	}

}
