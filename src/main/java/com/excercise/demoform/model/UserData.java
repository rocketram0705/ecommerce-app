package com.excercise.demoform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="userdata")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sno")
    private Long sNo;
    @Column(name = "name")
    private String name;
    @Column(name="fathername")
    private String fatherName;
    @Column(name="dob")
    private String date;
    @Column(name="address")
    private String address;
    @Column(name="password")
    private String password;
    public UserData() {
    }
    public UserData(Long sNo, String name, String fatherName, String date, String address,String password) {
        this.sNo = sNo;
        this.name = name;
        this.fatherName = fatherName;
        this.date = date;
        this.address = address;
        this.password = password;
    }
    public Long getsNo() {
        return sNo;
    }
    public void setsNo(Long sNo) {
        this.sNo = sNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFatherName() {
        return fatherName;
    }
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPassword (String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
}
