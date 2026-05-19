package com.main.JpaAdv.EntityPackage;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class course {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name ="title")
    private String title;



    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany(mappedBy = "Course",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Review> review;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }




    public Instructor getInstructor() {
        return instructor;
    }


    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }


    public course(String title) {
        this.title = title;
    }


    public course() {
    }

    


    @Override
    public String toString() {
        return "course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
    }


    public List<Review> getReview() {
        return review;
    }


    public void setReview(List<Review> review) {
        this.review = review;
    }


   public void add(Review tempreview)
   {
        if(review == null)
        {
            review = new ArrayList<>();
        }

        review.add(tempreview);
        tempreview.setCourse(this);
   }


   

    

}
