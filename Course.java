/*
File Name: Course.java
Description: The following program creates a Course object and has all course-related functions.
*/

//This is the declaration of the class.
public class Course{
   //These are the declarations of the fields.
   private String courseCode;
   private int size;
   private Teacher teacher;
   
   //This is the constructor for the class.
   //It takes in a String, an integer, and a Teacher object as parameters and creates a Course object.
   public Course (String courseCode, int size, Teacher teacher){
      this.courseCode = courseCode;
      this.size = size;
      this.teacher = teacher;
   }
   
   //These are the mutators of the class.
   //It takes in a String and returns no value.
   public void setCourseCode (String newCourseCode){
      courseCode = newCourseCode;
   }
   
   //It takes in an integer and returns no values.
   public void setSize(int newSize){
      size = newSize;
   }
   
   //It takes in a Teacher object and returns no value.
   public void setTeacher (Teacher newTeacher){
      teacher = newTeacher;
   }
   
   //These are the accessors of the class.
   //It takes in no parameters and returns a String.
   public String getCourseCode(){
      return courseCode;
   }
   
   //It takes in no parameters and returns an integer.
   public int getSize(){
      return size;
   }
   
   //It takes in no parameters and returns a Teacher object.
   public Teacher getTeacher(){
      return teacher;
   }
   
   //This is a method that would compare two Course objects' names.
   //It takes in a Course object as the argument and returns an integer to represent the difference between the two Course objects' course codes.
   //It returns a negative value if the argument's course code is lexicographically greater, 0 if the two course codes are equal, and a positive value if the argument's course code
   //is lexicographically less.
   public int compareToCourseCode (Course other){
      return courseCode.compareTo(other.courseCode);
   }
   
   //This is a method that would compare the difference of two course codes.
   //It takes in an integer as the argument and returns an integer to represent the difference between the course codes.
   //It returns a negative value if the argument is lexicographically greater, 0 if the two course codes are equal, and a positive value if the argument
   //is lexicographically less.
   public int compareToCourseCode (String otherCourseCode){
      return courseCode.compareTo(otherCourseCode);
   }
   
   //This overrides the original method in the Object class.
   //This is a method that would convert all information of a Course object into a presentable String.
   //It takes in no parameters and returns a String.
   @Override
   public String toString(){
      //This initializes an empty String that would be used to store all information about a Teacher object.
      String info = "";
      
      //This stores all the information related to a Course object into the empty string.
      info = info + "Course Code: " + courseCode;
      info = info + "\nMaximum Number of Students Admitted to the Course: " + size;
      if (teacher != null){
         info = info + "\nTeacher Responsible:\n" + teacher.getName();
      }else{
         info = info + "\nNo teacher is responsible for the course.";
      }
            
      return info;
   }
}
