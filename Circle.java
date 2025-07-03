class Circle {
    private double radius; 

   public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            System.out.println("Radius must be greater than zero");
        } else {
            this.radius = radius;
        }
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
     public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

     public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.setRadius(-5); 
        System.out.println("Radius: " + c1.getRadius());

        c1.setRadius(7); 
        System.out.println("Radius: " + c1.getRadius());
        System.out.println("Area: " + c1.calculateArea());
        System.out.println("Circumference: " + c1.calculateCircumference());
    }
   
}

