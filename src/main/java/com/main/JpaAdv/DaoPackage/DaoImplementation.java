package com.main.JpaAdv.DaoPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.JpaAdv.EntityPackage.Instructor;
import com.main.JpaAdv.EntityPackage.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class DaoImplementation implements Dao{

    @Autowired
    public EntityManager entmanager;

    public DaoImplementation(EntityManager entmanager)
    {
        this.entmanager = entmanager;
    }

    @Override
    @Transactional
    public void saveInstructor(Instructor instructor) {

        entmanager.persist(instructor);
        
    }

    @Override
    public Instructor findById(int i) {
        
        Instructor intObj = entmanager.find(Instructor.class, i);
        return intObj;

    }

    @Override
    public InstructorDetail findInsDetailById(int i) {
        InstructorDetail detailobj = entmanager.find(InstructorDetail.class,i);
        return detailobj;
    }

}
