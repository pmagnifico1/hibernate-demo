package com.spring.hibernate_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import com.spring.hibernate_demo.dao.StudentDao;
import com.spring.hibernate_demo.entity.Student;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

  @Bean
  CommandLineRunner commandLineRunner(StudentDao studentDao) {
    return runner -> {
      // createStudent(studentDao);
      // readStudent(studentDao);
      // queryStudents(studentDao);
      // queryStudentLastName(studentDao);
      // updateStudent(studentDao);
      // deleteStudent(studentDao);
      // deleteAllStudent(studentDao);
    };
  }

  private void deleteAllStudent(StudentDao studentDao){
    System.out.println("Deleting all student information...");
    int rowsDeleted = studentDao.deleteAll();
    System.out.println("Number of deleted rows: " + rowsDeleted);
  }

  private void deleteStudent(StudentDao studentDao){
    int id = 1;
    System.out.println("Delete ID: " + id);
    studentDao.delete(id);
  }

  private void updateStudent(StudentDao studentDao){
    int id = 1;
    System.out.println("Student ID: " + id);
    Student student = studentDao.findById(id);
    System.out.println("Updating student name...");
    student.setFirstName("Dark");
    studentDao.update(student);
    System.out.println("Updated student information: " + student);
  }

  private void queryStudentLastName(StudentDao studentDao){
    List<Student> students = studentDao.findByLastName("Avellana");
    for(Student s: students){
      System.out.println(s);
    }
  }

  private void queryStudents(StudentDao studentDao){
    List<Student> students = studentDao.findAll();
    for(Student s: students){
      System.out.println(s);
    }
  }

  private void createStudent(StudentDao studentDao){
    System.out.println("Creating student information...");
    Student student = new Student("Jhqq", "Avellana",
                                  "jhqqavellana@example.com");
    System.out.println("Saving student information...");
    studentDao.save(student);
    System.out.println("Saved! Generated id: " + student.getId());
  }

  private void readStudent(StudentDao studentDao){
    System.out.println("Retrieving student id 4...");
    Student student = studentDao.findById(4);
    System.out.println("Found the student: " + student);
  }


}

