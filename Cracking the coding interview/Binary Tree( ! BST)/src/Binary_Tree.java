import java.util.ArrayList;

public class Binary_Tree 
{
	private Nodebinary root;

	public Nodebinary getRoot() {
		return root;
	}

	public void setRoot(Nodebinary root) {
		this.root = root;
	}
	
	Binary_Tree() 
	{
		this.setRoot(new Nodebinary());
	}
	Binary_Tree(int data)
	{
		this.setRoot(new Nodebinary(data));
	}
	public Nodebinary insertminheight(int array[],int low,int high)
	{
		if(low>high)
		{
			return null;
		}
		else
		{
			int mid = (high+low)/2;
			return new Nodebinary(array[mid], insertminheight(array, low, mid-1), insertminheight(array, mid+1, high));
		}
	}
	public void inorder(Nodebinary root)
	{
		if(root!=null)
		{
			inorder(root.getLeft());
			System.out.println(root.getData());
			inorder(root.getRight());
			
		}
	}

	public Nodebinary search(Nodebinary root,int key)
	{
		if(root!=null)
		{
			if(root.getData()==key)
				return root;
			else
			{
				Nodebinary left = search(root.getLeft(),key);
				Nodebinary right = search(root.getRight(),key);
				if(left!=null)
					return left;
				else if(right!=null)
					return right;
				else
					return null;
				
			}
		}
		else
			return null;
	}
	public Nodebinary LCA(Nodebinary root,int first,int second)//least common ancestor
	{
		return commonancestor(root, search(root, first), search(root,second));
	}
	public Nodebinary commonancestor(Nodebinary root,Nodebinary first,Nodebinary second)
	{
		String left = whichside(root, first, "center");
		String right = whichside(root, second, "center");
		if(left.equals(right))
		{
			if(left=="left")
				return commonancestor(root.getLeft(), first, second);
			if(left=="right")
				return commonancestor(root.getRight(), first, second);
			else//center
				return root;
		}
		else
			return root;
	}
	public String whichside(Nodebinary root,Nodebinary key,String side)
	{
		if(root!=null)
		{
			if(root==key)
				return side;
			String left = whichside(root.getLeft(), key,"left");
			String right = whichside(root.getRight(), key,"right");
			if(left!="null")
				return "left";
			else if(right!="null")
				return "right";
			else
				return "null";
		}
		else
			return "null";
	}

	public boolean issubtree(Nodebinary sup,Nodebinary sub)
	{
		if(sup==null)
			return false;
		if(sub==null)
			return true;
		else
		{
			if(sup.getData()==sub.getData())
			{
				return matchtree(sup.getLeft(),sub.getLeft()) && matchtree(sup.getRight(), sub.getRight());
			}
			else
				return issubtree(sup.getLeft(), sub) || issubtree(sup.getRight(), sub);
		}
	}
	public boolean matchtree(Nodebinary sup,Nodebinary sub)
	{
		//System.out.println("called ");
		if(sup==null )
		{
			if(sub==null)
				return true;
			else
				return false;
		}
		else
		{
			if(sub==null)
				return true;
			else
			{
				if(sub.getData()==sup.getData())
					return matchtree(sup.getLeft(),sub.getLeft()) && matchtree(sup.getRight(), sub.getRight());
				else
					return false;
			}
		}
	}

	public void printpaths(Nodebinary root,int sum,ArrayList<Integer> list,int level)
	{
		if(root==null)
			return;
		int temp = sum;
		int data = root.getData();
		list.add(data);
		for(int i=level;i>=0;i--)
		{
			temp -= list.get(i);
			if(temp==0)
				printpath(list,i,level);
		}
		ArrayList<Integer> forleft = (ArrayList<Integer>) list.clone();
		ArrayList<Integer> forright = (ArrayList<Integer>)list.clone();
		
		printpaths(root.getLeft(), sum, forleft, level+1);
		printpaths(root.getRight(), sum, forright, level+1);
		
 	}
	public void printpath(ArrayList<Integer> list,int start,int end)
	{
		System.out.println("new path");
		for(int i=start;i<=end;i++)
		{
			System.out.print(list.get(i) + " ");
		}
		System.out.println("A path done");
	}

	//here we can clearly see that i passed a Nodebinary object's reference by value and changed the value of it in the 
	//below procedure ....result.setData(root.getData()) ..
	//but if i try this with the integer variable highestlevel this won't be possible because java is call by value
	//if u try to pass an Integer object than that is immutable..
	//the only way in java is to pass an array of size 1
	public int deepestleftleaf(Nodebinary root,boolean isleft,int level,int highestlevel,Nodebinary result)
	{
		if(root==null)
			return 0;
		if(isleft && root.getLeft()==null && root.getRight()==null)
		{
			if(level > highestlevel)
			{
				highestlevel = level;
				result.setData(root.getData());
			}
			return highestlevel;
		}
		else
		{
			return Math.max(deepestleftleaf(root.getLeft(), true, level+1, highestlevel,result),
					deepestleftleaf(root.getRight(), false, level+1, highestlevel,result));
		}
		
		
		
	}

}
