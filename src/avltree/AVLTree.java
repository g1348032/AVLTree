/**
 * @author 30038637 Takuya Hasama 29/07/2021
 */
package avltree;

/*
 *  Java Program to Implement Self Balancing Binary Search Tree
 */

/* Class AVLTree */
public class AVLTree {

    Node root;

    /* Constructor */
    public AVLTree() {
        root = null;
    }

    /* Function to get height of node */
    private int height(Node t) {
        return t == null ? -1 : t.height;
    }

    /* Function to max of left/right node */
    private int max(int lHeight, int rHeight) {
        return lHeight > rHeight ? lHeight : rHeight;
    }

    /* Function to insert data */
    public void insert(String data) {
        root = insert(data, root);
    }

    /* Function to insert data recursively */
    private Node insert(String newValue, Node n) {
        if (n == null) {
            n = new Node(newValue);
        } else if (newValue.compareTo(n.data) < 0) {
            n.left = insert(newValue, n.left);
            if (height(n.left) - height(n.right) == 2) {
                if (newValue.compareTo(n.left.data) < 0) {
                    n = leftRotate(n);
                } else {
                    n = doubleWithLeftChild(n);
                }
            }
        } else if (newValue.compareTo(n.data) > 0) {
            n.right = insert(newValue, n.right);
            if (height(n.right) - height(n.left) == 2) {
                if (newValue.compareTo(n.right.data) > 0) {
                    n = rightRotate(n);
                } else {
                    n = doubleWithRightChild(n);
                }
            }
        } else
           ;  // Duplicate; do nothing
        n.height = max(height(n.left), height(n.right)) + 1;
        return n;
    }

    /* Function to remove data */
    public void delete(String data) {
        root = delete(data, root);
    }

    /* Function to remove data recursively */
    private Node delete(String value, Node dn) {
        if (dn == null) {
            System.out.print("Can't find the mechanical part");
            return null;
        }
        if (value == null ? dn.data == null : value.equals(dn.data)) {
            // Case 1: no children
            if (dn.left == null && dn.right == null) {
                return null;
            }
            // Case 2: only 1 child
            if (dn.right == null) {
                return dn.left;
            }
            if (dn.left == null) {
                return dn.right;
            }
            // Case 3: 2 children
            String smallestValue = findSmallestValue(dn.right);
            dn.data = smallestValue;
            dn.right = delete(smallestValue, dn.right);
            return dn;
        }
        if (value.compareTo(dn.data) < 0) {
            dn.left = delete(value, dn.left);
            return dn;
        } else {
            dn.right = delete(value, dn.right);
            return dn;

        }
    }

    private String findSmallestValue(Node root) {
        return root.left == null ? root.data : findSmallestValue(root.left);
    }

    /* Rotate binary tree node with right child */
    private Node rightRotate(Node n1) {
        Node n2 = n1.right;
        n1.right = n2.left;
        n2.left = n1;
        n1.height = max(height(n1.left), height(n1.right)) + 1;
        n2.height = max(height(n2.right), n1.height) + 1;
        return n2;
    }

    /* Rotate binary tree node with left child */
    private Node leftRotate(Node n2) {
        Node n1 = n2.left;
        n2.left = n1.right;
        n1.right = n2;
        n2.height = max(height(n2.left), height(n2.right)) + 1;
        n1.height = max(height(n1.left), n2.height) + 1;
        return n1;
    }

    /**
     * Double rotate binary tree node: first left child with its right child;
     * then node n3 with new left child
     */
    private Node doubleWithLeftChild(Node n3) {
        n3.left = rightRotate(n3.left);
        return leftRotate(n3);
    }

    /**
     * Double rotate binary tree node: first right child with its left child;
     * then node n1 with new right child
     */
    private Node doubleWithRightChild(Node n4) {
        n4.right = leftRotate(n4.right);
        return rightRotate(n4);
    }

    /* Functions to count number of nodes */
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node r) {
        if (r == null) {
            return 0;
        } else {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }

    /* Functions to search for an element */
    public boolean search(String val) {
        return search(root, val);
    }

    private boolean search(Node sn, String val) {
        boolean found = false;
        while ((sn != null) && !found) {
            String rval = sn.data;
            if (val.compareTo(rval) < 0) {
                sn = sn.left;
            } else if (val.compareTo(rval) > 0) {
                sn = sn.right;
            } else {
                found = true;
                break;
            }
            found = search(sn, val);
        }
        return found;
    }

    /* Function for inorder traversal */
    public void inorder() {
        inorder(root);
    }

    private void inorder(Node r) {
        if (r != null) {
            inorder(r.left);
            System.out.print(r.data + " ");
            inorder(r.right);
        }
    }

}
