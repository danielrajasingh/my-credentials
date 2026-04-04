package chapter6.DependencyInversionPrinciple.src.main.java.coding.challenge.good;

public class ConnectToDatabase {

    public void connect(JdbcUrl jdbcUrl) {
        System.out.println("Connecting to " + jdbcUrl.get());
    }
}
