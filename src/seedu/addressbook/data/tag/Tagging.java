package seedu.addressbook.data.tag;

import java.util.ArrayList;

import seedu.addressbook.data.person.Person;

public class Tagging {
    public static final int STATE_ADD_TAG = 0;
    public static final int STATE_REMOVE_TAG = 1;
    
    Tag tag;
    Person person;
    int state;
    
    public Tagging(Tag tag, Person person, int state){
        this.tag = tag;
        this.person = person;
        this.state = state;
    }
    
    @Override
    public String toString(){
        switch(state){
        case STATE_ADD_TAG:
            return "+ "+person.getName()+" "+tag.toString();
        case STATE_REMOVE_TAG:
            return "+ "+person.getName()+" "+tag.toString();
        default:
            return "INVALID_STRING";
        }
    }
}
