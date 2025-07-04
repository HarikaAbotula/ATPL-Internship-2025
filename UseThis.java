//Use this to resolve naming conflicts between instance variables and parameters.
public class UseThis{
    String uName; //instance var
    int id;
    public UseThis(String userName,int id){ //parameters
        this.uName=userName; //this.uName refers to instance var and userName refers to parameter
        this.id=id;
    }
    public static void main(String args[]){
        UseThis obj=new UseThis("Harika",101);
        System.out.println(obj.uName+","+obj.id);
    }
}
