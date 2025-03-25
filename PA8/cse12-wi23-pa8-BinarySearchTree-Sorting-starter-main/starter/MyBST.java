/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors, TA office hours, and class notes
 * The main purpose of this file is to implement a BST.
 * Where you can insert remove and search for a certain key.
 */
import java.util.ArrayList;
/**
 * This class creates a BST using two instance variables.
 * Using the instance variables we can do many operations on this BST
 */
public class MyBST<K extends Comparable<K>, V> {
    MyBSTNode<K, V> root = null;
    int size = 0;
    /**
     * This method returns the size of the BST
     * @return the size of the BST
     */
    public int size() {
        return size;
    }
    /**
     * This method insetrs the given key and value into the BST.
     * @param key the key of the node that we are adding
     * @param value the value of the node that we are adding
     * @return the key that was replaced or returns null if didn't.
     */
    public V insert(K key, V value) {
        if(key == null){
            throw new NullPointerException();
        }
        // Root of the tree
        if(root == null){
            MyBSTNode<K, V> node = new MyBSTNode<>(key, value, null);
            root = node;
            size++;
            return null;

        }
        // Going through the tree
        else{
            MyBSTNode curr = root; 
            while(curr != null){
                if(key.compareTo((K)curr.getKey()) == 0){
                    V returnValue = (V)curr.getValue();
                    curr.setValue(value);
                    return returnValue;
                }
                else if(key.compareTo((K)curr.getKey()) < 0){
                    if(curr.getLeft() == null){
                        MyBSTNode<K, V> Node1=new MyBSTNode<>(key, value, curr);
                        curr.setLeft(Node1);
                        break;
                    }
                    curr = curr.getLeft();
                }
                else if(key.compareTo((K)curr.getKey()) > 0){
                    if(curr.getRight() == null){
                        MyBSTNode<K, V> Node2=new MyBSTNode<>(key, value, curr);
                        curr.setRight(Node2);
                        break;
                    }
                    curr = curr.getRight();
                }
            }
            size++;
        }
        return null;
    }
    /**
     * This method searches for the specific key given
     * @param key the key we are searching for
     * @return the value of the key or null if key doesn't exist
     */
    public V search(K key) {
        MyBSTNode curr = root; 
        while(curr != null){
            if(key.compareTo((K)curr.getKey()) == 0){
                return (V) curr.getValue();
            }
            else if(key.compareTo((K)curr.getKey()) < 0){
                curr = curr.getLeft();
            }
            else if(key.compareTo((K)curr.getKey()) > 0){
                curr = curr.getRight();
            }
        }
        return null;
    }   
    /**
     * This method removes the node at the given key
     * @param key the node that we are removing
     * @return null if no key exists
     */
    public V remove(K key) {
        V returnValue = null;
        MyBSTNode curr = root; 
        while(curr != null){
            //Checking if the key is contained in the key
            if(key.compareTo((K)curr.getKey()) == 0){
                returnValue = (V)curr.getValue();
                if(size == 1){
                    curr.setValue(null);
                    curr.setKey(null);
                    return returnValue;
                }
                //Runcs if the node contains two children
                if(curr.getLeft() != null && curr.getRight() != null){
                    MyBSTNode idk = curr.successor();
                    curr.setValue(idk.value);
                    curr.setKey(idk.key);
                    curr = idk;
                    
                }
                // Runs if node has no children
                if(curr.getLeft() == null && curr.getRight() == null){  
                    if(curr.getParent().getLeft() == curr){
                        curr.getParent().setLeft(null);
                    }
                    else{
                        curr.getParent().setRight(null);
                    } 
                }
                //Runcs if node has only one child
                else if(curr.getLeft() != null || curr.getRight() != null){
                    //Runs if the child is on the left
                    if(curr.getLeft() != null){
                        //Removes the node
                        if(curr.getParent().getLeft() == curr){
                            curr.getParent().setLeft(curr.getLeft());
                            curr.getLeft().setParent(curr.getParent());
                        }
                        else{
                            curr.getParent().setRight(curr.getLeft());
                            curr.getLeft().setParent(curr.getParent()); 
                        }
                    }
                    //Runs if the child is right
                    else{
                        // Removes the node
                        if(curr.getParent().getLeft() == curr){
                            curr.getParent().setLeft(curr.getLeft());
                            if(curr.getLeft() != null){
                                curr.getLeft().setParent(curr.getParent());
                            }
                        }
                        else{
                            curr.getParent().setRight(curr.getLeft());
                            if(curr.getLeft() != null){
                                curr.getLeft().setParent(curr.getParent()); 
                            }
                        }
                    }
                }
                // Decrementing the size
                size--;
                return returnValue;
            }
            // Runs if key doesn't match
            else if(key.compareTo((K)curr.getKey()) < 0){
                curr = curr.getLeft();
            }
            else {
                curr = curr.getRight();
            }
        }
        // Returns null if key is nmot found in the tree
        return null;
    }
    /**
     * This method adds the node of the BST into an array
     * @return the array that was copid from the BST
     */
    public ArrayList<MyBSTNode<K, V>> inorder() {
        ArrayList<MyBSTNode<K, V>> copy = new ArrayList<>();
        MyBSTNode<K,V> curr = root;
        while(curr.getLeft() != null){
            curr = curr.getLeft();
        }
        while(curr != null){
            copy.add(curr);
            curr = curr.successor();
        }
        return copy;
    }
    /**
     * This class has the mothod to access the parent or the child node of
     * a parent. This class additionally has a succesor method which returns
     * the successor of a node.
     */
    static class MyBSTNode<K, V> {
        private static final String TEMPLATE = "Key: %s, Value: %s";
        private static final String NULL_STR = "null";
        private K key;
        private V value;
        private MyBSTNode<K, V> parent;
        private MyBSTNode<K, V> left = null;
        private MyBSTNode<K, V> right = null;
        /**
         * Creates a MyBSTNode storing specified data
         *
         * @param key    the key the MyBSTNode will store
         * @param value  the data the MyBSTNode will store
         * @param parent the parent of this node
         */
        public MyBSTNode(K key, V value, MyBSTNode<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
        /**
         * Return the key stored in the the MyBSTNode
         *
         * @return the key stored in the MyBSTNode
         */
        public K getKey() {
            return key;
        }
        /**
         * Set the key stored in the MyBSTNode
         *
         * @param newKey the key to be stored
         */
        public void setKey(K newKey) {
            this.key = newKey;
        }
        /**
         * Return data stored in the MyBSTNode
         *
         * @return the data stored in the MyBSTNode
         */
        public V getValue() {
            return value;
        }
        /**
         * Set the data stored in the MyBSTNode
         *
         * @param newValue the data to be stored
         */
        public void setValue(V newValue) {
            this.value = newValue;
        }
        /**
         * Return the parent
         *
         * @return the parent
         */
        public MyBSTNode<K, V> getParent() {
            return parent;
        }

        /**
         * Set the parent
         *
         * @param newParent the parent
         */
        public void setParent(MyBSTNode<K, V> newParent) {
            this.parent = newParent;
        }
        /**
         * Return the left child
         *
         * @return left child
         */
        public MyBSTNode<K, V> getLeft() {
            return left;
        }
        /**
         * Set the left child
         *
         * @param newLeft the new left child
         */
        public void setLeft(MyBSTNode<K, V> newLeft) {
            this.left = newLeft;
        }
        /**
         * Return the right child
         *
         * @return right child
         */
        public MyBSTNode<K, V> getRight() {
            return right;
        }
        /**
         * Set the right child
         *
         * @param newRight the new right child
         */
        public void setRight(MyBSTNode<K, V> newRight) {
            this.right = newRight;
        }
        /**
         * This method returns the node with the smallest key
         * that is still larger than the key of the current node.
         * @return null if no such key exist
         */
        public MyBSTNode<K, V> successor() {
                MyBSTNode curr = this;
                if(curr.getRight() == null){
                    while(curr != null && curr.getParent() != null && curr != curr.getParent().getLeft()){
                        curr = curr.getParent();
                    }
                    return curr.getParent();
                }
                else if(curr.getRight() != null){
                    curr = curr.getRight();
                    while(curr != null){
                        if(curr.getLeft() == null){
                            return curr;
                        }
                        curr = curr.getLeft();
                    }
                }
            return null;
        }
        /**
         * This method compares if two node objects are equal.
         *
         * @param obj The target object that the currect object compares to.
         * @return Boolean value indicates if two node objects are equal
         */
        public boolean equals(Object obj) {
            if (!(obj instanceof MyBSTNode))
                return false;

            MyBSTNode<K, V> comp = (MyBSTNode<K, V>) obj;

            return ((this.getKey() == null ? comp.getKey() == null :
                    this.getKey().equals(comp.getKey()))
                    && (this.getValue() == null ? comp.getValue() == null :
                    this.getValue().equals(comp.getValue())));
        }
        /**
         * This method gives a string representation of node object.
         *
         * @return "Key:Value" that represents the node object
         */
        public String toString() {
            return String.format(
                    TEMPLATE,
                    this.getKey() == null ? NULL_STR : this.getKey(),
                    this.getValue() == null ? NULL_STR : this.getValue());
        }
    }
}
