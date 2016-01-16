/*
File Name: ComputerStudies.java
Description: The following program creates a specific department object and implements some 
             department-related functions.
*/

//This imports all necessary packages.
import java.util.*;

//This is the declaration of the class.
public class ComputerStudies extends Department{
   //This is the constructor of the class that initializes the fields.
   //It takes an array of Teacher objects, an array of Course objects, and an integer as parameters and creates a Department object.
   public ComputerStudies(ArrayList<Teacher> computerTeachers, ArrayList<Course> computerCourses, int number){
      departmentNum = number;
      teacherList = computerTeachers;
      courseOffered = computerCourses;
      acl = determineACL(); 
   }
   
   //This overrides the abstract method in the Department class.
   //It determines the ACL based on the diversity of courses the teach is able to teach.
   //If more than one teacher has the maximum number of courses a teacher can teach, then the ACL
   //will be given to the teacher whose name will appear first when the list is sorted alphabetically.
   //It takes in no parameter and returns a Teacher object.
   public Teacher determineACL(){
      //This initializes the ACL to be the first teacher in the array.
      Teacher temACL = teacherList.get(0);
      
      //This loops through the teacher list to find the teacher with the most diverse teaching ability.
      for (int i = 1; i < teacherList.size(); i ++){
            //This checks if the teacher array in the list has more diversity in the number of courses he/she can teach.
         if (temACL.compareToTeachingDiversity(teacherList.get(i)) < 0){
            temACL = teacherList.get(i);
         }
         else if (temACL.compareToTeachingDiversity(teacherList.get(i)) == 0){
               //This returns the Teacher object who is lexicographically less.
            if (teacherList.get(i).compareToName(temACL) < 0){
               temACL = teacherList.get(i);
            }
         }   
      }
      
      return temACL;
   }

}
