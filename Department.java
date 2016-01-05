/*
File Name: Department.java
Course: ICS4U1-01
Teacher Name: Ms. Zeng
Name: Jing Li & Nicole Zhang
Date: December 22, 2014
Description: The following program has all department-related functions.
*/

//This imports all necessary packages.
import java.util.*;

//This is the declaration of the class.
abstract class Department{
   //These are the declarations of the fields.
   protected Teacher acl;
   protected int departmentNum;
   protected ArrayList<Teacher> teacherList;
   protected ArrayList<Course> courseOffered;
   
   //These are the mutators of the class.
   //It takes in a Teacher object and returns no value.
   public void setACL (Teacher newACL){
      acl = newACL;
   }
   
   //It takes in an integer and returns no value.
   public void setDepartmentNum (int newNumber){
      departmentNum = newNumber;
   }
   
   //It takes in an array of Teacher objects and returns no value.
   public void setTeacherList (ArrayList<Teacher> newTeacherList){
      teacherList = newTeacherList;
   }
   
   //It takes in an array of Course objects and returns no value.
   public void setCourseOffered (ArrayList<Course> newCourseOffered){
      courseOffered = newCourseOffered;
   }
   
   //These are the accessors of the class.
   //It takes in no parameters and returns a Teacher object.
   public Teacher getACL(){
      return acl;
   }
   
   //It takes in no parameters and returns an integer.
   public int getDepartmentNum(){
      return departmentNum;
   }
   
   //It takes in no parameters and returns an array of Teacher objects.
   public ArrayList<Teacher> getTeacherList(){
      return teacherList;
   }
   
   //It takes in no parameters and returns an array of Course objects.
   public ArrayList<Course> getCourseOffered(){
      return courseOffered;
   }
   
   //This is the abstract method that determines the ACL of each department.
   //It takes in no parameters and returns a Teacher object.
   abstract Teacher determineACL();
   
   //This is a method that would compare two Department objects to see which one has a smaller department number.
   //It takes in a Department object as the argument and returns an integer to show the difference between the two objects' department numbers.
   //It returns a negative value if the argument's department number is greater, 0 if both numbers are equal to one another, and a positive value
   //if the argument's department number is less.
   public int compareToDepartmentNumber(Department other){
      return departmentNum - other.departmentNum;
   }
   
   //This is a method that finds the difference between the department numbers.
   //It takes in an integer the argument and returns an integer to show the difference between the department numbers.
   //It returns a negative value if the argument is greater, 0 if both numbers are equal to one another, and a positive value
   //if the argument is less.
   public int compareToDepartmentNumber(int otherDepartmentNum){
      return departmentNum - otherDepartmentNum;
   }
   
   //This overrides the original method in the Object class.
   //This is a method that would convert all information of a Teacher object into a presentable String.
   //It takes in no parameters and returns a String.
   @Override
   public String toString(){
      //This initializes an empty String that would be used to store all information about a Teacher object.
      String info = "";
      
      //This stores all the information related to a Teacher object into the empty string.
      info = info + "ACL: \n" + acl.getName() + "\n";
      info = info + "Department Number: " + departmentNum;
      info = info + "\nTeachers: \n"; 
      
      for (int i = 0; i < teacherList.size(); i ++){
         info = info + teacherList.get(i).getName() + "\n";     
      }
      
      info = info + "Courses Offered:\n";      
      for (int i = 0; i < courseOffered.size(); i ++){
         info = info + courseOffered.get(i).getCourseCode() + "\n";     
      }
      
      return info;
   }
}