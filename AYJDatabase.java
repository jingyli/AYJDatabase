/*
File Name: AYJDatabase.java
Description: The following program is the core of the AYJDatabase program.
             It contains all the functions of the program and executes the GUI interface.
*/

//This is the import of all necessary packages.
import java.util.*;
import java.io.*;
import java.lang.*;

//This is the declaration of the class.
public class AYJDatabase{
   //These are the declarations of the fields.
   private ArrayList<Student> studentList = new ArrayList<Student>();
   private ArrayList<Course> courseList = new ArrayList <Course>();
   private ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
   private ArrayList<Department> departmentList = new ArrayList<Department>();
   
   //This is the method that executes the program.
   //It takes in no parameter and returns no values.
   public void run(){
      //This initializes a boolean to be false to initiate the running of the program.
      boolean quit = false;
      boolean successInit = false;
      boolean validChoice = false;
      boolean validInput = false;
      Scanner sc = new Scanner (System.in);
      int choice = -1;
      String addInfoType, printInfoType, fileName;
      int sortInfoType = -1;
      int searchInfoType = -1;
      Department temDepartment;
      Course temCourse;
      Student temStudent = null;
      Teacher temTeacher;
      int departmentNum = -1;
      String courseCode;
      Name name;
      
      //This prints out a welcoming message to the user.
      System.out.println ("Welcome to the AYJDatabase application.");
      System.out.println();
      
      //This is a method that would initialize the program with appropriate information.
      while (!successInit){
         successInit = initProgram();
         
         //This prints out error messages to indicate that initialization did not complete. 
         if (!successInit){ 
            System.out.println("Initialization failed. Please try again.");           
            System.out.println();
            System.out.println ("Help: Please make sure your file is in the correct format and try other methods of input.");
            System.out.println();  
         }
      }
      System.out.println();
      
      //This shows that the user has yet to exit the execution of the program.
      while (!quit){
         printOptions();
         
         while (!validChoice){
            System.out.println();
            System.out.print ("Enter the number that corresponds to the desired choice: ");
            
            //This checks if the user is entering a valid option.
            try{
               choice = sc.nextInt();
               
               if (choice < 1 || choice > 9){
                  System.out.println ("The entered choice does not exist. Please try again.");
               }
               else {
                  validChoice = true;
               }
            }
            catch (InputMismatchException imx){
               sc.nextLine();
               System.out.println ("Invalid type entered. Please try again.");
            }
         }
         
         validChoice = false;
         //This initiates the different options depending on the user selection of option.
         switch (choice){
            case 1:
               sc.nextLine();
               System.out.print ("Enter what type of information do you want to add (Department/Teacher/Student/Course): ");
               addInfoType = sc.nextLine();
               addInfoType = addInfoType.toUpperCase();
               
               if (addInfoType.equals("DEPARTMENT")){
                  addDepartment();
               }
               else if (addInfoType.equals("TEACHER")){
                  addTeacher(); 
               }
               else if (addInfoType.equals("STUDENT")){
                  addStudent();
               }
               else if (addInfoType.equals("COURSE")){
                  addCourse();
               }
               else{
                  System.out.println ("This type of information is invalid.");
               }
               
               break;
            case 2:
               sc.nextLine();
               System.out.print ("Enter what type of information do you want to delete (Department/Teacher/Student/Course): ");
               addInfoType = sc.nextLine();
               addInfoType = addInfoType.toUpperCase();
               
               if (addInfoType.equals("DEPARTMENT")){
                  deleteDepartment();
               }
               else if (addInfoType.equals("TEACHER")){
                  deleteTeacher(); 
               }
               else if (addInfoType.equals("STUDENT")){
                  deleteStudent();
               }
               else if (addInfoType.equals("COURSE")){
                  deleteCourse();
               }
               else{
                  System.out.println ("This type of information is invalid.");
               }
               
               break;
            case 3:
               sc.nextLine();
               
               System.out.print ("Enter the file name (without the \".txt\" extension) you want to save the database's information to: ");
               fileName = sc.nextLine();
               
               saveAllCurrentInfo(fileName);
               
               break;
            case 4:
               System.out.println ("The following types of searching are avaliable: ");
               System.out.println ("1)Search for a specific student by his/her name.\n2)Search for a specific teacher by his/her name.");
               System.out.println ("3)Search for a course by its course code.\n4)Search for a specific department by its department number.");
               
               while (!validChoice){
                  System.out.print ("Enter a choice you want: ");
                  try{
                     searchInfoType = sc.nextInt();
                     if (searchInfoType > 0 && searchInfoType < 5){
                        validChoice = true;
                     }
                     else {
                        System.out.println ("Choice entered is not within the given range.");
                     }
                  }
                  catch (InputMismatchException imx){//This checks if the user enters the wrong type of data.
                     sc.nextLine();
                     System.out.println ("Wrong type of data inputted. Please try again.");
                  }
                  System.out.println();
               }
               
               //This calls the corresponding method to complete the user's choice of option.
               switch (searchInfoType){
                  case 1:
                     sc.nextLine();
                     
                     System.out.print ("Enter the name of the student (first last): ");
                     name = new Name (sc.nextLine());
                     System.out.println();
                     
                     temStudent = searchStudentName(name);
                     
                     if (temStudent != null){
                        System.out.println (temStudent);
                     }
                     else {
                        System.out.println ("The student does not exist in the database.");
                     }
                  
                     break;
                  case 2:
                     sc.nextLine();
                     
                     System.out.print ("Enter the name of the teacher (first last): ");
                     name = new Name (sc.nextLine());
                     System.out.println();
                     
                     temTeacher = searchTeacherName(name);
                     
                     if (temTeacher != null){
                        System.out.println (temTeacher);
                     }
                     else {
                        System.out.println ("The teacher does not exist in the database.");
                     }
                     
                     break;
                  case 3:
                     sc.nextLine();
                     
                     System.out.print ("Enter the course code of the course: ");
                     courseCode = sc.nextLine();
                     System.out.println();
                     
                     temCourse = searchCourse(courseCode);
                     
                     if (temCourse != null){
                        System.out.println(temCourse); 
                     }
                     else {
                        System.out.println ("The course does not exist in the database.");
                     }
                     
                     break;
                  default:
                     while (!validInput){
                        try{
                           System.out.print ("Enter the department number: ");
                           departmentNum = sc.nextInt();
                           
                           validInput = true;
                        }
                        catch(InputMismatchException imx){
                           sc.nextLine();
                           System.out.println ("Wrong type of data inputted. Please try again.");
                        }
                     }
                     System.out.println();
                     
                     temDepartment = searchDepartment (departmentNum);
                     
                     if (temDepartment != null){
                        System.out.println (temDepartment);
                     }
                     else {
                        System.out.println ("The department does not exist in the database.");
                     }
               }
               
               break;
            case 5:
               System.out.println ("The following types of sorting are avaliable: ");
               System.out.println ("1)Sort all students by their student numbers.\n2)Sort all teachers by their teacher numbers.");
               System.out.println ("3)Sort all departments by their departments numbers.\n4)Sort all courses by their course codes.");
               
               while (!validChoice){
                  System.out.print ("Enter a choice you want: ");
                  try{
                     sortInfoType = sc.nextInt();
                     if (sortInfoType > 0 && sortInfoType < 5){
                        validChoice = true;
                     }
                     else {
                        System.out.println ("Choice entered is not within the given range.");
                     }
                  }
                  catch (InputMismatchException imx){//This checks if the user enters the wrong type of data.
                     sc.nextLine();
                     System.out.println ("Wrong type of data inputted. Please try again.");
                  }
                  System.out.println();
               }
               
               //This calls the corresponding method to complete the user's choice of option.
               switch (sortInfoType){
                  case 1:
                     sortByStudentNum();
                     break;
                  case 2:
                     sortByTeacherNum();
                     break;
                  case 3:
                     sortByDepartmentNum();
                     break;
                  default:
                     sortByCourseCode();
               }
               break;
            case 6:
               sc.nextLine();
               
               while (!validInput){
                  System.out.print ("Enter the student's name to modify his/her time table (first last): ");
                  name = new Name (sc.nextLine());
                  
                  //This checks if the student exists in the database.
                  temStudent = searchStudentName(name);
                  
                  if (temStudent != null){
                     validInput = true;
                  }
                  else {
                     System.out.println ("The student does not exist.");
                     System.out.println ("Please try again.");
                     System.out.println();
                  }
               }
               
               modifyTimeTable(temStudent);
               
               break;
            case 7:
               printAllCombinations();
               
               break;
            case 8:
               sc.nextLine();
               System.out.print ("Enter what type of information do you want to print out (Department/Teacher/Student/Course): ");
               printInfoType = sc.nextLine();
               printInfoType = printInfoType.toUpperCase();
              
               if (printInfoType.equals ("DEPARTMENT")){
                  System.out.println("Printing all current departments' information: ");
                  System.out.println();
                  
                  reportAllDepartments();
               }
               else if (printInfoType.equals ("STUDENT")){
                  System.out.println("Printing all current students' information: ");
                  System.out.println();
                  
                  reportAllStudents();
               }
               else if (printInfoType.equals ("TEACHER")){
                  System.out.println("Printing all current teachers' information: ");
                  System.out.println();
                  
                  reportAllTeachers();
               }
               else if (printInfoType.equals ("COURSE")){
                  System.out.println("Printing all current courses' information: ");
                  System.out.println();
                  
                  reportAllCourses();
               }
               else {
                  System.out.println ("This type of information is invalid.");
                  System.out.println ("Please try again.");
               }
              
               break;
            default:
               quit = true;
         }
         
         System.out.println();
         validChoice = false;
         validInput = false;
      }  
      //This prints out an ending message to the user.
      System.out.println ("Thank you for using the AYJDatabase application!"); 
   }
   
   //This is the method that deletes a existing Department object from the department list.
   //It takes in no parameters and returns no values.
   public void deleteDepartment(){
      Scanner sc = new Scanner (System.in);
      Department temDepartment;
      int departmentNum = -1;
      boolean validInput = false;
      
      while (!validInput){
         try{
            System.out.print ("Enter the department's department number: ");
            departmentNum = sc.nextInt();
            validInput = true;
         }
         catch (InputMismatchException imx){
            System.out.println ("Wrong type of information entered.");
            System.out.println ("Please try again.");
            System.out.println (); 
         }
      }
      
      temDepartment = searchDepartment(departmentNum);
      
      if (temDepartment != null){
         departmentList.remove(temDepartment);
         System.out.println ("The department is removed from the database.");
      }
      else {
         System.out.println ("This department does not exist in the database.");
         System.out.println ("Please try again.");
      }
   }
   
   //This is the method that deletes a existing Student object from the student list.
   //It takes in no parameters and returns no values.
   public void deleteStudent(){
      Scanner sc = new Scanner (System.in);
      Student temStudent;
      Name name;
      
      System.out.print ("Enter the student's name (first last): ");
      name = new Name (sc.nextLine());
      
      temStudent = searchStudentName(name);
      
      if (temStudent != null){
         studentList.remove(temStudent);
         System.out.println ("The student is removed from the database.");
      }
      else {
         System.out.println ("This student does not exist in the database.");
         System.out.println ("Please try again.");
      }
   }
   
   //This is the method that deletes a existing Teacher object from the teacher list.
   //It takes in no parameters and returns no values.
   public void deleteTeacher(){
      Scanner sc = new Scanner (System.in);
      Teacher temTeacher;
      Course temCourse;
      int courseLen;
      Name name;
      Department temDepartment;
      boolean delete;
      
      System.out.print ("Enter the teacher's name (first last): ");
      name = new Name (sc.nextLine());
      
      temTeacher = searchTeacherName(name);
      
      if (temTeacher != null){
         teacherList.remove(temTeacher);
         
         for (int i = 0; i < courseList.size(); i ++){        
            temCourse = courseList.get(i);
            
            if (temCourse.getTeacher().equalsToName(temTeacher)){
               temCourse.setTeacher(null);
            }
         }   
         
         for (int i = 0; i < departmentList.size(); i ++){
            temDepartment = departmentList.get(i);
            
            delete = temDepartment.getTeacherList().remove(temTeacher);
            
            if (delete){
               temDepartment.setACL(temDepartment.determineACL());
            }
         } 
            
         System.out.println ("The teacher is removed from the database.");
      }
      else {
         System.out.println ("This teacher does not exist in the database.");
         System.out.println ("Please try again.");
      }
   }
   
   //This is the method that deletes a existing Course object from the course list.
   //It takes in no parameters and returns no values.
   public void deleteCourse(){
      Scanner sc = new Scanner (System.in);
      Course temCourse;
      String courseCode;
      ArrayList<Course> temCourseList;
      
      System.out.print ("Enter the course's course code: ");
      courseCode = sc.nextLine();
      
      temCourse = searchCourse(courseCode);
      
      if (temCourse != null){
         courseList.remove(temCourse);
         
         for (int i = 0; i < studentList.size(); i ++){
            temCourseList = studentList.get(i).getSchedule().getCourseChosen();         
            temCourseList.remove(temCourse);
         }
         
         for (int i = 0; i < teacherList.size(); i ++){
            temCourseList = teacherList.get(i).getCourseTaught();
            temCourseList.remove(temCourse);
         }
         
         for (int i = 0; i < departmentList.size(); i ++){
            temCourseList = departmentList.get(i).getCourseOffered();
            temCourseList.remove(temCourse);
         }
         
         System.out.println ("The course is removed from the database.");
      }
      else {
         System.out.println ("This course does not exist in the database.");
         System.out.println ("Please try again.");
      }
   }
   
   //This is the method that adds a new Department object to the existing department list.
   //It takes in no parameters and returns no values.
   public void addDepartment(){
      Scanner sc = new Scanner (System.in);
      String departmentType, courseCode;
      int departmentNum = -1;
      int teacherNum = -1;
      int teacherLen = 0;
      int courseLen = 0;
      int teacherPos;
      ArrayList<Teacher>temTeacherList = new ArrayList<Teacher>();
      ArrayList<Course>temCourseList = new ArrayList<Course>();
      boolean validType = false;
      boolean validInput = false;
      boolean exist = true;
      Course temCourse;
      
      
      System.out.print ("Enter the type of department you want to add (Music/Mathematics/Computer Studies): ");
      departmentType = sc.nextLine();
      departmentType = departmentType.toUpperCase();
      
      if (departmentType.equals("MUSIC") || departmentType.equals("MATHEMATICS") || departmentType.equals("COMPUTER STUDIES")){
         validType = true;
      }
      
      if (validType){
         while (!validInput){
            try{
               System.out.print ("Enter the department's department number: ");
               departmentNum = sc.nextInt();
               
               System.out.print ("Enter the number of teachers that will be in this department: ");
               teacherLen = sc.nextInt();
               
               for (int i = 0; i < teacherLen; i ++){
                  System.out.print ("Enter the teacher number for teacher #" + (i + 1) + ": ");
                  teacherNum = sc.nextInt();
                  
                  teacherPos = findTeacher(teacherNum);
                  
                  if (teacherPos != -1){
                     temTeacherList.add (teacherList.get(teacherPos));
                  }
                  else {
                     System.out.println ("This teacher does not exist.");
                     exist = false;
                     System.out.println ("The program continues without adding this teacher to the department.");
                  }
               }
               
               if (exist){
                  System.out.print ("Enter the number of courses that will be offered in this department: ");
                  courseLen = sc.nextInt();
               
                  for (int i = 0; i < courseLen; i ++){
                     System.out.print ("Enter the course code of course #" + (i + 1) + ": ");
                     courseCode = sc.nextLine();
                  
                     temCourse = searchCourse(courseCode);
                  
                     if (temCourse != null){
                        temCourseList.add(temCourse);
                     }
                     else {
                        System.out.println ("This course does not exist.");
                        System.out.println ("The program continues without adding this course to the department.");
                     }
                  }
               
                  validInput = true;
               }
            }
            catch(InputMismatchException imx){
               System.out.println ("Input type not valid. Please try again from the start.");
               sc.nextLine();
            }
            
            if (departmentType.equals("MUSIC")){
               departmentList.add(new Music (temTeacherList,temCourseList,departmentNum));
            }
            else if (departmentType.equals("MATHEMATICS")){
               departmentList.add(new Mathematics (temTeacherList,temCourseList,departmentNum));
            }
            else {
               departmentList.add(new ComputerStudies (temTeacherList,temCourseList,departmentNum));
            }   
         }        
      }
      else {
         System.out.println ("Selected type of department is not supported by the program.");
         System.out.println ("Please try again.");
      }
   }
   
   //This is the method that adds a new Course object to the existing course list.
   //It takes in no parameters and returns no values.
   public void addCourse(){
      Scanner sc = new Scanner (System.in);
      String courseCode, teacherType;
      int size = -1;
      int teacherNum = -1;
      int teacherPos, departmentPos;
      Teacher temTeacher;
      boolean validInput = false;
      
      System.out.print("Enter the course code: ");
      courseCode = sc.nextLine();
      
      while (!validInput){
         System.out.print("Enter the maximum number of students that can be admitted to the course: ");
          //This catches the exception of wrong type of data input.
         try{
            size = sc.nextInt();
            validInput = true;           
            sc.nextLine();
         }
         catch (InputMismatchException imx){
            System.out.println ("Input type not valid. Please try again.");
            sc.nextLine();
         }
      }
      
      validInput = false;
      
      //This checks if the teacher is an existing teacher or a new object should be made.
      System.out.print ("If the teacher responsible for the course is a new teacher, enter \"yes\": ");
      teacherType = sc.nextLine();
      teacherType = teacherType.toUpperCase();
      
      if (teacherType.equals ("YES")){
         addTeacher();
         
         courseList.add (new Course (courseCode, size, teacherList.get(teacherList.size() - 1)));
      }
      else {
         while (!validInput){
            System.out.print ("Enter the teacher number of the teacher: ");
            try{
               teacherNum = sc.nextInt();
               validInput = true;
            }
            catch (InputMismatchException imx){
               System.out.println ("Input type not valid. Please try again.");
               sc.nextLine();
            }
         }
         
         teacherPos = findTeacherByNum(teacherNum);
         
         if (teacherPos != -1){
            courseList.add (new Course (courseCode, size, teacherList.get(teacherPos)));
            System.out.println ("New course successfully added.");
         }
         else{
            System.out.println ("No such teacher exists. No new course is added.");
            System.out.println ("Please try again.");
         }
      }
   }
   
   //This is the method that adds a new Teacher object to the existing teacher list.
   //It takes in no parameters and returns no values.
   public void addTeacher(){
      Scanner sc = new Scanner (System.in);
      String teacherName, courseType;
      int teacherNum = -1;
      int coursePos;
      int departmentNum = -1;
      int experience = 0;
      int numCourses = -1;
      ArrayList<Course>temCourseList = new ArrayList<Course>();
      boolean validInput = false;
      String courseCode;
      Course temCourse;
      Department temDepartment;
      
      System.out.print ("Enter the teacher's name: ");
      teacherName = sc.nextLine();
      
      while (!validInput){          
          //This catches the error of user inputting the wrong type of information.
         try{
            System.out.print ("Enter the teacher number: ");
            teacherNum = sc.nextInt();
                        
            System.out.print ("Enter the number of years the teacher has been teaching: ");
            experience = sc.nextInt();
              
            System.out.print ("Enter the number of courses the teacher teachers: ");
            numCourses = sc.nextInt();
              
            sc.nextLine();
            validInput = true;
         }
         catch(InputMismatchException imx){
            System.out.println ("Input type not valid. Please try again.");
            sc.nextLine();
         }
      }
      
      validInput = false;
      //This reads in user inputs to fulfill the different courses the new teacher is able to teach.
      for (int i = 0; i < numCourses; i ++){
          //This checks if the course is a new course or an existing course.
         System.out.print ("Enter the course code: ");
         courseCode = sc.nextLine();
          
         temCourse = searchCourse(courseCode);
          
         if (temCourse != null){
            temCourseList.add(temCourse);
         }
      }
      
      //This adds a new Teacher object.
      teacherList.add(new Teacher (teacherName, teacherNum, experience, temCourseList));
      System.out.println ("The new teacher is successfully created.");
      
      while (!validInput){
          //This updates the new teacher to the existing department.
         try{
            System.out.print ("Enter the department number to add the teacher to an existing department: ");
            departmentNum = sc.nextInt();
              
            validInput = true;
         }
         catch (InputMismatchException imx){
            System.out.println ("Input type not valid. Please try again.");
            sc.nextLine();
         }
      }
      
      temDepartment = searchDepartment (departmentNum);
      
      if (temDepartment != null){
         temDepartment.getTeacherList().add(teacherList.get(teacherList.size() - 1));
         System.out.println ("The new teacher is successfully updated in the system.");
      }
      else{
         teacherList.remove (teacherList.size() - 1);
         
         System.out.println ("The department does not exist.");
         System.out.println ("The created teacher does not follow school regulation.");
         System.out.println ("The teacher is removed from the database.");
      }
   }
   
   //This is the method that adds a new Student object to the existing student list.
   //It takes in no parameters and returns no values.
   public void addStudent(){
      Scanner sc = new Scanner (System.in);
      int numStudent;
      int studentNum = -1; 
      int numCourse = 0;
      String studentName, courseCode;
      ArrayList<Course> temCourseList = new ArrayList<Course> ();
      Course temCourse;
      boolean validInput = false;
       
      System.out.print ("Enter the student name: ");
      studentName = sc.nextLine();
       
      while (!validInput){
         try{
            //This catches the wrong type of information the user might enter.
            System.out.print ("Enter the student number: ");
            studentNum = sc.nextInt();
           
            System.out.print ("Enter the number of courses the student is currently taking: ");
            numCourse = sc.nextInt();
           
            validInput = true;
         }
         catch (InputMismatchException imx){
            System.out.println ("Input type not valid. Please try again.");
            sc.nextLine();
         }
      }
       
      for (int i = 0; i < numCourse; i ++){
         System.out.print ("Enter the course code for course #" + (i + 1) + ": ");
         courseCode = sc.nextLine();
           
         temCourse = searchCourse (courseCode);
           
         if (temCourse != null){
            temCourseList.add(temCourse);
         }
      }
       
       //This adds the new Student object to the end of the student list.
      studentList.add(new Student (studentName, studentNum, temCourseList));
      System.out.println ("The new student is successfully created.");
   }
   
   //This is the private method that will print out all avaliable options for the user.
   //It takes in no parameters and returns no values.
   //It is a private method and can be only accessed in the AYJDatabase class.
   private static void printOptions(){
      System.out.println ("Here are your options: ");
      System.out.println ("1)Add information to current database.\n2)Delete information from current database.");
      System.out.println ("3)Save all current information onto a file.");
      System.out.println ("4)Search for specific information within the database.");
      System.out.println ("5)Sort information.");
      System.out.println ("6)Change a student's current time table.");
      System.out.println ("7)Print out all possible combinations of a student's chosen courses.");
      System.out.println ("8)Print out general information.");
      System.out.println ("9)Exit the application.");
   }
   
   //This is the method that would initiate the program with an accepted method (either file input or user input).
   //It takes in no parameters and returns a boolean value.
   public boolean initProgram(){
      //This initalizes all variables used.
      int choice = -1;
      Scanner sc = new Scanner (System.in);
      boolean validChoice = false;
      
      System.out.println ("Please choose a method to initialize the program (enter the number in front of the option): ");
      System.out.println ("1)File Input\n2)User Input");
      
      //This catches potential errorneous inputs and continues to prompt the user until the right type of information is entered.
      while (!validChoice){
         try{
            choice = sc.nextInt();
            
            //This checks if the options selected is within range.
            if (choice == 1 || choice == 2){
               //This sets the boolean to be true if the right type of data is entered. 
               validChoice = true;
            }
            else {
               System.out.println ("The selected choice is not within range.");
               System.out.println ("Please only select the options given and try again.");
            }
         }
         catch (InputMismatchException imx){
            sc.nextLine();
            System.out.println ("Invalid choice selected.");
            System.out.println ("Enter the number only and please try again.");
         }   
      } 
      
      System.out.println();           
      //This calls the corresponding initialization methods based on user input.
      if (choice == 1){
         return initFileInput();
      }
      else {
         return initUserInput();
      }
   }
   
   //This is the method that will initialize the program through a file which the user has inputted.
   //It takes in no parameters and returns a boolean to indicate the success of initialization.
   public boolean initFileInput(){
      //This initalizes all variables used.
      Scanner sc = new Scanner (System.in);
      String fileName;
      BufferedReader in;
      boolean validFile = false;
      int departmentLen, courseLen, teacherLen, totalCourseLen, scheduleLen, studentLen;
      
      int teacherCount = 0;
      int courseCount = 0;
      String departmentName, courseCode, teacherName, studentName;
      int departmentNum, teacherNum, experience, size, studentNum;
      int teacherPos, coursePos;
      ArrayList<Teacher> temTeacherList = new ArrayList<Teacher>(); 
      ArrayList<Course> temCourseList = new ArrayList<Course>();
      ArrayList<Course> courseTaught = new ArrayList<Course>();
   
      //This continues to ask the user for a valid input of file name.
      while (!validFile){
         System.out.print ("Enter the file name (without the \".txt\" extension): ");
         fileName = sc.nextLine();
         
         //This catches the multiple errors that might occur during the initialization.
         try{
            in = new BufferedReader (new FileReader (fileName + ".txt"));
            validFile = true;
            
            //This reads through the file and initializes the length of the fields.
            departmentLen = Integer.parseInt(in.readLine());
            
            in.readLine();
            //This continues to read in department information.
            for (int i = 0; i < departmentLen; i ++){
               departmentName = in.readLine();
               departmentNum = Integer.parseInt(in.readLine());
               
               teacherLen = Integer.parseInt(in.readLine());
               totalCourseLen = Integer.parseInt(in.readLine());
               
               in.readLine();
               //This creates an array of Teacher objects.
               for (int j = 0; j < teacherLen; j ++){
                  teacherName = in.readLine();
                  teacherNum = Integer.parseInt(in.readLine());
                  experience = Integer.parseInt(in.readLine());
                  courseLen = Integer.parseInt(in.readLine());
                  
                  for (int k = 0; k < courseLen; k ++){
                     courseTaught.add(new Course(in.readLine(), -1, null));
                  }
                  
                  temTeacherList.add(new Teacher (teacherName, teacherNum, experience, courseTaught));              
                  teacherList.add(teacherCount,temTeacherList.get(j));
                  teacherCount ++;
                  courseTaught = new ArrayList<Course>();
                  in.readLine();
               }
               
               //This creates an array of Course objects.
               for (int j = 0; j < totalCourseLen; j ++){
                  courseCode = in.readLine();
                  size = Integer.parseInt(in.readLine());
                  teacherPos = findTeacher(Integer.parseInt(in.readLine()));
                  
                  if (teacherPos != -1){
                     temCourseList.add (new Course (courseCode, size, teacherList.get(teacherPos)));
                     //This updates the teacher list with the corresponding courses.
                     coursePos = teacherList.get(teacherPos).findCourse(temCourseList.get(j).getCourseCode());
                     
                     if (coursePos != -1){
                        teacherList.get(teacherPos).getCourseTaught().set(coursePos, temCourseList.get(j));
                     }
                     else{//This appends the new course to the end of the teacher's list of teachable courses. 
                        teacherList.get(teacherPos).getCourseTaught().add(temCourseList.get(j));
                     }   
                  }
                  else {
                     temCourseList.add(new Course (courseCode, size, new Teacher("",-1,-1,null)));
                  }
                  
                  courseList.add(courseCount,temCourseList.get(j));
                  courseCount ++;
                  in.readLine();
               }
               
               //This creates the Department object depending on the type of Department.
               //It returns false if the department type is not supported by the program.
               departmentName = departmentName.toUpperCase();
                  
               if (departmentName.equals("MUSIC")){
                  departmentList.add (new Music (temTeacherList, temCourseList, departmentNum)); 
               }
               else if (departmentName.equals("MATHEMATICS")){
                  departmentList.add (new Mathematics(temTeacherList, temCourseList, departmentNum));
               }
               else if (departmentName.equals("COMPUTER STUDIES")){
                  departmentList.add (new ComputerStudies (temTeacherList, temCourseList, departmentNum));
               }
               else{
                  System.out.println ("Department not supported by current version.");
                  return false;
               }               
               
               temTeacherList = new ArrayList<Teacher>();
               temCourseList = new ArrayList<Course>();  
            }
            
            //This reads in the number of students.
            studentLen = Integer.parseInt(in.readLine());
            
            in.readLine();
            for (int i = 0; i < studentLen; i ++){
               studentName = in.readLine();
               studentNum = Integer.parseInt(in.readLine());
               scheduleLen = Integer.parseInt(in.readLine());
               
               for (int j = 0; j < scheduleLen; j ++){
                  courseCode = in.readLine();
                  coursePos = findCourse(courseCode);
                  
                  if (coursePos != -1){
                     temCourseList.add(courseList.get(coursePos));
                  }
                  else{//This catches if there is an illegal course selected by the student.
                     System.out.println ("Illegal course selected by a student.");
                     return false;
                  }
               }
               studentList.add(new Student (studentName, studentNum, temCourseList));
               temCourseList = new ArrayList<Course>();
               in.readLine();
            }
            
            in.close();
         }
         catch (IOException iox){//This checks if the file name exists.
            System.out.println ("File name does not exist.");
            System.out.println();
         }
         catch (NumberFormatException nfx){//This checks if the format of the file is correct.
            System.out.println ("There is an error in the format of the file.");
            return false;
         }
      }
      return true;
   }
   
   //This is the method that will search for the position of the Teacher responsible for a specific course.
   //It takes in an integer and returns a integer.
   //It is a private method that can only be accessed in the AYJDatabase class.
   private int findTeacher(int teacherNum){
      //This checks if the teacher can be found
      for (int i = 0; i < teacherList.size(); i ++){
         if (teacherList.get(i).getTeacherNum() == teacherNum){
            return i;
         }
      }
      
      return -1;
   }
   
   //This is the method that will initialize the program through user inputs of all information.
   //It takes in no parameters and returns a boolean to indicate the success of initialization.
   public boolean initUserInput(){
      Scanner sc = new Scanner (System.in);
      int departmentLen = 0; 
      int teacherLen, courseLen;
      int studentLen = 0;
      boolean validInput = false;
      
      String departmentName,teacherName, studentName, courseCode;
      int departmentNum, teacherNum, studentNum, experience, size, coursePos; 
      ArrayList<Teacher> temTeacherList = new ArrayList<Teacher>();
      ArrayList<Course> temCourseList = new ArrayList<Course>();
      Course temCourse;
      int courseCount = -1;
      int teacherCount = 0;
      
      //This inputs the number of departments.
      while (!validInput){
         System.out.print ("Enter number of departments: ");
         try{
            departmentLen = sc.nextInt();
            validInput = true;
         }
         catch (InputMismatchException imx){//This catches the error if any of the inputs are invalid.
            sc.nextLine();
            System.out.println ("Wrong type of data inputted.");
            System.out.println ("Please try again.");
            System.out.println ();
         }
      }
      
      sc.nextLine();
   
      validInput = false;
      
      //This inputs all the information related to a department.
      for (int i = 0; i < departmentLen; i ++){
         System.out.println();
         System.out.println ("Input the information for department #" + (i + 1) + ".");
         System.out.print ("Enter the department's type: ");
         departmentName = sc.nextLine();
         try{
            System.out.print ("Enter the department's number: ");
            departmentNum = sc.nextInt();
               
            System.out.print ("Enter number of teachers in this department: ");
            teacherLen = sc.nextInt();
            sc.nextLine();
               
            System.out.println();
            for (int j = 0; j < teacherLen; j ++){//This prompts the teachers in the department.
               System.out.println ("Input the information for teacher #" + (j + 1) + ".");
               System.out.print ("Enter the teacher's full name in the format of \"first last\": ");
               teacherName = sc.nextLine();
               System.out.print ("Enter the teacher's teacher number: ");
               teacherNum = sc.nextInt();
               System.out.print ("Enter the number of years the teacher has been teaching: ");
               experience = sc.nextInt();
               System.out.print ("Enter the number of courses the teacher is able to teach: ");
               courseLen = sc.nextInt();
               sc.nextLine();
                  
               System.out.println();
               for (int k = 0; k < courseLen; k ++){
                  System.out.println ("Input the information for course #" + (k + 1));
                  System.out.print ("Enter the course code: ");
                  courseCode = sc.nextLine();
                  System.out.print ("Enter the maximum number of students who can enroll in the course: ");
                  size = sc.nextInt();
                  
                  if (k != courseLen - 1){
                     sc.nextLine();
                  }
                     
                  temCourseList.add(new Course (courseCode, size, null));
                  courseList.add (temCourseList.get(k));
                  courseCount ++;
               }
                  
               temTeacherList.add(new Teacher (teacherName, teacherNum, experience, temCourseList));
               teacherList.add(temTeacherList.get(j));
                  
               for (int k = 0; k < courseLen; k ++){
                  courseList.get(courseCount).setTeacher(temTeacherList.get(j));   
               }
                  
               temCourseList = new ArrayList<Course>();
               
               if (j != teacherLen - 1){
                  sc.nextLine();
               }
               System.out.println();
            }
               
           //This prompts the courses offered by the department.
            System.out.print ("Enter the number of courses offered by the department: ");
            courseLen = sc.nextInt();
            
            sc.nextLine();
            temCourseList = new ArrayList<Course>();
            for (int j = 0; j < courseLen; j ++){
               System.out.print ("Enter the course code of course #" + (j + 1) + ": ");
               courseCode = sc.nextLine();
               
               coursePos = findCourse(courseCode);
               
               if (coursePos != -1){
                  temCourseList.add(courseList.get(coursePos));
               }
               else {
                  System.out.println ("The course does not exist.");
                  System.out.println ("Program proceed without adding this course.");
               }
            }    
               
           //This creates the Department object depending on the type of Department.
           //It returns false if the department type is not supported by the program.
            departmentName = departmentName.toUpperCase();
                  
            if (departmentName.equals("MUSIC")){
               departmentList.add (new Music (temTeacherList, temCourseList, departmentNum)); 
            }
            else if (departmentName.equals("MATHEMATICS")){
               departmentList.add (new Mathematics(temTeacherList, temCourseList, departmentNum));
            }
            else if (departmentName.equals("COMPUTER STUDIES")){
               departmentList.add (new ComputerStudies (temTeacherList, temCourseList, departmentNum));
            }
            else{
               System.out.println ("Department not supported by current version.");   
               courseList = new ArrayList<Course>();
               teacherList = new ArrayList<Teacher>();
               departmentList = new ArrayList<Department>();
               studentList = new ArrayList<Student>();
               return false;
            }
         }
         catch(InputMismatchException imx){//This catches the error if any of the inputs are invalid.
            sc.nextLine();
            System.out.println ("Wrong type of data inputted.");
            System.out.println ("Please try again.");
            System.out.println ();
            return false;
         } 
         temTeacherList = new ArrayList <Teacher>();
         temCourseList = new ArrayList<Course>();
         courseCount = -1;
         teacherCount = 0;   
      }
      
      System.out.println();
      //This inputs the number of students.
      while (!validInput){
         System.out.print ("Enter number of students: ");
         try{
            studentLen = sc.nextInt();
            validInput = true;
         }
         catch (InputMismatchException imx){//This catches the error if any of the inputs are invalid.
            sc.nextLine();
            System.out.println ("Wrong type of data inputted.");
            System.out.println ("Please try again.");
            System.out.println ();
         }
      }
      
      temCourseList = new ArrayList<Course>();
      sc.nextLine();
      //This inputs all information about the individual students.
      validInput = false;
      System.out.println();
      for (int i = 0; i < studentLen; i ++){
         try{
            System.out.println();
            System.out.println ("Input information for student " + (i + 1) + ".");
            System.out.print ("Enter the student's full name in the format of \"first last\": ");
            studentName = sc.nextLine();
            System.out.print("Enter the student's student number: ");
            studentNum = sc.nextInt();
            
            System.out.print ("Enter the number of courses the student has chosen: ");
            courseLen = sc.nextInt();
            sc.nextLine();
            
            for (int j = 0; j < courseLen; j ++){
               System.out.print ("Enter the course code of the course: ");
               courseCode = sc.nextLine();
               coursePos = findCourse (courseCode);
               
               if (coursePos != -1){
                  temCourseList.add (courseList.get(coursePos));
               }
               else {
                  System.out.println ("The course entered does not exist.");
                  
                  courseList = new ArrayList<Course>();
                  teacherList = new ArrayList<Teacher>();
                  departmentList = new ArrayList<Department>();
                  studentList = new ArrayList<Student>();
                  return false;
               }
            }
         }
         catch (InputMismatchException imx){
            sc.nextLine();
            System.out.println ("Wrong type of data inputted.");
            System.out.println ("Please try again.");
            System.out.println ();
            
            courseList = new ArrayList<Course>();
            teacherList = new ArrayList<Teacher>();
            departmentList = new ArrayList<Department>();
            studentList = new ArrayList<Student>();
            return false;
         }
            
         studentList.add (new Student (studentName, studentNum, temCourseList));
         temCourseList = new ArrayList <Course>();
      }
      return true;
   }
   
   //This is the method that will search for the position of the Teacher responsible for a specific course.
   //It takes in an integer and returns a integer.
   //It is a private method that can only be accessed in the AYJDatabase class.
   private int findTeacherByNum(int teacherNum){
      //This checks if the teacher can be found
      for (int i = 0; i < teacherList.size(); i ++){
         if (teacherList.get(i).getTeacherNum() == teacherNum){
            return i;
         }
      }
      return -1;
   }
   
   //This method will sort all student objects by their student numbers in ascending order.
   //The method implemented will be the bubble sort.
   //It takes in no parameter and returns no value.
   public void sortByStudentNum(){
      boolean keepSorting = true;
      Student swap;
     
      while(keepSorting){
         //This assumes that no swapping will occur throughout the list.
         keepSorting = false;
           
         for(int i = 0;i < studentList.size() - 1;i ++){
            //This switches the two neighbouring objects if the earlier student object has a smaller student number than the later student object.
            if((studentList.get(i)).compareToStudentNum(studentList.get(i + 1)) > 0){
               swap = studentList.get(i);
               studentList.set (i, studentList.get(i + 1));
               studentList.set (i + 1, swap);
                   
               //This signifies that a swapping has occurred and that the sorting should continue.
               keepSorting = true;  
            } 
         }
      } 
   }
   
   //This method takes in a String as the parameter and returns a Course object.
   //The method uses binary search to search for the Course object with the same course code.
   //If the course is not found, the method returns null.
   //This method will be used in the general program.
   public Course searchCourse(String courseCode){      
      //The entire list needs to be sorted before conducting the search.
      sortByCourseCode();
       
      //These are the variables declared in the method.
      int lower = 0;
      int upper = courseList.size() - 1;
      int medium;  
      int difference;
      
      while(lower <= upper){
         medium = (lower + upper) / 2;
         difference = courseList.get(medium).compareToCourseCode(courseCode);
         
         if(difference == 0){
            return courseList.get(medium);
         }
         else if(difference > 0){
            upper = medium - 1;
         }
         else{
            lower = medium + 1;
         }       
      }      
      return null;
   }
   
   //This method sorts the current course list by the individual course codes.
   //This method will incorporate the insertion sort algorithm.
   //It takes in no parameters and returns no values.
   public void sortByCourseCode(){
      //These are the variables declared in the method.
      Course tem;
      int currentIndex;
      
      for(int i = 1;i < courseList.size();i ++){
         tem = courseList.get(i);
         currentIndex = i; 
         
         while (currentIndex > 0 && courseList.get(currentIndex - 1).compareToCourseCode(courseList.get(currentIndex)) > 0){
            courseList.set(currentIndex, courseList.get(currentIndex - 1));
            currentIndex --;
         }
         
         courseList.set(currentIndex, tem);
      }
   }
   
   //This is the method that will search for the position of the course in the array of Course objects in the list of Course objects.
   //It takes in a String and returns a integer.
   //It is a private method that can only be accessed in the AYJDatabase class, specially for the initializing methods.
   private int findCourse(String courseCode){
      //This checks if the teacher can be found
      for (int i = 0; i < courseList.size(); i ++){
         if (courseList.get(i).getCourseCode().equals(courseCode)){
            return i;
         }
      }
      return -1;
   }
   
   //This method prints out all the current students' information.
   //It takes in no parameters and returns no values.
   public void reportAllStudents(){
      for(int i = 0;i < studentList.size();i ++){
         System.out.println(studentList.get(i));
         System.out.println();
      }
   }
   
   //This method prints out all the current teachers' information.
   //It takes in no parameters and returns no values.
   public void reportAllTeachers(){
      for(int i = 0;i < teacherList.size();i ++){
         System.out.println(teacherList.get(i));
         System.out.println();
      }
   }
   
   //This method prints out all the current departments' information.
   //It takes in no parameters and returns no values.
   public void reportAllDepartments(){
      for(int i = 0;i < departmentList.size();i ++){
         System.out.println(departmentList.get(i));
         System.out.println();
      }
   }
   
   //This method prints out all the current students who have chosen a specific course.
   //It takes in no parameters and returns no values.
   public void reportAllCourses(){
      for(int i = 0;i < courseList.size();i ++){
         System.out.println(courseList.get(i));
         System.out.println();
      }
   }
   
   //This method searches for the department with a specified department number. 
   //The method will implement the binary search algorithm. 
   //It takes in a integer as the parameter and returns a Department object.
   //It returns a null Department object if the department is not found with specified department number.
   public Department searchDepartment (int departmentNum){   
      //The list of departments needs to be sorted.
      sortByDepartmentNum();
     
      //This is the declaration of all necessary variables.
      int lower = 0;
      int upper = departmentList.size() - 1;
      int medium;
      int difference;
     
      while(lower <= upper){
         medium = (lower + upper) / 2;
         difference = departmentList.get(medium).compareToDepartmentNumber(departmentNum);
          
         if (difference == 0 ){
            return departmentList.get(medium);
         }
         else if (difference > 0){
            upper = medium - 1;
         }
         else{
            lower = medium + 1;
         }
      }
      return null;
   }
   
   //This method sorts all current departments by their department numbers in ascending order.
   //The method will implement the cocktail search algorithm.
   //It takes in no parameters and returns no values.
   public void sortByDepartmentNum(){
      boolean keepSorting = true;
      int currentPass = 0;
      Department temDepartment;
       
      while (keepSorting){
         keepSorting = false;
         currentPass ++;
           
         if (currentPass % 2 != 0){//This finds the Department object with the largest department number on odd turns.
            for (int i  = 0 ; i < departmentList.size() - 1; i ++){
               if (departmentList.get(i).compareToDepartmentNumber(departmentList.get(i + 1)) > 0){
                  temDepartment = departmentList.get(i);
                  departmentList.set(i, departmentList.get(i + 1));
                  departmentList.set(i + 1, temDepartment);
                       
                  keepSorting = true;
               }
            }
         }
         else{//This finds the Department object with the smallest department number on even turns.
            for (int i = departmentList.size() - 1; i > 0 ; i --){
               if (departmentList.get(i).compareToDepartmentNumber(departmentList.get(i - 1)) < 0){
                  temDepartment = departmentList.get(i);
                  departmentList.set(i, departmentList.get(i - 1));
                  departmentList.set(i - 1, temDepartment);
                       
                  keepSorting = true;
               }
            }
         }
      }
   }
   
   //This method sorts all current teachers by their teacher numbers in ascending order.
   //The method will use the selection sort algorithm.
   //It takes in no parameters and returns no values.
   public void sortByTeacherNum(){
      Teacher temTeacher;
      int minTeacherNumIndex;
     
      for(int i = 0 ; i < teacherList.size() - 1; i ++){
         minTeacherNumIndex = i;
       
         for(int j = i + 1; j < teacherList.size(); j ++){
            if(teacherList.get(minTeacherNumIndex).compareToTeacherNum(teacherList.get(j)) > 0){
               minTeacherNumIndex = j;
            }
         }
         
         if (minTeacherNumIndex != i){
            temTeacher = teacherList.get(i);
            teacherList.set(i,teacherList.get(minTeacherNumIndex));
            teacherList.set(minTeacherNumIndex,temTeacher);
         }
      } 
   }
   
   //This method searches for the teacher with a specified name. 
   //The method will use the sequential search algorithm.
   //If such a teacher does not exist, the method will return null. 
   //It takes in a Name object as the parameter and returns a Teacher object.
   public Teacher searchTeacherName(Name name){  
      for(int i = 0;i < teacherList.size();i ++){
         if(teacherList.get(i).getName().equalsToName(name)){
            return teacherList.get(i);
         }
      }
      return null;  
   }
   
   //This method searches for the student with a specified name. 
   //The method will use the sequential search algorithm.
   //If such a student does not exist, the method will return null. 
   //It takes in a Name object as the parameter and returns a Student object.
   public Student searchStudentName(Name name){  
      for(int i = 0;i < studentList.size();i ++){
         if(studentList.get(i).getName().equalsToName(name)){
            return studentList.get(i);
         }
      }
      return null;  
   }
   
   //This method modifies the a student's current timetable based on the user's inputs.
   //This method includes both an add and delete option.
   //It prompts the user for a student name and completes the modification.
   //It takes in a Name object and returns no values.
   public void modifyTimeTable(Student student){
      Scanner sc = new Scanner (System.in);
      Course chosenCourse = null;
      String option = "";
      String courseCode;
      boolean validInput = false;
      
      while (!validInput){
         System.out.print("Enter \"add\" to add a course to the student's time table and enter \"delete\" to delete a course from the student's time table: ");
         option = sc.nextLine();
         option = option.toUpperCase();
         
         if (option.equals("ADD") || option.equals ("DELETE")){
            validInput = true;
         }
         else {
            System.out.println ("The option enetered is not valid. Please try again.");
         }
      }
      
      validInput = false;
      
      //This prompts for a course code and finds the corresponding course.
      while (!validInput){
         System.out.print ("Enter the course code of the course you want to add/delete: ");
         courseCode = sc.nextLine();
            
         chosenCourse = searchCourse(courseCode);
            
         if (chosenCourse != null){
            validInput = true;
         }
         else {
            System.out.println ("The course does not exist.");
            System.out.println ("Please try again.");
            System.out.println ();
         }
      }
       
      if (option.equals("ADD")){
         student.addChosenCourse(chosenCourse);
      }
      else {
         student.deleteChosenCourse(chosenCourse);
      }
   }
   
   //This is a method to print out all possible combinations of a student's current timetable.
   //It takes in no parameters and returns no values.
   public void printAllCombinations(){
      Scanner sc = new Scanner (System.in);
      Student selectedStudent = null;
      Name name;
      boolean validInput = false;
      
      while (!validInput){
         System.out.print ("Enter the student's name to print out all possible combinations of his/her time table (first last): ");
         name = new Name (sc.nextLine());
                  
         //This checks if the student exists in the database.
         selectedStudent = searchStudentName(name);
                  
         if (selectedStudent != null){
            validInput = true;
         }
         else {
            System.out.println ("The student does not exist.");
            System.out.println ("Please try again.");
            System.out.println();
         }
      }
      
      System.out.println();
      System.out.println("Here are the different combinations: ");
      selectedStudent.getSchedule().permuteCourses();
   }
   
   //This is a method that writes all current information in the database onto a file provided by the user.
   //It takes in a String as the parameter and returns no values.
   public void saveAllCurrentInfo(String fileName){
      try{
         BufferedWriter out = new BufferedWriter (new FileWriter (fileName + ".txt"));
         Department temDepartment;
         Course temCourse;
         Teacher temTeacher;
         Student temStudent;
         String temName;
         int teacherLen, courseLen, studentLen;
         ArrayList<Course> temCourseList = new ArrayList<Course> ();
         boolean last = false;
         
         out.write (departmentList.size() + "");
         out.newLine();
         out.newLine();
         
         //This writes all departments onto the file.
         for (int i = 0; i < departmentList.size(); i ++){
            temDepartment = departmentList.get(i);
            teacherLen = temDepartment.getTeacherList().size();
            courseLen = temDepartment.getCourseOffered().size();
            
            if (temDepartment instanceof Music){
               out.write ("Music");
            }
            else if (temDepartment instanceof Mathematics){
               out.write ("Mathematics");
            }
            else {
               out.write ("Computer Studies");
            }
            out.newLine();
            
            out.write(temDepartment.getDepartmentNum() + "");
            out.newLine();
            out.write(teacherLen + "");
            out.newLine();
            out.write(courseLen + "");
            out.newLine();
           
            out.newLine();
            //This writes all the teachers onto the file.
            for (int j = 0; j < teacherLen; j ++){
               temTeacher = temDepartment.getTeacherList().get(j);
               temName = temTeacher.getName().getFirst() + " " + temTeacher.getName().getLast();
               temCourseList = temTeacher.getCourseTaught();
               
               out.write(temName);
               out.newLine();
               out.write(temTeacher.getTeacherNum() + "");
               out.newLine();
               out.write(temTeacher.getExperience() + "");
               out.newLine();
               out.write(temCourseList.size() + "");
               out.newLine();
               
               for (int k = 0; k < temCourseList.size(); k ++){
                  out.write(temCourseList.get(k).getCourseCode());
                  out.newLine();
               }
               
               out.newLine();
            }
            
            //This writes all the courses onto the file.
            temCourseList = temDepartment.getCourseOffered();
            
            for (int j = 0; j < courseLen;j ++){
               temCourse = temCourseList.get(j);
               
               out.write(temCourse.getCourseCode());
               out.newLine();
               out.write(temCourse.getSize() + "");
               out.newLine();
               out.write(temCourse.getTeacher().getTeacherNum() + "");
               out.newLine();
               
               out.newLine();
            }
         }
         
         //This writes all the students onto the file.
         studentLen = studentList.size();
         
         out.write(studentLen + "");
         out.newLine();
         
         out.newLine();
         
         for (int i = 0; i < studentLen; i ++){
            temStudent = studentList.get(i);
            temName = temStudent.getName().getFirst() + " " + temStudent.getName().getLast();
            temCourseList = temStudent.getSchedule().getCourseChosen();
            courseLen = temCourseList.size();
            
            out.write(temName);
            out.newLine();
            out.write(temStudent.getStudentNum() + "");
            out.newLine();
            out.write(temCourseList.size() + "");
            out.newLine();
            
            for (int j = 0; j < courseLen; j ++){
               out.write(temCourseList.get(j).getCourseCode());
               out.newLine();
            }
            
            if (i != studentLen - 1){
               out.newLine();
            }
         }
         
         out.close();
         System.out.println ("The saving process is completed.");
      }
      catch (IOException iox){
         System.out.println ("The program encouters a problem.");
         System.out.println ("The saving process is not completed.");
      }
   }
}
