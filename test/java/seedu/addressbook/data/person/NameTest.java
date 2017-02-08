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
}
