/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors, TA office hours, and class notes
 * The main purpose of this file is to create a class with given information
 * And enrolls student into the class if there are spots available
 */
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * This class uses the instance variables given to create a course.
 * Then checks if students can be added to that course.
 * This class has 6 instance variable.
 */
public class Course {
    // Instance variables
    HashSet<Student> enrolled;
    private final static String format = "%s %s [%d] %s";
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;
    /**
     * This method initializes the instance variables.
     * @param department the department that the course will be in
     * @param number the number of the course
     * @param description the description of the course
     * @param capacity the amount of student that can enroll in this course
     */
    public Course(String department, String number, String description, int capacity){
        if(department == null || number == null || description == null){
            throw new IllegalArgumentException();
        }
        else if(capacity <= 0){
            throw new IllegalArgumentException();
        }
        this.department = department;
        this.number = number;
        this.description = description;
        this.capacity = capacity;
        enrolled = new HashSet<>(0);
    }
    /**
     * This method returns the department instance variable
     * @return the department of the course.
     */
    public String getDepartment(){
        return department;
    }
    /**
     * This method returns the number instance variable
     * @return the number of the course.
     */
    public String getNumber(){
        return number;
    }
    /**
     * This method returns the description instance variable
     * @return the description of the course.
     */
    public String getDescription(){
        return description;
    }
    /**
     * This method returns the capacity instance variable
     * @return the capacity of the course.
     */
    public int getCapacity(){
        return capacity;
    }
    /**
     * This method checks to see if the a student can be enrolled in the course
     * If it can be added then we add it to the course
     * @param student the student that we want to add to the course
     * @return true if the student was added else it returns false
     */
    public boolean enroll(Student student){
        if(student == null){
            throw new  IllegalArgumentException();
        }
        if(enrolled.contains(student)){
            return false;
        }
        else if(enrolled.size() == capacity){
            return false;
        }
        else{
            enrolled.add(student);
            return true;
        }
    }
    /**
     * This method moves a student from the course.
     * @param student the student that we want to remove
     * @return true if student was removed or else truen false.
     */
    public boolean drop(Student student){
        if(student == null){
            throw new IllegalArgumentException();
        }
        if(enrolled.contains(student)){
            enrolled.remove(student);
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * This method cancels a class and removes all the students in it
     */
    public void cancel(){
        enrolled.removeAll(enrolled);
    }
    /**
     * This method checks if the size of the class is at capacity
     * @return true or false based on the size of the class
     */
    public boolean isFull(){
        if(enrolled.size() == capacity){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * This method returns the number of studnets in the class
     * @return the amount of students already in the class
     */
    public int getEnrolledCount(){
        return enrolled.size();
    }
    /**
     * This method checks the available spots in the class
     * @return true if there are space available else returns false
     */
    public int getAvailableSeats(){
        return capacity - enrolled.size();
    }
    /**
     * This method makes a shallow copy of the students that are
     * enrolled in the course
     * @return the shallow copy of the students
     */
    public HashSet<Student> getStudents(){
        Object shallowCopy = enrolled.clone();
        return (HashSet<Student>)shallowCopy;
    }
    /**
     * This method turns the shallowcopy of the students into an array
     * @return the arraylist version of the students
     */
    public ArrayList<Student> getRoster(){
        ArrayList<Student> roster = new ArrayList<>();
        for(Student index : enrolled){
            roster.add(index);
        }
        Collections.sort(roster);
        return roster;
    }
    /**
     * This method gives a string representation of course
     * @return the string representation of the class.
     */
    @Override
    public String toString(){
        return String.format(format, department, number, capacity, description);
    }
}
