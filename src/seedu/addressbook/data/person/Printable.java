package seedu.addressbook.data.person;
/*
 * Interface for any classes that has a fixed format with printable output
 */
public interface Printable {
    /*
     * Return a printable string in an appropriate format.
     * EXAMPLE: Name: John Doe , E-mail: johndoe@email.com
     * @param vararg of printable data.
     */
    public String getPrintableString(Printable... printables);
    
    /*
     * Return a string of the appropriate format.
     */
    public String getFormatString();
}
