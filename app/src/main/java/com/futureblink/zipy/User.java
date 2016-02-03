package com.futureblink.zipy;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Neeraj on 02-Feb-16.
 */
public class User implements Parcelable{
    private String name;
    private String address;
    private String phoneNumber;
    private String dob;
    private String password;
    private String email;

    public User(Parcel in){
        readFromParcel(in);
    }
    public User()
    {}

    public User(String address, String name, String phoneNumber, String dob, String password, String email) {
        this.address = address;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.password = password;
        this.email = email;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(phoneNumber);
        dest.writeString(dob);
        dest.writeString(password);
        dest.writeString(email);
    }
    private void readFromParcel(Parcel in) {
        name = in.readString();
        address = in.readString();
        phoneNumber = in.readString();
        dob = in.readString();
        password = in.readString();
        email = in.readString();
    }
}


