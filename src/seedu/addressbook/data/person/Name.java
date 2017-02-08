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
        
        HashMap<String,Integer> fullNameWordMap = new HashMap<String,Integer>();
        
        String fullNameWithoutCommas = fullName.replaceAll(","," ").toLowerCase();
        String otherNameWithoutCommas = other.replaceAll(","," ").toLowerCase();
        
        String[] fullNameWords = fullNameWithoutCommas.split(" ");
        String[] otherNameWords = otherNameWithoutCommas.split(" ");
        
        for(String word: fullNameWords){
            if(fullNameWordMap.containsKey(word)){
                fullNameWordMap.put(word, fullNameWordMap.get(word)-1);
            } else {
                fullNameWordMap.put(word, 1);
            }
        }
        
        for(String word: otherNameWords){
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
