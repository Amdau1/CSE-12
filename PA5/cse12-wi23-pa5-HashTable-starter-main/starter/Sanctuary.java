/*
 * Name: Amdadul Haque
 * Email: ahaque@ucsd.edu
 * PID: A16817502
 * Sources used: Tutors, TA office hours, and class notes
 * The main purpose of this file is to create a santuray with animals
 * You are able to count how many animals you have in the santuary as well
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
 * This class uses 3 instance variable to create a santuary
 * Also has few mathods to save and remove animals from the santuary
 */
public class Sanctuary {
    HashMap<String, Integer> sanctuary;
    private final int maxAnimals;
    private final int maxSpecies;
    /**
     * This method initializes the instance variable
     * @param maxAnimals the maximum number of animals that can be in santuary
     * @param maxSpecies the maximum number of species 
     */
    public Sanctuary(int maxAnimals, int maxSpecies){
        if(maxAnimals <= 0 || maxSpecies <= 0 || maxSpecies > maxAnimals){
            throw new IllegalArgumentException();
        }
        this.maxAnimals = maxAnimals;
        this.maxSpecies = maxSpecies;
        sanctuary = new HashMap<>();
    }
    /**
     * This method counts the amount of given species in the sanctuary
     * @param species the species that we are looking ro
     * @return the number of given species.
     */
    public int countForSpecies(String species){
        int count = 0;
        if(species == null){
            throw new IllegalArgumentException();
        }
        if(sanctuary.containsKey(species)){
           count = sanctuary.get(species);
        }
        if(count > 0){
            return count;
        }
        else{
            return 0;
        }
    }
    /**
     * This method gives the total number of animals in the sanctuary
     * @return the total animals count in the santuary
     */
    public int getTotalAnimals(){
        int returnvalue = 0;
        for(Integer key : sanctuary.values()){
            returnvalue += key;
        }
        return returnvalue;
    }
    /**
     * This method tells us the total amount of species in the sanctuary
     * @return the total amount of species in the sanctuary
     */
    public int getTotalSpecies(){
       return sanctuary.size(); 
    }
    /**
     * This method tells us how much animals we can put in the sanctuary
     * @return the maximum number of animals allowed in the sanctuary
     */
    public int getMaxAnimals(){
        return maxAnimals;
    }
    /**
     * This method tells us how much species we can put in the sanctuary
     * @return the maximum number of species allowed in the sanctuary
     */
    public int getMaxSpecies(){
        return maxSpecies;
    }
    /**
     * This method adds the given amount of the given species if possible
     * @param species the species that we want to add
     * @param num the number of the given species we are adding to sanctuary
     * @return the number that we were unable to add to santuary
     */
    public int rescue(String species, int num){
        if(num <= 0 || species == null){
            throw new IllegalArgumentException();
        }
        // Looping through the hashmap
        int totalAnimals = 0;
        for(Integer key : sanctuary.values()){
            totalAnimals += key;
        }
        int input = maxAnimals - totalAnimals;
        // Adding number of animals to the santary if possible
        if(num < maxAnimals && sanctuary.containsKey(species) && totalAnimals< maxAnimals){
            if((totalAnimals + num) > maxAnimals){
                sanctuary.put(species, input + sanctuary.get(species));
                return num - input;
            }
            else{
                sanctuary.put(species, num + sanctuary.get(species));
                return 0;
            }
        }
        else if(num < maxAnimals && sanctuary.size() < maxSpecies&& totalAnimals < maxAnimals){
            if((totalAnimals + num) > maxAnimals){
                sanctuary.put(species, input);
                return num - input;
            }
            else{
                sanctuary.put(species, num);
                return 0;
            }
        }
        else{
            return num;
        }
    }
    /**
     * This method removes the given amount of number from the given species
     * @param species the species that we want to remove
     * @param num the amount of that given species we are removing
     */
    public void release(String species, int num){
        if(species == null || sanctuary.containsKey(species) == false || sanctuary.get(species) == null){
            throw new IllegalArgumentException();
        }
        int v = sanctuary.get(species);
        if(num <= 0 || num > v){
            throw new IllegalArgumentException();
        }
        if(num < v){
            int y =  v - num;
            sanctuary.put(species , y);
        }
        else{
            sanctuary.remove(species);
        }
    }
}