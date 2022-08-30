package phonebook.entity;

public class Contact {

    String firstName;

    String secondName;

    String town;

    String country;

    String phoneNumber;

    public Contact(){}

    public Contact(String firstName, String secondName, String town, String country, String phoneNumber){
        this.firstName = firstName;
        this.secondName = secondName;
        this.town = town;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getSecondName(){
        return this.secondName;
    }

    public String getTown(){
        return this.town;
    }

    public String getCountry(){
        return this.country;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setFirstName(String newFirstName){
        this.firstName = newFirstName;
    }

    public void setSecondName(String newSecondName){
        this.secondName = newSecondName;
    }

    public void setTown(String newTown){
        this.town = newTown;
    }

    public void setCountry(String newCountry){
        this.country = newCountry;
    }

    public void setPhoneNumber(String newPhoneNumber){
        this.phoneNumber = newPhoneNumber;
    }


}
