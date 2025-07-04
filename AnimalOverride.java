//Create a base class Animal with makeSound() method. Override it in Dog, Cat, and Cow.
public class AnimalOverride{
    public static void main(String args[]){
        Animal obj1 = new Animal();
        Animal obj2 = new Dog();
        Animal obj3 = new Cat();
        Animal obj4 = new Cow();
         obj1.makeSound();
         obj2.makeSound();
         obj3.makeSound();
         obj4.makeSound();
    }
}
class Animal{
    public void makeSound(){
        System.out.println("Animal sound");
    }
}
class Dog extends Animal{
    public void makeSound(){
        System.out.println("Dog:bow bow");
    }
}
class Cat extends Animal{
    public void makeSound(){
        System.out.println("Cat:meow meow");
    }
}
class Cow extends Animal{
    public void makeSound(){
        System.out.println("Cow sound");
    }
}