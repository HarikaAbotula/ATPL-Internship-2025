//Create a Student class with static variable schoolName. Change it via one object and access through others.

public class Student {
    private static String schoolName;

    public static String getSchoolName() {
        return schoolName;
    }

    public static void setSchoolName(String schoolName) {
        Student.schoolName = schoolName;
    }
    public static void main(String[] args) {
       
        Student stud1 = new Student();
        Student stud2 = new Student();
        stud1.setSchoolName("ABC High School");//setting schlname
        System.out.println("Student 1 School Name: " + stud2.getSchoolName());//accessing through other obj
        System.out.println("School Name using class name: " + Student.getSchoolName());
    }
}



