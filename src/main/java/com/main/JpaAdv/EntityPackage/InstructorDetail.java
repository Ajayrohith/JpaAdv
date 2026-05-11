package com.main.JpaAdv.EntityPackage;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Detail_id;

    @Column(name = "youtube_channel")
    private String Channel;

    @Column(name = "hoby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)
    private Instructor instructor;

    public String getChannel() {
        return Channel;
    }

    public void setChannel(String channel) {
        Channel = channel;
    }


    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public InstructorDetail(String channel, String hobby) {
        Channel = channel;
        this.hobby = hobby;
    }

    public InstructorDetail() {
    }

    public int getDetail_id() {
        return Detail_id;
    }

    public void setDetail_id(int detail_id) {
        Detail_id = detail_id;
    }

    

   
  

    @Override
    public String toString() {
        return "InstructorDetail [Detail_id=" + Detail_id + ", Channel=" + Channel + ", hobby=" + hobby + "]";
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }





}
