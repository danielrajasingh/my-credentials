package chapter6.InterfaceSegregationPrinciple.src.main.java.coding.challenge;


public class Main {

    public static void main(String[] args) {

        System.out.println("\nApproach that doesn't follow ISP:\n");

        chapter6.InterfaceSegregationPrinciple.src.main.java.coding.challenge.bad.WwwPingConnection www1
                = new chapter6.InterfaceSegregationPrinciple.src.main.java.coding.challenge.bad.WwwPingConnection("www.yahoo.com");
        
        www1.http();
        www1.socket(); // this method doesn't do anything, but the client doesn't know that
        www1.connect();

        System.out.println("\nApproach that follow ISP:\n");

        chapter6.InterfaceSegregationPrinciple.src.main.java.coding.challenge.good.WwwPingConnection www2
                = new chapter6.InterfaceSegregationPrinciple.src.main.java.coding.challenge.good.WwwPingConnection("www.yahoo.com");
        
        www2.http();
        www2.connect();
    }
}
