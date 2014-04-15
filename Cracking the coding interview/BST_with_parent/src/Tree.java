import java.util.Arrays;
public class Tree 
{
	public static void main(String[] args) 
	{
		int values[] = {15,14,19,12,13,11,20,21,16,18,17};
 		Bstwithparent tree = new Bstwithparent(values);
 	
 		System.out.println("in order is");
 		tree.inorder(tree.getRoot());
 		System.out.println("\npre order is");
 		tree.preorder(tree.getRoot());
 		System.out.println("\npost order is");
 		tree.postorder(tree.getRoot());
 		 	
 		
 		Integer pre[] = new Integer[]{15,14,12,11,13,19,16,18,17,20,21};
 		Integer invalues[] = new Integer[]{11,12,13,14,15,16,17,18,19,20,21};
 				
 		Nodewithparent treemade = tree.maketreeprein(Arrays.asList(pre),Arrays.asList(invalues));
 		System.out.println("\nnew tree");
 		tree.inorder(treemade);
 		
 		
 		Integer prefull[] = new Integer[]{4,2,1,3,6,5,8,7,9};
 		Integer postfull[] = new Integer[]{1,3,2,5,7,9,8,6,4};
 		
 		Nodewithparent fully = tree.maketreeprepost(Arrays.asList(prefull),Arrays.asList(postfull));
 		System.out.println("\nfull tree only");
 		tree.inorder(fully);
	}

}
