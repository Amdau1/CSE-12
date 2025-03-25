import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PublicTester {
    MyBST<Integer, Integer> tree;

    @Before
    public void setup() {
        MyBST.MyBSTNode<Integer, Integer> root =
                new MyBST.MyBSTNode<>(4, 1, null);
        MyBST.MyBSTNode<Integer, Integer> two =
                new MyBST.MyBSTNode<>(2, 1, root);
        MyBST.MyBSTNode<Integer, Integer> six =
                new MyBST.MyBSTNode<>(6, 1, root);
        MyBST.MyBSTNode<Integer, Integer> one =
                new MyBST.MyBSTNode<>(1, 2, two);
        MyBST.MyBSTNode<Integer, Integer> three =
                new MyBST.MyBSTNode<>(3, 30, two);
        MyBST.MyBSTNode<Integer, Integer> five =
                new MyBST.MyBSTNode<>(5, 50, six);

        this.tree = new MyBST<>();
        this.tree.root = root;
        root.setLeft(two);
        root.setRight(six);
        two.setLeft(one);
        two.setRight(three);
        six.setLeft(five);
        tree.size = 6;
    }

    @Test
    public void testSuccessor() {
        MyBST.MyBSTNode<Integer, Integer> treeRoot = tree.root;
        assertSame(treeRoot.getRight().getLeft(), treeRoot.successor());
    }

    @Test
    public void testInsert() {
        Boolean check = false;
        MyBST.MyBSTNode<Integer, Integer> root = tree.root;
        tree.insert(10, 1);
        tree.insert(11, 1);
        tree.insert(12, 1);
        tree.insert(13, 1);
        assertEquals(10, root.getRight().getRight().getKey().intValue());
        assertEquals("size of tree", 10, tree.size);
        MyBST.MyBSTNode<Integer, Integer> curr = root;
        for(int i = 0; i < tree.size; i++){
            System.out.println(curr.getRight());
        }
        try{
            tree.insert(null,1);
        }
        catch(NullPointerException E){
            check = true;
        }
        assertTrue( check);
    }

    @Test
    public void testSearch() {
        assertEquals(1, tree.search(6).intValue());
        tree.insert(10, 6);
        assertNull(tree.search(100000));
        assertEquals(6, tree.search(10).intValue());
        tree.remove(10).intValue();
        assertNull(tree.search(10));
    }

    @Test
    public void testRemove() {
        MyBST.MyBSTNode<Integer, Integer> root = tree.root;
        assertNull(tree.remove(20));
        assertEquals(1, tree.remove(6).intValue());
        assertEquals(5, root.getRight().getKey().intValue());
        assertEquals("size of tree", 5, tree.size);
        assertEquals(50, tree.remove(5).intValue());
        assertEquals("size of tree", 4, tree.size);
    }

    @Test
    public void testInorder() {
        MyBST.MyBSTNode<Integer, Integer> root = tree.root;
        ArrayList<MyBST.MyBSTNode<Integer, Integer>> expectedRes =
                new ArrayList<>();
        expectedRes.add(root.getLeft().getLeft());
        expectedRes.add(root.getLeft());
        expectedRes.add(root.getLeft().getRight());
        expectedRes.add(root);
        expectedRes.add(root.getRight().getLeft());
        expectedRes.add(root.getRight());
        assertEquals(expectedRes, tree.inorder());
    }
}

