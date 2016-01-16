/*
File Name: Teacher.java
Description: The following program creates a Teacher object and has all teacher-related functions.
*/

//This imports all necessary packages.
import java.util.*;

//This is the declaration of the class.
public class Teacher extends Person{
   //These are the declarations of the fields.
   private int experience;
   private int teacherNum;
   private ArrayList<Course> courseTaught;
   
   //This is the constructor of the class.
   //It takes in a String, two integers, and an array of Course objects as parameters and creates a Teacher object.
   public Teacher (String fullName, int number, int experienceInYears, ArrayList<Course> courses){
      super (fullName);
      experience = experienceInYears;
      teacherNum = number;
      courseTaught = courses;
   }
   
   //These are the mutators of the class.
   //It takes in an integer and returns no value.
   public void setTeacherNum (int newNumber){
      teacherNum = newNumber;
   }
   
   //It takes in an integer and returns no value.
   public void setExperience (int newExperience){
      experience = newExperience;
   }
   
   //It takes in an array of Courses and returns no value.
   public void setCourseTaught (ArrayList<Course> newCourses){
      courseTaught = newCourses;
   }

   //These are the accessors of the class.
   //It takes in no parameters and returns an integer.
   public int getTeacherNum(){
      return teacherNum;
   }
   
   //It takes in no parameters and returns an integer.
   public int getExperience(){
      return experience;
   }

   //It takes in no parameters and returns an array of Course objects.
   public ArrayList<Course> getCourseTaught (){
      return courseTaught;
   }
   
   //This is a method that would compare two Teacher objects' names.
   //It takes in a Teacher object as the argument and returns an integer to represent the difference between the two Teacher objects' names.
   //It returns a negative value if the argument's name is greater, 0 if the two names are equal, and a positive value if the argument's name
   //is less.
   public int compareToName (Teacher other){
      return name.compareToName(other.name);
   }
   
   //This is a method that would compare two Teacher objects' names.
   //It takes in a Teacher object as the argument and returns a boolean to represent the difference between the two Name objects.
   //It returns false if any part of the name is not the same and true if both first and last names are equal.
   public boolean equalsToName(Teacher other){
      //This returns the lexicographical difference between the two Names (both first and last names).
      return name.equals(other.name);
   }

   
   //This is a method that would compare two Teacher objects' experiences.
   //It takes in a Teacher object as the argument and returns an integer to represent the difference between the two Teacher objects' experiences.
   //It returns a negative value if the argument's experience is greater, 0 if the two names are equal, and a positive value if the argument's experience
   //is less.
   public int compareToExperience (Teacher other){
      return experience - other.experience;
   }
   
   //This is a method that would compare two Teacher objects' teacher numbers.
   //It takes in a Teacher object as the argument and returns an integer to represent the difference between the two Teacher objects' teacher numbers.
   //It returns a negative value if the argument's teacher number is greater, 0 if the two names are equal, and a positive value if the argument's teacher number
   //is less.
   public int compareToTeacherNum (Teacher other){
      return teacherNum - other.teacherNum;
   }
   
   //This is a method that would compare two Teacher objects' abilities to teach multiple courses.
   //It takes in a Teacher object as the argument and returns an integer to represent the difference between the two Teacher objects' array lengths of Course objects.
   //It returns a negative value if the argument's array is longer, 0 if the two arrays are equal in length, and a positive value if the argument's array
   //is shorter.
   public int compareToTeachingDiversity (Teacher other){
      return courseTaught.size() - other.courseTaught.size();
   }
   
   //This overrides the original method in the Object class.
   //This is a method that would convert all information of a Teacher object into a presentable String.
   //It takes in no parameters and returns a String.
   @Override
   public String toString(){
      //This initializes an empty String that would be used to store all information about a Teacher object.
      String info = "";
      
      //This stores all the information related to a Teacher object into the empty string.
      info = info + "Teacher Name: \n" + name.toString();
      info = info + "Teacher Number: " + teacherNum;
      info = info + "\nExperience in Years: " + experience;
      
      info = info + "\nNumber of Courses He/She is Able to Teach: " + courseTaught.size();
      info = info + "\nCourses List: \n";
      for (int i = 0; i < courseTaught.size(); i ++){
         info = info + courseTaught.get(i).getCourseCode() + "\n";     
      }
      
      return info;
   }
   
   //This is the method that will search for the position of the course in the array of Course objects of a Teacher object.
   //It takes in an integer and returns a integer.
   public int findCourse(String courseCode){
      //This checks if the teacher can be found
      for (int i = 0; i < courseTaught.size(); i ++){
         if (courseTaught.get(i).getCourseCode().equals(courseCode)){
            return i;
         }
      } 
      return -1;
   }
}
