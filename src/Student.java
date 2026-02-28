import java.util.HashMap;

public class Student extends Person {
    private String Student_ID, grade_level;
    private HashMap<String , Double> courses = new HashMap<String, Double>();
    private double GPA = 0 , remainingFees = 1500;

    public void setStudent_ID (String Student_ID){
        this.Student_ID = Student_ID;
    }
    public String getStudent_ID(){
        return Student_ID;
    }
    public void setGrade_level (String grade_level){
        this.grade_level = grade_level;
    }
    public String getGrade_level(){
        return grade_level;
    }
    public void setGPA (double GPA){
        this.GPA = GPA;
    }
    public double getGPA(){
        return GPA;
    }
    public void setCourse (String course){
        courses.put(course, GPA);
    }
    public void setCourse(String course, double gpa){
        courses.put(course, gpa);
    }
    public double getCourse_GPA(String course){
        return courses.get(course);
    }

    public double getFees() {
        return remainingFees;
    }
    public void Pay(double money){
        this.remainingFees -= money;
    }
    public void CalcGPA(String name){
        double numerator = 0;
        for(double gpa : courses.values()){
            numerator += gpa * 3;
        }
        this.GPA = numerator / courses.size()*3;
    }
    public boolean isValid_Grade (String grade){
        grade = grade.toLowerCase();
        return (grade.equals("freshman")|| grade.equals("sophomore") || grade.equals("junior") || grade.equals("senior"));
    }
}
