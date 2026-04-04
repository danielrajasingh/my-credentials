package chapter6.LiskovSubstitutionPrinciple.src.main.java.coding.challenge.bad;

public abstract class Member {

    private final String name;

    public Member(String name) {
        this.name = name;
    }

    public abstract void joinTournament();

    public abstract void organizeTournament();
}
