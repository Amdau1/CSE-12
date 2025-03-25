/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors, TA office hours, and class notes
 * The main purpose of this file is to implement a min heap.
 * Implement the methods require in a min heap with out importing them.
 */
import java.util.ArrayList;
import java.util.Collection;
/**
 * This class uses the instance variables given to create a ArrayList object
 * We store data through this object and create a tree data structure from it
 * Which we call heap
 */
public class MyMinHeap<E extends Comparable<E>>implements MinHeapInterface<E> {
    private static final int AVOIDMAGIC_NUMBERS = 2;
    protected ArrayList<E> data;
    /**
     * This is the constructor method that creates a new 
     * arraylist object
     */
    public MyMinHeap(){
        data = new ArrayList<>();
    }
    /**
     * This method initializes the newly created arraylist
     * @param collection the data that we are putting in the arraylist
     */
    public MyMinHeap(Collection<? extends E> collection){
        if(collection == null){
            throw new NullPointerException();
        }
        data = new ArrayList<>(collection);
        for(int i = data.size() - 1; i >= 0 ; i--){
            if(data.get(i) == null){
                throw new NullPointerException();
            }
            this.percolateDown(i);
        }
    }
    /**
     * This mthod swaps the element at the two given indeces
     * @param from index we are swaping from
     * @param to index we are swaping to
     */
    protected void swap(int from, int to){
        E fromElement = data.get(from);
        E toElement = data.get(to);
        data.set(from, toElement);
        data.set(to, fromElement);
    }
    /**
     * This methos gets the parent of the given index
     * @param index the parent that we want to find
     * @return the parent of the given index
     */
    protected static int getParentIdx(int index){
        return (index - 1)/AVOIDMAGIC_NUMBERS;
    }
    /**
     * This method returns the left child of the given index
     * @param index the index that may have a left child
     * @return the left child of the given index
     */
    protected static int getLeftChildIdx(int index){
        return (AVOIDMAGIC_NUMBERS * index) + 1;
    }
    /**
     * This method returns the right child of the given index
     * @param index the index that may have a right child
     * @return the right child of the given index
     */
    protected static int getRightChildIdx(int index){
        return (AVOIDMAGIC_NUMBERS * index) + AVOIDMAGIC_NUMBERS;
    }
    /**
     * This method returns the minimum childres at the given index
     * @param index the parent of the children index
     * @return the minimum value children of the given parent
     */
    protected int getMinChildIdx(int index){
        int rightChild = getRightChildIdx(index);
        int leftChild = getLeftChildIdx(index);
        if(getLeftChildIdx(index) >= data.size()){
            return -1;
        }
        else if(rightChild >= data.size()){
            return getLeftChildIdx(index);
        }
        // Left child is greater
        else if(data.get(rightChild).compareTo(data.get(leftChild)) < 0){
            return this.getRightChildIdx(index);
        }
        // Right child is greater
        else if(data.get(rightChild).compareTo(data.get(leftChild)) > 0){
            return this.getLeftChildIdx(index);
        }
        else{
            return this.getLeftChildIdx(index);
        }
    }
    /**
     * This method moves the element at the given index up
     * @param index the element at this index that we wil be moving up
     */
    protected void percolateUp(int index){
        int parent = this.getParentIdx(index);
        if(index != 0 && data.get(index).compareTo(data.get(parent)) < 0){
            this.swap(index, parent);
            percolateUp(parent);
        }
        else{
            return;
        }       
    }
    /**
     * This method moves the element at the given index down
     * @param index the element at this index that we will be moving down
     */
    protected void percolateDown(int index){
        int minChild = this.getMinChildIdx(index);
        if(minChild != -1 && data.get(minChild).compareTo(data.get(index)) < 0){
            this.swap(index, minChild);
            percolateDown(minChild);
        }
        else{
            return;
        }
    }
    /**
     * This method delets the element at the specefied index
     * @param index the index that we are removing the element
     * @return the element that was removed
     */
    protected E deleteIndex(int index){
        E returnIndex = data.get(index);
        if(index == data.size() - 1){
            data.remove(index);
        }
        else{
            // int minChild = getMinChildIdx(index);
            // int parentIndex = getParentIdx(index);
            this.swap(index, data.size() - 1);
            data.remove(data.size() - 1);
            // Parent is greater than current node
            // if(data.get(parentIndex).compareTo(data.get(index))>0){
                this.percolateUp(index);
            // }
            // Current node is greater than its min child
            // else if (data.get(minChild).compareTo(data.get(index))<0){
                this.percolateDown(index);
            // }
        }
        return returnIndex;
    }
    /**
     * This method inserts the given element
     * @param element the data that we are inserting into the arrau
     */
    public void insert(E element){
        if(element == null){
            throw new NullPointerException();
        }
        data.add(data.size(), element);
        this.percolateUp(data.size() - 1);
    }
    /**
     * This method gets the minimum value of the array
     * which is the root
     * @return the minimum value of the array
     */
    public E getMin(){
        if(data == null|| data.size() == 0){
            return null;
        }
        else{
            return data.get(0);
        }
    }
    /**
     * This method removes the root of the heap
     * @return the element that was removed
     */
    public E remove(){
        if(data == null || data.size() == 0){
            return null;
        }
        else{
            return this.deleteIndex(0);
        }
    }
    /**
     * This method will return the size of the heap
     * @return the size of the heap
     */
    public int size(){
        return data.size();
    }
    /**
     * This method will remove all the data from the heap
     */
    public void clear(){
        data.clear();
    }
}