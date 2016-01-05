/*
File Name: Music.java
Course: ICS4U1-01
Teacher Name: Ms. Zeng
Name: Jing Li & Nicole Zhang
Date: December 22, 2014
Description: The following program creates a specific department object and implements some 
             department-related functions.
*/

//This imports all necessary packages.
import java.util.*;

//This is the declaration of the class.
public class Music extends Department{
   //This is the constructor of the class that initializes the fields.
   //It takes in an array of Teacher objects, an array of Course objects, and an integer as parameters and creates a Department object.
   public Music(ArrayList<Teacher> musicTeachers, ArrayList<Course> musicCourses, int number){
      departmentNum = number;
      teacherList = musicTeachers;
      courseOffered = musicCourses;
      acl = determineACL(); 
   }
   
   //This overrides the abstract method in the Department class.
   //It determines the ACL based on the experience each teacher has in teaching.
   //If more than one teacher has the longest experience, it returns the teacher who is at the front of the list if the list is sorted alphabetically.
   //It takes in no parameters and returns a Teacher object.
   public Teacher determineACL(){
      //This initializes the ACL to be the first teacher in the array.
      Teacher temACL = teacherList.get(0);
      
      //This loops through the teacher list to find the teacher with the longest experience.
      for (int i = 1; i < teacherList.size(); i ++){
      
            //This checks if the teacher in the array has a longer experience in teaching.
         if (temACL.compareToExperience(teacherList.get(i)) < 0){
            temACL = teacherList.get(i);
         }
         else if (temACL.compareToExperience(teacherList.get(i)) == 0){
            //This returns the Teacher object who is lexicographically less.
            if (teacherList.get(i).compareToName(temACL) < 0){
               temACL = teacherList.get(i);
            }
         }
      }
      
      return temACL;
   }
}