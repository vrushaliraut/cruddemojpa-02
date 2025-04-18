package com.example.cruddemojpa_02;

import com.example.cruddemojpa_02.dao.AppDAO;
import com.example.cruddemojpa_02.entity.Course;
import com.example.cruddemojpa_02.entity.Instructor;
import com.example.cruddemojpa_02.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Cruddemo02Application {

    public static void main(String[] args) {
        SpringApplication.run(Cruddemo02Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            // createInstructor(appDAO);

            // findInstructor(appDAO);

            // deleteInstructor(appDAO);

            // findInstructorDetail(appDAO);

            // deleteInstructorDetail(appDAO);

            // createInstructorWithCourses(appDAO);

            // findInstructorWithCourses(appDAO);

            //  findCoursesForInstructor(appDAO);

            // findInstructorWithCoursesJoinFetch(appDAO);

            // updateInstructor(appDAO);

            //updateCourse(appDAO);

            //deleteInstructor(appDAO);

            deleteCourse(appDAO);
        };
    }

    private void deleteCourse(AppDAO appDAO) {
        int theId = 3;
        System.out.println("Deleting course id: " + theId);
        appDAO.deleteCourseById(theId);
        System.out.println("Done!");
    }

    private void updateCourse(AppDAO appDAO) {
        int theId = 4;
        // find the course
        System.out.println("Finding course id: " + theId);
        Course tempCourse = appDAO.findCourseById(theId);
        System.out.println("Original Course" + tempCourse);
        // update the course
        tempCourse.setTitle("Pacman - How To Score One Million Points");
        appDAO.update(tempCourse);
        System.out.println("Updated course: " + tempCourse);
    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 1;
        // find the instructor
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("Original Instructor" + tempInstructor);
        // update the instructor
        tempInstructor.setFirstName("Scooby");
        tempInstructor.setLastName("Doo");
        appDAO.update(tempInstructor);
        System.out.println("Updated instructor: " + tempInstructor);
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
        System.out.println("tempInstructor: " + tempInstructor);

        System.out.println("Courses: " + tempInstructor.getCourses());
        System.out.println("Done!");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor: " + tempInstructor);

        // find courses for instructor
        System.out.println("Finding courses for instructor id: " + theId);
        List<Course> coursesByInstructorId = appDAO.findCoursesByInstructorId(theId);
        // associate the objects
        tempInstructor.setCourses(coursesByInstructorId);
        System.out.println("the associated courses: " + tempInstructor.getCourses());
        System.out.println("Done!");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor: " + tempInstructor);

        System.out.println("Courses: " + tempInstructor.getCourses());
        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        // create the instructor
        Instructor tempInstructor =
                new Instructor("Madhu", "Patel", "madhu@luv2code.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail("http://www.luv2code.com/youtube", "Guitar");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // create some courses
        Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
        Course tempCourse2 = new Course("The Pinball Masterclass");

        // add courses to instructor
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        // save the instructor
        // NOTE: this will ALSO save the courses
        // because of CascadeType.PERSIST
        //
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("Done!");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        // get the instructor detail object
        int theId = 2;
        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

        // print the instructor detail
        System.out.println("tempInstructorDetail: " + tempInstructorDetail);

        // print the associated instructor
        System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
        System.out.println("Done!");
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);
        appDAO.deleteInstructorById(theId);
        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 2;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated instructorDetail: " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
        /*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Chad", "Darby", "darby@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Luv 2 code!!!");
		*/

        // create the instructor
        Instructor tempInstructor =
                new Instructor("Madhu", "Patel", "madhu@luv2code.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail("http://www.luv2code.com/youtube", "Guitar");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        //
        // NOTE: this will ALSO save the details object
        // because of CascadeType.ALL
        //
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

}
