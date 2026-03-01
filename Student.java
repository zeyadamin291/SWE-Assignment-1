// Student.java
import java.util.ArrayList;

public class Student extends Person {

    private int id;
    private ArrayList<Double> grades;

    public Student(int id, String name, int age) {
        super(name, age);
        this.id = id;
        this.grades = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) return 0;

        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return sum / grades.size();
    }

    public String getGradeLevel() {
        double avg = calculateAverage();

        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("ID: " + id);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + calculateAverage());
        System.out.println("Grade Level: " + getGradeLevel());
        System.out.println("---------------------------");
    }
}