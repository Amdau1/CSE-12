/**
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors, lecture slides.
 * The main purpose of this file is to create a two ended array where a user
 * can remove and add to the front only. To do this the array must be 
 * a circuler array which has no end ina some way.
 */

/**
 * The main purpose of this class it to create a circuler array
 * and implement method that can remove or insert elements 
 * into the array only at the front or at the rear.
 * Instance variables:
 * data - store the data of teh array
 * size - The size of the array
 * rear - the back end of the array
 * front - the front of the array
 */
public class MyDeque<E> implements DequeInterface<E>{
    Object[] data;
    int size;
    int rear; 
    int front;
    /**
     * This method initializes the instance variables of the array
     * Checks for edge cases as well
     * @param initialCapacity the capacity that the array will be
     */
    public MyDeque(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
        }
        else{
            data = new Object[initialCapacity];
            front = 0;
            rear = 0;
            size = 0;
        }
    }
    /**
     * This method returns the size of the array
     * @return the size of the array
     */
    public int size(){
        return size;
    }
    /**
     * This method checks if the capactiy is full.
     * If it is this method will reasize the array
     */
    public void expandCapacity(){
        int newCapacity = data.length * 2;
        if(data.length == 0){
            data = new Object[10];
        }
        else{
            Object[] newData = new Object[newCapacity];
            // System.out.println(newData.length);
            int count = 0;
            if(size == 1){
                for(int i = 0; i < data.length; i++){
                    if(data[i] != null){
                        newData [0] = data [i];
                        rear = 0;
                        front = 0;
                    }
                }
            }
            if(front > rear){
                // Deep copying the array
                for(int i = front; i < data.length; i++){
                    newData [count] = data[i];
                    count++;
                }
                for(int i = 0; i < front; i++){
                    newData[count]= data[i];
                    count++;
                }
                front = 0;
                rear = size - 1;
            }
            else if(front < rear){
                //Deep copying the array
                int count2 = 0;
                for(int i = front; i <= rear; i++){
                    newData[count2] = data [i];
                    count2++;
                }
                front = 0;
                rear = size - 1;
            }
            data = newData;
  
        }
    }
    /**
     * This method adds the given emelement at the front of the array
     * @param element the element that we are adding to the array
     */
    public void addFirst(E element){
           // Checking for edge cases
           if(element == null){
            throw new NullPointerException();
        }
        // Resizing the array
        if(size == data.length){
            expandCapacity();
        } 
        // adding to the array 
        if(size == 0){
            // System.out.println("idk1");
            data [0] = element;
            front = 0;
            rear = 0;
        }
        else if(data[0] != null && data[data.length - 1] == null){
            // System.out.println("idk");
            data[data.length - 1] = element;
            front = data.length - 1;
        }
        else{
            // System.out.println("idk23");
            for(int i = 0; i < data.length; i++){
                if(front > rear && data [front - 1] == null){
                    data [front - 1] = element;
                    front = front -  1;
                    break;
                }
                else if(data[i] == null && (data[i+1] != null || (i + 2) >= data.length)){
                    data [i] = element;
                    front = i;
                    break;
                }
            }
        }
        // inceremting the size
        size++;
    }
    /**
     * This methos adds the given element at the rear of the array
     * @param element the element that we are adding to the array
     */
    public void addLast(E element){
        // Checking for edge cases
        if(element == null){
            throw new NullPointerException();
        }
        // Resizing the array
        if(size == data.length){
            expandCapacity();
        } 
        // Adding the element to the array 
        if(size == 0){
            data [0] = element;
            rear = 0;
        }
        else if(data[0] != null && data [data.length - 1] == null){
            data[data.length - 1] = element;
            rear = data.length - 1;
        }
        else{
            for(int i = 1; i < data.length; i++){
                // if(i == data.length - 1){
                //     if(data[i] != null && data[0] == null){
                //         data [0] = element;
                //         rear = 0;
                //         break;
                //     }
                // }
                if(front > rear && data [rear + 1] == null){
                    data[rear + 1] = element;
                    rear = rear + 1;
                }
                else if(data[i] == null && data[i-1] != null){
                    data [i] = element;
                    rear = i;
                    break;
                }
            }
        }
        // Incrementing the size
        size++;
    }
    /**
     * This method removes the element at the front of the array
     * @return the element that was removed from the array
     */
    public E removeFirst(){
        if(size == 0 || data.length == 0){
            // System.out.println("idk");
            return null;
        }
        // Checking for edge cases
        else{
            // System.out.println("2idk");
            int removedIndex = front;
            Object removedData = data [front];
            data [removedIndex] = null;
            if(front == data.length && data [0] != null){
                front = 0;
            }
            else{
                for(int i = 0; i <= data.length - 1; i++){
                    if(data [i] != null){
                        front = i;
                        break;
                    }
                }
            }
            size--;
            return (E) removedData;
            // Decremeting the size
        }
        // return ;
    }
    /**
     * This method removes the elemnts thats at the rear of the array
     * @return the element that was removed from the array
     */
    public E removeLast(){
        if(size == 0 || data.length == 0){
            return null;
        }
        int index = rear;
        Object removedData = data [rear];
        data [index] = null;
        // Reassigning the rear index
        if(rear == data.length - 1 && data [0] != null){
            rear = 0;
        }
        else{
            for(int i = data.length-1; i > 0; i--){
                if(data [i] != null){
                    rear = i;
                    break;
                }
            }
        }
        size--;    
        return (E) removedData;
    }
    /**
     * This method checks if there is a element at the front of the array
     * @return the elemnt at the fron index of the array
     */
    public E peekFirst(){
        if(data.length == 0){
            return null;
        } 
        else{
            return (E) data[front];
        }
    }
    /**
     * This emethod checks if there is an element at the rear index of the array
     * @return the element thats at the rear index of the element
     */
    public E peekLast(){
        if(data.length == 0){
            return null;
        } 
        else{
            return (E) data[rear];
        }
    }
}