package chapter6.MethodHiding.src.main.java.coding.challenge;

public class Main {

    public static void main(String[] args) {

        Vehicle.move(); // call Vehicle#move()
        Car.move();     // call Car#move()
    }
}
