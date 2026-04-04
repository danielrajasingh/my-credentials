package chapter6.LiskovSubstitutionPrinciple.src.main.java.coding.challenge;

import chapter6.LiskovSubstitutionPrinciple.src.main.java.coding.challenge.bad.Member;
import chapter6.LiskovSubstitutionPrinciple.src.main.java.coding.challenge.good.TournamentJoiner;
import chapter6.LiskovSubstitutionPrinciple.src.main.java.coding.challenge.good.TournamentOrganizer;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nApproach that doesn't follow LSP:\n");

        List<Member> members1 = List.of(
                new chapter6.LiskovSubstitutionPrinciple.src.main.java.coding.challenge.bad.PremiumMember("Jack Hores"),
                new chapter6.LiskovSubstitutionPrinciple.src.main.java.coding.challenge.bad.VipMember("Tom Johns"),
                new chapter6.LiskovSubstitutionPrinciple.src.main.java.coding.challenge.bad.FreeMember("Martin Vilop")
        );

        // this code respects LSP
        for (Member member : members1) {
            member.joinTournament();
        }
        
        System.out.println();
                
        // this code breaks LSP
        // a free member cannot organize tournaments
        for (Member member : members1) {
            member.organizeTournament();
        }
        
        System.out.println("\nApproach that follow LSP:\n");

        List<TournamentJoiner> members2 = List.of(
                new chapter6.LiskovSubstitutionPrinciple.src.main.java.coding.challenge.good.PremiumMember("Jack Hores"),
                new chapter6.LiskovSubstitutionPrinciple.src.main.java.coding.challenge.good.VipMember("Tom Johns"),
                new chapter6.LiskovSubstitutionPrinciple.src.main.java.coding.challenge.good.FreeMember("Martin Vilop")
        );               
        
        List<TournamentOrganizer> members3 = List.of(
                new chapter6.LiskovSubstitutionPrinciple.src.main.java.coding.challenge.good.PremiumMember("Jack Hores"),
                new chapter6.LiskovSubstitutionPrinciple.src.main.java.coding.challenge.good.VipMember("Tom Johns")
        );

        // this code respects LSP
        for (TournamentJoiner member : members2) {
            member.joinTournament();
        }               
        
        System.out.println();
        
        // this code respects LSP
        for (TournamentOrganizer member : members3) {
            member.organizeTournament();
        }
    }
}
