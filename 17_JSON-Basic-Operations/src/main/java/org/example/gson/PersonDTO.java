package org.example.gson;

import com.google.gson.annotations.Expose;

import java.util.Date;
import java.util.List;

public class PersonDTO {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    private boolean isMarried;
    @Expose
    private Date birthday;
    @Expose
    private AddressDTO address;
    @Expose
    private List<String> friendsList;

    public PersonDTO(String firstName, String lastName, int age, boolean isMarried, Date birthday, AddressDTO address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isMarried = isMarried;
        this.birthday = birthday;
        this.address = address;
    }

    public void setFriendsList(List<String> friendsList) {
        this.friendsList = friendsList;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", isMarried=" + isMarried +
                ", birthday=" + birthday +
                ", address=" + address +
                ", friendsList=" + friendsList +
                '}';
    }
}
