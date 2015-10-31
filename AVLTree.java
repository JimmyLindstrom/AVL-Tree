
/**
 * Class representing an AVL-Tree extending the BinaryTree-class.
 *
 * @author Jimmy Lindström
 */

public class AVLTree extends BinaryTree {

    public AVLTree() {
        super();
    }

    /**
     * Method for adding a value to the tree, calling the insert method.
     *
     * @param data the value to be added
     */
    @Override
    public void add(int data) {
        super.add(data);
        TreeNode parent = findParent(root, data);
        if(parent != null){
            parent.setHeight();
            balanceTree(parent);
        }
    }



    /**
     * Method for deleting a node, that calls the remove method. It sets the new
     * root of the tree
     *
     * @param data the value to be deleted from the tree
     */
    @Override
    public void delete(int data) {
        TreeNode parent = findParent(root, data);
        super.delete(data);
        if (parent == null){
            TreeNode successor = findSuccessor(root);
            balanceTree(successor);
        }else{
            parent.setHeight();
            balanceTree(parent);
        }
    }

    /**Method for checking the balance of the tree after inserting/deleting
     * It calls the methods for rotating left/right if unbalanced
     *
     * @param current the node from where the balancing should start
     * @return balanced tree
     */
    private TreeNode balanceTree(TreeNode current) {
        if(current == null)
            return current;

        int balance = current.getBalance();
        // if tree is unbalanced
        if (balance > 1 || balance < -1) {

            // if it is left-heavy
            if (balance < 0) {
                // if it is left-right-heavy
                if (current.getLeft().getBalance() > 0)
                    rotateLeft(current.getLeft());
                // if it is left-left-heavy
                rotateRight(current);

                // if it is right-heavy
            } else {
                // if it is right-left-heavy
                if (current.getRight().getBalance() < 0)
                    rotateRight(current.getRight());
                // if it is right-right-heavy
                rotateLeft(current);
            }
        }
        //when the node is balanced move upp towards the root to check balance
        TreeNode parent = findParent(root, current.getData());
        if(parent != null) {
            parent.setHeight();
            balanceTree(parent);
        }

        return current;
    }

    /**Method for balancing the tree by doing a left rotation
     *
     * @param current the unbalanced node
     * @return the balanced tree
     */
    private TreeNode rotateRight(TreeNode current) {
        TreeNode parent = findParent(root, current.getData());
        TreeNode leftChild = current.getLeft();
        TreeNode rightChild = leftChild.getRight();

        leftChild.setRight(current);
        current.setLeft(rightChild);

        if (parent == null){
            root = leftChild;
        }
        if(parent != null && parent.getLeft() == current){
            parent.setLeft(leftChild);
        }else if(parent != null && parent.getRight() == current){
            parent.setRight(leftChild);
        }

        current.setHeight();
        leftChild.setHeight();

        return leftChild;
    }

    /**Method for balancing tree by doing a right rotation
     *
     * @param current the unbalanced node
     * @return the balanced tree
     */
    private TreeNode rotateLeft(TreeNode current) {
        TreeNode parent = findParent(root, current.getData());
        TreeNode rightChild = current.getRight();
        TreeNode leftChild = rightChild.getLeft();

        rightChild.setLeft(current);
        current.setRight(leftChild);
        //if current is the root
        if (parent == null){
            root = rightChild;
        }else if(parent != null && parent.getLeft() == current){
            parent.setLeft(rightChild);
        }else if (parent != null && parent.getRight() == current){
            parent.setRight(rightChild);
        }
        current.setHeight();
        rightChild.setHeight();

        return rightChild;
    }

}
