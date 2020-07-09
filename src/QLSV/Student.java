/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSV;

/**
 *
 * @author HOANG NAM
 */
public class Student {
    int id;
    String fullname, gender, mail, phone_number;
    int age;
    public Student(){
    }

    public Student(int id, String fullname, String gender, String mail, String phone_number, int age) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.mail = mail;
        this.phone_number = phone_number;
        this.age = age;
    }

    public Student(String fullname, String gender, String mail, String phone_number, int age) {
        this.fullname = fullname;
        this.gender = gender;
        this.mail = mail;
        this.phone_number = phone_number;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
