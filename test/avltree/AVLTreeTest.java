package avltree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author zyoco
 */
public class AVLTreeTest {

    public AVLTreeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of insert method, of class AVLTree.
     */
    @Test
    public void testInsert() {
        System.out.println("\ninsert");
        String data = "seats";
        AVLTree instance = new AVLTree();
        instance.insert(data);
        System.out.println(instance.countNodes());
        Assertions.assertFalse(instance.root.data.isEmpty());

    }

    /**
     * Test of delete method, of class AVLTree.
     */
    @Test
    public void testDelete() {
        System.out.println("\ndelete");
        String data = "seats";
        AVLTree instance = new AVLTree();
        instance.insert(data);
        System.out.println("inserted");
        System.out.println(instance.countNodes());
        Assertions.assertFalse(instance.root.data.isEmpty());
        instance.delete(data);
        System.out.println("deleted");
        System.out.println(instance.countNodes());
        int expResult = 0;
        int result = instance.countNodes();
        assertEquals(expResult, result);

    }

    /**
     * Test of countNodes method, of class AVLTree.
     */
    @Test
    public void testCountNodes() {
        System.out.println("countNodes");
        AVLTree instance = new AVLTree();
        int expResult = 0;
        int result = instance.countNodes();
        System.out.println(instance.countNodes());
        assertEquals(expResult, result); 
        String data = "new";
        instance.insert(data);
        int expResultTwo = 1;
        int resultTwo = instance.countNodes();
        assertEquals(expResultTwo, resultTwo);
        System.out.println(instance.countNodes());
    }

    /**
     * Test of search method, of class AVLTree.
     */
    @Test
    public void testSearch() {
        System.out.println("\n\nsearch");
        String val = "Takuya";
        String valTwo = "belts";
        AVLTree instance = new AVLTree();
        instance.insert("belts");
        boolean result = instance.search(val);
        boolean resultTwo = instance.search(valTwo);
        Assertions.assertFalse(result);
        Assertions.assertTrue(resultTwo);
    }

    /**
     * Test of inorder method, of class AVLTree.
     */
    @Test
    public void testInorder() {
        System.out.println("\ninorder");
        AVLTree instance = new AVLTree();
        instance.insert("nuts");
        instance.insert("bolts");
        instance.insert("gears");
        instance.inorder();
        Assertions.assertFalse(instance.root.data.isEmpty());
        Assertions.assertFalse(instance.root.data.contains("bolts"));
    }

}
