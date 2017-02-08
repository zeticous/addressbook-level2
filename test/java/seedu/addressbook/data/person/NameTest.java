package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * 
 * @zeticous Created to start TDD on isSimilar Method
 *
 */
public class NameTest {
    @Test
    public void testIsSimilar_differentName() throws IllegalValueException{
        Name testName = new Name("potato");
        assertFalse(testName.isSimilar("celery"));
    }
    
    @Test
    public void testIsSimilar_sameName() throws IllegalValueException{
        Name testName = new Name("potato");
        assertTrue(testName.isSimilar("potato"));
    }
    
    @Test
    public void testIsSimilar_nullOther() throws IllegalValueException{
        Name testName = new Name("potato");
        assertFalse(testName.isSimilar(null));
    }
    
    @Test
    public void testIsSimilar_nameDifferentOrder() throws IllegalValueException{
        Name testName = new Name("huge potato");
        assertTrue(testName.isSimilar("potato huge"));
    }
    
    @Test
    public void testIsSimilar_otherSubsetOfName() throws IllegalValueException{
        Name testName = new Name("really huge potato");
        assertTrue(testName.isSimilar("potato huge"));
    }
    
    @Test
    public void testIsSimilar_nameDifferentOrderHasCommas() throws IllegalValueException{
        Name testName = new Name("huge potato");
        assertTrue(testName.isSimilar("potato,huge"));
    }
    
    @Test
    public void testIsSimilar_nameSubsetOfOther() throws IllegalValueException{
        Name testName = new Name("huge potato");
        assertFalse(testName.isSimilar("really potato huge"));
    }
    
    @Test
    public void testIsSimilar_sameNamesDifferentCapitalisation() throws IllegalValueException{
        Name testName = new Name("huge potato");
        assertTrue(testName.isSimilar("HUGE POTATO"));
    }
}
