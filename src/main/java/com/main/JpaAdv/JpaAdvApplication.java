package com.main.JpaAdv;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.main.JpaAdv.DaoPackage.Dao;
import com.main.JpaAdv.EntityPackage.Instructor;
import com.main.JpaAdv.EntityPackage.InstructorDetail;

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
			findInstructorDetail(daoobj);
		};
	}

	private void findInstructorDetail(Dao daoobj) {
		
		InstructorDetail insDetail = daoobj.findInsDetailById(1);
		System.out.println("The intructor detail is : "+insDetail.toString());

		System.out.println("The instructor is :" + insDetail.getInstructor().toString());
	}

	private void findInstructorById(Dao daoobj) {
		
		Instructor obj = daoobj.findById(1);
		System.out.println("The returned Instructor is :"+obj.toString());

	}

	private void createInstructor(Dao daoobj) {
		
		Instructor instructor = new Instructor("Muthu", "Kumar", "Kumar11@gmail.com");

		InstructorDetail insDetail = new InstructorDetail("MuthuPages", "Football");


		instructor.setInstructorDetail(insDetail);

		daoobj.saveInstructor(instructor);

		System.out.println ("Returned after instructor and details added");

	}

}
