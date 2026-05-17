package com.main.JpaAdv.DaoPackage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.JpaAdv.EntityPackage.Instructor;
import com.main.JpaAdv.EntityPackage.InstructorDetail;
import com.main.JpaAdv.EntityPackage.course;

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

    @Override
    public List<course> FindCourseForSpecificId(int i) {
        
        List<course> courseobj = entmanager.createQuery("SELECT c FROM course c WHERE c.instructor.id = :id",course.class).
        setParameter("id", i).getResultList();

        return courseobj;

    }

    @Override
    @Transactional
    public void DeleteInstructor(int i) {
        
        Instructor tempins = entmanager.find(Instructor.class, i);

        List<course> courses = tempins.getCourseRef();

        for(course tempcourse : courses)
        {
            tempcourse.setInstructor(null);
        }
        entmanager.remove(tempins);

    }

    
}
