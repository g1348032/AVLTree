/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

/**
 *
 * @author zyoco
 */

/* Class Node */
public class Node {

    Node left;
    Node right;
    String data;
    int height;

    public Node() {
        left = null;
        right = null;
        height = 0;
    }

    public Node(String v) {
        left = null;
        right = null;
        data = v;
        height = 0;
    }

}
