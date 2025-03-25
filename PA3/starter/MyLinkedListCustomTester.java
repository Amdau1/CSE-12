
/**
 * IMPORTANT: Do not change the method headers. Your tests will be run against
 * good and bad implementations of MyLinkedList. You will only receive points
 * if your test passes when run on a good implementation and fails for the
 * corresponding bad implementation.
 */

import static org.junit.Assert.*;
import org.junit.*;

public class MyLinkedListCustomTester {
	private MyLinkedList<Integer> emptyIntegerList;
    private MyLinkedList<String> threeStringList;
    private String[] strData = {"CSE 12", "Paul Cao", "Christine Alvarado"};

	// Optional: add test variables here

	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */
	@Before
	public void setUp() throws Exception {
		emptyIntegerList = new MyLinkedList<Integer>();
        threeStringList = new MyLinkedList<>();
		// Optional: add setup here
	}
	private void populateLinkedList() {
        MyLinkedList<String>.Node node0 =  
            this.threeStringList.new Node(this.strData[0]);
        MyLinkedList<String>.Node node1 =  
            this.threeStringList.new Node(this.strData[1]);
        MyLinkedList<String>.Node node2 =  
            this.threeStringList.new Node(this.strData[2]);

        this.threeStringList.head.next = node0;
        node0.prev = this.threeStringList.head;
        node0.next = node1;
        node1.prev = node0;
        node1.next = node2;
        node2.prev = node1;
        node2.next = this.threeStringList.tail;
        this.threeStringList.tail.prev = node2;
        this.threeStringList.size = 3;
    }

	/**
	 * Aims to test the add(E data) method with a valid argument.
	 */
	@Test
	public void testCustomAdd() {
		try{
		assertTrue(null, this.emptyIntegerList.add(10));
        assertEquals("New node should be accessible from head", 
            Integer.valueOf(10), this.emptyIntegerList.head.next.data);
        assertEquals("New node should be accessible from tail", 
            Integer.valueOf(10), this.emptyIntegerList.tail.prev.data);
        // assertEquals("Size of the LinkedList should be updated", 
        //     1, this.emptyIntegerList.size);
        // assertSame("Make sure the referece from head and tail are the same", 
        //     this.emptyIntegerList.head.next, this.emptyIntegerList.tail.prev);
        // assertSame("Added node should have correct previous pointer",
        //     this.emptyIntegerList.head.next.prev, this.emptyIntegerList.head);
        // assertSame("Added node should have the correct next pointer",
        //     this.emptyIntegerList.head.next.next, this.emptyIntegerList.tail);
		// // TODO: add your test here
		// this.emptyIntegerList.add(12);
		// assertEquals("New node should be accessible from head", 
        //     Integer.valueOf(12), this.emptyIntegerList.head.next.next.data);
		// assertEquals("New node should be accessible from tail", 
        //     Integer.valueOf(12), this.emptyIntegerList.tail.prev.data);
		// 	assertEquals("Check size is updated", 2, this.			emptyIntegerList.size);
		// this.emptyIntegerList.add(13);
		// assertEquals("New node should be accessible from head", 
        //     Integer.valueOf(13), this.emptyIntegerList.head.next.next.next.data);
		// assertEquals("New node should be accessible from tail", 
        //     Integer.valueOf(13), this.emptyIntegerList.tail.prev.data);
		// 	assertEquals("Check size is updated", 3, this.			emptyIntegerList.size);
		}
		catch(Exception E){
			fail();
		}

		
	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the beginning of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToStart() {
		// TODO: add your test here
		this.emptyIntegerList.add(0, 12);
        assertEquals("Check head reference is updated",
            Integer.valueOf(12), this.emptyIntegerList.head.next.data);
			this.emptyIntegerList.add(0, 15);
		assertEquals("Check head reference is updated",
			Integer.valueOf(15), this.emptyIntegerList.head.next.data);
        assertEquals("Check tail reference is updated", 
            Integer.valueOf(12), this.emptyIntegerList.tail.prev.data);
        assertEquals("Check size is updated", 2, this.			emptyIntegerList.size);
        assertSame("Added node should have correct previous pointer",
            this.emptyIntegerList.head.next.prev, this.emptyIntegerList.head);
        assertSame("Added node should have the correct next pointer",
            this.emptyIntegerList.head.next.next.next, this.emptyIntegerList.tail);
	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the middle of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToMiddle() {
		try{
			this.emptyIntegerList.add(0, 12);
			this.emptyIntegerList.add(1, 13);
			this.emptyIntegerList.add(2, 14);
			this.emptyIntegerList.add(3, 15);
			this.emptyIntegerList.add(4, 16);
			this.emptyIntegerList.add(2, 17);
			assertEquals("Check head reference is updated",
				Integer.valueOf(12), this.emptyIntegerList.head.next.data);
			assertEquals("Check next pointer is updated",
				Integer.valueOf(17), this.emptyIntegerList.head.next.next.next.data);
			assertEquals("Check next pointer is updated",
				Integer.valueOf(14), this.emptyIntegerList.head.next.next.next.next.data);
			assertEquals("Check prev reference is updated",
				Integer.valueOf(17), this.emptyIntegerList.tail.prev.prev.prev.prev.data);
			assertEquals("Check prev reference is updated",
				Integer.valueOf(13), this.emptyIntegerList.tail.prev.prev.prev.prev.prev.data);
			assertEquals("Check size is updated", 6, this.	emptyIntegerList.size);
			assertEquals("Check tail reference is updated", 
            Integer.valueOf(16), this.emptyIntegerList.tail.prev.data);
			int test = this.emptyIntegerList.get(2);
			assertEquals(17, test);
		}
		catch(Exception E){
			fail();
		}
		// TODO: add your test here
		

	}

	/**
	 * Aims to test the remove(int index) method. Remove from an empty list.
	 */
	@Test
	public void testCustomRemoveFromEmpty() {
		boolean checking = false;
		try{
		this.emptyIntegerList.remove(2);
		}
		catch(IndexOutOfBoundsException E){
			checking = true;
		}
		assertEquals("Check size is updated", 0, this.emptyIntegerList.size);
		assertEquals(true, checking);
		// TODO: add your test here
	}

	/**
	 * Aims to test the remove(int index) method.
	 * Remove a valid argument from the middle of MyLinkedList.
	 */
	@Test
	public void testCustomRemoveFromMiddle() {
		boolean checking = false;
		try{
		this.emptyIntegerList.add(0, 12);
		this.emptyIntegerList.add(1, 13);
		this.emptyIntegerList.add(2, 14);
		this.emptyIntegerList.add(3, 15);
		this.emptyIntegerList.add(4, 16);
		this.emptyIntegerList.add(5, 17);
		int test = this.emptyIntegerList.remove(3);
		assertEquals(15, test);
		assertEquals("Check size is updated", 5, this.emptyIntegerList.size);
		assertEquals("Check head reference is updated",
			Integer.valueOf(12), this.emptyIntegerList.head.next.data);
		assertEquals("Check next pointer is updated",
			Integer.valueOf(16), this.emptyIntegerList.head.next.next.next.next.data);
		assertEquals("Check prev reference is updated",
			Integer.valueOf(14), this.emptyIntegerList.tail.prev.prev.prev.data);
		assertEquals("Check tail reference is updated", 
            Integer.valueOf(17), this.emptyIntegerList.tail.prev.data);
		int test1 = this.emptyIntegerList.remove(1);
		assertEquals(13, test1);
		assertEquals("Check size is updated", 4, this.emptyIntegerList.size);
		assertEquals("Check head reference is updated",
			Integer.valueOf(12), this.emptyIntegerList.head.next.data);
		assertEquals("Check tail reference is updated", 
            Integer.valueOf(17), this.emptyIntegerList.tail.prev.data);
		int test2 = this.emptyIntegerList.remove(1);
		assertEquals(14, test2);
		assertEquals("Check size is updated", 3, this.emptyIntegerList.size);
		assertEquals("Check head reference is updated",
			Integer.valueOf(12), this.emptyIntegerList.head.next.data);
		assertEquals("Check tail reference is updated", 
			Integer.valueOf(17), this.emptyIntegerList.tail.prev.data);
		// this.emptyIntegerList.add(3, 15);
		// this.emptyIntegerList.add(4, 16);
		// this.emptyIntegerList.add(5, 17);
		// this.emptyIntegerList.add(6, 18);
		// int test = this.emptyIntegerList.remove(2);
		// assertEquals("Check size is updated", 6, this.emptyIntegerList.size);
		// assertEquals("Check size is updated", 14, test);
		// int test2 = this.emptyIntegerList.remove(4);
		// assertEquals("Check size is updated", 5, this.emptyIntegerList.size);
		// assertEquals("Check size is updated", 17, test2);
		// int test3 = this.emptyIntegerList.remove(4);
		// assertEquals("Check size is updated", 4, this.emptyIntegerList.size);
		// assertEquals("Check size is updated", 18, test3);
		// int test4 = this.emptyIntegerList.get(2);
		// assertEquals(15, test4);
		// int test5 = this.emptyIntegerList.get(1);
		// assertEquals(13, test5);
		// assertEquals("Check size is updated", 4, this.emptyIntegerList.size);
		// int test6 = this.emptyIntegerList.remove(5);
		// assertEquals("Check size is updated", 3, this.emptyIntegerList.size);
		// fail();
		}
		catch(Exception E){
			checking = true; // fail();
		}


		// TODO: add your test here
	}

	/**
	 * Aims to test the set(int index, E data) method.
	 * Set an out-of-bounds index with a valid data argument.
	 */
	@Test
	public void testCustomSetIdxOutOfBounds() {
		// TODO: add your test here
		boolean checks = false;
		try{
			this.populateLinkedList();
        	this.threeStringList.set(-1, "CSE 100");
        	assertEquals("Value at index 0 should be reset",
             "CSE 100", this.threeStringList.head.next.data);
			 fail();
		}
		catch(IndexOutOfBoundsException E){
			checks = true;
		}
		assertEquals(true, checks);

	}
}
