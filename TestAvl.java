
/**
 * Class for testing the AVL-Tree
 *
 * @author Jimmy Lindstr�m
 */

public class TestAvl {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.add(15);tree.add(5); tree.add(3); tree.add(4);
        tree.add(6); tree.add(61); tree.add(62); tree.add(63);
        tree.add(25); tree.add(26); tree.add(10); tree.add(8);
        tree.add(14); tree.add(12); tree.add(11); tree.add(13);
        tree.add(2); tree.add(3); tree.add(1); tree.add(99);
        tree.add(101); tree.add(100); tree.root.printTree();

        System.out.println("\n-----------------------------------\n");

        tree.delete(10); tree.delete(99); tree.delete(15); tree.delete(100); tree.delete(13);
        tree.delete(6); tree.delete(3); tree.delete(1); tree.delete(2); tree.delete(61);
        tree.delete(62); tree.delete(63); tree.root.printTree();
        System.out.println("\n-----------------------------------\n");
        tree.inOrder(tree.root);

       /* int[] numbers = {
               15, 5, 3, 4, 6, 61, 62, 63, 25, 26,10, 8, 14, 12, 11, 13, 2, 3, 1, 99, 101, 100
        };
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Adding number " + numbers[i] + ":\n" +
                               "------------------\n\n");
            tree.add(numbers[i]);
            tree.root.printTree();
            System.out.println("\n-----------------\n\n");
        }

        System.out.println("\n");
        System.out.println("Deleting number 10:\n" +
                "------------------\n\n");
        tree.delete(10);
        tree.root.printTree();
        System.out.println("Deleting number 99:\n" +
                "------------------\n\n");
        tree.delete(99);
        tree.root.printTree();
        System.out.println("Deleting number 15:\n" +
                "------------------\n\n");
        tree.delete(15);
        tree.root.printTree();
        System.out.println("Deleting number 100:\n" +
                "------------------\n\n");
        tree.delete(100);
        tree.root.printTree();
        System.out.println("Deleting number 13:\n" +
                "------------------\n\n");
        tree.delete(13);
        tree.root.printTree();
        System.out.println("Deleting number 6:\n" +
                "------------------\n\n");
        tree.delete(6);
        tree.root.printTree();
        System.out.println("Deleting number 3:\n" +
                "------------------\n\n");
        tree.delete(3);
        tree.root.printTree();
        System.out.println("Deleting number 1:\n" +
                "------------------\n\n");
        tree.delete(1);
        tree.root.printTree();
        System.out.println("Deleting number 2:\n" +
                "------------------\n\n");
        tree.delete(2);
        tree.root.printTree();
        System.out.println("Deleting number 61:\n" +
                "------------------\n\n");
        tree.delete(61);
        tree.root.printTree();
        System.out.println("Deleting number 62:\n" +
                "------------------\n\n");
        tree.delete(62);
        tree.root.printTree();
        System.out.println("Deleting number 63:\n" +
                "------------------\n\n");
        tree.delete(63);
        tree.root.printTree();

*/
    }
}

