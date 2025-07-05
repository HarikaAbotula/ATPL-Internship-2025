//Create an abstract class Shape with method draw(). Use an anonymous class to provide its implementation and call draw()
abstract class Shape{
    public abstract void draw();
}
public class AnonymousShape {
    public static void main(String[] args) {
        Shape obj=new Shape() {
        public void draw(){
            System.out.println("Drawing the shape");
        }    
        };
        obj.draw();
    }
}
