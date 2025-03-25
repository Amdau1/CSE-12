// DO NOT CHANGE THE METHOD NAMES

import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.*;

public class MyListIteratorCustomTester {
    private MyLinkedList listLen1, listLen2;
    private MyLinkedList.MyListIterator listLen1Iter, listLen2Iter;
    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test.
     */
    @Before
    public void setUp() throws Exception {
        listLen1 = new MyLinkedList();
        listLen1.add("Christine");
        listLen1Iter = listLen1.new MyListIterator();

        listLen2 = new MyLinkedList();
        listLen2.add("Paul");
        listLen2.add("Cao");
        listLen2Iter = listLen2.new MyListIterator();
    }

    /**
     * Aims to test the next() method when iterator is at end of the list 
     */
    @Test
    public void testNextEnd() {
        boolean cheecker = false;
        try{
            listLen1Iter.left = listLen1.head.getNext();
            listLen1Iter.right = listLen1.head.getNext().getNext();
            assertEquals("The element returned from calling next", "Christine",
                listLen1Iter.next());
            assertEquals("Index of iterator after 1 next()", 1, listLen1Iter.idx);
            assertTrue("Able to remove node", listLen1Iter.canRemoveOrSet);
            assertTrue("Direction is forward", listLen1Iter.forward);
        }
        catch(NoSuchElementException E){
            // fail();
            cheecker = true;
        }
        assertEquals(true, cheecker);
    }

    /**
     * Aims to test the previous() method when iterator is at the start of the 
     * list 
     */
    @Test
    public void testPreviousStart() {
        boolean checker = false;
        try{
            listLen1Iter.left = listLen1.head;
            listLen1Iter.right = listLen1.head.getNext();
            listLen1Iter.idx = 0;
            listLen1Iter.canRemoveOrSet = false;
            listLen1Iter.forward = true;
            assertEquals("The element returned from calling previous", "Christine",
                listLen1Iter.previous());
            assertEquals("Index of iterator after 0 previous()", 0,
                listLen1Iter.idx);
            assertTrue("Able to remove node", listLen1Iter.canRemoveOrSet);
            assertFalse("Direction is not forward", listLen1Iter.forward);
        }
        catch(NoSuchElementException E){
            checker = true;
            // fail();
        }
        assertEquals(true, checker);
    }

    /**
     * Aims to test the add(E e) method when an invalid element is added
     */
    @Test
    public void testAddInvalid() {
        boolean checker = false;
        try{
        listLen2Iter.add(null);
        assertEquals("Valid add left", "Paul",
        listLen2Iter.left.getElement());
        assertEquals("Valid add right", "Cao", 
        listLen2Iter.right.getElement());
        assertEquals("Index change after add", 1, listLen2Iter.idx);
        assertFalse("Cannot remove immediately after add",
        listLen2Iter.canRemoveOrSet);
        }
        catch(NullPointerException E){
            checker = true;
        }
        assertEquals(true, checker);
    }

    /**
     * Aims to test the set(E e) method when canRemoveOrSet is false
     */
    @Test
    public void testCantSet() {
        boolean checker = false;
        try{
        listLen2Iter.left = listLen2.head.getNext();
        listLen2Iter.right = listLen2.head.getNext().getNext();
        listLen2Iter.idx = 1;
        listLen2Iter.forward = true;
        listLen2Iter.canRemoveOrSet = false;

        listLen2Iter.set("Did it change?");
        assertEquals("Valid set when forward", "Did it change?", listLen2Iter.left.getElement());
        assertEquals("Valid set when forward, shouldn't change", "Cao",listLen2Iter.right.getElement());
        }
        catch(IllegalStateException E){
            checker = true;
        }
        assertEquals(true, checker);
    }


    /**
     * Aims to test the set(E e) method when an invalid element is set
     */
    @Test
    public void testSetInvalid() {
        boolean checker = false;
        try{
        listLen2Iter.left = listLen2.head.getNext();
        listLen2Iter.right = listLen2.head.getNext().getNext();
        listLen2Iter.idx = 1;
        listLen2Iter.forward = true;
        listLen2Iter.canRemoveOrSet = false;
        listLen2Iter.set(null);
        assertEquals("Valid set when forward", "Did it change?", listLen2Iter.left.getElement());
        assertEquals("Valid set when forward, shouldn't change", "Cao",listLen2Iter.right.getElement());
        }
        catch(NullPointerException E){
            checker = true;
        }
        assertEquals(true, checker);
    }

    /**
     * Aims to test the remove() method when canRemoveOrSet is false
     */
    @Test
    public void testCantRemove() {
        boolean checker = false;
        try{
        listLen2Iter.left = listLen2.head.getNext();
        listLen2Iter.right = listLen2.head.getNext().getNext();
        listLen2Iter.idx = 1;
        listLen2Iter.forward = true;
        listLen2Iter.canRemoveOrSet = false;

        listLen2Iter.remove();
        assertEquals("Valid remove when forward", null,
                listLen2Iter.left.getElement());
        assertEquals("Valid remove when forward, shouldn't change", "Cao",
                listLen2Iter.right.getElement());
        assertEquals("Index should decrement after removal", 0,
                listLen2Iter.idx);
        assertFalse("Prevent another remove or set",
                listLen2Iter.canRemoveOrSet);
        }
        catch(IllegalStateException E){
            checker = true;  
        }
        assertEquals(true, checker);
    }

    /**
     * Aims to tests the hasNext() method at the end of a list
     */
    @Test
    public void testHasNextEnd() {
        listLen2Iter.left = listLen2.head.getNext().getNext();
        listLen2Iter.right = listLen2.head.getNext().getNext().getNext();
        listLen2Iter.idx = 2;
        listLen2Iter.canRemoveOrSet = true;
        listLen2Iter.forward = true;
        assertFalse("call hasNext when there isn't a next node",
                listLen2Iter.hasNext());
    }

    /**
     * Aims to test the hasPrevious() method at the start of a list
     */
    @Test
    public void testHasPreviousStart() {
        assertFalse("call when there isn't a previous node",
        listLen2Iter.hasPrevious());
    }

    /**
     * Aims to test the previousIndex() method at the start of a list
     */
    @Test
    public void testPreviousIndexStart() {
        listLen2Iter.left = listLen2.head;
        listLen2Iter.right = listLen2.head.getNext();
        listLen2Iter.idx = 0;
        listLen2Iter.forward = true;
        listLen2Iter.canRemoveOrSet = false;
        assertEquals("Index after 2 next, no previous", -1,
                listLen2Iter.previousIndex());

    }

    /**
     * Aims to test the nextIndex() method at the end of a list
     */
    @Test
    public void testNextIndexEnd() {
        listLen2Iter.left = listLen2.tail.getPrev();
        listLen2Iter.right = listLen2.tail;
        listLen2Iter.idx = 2;
        listLen2Iter.forward = true;
        listLen2Iter.canRemoveOrSet = true;
        assertEquals("Index after 3 next", 2, listLen2Iter.nextIndex());
    }
}
