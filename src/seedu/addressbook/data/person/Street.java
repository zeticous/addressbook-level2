package seedu.addressbook.data.person;

public class Street {
    private String streetName;
    
    public Street(String streetName){
        setStreetName(streetName);
    }
    
    public String getStreetName(){
        return streetName;
    }
    
    public void setStreetName(String streetName){
        this.streetName = streetName;
    }
}
