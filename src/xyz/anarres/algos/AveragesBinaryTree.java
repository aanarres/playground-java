package xyz.anarres.algos;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * 
 Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
 *
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
public class AveragesBinaryTree {

	public static void main(String[] args) {
		// tests
		AveragesBinaryTree tree = new AveragesBinaryTree();
		
		// TreeNode node = new TreeNode (3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		// System.out.println("For 3 - 9, 20 - 15, 7: " + tree.averageOfLevels(node).toString());
		
		TreeNode node = new TreeNode(5, new TreeNode(2), new TreeNode(-3));
		System.out.println("For 5 --- 2, -3: " + tree.averageOfLevels(node).toString());
	}

	public List<Double> averageOfLevels(TreeNode root) {
		// traverse the thing, know the level, know the number of nodes at this level
		ArrayList<Integer> perLevel = new ArrayList<Integer>();
		ArrayList<Double> averages = new ArrayList<Double>();
		
		traverse(root, 0, averages, perLevel);
		System.out.println("Sums at each level: " + averages.toString());
		System.out.println("Number of elements per level: " + perLevel.toString());
		
		for (int i = 0; i <= averages.size() - 1; i++) {
			averages.set(i, averages.get(i)/perLevel.get(i));
		}
		
		return averages;
	}
	void traverse(TreeNode node, int level, ArrayList<Double> averages, ArrayList<Integer> perLevel) {
		// we're on level=0..
		if (averages.size() < level + 1) {
			averages.add(0.0);
			perLevel.add(0);
		}
		
		averages.set(level, averages.get(level) + node.val);
		perLevel.set(level, perLevel.get(level) + 1);
		
		if (node.left != null)
			traverse(node.left, level + 1, averages, perLevel);
		if (node.right != null)
			traverse(node.right, level + 1, averages, perLevel);
		
	}
}
