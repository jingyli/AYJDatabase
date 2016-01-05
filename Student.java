/*
File Name: Student.java
Course: ICS4U1-01
Teacher Name: Ms. Zeng
Name: Jing Li & Nicole Zhang
Date: December 22, 2014
Description: The following program creates a Student object and has all student-related functions.
*/

//This imports all necessary packages.
import java.util.*;

//This is the declaration of the class.
public class Student extends Person{
   //This is the declaration of the constant.
   private final int MAX_SCHEDULE = 4;
   
   //These are the declarations of the fields.   
   private int studentNum;
   private TimeTable schedule;
   
   //These are the constructors for the class.
   //It takes in a String, an integer, and an array of Course objects as parameters and creates a Student object.
   public Student (String fullName,int number, ArrayList<Course> coursesChosen){
      super (fullName);
      studentNum = number;
      schedule = new TimeTable (coursesChosen);
   }
   
   //It takes in a String and an integer as parameters and creates a Student object. 
   public Student (String fullName, int number){
      super (fullName);
      studentNum = number;
      schedule = new TimeTable();
   }
   
   //These are the mutators of the class.
   //It takes in an integer and returns no value.
   public void setStudentNum (int newNumber){
      studentNum = newNumber;
   }
   
   //It takes in a TimeTable objects and returns no value.
   public void setSchedule (TimeTable newSchedule){
      schedule = newSchedule;
   }
   
   //These are the accessors of the class.
   //It takes in no parameters and returns an integer.
   public int getStudentNum(){
      return studentNum;
   }
   
   //It takes in no parameters and returns a TimeTable object.
   public TimeTable getSchedule(){
      return schedule;
   }
   
   //This is a method that would compare two Student objects' names.
   //It takes in a Student object as the argument and returns an integer to represent the difference between the two Student objects' names.
   //It returns a negative value if the argument's name is greater, 0 if the two names are equal, and a positive value if the argument's name
   //is less.
   public int compareToName (Student other){
      return name.compareToName(other.name);
   }
   
   //This is a method that would compare two Student objects' names.
   //It takes in a Student object as the argument and returns a boolean to represent the difference between the two Name objects.
   //It returns false if any part of the name is not the same and true if both first and last names are equal.
   public boolean equalsName(Student other){
      //This returns the lexicographical difference between the two Names (both first and last names).
      return name.equals(other.name);
   }

   
   //This is a method that would compare two Student objects' student numbers.
   //It takes in a Student object as the argument and returns an integer to represent the difference between the two Student objects' student numbers.
   //It returns a negative value if the argument's student number is greater, 0 if the two numbers are equal, and a positive value if the argument's student  
   // number is less.
   public int compareToStudentNum (Student other){
      return studentNum - other.studentNum;
   }
   
   //This overrides the original method in the Object class.
   //This is a method that would convert all information of a Student object into a presentable String.
   //It takes in no parameters and returns a String.
   @Override
   public String toString(){
      //This initializes an empty String that would be used to store all information about a Teacher object.
      String info = "";
      
      //This stores all the information related to a Student object into the empty string.
      info = info + "Student Name: \n" + name.toString();
      info = info + "Student Number: " + studentNum;
      info = info + "\nTime Table Chosen:\n" + schedule.toString();
            
      return info;
   }
   
   //This method adds a chosen course to the existing student's schedule if there is an empty space.
   //It takes in a Course object for the corresponding course and returns no value.
   //It outputs an error message if there is no empty spaces left in the student's schedule.
   public void addChosenCourse(Course newCourse){
      //This finds the student's current schedule size.
      int scheduleSize = schedule.getCourseChosen().size();
      
      //This checks if the course is already selected by the student.
      boolean chosen = false;
      
      for (int i = 0; i < scheduleSize && !chosen; i ++){
         if (schedule.getCourseChosen().get(i).compareToCourseCode(newCourse) == 0){
            chosen = true;
         }
      }
      
      //This checks the capacity of the student's schedule.
      //It adds the course if the schedule has 3 or fewer courses and outputs an error message if the schedule has 4 courses.
      if (scheduleSize < MAX_SCHEDULE && !chosen){
         schedule.getCourseChosen().add(scheduleSize, newCourse);
         System.out.println ("The course is add from the student's schedule.");
      }else {   
         //This outputs an error message if the entire schedule if full.
         System.out.println ("Sorry. The student's schedule is full or the course is already in the student's time table.");
         System.out.println ("No new courses can be added.");
      }
   }
   
   //This method deletes a chosen course from the existing student's schedule if such a course can be found.
   //It takes in a Course object for the corresponding course and returns no value.
   //It outputs an error message if there is no such course found in the student's existing schedule.
   public void deleteChosenCourse(Course deletedCourse){
      //This initializes a boolean to be false to assume that there is such a course yet to be found in the student's 
      //existing schedule.
      boolean found = false;
      
      //This loops through the student's existing schedule to find the course.
      for (int i = 0; i < schedule.getCourseChosen().size() && !found; i ++){
         Course temCourse = schedule.getCourseChosen().get(i);
         if (temCourse.getCourseCode() == deletedCourse.getCourseCode()){
            found = true;
            //This deletes the selected course by issuing the value of the course to be null.
            schedule.getCourseChosen().remove(i);
            System.out.println ("The course is removed from the student's schedule.");
         }
      }
      
      //This outputs an error message if there is no such a course in the student's existing schedule.
      if (!found){
         System.out.println ("Sorry. The student did not select this course.");
         System.out.println ("No courses can be deleted.");
      }
   }
   
   
}