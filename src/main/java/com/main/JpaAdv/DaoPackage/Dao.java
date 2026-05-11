package com.main.JpaAdv.DaoPackage;

import com.main.JpaAdv.EntityPackage.Instructor;
import com.main.JpaAdv.EntityPackage.InstructorDetail;

public interface Dao {

    public void saveInstructor(Instructor instructor);

    public Instructor findById(int i);

    public InstructorDetail findInsDetailById(int i);

}
