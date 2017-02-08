package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";
    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        String trimmedName = name.trim();
        if (!isValidName(trimmedName)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = trimmedName;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }
    
    /**
     * Returns true if the names are similar
     */
    public boolean isSimilar(String other){
        if(other == null){
            return false;
        }
        
        String formattedFullName = formatNameToLowerCaseWithoutCommas(fullName);
        String formattedOtherName = formatNameToLowerCaseWithoutCommas(other);
        
        String[] fullNameFragments = createNameFragments(formattedFullName);
        String[] otherNameFragments = createNameFragments(formattedOtherName);
        
        HashMap<String,Integer> fullNameWordMap = intialiseNameWordMap(fullNameFragments);
        
        return compareOtherToWordMap(otherNameFragments, fullNameWordMap);
    }
    
    /**
     * Compare the words in the other name in the word map.
     * @param otherNameFragments: string array with individual words in 
     *        lower case.
     * @param fullNameWordMap: HashMap containing the individual words 
     *        of the full name.
     * @return
     */
    private boolean compareOtherToWordMap(String[] otherNameFragments, HashMap<String, Integer> fullNameWordMap) {
        for(String word: otherNameFragments){
            if(fullNameWordMap.containsKey(word)){
                if(fullNameWordMap.get(word)>1){
                    fullNameWordMap.put(word,fullNameWordMap.get(word)-1);
                } else {
                    fullNameWordMap.remove(word);
                }
            } else {
                return false;
            }
        }
        
        return true;
    }

    /**
     * Creates the hashmap for comparison of the name.
     * @param string array of individual words in lower casing.
     * @return hashmap of the words in the array.
     */
    private HashMap<String,Integer> intialiseNameWordMap(String[] fullNameFragments) {
        HashMap<String,Integer> fullNameWordMap = new HashMap<String,Integer>();
        
        for(String word: fullNameFragments){
            if(fullNameWordMap.containsKey(word)){
                fullNameWordMap.put(word, fullNameWordMap.get(word)-1);
            } else {
                fullNameWordMap.put(word, 1);
            }
        }
        
        return fullNameWordMap;
    }
    /**
     * format the name for the isSimilar method.
     * @param a string of the name.
     * @return name in lower case with commas replaced with white space.
     */
    private String formatNameToLowerCaseWithoutCommas(String name){
        return name.replace(",", " ").toLowerCase();
    }
    
    /**
     * Splits a name into its individual words.
     * @param a string of the name with all commas replaced with whitespace.
     * @return a string array containing all the individual words of the name.
     */
    private String[] createNameFragments(String formattedName){
        return formattedName.split(" ");
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

}
