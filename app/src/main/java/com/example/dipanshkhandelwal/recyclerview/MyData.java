package com.example.dipanshkhandelwal.recyclerview;

/**
 * Created by DIPANSH KHANDELWAL on 29-05-2017.
 */

public class MyData {

    String Name;
    String Address;
    String PhoneNumber;

    public MyData(String name, String address, String phoneNumber) {
        Name = name;
        Address = address;
        PhoneNumber = phoneNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
