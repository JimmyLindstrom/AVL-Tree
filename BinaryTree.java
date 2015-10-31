
import java.util.NoSuchElementException;

/**
 * Class representing a Binary Search Tree with methods for inserting, deleting,
 * in-order traversal, finding minimum value etc.
 * 
 * @author Jimmy Lindstr�m
 *
 */

public class BinaryTree {
	protected TreeNode root;
	protected int size;

	/**
	 * Constructor for a binary tree, sets size to 0;
	 */
	public BinaryTree() {
		size = 0;
	}

	/**
	 * Method for adding a value to the tree, calling the insert method.
	 * 
	 * @param data the value to be added
	 */
	public void add(int data) {
		try {
			root = insert(root, new TreeNode(data));
			size++;
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Method for inserting a new Inlämmningsuppgift3.TreeNode in the tree.
	 * 
	 * @param current the root of the tree
	 * @param newNode the new node to be inserted
	 * @return the new root of the tree
	 * @throws Exception if value already exists
	 */
	private TreeNode insert(TreeNode current, TreeNode newNode) throws Exception {
		if (current == null) {
			return newNode;
		}
		if (current.getData() == newNode.getData()) {
			throw new Exception("The value already exists in the tree!");
		} else if (newNode.getData() < current.getData()) {
			current.setLeft(insert(current.getLeft(), newNode));
		} else if (newNode.getData() > current.getData()) {
			current.setRight(insert(current.getRight(), newNode));
		}
		return current;
	}

	/**
	 * Method for deleting a node, that calls the remove method. It sets the new
	 * root of the tree
	 * 
	 * @param data the value to be deleted from the tree
	 */
	public void delete(int data) {
        try {
            root = remove(root, data);
            size--;
        } catch (NoSuchElementException e) {
           System.out.println(e);
        }
	}

	/**
	 * Method for removing a node from the tree
	 * 
	 * @param current the root node
	 * @param dataToRemove the value you want to remove
	 * @return the new root of the tree
	 */
	private TreeNode remove(TreeNode current, int dataToRemove) {
		TreeNode nodeToRemove = find(current, dataToRemove);

		// If the value doesn't exist
		if (nodeToRemove == null) {
			throw new NoSuchElementException("Value does not exist in tree");
		}
		TreeNode parent = findParent(root, nodeToRemove.getData());
		// If the node to be removed is a leaf(no children)
		if (parent != null && nodeToRemove.isLeaf()) {
			if (parent.getLeft() == nodeToRemove) {
				parent.setLeft(null);
			} else if (parent.getRight() == nodeToRemove) {
				parent.setRight(null);
			}
			// if the node to be removed has one child
		} else if (nodeToRemove.getLeft() == null || nodeToRemove.getRight() == null) {

			if (parent != null) {

				TreeNode tempNode = nodeToRemove.getLeft() == null
						? nodeToRemove.getRight()
						: nodeToRemove.getLeft();
				if (parent.getLeft() == nodeToRemove) {
					parent.setLeft(tempNode);
				} else {
					parent.setRight(tempNode);
				}
			}
		// if the node to be removed has two children
		} else {
			TreeNode tempNode = findSuccessor(nodeToRemove);
			int value = tempNode.getData();
			delete(value);
			nodeToRemove.setData(value);
		}
		return current;

	}
	/**
	 * Method for finding a node with a specific value in the tree
	 * 
	 * @param current
	 *            the node from where you want to start your search
	 * @param dataToFind
	 *            the value you are searching for
	 * @return the node with the value you are searching for
	 */
	private TreeNode find(TreeNode current, int dataToFind) {
		if(current == null){
            return current;
        }
        if (current.getData() == dataToFind) {
            return current;
        }
		if (current.getData() > dataToFind) {
			return find(current.getLeft(), dataToFind);
        } else {
            return find(current.getRight(), dataToFind);
		}
	}
	
	 /**
     * Method for finding a parent node of a node with a specified value
     * @param current Node to start from.
     * @param dataToFind The data of the child who's parent we're looking for.
     * @return The parent node.
     */
    public TreeNode findParent(TreeNode current, int dataToFind) {
        if (current == null)
            return null;

        if ((current.getLeft() != null && dataToFind == current.getLeft().getData()) ||
            (current.getRight() != null && dataToFind == current.getRight().getData()))
            return current;

        if (dataToFind < current.getData())
            return findParent(current.getLeft(), dataToFind);
        else
            return findParent(current.getRight(), dataToFind);
    }

	/**
	 * Method for doing in-order traversal, meaning printing out all the values
	 * in ascending order
	 * 
	 * @param current the node from where you want the traversal to begin
	 */
	public void inOrder(TreeNode current) {
		if (current == null) {
			return;
		}
		inOrder(current.getLeft());
		System.out.println(current.getData() + " Have height: " + current.getHeight());
		inOrder(current.getRight());
	}

	/**
	 * Method for finding the successor to a node. The successor next bigger
	 * number in the tree
	 * 
	 * @param current node for which we want the successor
	 * @return the successor node
	 */
	public TreeNode findSuccessor(TreeNode current) {
		if (current == null) {
			return null;
		}
		// if node has a right child find minimum value of the right child
		if (current.getRight() != null) {
			return findMinimum(current.getRight());
		}
		return current;
	}

	/**
	 * Method for finding the smallest value in the tree rooted in the parameter
	 * current
	 * 
	 * @param current the root of the tree/subtree
	 * @return node with smallest value in the tree/subtree
	 */
	private TreeNode findMinimum(TreeNode current) {
		if (current == null) {
			return null;
		}
		if (current.getLeft() != null) {
			return findMinimum(current.getLeft());
		}
		return current;
	}
}
