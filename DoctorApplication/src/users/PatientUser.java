/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

/**
 *
 * @author Matt
 */
public class PatientUser implements User{
    public static String userID = "";
    public String name = "";
    public String address = "";
    public String sex = "";
    int age;
    public PatientUser(String userID, String name, String address, String sex, int age)
    {
    this.userID = userID;
    this.name = name;
    this.address = address;
    this.sex = sex;
    this.age = age;
    }
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
