import java.util.HashMap;
import java.util.Scanner;

/**
 * The `manager` class manages students and teachers in a school/college system.
 * It uses HashMaps to store Student and Teacher objects, with names as keys.
 */

public class manager  {
    private HashMap<String, Student> Student = new HashMap<String , Student>();
    private HashMap<String , Teacher> Teacher = new HashMap<String , Teacher>();

    /**
     * Adds a new student to the system.
     * Prompts the user for student details (name, ID, national ID, phone, email, grade level, address).
     * Validates all inputs before adding the student to the HashMap.
     */

    public void add_new_student (){

        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        String name , ID , national_ID , address , phone , email , gradelevel ;

        System.out.println("Enter Student name (must be quadruple name): ");
        name = sc.nextLine();
        while(!student.isValid_name(name)){
            System.out.println("Enter valid student name: ");
            name = sc.nextLine();
        }
        student.setName(name);

        System.out.println("Enter Student ID: ");
        ID = sc.nextLine();
        student.setStudent_ID(ID);

        System.out.println("Enter Student National_ID (must be 14 digits): ");
        national_ID = sc.nextLine();
        while (!student.isValid_National_ID(national_ID)){
            System.out.println("Enter valid student National_ID: ");
            national_ID = sc.nextLine();
        }
        student.setNational_ID(national_ID);

        System.out.println("Enter Student Phone Number (must be 11 digits starting with \"011 , 010 , 012 , 015\"): ");
        phone = sc.nextLine();
        while (!student.isValid_phone(phone)){
            System.out.println("Enter valid student Phone: ");
            phone = sc.nextLine();
        }

        student.setPhone_number(phone);
        System.out.println("Enter Student Email: ");
        email = sc.nextLine();
        while (!student.isValid_email(email)){
            System.out.println("Enter valid student Email: ");
            email = sc.nextLine();
        }
        student.setPersonal_email(email);

        System.out.println("Enter Student Grade Level (Freshman or Sophomore or Junior or Senior): ");
        gradelevel = sc.nextLine();
        while(!student.isValid_Grade(gradelevel)){
            System.out.println("Enter valid grade level: ");
            gradelevel = sc.nextLine();
        }

        student.setGrade_level(gradelevel);

        System.out.println("Enter Student Address: ");
        address = sc.nextLine();
        student.setAddress(address);
        Student.put(student.getName(), student);
    }

    /**
     * Adds a new teacher to the system.
     * Prompts the user for teacher details (name, national ID, phone, email, subject, address).
     * Validates all inputs before adding the teacher to the HashMap.
     */

    public void add_new_teacher (){
        Scanner sc = new Scanner(System.in);
        Teacher teacher = new Teacher();
        String national_ID, name, Phone_number, Personal_email , address , subject;
        System.out.println("Enter Teacher name (must be quadruple name): ");
        name = sc.nextLine();
        while(!teacher.isValid_name(name)){
            System.out.println("Enter valid teacher name: ");
            name = sc.nextLine();
        }
        teacher.setName(name);
        System.out.println("Enter Teacher national ID (must be 14 digits): ");
        national_ID = sc.nextLine();
        while (!teacher.isValid_National_ID(national_ID)){
            System.out.println("Enter valid teacher National_ID: ");
            national_ID = sc.nextLine();
        }
        teacher.setNational_ID(national_ID);
        System.out.println("Enter Teacher Phone Number (must be 11 digits): ");
        Phone_number = sc.nextLine();
        while (teacher.isValid_phone(Phone_number)){
            System.out.println("Enter valid teacher Phone Number: ");
            Phone_number = sc.nextLine();
        }
        teacher.setPhone_number(Phone_number);

        System.out.println("Enter Teacher Email: ");
        Personal_email = sc.nextLine();
        while (!teacher.isValid_email(Personal_email)){
            System.out.println("Enter valid teacher Email: ");
            Personal_email = sc.nextLine();
        }
        teacher.setPersonal_email(Personal_email);

        System.out.println("Enter Teacher Subject: ");
        subject = sc.nextLine();
        teacher.setSubject(subject);

        System.out.println("Enter Teacher Address: ");
        address = sc.nextLine();
        teacher.setAddress(address);
        Teacher.put(teacher.getName(), teacher);
    }

    /**
     * Retrieves the total GPA of a specific student.
     *
     * @param name The name of the student whose GPA is to be retrieved.
     * @return The GPA of the student as a double.
     */

    public double get_total_GPA(String name){
        return Student.get(name).getGPA();
    }

    /**
     * Retrieves the GPA of a specific course for a given student.
     *
     * @param name   The name of the student.
     * @param course The course for which the GPA is to be retrieved.
     * @return The GPA of the specified course as a double.
     */

    public double get_sub_GPA(String name , String course){
        return Student.get(name).getCourse_GPA(course);
    }

    /**
     * Displays details of all students stored in the system.
     * Iterates through the `Student` HashMap and prints each student's information.
     */

    public void view_all_Students(){
        for(Student student : Student.values()){
            System.out.println('\n'+"+=====================================+"+'\n');
            System.out.println("Student's Name: "+student.getName());
            System.out.println("Student's National ID: "+ student.getNational_ID());
            System.out.println("Student ID: "+student.getStudent_ID());
            System.out.println("Student's GPA: "+student.getGPA());
            System.out.println("Student's Phone number" + student.getPhone_number());
            System.out.println("Grade level: " + student.getGrade_level());
            System.out.println("Personal Email: " + student.getPersonal_email());
            System.out.println("Address: " + student.getAddress());
            System.out.println('\n'+"+=====================================+"+'\n');
        }
    }

    /**
     * Displays details of all teachers stored in the system.
     * Iterates through the `Teacher` HashMap and prints each teacher's information in a formatted way.
     */
    public void view_all_Teacher() {
        for (Teacher teacher : Teacher.values()) {
            System.out.println('\n' + "+=====================================+" + '\n');
            System.out.println("Teacher's Name: " + teacher.getName());
            System.out.println("Teacher's National ID: " + teacher.getNational_ID());
            System.out.println("Teacher's Phone Number: " + teacher.getPhone_number());
            System.out.println("Personal Email: " + teacher.getPersonal_email());
            System.out.println("Subject: " + teacher.getSubject());
            System.out.println("Address: " + teacher.getAddress());
            System.out.println('\n' + "+=====================================+" + '\n');
        }
    }
    public void updateTeacherDetails(String name) {
        Scanner sc = new Scanner(System.in);
        if (Teacher.containsKey(name)) {
            Teacher teacher = Teacher.get(name); // Get the student object

            // Update Student
            add_new_teacher();

            System.out.println("Teacher details updated successfully!");
        } else {
            System.out.println("Teacher not found!");
        }
    }

    public void remove_Student(String name){
        Student.remove(name);
    }
    public void remove_Teacher(String name){
        Teacher.remove(name);
    }
    /**
     * Updates all details of a specific student.
     * Prompts the user to enter new values for each attribute and updates the student's record.
     *
     * @param name The name of the student to update.
     */
    public void updateStudentDetails(String name) {
        Scanner sc = new Scanner(System.in);
        if (Student.containsKey(name)) {
            Student student = Student.get(name); // Get the student object

            // Update Student
            add_new_student();

            System.out.println("Student details updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
    public void updateStudentName(String name, String new_name) {
        if (Student.containsKey(name)) {
            Student student = Student.remove(name); // Remove old key
            student.setName(new_name);
            Student.put(new_name, student); // Insert with the new key
        } else {
            System.out.println("Student not found!");
        }
    }

    public void updateTeacherName(String name, String new_name) {
        if (Teacher.containsKey(name)) {
            Teacher teacher = Teacher.remove(name); // Remove old key
            teacher.setName(new_name);
            Teacher.put(new_name, teacher); // Insert with the new key
        } else {
            System.out.println("Teacher not found!");
        }
    }
    public void updateGradeLevel(String name, String new_level) {
        Student.get(name).setGrade_level(new_level);
    }
    public Student getStudent(String name) {
        return Student.get(name);
    }
    public Teacher getTeacher(String name) {
        return Teacher.get(name);
    }
    /**
     * Updates only the subject of a specific teacher.
     *
     * @param subject The new subject of the teacher.
     * @param name    The name of the teacher to update.
     */
    public void updateTeacherSubject(String subject, String name) {
        if (Teacher.containsKey(name)) {
            Teacher teacher = Teacher.get(name);

            // Update the subject
            teacher.setSubject(subject);

            System.out.println("Teacher subject updated successfully!");
        } else {
            System.out.println("Teacher not found!");
        }
    }
    public void run (){
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        Student student = new Student();
        Teacher teacher = new Teacher();
        manager manager = new manager();

        int choice;
        do {
            menu.Menu1(); // Display the main menu
            choice = menu.getChoice(); // Get the user's choice

            // Validate the choice
            while (!menu.isValidChoice1(choice)) {
                System.out.println("Please enter a valid choice (1-14): ");
                choice = menu.getChoice();
            }

            // Handle the user's choice
            if (choice == 1) {
                // Add New Student
                manager.add_new_student(); // Call the method to add a new student
            } else if (choice == 2) {
                // View All Students
                manager.view_all_Students(); // Call the method to view all students
            } else if (choice == 3) {
                // Get Student GPA
                System.out.print("Enter student name: ");
                String studentName = sc.nextLine();
                System.out.println("GPA: " + manager.get_total_GPA(studentName)); // Call the method to get student GPA

            } else if (choice == 4) {
                // Get Student Course GPA
                System.out.print("Enter student name: ");
                String studentName = sc.nextLine();
                System.out.print("Enter course name: ");
                String course = sc.nextLine();
                System.out.println("Course GPA: " + manager.get_sub_GPA(studentName, course)); // Call the method to get course GPA

            } else if (choice == 5) {
                // Update Student Details
                menu.Menu2(); // Display the update student details menu
                int updateChoice = menu.getChoice();
                while (!menu.isValidChoice23(updateChoice)) {
                    System.out.println("Please enter a valid choice (1-3): ");
                    updateChoice = menu.getChoice();
                }
                // Handle update student details based on updateChoice
                switch (updateChoice) {
                    case 1:
                        // Update all student details
                        System.out.print("Enter Student name: ");
                        String studnetName = sc.nextLine();
                        manager.updateStudentDetails(studnetName);
                        break;
                    case 2:
                        // Update student name
                        System.out.println("Enter Student name that you want to update: ");
                        String Name = sc.nextLine();
                        System.out.println("Enter Student new name: ");
                        String newName = sc.nextLine();
                        manager.updateStudentName(newName, Name);
                        break;
                    case 3:
                        // Update student grade
                        System.out.println("Enter Student's name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter student new grade level: ");
                        String grade = sc.nextLine();
                        manager.updateGradeLevel(grade, name);
                        break;
                }
            } else if (choice == 6) {
                // Remove Student
                System.out.print("Enter student name to remove: ");
                String studentName = sc.nextLine();
                manager.remove_Student(studentName);
            } else if (choice == 7) {
                // Add New Teacher
                manager.add_new_teacher(); // Call the method to add a new teacher
            } else if (choice == 8) {
                // View All Teachers
                manager.view_all_Teacher(); // Call the method to view all teachers
            } else if (choice == 9) {
                // Update Teacher Details
                menu.Menu3(); // Display the update teacher details menu
                int updateChoice = menu.getChoice();
                while (!menu.isValidChoice23(updateChoice)) {
                    System.out.println("Please enter a valid choice (1-3): ");
                    updateChoice = menu.getChoice();
                }
                // Handle update teacher details based on updateChoice
                switch (updateChoice) {
                    case 1:
                        // Update all teacher details
                        System.out.print("Enter Teacher name: ");
                        String teacherName = sc.nextLine();
                        manager.updateTeacherDetails(teacherName);
                        break;
                    case 2:
                        // Update teacher name
                        System.out.println("Enter Teacher name that you want to update: ");
                        String oldName = sc.nextLine();
                        System.out.println("Enter Teacher new name: ");
                        String newName = sc.nextLine();
                        manager.updateTeacherName(newName, oldName);
                        break;
                    case 3:
                        // Update teacher subject
                        System.out.println("Enter Teacher's name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter Teacher new subject: ");
                        String subject = sc.nextLine();
                        manager.updateTeacherSubject(subject, name);
                        break;
                }
            } else if (choice == 10) {
                // Remove Teacher
                System.out.print("Enter teacher name to remove: ");
                String teacherName = sc.nextLine();
                manager.remove_Teacher(teacherName);
            } else if (choice == 11) {
                System.out.println("Enter student name to get GPA: ");
                String studentName = sc.nextLine();
                System.out.print(studentName + "'s GPA: ");
                manager.get_total_GPA(studentName);
            } else if (choice == 12) {
                System.out.print("Enter student name: ");
                String name = sc.nextLine();
                System.out.println("Enter Student GPA: ");
                double gpa = sc.nextDouble();
                manager.getStudent(name).setGPA(gpa);
            } else if (choice == 13) {
                System.out.print("Enter student name: ");
                String name = sc.nextLine();
                System.out.println("Enter Course name: ");
                String Cname = sc.nextLine();
                System.out.println("Enter Course GPA: ");
                double gpa = sc.nextDouble();
                manager.getStudent(name).setCourse(Cname,gpa);
            } else if (choice == 14) {
                // View All Teachers
                manager.view_all_Teacher(); // Call the method to view all teachers
            }
            else if(choice == 15){
                // Exit
                System.out.println("Exiting...");
            }
            else {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 15); // Continue until the user chooses to exit
    }
}