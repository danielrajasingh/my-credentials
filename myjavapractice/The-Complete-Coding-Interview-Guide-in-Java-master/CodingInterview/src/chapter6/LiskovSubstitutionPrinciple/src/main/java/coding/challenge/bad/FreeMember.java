package chapter6.LiskovSubstitutionPrinciple.src.main.java.coding.challenge.bad;

public class FreeMember extends Member {

    public FreeMember(String name) {
        super(name);
    }

    @Override
    public void joinTournament() {
        System.out.println("Classic member joins tournament ...");
    }

    // this method breaks Liskov’s Substitution Principle
    // since a free member cannot organize tournaments it cannot be
    // a substitute for the base class
    @Override
    public void organizeTournament() {
        System.out.println("A free member cannot organize tournaments");
    }
}
