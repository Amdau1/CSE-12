/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Class notes, Tutors.
 * The purpose for this file is to create the arraylist data structure.
 * Instead of importing the Arraylist ADT this file creats its own.
 * This fils works and has all the functions that are required for a ArrayList.
 */
// This class uses the instance variable data to store the elements in the list
// Also uses the instance variable size to store the size of the current data.
public class MyArrayList <E> implements MyList <E>{
    Object[] data;
    int size;
    public MyArrayList(){
        data = new Object [5];
    }
/**
 * Initializes both of the instance variable data.
 * @param intitialCapacity the length of the current array
 */
    public MyArrayList(int initialCapacity){
        // Checking for edge cases
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
        }
        else{
            data = new Object [initialCapacity];
        }
    }
/**
 * This constructior intializes the size of the array.
 * Also uses the parameter to create an array using the instance variable data.
 * @param arr an array that the users input.
 */
    public MyArrayList (E[] arr){
        if(arr == null){
            data = new Object [5];  
        }
        else{
        data = arr;
        size = arr.length;
        }
    }
/**
 * This method expands the capacity of the array.
 * If the required capacity is less then the actual capacity after adding.
 * The current capacity will become requiredCapacity
 * @param requiredCapacity the required capacity of array that users passes in.
 */
    public void expandCapacity (int requiredCapacity){
        // Checks if capacity is not 0
        if(getCapacity() > requiredCapacity){
            throw new IllegalArgumentException();
        }
        if(getCapacity() != 0){
            Object[] newData = new Object [getCapacity() + 3];
            for(int i = 0; i <= data.length - 1; i++){
                newData[i] = data[i];
            }
            if(newData.length < requiredCapacity){
                Object[] newArray1 = new Object [requiredCapacity];
                // Deep copying the elements
                for(int i = 0; i <= newData.length - 1; i++){
                    newArray1[i] = newData[i];
                }
                data = newArray1;
            }
            else{
                data = newData;
            }
        }
        // Checks if capacuty is 0
        else if (getCapacity() == 0){
            Object [] newArray = new Object [5];
            for(int i = 0; i < data.length - 1; i++){
                newArray[i] = data[i];
            }
            //Updates capacity if it still doesn't math the required capacity
            if(newArray.length < requiredCapacity){
                Object[] newArray2 = new Object [requiredCapacity];
                //Deeop copying the elements
                for(int i = 0; i < newArray.length - 1; i++){
                    newArray2[i] = newArray[i];
                }
                data = newArray2;
            }
            else{
                data = newArray;
            }
        }
    }
/**
 * @return the capacity of the current array.
 */
    public int getCapacity(){
        return data.length;
    }
/**
 * This method inserts an element at the intended index
 * adds one to the size even if the element is null
 * @param index the place where the eleme is being inserted
 * @param element the thing that is being added to data
 */
    public void insert(int index, E element){
        if(index < 0 || index > data.length){
            throw new IndexOutOfBoundsException();
        }
        // Checks if the capcity needs to expanded
        if(size == data.length){
            expandCapacity(data.length);
        }
        for(int i = data.length - 1; i >= index; i--){
            if( i > index){
                data[i] = data [i - 1];
            }
        }
        data[index] = element;
        size++;
    }
/**
 * Adds the given element at the end of the list
 * Has an if statement to check if the element is null
 * If it is null this method won't do anything
 * @param element the information that is being added to data
 */
    public void append(E element){
        // Checks for null/ edge case
        // if(element == null){}

            if(size == data.length){
                expandCapacity(data.length);
            }
            data [size] = element;
            size++;
    }
/**
 * Adds the given element at the 0th index of the data.
 * Also moves all the old data one index to left
 * Has an if statement to check if the size needs to be extended
 * @param element the information that is being added at the 0th element.
 */
    public void prepend(E element){
        // Expnad capacity when needed
        if(size == getCapacity()){
            expandCapacity(size + 1);
        }
        for(int i = data.length - 1; i > 0; i--){
            data[i] = data [i - 1];
        }
        data[0] = element;
        size++;   
    }
/**
 * This method returns the the data at the given index
 * Has an if statement to check if the given index is valid
 * @param index an index that is within the array.
 * @return the information at that index
 */
    public E get(int index){
        // Checking for edge cases
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        return (E) data[index];
    }
/**
 * This method replaces the old element with the new element at the index
 * @param index the value to where the insert the element to
 * @param element the element that will be put in the olds element's position
 * @return the element that was removed
 */
    public E set(int index, E element){
        E result = (E) data[index];
        // Checks if index is out of bounds
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        data [index] = element;
        return result; 
    }
/**
 * This method removes the element at the given index
 * Aditionally makes the specified index to be null
 * @param index the index number that we want to make null
 * @return the element at the specified index that we removed.
 */
    public E remove(int index){
        Object returnValue = data[index];
        // Checks for out of bounds/edge case.
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        for(int i = 0; i <= size - 1; i++){
            if(i == index){
                data [i] = null;
            }
        }
        // if(data[index] == null){

        // }
        // else{
        size--;
        
        return ((E) returnValue);
    }
/**
 * @return the size of data
 */
    public int size(){
        return size;
    }
}