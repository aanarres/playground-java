package xyz.anarres.leetcode.dailychallenge;

/**
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d.
 * The root node is at depth 1.
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with
 * value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new 
 * left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that 
 * means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the 
 * original tree is the new root's left subtree.
 * 
 * Notes
 * The given d is in range [1, maximum depth of the given tree + 1].
 * The given binary tree has at least one tree node.
 * 
 *     4
     /   \
    2     6
   / \   / 
  3   1 5 
 */
public class RowToTree {

	public static void main(String[] args) {
		// some tests
		/*   4
	       /   \
	      2     6
	     / \   / 
	    3   1 5 
		*/
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2, new TreeNode(3), new TreeNode(1));
		root.right = new TreeNode(6, new TreeNode(5), null);
		
		int v = 1; int d = 2; // insert nodes with value=1 at depth 2; root is depth 1
		/*
		 *        4
      			 / \
     			1   1
    		   /     \
   			  2       6
  			 / \     / 
 			3   1   5
		 */
		
		RowToTree tree = new RowToTree();
		// tree.addDepths(root, 1);
		
		System.out.println("here");
		root = tree.addOneRow(root, v, d);
		System.out.println(root.toString());
		
		/*
		 * 
		 */
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
		v = 5; d = 4; // depth 4, we have maxdepth=3 here
		tree.addOneRow(root, v, d);
		
		/*
		 * 4 / 2 / 3, 1   / 6 / 5
		 */
		root = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), new TreeNode(6, new TreeNode(5), null));
		v = 1; d = 1;
		tree.addOneRow(root, v, d);
	}

	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if (root == null)
			return null;
		
		// we traverse the tree, until we reach the current d (or not reach it if it's maxdepth+1)
		TreeNode newRoot = traverse(root, 1, v, d); // may be the same, may not be; if null, the old root is needed
		
		return (newRoot == null ? root : newRoot);
	}
	TreeNode traverse(TreeNode node, int k, int v, int d) {
		if (node == null)
			return null;
		
		if (d == 1) {
			// we have to insert a new root
			TreeNode newNode = new TreeNode(v, node, null);
			return newNode;
		}
		
		if (k + 1 > d)
			return null; // "this will never happen"(tm)

		if (k + 1 == d) {
			// we will be at the right spot
			// we'll insert UNDER node
			TreeNode oldLeft = node.left;
			TreeNode oldRight = node.right;
			if (oldLeft != null ) {
				// node had a left subtree
				TreeNode newNode = new TreeNode(v, oldLeft, null);
				node.left = newNode;
			}
			else {
				node.left = new TreeNode(v);
			}
			if (oldRight != null) {
				// node had a right subtree
				TreeNode newNode = new TreeNode(v, null, oldRight);
				node.right = newNode;
			}
			else {
				node.right = new TreeNode(v);
			}
			return null;
		}
		if (k < d - 1) {
			// we're not there yet, or not this time
			traverse(node.left, k+1, v, d);
			traverse(node.right, k+1, v, d);
		}
		return null;
	}
	
	// just messing around; this method isn't used
	void addDepths(TreeNode node, int k) {
		if (node == null)
			return;
		
		node.depth = k;
		addDepths(node.left, k+1);
		addDepths(node.right, k+1);
	}
}

/**
 *  Definition for a binary tree node.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	int depth;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}