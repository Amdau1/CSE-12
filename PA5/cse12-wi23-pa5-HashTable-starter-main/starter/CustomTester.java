/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: None
 * This file is made to tests the methods in santuary.java, Course.java
 * and Student.java files. This files tests those files in numours different
 * ways.
 */
import java.util.Objects;
import java.util.Map;
import org.junit.Test;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import static org.junit.Assert.*;
public class CustomTester {
    @Test
    public void testStudentEquals() {
        Course course = new Course("CSE", "12", "Data Structure", 100);
        Student student1 = new Student("1", "Student",
                "A12345678");
        Student student2 = new Student("1", "Student",
                "A12345678");
        assertTrue(student1.equals(student2));
        assertFalse(student1.equals(course));
    }
    @Test
    public void testStudentCompareTo() {
        Student student1 = new Student("1", "Student",
                "A12345678");
        Student student2 = new Student("1", "Student",
                "A123456");
        int testing = student1.compareTo(student2);
        assertEquals(2, testing);
    }
    @Test
    public void testCourseDrop() {
        boolean idk = false;
        try{
        Course course = new Course("CSE", "12", "Data Structure", 2);
        course.enrolled = new HashSet<>();
        Student student = new Student("Who", "Asked", "A69");
        course.enroll(student);
        Student student2 = new Student("idk", "my name", "A68");
        assertFalse(course.drop(student2));
        assertTrue(course.drop(student));
        assertEquals(0, course.enrolled.size());
        course.drop(null);
        }
        catch(IllegalArgumentException E){
            idk = true;
        }
        assertTrue(null, idk);
    }
    @Test
    public void testCourseEnroll() {
        Course course = new Course("CSE", "12", "Data Structure", 1);
        course.enrolled = new HashSet<>();
        Student student = new Student("Ben", "Dove", "A145");
        Student student2 = new Student("Ben", "Dover", "A6969");
        course.enroll(student);
        assertFalse(course.enroll(student2));
        assertFalse(course.enrolled.contains(student2));
        assertEquals(1, course.enrolled.size());
    }
    @Test
    public void testCourseGetRoster() {
        Course course = new Course("CSE", "12", "Data Structure", 100);
        course.enrolled = new HashSet<>();
        Student stu = new Student("Whales", "Ocean", "A123");
        course.enroll(stu);
        // assertTrue(course.enroll(stu));
        // assertTrue(course.enrolled.contains(stu));
        assertEquals(course.getRoster(), course.getRoster());
    }
    @Test
    public void testSanctConstructor() {
        boolean cheecker = false;
        try{
            Sanctuary sanct = new Sanctuary(-2, 2);
            sanct.sanctuary.put("Tiger", 55);
            assertEquals(55, sanct.getTotalAnimals());
            int k = sanct.rescue("Parrot", 20);
            assertEquals(10, k);
        }
        catch(IllegalArgumentException e){
            cheecker = true;
        }
        assertEquals(true, cheecker);
    }
    @Test
    public void testSanctRescuePartial() {
        Sanctuary sanct = new Sanctuary(65, 2);
        sanct.sanctuary.put("Tiger", 55);
        assertEquals(55, sanct.getTotalAnimals());
        assertEquals(10, sanct.rescue("Tiger", 20));
    }
    @Test
    public void testSanctRescueMaxSpecies() {
        Sanctuary sanct = new Sanctuary(100, 2);
        sanct.rescue("Tiger", 50);
        assertEquals(50, sanct.getTotalAnimals());
        assertEquals(0, sanct.rescue("Parrot", 20));
        assertEquals(0, sanct.rescue("Parrot", 20));
        assertEquals(20, sanct.rescue("Apple", 20));
        assertEquals(0, sanct.rescue("Tiger", 10));
        assertEquals(10, sanct.rescue("Tiger", 10));
        assertEquals(60, sanct.countForSpecies("Tiger"));
        assertEquals(40, sanct.countForSpecies("Parrot"));
        assertEquals(2, sanct.getTotalSpecies());
    }
    @Test
    public void testSanctReleasePartial() {
        Sanctuary sanct = new Sanctuary(100, 4);
        sanct.sanctuary.put("Tiger", 55);
        assertEquals(55, sanct.getTotalAnimals());
        sanct.release("Tiger", 45);
        assertEquals(10, sanct.getTotalAnimals());
    }

    @Test
    public void testSanctReleaseTooMany() {
        boolean cheecker = false;
        try{
        Sanctuary sanct = new Sanctuary(100, 4);
        sanct.sanctuary.put("Koala", 55);
        assertEquals(55, sanct.getTotalAnimals());
        sanct.release("Koala", 66);
        }
        catch(IllegalArgumentException E){
            cheecker = true;
        }
        assertEquals(true, cheecker);
    }
}
