import java.util.ArrayList;
import java.util.Iterator;
public class BST {
	public Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	BST() {
		this.setRoot(null);
	}

	BST(int root) {
		this.setRoot(new Node(root));
	}

	BST(int values[]) {
		for (int i = 0; i < values.length; i++) {
			insert(this.getRoot(), values[i]);
		}
	}

	public void insert(Node root, int data) {
		if (root == null) {
			this.setRoot(new Node(data));
		} else {
			if (root.getData() >= data)// left subtree
			{
				if (root.getLeft() == null) {
					root.setLeft(new Node(data));
				} else
					insert(root.getLeft(), data);

			} else {
				if (root.getRight() == null)
					root.setRight(new Node(data));
				else
					insert(root.getRight(), data);
			}

		}

	}

	public void preorder(Node root) {
		if (root != null) {
			System.out.println(root.getData());
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.getLeft());
			System.out.println(root.getData());
			inorder(root.getRight());
		}
	}

	public void postorder(Node root) {
		if (root != null) {
			preorder(root.getLeft());
			preorder(root.getRight());
			System.out.println(root.getData());
		}
	}

	public Node search(Node root, int key) {
		if (root != null) {
			if (root.getData() == key) {
				return root;
			} else {
				if (root.getData() >= key)
					return search(root.getLeft(), key);
				else
					return search(root.getRight(), key);
			}

		}
		return null;
	}

	public ArrayList<Node> levelordertraversal(Node root) {
		ArrayList<Node> queue = new ArrayList<Node>();
		if (root != null)
			queue.add(root);
		int index = 0;
		while ((index + 1) <= queue.size()) {
			Node temp = queue.get(index);
			if (temp.getLeft() != null)
				queue.add(temp.getLeft());
			if (temp.getRight() != null)
				queue.add(temp.getRight());
			index++;
		}
		return queue;

	}

	public ArrayList<ArrayList<Node>> makelistlevels(Node root) {
		ArrayList<ArrayList<Node>> alllinklists = new ArrayList<ArrayList<Node>>();
		ArrayList<Node> queue = new ArrayList<Node>();
		if (root != null)
			queue.add(root);
		int index = 0;
		while (index + 1 <= queue.size()) {
			int parentsatlevel = queue.size() - index;
			int start = index;
			ArrayList<Node> level = new ArrayList<Node>();
			while (start < queue.size()) {
				level.add(queue.get(start));
				start++;
			}
			alllinklists.add(level);
			Iterator<Node> iter = level.iterator();
			while (iter.hasNext()) {
				Node temp = iter.next();
				if (temp.getLeft() != null)
					queue.add(temp.getLeft());
				if (temp.getRight() != null)
					queue.add(temp.getRight());
			}
			index += parentsatlevel;
		}
		return alllinklists;

	}

	public int getmaxdepth(Node root) {
		if (root == null)
			return 0;
		return 1 + Math.max(getmaxdepth(root.getLeft()),
				getmaxdepth(root.getRight()));

	}

	public int getmindepth(Node root) {
		if (root == null)
			return 0;
		return 1 + Math.min(getmindepth(root.getLeft()),
				getmindepth(root.getRight()));
	}

	public boolean isbalanced(Node root) {
		// if difference of height is <= 1 then it's balanced otherwise not
		return (getmaxdepth(root) - getmindepth(root) <= 1);
	}

	public void heightofnode(Node root) {

		if (root != null) {
			System.out.println("the height of " + root.getData() + " is "
					+ getmaxdepth(root));
			heightofnode(root.getLeft());
			heightofnode(root.getRight());
		}
	}

	public void inordersuccessor(Node root, Stack s)// the number just greater
													// than the given number
	{
		// using stack
		if (root != null) {
			inordersuccessor(root.getLeft(), s);
			s.push(root.getData());
			inordersuccessor(root.getRight(), s);
		}

	}

	public ArrayList<Node> spiralorder(Node root) {
		if (root == null)
			return null;
		ArrayList<Node> queue = new ArrayList<Node>();
		int index = 0;

		queue.add(root);
		int direction = 1;
		while (index + 1 <= queue.size()) 
		{
			// System.out.println("index is "+ index);
			int parentsatlevel = queue.size() - index;
			// System.out.println("parents at level is "+ parentsatlevel);
			int start = index;
			Node temp = null;
			for (int i = start; i < start + parentsatlevel; i++) 
			{
				if (direction == 1)// add left first
				{
					temp = queue.get(i);
					if (temp.getLeft() != null)
						queue.add(temp.getLeft());
					if (temp.getRight() != null)
						queue.add(temp.getRight());
				} else {
					// System.out.println("right side ");
					temp = queue.get(i);
					if (temp.getRight() != null)
						queue.add(temp.getRight());
					if (temp.getLeft() != null)
						queue.add(temp.getLeft());

				}
			}
			index += parentsatlevel;
			if (direction == 1)
				direction = 2;
			else
				direction = 1;
		}
		return queue;
	}

	public Node mirror(Node root) {
		if (root == null)
			return null;
		else {
			Node temp = new Node(root.getData());
			temp.setLeft(mirror(root.getRight()));
			temp.setRight(mirror(root.getLeft()));

			return temp;
		}
	}
	
	public void preorderstack()
	{
		Node node = root;
		java.util.Stack<Node> st = new java.util.Stack<Node>();
		while(st.size()!=0 || node!=null)
		{
			//System.out.println(node.getData());
			if(node!=null)
			{
				System.out.print(node.getData() + " ");
				if(node.getRight()!=null)
				{
					st.push(node.getRight());
				}
				node = node.getLeft();
			}
			else
			{
				node = st.pop();
			}
		}
	}
	
	public void inorderstack()
	{
		Node node = root;
		if (root==null)
		{
			System.out.println("tree is empty");
		}
		java.util.Stack<Node> st = new java.util.Stack<Node>();
		while(st.size()!=0 || node!=null)
		{
			if(node!=null)
			{
				st.push(node);
				node = node.getLeft();
			}
			else
			{
				Node parent = st.pop();
				System.out.print(parent.getData() + " ");
				node = parent.getRight();
			}
		}
		System.out.println();
	}
	
	public void postorderstack()
	{
		Node node = root;
		java.util.Stack<Node> st = new java.util.Stack<Node>();
		while(st.size()!=0 || node!=null)
		{
			if(node!=null)
			{
				
				if(node.getRight()!=null)
					st.push(node.getRight());
				st.push(node);
				node = node.getLeft();
			}
			else
			{
				Node popped = st.pop();
//				/System.out.println("popped is "+ popped.getData());
				if(st.size()>0 && popped.getRight()==st.peek())
				{
					//System.out.println("here for " + st.peek().getData());
					Node right = st.pop();
					st.push(popped);
					node = right;
				}
				else
				{
					System.out.print(popped.getData() + " ");
					node = null;
				}
			}
		}
		System.out.println(); 
	}
}
