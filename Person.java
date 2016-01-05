/*
File Name: Person.java
Course: ICS4U1-01
Teacher Name: Ms. Zeng
Name: Jing Li & Nicole Zhang
Date: December 22, 2014
Description: The following program is the Person class that builds the foundation for the other(Student and Teacher) classes.
*/

//This is the declaration of the class.
public class Person {
   //These are the declarations of the fields.
   protected Name name;
  
   //This is the constructor for the class.
   //It takes in a String and creates a partial Person object.
   public Person (String fullName){
      name = new Name (fullName);
   }
   
   //This is the mutator of the class.
   //It takes in a Name object and returns no value.
   public void setName (Name newName){
      name = newName;
   }
   
   
   //This is the accessor of the class.
   //It takes in no parameters and returns a Name object.
   public Name getName(){
      return name;
   }
}