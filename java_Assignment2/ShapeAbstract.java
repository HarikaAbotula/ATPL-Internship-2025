    abstract class Shape {
        public abstract double area();
    }
     class Square extends Shape {
        private double side;

         Square(double side) {
            this.side = side;
        }
         public double area() {
            return side * side;
        }
    }
     class Triangle extends Shape {
        private double breadth;
        private double length;

         Triangle(double breadth,double length) {
            this.breadth = breadth;
            this.length=length;
        }
         public double area() {
            return 0.5 * breadth * length;
        }
    }
    public class ShapeAbstract {
        public static void main(String[] args) {
            Shape square = new Square(5.0);
            Shape triangle = new Triangle(4.0, 6.0);

            System.out.println("Area of Square: " + square.area());
            System.out.println("Area of Triangle: " + triangle.area());
        }
    }
