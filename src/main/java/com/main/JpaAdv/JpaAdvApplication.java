package com.main.JpaAdv;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.main.JpaAdv.DaoPackage.Dao;
import com.main.JpaAdv.EntityPackage.Instructor;
import com.main.JpaAdv.EntityPackage.InstructorDetail;
import com.main.JpaAdv.EntityPackage.Review;
import com.main.JpaAdv.EntityPackage.course;

@SpringBootApplication
public class JpaAdvApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(Dao daoobj)
	{
		return args ->
		{
			//createInstructor(daoobj);
			//findInstructorById(daoobj);
			//findInstructorDetail(daoobj);
			//createIntructorwithCOurses(daoobj);
			//FindInstructorCourse(daoobj);
			//Find_Instructor_Along_With_Course_Lazy(daoobj);
		//	DeleteInstructor(daoobj);
			Deletecourse(daoobj);
		//	createReview(daoobj);
		};
	}


	private void createReview(Dao daoobj) {
		course tempCourse = daoobj.findCourse(3);

		Review tempRev = new Review("The Best Course");

		tempCourse.add(tempRev);

		daoobj.SaveReview(tempCourse);
	}

	private void Deletecourse(Dao daoobj) {
		int a = 3;
		daoobj.DeleteCourse(a);
		System.out.println("Course deleted successfully");
	}

	private void DeleteInstructor(Dao daoobj) {
		
		int a = 3;

		System.out.println("Inside Delete instructor function");
		daoobj.DeleteInstructor(a);
		System.out.println("Deleted successfully");
	}

	private void Find_Instructor_Along_With_Course_Lazy(Dao daoobj) {
		

		int a = 4;
		List<course>  tempcourse = daoobj.FindCourseForSpecificId(a);
		System.out.println("Course returned from function : "+ tempcourse.toString());

		Instructor tempInstructor = daoobj.findById(a);

		System.out.println("The initial instructor details : "+ tempInstructor.toString());

		tempInstructor.setCourseRef(tempcourse);

		System.out.println("The final instructor : "+ tempInstructor.toString());
		System.out.println("Course Details : "+ tempInstructor.getCourseRef());
	}

	private void FindInstructorCourse(Dao daoobj) {
		System.out.println("FInding instructor and their course");
		Instructor tempIns = daoobj.findById(4);
		System.out.println(tempIns.toString());
		System.out.println(tempIns.getCourseRef().toString());
	}

	private void createIntructorwithCOurses(Dao daoobj) {

		Instructor instructor = new Instructor("sachin", "tendulakar", "sachin@gmail.com");

		InstructorDetail insDetail = new InstructorDetail("sachinPages", "odi");


		instructor.setInstructorDetail(insDetail);

		course course1 = new course("social");

		course course2 = new course("Evs");

		instructor.add(course1);
		instructor.add(course2);

		daoobj.saveInstructor(instructor);
	}

	// Start One to One Mapping Functions

	// private void findInstructorDetail(Dao daoobj) {
		
	// 	InstructorDetail insDetail = daoobj.findInsDetailById(1);
	// 	System.out.println("The intructor detail is : "+insDetail.toString());

	// 	System.out.println("The instructor is :" + insDetail.getInstructor().toString());
	// }

	// private void findInstructorById(Dao daoobj) {
		
	// 	Instructor obj = daoobj.findById(1);
	// 	System.out.println("The returned Instructor is :"+obj.toString());

	// }

	// private void createInstructor(Dao daoobj) {
		
	// 	Instructor instructor = new Instructor("Muthu", "Kumar", "Kumar11@gmail.com");

	// 	InstructorDetail insDetail = new InstructorDetail("MuthuPages", "Football");


	// 	instructor.setInstructorDetail(insDetail);

	// 	daoobj.saveInstructor(instructor);

	// 	System.out.println ("Returned after instructor and details added");

	// }

	// End One to One Mapping Functions

}
