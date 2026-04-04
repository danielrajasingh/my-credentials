package chapter6.Polymorphism.CompileTime.src.main.java.coding.challenge;

public class Main {

    public static void main(String[] args) {

        Triangle triangle = new Triangle();
        
        triangle.draw();
        triangle.draw("red");
        triangle.draw(10, "blue");
    }

}
