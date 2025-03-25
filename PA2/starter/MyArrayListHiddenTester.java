import static org.junit.Assert.*;

import org.junit.*;

public class MyArrayListHiddenTester {
    // Do not change the method signatures!
    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test 
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Aims to test the constructor when the input argument
     * is not valid
     */
    @Test
    public void testConstructorInvalidArg(){
        try{
        MyArrayList usingList = new MyArrayList<Integer>(-1);
        fail();
        }
        catch(IllegalArgumentException e){
        }
    }

    /**
     * Aims to test the constructor when the input argument is null
     */
    @Test
    public void testConstructorNullArg(){
        try {
            MyArrayList usingList = new MyArrayList<Integer>(null);
            assertEquals("", 0, usingList.size);
            assertEquals("", 5,usingList.getCapacity());
        }
        catch(IllegalArgumentException e){
            fail();
        }
    }

    /**
     * Aims to test the constructor when the input array has null elements
     */
    @Test
    public void testConstructorArrayWithNull(){

    }

    /**
     * Aims to test the append method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendAtCapacity(){
       Integer[] list = {1,2,3,4};
       MyArrayList usingList = new MyArrayList<Integer>(list);
       usingList.append(2);
       assertArrayEquals("Capacity should updated", 
                new Integer[]{1, 2, 3, 4, 2, null, null}, usingList.data);
        assertEquals("Check list size after the append", 5, usingList.size);
        assertEquals("getCapacity should return the length instance variable "
                + "data", 7, usingList.getCapacity());
    }

    /**
     * Aims to test the append method when null is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendNull(){
        Integer[] noname = {1,2,3,4};
        MyArrayList nulltest = new MyArrayList<Integer>(noname);
        nulltest.append(null);
        assertArrayEquals("Capacity should updated", 
                 new Integer[]{1, 2, 3, 4}, nulltest.data);
         assertEquals("Check list size after the append", 4, nulltest.size);
         assertEquals("getCapacity should return the length instance variable "
                 + "data", 4, nulltest.getCapacity()); 
    }

    /**
     * Aims to test the prepend method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testPrependAtCapacity(){
        Integer[] noname = {1,2,3,4};
        MyArrayList nulltest = new MyArrayList<Integer>(noname);
        nulltest.prepend(5);
        assertArrayEquals("Capacity should updated", 
                 new Integer[]{5, 1, 2, 3, 4, null, null}, nulltest.data);
         assertEquals("Check list size after the append", 5, nulltest.size);
         assertEquals("getCapacity should return the length instance variable "
                 + "data", 7, nulltest.getCapacity());  
    }
    
    /**
     * Aims to test the prepend method when a null element is added
     * Checks reflection on size and capacity
     * Checks whether null was added successfully
     */
    @Test
    public void testPrependNull(){
        Integer[] array = {1,2,3,4};
        MyArrayList nulltest = new MyArrayList<Integer>(array);
        nulltest.prepend(null);
        assertArrayEquals("Capacity should updated", 
            new Integer[]{null, 1, 2, 3, 4, null, null}, nulltest.data);
        assertEquals("Check list size after the append", 5,  nulltest.size);
        assertEquals("getCapacity should return the length instance variable "
            + "data", 7, nulltest.getCapacity());    
    }
    
    /**
     * Aims to test the insert method when input index is out of bounds
     */
    @Test
    public void testInsertOutOfBound(){
        try{
            Integer[] list = {1,2,3,4};
            MyArrayList usingList = new MyArrayList<Integer>(list);
            usingList.insert(-1, usingList);
            fail();
       }
       catch(IndexOutOfBoundsException e){} 
    }

    /**
     * Insert multiple (eg. 1000) elements sequentially beyond capacity -
     * Check reflection on size and capacity
     * Hint: for loop could come in handy
     */
    @Test
    public void testInsertMultiple(){
        Integer[] list = {1,2,3,4};
        MyArrayList usingList = new MyArrayList<Integer>(list);
        for(int i = 0; i < 10; i++){
            usingList.insert(i, 6);
        }
        assertEquals("", 14,usingList.size);
        assertEquals("", 16,usingList.getCapacity());
    }

    /**
     * Aims to test the get method when input index is out of bound
     */
    @Test
    public void testGetOutOfBound(){
        try{
            Integer[] list = {1,2,3,4};
            MyArrayList usingList = new MyArrayList<Integer>(list);
            usingList.get(-1);
            fail();
       }
       catch(IndexOutOfBoundsException e){

       } 
    }

    /**
     * Aims to test the set method when input index is out of bound
     */
    @Test
    public void testSetOutOfBound(){
       try{
            Integer[] list = {1,2,3,4};
            MyArrayList usingList = new MyArrayList<Integer>(list);
            usingList.set(-1, usingList);
            fail();
       }
       catch(IndexOutOfBoundsException e){

       } 
    }

    /**
     * Aims to test the remove method when removing multiple items from a list
     */
    @Test
    public void testRemoveMultiple(){
        Integer[] idk = { 1, 2, 3 , 4}; 
        MyArrayList idk2 = new MyArrayList<Integer>(idk);
        idk2.remove(0);
        assertArrayEquals("Capacity should update",
        new Integer[]{null, 2, 3, 4}, idk2.data); 
        idk2.remove(1);
        assertArrayEquals("Capacity should update", 
        new Integer[]{null, null, 3, 4}, idk2.data); 
        idk2.remove(2);
        idk2.remove(0);
        assertArrayEquals("Capacity should update", 
        new Integer[]{null, null, null, 4}, idk2.data); 
    }

    /**
     * Aims to test the remove method when input index is out of bound
     */
    @Test
    public void testRemoveOutOfBound(){
        try{
            Integer[] list = {1,2,3,4};
            MyArrayList usingList = new MyArrayList<Integer>(list);
            usingList.remove(-1);
            fail();
       }
       catch(IndexOutOfBoundsException e){

       } 
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is strictly less than the current capacity
     */
    @Test
    public void testExpandCapacitySmaller(){
        try{
            Integer[] idk = { 1, 2, 3 , 4}; 
            MyArrayList usingList = new MyArrayList<Integer>(idk);
            usingList.expandCapacity(3);
            fail();
        }
        catch(IllegalArgumentException e){
        }
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is greater than current capacity+3 and default capacity
     */
    @Test
    public void testExpandCapacityLarge(){
        Integer[] intList = { 1, 2, 3 }; 
        MyArrayList listWithInt = new MyArrayList<Integer>(intList);
        listWithInt.expandCapacity(7);
        assertArrayEquals("Capacity should update", 
        new Integer[]{1, 2, 3, null, null, null, null}, listWithInt.data);
    }
}
