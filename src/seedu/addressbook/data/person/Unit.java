package seedu.addressbook.data.person;

public class Unit {
    private static final int FLOOR = 0;
    private static final int UNIT_NUMBER = 1;
    
    /*
     * UNIT NUMBER FORMAT: (FLOOR)-(UNIT_NUMBER)
     * Example: B1-82
     */
    
    private int unitNumber;
    private String floor;
    
    public Unit(String unitNumberString){
        setUnitNumber(unitNumberString);
    }
    
    public String getUnitNumber(){
        return floor+"-"+unitNumber;
    }
    
    public void setUnitNumber(String unitNumberString){
        String[] unitNumberField = unitNumberString.split("-");
        floor = unitNumberField[FLOOR];
        this.unitNumber = Integer.parseInt(unitNumberField[UNIT_NUMBER]);
    }
}
