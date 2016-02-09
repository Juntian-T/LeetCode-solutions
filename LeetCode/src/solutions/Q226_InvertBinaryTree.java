package solutions;

public class Q226_InvertBinaryTree {

	//Didn't know how to deal with the return value here, so my first approach was
	//to write a helper function that returns nothing 
    public TreeNode invertTree(TreeNode root) {
    	invertTreeHelper(root);
    	return root;
    }
	
    public void invertTreeHelper(TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    	
    	if (root.left != null) {
    		invertTreeHelper(root.left);
    	}
    	if (root.right != null) {
    		invertTreeHelper(root.right);
    	}	
    }
    
    
    //Apparently I was doing extra work above, so here is the new implementation
    //Note in the one above: I did the work and the recurse, but this one let the recursion do the work
    public TreeNode invertTree2(TreeNode root) {
    	if (root == null) {
    		return null;
    	}
    	TreeNode temp = root.right;
    	root.right = invertTree2(root.left);
    	root.left = invertTree2(temp);
    	
    	return root;
    }
    
	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		TreeNode a4 = new TreeNode(4);
		TreeNode a5 = new TreeNode(5);
		TreeNode a6 = new TreeNode(6);
		TreeNode a7 = new TreeNode(7);
		TreeNode a8 = new TreeNode(8);
		TreeNode a9 = new TreeNode(9);
		
		a1.left = a2;
		a1.right = a3;

		a2.left = a4;
		a2.right = a5;

		a3.left = a6;
		a3.right = a7;

		a4.left = a8;
		a4.right = a9;
		
		Q226_InvertBinaryTree q = new Q226_InvertBinaryTree();
		q.invertTree2(a1);
	}

}
