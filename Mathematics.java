/*
File Name: Mathematics.java
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
public class Mathematics extends Department{
   //This is the constructor of the class that initializes the fields.
   //It takes in an array of Teacher objects, an array of Course objects, and an integer as parameters and creates a Department object.
   public Mathematics(ArrayList<Teacher> mathTeachers, ArrayList<Course> mathCourses, int number){
      departmentNum = number;
      teacherList = mathTeachers;
      courseOffered = mathCourses;
      acl = determineACL(); 
   }
   
   //This overrides the abstract method in the Department class.
   //It determines the ACL based on the number of courses a teacher is able to teach and his/her experience of teaching.
   //If more than one teacher has the maximum combination, then the ACL is the teacher whose name will appear first in the list if it is sorted alphabetically.
   //It takes in no parameters and returns a Teacher object.
   public Teacher determineACL(){
      //This initializes the ACL to be the first teacher in the array.
      Teacher temACL = teacherList.get(0);
      
      //This loops through the teacher list to find the teacher with the longest experience.
      for (int i = 1; i < teacherList.size(); i ++){
         int experienceDif = temACL.compareToExperience(teacherList.get(i));
         int teachingDivDif = temACL.compareToTeachingDiversity(teacherList.get(i));
         
         if (experienceDif + teachingDivDif < 0){
            temACL = teacherList.get(i);
         }
         else if (experienceDif + teachingDivDif == 0){
            if (teacherList.get(i).compareToName(temACL) < 0){
               temACL = teacherList.get(i);
            }
         }
      }
      return temACL;
   } 
}