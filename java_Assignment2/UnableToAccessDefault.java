package p2;
import p1.*;
public class UnableToAccessDefualt {
   int i=5;
   void display(){
    System.out.println(i);
   }
   public static void main(String args[]){
       DefaultAccessModifier obj=new DefaultAccessModifier();
       obj.display();
   }
}