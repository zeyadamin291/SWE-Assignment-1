import java.util.Scanner;
/**
 * The `Menu` class provides a user interface for the School Management System.
 * It displays menus for various operations and handles user input.
 */

public class Menu {
    /**
     * Displays the main menu of the School Management System.
     * The menu includes options for managing students, teachers, and system operations.
     */
    public void Menu1() {
        System.out.println("===== School Management System =====");
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. Get Student GPA");
        System.out.println("4. Get Student Course GPA");
        System.out.println("5. Update Student Details");
        System.out.println("6. Remove Student");
        System.out.println("7. Add New Teacher");
        System.out.println("8. View All Teachers");
        System.out.println("9. Update Teacher Details");
        System.out.println("10. Remove Teacher");
        System.out.println("11. Get Total GPA of All Students");
        System.out.println("12. Set Student total GPA");
        System.out.println("13. Set Student's Course GPA");
        System.out.println("14. View All teachers");
        System.out.println("15. Exit");
        System.out.println("===================================");
        System.out.print("Enter your choice: ");
    }

    /**
     * Displays the menu for updating student details.
     * Prompts the user to enter the student's full name and choose an update option.
     */

    public void Menu2() {
        System.out.println("===== Update Student Details =====");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student full name: ");
        String name = sc.nextLine();

        System.out.println("1. Update all student's details");
        System.out.println("2. Update student name");
        System.out.println("3. Update student grade");
    }

    /**
     * Displays the menu for updating teacher details.
     * Prompts the user to enter the teacher's full name and choose an update option.
     */

    public void Menu3() {
        System.out.println("===== Update Teacher Details =====");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Teacher full name: ");
        String name = sc.nextLine();
        System.out.println("1. Update all teacher's details");
        System.out.println("2. Update teacher name");
        System.out.println("3. Update teacher subject");
    }

    /**
     * Reads and returns the user's choice from the menu.
     *
     * @return The user's choice as an integer.
     */

    public int getChoice() {
        Scanner sc = new Scanner(System.in);
        int choice;
        choice = sc.nextInt();
        return choice;
    }

    /**
     * Validates the user's choice for the main menu.
     *
     * @param choice The user's choice.
     * @return `true` if the choice is between 1 and 15, otherwise `false`.
     */

    public boolean isValidChoice1(int choice) {
        return choice >= 1 && choice <= 15;
    }

    /**
     * Validates the user's choice for the update menus (Menu2 and Menu3).
     *
     * @param choice The user's choice.
     * @return `true` if the choice is between 1 and 3, otherwise `false`.
     */

    public boolean isValidChoice23(int choice) {
        return choice >= 1 && choice <= 3;
    }

}
