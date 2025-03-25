/**
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * The main purpose of this file is to tests the code
 * that were implemented in the class MyDeque, MyStack,MyQueue
 */
import org.junit.Test;
import static org.junit.Assert.*;
/*
 * This class creates tests for the code compmenetd in the classes.
 * Checks if the code is doing what it is supposed to
 */
public class CustomTester {
    /**
     * This method is creatinf an deque array
     * @param deque the object
     * @param data the data in the deque
     * @param size  the size of the array
     * @param front the front of the arrya
     * @param rear the rear of the array
     */
   static void initDeque(MyDeque<Integer> deque, Object[] data, int size, int front, int rear) {
        deque.data = data;
        deque.size = size;
        deque.front = front;
        deque.rear = rear;
    }
    /**
     * This method is testing the constructor of the class deque
     */
    @Test
    public void MyDequeConstructo(){
        boolean check = false;
        try{
        MyDeque<Integer> deque1 = new MyDeque<>(20);
        assertEquals("Capacity should be initialized to 20", 20,
                deque1.data.length);
        assertEquals("Size should be initialized to 0", 0, deque1.size);
        assertEquals("Front should be initialized to 0", 0, deque1.front);
        assertEquals("Rear should be initialized to 0", 0, deque1.rear);
        MyDeque<Integer> deque2 = new MyDeque<>(-1);
        }
        catch(IllegalArgumentException E){
            check = true;
        }
        assertTrue(check);
    }
    /**
     * This method tests the epand capacity method of deque class
     */
    @Test
    public void expandCapacity(){
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] orig = {null,null,null,null,null, null,null,null,null,null};
        initDeque(deque, orig, 0, 0, 0);

        deque.expandCapacity();

        assertEquals("Capacity should have doubled", 20, deque.data.length);
        assertEquals("Size should not have changed", 0, deque.size);
        assertEquals("Front should be 0", 0, deque.front);
        assertEquals("Rear should be at size - 1", 0, deque.rear);
        MyDeque<Integer> deque2 = new MyDeque<>(5);
        Integer[] orig2 = {3, 4, 5, 1, 2};
        Integer[] finalOrdering2 = { 1, 2, 3, 4, 5, null, null, null, null, null};
        initDeque(deque2, orig2, 5, 3, 2);
        deque2.expandCapacity();
        assertEquals("Capacity should have doubled", 10, deque2.data.length);
        assertEquals("Size should not have changed", 5, deque2.size);
        assertEquals("Front should be 0", 0, deque2.front);
        assertEquals("Rear should be at size - 1", 4, deque2.rear);
        for (int i = 0; i < 10; i++) {
            assertEquals("Deque structure should be maintained",
            finalOrdering2[i], deque2.data[i]);
        }
    }
    /**
     * This method tests the addFirst method of the deque class
     */
    @Test
    public void addFirst(){
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] orig = {2,3,1,4,5,6,8,10,9,7};
        initDeque(deque, orig, 10, 2, 7);

        deque.addFirst(0);

        assertEquals("Capacity should change because its full", 20,
                deque.data.length);
        assertEquals("Should increment size", 11, deque.size);
        assertEquals("Front should move one index when inserting into " +
                "non-empty deque", 19, deque.front);
        assertEquals("Rear change because of expand capacity", 9, deque.rear);
        assertEquals("0 should have been inserted into index 19",
        0, deque.data[19]);
        MyDeque<Integer> deque1 = new MyDeque<>(1);
        Integer[] orig1 = {4};
        initDeque(deque1, orig1, 1, 0, 0);
        deque1.addFirst(2);
        deque1.addFirst(3);
        deque1.addFirst(4);
        deque1.addFirst(5);
        deque1.addFirst(6);
        assertEquals("Capacity should not change if deque not full", 8,deque1.data.length);
        assertEquals("Should increment size", 6, deque1.size);
        assertEquals("Front should move one index when inserting into " +
                "non-empty deque", 6, deque1.front);
        assertEquals("Rear shouldn't change when calling addFirst", 3,
                deque1.rear);
        assertEquals("6 should have been inserted into index 2",
                2, deque1.data[2]);
        assertEquals("Index 3 should not have changed", 4,
                deque1.data[3]);
        assertEquals("Index 4 should not have changed",
                null, deque1.data[4]);
        assertEquals("Index 5 should not have changed", null,
                deque1.data[5]);
    }
    /**
     * This method tsts the addLast of the deque class
     */
    @Test
    public void addLast(){
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] orig = {null, null, 4, 5, 1};
        initDeque(deque, orig, 3, 2, 4);

        deque.addLast(-1);

        assertEquals("Capacity should not change if deque not full", 5,
                deque.data.length);
        assertEquals("Should increment size", 4, deque.size);
        assertEquals("Front shouldn't change when called addLast", 2,
                deque.front);
        assertEquals("Rear should move one index when inserting into " +
                "non-empty deque", 0, deque.rear);
        assertEquals("-1 should have been inserted into index 5",
                1, deque.data[4]);
        assertEquals("Index 2 should not have changed", 4,
                deque.data[2]);
        assertEquals("Index 3 should not have changed", 5,
                deque.data[3]);
        assertEquals("Index 4 should not have changed", 1,
                deque.data[4]);
                MyDeque<Integer> deque1 = new MyDeque<>(10);
                Integer[] orig1= {null, null, 4, 5, 1, null, null, null, null, null};
                initDeque(deque1, orig1, 3, 2, 4);
        
                deque1.addLast(-1);
        
                assertEquals("Capacity should not change if deque not full", 10,
                        deque1.data.length);
                assertEquals("Should increment size", 4, deque1.size);
                assertEquals("Front shouldn't change when called addLast", 2,
                        deque1.front);
                assertEquals("Rear should move one index when inserting into " +
                        "non-empty deque", 5, deque1.rear);
                assertEquals("-1 should have been inserted into index 5",
                        -1, deque1.data[5]);
                assertEquals("Index 2 should not have changed", 4,
                        deque1.data[2]);
                assertEquals("Index 3 should not have changed", 5,
                        deque1.data[3]);
                assertEquals("Index 4 should not have changed", 1,
                        deque1.data[4]);
    }
    /**
     * This method tests the removeFirst method of the deque class
     */
    @Test
    public void removeFirst(){
        MyDeque<Integer> deque = new MyDeque<>(4);
        Integer[] orig = {2, 3, 4, 1};
        initDeque(deque, orig, 4, 3, 1);

        assertEquals("Element removed should be returned", 1,
                deque.removeFirst().intValue());

        assertEquals("Array length shouldn't be changed", 4,
                deque.data.length);
        assertEquals("Size should decrement", 3, deque.size);
        assertEquals("Front should move one index after removing from " +
                "non-empty deque", 0, deque.front);
        assertEquals("Rear should not change after calling removeFirst", 1,
                deque.rear);
        // assertEquals("Index 2 should remain unchanged", 4,
        //         deque.data[2]);
        // assertEquals("Index 3 should remain unchanged", 1,
        //         deque.data[3]);
        // assertNull("Index 1 should have been set to null", deque.data[1]);
    }
    /**
     * This method tests the removeLast method from the class deque
     */
    @Test
    public void removeLast(){
        MyDeque<Integer> deque = new MyDeque<>(4);
        Integer[] orig = {2, 3, 4, 1};
        initDeque(deque, orig, 3, 1, 3);

        assertEquals("Element removed should be returned", 1,
                deque.removeLast().intValue());

        assertEquals("Array length shouldn't be changed", 4,
                deque.data.length);
        assertEquals("Size should decrement", 2, deque.size);
        assertEquals("Front should not change after calling removeLast", 1, deque.front);
        assertEquals("Rear should move one index after removing from " +
                "non-empty deque", 0, deque.rear);
        // assertEquals("Index 1 should remain unchanged", 3,
        //         deque.data[1]);
        // assertEquals("Index 2 should remain unchanged", 4,
        //         deque.data[2]);
        // assertNull("Index 3 should have been set to null", deque.data[3]);
    }
    /**
     * This method tests the class MyStack
     */
    @Test
    public void MyStack(){
        MyStack<Integer> stack = new MyStack<>(9);
        boolean check = false;
        assertEquals("Capacity should be initialized to 9", 9,
                stack.theStack.data.length);
        assertEquals("Size should be initialized to 0", 0,
                stack.theStack.size);
        assertEquals("Front should be initialized to 0", 0,
                stack.theStack.front);
        assertEquals("Rear should be initialized to 0", 0,
                stack.theStack.rear);
        try{
                MyStack<Integer> stack2 = new MyStack<>(-1);
        }
        catch(IllegalArgumentException E){
                check = true;
        }
        assertTrue( check);
    }
    /**
     * This methos tests the methods in MyQueue class.
     */
    @Test
    public void MyQueue(){
        MyStack<Integer> stack = new MyStack<>(10);
        Integer[] orig = {1, 2, 3, null, null, null, null, null, null, null};
        initDeque(stack.theStack, orig, 3, 0, 2);
        int idk = stack.peek();
        assertEquals("Should be 1", 1,
        idk);
        assertEquals("Front should not have changed", 0, stack.theStack.front);
        assertEquals("Rear should not have changed", 2, stack.theStack.rear);
    }
    /**
     * This method checks the push method in the class MyStack
     */
    @Test
    public void testStackPush() {
        MyStack<Integer> stack = new MyStack<>(4);
        Integer[] orig = {null,null,null,null};
        initDeque(stack.theStack, orig, 0, 0, 0);

        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);

        // peekLast also works
        assertEquals("Element should be at the top of the stack",
                Integer.valueOf(3), stack.theStack.peekFirst());
        assertEquals("Capacity should not have changed", 8,
                stack.theStack.data.length);
        assertEquals("Size should be incremented", 5, stack.theStack.size);
        assertEquals("Front should not have changed", 7, stack.theStack.front);
        assertEquals("Rear should not have changed", 3, stack.theStack.rear);
    }
}