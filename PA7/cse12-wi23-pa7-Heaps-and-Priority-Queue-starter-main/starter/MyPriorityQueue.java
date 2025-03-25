/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors, TA office hours, and class notes
 * The main purpose of this file is to use the implemented
 * MinHeap in a priority queue
 */
import java.util.Collection;
/**
 * This class implements a priority queuq data stucture
 * using the MyMinHeap class. This class one has one instance variable
 * Which is used to store the data in the heap
 */
public class MyPriorityQueue<E extends Comparable<E>> {
    protected MyMinHeap<E> heap;
    /**
     * This method is used to create a empty heap
     */
    public MyPriorityQueue(){
        heap = new MyMinHeap<>();
    }
    /**
     * This method is used to initialize a the heap
     * @param collection the data that we are initializing the heap with
     */
    public MyPriorityQueue(Collection<? extends E> collection){
        if(collection == null){
            throw new NullPointerException();
        }
        heap = new MyMinHeap<>(collection);
        // for(int i = heap.size() - 1; i >= 0 ; i--){
        //     heap.percolateDown(i);
        // }
    }
    /**
     * This method inserts the given element into the heap
     * @param element the data that we are adding
     */
    public void push(E element){
        if(element == null){
            throw new NullPointerException();
        }
        heap.insert(element);
    }
    /**
     * This method returns the root of the heap
     * @return the root of the heap
     */
    public E peek(){
        if(heap == null){
            return null;
        }
        else{
            return heap.getMin();
        }
    }
    /**
     * This method returns and removes the root of the heap
     * @return the element that was removed
     */
    public E pop(){
        if(heap == null){
            return null;
        }
        else{
            return heap.remove();
        }
    }
    /**
     * This methis gets the length of the heap
     * @return the size of the heap
     */
    public int getLength(){
        return heap.size();
    }
    /**
     * This method will remove all the elements in the heap.
     */
    public void clear(){
        heap.clear();
    }
}
