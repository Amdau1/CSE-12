/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors, TA office hours, and class notes
 * The main purpose of this file is to construct a linkedlist data structure.
 * Without importing any linkedlist class, this file creates its own linked list
 * from scratch. 
 */
import java.util.AbstractList;
/**
 * This class creats the two classes necessary for a linkedlist
 * The two necessary classes are linkedlist and node
 * There are three instance variable in this class
 * The size variable keeps track of the size of the list
 * The head variable keeps track of where the node head is pointing to
 * The tail variable keeps track of where the end of the linkedList is.
 */
public class MyLinkedList<E> extends AbstractList<E> {
    // instance variable
    int size;
    Node head;
    Node tail;

    /**
     * A Node class that holds data and references to previous and next Nodes.
     */
    protected class Node {
        E data;
        Node next;
        Node prev;

        /** 
         * Constructor to create singleton Node 
         * @param element Element to add, can be null	
         */
        public Node(E element) {
            // Initialize the instance variables
            this.data = element;
            this.next = null;
            this.prev = null;
        }

        /** 
         * Set the parameter prev as the previous node
         * @param prev new previous node
         */
        public void setPrev(Node prev) {
            this.prev = prev;		
        }

        /** 
         * Set the parameter next as the next node
         * @param next new next node
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /** 
         * Set the parameter element as the node's data
         * @param element new element 
         */
        public void setElement(E element) {
            this.data = element;
        }

        /** 
         * Accessor to get the next Node in the list 
         * @return the next node
         */
        public Node getNext() {
            return this.next;
        }
        /** 
         * Accessor to get the prev Node in the list
         * @return the previous node  
         */
        public Node getPrev() {
            return this.prev;
        } 
        /** 
         * Accessor to get the Nodes Element 
         * @return this node's data
         */
        public E getElement() {
            return this.data;
        } 
    }

    
    /** 
     * This is the constructior method that initializes the instance variables
     * Instance variables: tail, head.
     * Does not increase the size because the elemtns are null.
     */
    public MyLinkedList() {
        Node headNode = new Node(null);
        head = headNode;
        Node tailNode = new Node(null);
        tail = tailNode;
        head.next = tail;
        tail.prev = head;
    }
    
    /**
     * This method returns the size of the linkedList
     * @return size of the linkedList
     */
    @Override
    public int size() {
        // need to implement the size method
        return size;
    }

    /**
     * This method takes in a number and returns the data at that index
     * @param index the number of the node that should return data.
     * @return the data at the specified index.
     */
    @Override
    public E get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = head;
        E result = null;
        //For loop to ru untill it reaches the required index
        for(int i = 0; i <= index; i++){
            currentNode = currentNode.next;
            if(i == index){
                result = currentNode.data;
            }
        }
        return (E) result;
    }

    /**
     * This metohd adds a node and gives it some data at the specified index.
     * Also checks if the given data is null or not
     * If data is null it thorws a NullPointerException
     * Aditionally it checks for valid index
     * If the index is less then zero or greater than the size
     * Then it will throw a IndexOutOfBoundsException exception
     * @param index the index where the node should be added
     * @param data the data that should be stored in that node
     */
    @Override
    public void add(int index, E data) {
        Node currentNode = head.next;
        Node addedNode = new Node(data);
        // Checking for edge cases
        if(data == null){
            throw new NullPointerException();
        }
        else if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        // Changing the pointers with for loop
        for(int i = 0; i < index; i++){
            currentNode = currentNode.next;
        }       
        addedNode.next = currentNode;
        addedNode.prev = currentNode.prev;
        currentNode.prev.next = addedNode;
        currentNode.prev = addedNode;
        size++;
    }

    /**
     * This method adds a new node at the end of the linkedList.
     * Also checks if the given data is null or not
     * If data is null it thorws a NullPointerException
     * Increases the size
     * @param data the data that will be in the new node
     * @return true when the node was added successfully.
     */
    public boolean add(E data) {
        // Checks for edge cases
        if(data == null){
            throw new NullPointerException();
        }
        Node newNode = new Node(data);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev = newNode;
        newNode.prev.next = newNode;
        size++;
        return true;
    }

    /**
     * This method repalces the old data with the new given data
     * Also checks if the given data is null or not
     * If data is null it thorws a NullPointerException
     * Aditionally it checks for valid index
     * If the index is less then zero or greater than the size
     * Then it will throw a IndexOutOfBoundsException exception
     * @param index the position where the new data should go
     * @param data the information that goes at the given node
     * @return the old data of the node
     */
    public E set(int index, E data) {
        //Checking for edge cases
        if(data == null){
            throw new NullPointerException();
        }
        else if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = head;
        E result = null;
        //Replacing the old data with the new data.
        for(int i = 0; i <= index; i++){
            currentNode = currentNode.next;
            if(i == index){
                result = currentNode.data;
                currentNode.data = data;
            }
        }
        return (E) result;
    }

    /**
     * This method removes a node from the linked list.
     * Has an if statement to check if the given index is valid
     * Also decrements the size because a node is being removed
     * @param index the node "number" in the linkedlist
     * @return the elements that was in the node that was removed
     */
    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = head;
        E result = head.getElement();
        // For loop to go to the specified node
        for(int i = 0; i <= index; i++){
            currentNode = currentNode.next;
            if(i == index){
                result = currentNode.getElement();
                // removing the node
                if(i == 0){
                    head.next = currentNode.next;
                    currentNode.next.prev = head;
                }
                else if(currentNode.next == tail){
                    tail.prev = currentNode.prev;
                    currentNode.prev.next = tail;
                }
                else{
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                }
            }
        }
        //Decrementing the size.
        size--;
        return (E) result;
    }

    /**
     * If the linkedlist is not empty
     * This methos removes all the elements from this linkedList
     * Sets the size to be zero
     */
    public void clear() {
        if(isEmpty() == false){
            head.setNext(tail);
            tail.setPrev(head);
            size = 0;
        }
    }

    /**
     * This method uses size of the linkedList to check if its empty
     * @return true if linkedList is epmty else returns false
     */
    public boolean isEmpty() {
        if(size == 0){
            return true;
        } 
        else{
            return false;
        }
    }

    /**
     * This method is a helper method
     * This method will return the node at the specified index
     * Returns the node not the data
     * @param index the index value of the node that should be returned
     * @return the specified the node at the specified index.
     */
    protected Node getNth(int index) {
        // Checks for edge cases
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = head;
        Node result = null;
        for(int i = 0; i <= index; i++){
           currentNode = currentNode.next; 
           if(i == index){
            result = currentNode;
           }
        }
        //Returns the specified node.
        return (Node) result;
    }
}