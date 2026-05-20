package com.main.JpaAdv.EntityPackage;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

     @Column(name = "firstname")
    private String first_name;

     @Column(name = "lastname")
    private String last_name;

    
     @Column(name = "email")
    private String email_id;

    @ManyToMany(mappedBy = "students",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
})
    private List<course> Courses;


    public Student() {
    }


    public Student(String first_name, String last_name, String email_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_id = email_id;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getFirst_name() {
        return first_name;
    }


    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }


    public String getLast_name() {
        return last_name;
    }


    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public String getEmail_id() {
        return email_id;
    }


    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }


    public List<course> getCourses() {
        return Courses;
    }


    public void setCourses(List<course> courses) {
        Courses = courses;
    }


    @Override
    public String toString() {
        return "Student [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email_id="
                + email_id + "]";
    }

    public void addCourse(course tempcourse)
    {
        if(Courses == null)
        {
            Courses = new ArrayList<>();
        }
        Courses.add(tempcourse);
        tempcourse.addStudent(this);
    }

}
