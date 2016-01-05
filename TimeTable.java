/*
File Name: TimeTable.java
Course: ICS4U1-01
Teacher Name: Ms. Zeng
Name: Jing Li & Nicole Zhang
Date: December 22, 2014
Description: The following program creates a TimeTable object and has all time table-related functions.
*/

//This imports all necessary packages.
import java.util.*;

//This is the declaration of the class.
public class TimeTable{
   //This is the declaration of the field.
   private ArrayList<Course> courseChosen;
   
   //These are the constructors of the class.
   //It takes in an array of Course objects as the parameter and creates a TimeTable object.
   public TimeTable (ArrayList<Course> courses){
      courseChosen = courses;
   }
   
   //It takes in no parameters and creates a TimeTable object.
   public TimeTable(){
      courseChosen = null;
   }
   
   //This is the mutator of the class.
   //It takes in a an array of Course objects and returns no value.
   public void setCourseChosen (ArrayList<Course> newChosenCourses){
      courseChosen = newChosenCourses;
   }
   
   //This is the accessor of the class.
   //It takes in no parameters and returns an array of Course objects.
   public ArrayList<Course> getCourseChosen(){
      return courseChosen;
   }
   
   //This is a helper method that would call the other permuteCourses method.
   //It takes in no parameters and returns no values.
   public void permuteCourses(){
      permuteCourses (courseChosen.size(),courseChosen, "");
   }
   
   //This is a method that would incorporate recursion to print out all possible combination of courses the student has chosen.
   //It takes in an array of Course objects and a String as its parameters and returns no values.
   public void permuteCourses(int length, ArrayList<Course> courses, String soFarCombo){
      if (length == 0){
         boolean repeat = false;
         String[] courseList = soFarCombo.split("\n");
         String temCourse;
         
         //This checks if any of the courses in the combination are repeated.
         for (int i = 0; i < courseList.length && !repeat; i ++){
            temCourse = courseList[i];
            
            for (int j = i + 1; j < courseList.length && !repeat; j ++){
               if (temCourse.equals(courseList[j])){
                  repeat = true;
               }
            }
         }
         
         //This only prints out combinations with no repetitions.
         if (!repeat){
            System.out.println (soFarCombo);
         }
      }else {
         for (int i = 0; i < courses.size(); i ++){
            permuteCourses (length - 1, courses, soFarCombo + courses.get(i).getCourseCode() + "\n");
         }
      }
   }
      
   //This overrides the original method in the Object class.
   //This is a method that would convert all information of a TimeTable object into a presentable String.
   //It takes in no parameters and returns a String.
   @Override
   public String toString(){
      //This initializes an empty String that would be used to store all information about a Teacher object.
      String info = "";
      
      //This stores all the information related to a TimeTable object into the empty string.
      info = info + "Courses Chosen: \n";
      for (int i = 0; i < courseChosen.size(); i ++){
         info = info + courseChosen.get(i).getCourseCode() + "\n";
      }
            
      return info;
   }
}