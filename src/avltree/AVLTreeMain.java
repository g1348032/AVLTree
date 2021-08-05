/**
 * @author 30038637 Takuya Hasama 29/07/2021
 */
package avltree;

import java.util.Scanner;

/**
 *
 * @author zyoco
 */
public class AVLTreeMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Creating object of AVLTree */
        AVLTree tree = new AVLTree();
        System.out.println("SelfBalancingBinarySearchTree Test\n");
        tree.insert("nuts");
        tree.insert("bolts");
        tree.insert("gears");
        tree.insert("springs");
        tree.insert("wheels");
        tree.insert("belts");
        tree.insert("pulleys");
        tree.insert("bumpers");
        tree.insert("windows");
        tree.insert("tyres");

        char ch;
        /*  Perform tree operations  */
        try {
            do {
                System.out.println("\nSelfBalancingBinarySearchTree Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. search");
                System.out.println("3. delete");
                System.out.println("4. Display nodes");

                int choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter a mechanical part to insert");
                        tree.insert(scan.next());
                        break;
                    case 2:
                        System.out.println("Enter a mechanical part to search");
                        System.out.println("Search result : " + tree.search(scan.next()));
                        break;
                    case 3:
                        System.out.println("Enter a mechanical part to delete");
                        tree.delete(scan.next());
                        break;
                    case 4:
                        System.out.println("Nodes = " + tree.countNodes());
                        break;
                    default:
                        System.out.println("Wrong Entry \n ");
                        break;
                }

                /*  Display tree  */
                System.out.print("\nIn order : ");
                tree.inorder();

                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);

                while (ch != 'y' && ch != 'n') {
                    ch = scan.next().charAt(0);
                }
            } while (ch != 'n');

        } catch (Exception e) {
            System.out.println("Exception came up\n" + e);
        }

    }
}
