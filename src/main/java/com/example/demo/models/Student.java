package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    private String name;
    private float weight;
    private float height;
    private String hairColor;
    private float gpa;
    private String gender;
    private int yearOfBirth;
    public Student() { 
    }
    public Student(String name, float weight, float height, String hairColor, float gpa, String gender, int yearOfBirth) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.hairColor = hairColor;
        this.gpa = gpa;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getWeight() {
        return weight;
    }
    public float getHeight() {
        return height;
    }
    public String getHairColor() {
        return hairColor;
    }
    public float getGpa(){
        return gpa;
    }
    public String getGender(){
        return gender;
    }
    public int getYearOfBirth(){
        return yearOfBirth;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setWeight(float weight){
        this.weight = weight;
    }
    public void setHeight(float height){
        this.height = height;
    }
    public void setGpa(float gpa){
        this.gpa = gpa;
    }
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    
}
