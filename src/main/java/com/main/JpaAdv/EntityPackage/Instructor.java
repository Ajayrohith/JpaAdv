package com.main.JpaAdv.EntityPackage;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.Mapping;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "intructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "firstname")
    private String first_name;

    @Column(name = "lastname")
    private String last_name;

    @Column(name = "email")
    private String email;

      @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;


    @OneToMany(mappedBy = "instructor",fetch = FetchType.LAZY,
    cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    private List<course> courseRef;

    public Instructor() {
    }

    public Instructor(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<course> getCourseRef() {
        return courseRef;
    }

    public void setCourseRef(List<course> courseRef) {
        this.courseRef = courseRef;
    }

      public InstructorDetail getInstructorDetail() {
            return instructorDetail;
        }

        public void setInstructorDetail(InstructorDetail instructorDetail) {
            this.instructorDetail = instructorDetail;
        }

  

 //Adding method for bidirectional relationship

       @Override
public String toString() {
    return "Instructor [Id=" + Id +
            ", first_name=" + first_name +
            ", last_name=" + last_name +
            ", email=" + email + "]";
}

        public void add (course TempCourse)
        {
            //System.out.println(courseRef.toString());
            if(courseRef == null)
            {
                System.out.println("creating a new array list");
                courseRef = new ArrayList<>();
            }

            courseRef.add(TempCourse);
            TempCourse.setInstructor(this);
 
        }

      

    

}
