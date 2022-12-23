import java.util.ArrayList;

/**
 * Created by dev on 28/08/15.
 */
public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>(); //creation of new Arraylist during construction of MobilePhone object
    }

    public boolean addNewContact(Contact contact) {
        if(findContact(contact.getName()) >=0) { //calls getName instance method from Contact class on contact object and returns string
            //findContact(string) then tests that string value and returns the positive index of existing name or -1;
            //new contact added if no index present
            System.out.println("Contact is already on file");
            return false;
        }

        myContacts.add(contact);
        return true;

    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact); // finds index of existing Contact object in the ArrayList
        if(foundPosition <0) {
            System.out.println(oldContact.getName() +", was not found."); //prints string field value of the Contact
            return false;
        } else if (findContact(newContact.getName()) != -1){
            System.out.println("Contact with name " + newContact.getName() + " already exists. Update not successful");
            return false;
        }

        this.myContacts.set(foundPosition, newContact); //assigns new contact fields to index of old contact
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact); //calls findContact method of contact parameter type and returns index
        if(foundPosition <0) {
            System.out.println(contact.getName() +", was not found.");
            return false;
        }
        this.myContacts.remove(foundPosition); //uses java inbuilt method '.remove' to modify 'this.myContacts' ArrayList
        //at specified index
        System.out.println(contact.getName() + ", was deleted.");
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact); //returns index using inbuilt java method called on ArrayList
                                                    // 'this.myContacts'
    }

    private int findContact(String contactName) {
        for(int i=0; i<this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i); //local contact variable created and has both name and number
                                                    // fields associated with each index/occurrence of a contact object
            if(contact.getName().equals(contactName)) { //returns String value of name field of that contact index and
                                                    // compares to string value of name being tested
                return i; //returns the contact at index (i)
            }
        }
        return -1; //returns -1 if not on file
    }

    public String queryContact(Contact contact) {
        if(findContact(contact) >=0) { // calls findContact with Contact parameter type and returns its index
            return contact.getName(); // retrieves string field of contact object if index indicates contact exists
        }
        return null;
    }

    public Contact queryContact(String name) {
        int position = findContact(name); //call string parameter variant of findContact and returns index
        if(position >=0) {
            return this.myContacts.get(position); //returns the name and number fields of contact object at the index
        }

        return null;
    }

    public void printContacts() {
        System.out.println("Contact List");
        for(int i=0; i<this.myContacts.size(); i++) { //loops through mobilePhone ArrayList and prints name and number
            //of each Contact instance within the ArrayList
            System.out.println((i+1) + "." +
                    this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getPhoneNumber());
        }

    }

}