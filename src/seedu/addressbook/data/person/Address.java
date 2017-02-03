package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = 
            "Addresses must be in the format BLOCK,STREET,FLOOR-UNIT,POSTALCODE";
    public static final String ADDRESS_VALIDATION_REGEX = "(.*),(.*),(.*)-(.*),(.*)";
    
    public static final int ADDRESS_INDEX_BLOCK = 0;
    public static final int ADDRESS_INDEX_STREET = 1;
    public static final int ADDRESS_INDEX_UNIT = 2;
    public static final int ADDRESS_INDEX_POSTAL_CODE = 3;
    public static final int ADDRESS_FIELD_COUNT = 4;
    
    private boolean isPrivate;
    
    private Block addressBlock;
    private Street addressStreet;
    private Unit addressUnit;
    private PostalCode addressPostalCode;
    
    public String value;
    /*
     * Validates given address.
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        /*
         * Address Format: a/ BLOCK, STREET, FLOOR-UNIT, POSTAL_CODE
         */
        
        String[] addressField = splitAddress(address);
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        fillAddressField(addressField);
        value = toString();
    }
    
    public String[] splitAddress(String address){
        return address.split(",");
    }
    
    public void fillAddressField(String[] addressField){
        addressBlock = new Block(addressField[ADDRESS_INDEX_BLOCK].trim());
        addressStreet = new Street(addressField[ADDRESS_INDEX_STREET].trim());
        addressUnit = new Unit(addressField[ADDRESS_INDEX_UNIT].trim());
        addressPostalCode = new PostalCode(addressField[ADDRESS_INDEX_POSTAL_CODE].trim());
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return addressBlock.getBlockNumber()+", "+addressStreet.getStreetName()+", "
                +addressUnit.getUnitNumber()+", "+addressPostalCode.getPostalCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
