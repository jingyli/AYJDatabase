/*
File Name: Name.java
Course: ICS4U1-01
Teacher Name: Ms. Zeng
Name: Jing Li & Nicole Zhang
Date: December 22, 2014
Description: The following program creates a Name object and has all name-related functions.
*/

//This is the declaration of the class.
public class Name{
   //These are the declarations of the fields.
   private String first;
   private String last;
   
   //This is the constructor of the class.
   //It takes in a String and creates a Name object.
   public Name (String fullName){
      //This stores temporarily the different components of a name (first name before last name).
      String[] partsOfName = fullName.split(" ");
         
         //This initializes the fields with the different components of the name.
      if (partsOfName.length == 1){
         first = fullName;
         last = "";
      }
      else{
         first = partsOfName[0];
         last = partsOfName[1];
      }
   }
   
   //These are the mutators of the class.
   //It takes in a String and returns no value.
   public void setFirst(String firstName){
      first = firstName;
   }
   
   public void setLast(String lastName){
      last = lastName;
   }
   
   //These are the accessors of the class.
   //It takes in no parameters and returns a String.
   public String getFirst(){
      return first;
   }
   
   public String getLast(){
      return last;
   }
   
   //This is a method that would compare two Name objects lexicographically, starting with the first name.
   //It takes in a Name object as the argument and returns a boolean to represent the difference between the two Name objects.
   //It returns false if any part of the name is not the same and true if both first and last names are equal.
   public boolean equalsToName(Name other){
      //This returns the lexicographical difference between the two Names (both first and last names).
      return first.equals(other.first) && last.equals(other.last);
   }
   
   //This is a method that would compare two Name objects lexicographically, starting with the first name.
   //It takes in a Name object as the argument and returns an integer to represent the difference between the two Name objects.
   //It returns a negative value if the argument is lexicographically greater, 0 if the two Strings are equal, and a positive value if the argument
   //lexicographically less.
   public int compareToName(Name other){
      //This returns the lexicographical difference between the two Names (both first and last names).
      return first.compareTo(other.first) + last.compareTo(other.last);
   }
   
   //This overrides the original method in the Object class.
   //This is a method that would convert all information of a Name object into a presentable String.
   //It takes in no parameters and returns a String.
   @Override
   public String toString(){
      return "First Name: " + first +"\nLast Name: " + last +"\n";
   }
}