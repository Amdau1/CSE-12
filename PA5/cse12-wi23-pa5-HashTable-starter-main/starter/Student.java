/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors, and class notes
 * The main purpose of this file is to create a studdent object and
 * Initialize it with its last and first name, and PID.
 * Additionally this file also checks if two students are the same.
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
 * This class creates the student object and implements the 
 * method needed to initialize the student object.
 * This class contains three instance variables.
 * Which are: firstNmae, lastNamr, and PID
 */
public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String PID;
    /**
     * This method initializes the instance variables of this class
     * @param firstName the first name of the student
     * @param lastName the last name of the student
     * @param PID the PID of the student.
     */
    public Student(String firstName, String lastName, String PID){
        if(firstName == null || lastName == null || PID == null){
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.PID = PID;
    }
    /**
     * This method return the first name of the student that was initialized.
     * @return the first name of a student
     */
    public String getFirstName(){
        return firstName;
    }
    /**
     * This method eturn the last name of the student that was initialized.
     * @return the last name of the student
     */
    public String getLastName(){
        return lastName;
    }
    /**
     * This method eturn the PID of the student that was initialized.
     * @return the PID of the student
     */
    public String getPID(){
        return PID;
    }
    /**
     * This method checks if the given students are in student.
     * @param o the object that is being checked
     * @return true if the object given is student and not null
     * and matches the instance variables. Else returns false
     */
    @Override
    public boolean equals(Object o){
        if( o != null && o instanceof Student){
            Student typecast = (Student) o;            
            if(typecast.firstName.equals(firstName) && typecast.lastName.equals(lastName)){
                if(typecast.PID.equals(PID)){
                    return true;
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
        return false;
    }
    /**
     * This method returns a hash value for the student
     * @return an integer value of the hascode that was provided
     */
    @Override
    public int hashCode(){
        return Objects.hash(firstName, lastName, PID);
    }
    /**
     * This method compares two students for the class
     * @param o the object that is being passed on.
     * @return and integer value of the comparison that is being made
     */
    @Override
    public int compareTo(Student o){
        if( o == null){
            throw new NullPointerException();
        }
        if(lastName.compareTo(o.lastName) == 0){
            if(firstName.compareTo(o.firstName) == 0){
                if(PID.compareTo(o.PID) == 0){
                    return 0;
                }
                else{
                    return PID.compareTo(o.PID);
                }
            }
            else{
                return firstName.compareTo(o.firstName);
            }
        }
        else{
            return lastName.compareTo(o.lastName);
        }
    }
}