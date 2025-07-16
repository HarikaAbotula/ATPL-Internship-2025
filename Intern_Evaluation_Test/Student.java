public class Student {
    private String name;
    private int marks;
    private int id;

    Student(String name,int marks,int id){
        this.name=name;
        this.marks=marks;
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public int getMarks(){
        return marks;
    }

    public int getID(){
        return id;
    }

    public String toString(){
        return "Name: "+name+", Marks: "+marks+",ID: "+id;
    }
}

