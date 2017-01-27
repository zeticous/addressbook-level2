package seedu.addressbook.data.person;

public class PostalCode {
    private int postalCode;
    
    public PostalCode(String postalCode){
        setPostalCode(postalCode);
    }
    
    public int getPostalCode(){
        return postalCode;
    }
    
    public void setPostalCode(String postalCode){
        this.postalCode = Integer.parseInt(postalCode);
    }
}
