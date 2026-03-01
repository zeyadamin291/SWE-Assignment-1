// Main.java
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static StudentManager manager = new StudentManager();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    manager.displayAllStudents();
                    break;
                case 5:
                    addGradeToStudent();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void printMenu() {
        System.out.println("\n===== Student Management System =====");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Search Student");
        System.out.println("4. Display All Students");
        System.out.println("5. Add Grade to Student");
        System.out.println("6. Exit");
        System.out.print("Choose option: ");
    }

    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        Student student = new Student(id, name, age);
        manager.addStudent(student);

        System.out.println("Student added successfully!");
    }

    public static void removeStudent() {
        System.out.print("Enter ID to remove: ");
        int id = scanner.nextInt();

        manager.removeStudent(id);
        System.out.println("Student removed (if existed).");
    }

    public static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = scanner.nextInt();

        Student student = manager.findStudent(id);

        if (student != null) {
            student.displayInfo();
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void addGradeToStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        Student student = manager.findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Grade: ");
        double grade = scanner.nextDouble();

        student.addGrade(grade);
        System.out.println("Grade added successfully!");
    }
}