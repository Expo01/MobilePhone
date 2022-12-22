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
            //new contact added if no index prresent
            System.out.println("Contact is already on file");
            return false;
        }

        myContacts.add(contact);
        return true;

    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if(foundPosition <0) {
            System.out.println(oldContact.getName() +", was not found.");
            return false;
        }

        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if(foundPosition <0) {
            System.out.println(contact.getName() +", was not found.");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted.");
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for(int i=0; i<this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i); //local contact variable created and set to string value of all indexes
            // each index value tested to have same content as intended new name to ensure no duplication
            if(contact.getName().equals(contactName)) { //returns index of name if already on file
                return i;
            }
        }
        return -1; //returns -1 if not on file
    }

    public String queryContact(Contact contact) {
        if(findContact(contact) >=0) {
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name) {
        int position = findContact(name); //call string parameter variant of findContact and returns index
        if(position >=0) {
            return this.myContacts.get(position);
        }

        return null;
    }

    public void printContacts() {
        System.out.println("Contact List");
        for(int i=0; i<this.myContacts.size(); i++) { //loops through mobilePhone ArrayList and prints name and number
            System.out.println((i+1) + "." +
                    this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getPhoneNumber());
        }

    }

}