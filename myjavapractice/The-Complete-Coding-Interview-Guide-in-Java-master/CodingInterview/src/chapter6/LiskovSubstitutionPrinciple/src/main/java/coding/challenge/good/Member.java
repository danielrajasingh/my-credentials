package chapter6.LiskovSubstitutionPrinciple.src.main.java.coding.challenge.good;

public abstract class Member implements TournamentJoiner, TournamentOrganizer {

    private final String name;

    public Member(String name) {
        this.name = name;
    }  
}
