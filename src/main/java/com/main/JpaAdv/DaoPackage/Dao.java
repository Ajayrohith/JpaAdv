package com.main.JpaAdv.DaoPackage;

import java.util.List;

import com.main.JpaAdv.EntityPackage.Instructor;
import com.main.JpaAdv.EntityPackage.InstructorDetail;
import com.main.JpaAdv.EntityPackage.course;

public interface Dao {

    public void saveInstructor(Instructor instructor);

    public Instructor findById(int i);

    public InstructorDetail findInsDetailById(int i);

    public List<course> FindCourseForSpecificId(int i);

    public void DeleteInstructor(int i );


}
