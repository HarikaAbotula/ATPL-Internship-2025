import java.util.*;

public class StudentGrades {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John",88,101));
        students.add(new Student("Ron",97,103));
        students.add(new Student("Nancy",86,102));
        students.add(new Student("Steve",78,104));

        students.sort(new Comparator<Student>() {
            public int compare(Student s1,Student s2){
                return Integer.compare(s1.getMarks(),s2.getMarks());
            }
        });
        for(Student s: students){
                System.out.println(s);
        }
    }
}

