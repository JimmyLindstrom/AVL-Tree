package Inlämmningsuppgift3;

/**
 * Class representing a node in an AVL/BST Tree, and stores the value of the node
 * and its children(left, right) and the height of the node
 * 
 * @author Jimmy Lindstr�m
 *
 */

public class TreeNode {
	private int data;
	private TreeNode left;
	private TreeNode right;
	private int height;

	/**
	 * Constructor for the node taking one parameter, the value.
	 * @param data the value of the node
	 */

	public TreeNode(int data) {
		this.data = data;
		left = right = null;
		height = 0;
	}

	/**
	 * Method for fetching the value of a node
	 * @return the data the value of the node
	 */
	public int getData() {
		return data;
	}

	/**
	 * Method returning the left child of the node
	 * @return the left child of the node
	 */
	public TreeNode getLeft() {
		return left;
	}

	/**
	 * Method for setting the value of a node taking the value as parameter
	 * @param data the value to be set in the node
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * Method for setting the left child of the node, taking the new node as
	 * parameter
	 * @param left the left to set as child
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}

	/**
	 * Method returning the right child of the node
	 * @return the right child of the node
	 */
	public TreeNode getRight() {
		return right;
	}

	/**
	 * Method for setting the right child of the node, taking the new node as
	 * parameter
	 * @param right the right to set as child
	 */
	public void setRight(TreeNode right) {
		this.right = right;
	}


	/**Method for getting the height of a node
	 * 
	 * @return height of the node
	 */
	public int getHeight() {
		return height;
	}

	/**method for setting the height of a node, calculating it based on
     * the biggest height of the right and left child, and adding 1.
	 */
	public void setHeight() {
		int heightLeft = left != null ? left.getHeight() : -1;
		int heightRight = right != null ? right.getHeight() : -1;		
		
		height = Math.max(heightLeft, heightRight) +1;
	}

    /**Method returning the balance of a node.
     *
     * @return baalance of the node
     */
	public int getBalance(){
		
		int heightLeft = left != null ? left.getHeight() : -1;
		int heightRight = right != null ? right.getHeight() : -1;		
		
		return heightRight - heightLeft;
	}

	/**
	 * Method for checking if the node has NO children, if it's a leaf,
	 * returning true if node is a leaf, else false
	 */
	public boolean isLeaf() {
		return (right == null && left == null);
	}


	/**---------------------------------------
	 * Code to visualize the three
	 * ---------------------------------------
	 */

	public void printTree() {
		if (this.right != null) {
			right.printTree(true, "");
		}
		printNodeValue();
		if (left != null) {
			left.printTree(false, "");
		}
	}

	private void printTree(boolean isRight, String indent) {
		if (right != null) {
			right.printTree(true, indent + (isRight ? "        " : " |      "));
		}
		System.out.print(indent);
		if (isRight) {
			System.out.print(" /");
		} else {
			System.out.print(" \\");
		}
		System.out.print("----- ");
		printNodeValue();
		if (left != null) {
			left.printTree(false, indent + (isRight ? " |      " : "        "));
		}

	}

	private void printNodeValue() {
		System.out.print(data + "(" + this.height + ")");
		System.out.print('\n');
	}

}
